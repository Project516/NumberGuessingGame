# TeaVM Web Version

This directory contains the web browser version of the Number Guessing Game, compiled from Java to JavaScript using TeaVM.

## What is TeaVM?

TeaVM is an ahead-of-time compiler for Java bytecode that emits JavaScript. It allows running Java applications in web browsers without requiring a Java plugin or JVM.

## Files

- `index.html` - The main HTML page that loads and runs the game
- `classes.js` - The compiled JavaScript (generated during build, not committed to git)

## Building

To build the TeaVM version:

```bash
./teavm.sh
```

This script will:
1. Build the project
2. Compile the WebGUI class to JavaScript using TeaVM
3. Copy the output to `app/build/docs/javadoc/teavm/` for deployment

## Implementation

The web version uses `WebGUI.java` which:
- Implements a browser-native UI using TeaVM's JSO (JavaScript Objects) API
- Reuses the core game logic classes (`RandomNumber`, `CheckGuess`, etc.)
- Creates DOM elements dynamically for the game interface
- Provides the same gameplay experience as the Swing GUI

## Deployment

The TeaVM version is automatically deployed to GitHub Pages via the `javadoc.yml` workflow whenever changes are pushed to the master branch.

## Technical Details

- **TeaVM Version**: 0.10.2
- **Plugin**: io.github.zebalu.teavm-gradle-plugin v1.0.0
- **Main Class**: `io.github.project516.NumberGuessingGame.WebGUI`
- **Target**: JavaScript
- **Java Version Required**: 11+ (for compilation)
