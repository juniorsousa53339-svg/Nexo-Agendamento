# Documentação Técnica e Visual — NEXO Quiropraxia

---

## 1. Introdução ao Projeto
O **NEXO Quiropraxia** é uma plataforma web integrada de gestão e agendamento voltada para clínicas de quiropraxia. Desenvolvida para operar com alta performance e usabilidade, a aplicação combina uma interface pública moderna e responsiva (com suporte a modo escuro/claro e animações fluidas) com um painel administrativo completo para controle operacional de agendas, pacientes e procedimentos.

---

## 2. Problema que o Projeto Busca Solucionar
Clínicas de saúde de médio porte frequentemente enfrentam dificuldades operacionais como:
- Desorganização na marcação de horários de atendimento.
- Falta de visibilidade rápida sobre a agenda diária e status de pacientes (urgências, primeira consulta, atendimentos concluídos).
- Dificuldade na gestão centralizada de serviços clínicos, valores e durações.
- Experiência do paciente pouco interativa ou ausência de canais digitais ágeis para agendamento.

---

## 3. Objetivo geral
Fornecer um sistema web robusto, seguro e intuitivo que automatize o fluxo de agendamento de consultas quiropráticas e ofereça ao profissional responsável (Dr. Bryan Sousa) ferramentas gerenciais avançadas em tempo real.

---

## 4. Objetivos Específicos
- Disponibilizar um site institucional atrativo com biografia do especialista, apresentação de tratamentos e mapa de localização em Alphaville, Barueri - SP.
- Implementar um formulário de agendamento online com validações robustas e tratamento de restrições de horário.
- Criar um painel administrativo exclusivo para acompanhamento de KPIs diários e alteração dinâmica de status de consultas.
- Permitir a gestão completa (CRUD) de serviços clínicos com suporte a imagens customizadas.
- Garantir persistência confiável em banco de dados relacional com inicialização automática de dados de exemplo (`DataLoader` / `DataInitializer`).

---

## 5. Público-alvo
- **Pacientes**: Pessoas buscando alívio de dores crônicas/agudas, correção postural e bem-estar corporal.
- **Profissionais da Saúde (Quiropraxistas)**: Especialistas que precisam gerenciar sua agenda diária e histórico de pacientes.
- **Administradores de Clínicas**: Gestores focados em controle de procedimentos e métricas de atendimento.

---

## 6. Funcionalidades
- **Agendamento Online**: Seleção de serviço, data, horário (08h às 18h), indicação de primeira vez ou urgência/dor aguda.
- **Painel Administrativo (`/admin`)**:
  - Filtro de agendamentos por data.
  - Cartões de KPI (Agendamentos hoje, total de pacientes, concluídos, pendentes).
  - Atualização de status de consultas (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).
  - Gestão de Serviços (Adicionar, atualizar preço/duração/descrição/imagem, excluir).
- **Interface Dinâmica**: Alternância de tema (Dark/Light mode), animações de digitação (*Typewriter*), efeitos de elevação em cards (`hover-lift`) e galeria visual de tratamentos com imagens do Pexels.

---

## 7. Tecnologias Utilizadas
- **Linguagem**: Java 17
- **Framework Principal**: Spring Boot 4.x / 3.x (Spring Web, Spring Data JPA, Thymeleaf)
- **Banco de Dados**: H2 Database (In-memory com console web habilitada)
- **Frontend**: HTML5, Thymeleaf, Tailwind CSS (via CDN), JavaScript Vanilla
- **Gerenciador de Dependências**: Apache Maven / Maven Wrapper (`mvnw`)
- **Utilitários**: Lombok para redução de boilerplate

---

## 8. Arquitetura do Sistema

A arquitetura segue o padrão **MVC (Model-View-Controller)** em camadas sobre a plataforma Spring Boot.

