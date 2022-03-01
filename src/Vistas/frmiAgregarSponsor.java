/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.SponsorData;
import Modelo.Conexion;
import Modelo.Jugador;
import Modelo.Sponsor;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Romi
 */
public class frmiAgregarSponsor extends javax.swing.JInternalFrame {

        private Sponsor s;
        private SponsorData sponsor;
        
    public frmiAgregarSponsor(Conexion con) {
        initComponents();
        
        s = new Sponsor();
        sponsor = new SponsorData(con);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfMarca = new javax.swing.JTextField();
        cbActivo = new javax.swing.JCheckBox();
        btCargar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Agregar Sponsor");

        jLabel1.setText("Marca");

        jLabel2.setText("Activo");

        btCargar.setText("Cargar");
        btCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCargarMouseClicked(evt);
            }
        });
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbActivo))
                .addContainerGap(111, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btCargar)
                .addGap(27, 27, 27)
                .addComponent(btnLimpiar)
                .addGap(68, 68, 68))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cbActivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCargar)
                    .addComponent(btnLimpiar))
                .addGap(94, 94, 94))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
        limpiar();
       
    }//GEN-LAST:event_btnLimpiarMouseClicked
    private void limpiar() {
         tfMarca.setText("");
        cbActivo.setSelected(false);
    }
    
    public boolean validarCampos(){
   
        if(tfMarca.getText().isEmpty()) {return false;}
        
        return true; 
    }
    
    private void btCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCargarMouseClicked
        if(validarCampos()){
        
        s.setMarca(tfMarca.getText());
        s.setActivo(cbActivo.isSelected());
        sponsor.guardarSponsor(s);
        }else{JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");}
        //   JOptionPane.showMessageDialog(null,"Sponsor agregado con exito!");
        limpiar();
    }//GEN-LAST:event_btCargarMouseClicked

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCargarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField tfMarca;
    // End of variables declaration//GEN-END:variables
}
