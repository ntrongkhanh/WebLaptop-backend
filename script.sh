#!/bin/sh
sudo docker kill laptop
sudo mvn clean package -DskipTests=true
sudo docker-compose build
sudo docker-compose up
