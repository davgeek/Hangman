package client;

import packets.*;
import java.io.IOException;

import com.esotericsoftware.kryonet.Client;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.esotericsoftware.kryonet.Server;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import packets.*;
import utils.Network;

/**
 *
 * @author davgeek
 */
public class ClientThread implements Runnable {

    public final static int WRITE_BUFFER = 256 * 1024;
    public final static int READ_BUFFER = 256 * 1024;

    private String nickname;
    private String gameWord;
    private String nextIp;
    private boolean start = false;

    private Client client;
    private Client filterOutput;
    private Server filterInput;

    @Override
    public void run() {
        client = new Client(WRITE_BUFFER, READ_BUFFER);
        client.start();

        filterInput = new Server(WRITE_BUFFER, READ_BUFFER);
        filterInput.start();

        filterOutput = new Client(WRITE_BUFFER, READ_BUFFER);
        filterOutput.start();

        Network.register(client);
        Network.register(filterInput);
        Network.register(filterOutput);

        Listener listener = new Listener() {
            @Override
            public void connected(Connection cnctn) {
                super.connected(cnctn);
                System.out.println("Nueva conexcion: " + cnctn.getRemoteAddressTCP().getHostString());
            }

            @Override
            public void received(Connection connection, Object object) {
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
                        System.out.println("Mensaje: " + msg.word);
                    }

                    if (object instanceof PacketSetupGame) {
                        PacketSetupGame pir = (PacketSetupGame) object;

                        if (!filterOutput.isConnected()) {
                            if (pir.table.containsKey(nickname)) {
                                nextIp = pir.table.get(nickname);
                                gameWord = pir.gameWord;
                                System.out.println("word: " + gameWord);
                                System.out.println(nickname + " - Conectar a: " + nextIp);
                                try {
                                    filterOutput.connect(1000, nextIp, Network.F_PORT);
                                    System.out.println("FIn conectado a: " + nextIp);
                                    filterOutput.sendTCP(pir);
                                } catch (IOException ex) {
                                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        } else {
                            System.out.println("Cliente ya conectado, reenviar paquete a su nextIp");
                            final Set<Entry<String, String>> mapValues = pir.table.entrySet();
                            final int maplength = mapValues.size();
                            final Entry<String, String>[] auxTable = new Entry[maplength];
                            mapValues.toArray(auxTable);
                            if (auxTable[maplength - 1].getKey().equals(nickname)) {
                                System.out.println("Soy el ultimo");
                            } else {
                                filterOutput.sendTCP(pir);
                            }
                        }

                    }
                }
            }
        };

        client.addListener(listener);
        filterInput.addListener(listener);
        filterOutput.addListener(listener);

        String host = inputStr("Server");

        try {
            client.connect(1000, host, Network.S_PORT);
            filterInput.bind(Network.F_PORT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Login
        nickname = inputStr("Nickname");
        PacketClientConnect pc = new PacketClientConnect();
        pc.setNickname(nickname);
        client.sendTCP(pc);

        if (!start) {
            String startS = inputStr("Mensaje");
            if (startS.equals("si")) {
                PacketGameStart pgs = new PacketGameStart();
                pgs.start = true;
                client.sendTCP(pgs);
            }
            
            if(startS.equals("hola")) {
                PacketMessage msg = new PacketMessage();
                msg.word = "Hola";
                filterOutput.sendTCP(msg);
            }
        }

    }
    
    public void sendToNext(Object o) {
        filterOutput.sendTCP(o);
    }
    
    public void sendToServer(Object o) {
        client.sendTCP(o);
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