```text
+-------------------------------------------------------------------------+
|                              CLIENTE (Browser)                          |
|         [ Site Público (home.html) ]  &  [ Painel Admin (dashboard) ]   |
+-------------------------------------------------------------------------+
                                     |  HTTP Requests (GET / POST)
                                     v
+-------------------------------------------------------------------------+
|                      SPRING WEB CONTROLLERS                             |
|          [ HomeController ]              [ AdminController ]            |
+-------------------------------------------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                        SERVICES LAYER (Regras)                          |
|  [ AppointmentService ]  [ PatientService ]  [ ClinicServiceService ]   |
+-------------------------------------------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                   SPRING DATA JPA REPOSITORIES                          |
|   [ AppointmentRepository ] [ PatientRepository ] [ ServiceRepository ] |
+-------------------------------------------------------------------------+
                                     |
                                     v
+-------------------------------------------------------------------------+
|                     H2 IN-MEMORY DATABASE                               |
|               (Tabelas: patients, clinic_services, appointments)        |
+-------------------------------------------------------------------------+
```

---

## 9. Estrutura do Projeto

```text
nexo/
├── pom.xml
├── mvnw / mvnw.cmd
└── src/
    ├── main/
    │   ├── java/v1/agendamento/nexo/
    │   │   ├── NexoApplication.java
    │   │   ├── config/
    │   │   │   ├── DataLoader.java
    │   │   │   └── DataInitializer.java
    │   │   ├── controller/
    │   │   │   ├── HomeController.java
    │   │   │   └── AdminController.java
    │   │   ├── dto/
    │   │   │   └── AppointmentFormDTO.java
    │   │   ├── entity/model/
    │   │   │   ├── Patient.java
    │   │   │   ├── ClinicService.java
    │   │   │   ├── Appointment.java
    │   │   │   └── enums/AppointmentStatus.java
    │   │   ├── exception/
    │   │   │   ├── BusinessException.java
    │   │   │   └── GlobalExceptionHandler.java
    │   │   └── service/
    │   │       ├── PatientService.java
    │   │       ├── ClinicServiceService.java
    │   │       └── AppointmentService.java
    │   └── resources/
    │       ├── application.properties
    │       ├── static/
    │       │   └── images/
    │       │       └── doctor.png
    │       └── templates/
    │           ├── index.html
    │           ├── home.html
    │           └── admin/
    │               └── dashboard.html
    └── test/java/v1/agendamento/nexo/
        └── NexoApplicationTests.java
```

---

## 10. Funcionamento do Frontend
O frontend é renderizado no servidor utilizando **Thymeleaf**, integrado com **Tailwind CSS** para estilização responsiva.
- **Home (`home.html`)**: Apresenta a seção Hero com o Dr. Bryan Sousa, filosofia da clínica, galeria de serviços com imagens customizadas, mapa de localização e formulário de agendamento.
- **Dashboard (`dashboard.html`)**: Painel administrativo protegido logicamente por rota, contendo blocos de KPI, tabela interativa de agenda diária com alteração de status via formulários em linha, e cards para gerenciamento de serviços e inserção de novas imagens.

---

## 11. Funcionamento do Backend
O backend em **Spring Boot** gerencia o ciclo de vida HTTP, validações de formulário com Bean Validation (`@Valid`), tratamento centralizado de exceções (`GlobalExceptionHandler`), e persistência transacional via Spring Data JPA.

---

## 12. Comunicação entre Frontend e Backend

```text
[ Usuário Preenche Agendamento ]
               |
               | HTTP POST /appointments (Form Data)
               v
[ HomeController.createAppointment() ]
               |
               | Validação de dados (AppointmentFormDTO)
               v
[ AppointmentService.createAppointment() ]
               |
               | Localiza ou Cria Patient (por telefone único)
               | Associa ClinicService
               | Salva Appointment no H2
               v
[ Redirecionamento com Flash Attributes ] -> redirect:/#agendar (Sucesso / Erro)
```

---

