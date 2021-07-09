#!/bin/sh
docker kill laptop
mvn clean package -DskipTests=true
sudo docker-compose build
sudo docker-compose up
