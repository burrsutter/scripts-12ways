#!/bin/bash

echo 'correct usage is source 0_setenv.sh'

export MINIKUBE_HOME=/Users/burrsutter/minikube_1.0.0/bin;
export PATH=$MINIKUBE_HOME:$PATH
export KUBECONFIG=$MINIKUBE_HOME/.kube/config:$MINIKUBE_HOME/.kube/kubconfig2
export KUBE_EDITOR="code -w"

# https://github.com/GoogleContainerTools/krew
# export PATH="${KREW_ROOT:-$HOME/.krew}/bin:$PATH"

echo 'the following after minikube as started'
echo 'eval $(minikube -p 12ways docker-env)'