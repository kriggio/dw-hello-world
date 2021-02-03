# Alpine Linux with OpenJDK JRE
FROM openjdk:12-oracle
# copy JAR into image
COPY target/dwhello-1.0-SNAPSHOT.jar /app.jar 
COPY hello-world.yml /hello-world.yml 
# run application with this command line 
ENTRYPOINT [ "/usr/bin/java" ]
CMD ["-jar", "/app.jar", "server", "/hello-world.yml"]
