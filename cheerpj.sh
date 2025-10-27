#!/bin/sh

./gradlew build
rm -f cheerpj/app.jar
cp app/build/libs/app.jar cheerpj
mkdir -p app/build/docs/javadoc/cheerpj
cp -f cheerpj/* app/build/docs/javadoc/cheerpj/
