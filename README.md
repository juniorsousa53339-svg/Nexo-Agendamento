# 🌐 NEXO — Sistema de Gestão e Agendamento para Clínica de Quiropraxia

<p align="center">
  <b>Sistema web moderno de agendamento e gerenciamento desenvolvido como Projeto Integrador acadêmico utilizando uma abordagem avançada de AI-Assisted Software Development.</b>
</p>

---

## 📋 Sobre o Projeto

O **NEXO** é uma aplicação web desenvolvida para operar como o sistema digital de gestão e agendamento de uma clínica de quiropraxia de alto padrão localizada em **Alphaville, São Paulo**, tendo como profissional responsável **Bryan Sousa**.

Apesar de seu contexto acadêmico (Projeto Integrador), o sistema foi concebido com padrões de mercado (SaaS moderno), oferecendo arquitetura limpa, código manutenível, validações robustas de regras de negócio e uma experiência de usuário (UX/UI) sofisticada, tecnológica e minimalista.

O grande diferencial deste projeto reside na sua **metodologia de desenvolvimento**: a aplicação foi construída integralmente sob a direção técnica e o gerenciamento de **Luciano Júnior e Cláudio**, utilizando **Inteligência Artificial (IA)** como motor de aceleração, suporte técnico e geração de código, operando sob rigorosos princípios de **Context Engineering**, **Prompt Engineering** e **Orquestração de Agentes**.

---

## 🚀 AI-Assisted Development & Engineering Practices

Para demonstrar a competência prática em engenharia de software moderna com IA, o desenvolvimento do NEXO não utilizou prompts aleatórios ou cópias cegas. O projeto foi estruturado aplicando práticas profissionais de mercado:

### 1. AI-Assisted Software Development (Desenvolvimento Assistido por IA)
* **Aplicação:** A Inteligência Artificial foi integrada em todas as fases do ciclo de vida do software (SDLC) — desde o planejamento inicial até a implementação, estruturação de dados, desenvolvimento front-end, testes e documentação.
* **Papel Humano (Tech Lead / Product Owner):** Condução estratégica, definição de requisitos, especificação de regras de negócio, tomada de decisões arquiteturais, revisão rigorosa de código, testes funcionais e validação das entregas.
* **Papel dos Agentes de IA:** Aceleração na escrita de código boilerplate (Spring Boot, entidades JPA, repositórios, serviços, controllers, DTOs e tratamento de exceções) e suporte à estruturação de templates Thymeleaf com Tailwind CSS.

### 2. Context Engineering (Engenharia de Contexto)
Para evitar alucinações e desalinhamentos dos agentes de IA, foi estabelecida uma base de conhecimento estruturada na raiz do repositório através de arquivos de contexto dedicados:
* `PROJECT_CONTEXT.md`: Definição de escopo, personas, premissas e objetivos do MVP.
* `ARCHITECTURE.md`: Especificação estrita da arquitetura em camadas (Layered Architecture) do Spring Boot.
* `BUSINESS_RULES.md`: Regras de negócio essenciais (prevenção de conflito de horários, expediente de segunda a sexta das 08h às 18h, slots de 60 minutos, restrição de datas retroativas).
* `DATABASE_DESIGN.md`: Modelagem relacional da entidade `Appointment` e especificação do populamento automatizado via `DataLoader` (`CommandLineRunner`).
* `UI_UX_GUIDELINES.md`: Diretrizes visuais inspiradas na anatomia da coluna vertebral, paleta de cores clínica (obsidiana e teal clínico), tipografia limpa e regras de layout.
* `AI_AGENTS.md` & `IMPLEMENTATION_PLAN.md`: Governança de papéis e roadmap faseado de entregas.

### 3. Prompt Engineering & AI Agent Orchestration
* **Orquestração de Papéis:** O desenvolvimento foi dividido em frentes especializadas simulando agentes (Arquitetura, Back-End, Banco de Dados, Front-End/UI-UX, Testes e Documentação).
* **Elaboração de Prompts:** Uso de instruções estruturadas contendo escopo estrito (ex: proibição de frameworks SPA como React/Angular, mantendo o ecossistema Spring Boot + Thymeleaf puro), restrições tecnológicas e critérios de aceitação claros.

### 4. Software Architecture & Domain Modeling
* **Arquitetura em Camadas (Layered Architecture):** Organização robusta separando responsabilidades em pacotes claros (`controller`, `service`, `repository`, `model`, `dto`, `exception`, `config`).
* **Modelagem de Dados:** Entidades JPA bem definidas (`Appointment`, `Patient`, `ClinicService`) com relacionamentos consistentes e validações Bean Validation (`@NotNull`, `@NotBlank`, `@Future`).

### 5. Test Engineering, Code Review & Validation
* **Validação Funcional e QA:** Acompanhamento contínuo do comportamento da aplicação no navegador e inspeção de dados via H2 Console (`/h2-console`).
* **DataLoader Estratégico:** Implementação de massa de dados inicial via `DataLoader` para validar instantaneamente os indicadores do dashboard administrativo e a agenda diária.
* **Code Review Assistido:** Revisão humana detalhada de todas as implementações geradas pelas IAs, garantindo legibilidade, consistência e ausência de complexidade desnecessária.

