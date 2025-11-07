/**
 * Number Guessing Game - Main Game Logic
 * A modern web-based number guessing game with high score tracking
 */

class NumberGuessingGame {
    constructor() {
        this.targetNumber = 0;
        this.numberOfGuesses = 0;
        this.gameActive = false;
        this.highScoreManager = new HighScoreManager();
        
        this.initializeElements();
        this.attachEventListeners();
        this.startNewGame();
    }

    initializeElements() {
        // Game elements
        this.guessInput = document.getElementById('guess-input');
        this.submitBtn = document.getElementById('submit-btn');
        this.newGameBtn = document.getElementById('new-game-btn');
        this.feedbackLabel = document.getElementById('feedback');
        this.guessCounter = document.getElementById('guess-counter');
        this.gameArea = document.getElementById('game-area');
        this.winScreen = document.getElementById('win-screen');
        
        // Win screen elements
        this.winMessage = document.getElementById('win-message');
        this.usernameInput = document.getElementById('username');
        this.saveScoreBtn = document.getElementById('save-score-btn');
        
        // High scores elements
        this.highScoresContainer = document.getElementById('high-scores');
        this.clearScoresBtn = document.getElementById('clear-scores-btn');
        
        // Modal elements
        this.aboutBtn = document.getElementById('about-btn');
        this.aboutModal = document.getElementById('about-modal');
        this.closeModalBtn = document.getElementById('close-modal');
    }

    attachEventListeners() {
        // Game controls
        this.submitBtn.addEventListener('click', () => this.handleGuess());
        this.guessInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') this.handleGuess();
        });
        this.newGameBtn.addEventListener('click', () => this.startNewGame());
        
        // Win screen
        this.saveScoreBtn.addEventListener('click', () => this.saveHighScore());
        this.usernameInput.addEventListener('keypress', (e) => {
            if (e.key === 'Enter') this.saveHighScore();
        });
        
        // High scores
        this.clearScoresBtn.addEventListener('click', () => this.clearAllScores());
        
        // Modal
        this.aboutBtn.addEventListener('click', () => this.showAboutModal());
        this.closeModalBtn.addEventListener('click', () => this.hideAboutModal());
        this.aboutModal.addEventListener('click', (e) => {
            if (e.target === this.aboutModal) this.hideAboutModal();
        });
    }

    startNewGame() {
        this.targetNumber = this.generateRandomNumber(1, 100);
        this.numberOfGuesses = 0;
        this.gameActive = true;
        
        // Reset UI
        this.updateGuessCounter();
        this.feedbackLabel.textContent = '';
        this.feedbackLabel.className = 'feedback';
        this.guessInput.value = '';
        this.guessInput.disabled = false;
        this.submitBtn.disabled = false;
        this.guessInput.focus();
        
        // Show game area, hide win screen
        this.gameArea.style.display = 'block';
        this.winScreen.style.display = 'none';
        this.newGameBtn.style.display = 'none';
        
        // Update high scores display
        this.displayHighScores();
    }

    generateRandomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1)) + min;
    }

    handleGuess() {
        if (!this.gameActive) return;
        
        const guess = parseInt(this.guessInput.value);
        
        // Validate input
        if (isNaN(guess) || guess < 1 || guess > 100) {
            this.showFeedback('Please enter a valid number between 1 and 100!', 'error');
            return;
        }
        
        this.numberOfGuesses++;
        this.updateGuessCounter();
        
        // Check guess
        if (guess > this.targetNumber) {
            this.showFeedback(`${guess} is too high! Try a lower number.`, 'too-high');
        } else if (guess < this.targetNumber) {
            this.showFeedback(`${guess} is too low! Try a higher number.`, 'too-low');
        } else {
            this.handleWin();
        }
        
        // Clear input and focus
        this.guessInput.value = '';
        this.guessInput.focus();
    }

    showFeedback(message, type) {
        this.feedbackLabel.textContent = message;
        this.feedbackLabel.className = `feedback ${type}`;
    }

    updateGuessCounter() {
        this.guessCounter.textContent = this.numberOfGuesses;
    }

    handleWin() {
        this.gameActive = false;
        this.showFeedback(`🎉 Correct! The number was ${this.targetNumber}!`, 'correct');
        
        // Disable input
        this.guessInput.disabled = true;
        this.submitBtn.disabled = true;
        
        // Show win screen
        setTimeout(() => {
            this.gameArea.style.display = 'none';
            this.winScreen.style.display = 'block';
            
            const plural = this.numberOfGuesses === 1 ? 'guess' : 'guesses';
            this.winMessage.textContent = `You found the number in ${this.numberOfGuesses} ${plural}!`;
            
            // Focus username input
            this.usernameInput.value = '';
            this.usernameInput.focus();
        }, 1500);
    }

    saveHighScore() {
        const username = this.usernameInput.value.trim();
        
        if (!username) {
            // Add visual feedback for empty username
            this.usernameInput.style.borderColor = 'var(--danger-color)';
            this.usernameInput.placeholder = 'Please enter your name!';
            this.usernameInput.focus();
            
            // Reset border color after 2 seconds
            setTimeout(() => {
                this.usernameInput.style.borderColor = '';
                this.usernameInput.placeholder = 'Your name';
            }, 2000);
            return;
        }
        
        const saved = this.highScoreManager.addHighScore(username, this.numberOfGuesses);
        
        if (saved) {
            // Show success message
            this.winMessage.textContent = `Score saved! You used ${this.numberOfGuesses} ${this.numberOfGuesses === 1 ? 'guess' : 'guesses'}.`;
            this.usernameInput.disabled = true;
            this.saveScoreBtn.disabled = true;
            
            // Update high scores display
            this.displayHighScores();
            
            // Show new game button
            this.newGameBtn.style.display = 'block';
        }
    }

    displayHighScores() {
        const scores = this.highScoreManager.getTopHighScores(10);
        
        if (scores.length === 0) {
            this.highScoresContainer.innerHTML = '<p class="empty-state">No high scores yet. Be the first!</p>';
            return;
        }
        
        let html = '';
        scores.forEach((score, index) => {
            const rank = index + 1;
            let rankClass = '';
            let rankEmoji = '';
            
            if (rank === 1) {
                rankClass = 'gold';
                rankEmoji = '🥇';
            } else if (rank === 2) {
                rankClass = 'silver';
                rankEmoji = '🥈';
            } else if (rank === 3) {
                rankClass = 'bronze';
                rankEmoji = '🥉';
            }
            
            const plural = score.guesses === 1 ? 'guess' : 'guesses';
            
            html += `
                <div class="high-score-item">
                    <span class="high-score-rank ${rankClass}">${rankEmoji || rank + '.'}</span>
                    <span class="high-score-name">${this.escapeHtml(score.username)}</span>
                    <span class="high-score-guesses">${score.guesses} ${plural}</span>
                </div>
            `;
        });
        
        this.highScoresContainer.innerHTML = html;
    }

    clearAllScores() {
        if (confirm('Are you sure you want to clear all high scores? This cannot be undone.')) {
            this.highScoreManager.clearAllScores();
            this.displayHighScores();
        }
    }

    showAboutModal() {
        this.aboutModal.style.display = 'flex';
    }

    hideAboutModal() {
        this.aboutModal.style.display = 'none';
    }

    escapeHtml(text) {
        const div = document.createElement('div');
        div.textContent = text;
        return div.innerHTML;
    }
}

