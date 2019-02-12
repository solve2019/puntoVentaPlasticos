/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdialog;

import ClasesDAO.accesoSistema;
import Utilerias.funciones;
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
public class EditarCantidad extends javax.swing.JDialog {
int fila;
String precios,ids;
String existencias;
String idproduc;
float totales=0;
    /**
     * Creates new form EditarCantidad
     */
    public EditarCantidad(java.awt.Frame parent, boolean modal,int filas, String producto, String cantidad, String precio, String existencia,String idprod,String total,String descuento) {
        super(parent, modal);
        initComponents();
        jtcatlotes.getColumnModel().getColumn(0).setMaxWidth(60);
        jtcatlotes.getColumnModel().getColumn(0).setMinWidth(60);
        jtcatlotes.getColumnModel().getColumn(0).setPreferredWidth(60);
        jtcatlotes.getColumnModel().getColumn(0).setWidth(60);
        
        this.setLocationRelativeTo(null);
        totales=Float.parseFloat(total);
        jlproducto.setText(producto);
        txtdescuento.setText(descuento);
        txtcantidadactual.setText(cantidad);
        txtcantidadnueva.setText(cantidad);
        txttotal.setText(total);
        fila=filas;
        precios=precio;
        existencias=existencia;
        ids=idprod;
        idproduc=idprod;
        txtcantidadnueva.requestFocus();
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
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jlproducto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtcantidadactual = new javax.swing.JTextField();
        txttotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtdescuento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtcantidadnueva = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        panellotes = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcantibiotico = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtlote = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtcatlotes = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Actualizar Cantidad");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(249, 247, 247));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(249, 247, 247));

        jlproducto.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jlproducto.setText("-");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel1.setText("Producto:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel3.setText("Cantidad Actual:");

        txtcantidadactual.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcantidadactual.setEnabled(false);
        txtcantidadactual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadactualKeyTyped(evt);
            }
        });

        txttotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttotalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel2.setText("Monto para calcular descuento:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel5.setVisible(true);
        jLabel5.setText("Descuento:");

        txtdescuento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtdescuento.setVisible(true);
        txtdescuento.setText("0");
        txtdescuento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescuentoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel6.setVisible(true);
        jLabel6.setText("%");

        txtcantidadnueva.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtcantidadnueva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadnuevaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadnuevaKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        jLabel4.setText("Cantidad Nueva:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidadactual))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtcantidadnueva))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txttotal))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlproducto))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtcantidadactual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtdescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantidadnueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venta", jPanel2);

        panellotes.setBackground(new java.awt.Color(249, 247, 247));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Es antibiotico:");

        jcantibiotico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "SI" }));

        jLabel8.setText("Lote:");

        txtlote.setEnabled(false);

        jtcatlotes.getTableHeader().setReorderingAllowed(false) ;
        jtcatlotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Lote", "Descripcion", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtcatlotes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtcatlotes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtcatlotesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtcatlotes);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Buscar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Limpiar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panellotesLayout = new javax.swing.GroupLayout(panellotes);
        panellotes.setLayout(panellotesLayout);
        panellotesLayout.setHorizontalGroup(
            panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellotesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panellotesLayout.createSequentialGroup()
                        .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panellotesLayout.createSequentialGroup()
                                .addComponent(txtBusqueda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton2))
                            .addGroup(panellotesLayout.createSequentialGroup()
                                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtlote)
                                    .addComponent(jcantibiotico, 0, 162, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panellotesLayout.setVerticalGroup(
            panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panellotesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcantibiotico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtlote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jButton3))
                .addGap(13, 13, 13)
                .addGroup(panellotesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Farmacia", panellotes);
        if(accesoSistema.menufarmacia.equals("0")){
            panellotes.setVisible(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txtcantidadactualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadactualKeyTyped
        // TODO add your handling code here:
        
        
        if(txtcantidadactual.getText().trim().length()>=4){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }
        }
        
    }//GEN-LAST:event_txtcantidadactualKeyTyped

    private void txtcantidadnuevaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadnuevaKeyTyped
        // TODO add your handling code here:
        if(txtcantidadnueva.getText().trim().length()>=7){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) && (evt.getKeyChar() != '.')){
               evt.consume(); // ignorar el evento de teclado
            }
            
            
        }
    }//GEN-LAST:event_txtcantidadnuevaKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       cargarcantidad();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
         Ventas.txtproducto.requestFocus();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
         Ventas.txtproducto.requestFocus();
    }//GEN-LAST:event_formWindowClosing

    private void txtcantidadnuevaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadnuevaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            cargarcantidad();
         }            
    }//GEN-LAST:event_txtcantidadnuevaKeyPressed

    private void txtdescuentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtcantidadnueva.requestFocus();
        }
    }//GEN-LAST:event_txtdescuentoKeyPressed

    private void txtdescuentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescuentoKeyTyped
        // TODO add your handling code here:

        if(txtdescuento.getText().trim().length()>=2){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
                evt.consume(); // ignorar el evento de teclado
            }
        }

    }//GEN-LAST:event_txtdescuentoKeyTyped

    private void txttotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyTyped
        // TODO add your handling code here:
        if(txttotal.getText().trim().length()>=6){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
                evt.consume(); // ignorar el evento de teclado
            }
        }
    }//GEN-LAST:event_txttotalKeyTyped

    private void txttotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalKeyReleased
        // TODO add your handling code here:
        String val=txttotal.getText().trim();
        System.out.println(""+val);
        if(val.equals("")){
         val="0";
        }
        Float totalnuevo=Float.parseFloat(val);
        if(totalnuevo>totales){
            JOptionPane.showMessageDialog(null, "El monto nuevo no puede ser mayor al costo total","Alerta",JOptionPane.ERROR_MESSAGE);            
        }else{
            double descue=totales-totalnuevo;
            double a=descue*100;
            double descporcentaje=a/totales;  
            funciones redondear=new funciones();
            descporcentaje=redondear.redondearDecimales(descporcentaje, 2);
            txtdescuento.setText(descporcentaje+"");
        }
        
    }//GEN-LAST:event_txttotalKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtlote.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jtcatlotesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtcatlotesMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int fila=-1;
            fila=jtcatlotes.getSelectedRow();
            if(fila!=-1){
                String id=jtcatlotes.getValueAt(jtcatlotes.getSelectedRow(),0).toString();                
                String lote=jtcatlotes.getValueAt(jtcatlotes.getSelectedRow(),1).toString();                
                txtlote.setText(id+"-"+lote);

            }else{            
                //TiketPDF etiqueta=new TiketPDF();
                //etiqueta.imprimiretiqueta("coca cola", "44574423552");
                JOptionPane.showMessageDialog(null,"Seleccione un lote de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtcatlotesMouseClicked

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
            java.util.logging.Logger.getLogger(EditarCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarCantidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditarCantidad dialog = new EditarCantidad(new javax.swing.JFrame(), true,1,"","","","","","","");
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

    public void cargarcantidad(){
        String cantidadanterior=txtcantidadactual.getText().trim();
        String cantidadnueva=txtcantidadnueva.getText().trim();
        String descuento=txtdescuento.getText().trim();
        String antibiotico=jcantibiotico.getSelectedItem().toString();
        String lote=txtlote.getText().trim();
        if(descuento.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de descuento no debe ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
        }else if(cantidadnueva.equals("")){
            JOptionPane.showMessageDialog(null, "El campo de cantidad no debe ir vacio.", "Alerta", JOptionPane.ERROR_MESSAGE);        
        }else{
            float cantinueva=Float.parseFloat(cantidadnueva);
            float cantiantes=Float.parseFloat(cantidadanterior);
            float preci=Float.parseFloat(precios);
            
            float descuen=Float.parseFloat(descuento);
            
            int cantidad_minimamayoreo=0,cantidadpromo=0;
            float preciomayoreo=0,precionormal=0,preciopromo=0;
            double ieps=0;
            conex con=new conex();          
            ResultSet rs = null;       
            String myQuery = "SELECT * FROM tc_productos where idproducto='"+ids+"'";        
            try {  
                Statement st = con.getConnection().createStatement();
                rs = st.executeQuery(myQuery);            
                while(rs.next()) {                     
                    cantidad_minimamayoreo=rs.getInt("cantidad_mayoreo");
                    preciomayoreo=rs.getFloat("precio_mayoreo");
                    precionormal=rs.getFloat("precio_venta");
                    preciopromo=rs.getFloat("precio_promocion");
                    cantidadpromo=rs.getInt("cantidad_promocion");
                    ieps=rs.getDouble("ieps");
                    if(cantidad_minimamayoreo==0){
                        cantidad_minimamayoreo=1000;
                    }
                }
                rs.close(); 
                st.close();
                con.desconectar();                
            } catch (SQLException ex) {
            }
            System.out.println(cantinueva+">="+cantidad_minimamayoreo);
            if(cantinueva>=cantidad_minimamayoreo){
                preci=preciomayoreo;
            }else{
                preci=precionormal;
            }
            
            //PROMOCION
            if(cantidadpromo!=0 && cantinueva>=cantidadpromo){
                int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.out.println("PRECIO PROMO");
                    preci=preciopromo;
                }                 
            }
            //FIN PROMO
            
            
            float total=preci*(cantinueva);//nuevo precio de la venta            
            
            total=total-((total*descuen)/100);
            
            
            float existenciafisica=obtenexistencia(idproduc+"");
            //int existen=Integer.parseInt(existencias)-cantinueva; //se recalcula la existencia
            float existen=existenciafisica-cantinueva; //se recalcula la existencia
            
            funciones redondear=new funciones();              
            ieps=ieps*preci;
            ieps=redondear.redondearDecimales(ieps, 2);
            ieps=ieps*Integer.parseInt(cantidadnueva); 
            ieps=redondear.redondearDecimales(ieps, 2);
           
            Ventas.jtproductos.setValueAt(preci+"", fila, 2);
            Ventas.jtproductos.setValueAt(cantidadnueva, fila, 3);
            Ventas.jtproductos.setValueAt(total+"", fila, 4);
            Ventas.jtproductos.setValueAt(existen+"", fila, 5);
            Ventas.jtproductos.setValueAt(descuento+"", fila, 7);                        
            Ventas.jtproductos.setValueAt(ieps+"", fila, 8);                        
            Ventas.jtproductos.setValueAt(antibiotico+"", fila, 9);   
            Ventas.jtproductos.setValueAt(lote+"", fila, 10);   
            Ventas.cargar_informacion();            
            JOptionPane.showMessageDialog(null, "Se modifico la cantidad correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                   
            dispose();
            Ventas.txtproducto.requestFocus();
        }        
    
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcantibiotico;
    private javax.swing.JLabel jlproducto;
    private javax.swing.JTable jtcatlotes;
    private javax.swing.JPanel panellotes;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtcantidadactual;
    private javax.swing.JTextField txtcantidadnueva;
    private javax.swing.JTextField txtdescuento;
    private javax.swing.JTextField txtlote;
    private javax.swing.JTextField txttotal;
    // End of variables declaration//GEN-END:variables

    public int obtenexistencia(String idprod){
        int cantidad=0;
        
            conex con=new conex();  
            try {
                String myQuery = "select existencia from tc_productos where idproducto='"+idprod+"'";
                System.out.println(""+myQuery);
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                                        
                        cantidad=rsR.getInt("existencia");                        
                }
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {       
                //JOptionPane.showMessageDialog(null, "Error al obtener datos del producto: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }  
        
        
        return cantidad;
    }
    
    public void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtcatlotes.getModel();         
            for (int i = 0; i < jtcatlotes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    public void cargartabla(){   
        funciones funct=new funciones();
        double iva=1+funct.obteniva();  
        vaciartabla();
        String buscar=txtBusqueda.getText().trim();
        DefaultTableModel modelo=(DefaultTableModel) jtcatlotes.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String sqlaux="";
        if(buscar.equals("")){
        }else{
            sqlaux=sqlaux+" and (lote like '%"+buscar+"%' or descripcion like '%"+buscar+"%')";
        }
        String myQuery = "select * from farmacia_to_lotes where estatus=1"+sqlaux+" and cantidad>0";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                             
                            modelo.addRow(new Object[]{rsR.getString("Id_lotes"),rsR.getString("lote"),rsR.getString("descripcion"),rsR.getString("cantidad")});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }
}
