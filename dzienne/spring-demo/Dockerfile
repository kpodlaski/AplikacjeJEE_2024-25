FROM eclipse-temurin:21
WORKDIR /opt/project
COPY .mvn/ /opt/project/.mvn
COPY mvnw pom.xml /opt/project/

# Converting the mvnw line endings during build (if you don’t change line endings of the mvnw file)
RUN apt update && apt install -y dos2unix
RUN dos2unix ./mvnw
RUN ./mvnw dependency:resolve

COPY --from=build /root/.m2 /root/.m2

COPY src /opt/project/src

CMD ["./mvnw", "spring-boot:run"]