## 13. Banco de Dados
Utiliza o banco de dados em memória **H2** (`jdbc:h2:mem:nexodb`).
- A console H2 está habilitada em `/h2-console`.
- A inicialização automática de dados de teste e serviços padrão é realizada pelas classes `DataLoader` e `DataInitializer`.

---

## 14. Modelagem das Entidades

```text
+-------------------+       1:N       +---------------------+
|     Patient       |---------------->|     Appointment     |
+-------------------+                 +---------------------+
| id (PK)           |                 | id (PK)             |
| name              |                 | appointmentDate     |
| phone (Unique)    |                 | appointmentTime     |
| email             |                 | status (Enum)       |
| createdAt         |                 | isFirstVisit        |
+-------------------+                 | isUrgent            |
                                      | observations        |
                                      +---------------------+
+-------------------+                            | N:1
|   ClinicService   |----------------------------+
+-------------------+
| id (PK)           |
| name              |
| description       |
| durationMinutes   |
| price (BigDecimal)|
| imageUrl          |
+-------------------+
```

---

## 15. Regras de Negócio
1. **Identificação Única de Paciente**: Um paciente é identificado pelo número de telefone. Se o telefone já existir na base, o agendamento é vinculado ao paciente existente; caso contrário, um novo cadastro é criado automaticamente.
2. **Horário de Atendimento**: Consultas são restritas a dias úteis (Segunda a Sexta) e horário comercial (08:00 às 18:00).
3. **Status de Agendamento**: Toda nova consulta inicia com o status `AGENDADO` ou `CONFIRMADO`, podendo evoluir para `CONCLUIDO` ou `CANCELADO` pelo painel administrativo.
4. **Integridade de Serviços**: Serviços possuem duração em minutos, preço monetário e URL de imagem opcional/padronizada via Pexels ou Unsplash.

---

## 16. Endpoints e APIs

| Método | Endpoint | Descrição |
| :--- | :--- | :--- |
| `GET` | `/` | Página inicial pública (Home) |
| `POST` | `/appointments` | Processa e salva um novo agendamento |
| `GET` | `/admin` | Exibe o painel administrativo (com filtro opcional por `date`) |
| `POST` | `/admin/appointments/{id}/status` | Atualiza o status de um agendamento |
| `POST` | `/admin/services` | Cadastra um novo serviço clínico |
| `POST` | `/admin/services/{id}` | Atualiza um serviço clínico existente |
| `POST` | `/admin/services/{id}/delete` | Remove um serviço clínico |

---

## 17. Fluxos Principais do Sistema

### Fluxo de Agendamento pelo Paciente:
```text
Acessa Site -> Preenche Dados (Nome, Telefone, Serviço, Data, Hora) -> Envia Formulário -> Sistema Valida -> Salva no Banco -> Retorna Mensagem de Sucesso na Home.
```

### Fluxo de Gestão Administrativa:
```text
Acessa /admin -> Visualiza KPIs do Dia -> Filtra por Data -> Altera Status de Atendimento (ex: de Agendado para Concluído) -> Salva -> Tabela Atualiza em Tempo Real.
```

---

## 18. Segurança
- O painel administrativo (`/admin`) é voltado para demonstração acadêmica e gestão interna.
- Validação de entrada de dados contra injeção via parâmetros tipados e DTOs do Spring.
- Tratamento global de exceções para evitar vazamento de stack traces para o usuário final.

---

## 19. Testes Realizados e Existentes
- **Testes de Contexto e Inicialização (`NexoApplicationTests`)**:
  - Verifica o carregamento correto do contexto da aplicação Spring Boot (`@SpringBootTest`).
  - Executado e validado com sucesso (`BUILD SUCCESS`).

---

## 20. Conclusão Técnica
O **NEXO Quiropraxia** atende plenamente aos requisitos de um sistema moderno de agendamento e gestão clínica. Sua arquitetura desacoplada em camadas, uso eficiente de Spring Boot com Thymeleaf e H2, e interface altamente polida com Tailwind CSS proporcionam uma experiência excelente tanto para os pacientes quanto para o profissional administrador.
