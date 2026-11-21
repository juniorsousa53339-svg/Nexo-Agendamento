# DATABASE_DESIGN.md — Modelagem de Dados e DataLoader

## 1. Visão Geral
A modelagem de dados do projeto **NEXO** foi projetada para ser simples, enxuta e totalmente aderente ao escopo acadêmico, utilizando o **H2 Database** em memória com persistência gerenciada pelo Spring Data JPA / Hibernate.

---

## 2. Entidade Principal: `Appointment` (Agendamento)
A entidade `Appointment` armazena todas as informações referentes a uma consulta agendada na clínica.

### Campos da Entidade:
* `id` (`Long`, Primary Key, Auto Increment)
* `patientName` (`String`, Not Null) — Nome completo do paciente.
* `phone` (`String`, Not Null) — Telefone de contato / WhatsApp.
* `email` (`String`, Nullable) — E-mail de contato do paciente.
* `serviceName` (`String`, Not Null) — Nome do serviço de quiropraxia escolhido.
* `appointmentDate` (`LocalDate`, Not Null) — Data do agendamento.
* `appointmentTime` (`LocalTime`, Not Null) — Horário da consulta.
* `status` (`AppointmentStatus`, Enum, Not Null) — Status atual (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).
* `isFirstVisit` (`Boolean`, Not Null) — Indica se é a primeira consulta do paciente.
* `isUrgent` (`Boolean`, Not Null) — Indica se o atendimento possui caráter de urgência/dor aguda.
* `observations` (`String`, ColumnDefinition = "TEXT", Nullable) — Observações adicionais do paciente.
* `createdAt` (`LocalDateTime`, Not Null) — Data e hora em que o registro foi criado no sistema.

---

## 3. Enumerações (`Enums`)

### `AppointmentStatus`
* `AGENDADO` ("Agendado")
* `CONFIRMADO` ("Confirmado")
* `CONCLUIDO` ("Concluído")
* `CANCELADO` ("Cancelado")

---

## 4. Estratégia do DataLoader
Para garantir que o Dashboard Administrativo do proprietário (Bryan Sousa) nasça preenchido e visualmente rico desde a primeira execução, será implementado um componente `DataLoader` utilizando a interface `CommandLineRunner`:

* **Comportamento:** Executado automaticamente na inicialização da aplicação Spring Boot.
* **Verificação:** Verifica se o repositório já possui registros; caso esteja vazio, insere massa de dados fictícia e realista.
* **Massa de Dados Fictícia:**
  * Agendamentos para a **data de hoje** (com horários variados e status `CONFIRMADO` / `AGENDADO`).
  * Agendamentos **futuros** (para testar a agenda da semana).
  * Agendamentos **concluídos** e **cancelados** (para preencher os indicadores estatísticos do dashboard).
* **Serviços simulados no DataLoader:**
  * "Avaliação Inicial"
  * "Consulta de Quiropraxia"
  * "Atendimento para Dores Musculares"
  * "Avaliação de Mobilidade"
  * "Orientação Postural"
