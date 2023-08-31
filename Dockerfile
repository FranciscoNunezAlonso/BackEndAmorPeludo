FROM azul/zulu-openjdk:17-latest
VOLUME /tmp
COPY amorPeludo/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080