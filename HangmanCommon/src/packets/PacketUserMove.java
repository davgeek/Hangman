package packets;

/**
 *
 * @author davgeek
 */
public class PacketUserMove extends Packet{
    private String user;
    private char c;

    public PacketUserMove() {
    }

    public PacketUserMove(String user, char c) {
        this.user = user;
        this.c = c;
    }

    public String getUser() {
        return user;
    }

    public char getC() {
        return c;
    }
    
}
