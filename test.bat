@echo off
REM Quick test script for console mode (Windows)
REM This script runs the console version of the game
REM Note: You must build the project first with gradlew.bat build

REM Run the game in console mode (text-based interface)
java -jar app/build/libs/app.jar --console

@pause
