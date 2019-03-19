#!/bin/bash

minikube start -p 12ways --memory=8192 --cpus=3 \
  --kubernetes-version=v1.12.0 \
  --vm-driver=virtualbox \
  --disk-size=30g \

  echo 'eval $(minikube -p 12ways docker-env)'