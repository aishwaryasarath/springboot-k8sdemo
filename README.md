
![Docker Image Version (latest by date)](https://img.shields.io/docker/v/aishwaryasarath/kubernetes?style=plastic)
# springboot-k8sdemo
Deploying a simple springboot restful app to Kubernetes

## Requirements
1. Create a basic springboot structure using [spring initializr](https://start.spring.io)
   Project: Gradle
   Language: Java
   Springboot: 2.64
   Packaging: Jar
   Java: 8
2. Add an endpoint /hello to return Hello 

## Gradle build
```
./gradlew build
```

## Docker build, run, tag & push
```
docker build -t demo-sb-k8sj8 .
docker run -p 8080:8080 demo-sb-k8sj8 .
docker tag  demo-sb-k8sj8 aishwaryasarath/kubernetes:demo-sb-k8sj8
docker push aishwaryasarath/kubernetes:demo-sb-k8sj8
```

## Deploy the app in Kubernetes
```
kubectl create deployment demo-sb --image=aishwaryasarath/kubernetes:demo-sb-k8sj8 --dry-run=client -o=yaml > deployment.yaml
echo --- >> deployment.yaml
kubectl create service clusterip demo-sb --tcp=8080:8080 --dry-run=client -o=yaml >> deployment.yaml
kubectl apply -f deployment.yaml
kubectl get deployments
kubectl get service
```

## Connect to the app exposed as a service through ssh tunnel
```
kubectl port-forward svc/demo-sb 8080:8080
```

## Verify that the app is running in another terminal
```
curl localhost:8080/hello
```
