# Number Guessing Game

A simple number guessing game where you try to guess a randomly generated number. The game will tell you if your guess is too high or too low until you find the correct number.

## Installation & Running

### Installation via Flatpak (Linux - Cross-distro)

**Recommended for all Linux distributions:**

Once the app is published on Flathub, you can install it with:

```bash
flatpak install flathub io.github.project516.NumberGuessingGame
```

Run the game:
```bash
flatpak run io.github.project516.NumberGuessingGame
```

To uninstall:
```bash
flatpak uninstall io.github.project516.NumberGuessingGame
```

For more information about Flatpak, visit [flatpak.org](https://flatpak.org)

### Installation via Debian Package (Linux)

For Debian/Ubuntu and derivatives:

1. Download the `.deb` package from the [latest release](https://github.com/Project516/NumberGuessingGame/releases)
2. Install it:
   ```bash
   sudo dpkg -i numberguessinggame.deb
   sudo apt-get install -f  # Install dependencies if needed
   ```
3. Run from anywhere in your terminal:
   ```bash
   numberguessinggame
   ```

To uninstall:
```bash
sudo dpkg -r numberguessinggame
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
Run `.\gradlew build` and `package.bat` from the project root.

**On Linux/Mac:**
Run `./package.sh` from the project root.

This will create `archive.zip` containing the application, run scripts, and README. The archive can be released to GitHub Releases.

#### Debian Package

**On Linux:**
Run `./package-deb.sh` from the project root.

This will create `numberguessinggame.deb` which can be installed via `apt`/`dpkg` on Debian-based systems. The package can be released to GitHub Releases for easy distribution.

#### Flatpak

**On Linux:**

Prerequisites:
- Install `flatpak-builder`: `sudo apt install flatpak-builder` (on Debian/Ubuntu)

Run `./package-flatpak.sh` from the project root for local testing.

This will build a Flatpak package. For distribution via Flathub, the manifest file `io.github.project516.NumberGuessingGame.yml` should be submitted to the [Flathub repository](https://github.com/flathub/flathub) following their [submission guidelines](https://docs.flathub.org/docs/for-app-authors/submission/).
