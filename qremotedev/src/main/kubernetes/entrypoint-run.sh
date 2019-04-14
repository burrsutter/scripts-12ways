#!/bin/sh
git clone $PROJECT_URL project
cd project/$PROJECT_PATH
mvn compile quarkus:dev