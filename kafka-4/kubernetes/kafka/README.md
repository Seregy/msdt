## Deploying Kafka and Producer application

### 1. Replace HOSTNAME with your Minikube IP
Get Minikube IP:
```
minikube ip
```

Replace HOSTNAME values with your Minikube IP in files:
 - 21-kafka-statefulset.yml
 - 31-producer-controller.yml

### 2. Deploy Zookeeper
Create Zookeeper service:
```
kubectl create -f 10-zookeeper-service.yml
```

Create Zookeeper deployment with Zookeeper instance:
```
kubectl create -f 11-zookeeper-deployment.yml
```

### 3. Deploy Kafka broker
Create service for Kafka broker:
```
kubectl create -f 20-kafka-service.yml
```

Create StatefulSet with broker instance:
```
kubectl create -f 21-kafka-statefulset.yml
```

Take a look at broker logs:
```
kubectl logs kafka-0
```

### 4. Deploy Producer application
Create service for Producer:
```
kubectl create -f 30-producer-service.yml
```

Create ReplicationController with Producer instance:
```
kubectl create -f 31-producer-controller.yml
```

Take a look at created pods:
```
kubectl get pods
```

Take a look at Producer's logs using pod id, that can be acquired in the previous step:
```
kubectl logs producer-controller-{uniquePodId}
```

### 5. Launch Consumer
Launch Consumer from [kafka-1](../../../kafka-1/kafka-1-consumer) with property
```
spring.kafka.bootstrap-servers = {yourMinikubeIp}:32000
```

### 6. Delete created services and deployments
Delete Zookeeper service:
```
kubectl delete -f 10-zookeeper-service.yml
```

Delete Zookeeper deployment:
```
kubectl delete -f 11-zookeeper-deployment.yml
```

Delete Kafka broker service:
```
kubectl delete -f 20-kafka-service.yml
```

Delete Kafka broker StatefulSet:
```
kubectl delete -f 21-kafka-statefulset.yml
```

Delete Producer service:
```
kubectl delete -f 30-producer-service.yml
```

Delete Producer controller:
```
kubectl delete -f 31-producer-controller.yml
```
