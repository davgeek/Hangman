/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangui;

import client.FilterControl;
import client.nal.FilterInput;
import client.nal.FilterOuput;
import client.queue.PacketQueue;
import hangmangui.mvc.Controller;
import hangmangui.mvc.Model;
import hangmangui.mvc.View;

/**
 *
 * @author davgeek
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // queues creation
        PacketQueue queueIn = new PacketQueue("input");
        PacketQueue queueOut = new PacketQueue("output");
        PacketQueue queueGui = new PacketQueue("gui");
        
        // filter nal setup
        FilterInput input = new FilterInput(queueIn);
        FilterControl control = new FilterControl(queueOut, queueGui);
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
        
        // game mvc creation
        Model gameModel = new Model(control);        
        Controller controller = new Controller(gameModel);
        View view = new View(gameModel, controller);
        queueGui.attach(view);
        view.setVisible(true);
        
    }
    
}
