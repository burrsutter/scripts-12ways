#!/bin/bash

kubectl apply -f kubefiles/my-cluster.yaml

echo 'wait for my-cluster-entity-operator*'

kubectl get pods

