FROM openjdk:17
COPY "./target/ProyectoSamuelDeportes-1.jar" "app.jar"
EXPOSE 8067
ENTRYPOINT [ "java", "-jar","app.jar" ]