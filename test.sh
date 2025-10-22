#!/bin/sh

./gradlew build
java -jar app/build/libs/app.jar --console
