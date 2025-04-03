#!/bin/sh
echo starting: Ping-Service.
export OTEL_EXPORTER_OTLP_ENDPOINT=https://my-observability-project-e4bdb9.apm.us-east-1.aws.elastic.cloud:443
export OTEL_EXPORTER_OTLP_HEADERS="Authorization=ApiKey NzNkaU41VUJJa1NKQkRQWTA3T1c6aVVvOWQ2NHdxT3VmVld4Qk42RlpVZw=="
export OTEL_METRICS_EXPORTER=otlp
export OTEL_LOGS_EXPORTER=otlp
export OTEL_RESOURCE_ATTRIBUTES=service.name=rest-jpa-collector-service,service.version=0.0.1-SNAPSHOT,deployment.environment=my-environment
#export OTEL_INSTRUMENTATION_HTTP_CAPTURE_HEADERS_CLIENT_REQUEST=all

#export OTEL_INSTRUMENTATION_HTTP_CAPTURE_HEADERS_CLIENT_RESPONSE=all
#export OTEL_INSTRUMENTATION_HTTP_CAPTURE_PARAMETERS=request

java -XX:+UseZGC -XX:+ZGenerational -Xms1g -Xmx1g -XX:+ExitOnOutOfMemoryError -javaagent:./opentelemetry-javaagent.jar  -Dotel.instrumentation.http.capture-headers.client.request=all  -Dotel.instrumentation.http.capture-headers.client.response=all -Dotel.instrumentation.http.capture-parameters=request  -jar ../target/rest-jpa-0.0.1-SNAPSHOT.jar  2>&1
echo $! > ./pid.file



