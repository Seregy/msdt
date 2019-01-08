## Test Kubernetes Application
### 1. Package the application:
Package the application via Maven:
```
mvn clean verify
```

### 2. Publish the application:
Build Docker image and push it to the Docker Hub:
```
docker build . -t kub-test-app

docker push seregy/msdt:kub-test-app
```
