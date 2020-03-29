#allows to run maven project 
FROM maven:3.3.9-jdk-8 as build

#sets the working directory
WORKDIR /app

# selectively add the POM file and
# install dependencies
COPY pom.xml .
COPY src src
# rest of the project
RUN mvn install -DskipTests

RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

#openjdk repo
FROM openjdk:8-jdk-alpine

WORKDIR /app
VOLUME /tmp

ARG TARGET=/app/target/

COPY --from=build ${TARGET}/lib /app/lib
COPY --from=build ${TARGET}/classes .

#exposed port for app
EXPOSE 8080

#comands started after contaier's been started -> java -cp/app:/app/lib/* rest.App -> where:
#java - java runtiem launcher
#-cp /app:/app/lib/* - sets the path to the packages (classpath)
#rest.App - name of the main class
ENTRYPOINT ["java","-cp","/app:/app/lib/*","rest.App"]