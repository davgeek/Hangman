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
    private String text;

    public PacketMessage() {
    }
    
    public PacketMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    
}
