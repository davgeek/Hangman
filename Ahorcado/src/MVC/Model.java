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
public class Model {
    public boolean start;
    public String word;
    public int err;
    public String turn;
    String winner;
    String fallido;
    String asierto;

    public Model() {
    }

    public Model(boolean start, String word, int err,String turn) {
        this.start = start;
        this.word = word;
        this.err = err;
        this.turn=turn;
        System.out.println("palabra: "+word);
    }

    
    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getErr() {
        return err;
    }

    public void setErr(int err) {
        this.err = err;
        System.out.println("Num Perdidas : "+this.err);
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
        System.out.println("ganador: "+winner);
    }

    public String getFallido() {
        return fallido;
    }

    public void setFallido(String fallido) {
        this.fallido = fallido;
         System.out.println("fallido: "+fallido);
    }

    public String getAsierto() {
        return asierto;
    }

    public void setAsierto(String asierto) {
        this.asierto = asierto;
         System.out.println("Caracter recibido ACERTADO: "+this.asierto);
  
    }

    @Override
    public String toString() {
        return   "start=" + start + ", word=" + word + ", Perdidas =" + err + ", turn=" + turn  + ", winner=" + winner + ", fallido=" + fallido + ", asierto=" + asierto;
    }


  

    public String getPalabra() {
   /**     palabra[0] = "perro".toUpperCase();
        palabra[1] = "Pumas".toUpperCase();
        palabra[2] = "victor".toUpperCase();
        palabra[3] = "joel".toUpperCase();
        palabra[4] = "david".toUpperCase();
        palabra[5] = "rompope".toUpperCase();
        palabra[6] = "melon".toUpperCase();
        palabra[7] = "Michoacan".toUpperCase();
        palabra[8] = "platano".toUpperCase();
        palabra[9] = "ferrocarril".toUpperCase();
        palabra[10] = "monstruo".toUpperCase();
        palabra[11] = "pinocho".toUpperCase();
        palabra[12] = "aguacate".toUpperCase();
        palabra[13] = "mecanico".toUpperCase();
        palabra[14] = "juanito".toUpperCase();
        palabra[15] = "amen".toUpperCase();
        palabra[16] = "plato".toUpperCase();
        palabra[17] = "raton".toUpperCase();
        palabra[18] = "comander".toUpperCase();
        palabra[19] = "cama".toUpperCase();
        
       */
         return "test".toUpperCase();
        
        
    }
    

    
    /**
     * palabra
     * caracter recibido
     * Finish: whos won
     * 
     * 
     *   regresar la palabra correcta
     *   Cuando gano regresar flag
     *   enviar el nxtPlayer
     *   regresar el error fallido
     *   
     * 
     */
    
}
