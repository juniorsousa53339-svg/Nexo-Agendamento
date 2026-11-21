# IMPLEMENTATION_PLAN.md — Plano de Implementação (Roadmap)

## 1. Visão Geral do Roadmap
O desenvolvimento do projeto **NEXO** será dividido em etapas sequenciais e controladas, garantindo entregas incrementais e testáveis.

---

## 2. Fases de Desenvolvimento

### Fase 1: Arquitetura e Documentação (Fase Atual)
* [x] Análise da estrutura do projeto e dependências (Java 17, Spring Boot).
* [x] Criação dos arquivos de contexto centrais (`PROJECT_CONTEXT.md`, `ARCHITECTURE.md`, `BUSINESS_RULES.md`, `UI_UX_GUIDELINES.md`, `AI_AGENTS.md`, `IMPLEMENTATION_PLAN.md`, `DATABASE_DESIGN.md`).
* [ ] Revisão dos documentos pelo usuário (Brian Sousa / Professor orientador).

### Fase 2: Configuração e Camada de Domínio (Back-End Base)
* [ ] Configuração do banco H2 e propriedades em `application.properties`.
* [ ] Criação do Enum `AppointmentStatus` e `ServiceType`.
* [ ] Criação da entidade JPA `Appointment`.
* [ ] Criação da interface `AppointmentRepository`.

### Fase 3: Regras de Negócio e Serviços
* [ ] Implementação do `AppointmentService` com validações de conflito de horário, datas passadas e expediente.
* [ ] Implementação do `DataLoader` (`CommandLineRunner`) para popular o banco H2 com agendamentos fictícios variados.

### Fase 4: Front-End (Thymeleaf & UI/UX)
* [ ] Configuração do layout base com Thymeleaf e Tailwind CSS.
* [ ] Desenvolvimento da Página 1 — Home & Agendamento (Hero, Sobre, Serviços, Localização, Formulário de Agendamento).
* [ ] Implementação da Página 2 — Dashboard Administrativo (KPIs, Agenda do Dia, Próximos Atendimentos, Filtros).

### Fase 5: Controllers e Integração
* [ ] Implementação do `HomeController` (exibição da página pública e processamento do formulário de agendamento).
* [ ] Implementação do `AdminController` (exibição do dashboard e gestão de status).
* [ ] Testes manuais e validação do fluxo completo ponta a ponta.

### Fase 6: Testes e Refinamentos Finais
* [ ] Testes unitários de serviços e repositórios.
* [ ] Ajustes de responsividade e polimento visual.
* [ ] Preparação para entrega acadêmica.
