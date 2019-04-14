#!/bin/sh
git clone $PROJECT_URL project
cd project
mvn compile quarkus:dev