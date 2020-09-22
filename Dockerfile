FROM openjdk:8-jdk-alpine

# Run as user spring
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# https://spring.io/guides/gs/spring-boot-docker/
# Separate dependencies and application for performance
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","th.in.codex.demo.blog.BlogApp"]

# mysql
https://docs.docker.com/engine/swarm/secrets/
