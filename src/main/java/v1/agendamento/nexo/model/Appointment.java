package v1.agendamento.nexo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import v1.agendamento.nexo.model.enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O paciente é obrigatório")
    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @NotNull(message = "O serviço é obrigatório")
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ClinicService service;

    @NotNull(message = "A data do agendamento é obrigatória")
    @Column(nullable = false)
    private LocalDate appointmentDate;

    @NotNull(message = "O horário do agendamento é obrigatório")
    @Column(nullable = false)
    private LocalTime appointmentTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AppointmentStatus status = AppointmentStatus.AGENDADO;

    @Column(nullable = false)
    private Boolean isFirstVisit = false;

    @Column(nullable = false)
    private Boolean isUrgent = false;

    @Column(columnDefinition = "TEXT")
    private String observations;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
