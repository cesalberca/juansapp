/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.juanxxiii.juansapp.controller;

import java.time.Instant;
import java.util.Date;

/**
 *
 * @author Dam
 */
public class Message {
    private String body;
    private Date sendDate;
    private String server;

    public Message(String body, String server) {
        this.body = body;
        this.server = server;
        this.sendDate = Date.from(Instant.MIN);
    }
    create table user(
	nickname text,
	lastConnection datetime,
	isConnected Boolean,
	lastServer text);
	
create table message(
	body text,
	sendDate datetime,
	server text);
}
