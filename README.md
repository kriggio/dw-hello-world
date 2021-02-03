# Hello World via DropWizard

How to start the Hello World application
---

1. Run `mvn clean package` or `gradle jar` to build your application
1. Start application with `java -jar target/dwhello-1.0-SNAPSHOT.jar server hello-world.yml` for Maven or `java -jar build/libs/dwhello-1.0-SNAPSHOT.jar server hello-world.yml` for gradle
1. To check that your application is running enter url `http://localhost:8080/hello-world`

Trying It Out
---

`$ curl http://localhost:8080/hello-world`

Will output:
`Hello! How are you today?`

`$ curl "http://localhost:8080/hello-world/format?reverse=true"`

Will output:
`?yadot uoy era woH !olleH`

`$ curl http://localhost:8080/hello-world/format`

Will output:
`Hello! How are you today?`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Using Docker
---
You can run locally via Docker by running the following commands after packaging the project via maven (`mvn package`, though you will have to update the Dockerfile to get this to grab the correct jar now) or gradle (`gradle jar`).

`$ docker build -t dw-hello-world .`

`$ docker run -p 8080:8080 -ti --rm dw-hello-world`

Tests
---
You can run the tests via maven or gradle

`$ mvn clean test`

or

`gradle clean test`

Notes
---
Please note that the Saying and SayingResource classes are just part of the boilerplate init and there for reference.

TODO
---
Add Drop Wizard Resource Testing through a Jetty Client Testing to Spock Tests

