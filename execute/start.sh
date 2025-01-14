#!/bin/sh
echo starting: Ping-Service.
export OTEL_EXPORTER_OTLP_ENDPOINT=http://172.162.240.204:8200
export OTEL_EXPORTER_OTLP_HEADERS="Authorization=Bearer Passw0rd"
export OTEL_METRICS_EXPORTER=otlp
export OTEL_LOGS_EXPORTER=otlp
export OTEL_RESOURCE_ATTRIBUTES=service.name=rest-jpa-collector-service,service.version=0.0.1-SNAPSHOT,deployment.environment=my-environment


java -XX:+UseZGC -XX:+ZGenerational -Xms1g -Xmx1g -XX:+ExitOnOutOfMemoryError -javaagent:./opentelemetry-javaagent.jar  -jar ./rest-jpa-0.0.1-SNAPSHOT.jar  2>&1
echo $! > ./pid.file



