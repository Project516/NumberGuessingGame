#!/bin/sh

rm -rf temp
cd app
gradle build
cd ..
mkdir temp
cp -r app/build/libs/app.jar temp/app.jar
cp -r scripts/run.bat temp/run.bat
cp -r scripts/run.sh temp/run.sh
zip -r archive.zip temp/
rm -rf temp
