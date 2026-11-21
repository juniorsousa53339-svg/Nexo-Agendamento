# Prompt para Geração de Documentação Acadêmica (Padrão BNT / ABNT)

Utilize o prompt abaixo em outra inteligência artificial juntamente com o modelo de documento BNT da sua instituição para gerar a documentação acadêmica oficial do projeto **NEXO Quiropraxia**.

---

## 📋 Copie e cole o texto abaixo na outra IA:

```text
Você é um(a) especialista em documentação acadêmica e engenharia de software. 

Sua tarefa é redigir um documento acadêmico completo para o projeto "NEXO Quiropraxia", seguindo rigorosamente as normas de formatação e estrutura do modelo BNT (ou ABNT) que será fornecido a seguir.

CONTEXTO REAL DO PROJETO "NEXO QUIROPRAXIA":
- O que é: Sistema web de gestão e agendamento para clínica de quiropraxia avançada localizada em Alphaville, Barueri - SP.
- Tecnologias reais: Java 17, Spring Boot, Spring Data JPA, H2 Database (In-Memory), Thymeleaf, Tailwind CSS, Maven Wrapper.
- Arquitetura: Padrão MVC em camadas (Controllers, Services, Repositories, Entities/Models, DTOs).
- Funcionalidades principais:
  1. Site público responsivo com apresentação institucional, biografia do quiropraxista principal (Dr. Bryan Sousa), galeria de tratamentos com imagens customizáveis (integração Pexels), mapa de localização e formulário de agendamento online.
  2. Painel administrativo (/admin) com indicadores de KPI (agendamentos hoje, total de pacientes, concluídos, pendentes), filtro por data, alteração dinâmica de status de agendamentos e CRUD completo de serviços clínicos.
- Mecanismo de Inicialização: Classes DataLoader e DataInitializer que populam automaticamente serviços padrão e dados de teste.
- Testes: Suíte integrada com JUnit 5 e Spring Boot Test (NexoApplicationTests).

DIRETRIZES OBRIGATÓRIAS:
1. Baseie-se EXCLUSIVAMENTE nas informações reais listadas acima e na estrutura do código-fonte do projeto.
2. NÃO invente tecnologias, frameworks, microsserviços, tokens JWT ou bancos de dados relacionais externos não presentes no projeto.
3. Utilize o modelo de documento BNT fornecido como referência estrutural, adaptando todo o conteúdo textual para descrever o projeto NEXO Quiropraxia.
4. Mantenha uma linguagem técnica, formal, acadêmica e em português brasileiro.

Abaixo está o modelo BNT de referência (inserir modelo BNT da instituição):
[INSERIR MODELO BNT AQUI]
```
