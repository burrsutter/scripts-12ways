#!/bin/bash

KAFKAPORT=$(kubectl get service my-cluster-kafka-0 -o 'jsonpath={.spec.ports[0].port}')
echo $KAFKAPORT

kubectl run kafkacat --rm -it --image=burrsutter/kafkacat --image-pull-policy=Never -- kafkacat -P -b my-cluster-kafka-0:$KAFKAPORT -t my-topic
