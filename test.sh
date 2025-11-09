#!/bin/sh

# SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# Quick test script for console mode
# This script builds the project and runs the console version of the game

# Build the project using Gradle
./gradlew build

# Run the game in console mode (text-based interface)
java -jar app/build/libs/app-all.jar --console
