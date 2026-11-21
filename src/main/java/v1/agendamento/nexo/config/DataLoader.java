package v1.agendamento.nexo.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            ClinicServiceRepository serviceRepository,
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository) {
        return args -> {
            if (serviceRepository.count() == 0) {
                log.info("Populando serviços de quiropraxia...");

                ClinicService s1 = new ClinicService(null, "Avaliação Inicial & Diagnóstico", "Avaliação biomecânica completa, testes posturais e anamnese detalhada.", 60, new BigDecimal("250.00"), "https://images.pexels.com/photos/5793654/pexels-photo-5793654.jpeg");
                ClinicService s2 = new ClinicService(null, "Consulta de Quiropraxia (Manutenção)", "Sessão de ajustes articulares, liberação miofascial e restauração da mobilidade.", 45, new BigDecimal("200.00"), "https://images.pexels.com/photos/5793949/pexels-photo-5793949.jpeg");
                ClinicService s3 = new ClinicService(null, "Alívio de Dores Agudas", "Atendimento focado no alívio imediato de cervicalgias, lombalgias e travamentos.", 50, new BigDecimal("220.00"), "https://images.pexels.com/photos/5793794/pexels-photo-5793794.jpeg");
                ClinicService s4 = new ClinicService(null, "Avaliação de Mobilidade & Postura", "Análise avançada de desalinhamentos posturais e padrões de movimento.", 60, new BigDecimal("250.00"), "https://images.pexels.com/photos/5793895/pexels-photo-5793895.jpeg");
                ClinicService s5 = new ClinicService(null, "Orientação Postural & Ergonomia", "Sessão educativa e prática para correção de postura no trabalho e dia a dia.", 45, new BigDecimal("180.00"), "https://images.pexels.com/photos/5793683/pexels-photo-5793683.jpeg");

                serviceRepository.saveAll(List.of(s1, s2, s3, s4, s5));

                log.info("Serviços populados com sucesso!");
            }

            if (patientRepository.count() == 0 && appointmentRepository.count() == 0) {
                log.info("Populando pacientes e agendamentos iniciais...");

                Patient p1 = new Patient(null, "Carlos Eduardo Silva", "(11) 98765-4321", "carlos.silva@email.com", LocalDateTime.now().minusDays(5));
                Patient p2 = new Patient(null, "Mariana Souza Lima", "(11) 97123-4567", "mariana.lima@email.com", LocalDateTime.now().minusDays(4));
                Patient p3 = new Patient(null, "Roberto Alcantara", "(11) 99888-7766", "roberto@email.com", LocalDateTime.now().minusDays(3));
                Patient p4 = new Patient(null, "Juliana Mendes", "(11) 91234-5678", "juliana@email.com", LocalDateTime.now().minusDays(2));

                patientRepository.saveAll(List.of(p1, p2, p3, p4));

                List<ClinicService> services = serviceRepository.findAll();
                LocalDate today = LocalDate.now();

                // Garante que não caia em fim de semana para o DataLoader de hoje
                LocalDate sampleDate = today;
                if (sampleDate.getDayOfWeek().getValue() > 5) {
                    sampleDate = today.plusDays(2); // Vai para segunda-feira
                }

                Appointment a1 = new Appointment(null, p1, services.get(0), sampleDate, LocalTime.of(9, 0), AppointmentStatus.CONFIRMADO, true, false, "Relata dores lombares ao trabalhar sentada.", LocalDateTime.now());
                Appointment a2 = new Appointment(null, p2, services.get(1), sampleDate, LocalTime.of(10, 30), AppointmentStatus.CONFIRMADO, false, false, "Manutenção mensal de rotina.", LocalDateTime.now());
                Appointment a3 = new Appointment(null, p3, services.get(2), sampleDate, LocalTime.of(14, 0), AppointmentStatus.AGENDADO, false, true, "Torcicolo agudo após treino.", LocalDateTime.now());
                Appointment a4 = new Appointment(null, p4, services.get(3), sampleDate.plusDays(1), LocalTime.of(11, 0), AppointmentStatus.AGENDADO, true, false, "Primeira consulta para avaliação postural.", LocalDateTime.now());

                appointmentRepository.saveAll(List.of(a1, a2, a3, a4));

                log.info("Banco de dados populado com sucesso com dados de exemplo!");
            }
        };
    }
}
