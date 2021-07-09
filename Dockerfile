FROM openjdk:8

EXPOSE 8080
ADD /target/weblaptop-0.0.1-SNAPSHOT.jar  weblaptop.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","weblaptop.jar"]
