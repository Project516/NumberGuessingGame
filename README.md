# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game will tell you if your guess is too high or too low until you find the correct number.

## Installation & Running

### Installation via Debian Package (Linux)

For Debian/Ubuntu and derivatives (recommended for terminal usage):

1. Download the `.deb` package from the [latest release](https://github.com/Project516/NumberGuessingGame/releases)

   You can use curl to do it from the command line:
   ```bash
   curl -s -L -o numberguessingame.deb https://github.com/Project516/NumberGuessingGame/releases/download/0.0.x/numberguessinggame.deb
   ```
   where `x` is the version you want.
3. Install it:
   ```bash
   sudo apt update # Update packages
   sudo apt install ./numberguessinggame.deb # From directory with the deb package
   sudo apt install -f  # Install dependencies
   ```
4. Run from anywhere in your terminal:
   ```bash
   numberguessinggame
   ```

To uninstall:
```bash
sudo apt remove numberguessinggame
sudo apt autoremove -y # Remove dependencies
```

### Manual Installation

#### Requirements

- Java 8 or higher (may require Java 17+ in future versions)

#### How to Run

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh`

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

### Running Tests

```
gradle test
```

### Creating Release Archives

#### Zip Archive

**On Windows:**
Run `.\gradlew build` and `.\package.bat` from the project root.

**On Linux/Mac:**
Run `./package.sh` from the project root.

This will create `archive.zip` containing the application, run scripts, README, and LICENSE. The archive can be released to GitHub Releases.

#### Debian Package

**On Linux:**
Run `./package-deb.sh` from the project root.

This will create `numberguessinggame.deb` which can be installed via `apt`/`dpkg` on Debian-based systems. The package can be released to GitHub Releases for easy distribution.
