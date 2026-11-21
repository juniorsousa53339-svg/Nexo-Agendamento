# Documentação de Testes — NEXO Quiropraxia

---

## 1. Objetivo dos Testes
A suíte de testes do projeto **NEXO Quiropraxia** tem como objetivo validar a integridade estrutural do sistema, garantir o carregamento correto do contexto da aplicação Spring Boot, bem como assegurar que beans, repositórios e configurações JPA inicializem sem falhas.

---

## 2. Tipos de Testes Identificados
- **Testes de Integração e Carregamento de Contexto**:
  - Validação da classe `NexoApplicationTests`, que utiliza a anotação `@SpringBootTest` para carregar o contexto completo do Spring Boot, testando a injeção de dependências e a integridade do mapeamento JPA/Hibernate com o banco H2.

---

## 3. Tecnologias e Ferramentas Utilizadas
- **JUnit 5**: Framework padrão de testes em Java.
- **Spring Boot Test**: Suporte a testes integrados para aplicações Spring (`@SpringBootTest`).
- **H2 Database (In-Memory)**: Banco de dados utilizado durante a execução dos testes para simular o ambiente de produção/desenvolvimento de forma isolada.

---

## 4. Comandos para Execução dos Testes
Para executar todos os testes automatizados do projeto, utilize o Maven Wrapper na raiz do diretório `nexo`:

### No Windows:
```cmd
.\mvnw.cmd test
```

### No Linux / macOS:
```bash
./mvnw test
```

---

## 5. Resultados dos Testes Executados
Execução realizada com sucesso no ambiente atual:

```text
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running v1.agendamento.nexo.NexoApplicationTests
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] Results:
[INFO] 
[INFO] BUILD SUCCESS
```

- **Resumo**: 1 teste executado, 0 falhas, 0 erros. O tempo médio de execução da suíte completa é de aproximadamente 6 a 8 segundos.

---

## 6. Limitações Encontradas
1. **Cobertura de Testes Unitários**:
   - Atualmente, as classes de serviço (`AppointmentService`, `PatientService`, `ClinicServiceService`) e os controladores (`HomeController`, `AdminController`) não possuem testes unitários isolados (utilizando Mockito).
2. **Testes de Interface (E2E)**:
   - Não há automação de testes de ponta a ponta (como Selenium ou Playwright) para testar os formulários web e a navegação no painel administrativo.

---

## 7. Propostas de Testes Futuros
Para elevar a maturidade de testes do projeto, recomenda-se implementar:
- **Testes Unitários para Services**: Utilizar JUnit 5 e Mockito para testar as regras de negócio de agendamento e verificação de horários sem subir o contexto do Spring.
- **Testes de Controladores (Web Mvc Test)**: Utilizar `MockMvc` para validar os endpoints HTTP do `HomeController` e `AdminController`, garantindo o retorno correto de views e tratamento de erros.
- **Testes de Repositórios (Data JPA Test)**: Validar consultas customizadas e integridade das entidades com `@DataJpaTest`.
