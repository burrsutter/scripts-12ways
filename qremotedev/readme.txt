Quarkus remote:dev Example

Quarkus Example of
  REST (/api & /api/{name})
  Websockets

index.html sends 'ticks' to server and receive 'tocks' back from server

1. minikube -p myprofile docker-env
2. ./dockerbuild.sh
3. ./kubedeploy.sh
4. ./kubelogs.sh (and wait for server to start)
5. ./kubeservice.sh
6. ./kubeurl.sh
7. updated src/resources/application.properties with the REMOTE_URL
8. mvn quarkus:remote-dev


