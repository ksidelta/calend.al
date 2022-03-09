#!/usr/bin/env bash
COMMIT=`git rev-parse HEAD`
IMAGE_NAME="ksidelta-calendal-backend" 
REPOSITORY="psuwala"

docker build . -t $REPOSITORY/$IMAGE_NAME:$COMMIT
docker image push $REPOSITORY/$IMAGE_NAME:$COMMIT
