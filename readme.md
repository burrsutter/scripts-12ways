
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
./10_kafka_strimiz.sh
./12_create_cluster.sh
./13_create_topic.sh
./14_list_topics.sh

Terminal 1
./17_kafka_producer.sh

Terminal 2
./18_kafka_consumer.sh







20 - Helm Operator SDK


brew install kubernetes-helm

helm init
helm repo update
helm list


