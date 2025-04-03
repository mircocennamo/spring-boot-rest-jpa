# STEP per creare immagine docker e push su dockerhub
docker build -t spring-boot-rest-jpa .
docker login
docker tag spring-boot-rest-jpa mircocennamo82/my-repo:spring-boot-rest-jpa
docker push mircocennamo82/my-repo:spring-boot-rest-jpa