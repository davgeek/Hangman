package client;

import client.queue.PacketQueue;
import packets.*;
import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import packets.*;
import utils.Network;

/**
 *
 * @author davgeek
 */
public class FilterControl implements Runnable, Observer {

    public final static int WRITE_BUFFER = 256 * 1024;
    public final static int READ_BUFFER = 256 * 1024;

    private String nickname;
    private String gameWord;
    private boolean start = false;

    private Client client;
    private PacketQueue queueOut;
    
    public FilterControl(PacketQueue queueOut) {
        this.queueOut = queueOut;
        client = new Client(WRITE_BUFFER, READ_BUFFER);
        client.start();
        Network.register(client);
    }
    
    @Override
    public void run() {
        
        Listener listener = new Listener() {

            @Override
            public void received(Connection connection, Object object) {
                if (object instanceof Packet) {
                    System.out.println("obj: " + object.toString());
                    if (object instanceof PacketError) {
                        PacketError pe = (PacketError) object;
                        System.out.println(pe.getError());
                    }

                    if (object instanceof PacketGameStart) {
                        PacketGameStart pgs = (PacketGameStart) object;
                        if (pgs.start) {
                            start = true;
                        }
                        System.out.println("Iniciar juego");
                    }

                    if (object instanceof PacketSetupGame) {
                        System.out.println("Paquete de Setup");
                        PacketSetupGame pir = (PacketSetupGame) object;
                        gameWord = pir.gameWord;
                        System.out.println("Palabra: " + gameWord);
                        queueOut.addMsg(pir);
                    }
                }
            }
        };

        client.addListener(listener);
    }
    
    public void sendToNext(Packet o) {
        queueOut.addMsg(o);
    }
    
    public void sendToServer(Packet o) {
        client.sendTCP(o);
    }
    
    public void connectToServer(String host, String nickname){
        try {
            client.connect(1000, host, Network.S_PORT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        
        this.nickname = nickname;
    }
    
    public void login(){
        PacketClientConnect pc = new PacketClientConnect();
        pc.setNickname(nickname);
        queueOut.addMsg(pc);
        client.sendTCP(pc);
    }
    
    @Override
    public synchronized void update(Observable o, Object object) {
        if (object instanceof Packet) {
            if (object instanceof PacketError) {
                PacketError pe = (PacketError) object;
                System.out.println(pe.getError());
            }

            if (object instanceof PacketGameStart) {
                PacketGameStart pgs = (PacketGameStart) object;
                if (pgs.start) {
                    start = true;
                }
                System.out.println("Iniciar juego");
            }

            if (object instanceof PacketMessage) {
                PacketMessage msg = (PacketMessage) object;
                System.out.println("Mensaje: " + msg.getWord());
            }

            if (object instanceof PacketSetupGame) {
                PacketSetupGame pir = (PacketSetupGame) object;
                queueOut.addMsg(pir);
            }
        }
    }

}
