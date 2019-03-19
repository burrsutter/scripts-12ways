#!/bin/bash

kubectl create namespace franz

kubens franz

curl -L https://github.com/strimzi/strimzi-kafka-operator/releases/download/0.11.1/strimzi-cluster-operator-0.11.1.yaml \
  | sed 's/namespace: .*/namespace: franz/' \
  | kubectl -n franz apply -f -

  