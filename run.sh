#!/usr/bin/env bash

# Project root directory
BASE_DIR="$(pwd)"

# Maven package
mvn clean package -DskipTests


# Host docker resource directory
DOCKER_DIR=docker
if [ ! -d "${HOME}/${DOCKER_DIR}" ];  then
    cd ~ && mkdir "${DOCKER_DIR}"
fi

SPRING_BOOT_EXAMPLES_DIR=spring-boot-examples
cd ~/${DOCKER_DIR}
if [ ! -d "${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}" ];  then
    mkdir "${SPRING_BOOT_EXAMPLES_DIR}"
fi

TMP_TARGET_DIR=spring-boot-app
mv ${BASE_DIR}/target/spring-boot-app.zip /tmp
cd /tmp && rm -rf ${TMP_TARGET_DIR}
unzip spring-boot-app.zip -d ${TMP_TARGET_DIR}
cd ${TMP_TARGET_DIR} && cp spring-boot-examples.jar ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}


# If specific image not exists, build a new image
if [ -z "$(docker images -q spring-boot-examples 2> /dev/null)" ];  then
    docker build -t spring-boot-examples .
fi


# Container name
CONTAINER=spring-boot-web
# Container status
RUNNING=$(docker inspect --format="{{ .State.Running }}" ${CONTAINER} 2> /dev/null)

# If specific container not exists, run a new container
if [ $? -eq 1 ];  then
    docker run --name spring-boot-web -d -p 8088:8081 -v ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}:/opt/spring-boot-examples spring-boot-examples /bin/bash
fi

# Check container running status
if [ "$RUNNING" = "false" ];  then
    docker start spring-boot-web
else if [ "$RUNNING" = "true" ];  then
    docker restart spring-boot-web
    fi
fi