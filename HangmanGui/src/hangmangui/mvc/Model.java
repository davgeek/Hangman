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
public class Model {
    boolean guessed;
    int correctGuessTotal;
    int livesLeft;
    String wordToGuess;
    StringBuffer guessedSoFarStringBuffer;
    

    public Model() {
        this.livesLeft = 6;
    }

    boolean isTheWholeWordGuessed() {
        return this.correctGuessTotal == this.wordToGuess.length();
    }

    String getHangmanWord() {
        return putInSpaces(guessedSoFarStringBuffer.toString());
    }

    void setHangmamWordIndexTo(int index, char x) {
        this.guessedSoFarStringBuffer.setCharAt(index, x);
    }

    void initilizeguessedSoFarStringBuffer() {
        guessedSoFarStringBuffer = new StringBuffer();
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedSoFarStringBuffer.append("_");
        }
    }

    String getSecretWord() {
        return "word";
    }

    private String putInSpaces(String aWord) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < aWord.length(); i++) {
            sb.append(aWord.charAt(i) + " ");
        }
        return sb.toString();
    }

    public int getLivesLeft() {
        return livesLeft;
    }

    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }
    
    
    
}
