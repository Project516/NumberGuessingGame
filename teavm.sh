#!/bin/sh
# Script to build TeaVM JavaScript output for GitHub Pages deployment
# This replaces the cheerpj.sh script

echo "Building project..."
./gradlew build

echo "Compiling Java to JavaScript with TeaVM..."
# Disable configuration cache due to TeaVM plugin compatibility
./gradlew teavmc --no-configuration-cache

echo "Copying TeaVM output to javadoc directory..."
mkdir -p app/build/docs/javadoc/teavm
cp -f app/build/teavm/classes.js app/build/docs/javadoc/teavm/
cp -f teavm/index.html app/build/docs/javadoc/teavm/

echo "TeaVM build completed successfully!"
echo "Output location: app/build/docs/javadoc/teavm/"
