#!/bin/sh
# Script to create a Windows package with bundled JRE for Number Guessing Game

set -e

echo "Building Number Guessing Game for Windows with bundled JRE..."

# Configuration
PACKAGE_NAME="NumberGuessingGame-windows"
JRE_DIR="jre-windows"
ADOPTIUM_BASE_URL="https://api.adoptium.net/v3/binary/latest/21/ga"

# Clean up previous builds
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}
rm -f ${PACKAGE_NAME}.zip

# Build the application
echo "Building application..."
./gradlew build

# Download JRE for Windows
echo "Downloading JRE for Windows..."
mkdir -p ${JRE_DIR}
curl -L "${ADOPTIUM_BASE_URL}/windows/x64/jre/hotspot/normal/eclipse?project=jdk" -o ${JRE_DIR}/jre-windows.zip

# Extract JRE
echo "Extracting JRE..."
cd ${JRE_DIR}
unzip -q jre-windows.zip
JRE_EXTRACTED=$(ls -d jdk* 2>/dev/null || ls -d jre* 2>/dev/null)
cd ..

# Create package directory structure
echo "Creating package structure..."
mkdir -p ${PACKAGE_NAME}
cp app/build/libs/app.jar ${PACKAGE_NAME}/game.jar
cp README.md ${PACKAGE_NAME}/README.txt
cp LICENSE ${PACKAGE_NAME}/LICENSE

# Copy JRE into package
echo "Copying JRE into package..."
cp -r ${JRE_DIR}/${JRE_EXTRACTED} ${PACKAGE_NAME}/jre

# Create run.bat that uses bundled JRE
cat > ${PACKAGE_NAME}/run.bat << 'EOF'
@echo off

jre\bin\java.exe -jar game.jar

@pause
EOF

# Create the zip archive
echo "Creating zip archive..."
zip -r ${PACKAGE_NAME}.zip ${PACKAGE_NAME}/

# Clean up
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}

echo ""
echo "✓ Windows package with bundled JRE created: ${PACKAGE_NAME}.zip"
echo ""
