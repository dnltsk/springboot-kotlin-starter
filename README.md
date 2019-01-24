[![Build Status](https://travis-ci.org/dnltsk/springboot-kotlin-starter.svg?branch=master)](https://travis-ci.org/dnltsk/springboot-kotlin-starter)
codebeat
[![codecov](https://codecov.io/gh/dnltsk/springboot-kotlin-starter/branch/master/graph/badge.svg)](https://codecov.io/gh/dnltsk/springboot-kotlin-starter)


# springboot-kotlin-starter

starting point for a new spring boot micro service, written in Kotlin

## features

* [x] Travis CI integration
* [ ] CodeBeat integration
* [x] CodeCov integration
* [ ] Swagger UI
* [ ] Sentry integration
* [x] Dockerization
* [ ] Heroku deployment

## test

`./gradlew clean test`

## build

`./gradlew clean bootJar`

## start

`java -jar build/libs/*.jar`

## build docker

`docker build . -t springboot-kotlin-starter`

## start docker

`docker run -it -p 8080:8080 springboot-kotlin-starter`

## access

http://localhost:8080/
