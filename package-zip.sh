#!/bin/sh

# SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# Creates a distributable ZIP archive of the game
# This archive requires Java to be installed on the user's system

# Clean up any previous builds
rm -rf NumberGuessingGame
rm -rf temp
rm -f archive.zip

# Build the application
cd app
gradle build
cd ..

# Create distribution directory structure
mkdir NumberGuessingGame

# Copy the game JAR and necessary files
cp -r app/build/libs/app-all.jar NumberGuessingGame/game.jar
cp -r scripts/run.bat NumberGuessingGame/run.bat
cp -r scripts/run.sh NumberGuessingGame/run.sh
cp -r README.md NumberGuessingGame/README.txt
cp -r LICENSE NumberGuessingGame/LICENSE

# Create the ZIP archive with maximum compression
zip -9 -r archive.zip NumberGuessingGame/

# Clean up temporary directory
rm -rf NumberGuessingGame
