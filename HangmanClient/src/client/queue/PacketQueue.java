/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import packets.Packet;

/**
 *
 * @author davgeek
 */
public class PacketQueue extends Observable{
    
    private String name;
    List<Packet> msgs = new ArrayList<>();
    Observer observer;

    public PacketQueue(String name) {
        this.name = name;
    }
    
    public void addMsg(Packet p){
        System.out.println("Mensaje agregado en: " + name);
        msgs.add(p);
        notifyObservers();
    }
    
    public Packet getFirst(){
        Packet temp = msgs.get(0);
        msgs.remove(0);
        return temp;
    }
    
    public Packet getLast(){
        return msgs.get(msgs.size()-1);
    }
    
    public void attach(Observer o){
        observer = o;
    }

    @Override
    public void notifyObservers() {
        observer.update(this, getFirst());
    }
        
    
}
