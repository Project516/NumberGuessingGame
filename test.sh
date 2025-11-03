#!/bin/sh
# Quick test script for console mode
# This script builds the project and runs the console version of the game

# Build the project using Gradle
./gradlew build

# Run the game in console mode (text-based interface)
java -jar app/build/libs/app-all.jar --console
