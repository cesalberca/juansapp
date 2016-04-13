/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.juanxxiii.juansapp.controller;

/**
 *
 * @author Dam
 */
public class Message {
    private String body;
    private String userNick;
    private String server;

    public Message(String body, String userNick, String server) {
        this.body = body;
        this.userNick = userNick;
        this.server = server;
    }
    
    public String getBody() {
        return body;
    }

    public String getUserNick() {
        return userNick;
    }

    public String getServer() {
        return server;
    }

    @Override
    public String toString() {
        return userNick + ": " + body + "\n";
    }
    
    
    
}
