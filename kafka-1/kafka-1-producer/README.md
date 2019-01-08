## Kafka Producer
### 1. Package the application:
Package the application via Maven:
```
mvn clean verify
```

### 2. Publish the application:
Build Docker image and push it to the Docker Hub:
```
docker build . -t seregy/msdt-producer

docker push seregy/msdt-producer
```
