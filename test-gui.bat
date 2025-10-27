@echo off
REM Quick test script for GUI mode (Windows)
REM This script runs the graphical version of the game
REM Note: You must build the project first with gradlew.bat build

REM Run the game in GUI mode (default - opens a window)
java -jar app/build/libs/app.jar

@pause
