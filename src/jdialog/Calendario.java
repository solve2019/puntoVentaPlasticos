/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdialog;

import com.toedter.calendar.JDateChooser;
import conexion.conex;
import static datechooser.model.multiple.DateOutputStyle.getDateFormat;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author JOSE
 */
public class Calendario extends javax.swing.JDialog {

    /**
     * Creates new form Calendario
     */
    public Calendario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarnotaini();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooserDialog1 = new datechooser.beans.DateChooserDialog();
        jPanel1 = new javax.swing.JPanel();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlfecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtnotas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtnota = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        dateChooserPanel1.setBehavior(datechooser.model.multiple.MultyModelBehavior.SELECT_SINGLE);
        dateChooserPanel1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserPanel1OnSelectionChange(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 245, 245));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Fecha:");

        jlfecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jtnotas.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jtnotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nota"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtnotas.setRowHeight(22);
        jScrollPane1.setViewportView(jtnotas);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtnota.setColumns(20);
        txtnota.setRows(5);
        txtnota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtnotaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtnota);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 49, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 772, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
        // TODO add your handling code here:        
        //System.out.println(""+dateChooserPanel1.getSelectedPeriodSet().toString(getDateFormat()));          
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");             
        String fec=dateChooserPanel1.getSelectedPeriodSet().toString(getDateFormat());
        Date dat=null;
        try {
            dat = getDateFormat().parse(fec);
        } catch (ParseException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fechas1=formatter.format(dat);
        
        jlfecha.setText(""+fechas1);
        cargarnotas(""+fechas1);
        
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        guardarnota();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int fila=-1;
            fila=jtnotas.getSelectedRow();
            if(fila!=-1){
                int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?","Alerta",JOptionPane.INFORMATION_MESSAGE);
                if(opc==JOptionPane.OK_OPTION){
                    String id=jtnotas.getValueAt(jtnotas.getSelectedRow(),0).toString();
                    conex con=new conex();                                               
                    try {
                        String myQuery = "delete from to_agenda where id_agenda='"+id+"'";
                        Statement st = con.getConnection().createStatement();
                        st.executeUpdate(myQuery);
                        st.close();
                        con.desconectar();
                        String fechas1=jlfecha.getText().trim();
                        cargarnotas(""+fechas1);
                        JOptionPane.showMessageDialog(null, "La nota se elimino correctamente. ", "Nota eliminado", JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException ex) {       

                        JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }   
                    
                }
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione una nota de la tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtnotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnotaKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){  
           guardarnota();
        }
    }//GEN-LAST:event_txtnotaKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calendario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Calendario dialog = new Calendario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private datechooser.beans.DateChooserDialog dateChooserDialog1;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlfecha;
    private javax.swing.JTable jtnotas;
    private javax.swing.JTextArea txtnota;
    // End of variables declaration//GEN-END:variables
public void cargarnotas(String fecha){
vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select id_agenda,nota from to_agenda where fecha='"+fecha+"'";
        System.out.println(""+myQuery);
        try {
            Statement st = con.getConnection().createStatement();
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {                                                
                     modelo.addRow(new Object[]{rsR.getString("id_agenda"),rsR.getString("nota")});                        
            }

            rsR.close(); 
            st.close();
            con.desconectar();
        } catch (SQLException ex) {       

            JOptionPane.showMessageDialog(null, "Error al obtener las notas: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }     
        jtnotas.getColumnModel().getColumn(0).setMaxWidth(85);
        jtnotas.getColumnModel().getColumn(0).setMinWidth(85);
        jtnotas.getColumnModel().getColumn(0).setPreferredWidth(85);
        jtnotas.getColumnModel().getColumn(0).setWidth(85);
}

 public void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();         
            for (int i = 0; i < jtnotas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }


 public void cargarnotaini(){
 
     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");             
        String fec=dateChooserPanel1.getSelectedPeriodSet().toString(getDateFormat());
        Date dat=null;
        try {
            dat = getDateFormat().parse(fec);
        } catch (ParseException ex) {
            Logger.getLogger(Calendario.class.getName()).log(Level.SEVERE, null, ex);
        }
        String fechas1=formatter.format(dat);
        
        jlfecha.setText(""+fechas1);
        cargarnotas(""+fechas1);
 
 
 }

public void guardarnota(){

       String fechas1=jlfecha.getText().trim();
        if(fechas1.equals("")){
            JOptionPane.showMessageDialog(null, "No ha seleccionado la fecha.", "Error", JOptionPane.PLAIN_MESSAGE);
        }else if(txtnota.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "No ha ingresado la nota.", "Error", JOptionPane.PLAIN_MESSAGE);
        }else{
            conex con=new conex();  
            try {
                String myQuery = "insert into to_agenda (fecha,nota) "
                + "values('"+fechas1+"','"+txtnota.getText().trim()+"')";
                //System.out.println(""+myQuery);
                Statement st = con.getConnection().createStatement();
                st.executeUpdate(myQuery);
                st.close();
                con.desconectar();     
                txtnota.setText("");
                txtnota.requestFocus();
                JOptionPane.showMessageDialog(null, "La nota se registro correctamente. ", "Nota registrado", JOptionPane.PLAIN_MESSAGE);                
            } catch (SQLException ex) {       

                JOptionPane.showMessageDialog(null, "Error al registrar la nota: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
            cargarnotas(""+fechas1);
        } 

}
 
}
