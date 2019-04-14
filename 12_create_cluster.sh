#!/bin/bash

kubectl apply -f kafka-kubernetes/my-cluster.yaml

echo 'wait for my-cluster-entity-operator*'

kubectl get pods

