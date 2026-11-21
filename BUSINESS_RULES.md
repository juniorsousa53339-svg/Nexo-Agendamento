# BUSINESS_RULES.md — Regras de Negócio e Validações

## 1. Visão Geral
Este documento define o conjunto de regras de negócio, restrições operacionais e validações que devem ser rigorosamente aplicadas no back-end (e auxiliadas no front-end) da aplicação **NEXO**.

---

## 2. Regras de Agendamento
1. **Unicidade de Horário (Anti-Conflito):**
   * Não é permitido realizar dois agendamentos para o mesmo horário/data, visto que Brian Sousa é o único profissional atendendo.
2. **Expediente e Dias de Atendimento:**
   * **Dias úteis:** Segunda-feira a Sexta-feira. Sábados e domingos a clínica não realiza atendimentos regulares (**DECISÃO PENDENTE** sobre plantões eventuais).
   * **Horário de funcionamento:** Das 08:00 às 18:00.
   * **Duração padrão da consulta:** 60 minutos por slot de atendimento (ex: 08:00, 09:00, 10:00, ..., 17:00).
3. **Restrição de Datas Passadas:**
   * O sistema deve rejeitar imediatamente qualquer tentativa de agendamento em datas ou horários retroativos (anteriores ao momento atual).
4. **Disponibilidade Dinâmica:**
   * O sistema deve calcular e exibir apenas os horários livres do dia selecionado, ocultando ou desabilitando horários já ocupados.

---

## 3. Validações de Formulário (Bean Validation & Service Layer)
* **Nome Completo (`patientName`):** Obrigatório, tamanho mínimo de 3 caracteres, sem caracteres especiais inválidos.
* **Telefone (`phone`):** Obrigatório, formato válido (ex: com DDD, aceitando padrões brasileiros de WhatsApp/Celular).
* **E-mail (`email`):** Opcional ou recomendado, validado com formato de e-mail padrão.
* **Serviço (`serviceName`):** Obrigatório, selecionado a partir da lista pré-definida de serviços da clínica.
* **Data do Agendamento (`appointmentDate`):** Obrigatória, deve ser uma data futura ou igual a hoje (desde que o horário ainda não tenha passado).
* **Horário (`appointmentTime`):** Obrigatório, deve estar dentro do intervalo comercial (08:00 - 18:00) e alinhar-se aos slots de atendimento.

---

## 4. Status do Agendamento (`AppointmentStatus`)
O ciclo de vida de um agendamento é representado pelos seguintes status:
1. **AGENDADO:** Criado recentemente pelo paciente através da página pública, aguardando confirmação ou atendimento.
2. **CONFIRMADO:** Validado pelo profissional (Brian Sousa) no dashboard.
3. **CONCLUIDO:** Atendimento realizado com sucesso.
4. **CANCELADO:** Agendamento cancelado pelo paciente ou pela clínica.

---

## 5. Regras do Dashboard Administrativo
1. **Visão Geral em Tempo Real:** Os indicadores (KPIs) de agendamentos de hoje, total de pacientes e atendimentos concluídos devem ser calculados dinamicamente a partir do banco de dados.
2. **Filtros:** O proprietário deve poder filtrar a agenda por data específica e por status do agendamento.
3. **Atualização de Status:** O proprietário pode alterar o status de um agendamento diretamente pela interface do dashboard.
