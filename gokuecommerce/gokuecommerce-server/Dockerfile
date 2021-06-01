FROM fabric8/java-alpine-openjdk8-jre
VOLUME /tmp
ADD target/gokuecommerce-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS="-Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=8080,suspend=n, -Xlog:gc:/tmp/gc1.log -verbose:gc* -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/ Xms512 -Xmx512 -XX:MaxMetaspaceSize=256m -XX:UseG1GC -XX:MaxGCPauseMillis=200 -XX:ParalleGCThreds=5 -XX:ConGCThreds=2"
ENV SPRING_PROFILES_ACTIVE "docker"
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=$SPRING_PROFILES_ACTIVE -jar /app.jar" ]
