@echo off
REM Quick test script for console mode (Windows)
REM This script runs the console version of the game
REM Note: Run gradlew.bat build first to compile the project

REM Run the game in console mode (text-based interface)
java -jar app/build/libs/app.jar --console

@pause
