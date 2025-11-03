#!/bin/sh
# Script to create a Linux package with bundled JRE for Number Guessing Game
# This creates a self-contained package that doesn't require Java to be installed
# Output: NumberGuessingGame-linux.tar.xz

# Exit immediately if any command fails
set -e

echo "Building Number Guessing Game for Linux with bundled JRE..."

# Configuration
PACKAGE_NAME="NumberGuessingGame-linux"
JRE_DIR="jre-linux"
ADOPTIUM_BASE_URL="https://api.adoptium.net/v3/binary/latest/8/ga"

# Clean up any previous builds
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}
rm -f ${PACKAGE_NAME}.tar.xz
rm -f ${PACKAGE_NAME}.tar.gz

# Build the application using Gradle
echo "Building application..."
./gradlew build

# Download JRE for Linux from Eclipse Adoptium
echo "Downloading JRE for Linux..."
mkdir -p ${JRE_DIR}
curl -L "${ADOPTIUM_BASE_URL}/linux/x64/jre/hotspot/normal/eclipse?project=jdk" -o ${JRE_DIR}/jre-linux.tar.gz

# Extract the downloaded JRE
echo "Extracting JRE..."
cd ${JRE_DIR}
tar -xzf jre-linux.tar.gz
JRE_EXTRACTED=$(ls -d jdk* 2>/dev/null || ls -d jre* 2>/dev/null)
cd ..

# Create package directory structure
echo "Creating package structure..."
mkdir -p ${PACKAGE_NAME}
cp app/build/libs/app-all.jar ${PACKAGE_NAME}/game.jar
cp README.md ${PACKAGE_NAME}/README.txt
cp LICENSE ${PACKAGE_NAME}/LICENSE

# Copy the JRE into the package
echo "Copying JRE into package..."
cp -r ${JRE_DIR}/${JRE_EXTRACTED} ${PACKAGE_NAME}/jre

# Create a shell script that uses the bundled JRE
cat > ${PACKAGE_NAME}/run.sh << 'EOF'
#!/bin/sh

# Get the directory where the script is located
SCRIPT_DIR="$(cd "$(dirname "$0")" && pwd)"

"${SCRIPT_DIR}/jre/bin/java" -jar "${SCRIPT_DIR}/game.jar"
EOF

# Make the run script executable
chmod +x ${PACKAGE_NAME}/run.sh

# Create the final tar.xz archive with maximum compression
echo "Creating tar.xz archive..."
tar -cJf ${PACKAGE_NAME}.tar.xz ${PACKAGE_NAME}/

# Clean up temporary directories
rm -rf ${PACKAGE_NAME}
rm -rf ${JRE_DIR}

echo ""
echo "✓ Linux package with bundled JRE created: ${PACKAGE_NAME}.tar.xz"
echo ""
