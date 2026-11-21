package v1.agendamento.nexo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "clinic_services")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClinicService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do serviço é obrigatório")
    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "A duração é obrigatória")
    @Column(nullable = false)
    private Integer durationMinutes = 60; // Padrão de 60 minutos

    @Column(precision = 10, scale = 2)
    private BigDecimal price;
}
