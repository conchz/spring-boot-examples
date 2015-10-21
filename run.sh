#!/usr/bin/env bash

BASE_DIR="$(pwd)"
DOCKER_DIR=docker
SPRING_BOOT_EXAMPLES_DIR=spring-boot-examples
CONTAINER=spring-boot-web

mvn clean package -DskipTests

if [ ! -d "${HOME}/${DOCKER_DIR}" ];  then
    cd ~ && mkdir "${DOCKER_DIR}"
fi

cd ~/${DOCKER_DIR}
if [ ! -d "${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}" ];  then
    mkdir "${SPRING_BOOT_EXAMPLES_DIR}"
fi

mv ${BASE_DIR}/target/spring-boot-app.zip /tmp
cd /tmp && rm -rf spring-boot-app
unzip spring-boot-app.zip -d spring-boot-app && cd spring-boot-app
cp spring-boot-examples.jar ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}

if [ -z "$(docker images -q spring-boot-examples 2> /dev/null)" ];  then
    docker build -t spring-boot-examples .
fi

RUNNING=$(docker inspect --format="{{ .State.Running }}" ${CONTAINER} 2> /dev/null)

if [ $? -eq 1 ];  then
    docker run --name spring-boot-web -d -p 8088:8081 -v ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}:/opt/spring-boot-examples spring-boot-examples
fi

if [ "$RUNNING" = "false" ];  then
    docker restart --name spring-boot-web -d -p 8088:8081 -v ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}:/opt/spring-boot-examples spring-boot-examples
fi