java  -XX:+UseZGC -XX:+ZGenerational -Xms1g -Xmx1g -XX:+ExitOnOutOfMemoryError \
-javaagent:./elastic-apm-agent-1.52.0.jar \
-Delastic.apm.service_name=rest-jpa \
-Delastic.apm.secret_token=Passw0rd \
-Delastic.apm.server_url=http://172.162.240.204:8200 \
-Delastic.apm.environment=my-environment \
-Delastic.apm.application_packages=com.avanade \
-jar rest-jpa-0.0.1-SNAPSHOT.jar \
--logging.config=./logback.xml