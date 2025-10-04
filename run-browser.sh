#!/bin/sh
# Script to build and run the browser version of Number Guessing Game

echo "Building TeaVM version..."
./gradlew buildTeaVM

if [ $? -eq 0 ]; then
    echo ""
    echo "Build successful!"
    echo "Opening browser version..."
    echo ""
    
    # Detect OS and open browser
    if command -v xdg-open > /dev/null; then
        # Linux
        xdg-open app/build/teavm/index.html
    elif command -v open > /dev/null; then
        # macOS
        open app/build/teavm/index.html
    elif command -v start > /dev/null; then
        # Windows
        start app/build/teavm/index.html
    else
        echo "Could not detect how to open browser on this system."
        echo "Please manually open: app/build/teavm/index.html"
    fi
else
    echo ""
    echo "Build failed. Please check the error messages above."
    exit 1
fi
