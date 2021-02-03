# From an existing image that supports Java out of the box
FROM openjdk:12-oracle
# copy JAR into image
# Maven
# COPY target/dwhello-1.0-SNAPSHOT.jar /app.jar 
# Gradle
COPY build/libs/dwhello-1.0-SNAPSHOT.jar /app.jar 
# I would typically either make these types of configs eithe part of the 
# resources if build level changes are needed. If we want to support prurely runtime
# or restart level changes, I would use somethign like Spring Cloud Config for this.
COPY hello-world.yml /hello-world.yml 
# run application with this command line 
ENTRYPOINT [ "/usr/bin/java" ]
CMD ["-jar", "/app.jar", "server", "/hello-world.yml"]

# I would normally version tag these too.
#$ docker build -t dw-hello-world .
#$ docker run -p 8080:8080 -ti --rm dw-hello-world
