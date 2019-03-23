#!/bin/bash

# Note: this does not work, must run producers/consumers, inside of Minikube

echo 'usage: source 15_ip_port.sh'

export KAFKA_IP=$(minikube -p 12ways ip)
export KAFKA_PORT=$(kubectl get svc my-cluster-kafka-external-bootstrap -o 'jsonpath={.spec.ports[0].nodePort}')