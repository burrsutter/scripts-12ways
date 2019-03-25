FROM registry.access.redhat.com/ubi7-dev-preview/ubi-minimal
WORKDIR /work/
COPY target/qkafkaproducer2-1.0.0-runner /work/qkafkaproducer2-1.0.0-runner
RUN chmod 775 /work
EXPOSE 8080
ENTRYPOINT [ "./qkafkaproducer2-1.0.0-runner",  "-Xmx8m", "-Xmn8m", "-Xms8m"]