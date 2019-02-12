/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciotecnico;

import conexion.conex;
import static conexion.conex.ip;
import java.awt.Frame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author desarrollo8
 */
public class ServicioTec extends javax.swing.JFrame {

    /**
     * Creates new form ServicioTec
     */
    public ServicioTec() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        cargartabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jmreimprimir = new javax.swing.JMenuItem();
        jmcerrar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtcliente = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        txtmarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmodelo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtimei = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtestado = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtservicios = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtobservaciones = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jmreimprimir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmreimprimir.setText("Reimprimir Nota Servicio");
        jmreimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmreimprimirActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmreimprimir);

        jmcerrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jmcerrar.setText("Cerrar servicio");
        jmcerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmcerrarActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jmcerrar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Servicio Tecnico");

        jPanel1.setBackground(new java.awt.Color(251, 251, 251));

        jLabel1.setText("Cliente:");

        jLabel2.setText("Teléfono:");

        jLabel3.setText("Correo:");

        jLabel4.setText("Marca:");

        jLabel5.setText("Modelo:");

        jLabel6.setText("IMEI:");

        jLabel7.setText("Estado:");

        txtestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona..", "BUENO", "REGULAR", "MALO" }));

        jLabel8.setText("Observaciones:");

        jtservicios.getTableHeader().setReorderingAllowed(false);
        jtservicios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jtservicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Fecha", "Cliente", "Teléfono", "Correo", "Marca", "Modelo", "IMEI", "Estado", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtservicios.setComponentPopupMenu(jPopupMenu1);
        jtservicios.setRowHeight(22);
        jtservicios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtservicios);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/guardar.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtobservaciones.setColumns(20);
        txtobservaciones.setRows(5);
        jScrollPane3.setViewportView(txtobservaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtmodelo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtimei, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(jScrollPane3)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcorreo, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtcliente)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono)
                            .addComponent(txtmarca, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtimei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jMenu1.setText("Reportes");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Servicios generados");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String cliente=txtcliente.getText().trim();
        String telefono=txttelefono.getText().trim();
        String correo=txtcorreo.getText().trim();
        String marca=txtmarca.getText().trim();
        String modelo=txtmodelo.getText().trim();
        String estado=txtestado.getSelectedItem().toString();
        String observaciones=txtobservaciones.getText().trim();
        String imei=txtimei.getText().trim();
        if(cliente.equals("")){
            txtcliente.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(telefono.equals("")){
            txttelefono.requestFocus();
            JOptionPane.showMessageDialog(null, "Ingrese el numero de telefono del cliente", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(marca.equals("")){
            txtmarca.requestFocus();
             JOptionPane.showMessageDialog(null, "Ingrese la marca del equipo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(modelo.equals("")){
            txtmodelo.requestFocus();
             JOptionPane.showMessageDialog(null, "Ingrese el modelo del equipo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else if(imei.equals("")){
            txtimei.requestFocus();
             JOptionPane.showMessageDialog(null, "Ingrese el no serie del equipo", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
            
            conex cn = new conex();    
            String sql="insert into to_recepcion (nombre,correo,telefono,fecha,observaciones,imei, marca,modelo, estado,estatus) values ('"+cliente+"','"+correo+"','"+telefono+"',now(),'"+observaciones+"','"+imei+"','"+marca+"','"+modelo+"','"+estado+"','ABIERTA')";
            System.out.println(sql);
            PreparedStatement pstm100;
            try {
                String folio="0";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
                pstm100.executeUpdate();  
                sql="select id from to_recepcion order by id desc limit 1";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);                
                ResultSet rs=pstm100.executeQuery();    
                while(rs.next()){
                    folio=rs.getString("id");
                }
                
                pstm100.close();
                cn.desconectar();
                txtcliente.setText("");
                txttelefono.setText("");
                txtcorreo.setText("");
                txtmarca.setText("");
                txtmodelo.setText("");
                txtestado.setSelectedIndex(0);
                txtobservaciones.setText("");
                txtimei.setText("");
                cargartabla();
                ticketentrega tick=new ticketentrega();
                System.out.println("folio: "+folio);
                tick.ImprimirServicio(folio);
                JOptionPane.showMessageDialog(null, "Se registro correctamente el servicio.", "OK", JOptionPane.INFORMATION_MESSAGE);                
            } catch (SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
            }
        
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jmreimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmreimprimirActionPerformed
        // TODO add your handling code here:
        int fila=-1;
        fila=jtservicios.getSelectedRow();
        if(fila!=-1){
            String folio=jtservicios.getValueAt(jtservicios.getSelectedRow(),0).toString();
            ticketentrega tick=new ticketentrega();
            System.out.println("folio: "+folio);
            tick.ImprimirServicio(folio);

        }else{
            //TiketPDF etiqueta=new TiketPDF();
            //etiqueta.imprimiretiqueta("coca cola", "44574423552");
            JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jmreimprimirActionPerformed

    private void jmcerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmcerrarActionPerformed
        // TODO add your handling code here:
        int fila=-1;
        fila=jtservicios.getSelectedRow();
        if(fila!=-1){
            String folio=jtservicios.getValueAt(jtservicios.getSelectedRow(),0).toString();
            String cliente=jtservicios.getValueAt(jtservicios.getSelectedRow(),2).toString();
            ticketentrega tick=new ticketentrega();
            System.out.println("folio: "+folio);
            Frame f = JOptionPane.getFrameForComponent(this);
            CerrarServicio venta=new CerrarServicio(f,true,folio,cliente);
            venta.show();

        }else{
            //TiketPDF etiqueta=new TiketPDF();
            //etiqueta.imprimiretiqueta("coca cola", "44574423552");
            JOptionPane.showMessageDialog(null,"Seleccione un servicio de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jmcerrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Reporte rep=new Reporte();
        rep.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(ServicioTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServicioTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServicioTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServicioTec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServicioTec().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JMenuItem jmcerrar;
    private javax.swing.JMenuItem jmreimprimir;
    public static javax.swing.JTable jtservicios;
    private javax.swing.JTextField txtcliente;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JComboBox<String> txtestado;
    private javax.swing.JTextField txtimei;
    private javax.swing.JTextField txtmarca;
    private javax.swing.JTextField txtmodelo;
    private javax.swing.JTextArea txtobservaciones;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtservicios.getModel();         
            for (int i = 0; i < jtservicios.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public static void cargartabla(){    
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtservicios.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from to_recepcion where estatus='ABIERTA'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("Id"),rsR.getString("fecha"),rsR.getString("nombre"),rsR.getString("telefono"),rsR.getString("correo"),rsR.getString("marca"),rsR.getString("modelo"),rsR.getString("imei"),rsR.getString("estado"),rsR.getString("observaciones")});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    } 
}