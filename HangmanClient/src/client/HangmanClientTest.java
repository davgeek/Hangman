/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;

/**
 *
 * @author davgeek
 */
public class HangmanClientTest {
    public static void main(String[] args) throws IOException {
        new HangmanClientTest().run();
    }
    
    private void run() {
        ClientThread clientThread = new ClientThread();
                
        Thread threadClient = new Thread(clientThread);
        threadClient.setName("Client");
        threadClient.start();
    }
    
}
