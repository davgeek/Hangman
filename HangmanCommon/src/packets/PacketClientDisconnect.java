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
public class PacketClientDisconnect extends Packet {
    private String nickname;

    public PacketClientDisconnect() {
    }
    
    

    public PacketClientDisconnect(String nickname) {
        this.nickname = nickname;
    }    

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
