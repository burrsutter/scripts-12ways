#!/bin/bash
INGRESSGATEWAY=istio-ingressgateway
IP_ADDRESS="$(minikube -p 12ways ip):$(kubectl get svc $INGRESSGATEWAY --namespace istio-system --output 'jsonpath={.spec.ports[?(@.port==80)].nodePort}')"
HOST_URL=$(kubectl get routes.serving.knative.dev qeventingservice -o jsonpath='{.status.domain}')

while true
do curl -H "Host: ${HOST_URL}" $IP_ADDRESS \
   -H "Content-Type: application/json" \
   -d '{"message": "Waasssup"}'
echo   
sleep .3
done