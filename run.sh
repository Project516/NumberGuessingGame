#!/bin/sh

cd app
gradle build
java -jar build/libs/app.jar