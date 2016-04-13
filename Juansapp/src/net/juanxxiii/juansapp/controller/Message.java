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
    private Date sendDate;
    private String server;

    public Message(String body, String server, String userNick) {
        
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String reportDate = df.format(sendDate.getTime());
        this.body = body;
        this.server = server;
        this.sendDate = Date.from(Instant.MIN);
        this.userNick = userNick;
    }
    
    public Message(String body, String server, String userNick, Date sendDate) {
        this.body = body;
        this.server = server;
        this.userNick = userNick;
        this.sendDate = sendDate;
    }

    public String getBody() {
        return body;
    }

    public String getUserNick() {
        return userNick;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public String getServer() {
        return server;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("HH:mm:ss");
        String reportDate = df.format(sendDate.getTime());
        return "(" + reportDate + ") " + userNick + ": " + body;
    }
    
    
    
}
