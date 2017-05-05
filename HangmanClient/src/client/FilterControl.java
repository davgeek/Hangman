package client;

import client.queue.PacketQueue;
import packets.*;
import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import java.net.InetAddress;
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
    private String gameWord = "";
    private boolean start = false;

    private Client client;
    private PacketQueue queueOut;
    private PacketQueue queueGui;
    
    public FilterControl(PacketQueue queueOut, PacketQueue queueGui) {
        this.queueOut = queueOut;
        this.queueGui = queueGui;
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
                    if (object instanceof PacketError) {
                        PacketError pe = (PacketError) object;
                        System.out.println(pe.getError());
                    }

                    if(object instanceof PacketNewWord){
                        PacketNewWord newWord = (PacketNewWord) object;
                        gameWord = newWord.getWord();
                        queueOut.addMsg(newWord);
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
    
    public void connectToServer(String host){
        try {
            client.connect(5000, host, Network.S_PORT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }        
        
        this.nickname = nickname;
    }
    
    public void login(String nickname){
        this.nickname = nickname;
        PacketClientConnect pc = new PacketClientConnect();
        pc.setNickname(this.nickname);
        queueOut.addMsg(pc);
        client.sendTCP(pc);
    }
    
    public void start(){
        client.sendTCP(new PacketGameStart());
    }
    public void restart(){
        client.sendTCP(new PacketGameStart());
    }
    
    @Override
    public synchronized void update(Observable o, Object object) {
        if (object instanceof Packet) {
            if (object instanceof PacketSetupGame) {
                PacketSetupGame pir = (PacketSetupGame) object;
                gameWord = pir.gameWord;
                System.out.println("Palabra: " + gameWord);
                queueOut.addMsg(pir);
            } else if(object instanceof PacketNewWord){
                PacketNewWord newWord = (PacketNewWord) object;
                gameWord = newWord.getWord();
                System.out.println("Me llego: " + gameWord);
                if(!newWord.getLast().equalsIgnoreCase(nickname)){
                    queueOut.addMsg(newWord);
                }
            }
            else {
                addToGui(object);
            }
        }
    }
    
    private void addToGui(Object o){
        queueGui.addMsg((Packet) o);
    }

    public String getGameWord() {
        return gameWord;
    }

    public String getNickname() {
        return nickname;
    }
}
