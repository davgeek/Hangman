/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangui.mvc;

import client.FilterControl;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import packets.Packet;
import packets.PacketMessage;

/**
 *
 * @author davgeek
 */
public class Model {
    
    boolean guessed;
    int correctGuessTotal;
    private int livesLeft;
    String wordToGuess;
    StringBuffer guessedSoFarStringBuffer;
    FilterControl filter;

    public Model() {
        this.livesLeft = 6;
    }

    public Model(FilterControl filter) {
        this.filter = filter;
    }
    
    public void connect(String host){
        filter.connectToServer(host);
    }
    
    public void sendToNext(Packet p){
        filter.sendToNext(p);
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
        }
        wordToGuess = filter.getGameWord();
        System.out.println("MOD: " + wordToGuess);
        guessedSoFarStringBuffer = new StringBuffer();
        for (int i = 0; i < wordToGuess.length(); i++) {
            guessedSoFarStringBuffer.append("_");
        }
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
