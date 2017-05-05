package hangmangui.mvc;

import packets.Packet;
import packets.PacketMessage;
import packets.PacketUserMove;

/**
 *
 * @author davgeek
 */
public class Controller {
    private Model model;

    public Controller(Model model) {
        this.model = model;
    }
    
    void tryWith(char c) {
        model.sendToNext(new PacketUserMove(model.filter.getNickname(), c));
        if (model.getLivesLeft() > 0 && model.guessed == false) {
            model.sendToNext(new PacketMessage(c+""));
            boolean wasTheGuessCorrect = wasTheGuessCorrect(c);
            if (wasTheGuessCorrect == true) {
                handleCorrectGuess(c);
            } else {
                handleWrongGuess();
            }
        }
    }
    
    void tryMove(char c) {
        boolean wasTheGuessCorrect = wasTheGuessCorrect(c);
        if (wasTheGuessCorrect == true) {
            handleCorrectGuess(c);
        } else {
            handleWrongGuess();
        }        
    }

    void reset() {
        model.filter.restart();
        model.guessed = false;
        model.correctGuessTotal = 0;
        model.setLivesLeft(6);        
        initilizeGuessedSoFarStringBuffer();
    }

    void initilizeGuessedSoFarStringBuffer() {
        model.wordToGuess = model.filter.getGameWord();
        model.initilizeguessedSoFarStringBuffer();
        System.out.println("gues:" + model.wordToGuess);
    }

    boolean wasTheGuessCorrect(char guessLetter) {
        boolean match = false;
        for (int w = 0; w < model.wordToGuess.length(); w++) {
            if (model.wordToGuess.toLowerCase().charAt(w) == guessLetter) {
                match = true;
            }
        }
        return match;
    }

    void handleCorrectGuess(char in) {
        for (int w = 0; w < model.wordToGuess.length(); w++) {
            if (model.wordToGuess.toLowerCase().charAt(w) == in) {
                model.setHangmamWordIndexTo(w, in);
                model.correctGuessTotal++;
            }
        }
    }

    void handleWrongGuess() {
        model.setLivesLeft(model.getLivesLeft()-1);
    }
    
    void sendToNext(Packet p){
        model.sendToNext(p);
    }
    
}