---

## 🛠️ Tecnologias Utilizadas

* **Back-End:**
  * **Java 17**
  * **Spring Boot** (Spring Web, Spring Data JPA, Hibernate, Bean Validation)
  * **Lombok**
* **Front-End:**
  * **Thymeleaf** (Template Engine)
  * **HTML5, CSS3 / Tailwind CSS (via CDN)**
  * **JavaScript Vanilla**
* **Banco de Dados:**
  * **H2 Database** (Embutido em memória para execução rápida e demonstração)
* **Build & Dependências:**
  * **Maven** (`mvnw` / `pom.xml`)

---

## 🚀 Funcionalidades Principais

### 🌐 1. Portal Público (Home & Agendamento)
* **Apresentação Institucional:** Seções dedicadas à filosofia de saúde e bem-estar da clínica e biografia de Bryan Sousa.
* **Catálogo de Serviços:** Listagem de tratamentos de quiropraxia (Avaliação Inicial, Ajuste Vertebral, Alívio de Dores, Mobilidade, etc.) com detalhes de duração e objetivos.
* **Agendamento Online Inteligente:** Formulário interativo para o paciente selecionar serviço, data e horário disponível, com validações em tempo real.
* **Alternância de Tema:** Suporte a modo Claro (Light) e Escuro (Dark).

### 📊 2. Dashboard Administrativo
* **Visão Geral (KPIs):** Indicadores de atendimentos do dia, próximos horários e total de pacientes cadastrados.
* **Gestão da Agenda Diária:** Acompanhamento em tempo real dos agendamentos do dia.
* **Controle de Status:** Atualização de status de atendimento (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).
* **Populamento Automático (DataLoader):** Inicialização com massa de dados fictícia para demonstração imediata do fluxo gerencial.

---

## ⚙️ Regras de Negócio

1. **Prevenção de Conflitos (Anti-Conflito):** Impossibilidade de múltiplos agendamentos no mesmo horário para o mesmo profissional.
2. **Horário de Expediente:** Restrição a dias úteis (Segunda a Sexta) das 08:00 às 18:00, com slots de 60 minutos.
3. **Validação Temporal:** Bloqueio automático de datas passadas e horários expirados.
4. **Integridade de Dados:** Validação obrigatória de dados de contato e seleção de serviços válidos via Bean Validation.

---

## 📥 Como Executar o Projeto Localmente

### Pré-requisitos
* **Java 17** instalado na máquina.
* **Maven** (ou utilize o Maven Wrapper incluído no projeto).

### Passo a Passo

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/juniorsousa53339-svg/Nexo-Agendamento.git
   cd Nexo-Agendamento
   ```

2. **Execute a aplicação via Maven Wrapper:**
   * No Linux / macOS:
     ```bash
     ./mvnw spring-boot:run
     ```
   * No Windows (PowerShell / CMD):
     ```cmd
     .\mvnw.cmd spring-boot:run
     ```

3. **Acesse no navegador:**
   * **Portal Público:** `http://localhost:8080/`
   * **Dashboard Administrativo:** `http://localhost:8080/admin`
   * **Console H2 Database:** `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:nexodb`, User: `sa`, Senha: *(vazia)*)

---

## 📁 Estrutura do Projeto

```text
nexo/
├── src/
│   ├── main/
│   │   ├── java/v1/agendamento/nexo/
│   │   │   ├── config/          # Configurações globais e DataLoader
│   │   │   ├── controller/      # Controladores Spring MVC
│   │   │   ├── dto/             # Objetos de Transferência de Dados
│   │   │   ├── exception/       # Tratamento global de exceções
│   │   │   ├── model/           # Entidades JPA e Enums
│   │   │   ├── repository/      # Repositórios Spring Data JPA
│   │   │   ├── service/         # Regras de negócio
│   │   │   └── NexoApplication.java
│   │   └── resources/
│   │       ├── static/          # CSS, JS, Imagens
│   │       ├── templates/       # Páginas Thymeleaf (Portal e Admin)
│   │       └── application.properties
│   └── test/                    # Testes automatizados
├── pom.xml                      # Dependências Maven
├── PROJECT_CONTEXT.md           # Contexto geral do projeto
├── ARCHITECTURE.md              # Documentação de arquitetura
├── BUSINESS_RULES.md            # Regras de negócio e validações
├── DATABASE_DESIGN.md           # Modelagem de dados
├── UI_UX_GUIDELINES.md          # Diretrizes visuais e UI/UX
└── README.md                    # Documentação do Projeto
```

---

## 👥 Autoria

Desenvolvido por **Luciano Júnior** e **Cláudio** em colaboração com Inteligência Artificial, como parte do **Projeto Integrador acadêmico** (Clínica de Quiropraxia - Alphaville/SP).

---

🤖 Generated with [Claude Code](https://claude.com/claude-code)
