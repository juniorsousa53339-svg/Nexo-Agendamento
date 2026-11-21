# 🌐 NEXO — Sistema de Gestão e Agendamento para Clínica de Quiropraxia

<p align="center">
  <b>Sistema web moderno de agendamento e gerenciamento desenvolvido como Projeto Integrador acadêmico.</b>
</p>

---

## 📋 Sobre o Projeto

O **NEXO** é uma aplicação web desenvolvida para operar como o sistema digital de gestão e agendamento de uma clínica de quiropraxia de alto padrão localizada em **Alphaville, São Paulo**, tendo como profissional responsável **Brian Sousa**.

Apesar de seu contexto acadêmico (Projeto Integrador), o sistema foi concebido com padrões de mercado (SaaS moderno), oferecendo arquitetura limpa, código manutenível, validações robustas e uma experiência de usuário (UX/UI) sofisticada, tecnológica e minimalista.

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
* **Apresentação Institucional:** Seções dedicadas à filosofia de saúde e bem-estar da clínica e biografia de Brian Sousa.
* **Catálogo de Serviços:** Listagem de tratamentos de quiropraxia (Avaliação Inicial, Ajuste Vertebral, Alívio de Dores, Mobilidade, etc.) com detalhes de duração e objetivos.
* **Agendamento Online Inteligente:** Formulário interativo para o paciente selecionar serviço, data e horário disponível, com validações em tempo real.
* **Alternância de Tema:** Suporte a modo Claro (Light) e Escuro (Dark).

### 📊 2. Dashboard Administrativo
* **Visão Geral (KPIs):** Indicadores de atendimentos do dia, próximos horários e total de pacientes cadastrados.
* **Gestão da Agenda Diária:** Acompanhamento em tempo real dos agendamentos do dia.
* **Controle de Status:** Atualização de status de atendimento (`AGENDADO`, `CONFIRMADO`, `CONCLUIDO`, `CANCELADO`).
* **Populamento Automático (DataLoader):** Inicialização com dados fictícios para demonstração imediata do fluxo.

---

## ⚙️ Regras de Negócio

1. **Prevenção de Conflitos:** Impossibilidade de múltiplos agendamentos no mesmo horário.
2. **Horário de Expediente:** Restrição a dias úteis e horários comerciais estabelecidos.
3. **Validação Temporal:** Bloqueio automático de datas passadas e horários expirados.
4. **Integridade de Dados:** Validação obrigatória de dados de contato e seleção de serviços válidos.

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
│   │   │   ├── controller/      # Controladores Spring MVC
│   │   │   ├── model/           # Entidades JPA e Enums
│   │   │   ├── repository/      # Repositórios Spring Data JPA
│   │   │   ├── service/         # Regras de negócio
│   │   │   └── NexoApplication.java
│   │   └── resources/
│   │       ├── static/          # CSS, JS, Imagens
│   │       ├── templates/       # Páginas Thymeleaf
│   │       └── application.properties
│   └── test/                    # Testes automatizados
├── pom.xml                      # Dependências Maven
└── README.md                    # Documentação do Projeto
```

---

## 👥 Autor

Desenvolvido por **Luciano Jr** como parte do **Projeto Integrador acadêmico** (Clínica de Quiropraxia - Alphaville/SP).

---

🤖 Generated with [Claude Code](https://claude.com/claude-code)
