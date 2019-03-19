#!/bin/bash

kubectl exec -it my-cluster-kafka-0 -- bin/kafka-topics.sh --list --zookeeper localhost:2181