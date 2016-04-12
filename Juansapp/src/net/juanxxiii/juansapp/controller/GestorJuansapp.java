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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class GestorJuansapp {
    private User us;
    private Message ms;
    
    public void addUser() {
        
    }
    
    public void createBBDD(String dbDirectory) {
        // Botón de conectar
        jtaLector.setText("");
        try {
            // TODO add your handling code here:
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
                jtaLector.append(rs.getString("Nick:") + " | ");
                jtaLector.append(rs.getString("NOMBRE") + " | ");
                jtaLector.append(rs.getString("EQUIPO") + "\n");
            }
            
            stmt.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPSqlite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPSqlite.class.getName()).log(Level.SEVERE, null, ex);
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
