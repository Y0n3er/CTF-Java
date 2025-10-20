FROM openjdk:21-jdk-slim

WORKDIR /app

COPY app.jar /app/app.jar
COPY flag.txt /tmp/flag.txt

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]