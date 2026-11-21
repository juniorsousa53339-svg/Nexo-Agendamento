# AI_AGENTS.md — Diretrizes para Agentes de Inteligência Artificial

## 1. Propósito deste Documento
Este documento estabelece as regras de governança, divisão de papéis e diretrizes de desenvolvimento para os diferentes agentes de IA que atuarão no projeto **NEXO**. O objetivo é garantir alinhamento arquitetural, consistência de código e respeito ao escopo acadêmico e funcional definido.

---

## 2. Papéis dos Agentes de IA
* **Agente de Arquitetura:** Responsável por revisar a estrutura de pacotes, consistência dos documentos de contexto e aderência às tecnologias definidas (Java 17, Spring Boot, Thymeleaf).
* **Agente de Back-End:** Responsável pela implementação das entidades, repositórios, serviços, controllers e regras de negócio em Java.
* **Agente de Banco de Dados & DataLoader:** Responsável pela modelagem relacional, configuração do H2 e implementação do populamento de dados fictícios.
* **Agente de Front-End & UI/UX:** Responsável pelo desenvolvimento das páginas Thymeleaf, estilização com Tailwind CSS, responsividade e interatividade com JavaScript.
* **Agente de Testes e Qualidade:** Responsável por validar regras de negócio, testes unitários e de integração (JUnit / Mockito).

---

## 3. Regras Gerais de Desenvolvimento para IAs
1. **Respeito ao Escopo:** Não adicione funcionalidades não solicitadas (ex: sistemas complexos de pagamento, OAuth2 avançado, microsserviços) a menos que explicitamente autorizado.
2. **Consulta aos Contextos:** Antes de iniciar qualquer tarefa, o agente deve ler os arquivos de contexto (`PROJECT_CONTEXT.md`, `ARCHITECTURE.md`, `BUSINESS_RULES.md`, etc.).
3. **Consistência Tecnológica:** Jamais introduza frameworks não aprovados (como React, Angular ou Vue). Mantenha-se estritamente em Java 17, Spring Boot e Thymeleaf.
4. **Comunicação de Decisões:** Qualquer alteração em decisões arquiteturais deve ser sinalizada e registrada no histórico ou na seção de pendências.
5. **Código Limpo e Documentado:** Escreva código legível, com nomes de variáveis em inglês (padrão Spring/Java) e comentários explicativos quando necessário.
