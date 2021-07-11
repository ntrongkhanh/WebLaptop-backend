FROM openjdk:8

EXPOSE 8443
ADD /target/weblaptop-0.0.1-SNAPSHOT.jar  weblaptop.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","weblaptop.jar"]
