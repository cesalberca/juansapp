/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.juanxxiii.juansapp.controller;

import java.util.Date;

/**
 *
 * @author Dam
 */
public class User {

    private String nickname;
    private Date lastConnection;
    private Boolean isConnected;
    private String server;

    public User(String nickname, String server) {
        this.nickname = nickname;
        this.server = server;
    }

    public Date getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(Date lastConnection) {
        this.lastConnection = lastConnection;
    }

    public Boolean getIsConnected() {
        return isConnected;
    }

    public void setIsConnected(Boolean isConnected) {
        this.isConnected = isConnected;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getNickname() {
        return nickname;
    }

}
