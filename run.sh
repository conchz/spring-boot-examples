#!/bin/bash

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


# If specific image not exist, build a new image
IMAGE=spring-boot-examples
if [ -z "$(docker images -q ${IMAGE} 2> /dev/null)" ];  then
    docker build -t ${IMAGE} .
fi


# Container name
CONTAINER=spring-boot-web
# Container status
RUNNING=$(docker inspect --format="{{ .State.Running }}" ${CONTAINER} 2> /dev/null)

# If specific container not exist, run a new container
if [ $? -eq 1 ];  then
    docker run --name=${CONTAINER} --net=host -d -v ${HOME}/${DOCKER_DIR}/${SPRING_BOOT_EXAMPLES_DIR}:/opt/spring-boot-examples ${IMAGE}
fi

# Check container running status
if [ "$RUNNING" = "false" ];  then
    docker start ${CONTAINER}
else if [ "$RUNNING" = "true" ];  then
    docker restart ${CONTAINER}
    fi
fi