/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import client.ClientThread;

/**
 *
 * @author dav
 */
public class HangmanModel {
    private ClientThread network;
    
    private boolean start;
    private String turn;
    private String winner;
    private String fallido;
    private String asierto;
    private int equivocaciones = 5; 
    
    public HangmanModel(ClientThread network) {
        this.network = network;
        network.sendToNext(new packets.PacketMessage("Hola"));
    }

    public ClientThread getNetwork() {
        return network;
    }

    public void setNetwork(ClientThread network) {
        this.network = network;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getWord() {
        return network.getGameWord();
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getFallido() {
        return fallido;
    }

    public void setFallido(String fallido) {
        this.fallido = fallido;
    }

    public String getAsierto() {
        return asierto;
    }

    public void setAsierto(String asierto) {
        this.asierto = asierto;
    }

    public int getEquivocaciones() {
        return equivocaciones;
    }

    public void setEquivocaciones() {
        this.equivocaciones -= 1;
    }
    
}
