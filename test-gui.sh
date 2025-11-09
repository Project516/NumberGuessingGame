#!/bin/sh

# SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# Quick test script for GUI mode
# This script builds the project and runs the graphical version of the game

# Build the project using Gradle
./gradlew build

# Run the game in GUI mode (default - opens a window)
java -jar app/build/libs/app-all.jar
