#!/bin/bash

MINIKUBE_IP=$(minikube -p 12ways ip)
# echo $MINIKUBE_IP

NODE_PORT=$(kubectl get service/qremotedev -o jsonpath="{.spec.ports[*].nodePort}")
# echo $NODE_PORT

REMOTE_URL="http://"$MINIKUBE_IP":"$NODE_PORT

echo $REMOTE_URL

curl $REMOTE_URL/api

