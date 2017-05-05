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
public class PacketGameStart extends Packet {
    private boolean start = true;
    private String from;

    public PacketGameStart() {
    }

    public PacketGameStart(boolean start, String from) {
        this.start = start;
        this.from = from;
    }

    public boolean isStart() {
        return start;
    }

    public String getFrom() {
        return from;
    }
}
