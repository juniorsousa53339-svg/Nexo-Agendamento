package v1.agendamento.nexo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v1.agendamento.nexo.dto.AppointmentFormDTO;
import v1.agendamento.nexo.exception.BusinessException;
import v1.agendamento.nexo.model.Appointment;
import v1.agendamento.nexo.model.ClinicService;
import v1.agendamento.nexo.model.Patient;
import v1.agendamento.nexo.model.enums.AppointmentStatus;
import v1.agendamento.nexo.repository.AppointmentRepository;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;
    private final ClinicServiceService clinicServiceService;

    @Transactional
    public Appointment createAppointment(AppointmentFormDTO dto) {
        // Validação de dia útil (Segunda a Sexta)
        DayOfWeek dayOfWeek = dto.getAppointmentDate().getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            throw new BusinessException("A clínica não realiza atendimentos aos sábados e domingos.");
        }

        // Validação de horário de expediente (08:00 às 18:00)
        LocalTime time = dto.getAppointmentTime();
        LocalTime opening = LocalTime.of(8, 0);
        LocalTime closing = LocalTime.of(18, 0);
        if (time.isBefore(opening) || time.isAfter(closing)) {
            throw new BusinessException("O horário de atendimento é das 08:00 às 18:00.");
        }

        // Validação de conflito de horário
        List<Appointment> conflicts = appointmentRepository.findActiveAppointmentsAtTime(dto.getAppointmentDate(), dto.getAppointmentTime());
        if (!conflicts.isEmpty()) {
            throw new BusinessException("Já existe um atendimento agendado para este dia e horário. Por favor, escolha outro horário.");
        }

        // Buscar ou criar paciente
        Patient patient = patientService.saveOrUpdatePatient(dto.getPatientName(), dto.getPhone(), dto.getEmail());

        // Buscar serviço
        ClinicService clinicService = clinicServiceService.findById(dto.getServiceId());

        // Montar entidade de agendamento
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setService(clinicService);
        appointment.setAppointmentDate(dto.getAppointmentDate());
        appointment.setAppointmentTime(dto.getAppointmentTime());
        appointment.setStatus(AppointmentStatus.AGENDADO);
        appointment.setIsFirstVisit(dto.getIsFirstVisit() != null ? dto.getIsFirstVisit() : false);
        appointment.setIsUrgent(dto.getIsUrgent() != null ? dto.getIsUrgent() : false);
        appointment.setObservations(dto.getObservations());
        appointment.setCreatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public List<Appointment> findAppointmentsByDate(LocalDate date) {
        return appointmentRepository.findByAppointmentDateOrderByAppointmentTimeAsc(date);
    }

    public List<Appointment> findUpcomingAppointments() {
        return appointmentRepository.findByAppointmentDateGreaterThanEqualOrderByAppointmentDateAscAppointmentTimeAsc(LocalDate.now());
    }

    public Appointment findById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Agendamento não encontrado."));
    }

    @Transactional
    public void updateStatus(Long id, AppointmentStatus status) {
        Appointment appointment = findById(id);
        appointment.setStatus(status);
        appointmentRepository.save(appointment);
    }

    public long countAppointmentsToday() {
        return appointmentRepository.countByAppointmentDate(LocalDate.now());
    }

    public long countCompletedAppointments() {
        return appointmentRepository.countByStatus(AppointmentStatus.CONCLUIDO);
    }

    public long countPendingAppointments() {
        return appointmentRepository.countByStatus(AppointmentStatus.AGENDADO);
    }
}
