/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packets;

/**
 *
 * @author davgeek
 */
public class PacketMessage extends Packet {
    public String word;

    public PacketMessage(String word) {
        this.word = word;
    }
    
    
}
