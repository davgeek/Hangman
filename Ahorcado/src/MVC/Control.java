/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

/**
 *
 * @author pride
 */
public class Control {
    Model mod;
    boolean start; 
    String word; 
    int err;
    String turn;
    String asiertos;
    String fallido;
    String winner;
    
    public Control() {
        mod=new Model();
    }

    public Control(boolean start, String word, int err, String turn) {
       mod=new Model(start,word,err,turn);
    }

    public String getAsiertos() {
        return asiertos;
    }

    public void setAsiertos(String caracter) {
        mod.setAsierto(caracter);
         }


    public void setFallido(String fallidos) {
       mod.setFallido(fallidos);
       
    }

    public String getFallido() {
        return fallido;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.mod.setWinner(winner);
    }

    

    public Model getMod() {
        return mod;
    }

    public void setMod(Model mod) {
        this.mod = mod;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String  getWord() {
        return mod.getPalabra();
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        mod.setErr(err);
        
    }

    public String getTurn() {
        return turn;
    }

    public void setTurn(String turn) {
        this.turn = turn;
    }

    @Override
    public String toString() {
        return mod.toString();
                }
    
    
    
    
    
    
}
