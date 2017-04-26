package server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import domain.Player;
import packets.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import utils.HangmanLexicon;
import utils.Network;

/**
 *
 * @author davgeek
 */
public class ServerThread implements Runnable {
    
    public final static int WRITE_BUFFER = 256 * 1024;
    public final static int READ_BUFFER = 256 * 1024;
    private Server server;
    
    private ArrayList <Player> players = new ArrayList();
    private HangmanLexicon hangmanWords;
    
    @Override
    public void run() {
        
        // lexicon
        hangmanWords = new HangmanLexicon("words.txt");
        
        server = new Server(WRITE_BUFFER, READ_BUFFER);
        
        Network.register(server);
        
        server.addListener(new Listener() {
            @Override
            public void connected(Connection cnctn) {
                super.connected(cnctn);
                System.out.println("New: " + cnctn.getRemoteAddressTCP().getHostName());
            }
            
            @Override
            public void received(Connection connection, Object object) {
                
                if (object instanceof Packet) {
                    if(object instanceof PacketClientConnect) {
                        PacketClientConnect pc = (PacketClientConnect) object;
                        if(players.contains(new Player(pc.getNickname()))){
                            connection.sendTCP(new PacketError("Nickname ya registrado"));
                        } else {
                            System.out.println("Nick: " + pc.getNickname());
                            players.add(new Player(pc.getNickname(), connection));
                        }
                    }
                    
                    if(object instanceof PacketGameStart) {
                        System.out.println("Iniciar juego");
                        
                        PacketGameStart pgs = (PacketGameStart) object;
                        if(pgs.start){
                            PacketSetupGame pir = new PacketSetupGame();
                            
                            // game word
                            String word = hangmanWords.pickWord();
                            System.out.println("Establecer palabra. " + word);
                            pir.gameWord = word;
                            
                            // create ip table
                            for (int i = 0; i < players.size(); i++) {
                                if(i == players.size()-1){
                                    pir.table.put(players.get(i).getNickname(), players.get(0).getConn().getRemoteAddressTCP().getHostString());
                                } else{
                                    pir.table.put(players.get(i).getNickname(), players.get(i+1).getConn().getRemoteAddressTCP().getHostString());
                                }
                                
                            }
                            players.get(0).getConn().sendTCP(pir);
                        }
                        
                    }
                }
            }
            
            @Override
            public void disconnected(Connection c) {
                System.out.println("DES:" + c.getID());
            }
        });
                
        System.out.println("Iniciando Server");
        server.start();
        
        try {
            server.bind(Network.S_PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
