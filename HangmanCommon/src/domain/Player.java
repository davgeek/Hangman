/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import com.esotericsoftware.kryonet.Connection;

/**
 *
 * @author davgeek
 */
public class Player {
    private String nickname;
    private Connection conn;

    public Player(String nickname, Connection conn) {
        this.nickname = nickname;
        this.conn = conn;
    }

    public Player(String nickname) {
        this.nickname = nickname;
    }

    public Player() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof Player){
            sameSame = this.nickname == ((Player) object).nickname;
        }

        return sameSame;
    }
    
    
    
}
