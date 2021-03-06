/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.juanxxiii.juansapp.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.juanxxiii.juansapp.controller.GestorJuansapp;
import net.juanxxiii.juansapp.controller.Message;
import net.juanxxiii.juansapp.controller.User;

/**
 *
 * @author Dam
 */
public class JPJuansapp extends javax.swing.JPanel {
    GestorJuansapp gj;
    User us;
    ArrayList<Message> messages;
    private String server;
    
    /**
     * Creates new form JPJuansapp
     */
    public JPJuansapp() {
        initComponents();
        gj = new GestorJuansapp();
        jbMessage.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfLastConnection = new javax.swing.JTextField();
        jbLastConnection = new javax.swing.JButton();
        jtfNickname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaMessages = new javax.swing.JTextArea();
        jtfMessage = new javax.swing.JTextField();
        jbMessage = new javax.swing.JButton();

        setBackground(new java.awt.Color(0, 153, 153));
        setNextFocusableComponent(jtaMessages);

        jtfLastConnection.setText("Escribe la Dirección de la BBDD");

        jbLastConnection.setText("Conectar");
        jbLastConnection.setSelected(true);
        jbLastConnection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLastConnectionActionPerformed(evt);
            }
        });

        jtfNickname.setText("Escribe tu Nickname");
        jtfNickname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfNicknameFocusGained(evt);
            }
        });

        jtaMessages.setColumns(20);
        jtaMessages.setRows(5);
        jScrollPane1.setViewportView(jtaMessages);

        jtfMessage.setText("Escriba aquí su mensaje...");
        jtfMessage.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfMessageFocusGained(evt);
            }
        });

        jbMessage.setText("Enviar");
        jbMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMessageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfLastConnection, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
                            .addComponent(jtfNickname))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLastConnection)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtfLastConnection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbLastConnection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMessage))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshMessages() {
        // Carga todos los mensajes y los mete en un array
        try {
            messages = gj.getDataBBDD(server);
            if (messages.size() != 0) {
                jtaMessages.setText("");
                for (Message message : messages) {
                    jtaMessages.append(message.toString());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay mensajes para mostrar");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Falla aqui");
        }
        
    }
    
    private void jtfNicknameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfNicknameFocusGained
        jtfNickname.setText("");
    }//GEN-LAST:event_jtfNicknameFocusGained

    private void jtfMessageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfMessageFocusGained
        jtfMessage.setText("");
    }//GEN-LAST:event_jtfMessageFocusGained

    private void jbMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMessageActionPerformed
        String body = jtfMessage.getText();
        if (!body.isEmpty()) {
            try {
                Message m = new Message(body, us.getNickname(), server);
                gj.sendMsgToBBDD(m);
                jtfMessage.setText("");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(JPJuansapp.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(JPJuansapp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.refreshMessages();
    }//GEN-LAST:event_jbMessageActionPerformed

    private void jbLastConnectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLastConnectionActionPerformed
        
        server = jtfLastConnection.getText();
        String nick = jtfNickname.getText();
        
        if (!server.isEmpty() && !nick.isEmpty()) {
            us = new User(nick, server);
            JOptionPane.showMessageDialog(null, "Bienvenido " + us.getNickname());
            jbMessage.setEnabled(true);
            this.refreshMessages();
        } else {
            JOptionPane.showMessageDialog(null, "Completa los campos");
        }
    }//GEN-LAST:event_jbLastConnectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbLastConnection;
    private javax.swing.JButton jbMessage;
    private javax.swing.JTextArea jtaMessages;
    private javax.swing.JTextField jtfLastConnection;
    private javax.swing.JTextField jtfMessage;
    private javax.swing.JTextField jtfNickname;
    // End of variables declaration//GEN-END:variables

}
