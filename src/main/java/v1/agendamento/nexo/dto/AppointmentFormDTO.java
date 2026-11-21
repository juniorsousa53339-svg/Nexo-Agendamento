package v1.agendamento.nexo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentFormDTO {

    @NotBlank(message = "O nome completo é obrigatório")
    private String patientName;

    @NotBlank(message = "O telefone de contato é obrigatório")
    private String phone;

    @Email(message = "Informe um e-mail válido")
    private String email;

    @NotNull(message = "Selecione um serviço")
    private Long serviceId;

    @NotNull(message = "A data da consulta é obrigatória")
    @FutureOrPresent(message = "A data da consulta não pode ser no passado")
    private LocalDate appointmentDate;

    @NotNull(message = "O horário da consulta é obrigatório")
    private LocalTime appointmentTime;

    private Boolean isFirstVisit = false;

    private Boolean isUrgent = false;

    private String observations;
}
