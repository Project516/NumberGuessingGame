<<<<<<< HEAD
# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game features both a user-friendly graphical user interface (GUI) and a classic console mode.

**Features:**
- Swing-based GUI (default)
- Console mode (use `--console` flag)
- High score tracking with usernames
- Persistent score storage
- Cross-platform

## Installation & Running

### Installation via Debian Package (APT)

For Debian/Ubuntu and derivatives (recommended for terminal usage):

1. Download the `.deb` package from the [latest release](https://github.com/Project516/NumberGuessingGame/releases)

   You can use curl to do it from the command line:
   ```bash
   curl -s -L -o numberguessingame.deb https://github.com/Project516/NumberGuessingGame/releases/download/0.x.y/numberguessinggame.deb
   ```
   where `x` and `y` is the version you want.
2. Install it:
   ```bash
   sudo apt update # Update packages
   sudo apt install ./numberguessinggame.deb # From directory with the deb package
   sudo apt install -f  # Install dependencies
   echo 'export PATH=$PATH:/usr/games' >> ~/.bashrc # Add games directory to user PATH
   source ~/.bashrc
   ```
3. Run from anywhere in your terminal:
   ```bash
   numberguessinggame
   ```

To uninstall:
```bash
sudo apt remove numberguessinggame
sudo apt autoremove -y # Remove dependencies
```

### Standalone Packages with Bundled JRE (Recommended)

Download the platform-specific package with bundled JRE from the [latest release](https://github.com/project516/numberguessinggame/releases):

- **Windows**: `NumberGuessingGame-windows.zip`
- **macOS**: `NumberGuessingGame-macos.zip`
- **Linux**: `NumberGuessingGame-linux.tar.xz`

Extract the downloaded archive and run:

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh`

### Manual Installation (Requires Java)

Download the `archive.zip` from the [latest release](https://github.com/project516/numberguessinggame/releases)

#### Requirements

- Java 8 or higher

#### How to Run

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh`

### How to Play

The game features both a graphical user interface (GUI) and a console mode.

#### GUI Mode (Default)

1. Start the game using one of the methods above
2. A window will appear with the game interface
3. Enter your guess in the text field and click "Submit Guess" or press Enter
4. The game will provide visual feedback:
   - Blue text indicates your guess was too low
   - Orange text indicates your guess was too high
   - Green text indicates you guessed correctly!
5. The number of guesses is displayed and updated in real-time
6. When you guess correctly, you'll be prompted to enter your username
7. After entering your username, your score will be saved and the top high scores will be displayed
8. Click "New Game" to play again
9. Use the menu bar for additional options:
   - File → New Game (Ctrl+N): Start a new game
   - File → Exit: Close the application
   - View → High Scores: View the top high scores
   - Help → About: View game information

#### Console Mode

To run the classic console version, use the `--console` or `-c` flag:

```bash
java -jar app.jar --console
# or
./run.sh --console  # Linux/Mac
run.bat --console   # Windows
```

In console mode:
1. Enter your guess when prompted
2. The game will tell you if your guess is too high or too low
3. Keep guessing until you find the correct number
4. The game will display how many guesses it took you
5. Enter your username when prompted to save your score
6. The top high scores will be displayed after saving your score

### High Scores

The game automatically tracks high scores (games won with the least guesses). High scores are stored in your home directory at `~/.numberguessinggame/highscores.properties`.

- The top 10 scores are kept
- Scores are sorted by the number of guesses (least is best)
- Each score includes the username and number of guesses
- High scores persist across game sessions
- View high scores from the GUI menu (View → High Scores) or after completing a game

## Development

### Requirements

- Java 25 (Eclipse Temurin recommended for development)

### Development Setup

[SDKMAN!](https://sdkman.io) is the recommended way to install Java and Gradle:

```
sdk install java 25-tem
```

Alternatively, install Eclipse Temurin JDK directly from https://adoptium.net/

### Building

From the project root:
```
./gradlew build
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

#### Platform-Specific Packages with Bundled JRE

**On Linux:**
Run the following scripts to create platform-specific packages with bundled JRE:

```bash
./package-win.sh  # Creates NumberGuessingGame-windows.zip
./package-macos.sh    # Creates NumberGuessingGame-macos.zip
./package-linux.sh    # Creates NumberGuessingGame-linux.tar.xz
```

These packages include a bundled JRE and do not require Java to be installed on the target system. They are automatically built and uploaded to GitHub Releases via GitHub Actions.
=======
# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game features both a user-friendly graphical user interface (GUI) and a classic console mode. The GUI provides visual feedback with color-coded hints and tracks your progress in real-time.

**Features:**
- Swing-based GUI (default)
- Console mode (use `--console` flag)
- High score tracking with usernames
- Persistent score storage
- Cross-platform (Made in Java!)

## Installation & Running

### Installation via Debian Package (Linux)

For Debian/Ubuntu and derivatives (recommended for terminal usage):

1. Download the `.deb` package from the [latest release](https://github.com/Project516/NumberGuessingGame/releases)

   You can use curl to do it from the command line:
   ```bash
   curl -s -L -o numberguessingame.deb https://github.com/Project516/NumberGuessingGame/releases/download/0.x.y/numberguessinggame.deb
   ```
   where `x` and `y` is the version you want.
2. Install it:
   ```bash
   sudo apt update # Update packages
   sudo apt install ./numberguessinggame.deb # From directory with the deb package
   sudo apt install -f  # Install dependencies
   echo 'export PATH=$PATH:/usr/games' >> ~/.bashrc # Add games directory to user PATH
   source ~/.bashrc
   ```
3. Run from anywhere in your terminal:
   ```bash
   numberguessinggame
   ```

To uninstall:
```bash
sudo apt remove numberguessinggame
sudo apt autoremove -y # Remove dependencies
```

### Standalone Packages with Bundled JRE (Recommended)

Download the platform-specific package with bundled JRE from the [latest release](https://github.com/project516/numberguessinggame/releases):

- **Windows**: `NumberGuessingGame-windows.zip` (no Java installation required)
- **macOS**: `NumberGuessingGame-macos.zip` (no Java installation required)
- **Linux**: `NumberGuessingGame-linux.tar.xz` (no Java installation required)

Extract the downloaded archive and run:

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh`

### Manual Installation (Requires Java)

Download the `archive.zip` from the [latest release](https://github.com/project516/numberguessinggame/releases)

#### Requirements

- Java 8 or higher

#### How to Run

**On Windows:**
Run `run.bat`

**On Linux/Mac:**
Run `run.sh`

### How to Play

The game now features both a graphical user interface (GUI) and a console mode.

#### GUI Mode (Default)

1. Start the game using one of the methods above
2. A window will appear with the game interface
3. Enter your guess in the text field and click "Submit Guess" or press Enter
4. The game will provide visual feedback:
   - Blue text indicates your guess was too low
   - Orange text indicates your guess was too high
   - Green text indicates you guessed correctly!
5. The number of guesses is displayed and updated in real-time
6. When you guess correctly, you'll be prompted to enter your username
7. After entering your username, your score will be saved and the top high scores will be displayed
8. Click "New Game" to play again
9. Use the menu bar for additional options:
   - File → New Game (Ctrl+N): Start a new game
   - File → Exit: Close the application
   - View → High Scores: View the top high scores
   - Help → About: View game information

#### Console Mode

To run the classic console version, use the `--console` or `-c` flag:

```bash
java -jar app.jar --console
# or
./run.sh --console  # Linux/Mac
run.bat --console   # Windows
```

In console mode:
1. Enter your guess when prompted
2. The game will tell you if your guess is too high or too low
3. Keep guessing until you find the correct number
4. The game will display how many guesses it took you
5. Enter your username when prompted to save your score
6. The top high scores will be displayed after saving your score

### High Scores

The game automatically tracks high scores (games won with the fewest guesses). High scores are stored persistently in your home directory at `~/.numberguessinggame/highscores.properties`.

- The top 10 scores are kept
- Scores are sorted by the number of guesses (fewest is best)
- Each score includes the username and number of guesses
- High scores persist across game sessions
- View high scores from the GUI menu (View → High Scores) or after completing a game

## Development

### Requirements

- Java 25 (Eclipse Temurin recommended for development)
- Gradle

### Development Setup

[SDKMAN!](https://sdkman.io) is the recommended way to install Java and Gradle:

```
sdk install java 25-tem
```

Alternatively, install Eclipse Temurin JDK directly from https://adoptium.net/

### Building

From the project root:
```
./gradlew build
```

### Creating Release Archives

#### Zip Archive (Requires Java)

**On Windows:**
Run `.\gradlew build` and `.\package.bat` from the project root.

**On Linux/Mac:**
Run `./package.sh` from the project root.

This will create `archive.zip` containing the application, run scripts, README, and LICENSE. The archive can be released to GitHub Releases.

#### Debian Package

**On Linux:**
Run `./package-deb.sh` from the project root.

This will create `numberguessinggame.deb` which can be installed via `apt`/`dpkg` on Debian-based systems. The package can be released to GitHub Releases for easy distribution.

#### Platform-Specific Packages with Bundled JRE

**On Linux:**
Run the following scripts to create platform-specific packages with bundled JRE:

```bash
./package-win.sh  # Creates NumberGuessingGame-windows.zip
./package-macos.sh    # Creates NumberGuessingGame-macos.zip
./package-linux.sh    # Creates NumberGuessingGame-linux.tar.xz
```

These packages include a bundled JRE and do not require Java to be installed on the target system. They are automatically built and uploaded to GitHub Releases via GitHub Actions.
>>>>>>> parent of ad04a2e (readme fix)
