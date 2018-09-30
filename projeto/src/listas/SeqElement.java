/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author aluno
 */
public class SeqElement extends javax.swing.JPanel {
    private int position;
    private int value;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
        showElement();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        showElement();
    }
    /**
     * Creates new form SeqElement
     */
    public SeqElement(int position, int value) {
        initComponents();
        this.position = position;
        this.value = value;    
        showElement();
        
        this.setVisible(true);


        
    }
    
    private void showElement() {
        element.setText(this.value + "");
        pos.setText("Pos: " + this.position);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        element = new javax.swing.JLabel();
        pos = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        element.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        element.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        element.setText("2");
        element.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos.setText("Pos: X");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(element, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pos, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pos, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(element, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel element;
    private javax.swing.JLabel pos;
    // End of variables declaration//GEN-END:variables
}
