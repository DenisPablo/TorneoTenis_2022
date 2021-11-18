/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.JugadorData;
import Data.PatrocinioData;
import Modelo.Conexion;
import Modelo.Jugador;
import Modelo.Patrocinio;
import Modelo.Sponsor;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Romi
 */
public class frmiAgregarJugador extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmiAgregarJugador
     */
    public frmiAgregarJugador() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField13 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        tfDni = new javax.swing.JTextField();
        tfAltura = new javax.swing.JTextField();
        tfPeso = new javax.swing.JTextField();
        rbDer = new javax.swing.JRadioButton();
        rbIzq = new javax.swing.JRadioButton();
        cbActivo = new javax.swing.JCheckBox();
        btnCargar = new javax.swing.JButton();
        cboEstilo = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        jdFecNac = new com.toedter.calendar.JDateChooser();

        jTextField13.setText("jTextField13");

        setClosable(true);
        setResizable(true);
        setTitle("Agregar Jugador");

        jLabel1.setText("Nombre");

        jLabel2.setText("Dni");

        jLabel3.setText("Fecha de Nacimiento");

        jLabel7.setText("Altura");

        jLabel8.setText("Peso");

        jLabel9.setText("Estilo");

        jLabel10.setText("Mano Habil");

        jLabel14.setText("Activo");

        tfDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDniActionPerformed(evt);
            }
        });
        tfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDniKeyTyped(evt);
            }
        });

        tfAltura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAlturaKeyTyped(evt);
            }
        });

        tfPeso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPesoKeyTyped(evt);
            }
        });

        rbDer.setText("Der");

        rbIzq.setText("Izq");

        btnCargar.setText("Cargar");
        btnCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCargarMouseClicked(evt);
            }
        });

        cboEstilo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agresivo", "Voleadores", "Jugadores" }));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        jdFecNac.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jdFecNac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfNombre)
                    .addComponent(tfDni)
                    .addComponent(tfAltura)
                    .addComponent(tfPeso)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbDer)
                        .addGap(29, 29, 29)
                        .addComponent(rbIzq))
                    .addComponent(cbActivo)
                    .addComponent(cboEstilo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
            .addGroup(layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(btnCargar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLimpiar)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfDni))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jdFecNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfAltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addComponent(tfPeso, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(cboEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbDer)
                            .addComponent(rbIzq))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbActivo)
                    .addComponent(jLabel14))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCargar)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked

        tfAltura.setText("");
        tfNombre.setText("");
        tfDni.setText("");
        tfPeso.setText("");
        tfNombre.setText("");
        cbActivo.setSelected(false);
        cboEstilo.setSelectedIndex(0);
        rbDer.setSelected(false);
        rbIzq.setSelected(false);
        jdFecNac.setDate(null);
    }//GEN-LAST:event_btnLimpiarMouseClicked

    private void btnCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCargarMouseClicked
        try {
            boolean a;
            Conexion con = new Conexion();
            Jugador j=new Jugador();
            JugadorData jd=new JugadorData(con);
            j.setNombre(tfNombre.getText());
            j.setDni(Integer.parseInt(tfDni.getText()));
            Date fecini=(Date) jdFecNac.getDate();
            LocalDate ld=fecini.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            j.setFechaNac(ld);
            j.setAltura(Double.parseDouble(tfAltura.getText()));
            j.setPeso(Double.parseDouble(tfPeso.getText()));
            j.setEstilo(cboEstilo.getSelectedItem().toString());
            if(rbDer.isSelected())
            j.setManoHabil("Derecha");
            if(rbIzq.isSelected())
            j.setManoHabil("Izquierda");
            j.setActivo(cbActivo.isSelected());
            a=jd.guardarJugador(j);
            if(a) {
               JOptionPane.showMessageDialog(null,"El Jugador se agrego con exito"); 
            } else {
                JOptionPane.showMessageDialog(null,"Error al conectar con la base de datos:" );
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(frmiAgregarSponsor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCargarMouseClicked

    private void tfDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDniActionPerformed

    private void tfDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDniKeyTyped
         char c=evt.getKeyChar();
     if(c<'0'||c>'9')evt.consume();
    }//GEN-LAST:event_tfDniKeyTyped

    private void tfAlturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAlturaKeyTyped
       char c=evt.getKeyChar();
     if(c<'0'||c>'9'||c=='.')evt.consume();
    }//GEN-LAST:event_tfAlturaKeyTyped

    private void tfPesoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesoKeyTyped
        char c=evt.getKeyChar();
     if(c<'0'||c>'9'||c=='.')evt.consume();
    }//GEN-LAST:event_tfPesoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox<String> cboEstilo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField13;
    private com.toedter.calendar.JDateChooser jdFecNac;
    private javax.swing.JRadioButton rbDer;
    private javax.swing.JRadioButton rbIzq;
    private javax.swing.JTextField tfAltura;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPeso;
    // End of variables declaration//GEN-END:variables
}
