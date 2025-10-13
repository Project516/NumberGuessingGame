#!/bin/sh
# Script to create a Debian package (.deb) for Number Guessing Game

set -e

echo "Building Number Guessing Game Debian package..."

# Clean up previous builds
rm -rf debian-package/usr/share/games/numberguessinggame/*
rm -f numberguessinggame.deb

# Build the application
echo "Building application..."

gradle build

# Copy the jar file
echo "Copying files to package directory..."
cp app/build/libs/app.jar debian-package/usr/share/games/numberguessinggame/game.jar

# Copy documentation
cp README.md debian-package/usr/share/games/numberguessinggame/README.md
cp LICENSE debian-package/usr/share/games/numberguessinggame/LICENSE

# Set permissions
chmod 755 debian-package/DEBIAN
chmod 755 debian-package/DEBIAN/postinst
chmod 755 debian-package/usr/games/numberguessinggame

# Build the .deb package
echo "Building .deb package..."
dpkg-deb --build debian-package numberguessinggame.deb

echo ""
echo "✓ Debian package created: numberguessinggame.deb"
echo ""
echo "To install, run:"
echo "  sudo apt install ./numberguessinggame.deb"
echo "  sudo apt-get install -f  # to install any missing dependencies"
echo ""
echo "After installation, run the game with:"
echo "  numberguessinggame"
echo ""
