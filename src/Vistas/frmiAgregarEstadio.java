/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.EstadioData;
import Data.TorneoData;
import Modelo.Conexion;
import Modelo.Estadio;
import Modelo.Jugador;
import Modelo.Torneo;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Romi
 */
public class frmiAgregarEstadio extends javax.swing.JInternalFrame {

    private Estadio est;
    EstadioData estd;
    
    public frmiAgregarEstadio(Conexion con) {
        initComponents();
        
        estd = new EstadioData(con);
        est = new Estadio();
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nomnre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfCiudad = new javax.swing.JTextField();
        tfDirCom = new javax.swing.JTextField();
        tfDimension = new javax.swing.JTextField();
        cboCategoria = new javax.swing.JComboBox<>();
        cbActivo = new javax.swing.JCheckBox();
        btnCargar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Agregar Estadio");

        Nomnre.setText("Nombre");

        jLabel2.setText("Ciudad");

        jLabel3.setText("Categoria");

        jLabel4.setText("Direccion Comercial");

        jLabel5.setText("Dimension");

        jLabel6.setText("Activo");

        tfNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfNombreKeyReleased(evt);
            }
        });

        tfDimension.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDimensionKeyTyped(evt);
            }
        });

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cesped", "Cemento", "Ladrillo" }));

        btnCargar.setText("Cargar");
        btnCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarMouseClicked(evt);
            }
        });
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
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
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nomnre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(cboCategoria, 0, 217, Short.MAX_VALUE)
                    .addComponent(cbActivo)
                    .addComponent(tfNombre)
                    .addComponent(tfCiudad)
                    .addComponent(tfDirCom)
                    .addComponent(tfDimension))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCargar)
                .addGap(18, 18, 18)
                .addComponent(btnLimpiar)
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nomnre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDirCom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfDimension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbActivo)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked

        limpiar();
    }//GEN-LAST:event_btnLimpiarMouseClicked
 public void limpiar(){
       tfCiudad.setText("");
        tfDimension.setText("");
        tfDirCom.setText("");
        tfNombre.setText("");
        cbActivo.setSelected(false);
        cboCategoria.setSelectedIndex(0);
 }
 
   public boolean validarCampos(){

       if(est.getNombre().isEmpty())                   {return false;}
       if(est.getCiudad().isEmpty())                   {return false;}
       if(est.getCategoria().isEmpty())                {return false;}
       
       if(est.getDireccionComercial().isEmpty())       {return false;}
       if(est.getDimension().isEmpty())                {return false;}
      
       return true;
   }
 
    private void btnCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarMouseClicked
           

            est.setNombre(tfNombre.getText());
            est.setCiudad(tfCiudad.getText());
            est.setCategoria(cboCategoria.getSelectedItem().toString());
            est.setActivo(cbActivo.isSelected());
            est.setDireccionComercial(tfDirCom.getText());
            est.setDimension(tfDimension.getText());
         // j.setEstado(cbEstado.isSelected());
            if(validarCampos()){
            estd.guardarEstadio(est);
            }else{
            JOptionPane.showMessageDialog(null,"Por favor complete todos lo campos." );
            }
      limpiar();
         
    }//GEN-LAST:event_btnCargarMouseClicked

    private void tfDimensionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDimensionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDimensionKeyTyped

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCargarActionPerformed

    private void tfNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreKeyTyped

    private void tfNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreKeyReleased

    private void tfNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Nomnre;
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField tfCiudad;
    private javax.swing.JTextField tfDimension;
    private javax.swing.JTextField tfDirCom;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
