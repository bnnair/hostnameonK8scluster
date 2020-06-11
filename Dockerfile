FROM maven:3.5-jdk-8 AS build  
COPY ./hostname/ /usr/src/app/
COPY ./hostname/pom.xml /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package

FROM openjdk:8-jdk-alpine
COPY --from=build /usr/src/app/target/*.jar /usr/src/app/hostname.jar  
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/src/app/hostname.jar"]