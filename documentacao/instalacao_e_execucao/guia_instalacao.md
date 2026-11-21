# Guia de Instalação e Execução Local — NEXO Quiropraxia

Este documento fornece instruções detalhadas para configurar, instalar e executar o projeto **NEXO Quiropraxia** em uma máquina limpa.

---

## 1. Requisitos Mínimos da Máquina
- **Processador**: Dual Core 2.0 GHz ou superior.
- **Memória RAM**: 4 GB (recomendado 8 GB).
- **Espaço em Disco**: 500 MB livres para dependências e build do Maven.

## 2. Sistemas Operacionais Compatíveis
- **Windows** (10 ou 11)
- **Linux** (Ubuntu, Fedora, etc.)
- **macOS**

---

## 3. Instalação e Verificação do Java (JDK 17)
O projeto requer obrigatoriamente o **Java Development Kit (JDK) versão 17**.

### Como verificar se o Java está instalado:
Abra o terminal (Prompt de Comando ou PowerShell no Windows, ou Terminal no Linux/macOS) e execute:
```bash
java -version
```
*A saída deve indicar a versão `17.x.x`.*

### Configuração da Variável de Ambiente `JAVA_HOME`:
1. Certifique-se de que a variável de sistema `JAVA_HOME`ponte para o diretório de instalação do JDK 17.
2. Adicione `%JAVA_HOME%\bin` (Windows) ou `$JAVA_HOME/bin` (Linux/macOS) ao `PATH` do sistema.

---

## 4. Instalação e Verificação do Git
O Git é necessário para clonar o repositório do projeto.

### Como verificar o Git:
```bash
git --version
```

---

## 5. Clonagem do Repositório
Abra o terminal na pasta onde deseja salvar o projeto e execute o comando de clonagem:
```bash
git clone <url-do-repositorio>
cd nexo
```
*(Nota: Se o código já estiver na sua máquina, navegue diretamente para a pasta raiz do projeto).*

---

## 6. Estrutura de Execução via Maven Wrapper
O projeto inclui o **Maven Wrapper** (`mvnw` para Linux/macOS e `mvnw.cmd` para Windows). Isso significa que você **não** precisa ter o Maven instalado globalmente na sua máquina; o próprio wrapper baixará a versão correta do Maven automaticamente.

---

## 7. Como Executar o Backend (Spring Boot)

No terminal, certifique-se de estar na pasta raiz do projeto onde se encontra o arquivo `pom.xml` (ou navegue para a subpasta `nexo` caso o repositório contenha essa estrutura):

### No Windows (PowerShell / Prompt):
```cmd
cd nexo
.\mvnw.cmd spring-boot:run
```

### No Linux / macOS (Bash / Zsh):
```bash
cd nexo
./mvnw spring-boot:run
```

### O que acontece durante a execução:
1. O Spring Boot compila o código e inicia o container embutido Tomcat.
2. O banco de dados em memória **H2** é inicializado.
3. As classes `DataLoader` e `DataInitializer` populam automaticamente o banco com os serviços de quiropraxia (com imagens Pexels configuradas) e agendamentos de exemplo.
4. A aplicação fica disponível na porta `8080`.

---

## 8. Acessando a Aplicação pelo Navegador
Abra o seu navegador web (Google Chrome, Firefox, Edge, etc.) e acesse:

- **Site Público (Home)**: [`http://localhost:8080`](http://localhost:8080)
- **Painel Administrativo**: [`http://localhost:8080/admin`](http://localhost:8080/admin)
- **Console do Banco H2**: [`http://localhost:8080/h2-console`](http://localhost:8080/h2-console)
  - *Configurações de Conexão H2*:
    - **JDBC URL**: `jdbc:h2:mem:nexodb`
    - **User Name**: `sa`
    - **Password**: *(deixe em branco)*

---

## 9. Como Executar os Testes Automatizados
Para executar a suíte de testes do projeto e verificar a integridade do código:

### No Windows:
```cmd
.\mvnw.cmd test
```

### No Linux / macOS:
```bash
./mvnw test
```
*Resultado esperado*: `BUILD SUCCESS` com 100% dos testes aprovados.

---

## 10. Solução de Erros Mais Comuns

1. **Porta 8080 em uso (`Address already in use`)**:
   - Outro aplicativo ou instância anterior do Spring Boot está rodando na porta 8080. Encerre o processo correspondente ou altere a porta em `src/main/resources/application.properties` adicionando:
     ```properties
     server.port=8081
     ```

2. **Erro de Versão do Java (`UnsupportedClassVersionError`)**:
   - O projeto foi compilado para Java 17, mas você está executando com uma versão inferior (ex: Java 11 ou 8). Verifique `java -version` e configure o `JAVA_HOME` corretamente para o JDK 17.

3. **Banco de Dados Vazio ou Erro de Tabela Não Encontrada**:
   - O Spring Boot utiliza `spring.jpa.hibernate.ddl-auto=create-drop`, recriando o esquema a cada inicialização e populando via `DataLoader`. Caso ocorra falha, reinicie a aplicação com o comando `spring-boot:run`.
