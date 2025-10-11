@echo off

rmdir /s /q NumberGuessingGame 2>nul
rmdir /s /q temp 2>nul
del /f archive.zip 2>nul
mkdir NumberGuessingGame
copy app\build\libs\app.jar NumberGuessingGame\game.jar
copy scripts\run.bat NumberGuessingGame\run.bat
copy scripts\run.sh NumberGuessingGame\run.sh
copy README.md NumberGuessingGame\README.txt
copy LICENSE NumberGuessingGame\LICENSE
powershell -command "Compress-Archive -Path NumberGuessingGame -DestinationPath archive.zip -Force"
rmdir /s /q NumberGuessingGame

@pause