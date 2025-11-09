REM SPDX-FileCopyrightText: 2025 Project516 <138796702+Project516@users.noreply.github.com>
REM
REM SPDX-License-Identifier: GPL-3.0-or-later

@echo off
REM Quick test script for console mode (Windows)
REM This script runs the console version of the game
REM Note: Run gradlew.bat build first to compile the project

REM Run the game in console mode (text-based interface)
java -jar app/build/libs/app-all.jar --console

@pause
