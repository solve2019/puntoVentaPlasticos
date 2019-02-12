/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosVenta;

import conexion.conex;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jinternalPanel.Ventas;

/**
 *
 * @author desarrollo8
 */
public class CargarPosVenta extends javax.swing.JDialog {

    /**
     * Creates new form CargarPosVenta
     */
    public CargarPosVenta(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        cargarpendientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtpendientes = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtprodpendientes = new javax.swing.JTable();
        txtcodbarpendientes = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtcodbar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtcod = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtprodpos = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cargar Pos Venta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(247, 243, 243));

        jTabbedPane1.setBackground(new java.awt.Color(248, 247, 247));

        jPanel3.setBackground(new java.awt.Color(248, 247, 247));

        jtpendientes.getTableHeader().setReorderingAllowed(false);
        jtpendientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtpendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Folio", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtpendientes.setRowHeight(22);
        jtpendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtpendientesMouseClicked(evt);
            }
        });
        jtpendientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtpendientesKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jtpendientes);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito.png"))); // NOI18N
        jButton4.setText("Cargar a Venta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jtprodpendientes.getTableHeader().setReorderingAllowed(false);
        jtprodpendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtprodpendientes);

        txtcodbarpendientes.setVisible(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(txtcodbarpendientes, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtcodbarpendientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Ventas Pendientes", jPanel3);

        jPanel2.setBackground(new java.awt.Color(248, 247, 247));

        txtcodbar.setVisible(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo de Barras:");

        txtcod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcodKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtprodpos.getTableHeader().setReorderingAllowed(false);
        jtprodpos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtprodpos);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito.png"))); // NOI18N
        jButton2.setText("Cargar a Venta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcodbar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("Pos Venta", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!txtcod.getText().trim().equals("")){
                cargar();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcodKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
            if(!txtcod.getText().trim().equals("")){
                cargar();
            }
        }
    }//GEN-LAST:event_txtcodKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txtcodbar.getText().trim().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Debe cargar un codigo de barras de pos Venta.", "Error.", JOptionPane.ERROR_MESSAGE);
        }else{
           String codigo_barras=txtcodbar.getText().trim();
           conex con=new conex();          
           ResultSet rs = null;   
           String myQuery="";  
           DefaultTableModel modelo=(DefaultTableModel) Ventas.jtproductos.getModel();    
           myQuery = "SELECT * FROM to_pos_venta WHERE folio='"+codigo_barras+"' and tipo_venta='POSVENTA'"; //el estatus es producto comun       
           try {  
               Statement st = con.getConnection().createStatement();
               rs = st.executeQuery(myQuery);           
               while(rs.next()) {                                                                                 
                   modelo.addRow(new Object[]{rs.getString("codbar"),rs.getString("descprod"),rs.getString("preciounitario"),rs.getString("cantidad"),rs.getString("importe"),rs.getString("existencia"),rs.getString("idprod"),rs.getString("descuento"),rs.getString("ieps")});                   
               }          
               rs.close(); 
               st.close();
               con.desconectar();   
               Ventas.cargar_informacion();
               Ventas.txtproducto.requestFocus();
               dispose();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar los datos. "+ex, "Error.", JOptionPane.ERROR_MESSAGE);
           }       
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        vaciartabla();
        txtcod.requestFocus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Ventas.txtproducto.requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(txtcodbarpendientes.getText().trim().toString().equals("")){
            JOptionPane.showMessageDialog(null, "Debe seleccionar una Venta pendiente.", "Error.", JOptionPane.ERROR_MESSAGE);
        }else{
           String codigo_barras=txtcodbarpendientes.getText().trim();
           conex con=new conex();          
           ResultSet rs = null;   
           String myQuery="";  
           DefaultTableModel modelo=(DefaultTableModel) Ventas.jtproductos.getModel();    
           myQuery = "SELECT * FROM to_pos_venta WHERE folio='"+codigo_barras+"' and tipo_venta='VENTATEMPORAL'"; //el estatus es producto comun       
           try {  
               Statement st = con.getConnection().createStatement();
               rs = st.executeQuery(myQuery);           
               while(rs.next()) {                                                                                 
                   modelo.addRow(new Object[]{rs.getString("codbar"),rs.getString("descprod"),rs.getString("preciounitario"),rs.getString("cantidad"),rs.getString("importe"),rs.getString("existencia"),rs.getString("idprod"),rs.getString("descuento"),rs.getString("ieps")});                   
               }          
               myQuery = "delete from to_pos_venta WHERE folio='"+codigo_barras+"' and tipo_venta='VENTATEMPORAL'"; //el estatus es producto comun       
               st.executeUpdate(myQuery);   
               rs.close(); 
               st.close();
               con.desconectar();   
               Ventas.cargar_informacion();
               Ventas.txtproducto.requestFocus();
               dispose();
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Error al cargar los datos. "+ex, "Error.", JOptionPane.ERROR_MESSAGE);
           }       
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtpendientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtpendientesKeyPressed
        // TODO add your handling code here:
         int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
          DefaultTableModel modelo=(DefaultTableModel) jtpendientes.getModel();  
          int fila=-1;
          fila=jtpendientes.getSelectedRow();
          if(fila!=-1){
            String codigobarras=jtpendientes.getValueAt(fila, 1).toString();            
            cargarprodtemp(codigobarras);
            
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
          }
        }else{
        
        }
    }//GEN-LAST:event_jtpendientesKeyPressed

    private void jtpendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpendientesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {        
          DefaultTableModel modelo=(DefaultTableModel) jtpendientes.getModel();  
          int fila=-1;
          fila=jtpendientes.getSelectedRow();
          if(fila!=-1){
            String codigobarras=jtpendientes.getValueAt(fila, 1).toString();            
            cargarprodtemp(codigobarras);
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
          }
        }
    }//GEN-LAST:event_jtpendientesMouseClicked

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
            java.util.logging.Logger.getLogger(CargarPosVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CargarPosVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CargarPosVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CargarPosVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CargarPosVenta dialog = new CargarPosVenta(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtpendientes;
    private javax.swing.JTable jtprodpendientes;
    private javax.swing.JTable jtprodpos;
    private javax.swing.JTextField txtcod;
    private javax.swing.JTextField txtcodbar;
    private javax.swing.JTextField txtcodbarpendientes;
    // End of variables declaration//GEN-END:variables


 public void vaciartabla(){
        DefaultTableModel modelo=(DefaultTableModel) jtprodpos.getModel();         
            for (int i = 0; i < jtprodpos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
           
    }  
    public void cargar(){
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtprodpos.getModel();          
        String codigo_barras=txtcod.getText().trim();
        conex con=new conex();          
        ResultSet rs = null;   
        String myQuery="";       
        myQuery = "SELECT * FROM to_pos_venta WHERE folio='"+codigo_barras+"' and tipo_venta='POSVENTA'"; //el estatus es producto comun       
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);           
            while(rs.next()) {                                                              
                modelo.addRow(new Object[]{rs.getString("descprod"),rs.getString("preciounitario"),rs.getString("cantidad"),rs.getString("importe")});
                txtcodbar.setText(codigo_barras);
            }          
            rs.close(); 
            st.close();
            con.desconectar();                           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos. "+ex, "Error.", JOptionPane.ERROR_MESSAGE);
        }       
        txtcod.setText("");
        txtcod.requestFocus();
    }
    
    
    public void vaciartablapendientes(){
        DefaultTableModel modelo=(DefaultTableModel) jtpendientes.getModel();         
            for (int i = 0; i < jtpendientes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
           
    }  
    public void cargarpendientes(){
        vaciartablapendientes();
        DefaultTableModel modelo=(DefaultTableModel) jtpendientes.getModel();          
        String codigo_barras=txtcod.getText().trim();
        conex con=new conex();          
        ResultSet rs = null;   
        String myQuery="";       
        myQuery = "SELECT distinct(folio) as folio, Idposventa,fecha FROM to_pos_venta WHERE tipo_venta='VENTATEMPORAL' group by folio"; //el estatus es producto comun       
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);           
            while(rs.next()) {                                                              
                modelo.addRow(new Object[]{rs.getString("Idposventa"),rs.getString("folio"),rs.getString("fecha")});                
            }          
            rs.close(); 
            st.close();
            con.desconectar();                           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos temporales. "+ex, "Error.", JOptionPane.ERROR_MESSAGE);
        }               
    }


public void vaciartablaprodtemp(){
        DefaultTableModel modelo=(DefaultTableModel) jtprodpendientes.getModel();         
            for (int i = 0; i < jtprodpendientes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
           
    }  
    public void cargarprodtemp(String codigo_barras){
        vaciartablaprodtemp();
        DefaultTableModel modelo=(DefaultTableModel) jtprodpendientes.getModel();                  
        conex con=new conex();          
        ResultSet rs = null;   
        String myQuery="";       
        myQuery = "SELECT * FROM to_pos_venta WHERE folio='"+codigo_barras+"' and tipo_venta='VENTATEMPORAL'"; //el estatus es producto comun       
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);           
            while(rs.next()) {                                                              
                modelo.addRow(new Object[]{rs.getString("descprod"),rs.getString("preciounitario"),rs.getString("cantidad"),rs.getString("importe")});
                txtcodbarpendientes.setText(codigo_barras);
            }          
            rs.close(); 
            st.close();
            con.desconectar();                           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos. "+ex, "Error.", JOptionPane.ERROR_MESSAGE);
        }              
    }
    

    
}
