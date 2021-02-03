# Example

How to start the Hello World application
---

1. Run `mvn clean package` or `gradle clean package` to build your application
1. Start application with `java -jar target/dwhello-1.0-SNAPSHOT.jar server hello-world.yml`
1. To check that your application is running enter url `http://localhost:8080/hello-world`

Health Check
---

To see your applications health enter url `http://localhost:8081/healthcheck`

Using Docker
---
You can run locally via Docker by running the following commands after packaging the project via maven or gradle.


`$ docker build -t dw-hello-world`

`$ docker run -p 8080:8080 -ti --rm dw-hello-world`

Tests
---
You can run the tests via maven or gradle

`$ mvn clean test`

or

`gradle clean test`

