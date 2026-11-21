package v1.agendamento.nexo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v1.agendamento.nexo.exception.BusinessException;
import v1.agendamento.nexo.model.ClinicService;
import v1.agendamento.nexo.repository.ClinicServiceRepository;
import v1.agendamento.nexo.repository.AppointmentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicServiceService {

    private final ClinicServiceRepository clinicServiceRepository;
    private final AppointmentRepository appointmentRepository;

    public List<ClinicService> findAllServices() {
        return clinicServiceRepository.findAll();
    }

    public ClinicService findById(Long id) {
        return clinicServiceRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Serviço selecionado não foi encontrado."));
    }

    @Transactional
    public ClinicService saveService(ClinicService service) {
        return clinicServiceRepository.save(service);
    }

    @Transactional
    public void deleteService(Long id) {
        ClinicService service = findById(id);
        if (appointmentRepository.existsByServiceId(id)) {
            throw new BusinessException("Não é possível excluir este serviço pois existem agendamentos vinculados a ele.");
        }
        clinicServiceRepository.delete(service);
    }
}
