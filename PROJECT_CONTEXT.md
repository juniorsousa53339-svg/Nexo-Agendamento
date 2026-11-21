# PROJECT_CONTEXT.md — Projeto NEXO

## 1. Visão Geral do Projeto
**NEXO** é uma aplicação web desenvolvida como trabalho acadêmico de **Projeto Integrador (PI)**, concebida para operar como o sistema digital de gestão e agendamento de uma clínica de quiropraxia de alto padrão. Localizada ficticiamente em **Alphaville, São Paulo**, a clínica tem como proprietário e único profissional responsável pelos atendimentos **Brian Sousa**.

Apesar do contexto acadêmico, a diretriz principal é entregar uma aplicação com padrão de mercado (SaaS moderno), apresentando arquitetura limpa, código manutenível e uma experiência de usuário (UX/UI) sofisticada, tecnológica e minimalista.

---

## 2. Objetivos Principais
1. **Apresentação Institucional:** Exibir a proposta da clínica, sua filosofia de saúde e bem-estar, e a biografia profissional de Brian Sousa.
2. **Catálogo de Serviços:** Listar os tratamentos e avaliações de quiropraxia oferecidos, detalhando escopo, duração e indicações.
3. **Agendamento Online Intuitivo:** Permitir que pacientes realizem agendamentos de forma simples, com validações em tempo real de disponibilidade.
4. **Gestão de Conflitos e Regras de Negócio:** Garantir integridade na agenda, impedindo choques de horários, agendamentos fora do expediente ou em datas passadas.
5. **Dashboard Administrativo:** Disponibilizar uma visão gerencial para o proprietário (Brian Sousa) com indicadores de atendimento, agenda diária, próximos horários e filtros por status/data.
6. **Populamento Automático (DataLoader):** Inicializar o banco de dados H2 com dados fictícios realistas para demonstração imediata do dashboard e fluxo de agendamentos.

---

## 3. Pilha Tecnológica (Tech Stack)
* **Back-End:**
  * **Linguagem:** Java 17
  * **Framework:** Spring Boot 4.2.0 (Spring Web, Spring Data JPA, Hibernate, Bean Validation)
  * **Utilitários:** Lombok
* **Front-End:**
  * **Template Engine:** Thymeleaf
  * **Estilização & Interatividade:** HTML5, CSS3 (ou Tailwind CSS via CDN para agilidade e visual moderno), JavaScript Vanilla.
* **Banco de Dados:**
  * **Embutido:** H2 Database (modo in-memory com console habilitado para inspeção).
* **Gerenciamento de Dependências e Build:**
  * **Maven** (`mvnw` / `pom.xml`)

---

## 4. Escopo Funcional (MVP)
### Página 1: Home e Agendamento (Pública)
* **Header:** Logotipo NEXO, navegação por âncoras (Início, Sobre, Serviços, Localização), botão de ação "Agendar Consulta", seletor de Tema (Dark/Light mode).
* **Hero Section:** Título de impacto, proposta de valor sobre movimento e alinhamento corporal, CTA principal.
* **Sobre a Clínica:** Apresentação do espaço e conceito de saúde corporal em Alphaville.
* **Sobre o Profissional:** Apresentação de Brian Sousa, seu foco em mobilidade e atendimento personalizado.
* **Serviços:** Cards interativos detalhando serviços (Avaliação Inicial, Consulta de Quiropraxia, Alívio de Dores, Avaliação de Mobilidade, Sessão de Acompanhamento, Orientação Postural).
* **Localização:** Endereço fictício em Alphaville/SP e horários de atendimento.
* **Formulário de Agendamento:** Coleta de dados do paciente, seleção de serviço, escolha de data e horário disponível, marcação de primeira consulta/urgência e observações. Validações e feedback de sucesso.

### Página 2: Dashboard Administrativo (Restrito / Acadêmico)
* **Header Admin:** Boas-vindas personalizada ("Bem-vindo de volta, Brian").
* **Indicadores (KPIs):** Cards com agendamentos de hoje, próximos atendimentos, total de pacientes, concluídos e pendentes.
* **Agenda do Diária:** Tabela/lista detalhada dos atendimentos do dia (horário, paciente, telefone, serviço, status).
* **Próximos Agendamentos:** Visão estendida da agenda futura.
* **Filtros e Gestão de Status:** Capacidade de filtrar por data/status e alterar status dos agendamentos (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).

---

## 5. Regras de Negócio Essenciais
1. **Conflito de Horários:** Proibido dois agendamentos no mesmo horário/profissional.
2. **Expediente da Clínica:** Agendamentos restritos aos dias úteis e horários de expediente definidos (ex: Segunda a Sexta, das 08:00 às 18:00, consultas de 45 ou 60 minutos).
3. **Validação Temporal:** Bloqueio estrito de datas passadas e horários já ocupados ou expirados.
4. **Validação de Dados:** Obrigatoriedade de preenchimento correto de nome, telefone de contato e serviço.

---

## 6. Restrições do Projeto
* **Sem Frameworks SPA:** Não utilizar React, Angular ou Vue. Todo o front-end é servido via Spring Boot com Thymeleaf.
* **Sem Autenticação Complexa (Neste Momento):** O dashboard administrativo é acessível diretamente para fins acadêmicos e de demonstração, sem Spring Security complexo no MVP (**DECISÃO PENDENTE** para fases futuras).
* **Banco de Dados H2:** Persistência em memória com carga via `CommandLineRunner` / `DataLoader`.

---

## 7. Decisões Pendentes
* *D-01 (Autenticação Admin):* No MVP atual, o dashboard não exigirá login. Sugestão: Adicionar autenticação básica HTTP ou Spring Security InMemory nas próximas evoluções do projeto.
* *D-02 (Definição exata de horários de atendimento):* Sugestão: Segunda a Sexta das 08:00 às 18:00, com slots de 1 hora.
