# Usa una imagen base oficial de Java
FROM eclipse-temurin:21-jdk-alpine

# Crea un directorio en el contenedor para la aplicación
WORKDIR /app

# Copia los archivos del proyecto al contenedor
COPY . .

# Da permisos de ejecución a gradlew
RUN chmod +x ./gradlew

# Construye la aplicación utilizando Gradle
RUN ./gradlew build -x test

# Exponer el puerto en el que tu aplicación correrá
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "build/libs/nombre-de-tu-aplicacion.jar"]
