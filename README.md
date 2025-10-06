# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game will tell you if your guess is too high or too low until you find the correct number.

## Running the Game

### Requirements

- Java 8 or higher (may require Java 17+ in future versions)

### How to Run

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh` or execute `java -jar app.jar`

### How to Play

1. Start the game using one of the methods above
2. Enter your guess when prompted
3. The game will tell you if your guess is too high or too low
4. Keep guessing until you find the correct number
5. The game will display how many guesses it took you

## Development

### Requirements

- Java 25 (Eclipse Temurin recommended for development)
- Gradle

### Development Setup

SDKMAN is the recommended way to install Java and Gradle (pre-installed in GitHub Codespaces):

```
sdk install java 25-tem
sdk install gradle
```

Alternatively, install Eclipse Temurin JDK directly from https://adoptium.net/

### Building

From the project root:
```
gradle build
```

Or from the app directory:
```
cd app
gradle build
```

### Running Tests

```
cd app
gradle test
```

### Creating Release Archive

Run `./package.sh` from the project root. This will create `archive.zip` containing the application, run scripts, and README. The archive can be released to GitHub Releases.
