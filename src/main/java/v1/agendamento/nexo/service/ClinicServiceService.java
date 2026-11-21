package v1.agendamento.nexo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import v1.agendamento.nexo.exception.BusinessException;
import v1.agendamento.nexo.model.ClinicService;
import v1.agendamento.nexo.repository.ClinicServiceRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClinicServiceService {

    private final ClinicServiceRepository clinicServiceRepository;

    public List<ClinicService> findAllServices() {
        return clinicServiceRepository.findAll();
    }

    public ClinicService findById(Long id) {
        return clinicServiceRepository.findById(id)
                .orElseThrow(() -> new BusinessException("Serviço selecionado não foi encontrado."));
    }
}
