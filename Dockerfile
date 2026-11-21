# Estágio de Build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Copia todos os arquivos do projeto para o container
COPY . .

# Garante permissão de execução no mvnw e compila o projeto
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Porta padrão exposta pelo Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
