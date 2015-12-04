#!/bin/bash

# Project root directory
base_dir=$(pwd)

# Maven package
mvn clean package -DskipTests


# Host docker resource directory
docker_dir=docker
if [ ! -d "${HOME}/${docker_dir}" ];  then
    cd ~ && mkdir "${docker_dir}"
fi

spring_boot_examples_dir=spring-boot-examples
cd ~/${docker_dir}
if [ ! -d "${HOME}/${docker_dir}/${spring_boot_examples_dir}" ];  then
    mkdir "${spring_boot_examples_dir}"
fi

tmp_target_dir=spring-boot-app
mv ${base_dir}/target/spring-boot-app.zip /tmp
cd /tmp && rm -rf ${tmp_target_dir}
unzip spring-boot-app.zip -d ${tmp_target_dir}
cd ${tmp_target_dir} && cp spring-boot-examples.jar ${HOME}/${docker_dir}/${spring_boot_examples_dir}


# If specific image not exist, build a new image
imageName=spring-boot-examples
if [ -z "$(docker images -q ${imageName} 2> /dev/null)" ];  then
    docker build -t ${imageName} .
fi


# Container name
container=spring-boot-web
# Container status
running=$(docker inspect --format="{{ .State.Running }}" ${container} 2> /dev/null)

# If specific container not exist, run a new container
if [ $? -eq 1 ];  then
    docker run --name=${container} --net=host -d -v ${HOME}/${docker_dir}/${spring_boot_examples_dir}:/opt/docker ${imageName}
fi

# Check container running status
if [ "${running}" = "false" ];  then
    docker start ${container}
else if [ "${running}" = "true" ];  then
    docker restart ${container}
    fi
fi