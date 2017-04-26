/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.serializers.MapSerializer;
import com.esotericsoftware.kryonet.EndPoint;
import java.util.LinkedHashMap;
import packets.*;

/**
 *
 * @author davgeek
 */
public class Network {
    static public final int S_PORT = 4444;
    static public final int F_PORT = 4445;

    static public void register(EndPoint endPoint) {
        MapSerializer serializer = new MapSerializer();        
        Kryo kryo = endPoint.getKryo();
        
        kryo.register(LinkedHashMap.class, serializer);
        serializer.setKeyClass(String.class, kryo.getSerializer(String.class));
        serializer.setKeysCanBeNull(false);
        serializer.setKeyClass(String.class, kryo.getSerializer(String.class));
        
        kryo.register(Packet.class);
        kryo.register(PacketClientConnect.class);
        kryo.register(PacketClientDisconnect.class);
        kryo.register(PacketGameStart.class);
        kryo.register(PacketError.class);
        kryo.register(PacketSetupGame.class);
        kryo.register(PacketMessage.class);
    }
}