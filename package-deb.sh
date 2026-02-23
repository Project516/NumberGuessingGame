#!/bin/sh

# SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# Script to create a Debian package (.deb) for Number Guessing Game
# This package can be installed on Debian-based Linux distributions (Ubuntu, Mint, etc.)
# Usage: ./package-deb.sh
# Output: NumberGuessingGame.deb

# Exit immediately if any command fails
set -e

echo "Building Number Guessing Game Debian package..."

# Clean up any previous build artifacts
echo "Cleaning up previous builds..."
rm -rf debian-package/usr/share/games/numberguessinggame/*
rm -f NumberGuessingGame.deb

# Build the application using Gradle
echo "Building application..."

./gradlew build

# Copy the compiled JAR file to the package directory
echo "Copying files to package directory..."
cp app/build/libs/app-all.jar debian-package/usr/share/games/numberguessinggame/game.jar

# Copy documentation files
cp README.md debian-package/usr/share/games/numberguessinggame/README.md
cp LICENSE debian-package/usr/share/games/numberguessinggame/LICENSE

# Set correct permissions for Debian package
echo "Setting file permissions..."
chmod 755 debian-package/DEBIAN
chmod 755 debian-package/DEBIAN/postinst
chmod 755 debian-package/usr/games/numberguessinggame

# Build the .deb package using dpkg-deb
echo "Building .deb package..."
dpkg-deb --build debian-package NumberGuessingGame.deb

# Display success message with installation instructions
echo ""
echo "✓ Debian package created: NumberGuessingGame.deb"
echo ""
echo "To install, run:"
echo "  sudo apt install ./NumberGuessingGame.deb"
echo "  sudo apt install -f  # to install any missing dependencies"
echo ""
echo "After installation, run the game with:"
echo "  numberguessinggame"
echo ""
