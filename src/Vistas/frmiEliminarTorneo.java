/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.TorneoData;
import Modelo.Conexion;
import Modelo.Torneo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Romi
 */
public class frmiEliminarTorneo extends javax.swing.JInternalFrame {

        private TorneoData orneo;
        private Torneo p;
        private TorneoData patrocinio;
        private Torneo p1;
        private TorneoData patrocinio1;
   
    public frmiEliminarTorneo(Conexion con) {
        initComponents();
        orneo=new TorneoData(con);
        p=new Torneo();
        patrocinio=new TorneoData(con);
        p1=new Torneo();
        patrocinio1=new TorneoData(con);
        cargarCbo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        CboEliminarTorneo = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        CboActivarTorneo = new javax.swing.JComboBox<>();
        btnActivar1 = new javax.swing.JButton();

        setClosable(true);
        setResizable(true);
        setTitle("Eliminar/Agregar Torneo");

        jLabel35.setText("Eliminar");

        jLabel36.setText("Torneo");

        jLabel37.setText("Activar");

        jButton1.setText("Eliminar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel34.setText("Torneo");

        btnActivar1.setText("Activar");
        btnActivar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnActivar1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel37)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel35)
                        .addGap(263, 271, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CboActivarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CboEliminarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnActivar1)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(85, 85, 85))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel35)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(CboEliminarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel37)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CboActivarTorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addComponent(btnActivar1)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void cargarCbo(){
    List<Torneo> tor= orneo.devolverTodosTorneos();
    for (int i = 0; i < tor.size(); i++) {
        if(tor.get(i).isActivo()==false)
            CboActivarTorneo.addItem(tor.get(i));
    }
    for (int i = 0; i < tor.size(); i++) {
        if(tor.get(i).isActivo()==true)
            CboEliminarTorneo.addItem(tor.get(i));
    }
 }
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(CboEliminarTorneo.getSelectedItem() != null){
        p=(Torneo)CboEliminarTorneo.getSelectedItem();
        patrocinio.darBajaTorneo(p.getIdTorneo());
        }else{JOptionPane.showMessageDialog(null, "Seleccione un Torneo.");}
         CboActivarTorneo.removeAllItems();
         CboEliminarTorneo.removeAllItems(); 
        cargarCbo();
                   
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnActivar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActivar1MouseClicked
        if(CboActivarTorneo.getSelectedItem() != null){
        p1=(Torneo)CboActivarTorneo.getSelectedItem();
        patrocinio1.darAltaTorneo(p1.getIdTorneo());
        CboActivarTorneo.removeAllItems();
        CboEliminarTorneo.removeAllItems(); 
        }else{JOptionPane.showMessageDialog(null, "Seleccione un Torneo.");}
        cargarCbo();
    }//GEN-LAST:event_btnActivar1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Torneo> CboActivarTorneo;
    private javax.swing.JComboBox<Torneo> CboEliminarTorneo;
    private javax.swing.JButton btnActivar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    // End of variables declaration//GEN-END:variables
}
