#!/bin/bash

kubectl logs $(kubectl get pod -l app=qremotedev -o 'jsonpath={.items[0].metadata.name}') -f
