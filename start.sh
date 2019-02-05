#!/bin/bash
mvn clean package
docker build -t pio .
docker run -d -p 9090:8080  pio 