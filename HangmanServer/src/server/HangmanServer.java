/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import com.esotericsoftware.minlog.Log;
import java.io.IOException;

/**
 *
 * @author davgeek
 */
public class HangmanServer {
    public static void main(String[] args) throws IOException{
        Log.set(Log.LEVEL_DEBUG);
        new HangmanServer().run();
    }
    
    private void run() {
        ServerThread server = new ServerThread();
        Thread threadServer = new Thread(server);
        threadServer.setName("Server");
        threadServer.start();
    }
}
