#!/bin/bash

KAFKACATPOD=$(kubectl get pod -l run=kafkacat -o 'jsonpath={.items[0].metadata.name}')
KAFKAPORT=$(kubectl get service my-cluster-kafka-0 -o 'jsonpath={.spec.ports[0].port}')
echo $KAFKAPORT

kubectl exec -it $KAFKACATPOD -- kafkacat -C -b my-cluster-kafka-0:$KAFKAPORT -t my-topic
