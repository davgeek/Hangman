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
public class PacketError extends Packet {
    private String error;

    public PacketError() {
    }

    
    public PacketError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
