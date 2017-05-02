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
public class App {
    public static void main(String[] args) {
        new App().run();
    }
    
    private void run() {
        ClientThread filter = new ClientThread();

        Thread threadClient = new Thread(filter);
        threadClient.setName("Client");
        threadClient.start();

        HangmanModel hangman = new HangmanModel(filter);

        HangmanView view = new HangmanView();
        HangmanController controller = new HangmanController(hangman, view);
        
    }
}
