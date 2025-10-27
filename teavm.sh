#!/bin/sh
# Script to build TeaVM JavaScript output for GitHub Pages deployment
# TeaVM compiles Java bytecode to JavaScript for running in web browsers
# This script replaces the old cheerpj.sh approach
# Output: JavaScript files in app/build/docs/javadoc/teavm/

echo "Building project..."
./gradlew build

echo "Compiling Java to JavaScript with TeaVM..."
# Note: Configuration cache is disabled due to TeaVM plugin compatibility
./gradlew teavmc --no-configuration-cache

echo "Copying TeaVM output to javadoc directory..."
# Create output directory if it doesn't exist
mkdir -p app/build/docs/javadoc/teavm

# Copy generated JavaScript and HTML files
cp -f app/build/teavm/classes.js app/build/docs/javadoc/teavm/
cp -f teavm/index.html app/build/docs/javadoc/teavm/

echo "TeaVM build completed successfully!"
echo "Output location: app/build/docs/javadoc/teavm/"
