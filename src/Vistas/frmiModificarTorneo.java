/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Data.TorneoData;
import Modelo.Conexion;
import Modelo.Torneo;
import static Vistas.frmiAgregarEncuentro.vHora;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Romi
 */
public class frmiModificarTorneo extends javax.swing.JInternalFrame {

     TorneoData orneo;
     Torneo j;
     TorneoData jd;
     Torneo j1;
    public frmiModificarTorneo(Conexion con) {
        initComponents();
        orneo=new TorneoData(con);
        j=new Torneo();
        jd=new TorneoData(con);
        j1= new Torneo();
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

        jLabel2 = new javax.swing.JLabel();
        BtnCargar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbActivo = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        cboorneo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jdInicio = new com.toedter.calendar.JDateChooser();
        jdFin = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setResizable(true);
        setTitle("Modificar Torneo");

        jLabel2.setText("Fecha de Inicio");

        BtnCargar.setText("Modificar");
        BtnCargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnCargarMouseClicked(evt);
            }
        });

        jLabel6.setText("Fecha Final");

        jLabel10.setText("Activo");

        jLabel1.setText("Nombre");

        jLabel11.setText("Torneo");

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseClicked(evt);
            }
        });

        jdInicio.setDateFormatString("yyyy-MM-dd");

        jdFin.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(44, 44, 44)
                                .addComponent(cbActivo))))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(cboorneo, 0, 251, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCargar)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar)
                        .addGap(45, 45, 45))))
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jdFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboorneo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbActivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCargar)
                    .addComponent(btnLimpiar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseClicked
       
        tfNombre.setText("");
        cbActivo.setSelected(false);
        cboorneo.setSelectedIndex(0);
        jdInicio.setDate(null);
        jdFin.setDate(null);

    }//GEN-LAST:event_btnLimpiarMouseClicked
public void cargarCbo(){
    List<Torneo> tor= orneo.devolverTodosTorneos();
    for (int i = 0; i < tor.size(); i++) {
        cboorneo.addItem(tor.get(i));
    }
 }

 public boolean vFecha(LocalDate ld) {
         LocalDate ld2 = ld;
         Period rango = Period.between(ld2, LocalDate.now());
         if (rango.getYears() < 1){ 
         return true;
         }
         JOptionPane.showMessageDialog(null, "No se puede modificar la fecha de inicio pasado el año.");
         return false;
         }

   public boolean validarCampos(){
        
    if(tfNombre.getText().isEmpty())         {return false;}
    if(jdInicio.getDate() == null)           {return false;} 
    if(jdFin.getDate() == null)              {return false;}
    if(cboorneo.getSelectedItem() == null)   {return false;}
    
    return true;
    }

    private void BtnCargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnCargarMouseClicked
        if(validarCampos()){ 
        j=(Torneo)cboorneo.getSelectedItem();
        j.setNombre(tfNombre.getText());
        Date fecini=(Date) jdInicio.getDate();
        LocalDate ld=fecini.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date fecFin=(Date) jdFin.getDate();
        LocalDate ld1=fecFin.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            
            if(vFecha(ld)){
            j.setFechaNacInicio(ld);            
            j.setFehcaNacFinal(ld1);
            j.setActivo(cbActivo.isSelected());
            
            jd.modificadarTorneo(j);
            }
            
        cboorneo.removeAllItems();
        cargarCbo();
        }else{JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");}
    }//GEN-LAST:event_BtnCargarMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        
        j1= (Torneo) cboorneo.getSelectedItem();
        tfNombre.setText(j1.getNombre());
        Date fecFin=java.sql.Date.valueOf(j1.getFechaNacInicio());
        jdInicio.setDate(fecFin);
        Date fecFin1=java.sql.Date.valueOf(j1.getFehcaNacFinal());
        jdFin.setDate(fecFin1);
       cbActivo.setSelected(j1.isActivo());
    }//GEN-LAST:event_btnBuscarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox cbActivo;
    private javax.swing.JComboBox<Torneo> cboorneo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private com.toedter.calendar.JDateChooser jdFin;
    private com.toedter.calendar.JDateChooser jdInicio;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
