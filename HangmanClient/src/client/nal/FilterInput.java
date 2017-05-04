/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.nal;

import client.queue.PacketQueue;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.io.IOException;
import packets.Packet;
import packets.PacketMessage;
import utils.Network;

/**
 *
 * @author davgeek
 */
public class FilterInput implements Runnable{
    
    private final static int WRITE_BUFFER = 256 * 1024;
    private final static int READ_BUFFER = 256 * 1024;
    private PacketQueue queue;
    
    private Server filterInput;

    public FilterInput(PacketQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        filterInput = new Server(WRITE_BUFFER, READ_BUFFER);
        Network.register(filterInput);
        
        Listener listener = new Listener(){
            
            @Override
            public void received(Connection cnctn, Object o) {
                if(o instanceof Packet){
                    queue.addMsg((Packet) o);
                }
            }
            
            @Override
            public void disconnected(Connection c) {
                System.out.println("INPUT: desconectado " + c.getID());
            }
        };
        
        filterInput.addListener(listener);
        filterInput.start();
        
        try {
            filterInput.bind(Network.F_PORT);
        } catch (IOException ex) {
            System.out.println(ex.getLocalizedMessage());
        }
    }
    
    
}
