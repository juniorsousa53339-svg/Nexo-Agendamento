package v1.agendamento.nexo.model.enums;

public enum AppointmentStatus {
    AGENDADO("Agendado"),
    CONFIRMADO("Confirmado"),
    CONCLUIDO("Concluído"),
    CANCELADO("Cancelado");

    private final String descricao;

    AppointmentStatus(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getDescription() {
        return descricao;
    }
}
