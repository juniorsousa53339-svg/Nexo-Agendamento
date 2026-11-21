package v1.agendamento.nexo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v1.agendamento.nexo.model.Patient;
import v1.agendamento.nexo.repository.PatientRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient saveOrUpdatePatient(String name, String phone, String email) {
        Optional<Patient> existing = patientRepository.findByPhone(phone);
        if (existing.isPresent()) {
            Patient patient = existing.get();
            patient.setName(name);
            if (email != null && !email.isBlank()) {
                patient.setEmail(email);
            }
            return patientRepository.save(patient);
        } else {
            Patient newPatient = new Patient();
            newPatient.setName(name);
            newPatient.setPhone(phone);
            newPatient.setEmail(email);
            newPatient.setCreatedAt(LocalDateTime.now());
            return patientRepository.save(newPatient);
        }
    }

    public long countTotalPatients() {
        return patientRepository.count();
    }
}
