#!/bin/sh

# SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# Script to create a Fedora/RPM package (.rpm) for Number Guessing Game
# This package can be installed on Fedora, RHEL, CentOS, and other RPM-based distributions
# Usage: ./package-rpm.sh
# Output: NumberGuessingGame.rpm

# Exit immediately if any command fails
set -e

echo "Building Number Guessing Game RPM package..."

# Check if rpmbuild is installed
if ! command -v rpmbuild >/dev/null 2>&1; then
    echo "Error: rpmbuild not found. Please install rpm-build:"
    echo "  Fedora/RHEL: sudo dnf install rpm-build"
    echo "  Ubuntu/Debian: sudo apt install rpm"
    exit 1
fi

# Clean up any previous build artifacts
echo "Cleaning up previous builds..."
rm -rf ~/rpmbuild/RPMS/noarch/numberguessinggame-*.rpm
rm -rf ~/rpmbuild/BUILD/numberguessinggame-*
rm -rf ~/rpmbuild/BUILDROOT/numberguessinggame-*
rm -f NumberGuessingGame.rpm

# Build the application using Gradle
echo "Building application..."
./gradlew build

# Create RPM build directory structure
echo "Setting up RPM build environment..."
mkdir -p ~/rpmbuild/BUILD
mkdir -p ~/rpmbuild/RPMS
mkdir -p ~/rpmbuild/SOURCES
mkdir -p ~/rpmbuild/SPECS
mkdir -p ~/rpmbuild/SRPMS

# Copy the spec file to the SPECS directory
echo "Copying spec file..."
cp fedora-package/SPECS/numberguessinggame.spec ~/rpmbuild/SPECS/numberguessinggame.spec

# Copy the JAR file to the SOURCES directory
echo "Copying JAR file..."
cp app/build/libs/app-all.jar ~/rpmbuild/SOURCES/game.jar

# Build the RPM package
echo "Building RPM package..."
rpmbuild -bb ~/rpmbuild/SPECS/numberguessinggame.spec

# Copy the built RPM to the current directory
echo "Copying RPM package to current directory..."
cp ~/rpmbuild/RPMS/noarch/numberguessinggame-*.rpm ./NumberGuessingGame.rpm

# Display success message with installation instructions
echo ""
echo "✓ RPM package created: $(ls NumberGuessingGame.rpm)"
echo ""
echo "To install on Fedora/RHEL/CentOS, run:"
echo "  sudo dnf install ./NumberGuessingGame.rpm"
echo ""
echo "Or on older systems:"
echo "  sudo yum install ./NumberGuessingGame.rpm"
echo ""
echo "After installation, run the game with:"
echo "  numberguessinggame"
echo ""
