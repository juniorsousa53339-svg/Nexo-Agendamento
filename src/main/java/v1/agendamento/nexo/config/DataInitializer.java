package v1.agendamento.nexo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import v1.agendamento.nexo.model.Appointment;
import v1.agendamento.nexo.model.ClinicService;
import v1.agendamento.nexo.model.Patient;
import v1.agendamento.nexo.model.enums.AppointmentStatus;
import v1.agendamento.nexo.repository.AppointmentRepository;
import v1.agendamento.nexo.repository.ClinicServiceRepository;
import v1.agendamento.nexo.repository.PatientRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private ClinicServiceRepository clinicServiceRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public void run(String... args) throws Exception {
        if (clinicServiceRepository.count() == 0) {
            // 1. Cadastrar Serviços
            ClinicService s1 = new ClinicService(null, "Avaliação Inicial", "Avaliação postural, anamnese completa e testes ortopédicos para identificação de desalinhamentos.", 60, new BigDecimal("150.00"));
            ClinicService s2 = new ClinicService(null, "Consulta de Quiropraxia", "Ajuste articular e técnicas de manipulação para alívio de dores na coluna e extremidades.", 60, new BigDecimal("200.00"));
            ClinicService s3 = new ClinicService(null, "Alívio de Dores Agudas", "Atendimento focado em analgesia imediata e liberação miofascial para crises agudas.", 60, new BigDecimal("220.00"));
            ClinicService s4 = new ClinicService(null, "Avaliação de Mobilidade", "Análise biomecânica detalhada de amplitude de movimento e padrões de movimento.", 60, new BigDecimal("180.00"));
            ClinicService s5 = new ClinicService(null, "Sessão de Acompanhamento", "Reavaliação periódica e manutenção preventiva do alinhamento corporal.", 60, new BigDecimal("160.00"));
            ClinicService s6 = new ClinicService(null, "Orientação Postural", "Educação ergonômica para o trabalho e cinesioterapia preventiva.", 60, new BigDecimal("140.00"));

            clinicServiceRepository.save(s1);
            clinicServiceRepository.save(s2);
            clinicServiceRepository.save(s3);
            clinicServiceRepository.save(s4);
            clinicServiceRepository.save(s5);
            clinicServiceRepository.save(s6);

            // 2. Cadastrar Pacientes Fictícios
            Patient p1 = new Patient(null, "Carlos Silva", "(11) 98765-4321", "carlos.silva@email.com", LocalDateTime.now().minusDays(10));
            Patient p2 = new Patient(null, "Ana Oliveira", "(11) 99123-4567", "ana.oliveira@email.com", LocalDateTime.now().minusDays(5));
            Patient p3 = new Patient(null, "Roberto Mendes", "(11) 97788-9900", "roberto.mendes@email.com", LocalDateTime.now().minusDays(2));
            Patient p4 = new Patient(null, "Mariana Costa", "(11) 98877-6655", "mariana.costa@email.com", LocalDateTime.now().minusDays(1));

            patientRepository.save(p1);
            patientRepository.save(p2);
            patientRepository.save(p3);
            patientRepository.save(p4);

            // 3. Cadastrar Agendamentos (Hoje e Futuros)
            LocalDate hoje = LocalDate.now();
            LocalDate amanha = hoje.plusDays(1);
            LocalDate depoisAmanha = hoje.plusDays(2);

            // Se hoje for fim de semana, ajustar para o próximo dia útil para teste do DataLoader
            if (hoje.getDayOfWeek().getValue() > 5) {
                hoje = hoje.plusDays(2); // Vai para segunda-feira
                amanha = hoje.plusDays(1);
                depoisAmanha = hoje.plusDays(2);
            }

            Appointment a1 = new Appointment(null, p1, s2, hoje, LocalTime.of(9, 0), AppointmentStatus.CONFIRMADO, true, false, "Sentindo dores lombares ao sentar.", LocalDateTime.now());
            Appointment a2 = new Appointment(null, p2, s1, hoje, LocalTime.of(10, 30), AppointmentStatus.AGENDADO, true, true, "Crise aguda de cervicalgia.", LocalDateTime.now());
            Appointment a3 = new Appointment(null, p3, s5, hoje, LocalTime.of(14, 0), AppointmentStatus.CONCLUIDO, false, false, "Retorno de manutenção mensal.", LocalDateTime.now());
            Appointment a4 = new Appointment(null, p4, s3, amanha, LocalTime.of(11, 0), AppointmentStatus.AGENDADO, true, false, "Primeira consulta de avaliação.", LocalDateTime.now());
            Appointment a5 = new Appointment(null, p1, s4, depoisAmanha, LocalTime.of(15, 0), AppointmentStatus.AGENDADO, false, false, "Teste de mobilidade esportiva.", LocalDateTime.now());

            appointmentRepository.save(a1);
            appointmentRepository.save(a2);
            appointmentRepository.save(a3);
            appointmentRepository.save(a4);
            appointmentRepository.save(a5);
        }
    }
}
