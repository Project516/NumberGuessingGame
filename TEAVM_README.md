# TeaVM Support for Number Guessing Game

This project now supports compilation to JavaScript using [TeaVM](https://teavm.org/), allowing the game to run directly in a web browser!

## What is TeaVM?

TeaVM is a Java bytecode to JavaScript/WebAssembly compiler. It allows you to write Java code and run it in the browser without plugins.

## Building the Browser Version

To compile the Java code to JavaScript:

```bash
./gradlew buildTeaVM
```

This will:
1. Compile the Java code
2. Use TeaVM to convert it to JavaScript
3. Copy the HTML page and resources
4. Output everything to `app/build/teavm/`

## Running the Browser Version

After building, open the generated HTML file in your browser:

```bash
# On Linux
xdg-open app/build/teavm/index.html

# On macOS
open app/build/teavm/index.html

# On Windows
start app/build/teavm/index.html
```

Or use a local web server:

```bash
cd app/build/teavm
python3 -m http.server 8000
# Then open http://localhost:8000 in your browser
```

## Architecture

### Browser-Specific Code

The browser version uses a separate entry point (`BrowserMain.java`) instead of the console version (`Main.java`). This is necessary because:

1. **Input Handling**: The browser doesn't support `Scanner` for console input. Instead, we use HTML input fields and buttons.
2. **Asynchronous Nature**: Browser applications are event-driven rather than procedural.
3. **Output**: While `System.out.println()` works in TeaVM (it prints to the browser console), we also redirect it to an on-screen div for better user experience.

### Key Files

- **`BrowserMain.java`**: Browser-specific entry point with exported methods
- **`src/main/webapp/index.html`**: HTML page that hosts the game
- **Build configuration**: Custom Gradle tasks in `build.gradle`

### Shared Code

The core game logic is shared between console and browser versions:
- `RandomNumber.java`: Generates random numbers
- `SystemInfo.java`: System information (used in console version)

## Development Notes

### TeaVM Version

This project uses TeaVM 0.10.0 with manual task configuration instead of the Gradle plugin due to compatibility issues with Gradle 9.

### Limitations

- The `@JSExport` annotation is used to make Java methods callable from JavaScript
- System properties (like in `SystemInfo.java`) may not work the same in the browser
- The game state is maintained in static fields and resets only on page refresh

### Customization

To modify the game:
1. Edit `BrowserMain.java` for browser-specific logic
2. Edit `index.html` for UI changes
3. Run `./gradlew buildTeaVM` to rebuild
4. Refresh your browser to see changes

## Gradle Tasks

- **`compileToJs`**: Compiles Java to JavaScript using TeaVM
- **`copyTeaVMResources`**: Copies HTML and resources to output directory
- **`buildTeaVM`**: Complete build (runs both of the above)

## Troubleshooting

### Build Fails

If the build fails, try:
```bash
./gradlew clean buildTeaVM --no-configuration-cache
```

### JavaScript Errors

Check the browser console (F12) for error messages. The generated `NumberGuessingGame.js` includes source maps for debugging.

### Game Not Loading

Ensure you're opening the HTML file through a web server (not `file://`) if you encounter issues with loading JavaScript files.

## Resources

- [TeaVM Official Website](https://teavm.org/)
- [TeaVM Documentation](https://teavm.org/docs/)
- [TeaVM GitHub](https://github.com/konsoletyper/teavm)
