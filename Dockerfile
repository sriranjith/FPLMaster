# https://medium.com/oracledevs/run-always-free-docker-container-on-oracle-cloud-infrastructure-c88e36b65610
FROM maven:3.6.3-openjdk-11-slim as BUILDER
ARG VERSION=0.0.1-SNAPSHOT
WORKDIR /build/
COPY pom.xml /build/
COPY src /build/src/

#RUN mvn clean package
COPY target/FPLMaster-${VERSION}.jar target/application.jar

FROM openjdk:11.0.8-jre-slim
WORKDIR /app/

EXPOSE 8080
COPY --from=BUILDER /build/target/application.jar /app/
CMD java -jar /app/application.jar