REM SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
REM
REM SPDX-License-Identifier: GPL-3.0-or-later

@echo off
REM Quick test script for GUI mode (Windows)
REM This script runs the graphical version of the game
REM Note: Run gradlew.bat build first to compile the project

REM Run the game in GUI mode (default - opens a window)
java -jar app/build/libs/app-all.jar

@pause
