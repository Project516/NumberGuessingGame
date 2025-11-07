# Number Guessing Game - Web Version

A modern, responsive web-based number guessing game with high score tracking. Try to guess the randomly generated number between 1 and 100 in as few guesses as possible!

🎮 **[Play the game here!](https://project516.github.io/NumberGuessingGame/)**

## Features

- 🎯 **Modern Design**: Clean, responsive UI that works on all devices
- 🏆 **High Score Tracking**: Compete for the top spot with localStorage-based persistence
- 📱 **Mobile-Friendly**: Fully responsive design that works on phones, tablets, and desktops
- 🎨 **Visual Feedback**: Color-coded hints and smooth animations
- ⚡ **Fast & Lightweight**: No dependencies, pure vanilla JavaScript
- 🚀 **GitHub Pages Ready**: Easy deployment as a static site

## How to Play

1. Enter a number between 1 and 100
2. Click "Submit Guess" or press Enter
3. Follow the color-coded hints:
   - 🔵 **Blue**: Your guess is too low
   - 🟠 **Orange**: Your guess is too high
   - 🟢 **Green**: Correct! You won!
4. Try to guess the number in as few attempts as possible
5. Save your score and compete for the high scores!

## Technologies Used

- **HTML5**: Semantic markup
- **CSS3**: Modern styling with CSS Grid, Flexbox, and animations
- **Vanilla JavaScript**: No frameworks or dependencies
- **LocalStorage API**: For persistent high score tracking

## Local Development

Simply open `index.html` in your web browser. No build process or server required!

For a local development server (optional):

```bash
# Using Python 3
python -m http.server 8000

# Using Node.js (with npx)
npx serve

# Using PHP
php -S localhost:8000
```

Then navigate to `http://localhost:8000` in your browser.

## Deployment to GitHub Pages

This game is designed to be easily deployed to GitHub Pages:

1. Push the code to your GitHub repository
2. Go to **Settings** → **Pages**
3. Under "Source", select the branch (e.g., `main`) and folder (`/ (root)`)
4. Click **Save**
5. Your game will be live at `https://yourusername.github.io/NumberGuessingGame/`

The game is fully self-contained with no build process required!

## Desktop Version

This web version complements the original Java desktop application. To use the desktop version:

- Download from the [releases page](https://github.com/Project516/NumberGuessingGame/releases)
- Available for Windows, macOS, and Linux
- Features both GUI and console modes

See the main [README.md](README.md) for more details about the desktop version.

## Browser Compatibility

The game works in all modern browsers:

- ✅ Chrome/Edge (latest)
- ✅ Firefox (latest)
- ✅ Safari (latest)
- ✅ Mobile browsers (iOS Safari, Chrome Mobile)

## License

This project is open source. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests.

---

Made with ❤️ for learning and fun!
