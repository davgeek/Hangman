/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

/**
 *
 * @author dav
 */
public class HangmanController {
    private HangmanModel model;
    private HangmanView view;

    public HangmanController(HangmanModel model, HangmanView view) {
        this.model = model;
        this.view = view;
        
        
        
    }
    
    public void pedir() {
        if(model.isStart()) {
            model.getWord();
        }
    }
    
    
    
    
}
