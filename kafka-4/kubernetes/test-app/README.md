## Deploying Kubernetes test application

### 1. Create service for accessing the application
Create service:
```
kubectl create -f 1-testapp-service.yaml
```

Get list of services:
```
kubectl get services 
```

Get service's url:
```
minikube service test-app-service --url
```

### 2. Create replication controller
Create controller:
```
kubectl create -f 2-testapp-controller.yaml
```

Display controller's info:
```
kubectl describe replicationcontrollers/test-app-controller
```

Take a look at created pods:
```
kubectl get pods
```

### 3. Delete created service and controller
Delete controller:
```
kubectl delete replicationcontrollers/test-app-controller
```

Delete service:
```
kubectl delete service test-app-service
```
