# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game will tell you if your guess is too high or too low until you find the correct number.

## For End Users

### Requirements

- Java 8 or higher

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

## For Developers

### Requirements

- Java 8 or higher (Eclipse Temurin recommended)
- Gradle

### Development Setup

Install SDKMAN! and run:

```
sdk install java 25-tem
sdk install gradle
```

Or install Eclipse Temurin JDK directly from https://adoptium.net/

### Building

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

Run `./package.sh` from the project root. This will create `archive.zip` containing the application and run scripts.
