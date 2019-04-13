
10 - Kafka 

1. For local development via Docker for Mac/Windows

make sure to be connected to the normal Docker daemon
unset DOCKER_TLS_VERIFY DOCKER_HOST DOCKER_CERT_PATH DOCKER_API_VERSION

cd kafka-docker
docker-compose up

brew install kafkacat
kafkacat -P -b localhost -t my-topic
2nd terminal
kafkacat -C -b localhost -t my-topic




2. For Kafka in Kubernetes






20 - Helm Operator SDK


brew install kubernetes-helm

helm init
helm repo update
helm list


