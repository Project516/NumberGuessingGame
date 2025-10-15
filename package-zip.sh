#!/bin/sh

rm -rf NumberGuessingGame
rm -rf temp
rm -f archive.zip
cd app
gradle build
cd ..
mkdir NumberGuessingGame
cp -r app/build/libs/app.jar NumberGuessingGame/game.jar
cp -r scripts/run.bat NumberGuessingGame/run.bat
cp -r scripts/run.sh NumberGuessingGame/run.sh
cp -r README.md NumberGuessingGame/README.txt
cp -r LICENSE NumberGuessingGame/LICENSE
zip -r archive.zip NumberGuessingGame/
rm -rf NumberGuessingGame
