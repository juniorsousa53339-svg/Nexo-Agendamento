package v1.agendamento.nexo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import v1.agendamento.nexo.model.ClinicService;

@Repository
public interface ClinicServiceRepository extends JpaRepository<ClinicService, Long> {
}
