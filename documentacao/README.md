# Documentação Oficial — NEXO Quiropraxia

Este repositório contém a documentação completa do sistema **NEXO Quiropraxia**, uma aplicação web desenvolvida para a gestão e agendamento de consultas em uma clínica de quiropraxia de alto padrão localizada em Alphaville, Barueri - SP.

---

## 📁 Estrutura da Documentação

A documentação está organizada nos seguintes módulos:

1. **[Documentação Técnica](./documentacao_tecnica/documentacao_tecnica.md)**
   - Visão geral, arquitetura do sistema, diagramas visuais (estilo Excalidraw), modelagem de dados, regras de negócio, fluxos de funcionamento, endpoints e tecnologias.

2. **[Guia de Instalação, Execução e Deploy](./instalacao_e_execucao/guia_instalacao.md)**
   - Manual passo a passo para configuração do ambiente, clonagem do repositório, execução via Maven Wrapper (`mvnw`), acesso ao H2 Console, **containerização via Docker** e **publicação/hospedagem na Render**.

3. **[Documentação de Testes](./testes/documentacao_testes.md)**
   - Análise dos testes automatizados existentes, suíte JUnit, resultados de execução, cobertura e propostas de testes futuros.

4. **[Prompts de Apoio e BNT](./prompts/)**
   - **[Prompt de Documentação BNT](./prompts/prompt_documentacao_bnt.md)**: Prompt estruturado para geração de documentos acadêmicos e técnicos baseados em normas (ABNT/BNT).
   - **[Prompt de Documentação Visual](./prompts/prompt_geracao_documentacao_visual.md)**: Prompt auxiliar para criação de representações visuais baseadas no código real.

---

## 🚀 Sobre o Sistema

O **NEXO Quiropraxia** é uma solução completa dividida entre:
- **Site Público**: Apresentação institucional, galeria de tratamentos com suporte a imagens customizáveis (integração Pexels), biografia do profissional responsável (Dr. Bryan Sousa) e formulário de agendamento online com validações.
- **Painel Administrativo (`/admin`)**: Gestão em tempo real da agenda diária, visualização de KPIs de atendimento (total hoje, pacientes cadastrados, concluídos, pendentes), filtro por data, alteração de status de agendamentos e cadastro/edição de serviços clínicos.
- **Deploy em Nuvem (Docker & Render)**: Suporte a containerização e publicação web para demonstração online a clientes.
