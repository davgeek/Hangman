/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangui.mvc;

/**
 *
 * @author davgeek
 */
public class Controller {
    private Model gameModel;

    public Controller(Model model) {
        this.gameModel = model;
    }
    
    void tryWith(char c) {
        if (gameModel.getLivesLeft() > 0 && gameModel.guessed == false) {
            boolean wasTheGuessCorrect = wasTheGuessCorrect(c);

            if (wasTheGuessCorrect == true) {
                handleCorrectGuess(c);
            } else {
                handleWrongGuess();
            }
        }
    }

    void reset() {
        gameModel.guessed = false;
        gameModel.correctGuessTotal = 0;
        gameModel.setLivesLeft(6);
        initilizeGuessedSoFarStringBuffer();
    }

    void setLives(int amount) {
        gameModel.livesLeft = amount;
    }

    void initilizeGuessedSoFarStringBuffer() {
        gameModel.initilizeguessedSoFarStringBuffer();
    }

    boolean wasTheGuessCorrect(char guessLetter) {
        boolean match = false;
        for (int w = 0; w < gameModel.wordToGuess.length(); w++) {
            if (gameModel.wordToGuess.charAt(w) == guessLetter) {
                match = true;
            }
        }
        return match;
    }

    void handleCorrectGuess(char in) {
        for (int w = 0; w < gameModel.wordToGuess.length(); w++) {
            if (gameModel.wordToGuess.charAt(w) == in) {
                gameModel.setHangmamWordIndexTo(w, in);
                gameModel.correctGuessTotal++;
            }
        }
    }

    void handleWrongGuess() {
        gameModel.setLivesLeft(gameModel.getLivesLeft()-1);
    }
    
}
