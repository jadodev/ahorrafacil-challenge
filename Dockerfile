# Usa una imagen base oficial de Java 17
FROM eclipse-temurin:17-jdk-alpine

# Crea un directorio en el contenedor para la aplicación
WORKDIR /app

# Copia solo los archivos necesarios para construir la aplicación
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle ./
COPY settings.gradle ./
COPY src ./src

# Da permisos de ejecución a gradlew
RUN chmod +x ./gradlew

# Construye la aplicación utilizando Gradle
RUN ./gradlew build -x test --stacktrace --info && ls build/libs

# Exponer el puerto en el que tu aplicación correrá
EXPOSE 8080

# Comando para ejecutar la aplicación, asegúrate de cambiar el nombre del archivo jar
ENTRYPOINT ["java", "-jar", "/ahorrafacil.jar"]

