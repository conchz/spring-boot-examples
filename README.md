# Spring Boot Examples

Spring-boot-examples use [Spring Boot](http://projects.spring.io/spring-boot/) to build web project.

At the same time, some extra technologies are used, as following:

1. Using [Docker](https://www.docker.com/) to deploy project.
2. Integrating [mustache.java](https://github.com/spullara/mustache.java) to display view.
3. Combining [MySQL](https://www.mysql.com/) with [Hibernate](http://hibernate.org/) as data persistence.
4. Using [HikariCP](https://github.com/brettwooldridge/HikariCP) as database's dataSource.

> **Note:**

> - In order to run project successfully, you need to change database's connection as your own in hibernate.properties, including **jdbcUrl**, **username**, **password**.