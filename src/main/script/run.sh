#!/usr/bin/env bash

docker build -t dolphineor/spring-boot-examples .
docker run --name spring-boot-examples --net=host -d -p 8081:8081 dolphineor/spring-boot-examples