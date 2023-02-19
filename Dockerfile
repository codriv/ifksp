FROM maven:3.8.3-openjdk-17 as build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn package

FROM maven:3.8.3-openjdk-17
COPY --from=build /usr/app/target/ifksp-0.0.1-SNAPSHOT.jar /app/ifksp.jar
ENTRYPOINT java -jar /app/ifksp.jar