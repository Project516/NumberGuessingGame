#!/bin/sh
# Script to build a Flatpak for Number Guessing Game
# This script is for local testing. For Flathub submission, the manifest should be submitted to:
# https://github.com/flathub/flathub

set -e

echo "Building Number Guessing Game Flatpak..."

# Check if flatpak-builder is installed
if ! command -v flatpak-builder >/dev/null 2>&1; then
    echo "Error: flatpak-builder is not installed."
    echo "Install it with: sudo apt install flatpak-builder"
    exit 1
fi

# Build the application first
echo "Building application..."
./gradlew build

# Build the Flatpak
echo "Building Flatpak package..."
flatpak-builder --force-clean --repo=repo build-dir io.github.project516.NumberGuessingGame.yml

echo ""
echo "✓ Flatpak built successfully!"
echo ""
echo "To install locally, run:"
echo "  flatpak-builder --user --install --force-clean build-dir io.github.project516.NumberGuessingGame.yml"
echo ""
echo "To run the installed app:"
echo "  flatpak run io.github.project516.NumberGuessingGame"
echo ""
echo "For Flathub submission, submit the manifest file to:"
echo "  https://github.com/flathub/flathub"
echo ""
