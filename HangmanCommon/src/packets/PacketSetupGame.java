/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

import java.util.LinkedHashMap;

/**
 *
 * @author davgeek
 */
public class PacketSetupGame extends Packet{
    public String gameWord;
    public LinkedHashMap<String,String> table = new LinkedHashMap<>();
}
