/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdialog;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import jinternalPanel.Ventas;

/**
 *
 * @author JOSE
 */
public class ProductoComun extends javax.swing.JDialog {

    /**
     * Creates new form ProductoComun
     */
    public ProductoComun(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(this);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtdescripcion = new javax.swing.JTextField();
        txtcantidad = new javax.swing.JTextField();
        txtmonto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Producto Común");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));

        jPanel2.setBackground(new java.awt.Color(255, 51, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Producto Común");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel2.setText("DESCRIPCIÓN");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel3.setText("COSTO");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("CANTIDAD");

        txtdescripcion.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });

        txtcantidad.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txtmonto.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtmonto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtmontoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtmontoKeyTyped(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtcantidad)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtmonto)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    private void txtmontoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyTyped
        // TODO add your handling code here:
        if(txtmonto.getText().trim().length()>=7){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) && (evt.getKeyChar() != '.')){
               evt.consume(); // ignorar el evento de teclado
            }
        }
    }//GEN-LAST:event_txtmontoKeyTyped

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
        if(txtcantidad.getText().trim().length()>=5){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }
        }
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        // TODO add your handling code here:
        if(txtdescripcion.getText().trim().length()>=50){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void txtdescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcantidad.requestFocus();
        }
    }//GEN-LAST:event_txtdescripcionKeyPressed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtmonto.requestFocus();
        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtmontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtmontoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            registrar();
        }
    }//GEN-LAST:event_txtmontoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        registrar();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProductoComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductoComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductoComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductoComun.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ProductoComun dialog = new ProductoComun(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtdescripcion;
    private javax.swing.JTextField txtmonto;
    // End of variables declaration//GEN-END:variables

    public void registrar(){
        String idprod="0";
            boolean validador=true;
            double montook=0;
            try{
                montook = Double.parseDouble(txtmonto.getText().trim());
                System.out.println(""+montook);
            } catch (NumberFormatException nfe) {
                validador=false;                
            }
            if(txtdescripcion.getText().trim().equals("")){
                txtdescripcion.requestFocus();
                JOptionPane.showMessageDialog(null, "Debe de ingresar la descripcion del producto.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }else if(txtcantidad.getText().trim().equals("")){                
                txtcantidad.requestFocus();
                JOptionPane.showMessageDialog(null, "La cantidad no debe de ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }else if(txtmonto.getText().trim().equals("")){                
                txtmonto.requestFocus();
                JOptionPane.showMessageDialog(null, "El costo no debe de ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }else if(validador==false){
                JOptionPane.showMessageDialog(null, "El costo es invalido favor de verificar.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }else{
                    conex con=new conex();  
                    try {
                        String myQuery = "insert into tc_productos (codigo_barras,nombre_producto,precio_compra,precio_venta,cantidad_minima,estatus,fecha_registro,usuario_registro,existencia) "
                                + "values('','"+txtdescripcion.getText().trim()+"','"+txtmonto.getText().trim()+"','"+txtmonto.getText().trim()+"','"+txtcantidad.getText().trim()+"',3,now(),'"+accesoSistema.nombreuser+"',1000)";
                        System.out.println(""+myQuery);
                        ResultSet rsR = null; 
                        Statement st = con.getConnection().createStatement();
                        st.executeUpdate(myQuery);
                        myQuery="select idproducto from tc_productos order by idproducto desc limit 1";
                        rsR=st.executeQuery(myQuery);
                        while(rsR.next()) {   
                            idprod=rsR.getString("idproducto");
                        }
                        rsR.close();
                        st.close();
                        con.desconectar();                  
                    } catch (SQLException ex) {       

                    }  
                double total=Double.parseDouble(txtmonto.getText().trim())*Double.parseDouble(txtcantidad.getText().trim());
                System.out.println("idprod: "+idprod+"    cantidad: "+txtcantidad.getText().trim());
                Ventas.cargar_productobusquedacomun(idprod,txtcantidad.getText().trim(),total+"");            
                dispose();
            }
    }
}