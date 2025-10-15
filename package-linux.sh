#!/bin/sh
# Script to create a Linux package with bundled JRE for Number Guessing Game

set -e

echo "Building Number Guessing Game for Linux with bundled JRE..."

# Configuration
PACKAGE_NAME="NumberGuessingGame-linux"
JRE_DIR="jre-linux"
ADOPTIUM_BASE_URL="https://api.adoptium.net/v3/binary/latest/25/ga"

# Clean up previous builds
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}
rm -f ${PACKAGE_NAME}.tar.gz

# Build the application
echo "Building application..."
./gradlew build

# Download JRE for Linux
echo "Downloading JRE for Linux..."
mkdir -p ${JRE_DIR}
curl -L "${ADOPTIUM_BASE_URL}/linux/x64/jre/hotspot/normal/eclipse?project=jdk" -o ${JRE_DIR}/jre-linux.tar.gz

# Extract JRE
echo "Extracting JRE..."
cd ${JRE_DIR}
tar -xzf jre-linux.tar.gz
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

# Create run.sh that uses bundled JRE
cat > ${PACKAGE_NAME}/run.sh << 'EOF'
#!/bin/sh

# Get the directory where the script is located
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

"${SCRIPT_DIR}/jre/bin/java" -jar "${SCRIPT_DIR}/game.jar"
EOF

chmod +x ${PACKAGE_NAME}/run.sh

# Create the tar.gz archive
echo "Creating tar.gz archive..."
tar -czf ${PACKAGE_NAME}.tar.gz ${PACKAGE_NAME}/

# Clean up
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}

echo ""
echo "✓ Linux package with bundled JRE created: ${PACKAGE_NAME}.tar.gz"
echo ""
