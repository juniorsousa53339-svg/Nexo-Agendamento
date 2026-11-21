# Estágio de Build
FROM eclipse-temurin:17-jdk-jammy AS build
WORKDIR /app

# Instala o Maven diretamente no container para evitar problemas com o wrapper
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*

# Copia todos os arquivos do projeto para o container
COPY . .

# Compila o projeto diretamente com o maven instalado (mvn)
RUN mvn clean package -DskipTests

# Estágio de Execução
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copia o jar gerado no estágio anterior
COPY --from=build /app/target/*.jar app.jar

# Porta padrão exposta pelo Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
