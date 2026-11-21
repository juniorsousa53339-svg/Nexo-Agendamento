# ARCHITECTURE.md — Arquitetura do Projeto NEXO

## 1. Visão Geral da Arquitetura
O projeto **NEXO** adota uma **Arquitetura em Camadas (Layered Architecture)** tradicional e robusta baseada no ecossistema Spring Boot, garantindo alta coesão, baixo acoplamento e separação clara de responsabilidades entre apresentação, regra de negócio, persistência e domínio.

---

## 2. Estrutura de Pacotes Proposta
A organização de pacotes segue o padrão Spring Boot abaixo do pacote raiz `v1.agendamento.nexo`:

```text
v1.agendamento.nexo/
├── NexoApplication.java
├── config/                  # Configurações globais (DataLoader, beans, WebConfig)
├── controller/              # Controladores MVC (Web Controllers e REST Controllers auxiliares)
├── dto/                     # Objetos de Transferência de Dados (Formulários e Respostas)
├── model/                   # Entidades JPA e Enums
│   ├── entity/              # Appointment, ClientService, etc.
│   └── enums/               # AppointmentStatus, ServiceType, etc.
├── repository/              # Repositórios Spring Data JPA
├── service/                 # Regras de negócio e lógica de aplicação
└── exception/               # Tratamento global de exceções e erros de negócio
```

---

## 3. Responsabilidades das Camadas

### A) Controller (`v1.agendamento.nexo.controller`)
* **Responsabilidade:** Receber requisições HTTP do cliente (navegador), validar entradas via Bean Validation, invocar os serviços apropriados e retornar templates Thymeleaf (`ModelAndView` / `String`) ou dados JSON (se houver endpoints AJAX/API para consulta de horários).
* **Componentes principais:**
  * `HomeController`: Gerencia a página principal (Home, Sobre, Serviços, Localização) e submissão do formulário de agendamento.
  * `AdminController`: Gerencia o dashboard do proprietário (Bryan Sousa), listagem de agendamentos, indicadores e alteração de status.
  * `AvailabilityController` (Opcional/API): Endpoint REST auxiliar para consulta dinâmica de horários livres por data.

### B) Service (`v1.agendamento.nexo.service`)
* **Responsabilidade:** Concentrar todas as regras de negócio, validações de disponibilidade, regras de agendamento e transacionalidade (`@Transactional`).
* **Componentes principais:**
  * `AppointmentService`: Regras de criação, listagem, cancelamento e verificação de conflitos de horário.
  * `AvailabilityService`: Lógica de cálculo de slots de atendimento disponíveis com base no expediente e agendamentos existentes.

### C) Repository (`v1.agendamento.nexo.repository`)
* **Responsabilidade:** Comunicação com o banco de dados H2 através do Spring Data JPA.
* **Componentes principais:**
  * `AppointmentRepository`: Interface estendendo `JpaRepository<Appointment, Long>`, contendo consultas customizadas (ex: buscar por data, verificar conflitos de horário).

### D) Model / Entities (`v1.agendamento.nexo.model`)
* **Responsabilidade:** Representação do modelo de domínio mapeado para o banco de dados relacional e enumerações de status/tipos.
* **Componentes principais:**
  * `Appointment`: Entidade principal de agendamento.
  * `AppointmentStatus`: Enum (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).

### E) DTO (`v1.agendamento.nexo.dto`)
* **Responsabilidade:** Transportar dados entre a camada de visualização (Thymeleaf / Forms) e a camada de serviço, isolando as entidades de domínio e aplicando anotações de validação (`@NotNull`, `@NotBlank`, `@Future`, etc.).

### F) Config (`v1.agendamento.nexo.config`)
* **Responsabilidade:** Configurações de inicialização do sistema, como o `DataLoader` (`CommandLineRunner`) responsável por popular o banco H2 com dados fictícios na inicialização.

---

## 4. Fluxo de Dados (Data Flow)
1. **Requisição do Cliente:** O usuário acessa a Home ou submete o formulário de agendamento via navegador.
2. **Controller:** O `HomeController` intercepta a requisição, recebe os dados encapsulados em um DTO e valida as anotações do Bean Validation.
3. **Service:** O controller delega a operação para o `AppointmentService`. O serviço consulta o `AppointmentRepository` para verificar disponibilidade e regras de negócio.
4. **Persistência:** Se válido, o repositório persiste o agendamento no banco H2.
5. **Resposta:** O serviço retorna o resultado para o controller, que redireciona para a página de sucesso ou renderiza o template Thymeleaf com os dados atualizados.

---

## 5. Estratégia de Persistência (H2 Database)
* **Banco:** H2 em memória (`jdbc:h2:mem:nexodb`).
* **Console H2:** Habilitado para facilitar a inspeção e auditoria durante o desenvolvimento acadêmico (`/h2-console`).
* **DDL Auto:** Configurado como `update` ou `create-drop` para recriar o schema e popular via `DataLoader` a cada inicialização.
