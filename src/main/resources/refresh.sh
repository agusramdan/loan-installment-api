#!/bin/sh

curl localhost:7180/actuator/refresh -d {} -H "Content-Type: application/json"
