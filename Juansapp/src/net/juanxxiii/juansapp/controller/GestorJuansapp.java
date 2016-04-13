/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.juanxxiii.juansapp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class GestorJuansapp {
    private User us;
    private Message ms;
    private ArrayList<Message> messages;
    
    public void addUser() {
        
    }
    
    public ArrayList<Message> getDataBBDD(String dbDirectory) {
        messages = null;
        try {
            messages = new ArrayList<>();
            Connection conexion = null;
            Statement stmt = null;
            String sql = null;
            ResultSet rs = null;
            
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(dbDirectory);
            stmt = conexion.createStatement();
            
            sql = "SELECT * FROM MESSAGES";
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                messages.add(new Message(rs.getString("body"), rs.getString("userNick"), rs.getString("server"), rs.getDate("sendDate")));
            }
            
            stmt.close();
            conexion.close();
            return messages;
        } catch (ClassNotFoundException ex) {
            return messages;
        } catch (SQLException ex) {
            return messages;
        }
    }
    
    public void sendMsgToBBDD(Message msg) {
        try {
            Connection conexion = null;
            Statement stmt = null;
            String sql = null;
            
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection(msg.getServer());
            stmt = conexion.createStatement();
            
            sql = "INSERT INTO MESSAGES VALUES('" + msg.getBody() + "', '" + msg.getUserNick() + "', '" + msg.getSendDate() + "', '" + msg.getServer() + "')";
            
            stmt.executeUpdate(sql);
            
            stmt.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorJuansapp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorJuansapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
