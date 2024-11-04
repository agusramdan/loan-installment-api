#!/bin/sh
#
# $PG_PASSWORD
cd target
nohup java -Xmx256M -jar loan-instalment-api-2024.0.1.jar --spring.profiles.active=pg --spring.datasource.password=$PG_PASSWORD &> /dev/null &
