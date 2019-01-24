[![Build Status](https://travis-ci.org/dnltsk/springboot-kotlin-starter.svg?branch=master)](https://travis-ci.org/dnltsk/springboot-kotlin-starter)
[![CodeBeat](https://codebeat.co/badges/6fb20abc-6142-406d-97af-6314ac5972f6)](https://codebeat.co/projects/github-com-dnltsk-springboot-kotlin-starter-master)
[![CodeCov](https://codecov.io/gh/dnltsk/springboot-kotlin-starter/branch/master/graph/badge.svg)](https://codecov.io/gh/dnltsk/springboot-kotlin-starter)


# springboot-kotlin-starter

starting point for a new spring boot micro service, written in Kotlin

## features

* [x] Travis CI integration
* [x] CodeBeat integration
* [x] CodeCov integration
* [x] Swagger UI
* [x] Sentry integration
* [x] Dockerization
* [ ] Heroku deployment

## test

`./gradlew clean test`

## build

`./gradlew clean bootJar`

## start

`java -jar build/libs/*.jar --sentry.enabled=true --sentry.dsn=${YOUR_SENTRY_DSN}`

## build docker

`docker build . -t springboot-kotlin-starter`

## start docker

`docker run -it -p 8080:8080 -e sentry.enabled='true' -e sentry.dsn='${YOUR_SENTRY_DSN}' springboot-kotlin-starter`

## access

http://localhost:8080/
