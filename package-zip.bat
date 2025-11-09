REM SPDX-FileCopyrightText: 2024 Project516 <138796702+Project516@users.noreply.github.com>
REM
REM SPDX-License-Identifier: GPL-3.0-or-later

@echo off
REM Creates a distributable ZIP archive of the game (Windows)
REM This archive requires Java to be installed on the user's system

REM Clean up any previous builds
rmdir /s /q NumberGuessingGame 2>nul
rmdir /s /q temp 2>nul
del /f archive.zip 2>nul

REM Create distribution directory structure
mkdir NumberGuessingGame

REM Copy the game JAR and necessary files
copy app\build\libs\app-all.jar NumberGuessingGame\game.jar
copy scripts\run.bat NumberGuessingGame\run.bat
copy scripts\run.sh NumberGuessingGame\run.sh
copy README.md NumberGuessingGame\README.txt
copy LICENSE NumberGuessingGame\LICENSE

REM Create the ZIP archive using PowerShell with maximum compression
powershell -command "Compress-Archive -Path NumberGuessingGame -DestinationPath archive.zip -CompressionLevel Optimal -Force"

REM Clean up temporary directory
rmdir /s /q NumberGuessingGame

@pause