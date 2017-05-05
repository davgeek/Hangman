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
public class PacketNewWord extends Packet{
    private String word;
    private String last;

    public PacketNewWord() {
    }
    
    

    public PacketNewWord(String word, String last ) {
        this.word = word;
        this.last = last;
    }

    public String getWord() {
        return word;
    }

    public String getLast() {
        return last;
    }
    
    
}
