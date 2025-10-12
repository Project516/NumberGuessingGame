# Flathub Submission Guide

This document provides instructions for submitting the Number Guessing Game to Flathub.

## Files for Flathub

The following files are required for Flathub packaging:

1. **io.github.project516.NumberGuessingGame.yml** - Flatpak manifest file
2. **io.github.project516.NumberGuessingGame.metainfo.xml** - AppStream metadata
3. **io.github.project516.NumberGuessingGame.desktop** - Desktop entry file
4. **io.github.project516.NumberGuessingGame.png** - Application icon (256x256)

## Submission Process

To submit this application to Flathub:

1. Fork the [Flathub repository](https://github.com/flathub/flathub)

2. Create a new directory with the app ID:
   ```bash
   mkdir io.github.project516.NumberGuessingGame
   ```

3. Copy the manifest file and related assets:
   ```bash
   cp io.github.project516.NumberGuessingGame.yml io.github.project516.NumberGuessingGame/
   cp io.github.project516.NumberGuessingGame.metainfo.xml io.github.project516.NumberGuessingGame/
   cp io.github.project516.NumberGuessingGame.desktop io.github.project516.NumberGuessingGame/
   cp io.github.project516.NumberGuessingGame.png io.github.project516.NumberGuessingGame/
   ```

4. **Important**: Update the manifest to use released versions instead of local files. Replace the `sources` section in the manifest with:
   ```yaml
   sources:
     - type: archive
       url: https://github.com/Project516/NumberGuessingGame/releases/download/v1.0.0/archive.zip
       sha256: <checksum-here>
   ```

5. Commit and push to your fork:
   ```bash
   git add io.github.project516.NumberGuessingGame
   git commit -m "Add io.github.project516.NumberGuessingGame"
   git push
   ```

6. Create a pull request to the Flathub repository

7. Wait for the automated tests to complete and address any feedback from reviewers

## Testing Locally

Before submitting, test the Flatpak build locally:

```bash
# Install flatpak-builder if not already installed
sudo apt install flatpak-builder

# Build the application
./gradlew build

# Build and install the Flatpak
./package-flatpak.sh
```

Or build manually:
```bash
flatpak-builder --user --install --force-clean build-dir io.github.project516.NumberGuessingGame.yml
```

Run the installed application:
```bash
flatpak run io.github.project516.NumberGuessingGame
```

## Resources

- [Flathub Documentation](https://docs.flathub.org/)
- [Flatpak Documentation](https://docs.flatpak.org/)
- [AppStream Documentation](https://www.freedesktop.org/software/appstream/docs/)
- [Desktop Entry Specification](https://specifications.freedesktop.org/desktop-entry-spec/latest/)
