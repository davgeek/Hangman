/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.nal;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Listener;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import packets.Packet;
import packets.PacketClientConnect;
import packets.PacketError;
import packets.PacketMessage;
import packets.PacketSetupGame;
import utils.Network;

/**
 *
 * @author davgeek
 */
public class FilterOuput implements Runnable, Observer {
    private final static int WRITE_BUFFER = 256 * 1024;
    private final static int READ_BUFFER = 256 * 1024;
    
    private Client filterOutput;
    private String nickname;
    private String nextIp;

    public FilterOuput() {
        filterOutput = new Client(WRITE_BUFFER, READ_BUFFER);
        Network.register(filterOutput);
    }

    @Override
    public void update(Observable o, Object object) {
        
        if (object instanceof Packet) {
            if(object instanceof PacketClientConnect){
                PacketClientConnect pc = (PacketClientConnect) object;
                nickname = pc.getNickname();
            } else if (object instanceof PacketSetupGame) {
                PacketSetupGame pir = (PacketSetupGame) object;
                if (!filterOutput.isConnected()) {
                    if (pir.table.containsKey(nickname)) {
                        nextIp = pir.table.get(nickname);
                        System.out.println(nickname + " - Conectar a: " + nextIp);
                        try {
                            filterOutput.connect(1000, nextIp, Network.F_PORT);
                            System.out.println("Output conectado a: " + nextIp);
                            filterOutput.sendTCP(pir);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } else {
                    System.out.println("Cliente ya conectado, reenviar paquete a:" + nextIp);
                    final Set<Entry<String, String>> mapValues = pir.table.entrySet();
                    final int maplength = mapValues.size();
                    final Entry<String, String>[] auxTable = new Entry[maplength];
                    mapValues.toArray(auxTable);
                    if (auxTable[maplength - 1].getKey().equals(nickname)) {
                        System.out.println("Soy el ultimo: " + nickname);
                    } else {
                        filterOutput.sendTCP(pir);
                    }
                }

            } else {
                filterOutput.sendTCP(object);
            }
        }
    }

    @Override
    public void run() {
        Listener listener = new Listener() {};
        filterOutput.addListener(listener);
        filterOutput.start();
    }
    
    public boolean isReady(){
        return filterOutput.isConnected();
    }
    
    
    
}
