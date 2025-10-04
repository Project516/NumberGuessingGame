# NumberGuessingGame

A simple number guessing game written in Java, available in two versions:
- **Console Version**: Traditional command-line interface
- **Browser Version**: Web-based version compiled with TeaVM

### Java 21 is required!

## Running the Console Version

```bash
./gradlew run
```

## Building for the Browser (TeaVM)

This game can also run in your web browser, compiled from Java to JavaScript using TeaVM:

```bash
./gradlew buildTeaVM
```

Then open `app/build/teavm/index.html` in your browser.

For detailed information about the TeaVM version, see [TEAVM_README.md](TEAVM_README.md).