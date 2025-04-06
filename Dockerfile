FROM maven:3.8.4-openjdk-17 as build

RUN apk --no-cache add curl

##AJUSTA DATA-HORA
RUN apk add --no-cache tzdata
ENV TZ=America/Sao_Paulo

COPY src /udemy-app/src

COPY pom.xml /udemy-app

WORKDIR /udemy-app

RUN mvn clean install

FROM openjdk:22-ea-16-oracle

COPY --from=build /udemy-app/target/udemy-proto-api-0.0.1.jar /udemy-app/udemy-proto-api-0.0.1.jar

WORKDIR /udemy-app

EXPOSE 8080

CMD [ "java","-jar","udemy-proto-api-0.0.1.jar"]

