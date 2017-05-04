/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.nal.FilterInput;
import client.nal.FilterOuput;
import client.queue.PacketQueue;
import java.io.IOException;
import javax.swing.JOptionPane;
import packets.PacketGameStart;
import packets.PacketMessage;

/**
 *
 * @author davgeek
 */
public class HangmanClientTest {
    public static void main(String[] args) throws IOException {
        new HangmanClientTest().run();
    }
    
    private void run() {
        PacketQueue queueIn = new PacketQueue("input");
        PacketQueue queueOut = new PacketQueue("output");
        
        FilterInput input = new FilterInput(queueIn);
        
        FilterControl control = new FilterControl(queueOut);
        queueIn.attach(control);

        FilterOuput output = new FilterOuput();
        queueOut.attach(output);
        
        Thread threadClient = new Thread(control);
        threadClient.setName("Client");
        threadClient.start();

        Thread inputThread = new Thread(input);
        inputThread.setName("Input");
        inputThread.start();

        Thread outputThread = new Thread(output);
        outputThread.setName("Output");
        outputThread.start();

        //hard coded data
        control.connectToServer("localhost", "dav");
        control.login();
        control.sendToServer(new PacketGameStart());
        
        
        String msg = inputStr("Mensaje");
        control.sendToNext(new PacketMessage(msg));
        
        
    }
    
    private String inputStr(String title) {
        String input = (String) JOptionPane.showInputDialog(null, "Valor:", title, JOptionPane.QUESTION_MESSAGE,
                null, null, "");
        if (input == null || input.trim().length() == 0) {
            System.exit(1);
        }
        return input.trim();
    }
    
}