/**
 * High Score Manager - Handles score persistence using localStorage
 */
class HighScoreManager {
    constructor() {
        this.storageKey = 'numberGuessingGame_highScores';
        this.maxScores = 10;
    }

    addHighScore(username, guesses) {
        const scores = this.loadScores();
        
        // Create new score object
        const newScore = {
            username: username,
            guesses: guesses,
            timestamp: Date.now()
        };
        
        // Add to scores array
        scores.push(newScore);
        
        // Sort by guesses (ascending - fewer is better)
        scores.sort((a, b) => {
            if (a.guesses === b.guesses) {
                return a.timestamp - b.timestamp; // Earlier timestamp wins if tied
            }
            return a.guesses - b.guesses;
        });
        
        // Keep only top scores
        const topScores = scores.slice(0, this.maxScores);
        
        // Save to localStorage
        this.saveScores(topScores);
        
        return true;
    }

    getTopHighScores(count) {
        const scores = this.loadScores();
        return scores.slice(0, count);
    }

    loadScores() {
        try {
            const data = localStorage.getItem(this.storageKey);
            if (data) {
                return JSON.parse(data);
            }
        } catch (error) {
            console.error('Error loading high scores:', error);
        }
        return [];
    }

    saveScores(scores) {
        try {
            localStorage.setItem(this.storageKey, JSON.stringify(scores));
        } catch (error) {
            console.error('Error saving high scores:', error);
        }
    }

    clearAllScores() {
        try {
            localStorage.removeItem(this.storageKey);
        } catch (error) {
            console.error('Error clearing high scores:', error);
        }
    }
}

// Initialize the game when DOM is ready
if (document.readyState === 'loading') {
    document.addEventListener('DOMContentLoaded', () => {
        new NumberGuessingGame();
    });
} else {
    new NumberGuessingGame();
}
