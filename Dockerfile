# Estágio de Build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Copia os arquivos de configuração do Maven e o wrapper
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

# Baixa as dependências (cache de build)
RUN ./mvnw dependency:go-offline

# Copia o código fonte
COPY src/ src/

# Empacota a aplicação sem rodar os testes
RUN ./mvnw package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado do estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
