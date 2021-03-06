/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraspasoProductos;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo8
 */
public class Traspasos extends javax.swing.JInternalFrame implements KeyListener {

    /**
     * Creates new form Traspasos
     */
    public Traspasos() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        txtfechaini.setCalendar(c2);
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

        jptablenotas = new javax.swing.JPopupMenu();
        jmeliminarnota = new javax.swing.JMenuItem();
        jmverpdf = new javax.swing.JMenuItem();
        jmcerrarnota = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jttraspasos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                if(colIndex==3){ //Con esto se pueden editar todas las celdas menos la de la columna 0  colIndex==7 ||
                    return true;
                }
                else{
                    return false;
                }

                //return false; //Disallow the editing of any cell
            }
        };
        jScrollPane2 = new javax.swing.JScrollPane();
        jtnotas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtfechaini = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jlnota = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jltotal = new javax.swing.JLabel();
        jlestatusnota = new javax.swing.JLabel();

        jmeliminarnota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        jmeliminarnota.setText("Eliminar Nota de Traspaso");
        jmeliminarnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmeliminarnotaActionPerformed(evt);
            }
        });
        jptablenotas.add(jmeliminarnota);

        jmverpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pdfIco.jpg"))); // NOI18N
        jmverpdf.setText("Ver PDF Traspaso");
        jmverpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmverpdfActionPerformed(evt);
            }
        });
        jptablenotas.add(jmverpdf);

        jmcerrarnota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jmcerrarnota.setText("Cerrar Traspaso (Procesado)");
        jmcerrarnota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmcerrarnotaActionPerformed(evt);
            }
        });
        jptablenotas.add(jmcerrarnota);

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Traspaso de Productos");

        jPanel1.setBackground(new java.awt.Color(248, 246, 246));

        jttraspasos.getTableHeader().setReorderingAllowed(false) ;
        jttraspasos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jttraspasos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo de Barras", "Producto", "Cantidad", "Id Prod"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jttraspasos.setCellSelectionEnabled(true);
        jttraspasos.setRowHeight(20);
        jttraspasos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jttraspasos.getColumnModel().getColumn(4).setMaxWidth(0);
        jttraspasos.getColumnModel().getColumn(4).setMinWidth(0);
        jttraspasos.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
        jttraspasos.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
        jScrollPane1.setViewportView(jttraspasos);

        jtnotas.getTableHeader().setReorderingAllowed(false) ;
        jtnotas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtnotas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "No. Traspaso", "Usuario Creación", "Fecha Creación", "Observación", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtnotas.setComponentPopupMenu(jptablenotas);
        jtnotas.setRowHeight(24);
        jtnotas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtnotas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtnotasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtnotas);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Código del Producto:");

        txtproducto.addKeyListener(this);
        txtproducto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproductoKeyPressed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("ENTER - Agregar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton3.setVisible(false);
        jButton3.setText("F10 Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jButton2.setText("DEL Borrar Art.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Fecha:");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton4.setText("Buscar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mas.png"))); // NOI18N
        jButton5.setText("Nuevo Traspaso");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("NOTA TRASPASO:");

        jlnota.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton6.setText("Asignar a Traspaso");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jltotal.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jltotal.setText("TOTAL: 0");

        jlestatusnota.setVisible(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlnota, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 185, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlestatusnota, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtfechaini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnota, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jltotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlestatusnota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!txtproducto.getText().trim().equals("")){
                cargar_producto(txtproducto.getText().trim());
            }
        }
    }//GEN-LAST:event_txtproductoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!txtproducto.getText().trim().equals("")){
            cargar_producto(txtproducto.getText().trim());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

       DefaultTableModel modelo=(DefaultTableModel) jttraspasos.getModel();  
          int fila=-1;
          fila=jttraspasos.getSelectedRow();
          if(fila!=-1){             
                modelo.removeRow(fila);                              
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
         }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        NuevoTraspaso dialog = new NuevoTraspaso(f, true);
        dialog.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jtnotasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtnotasMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            String novalidador=jtnotas.getValueAt(jtnotas.getSelectedRow(), 1).toString();
            String estatus=jtnotas.getValueAt(jtnotas.getSelectedRow(), 5).toString();
            jlnota.setText(novalidador);
            jlestatusnota.setText(estatus);
            cargartablaprod();
        }
    }//GEN-LAST:event_jtnotasMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(jlestatusnota.getText().trim().equals("CERRADA")){
            JOptionPane.showMessageDialog(null, "Ya no se pueden asignar productos al traspaso ya esta cerrado.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
        }else{
            registraproductos();
        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jmcerrarnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmcerrarnotaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();  
        int fila=-1;
        fila=jtnotas.getSelectedRow();
        if(fila!=-1){ 
            int response = JOptionPane.showConfirmDialog(null, "Desea cerrar el ciclo de transferencia?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) { 
                String id=jtnotas.getValueAt(jtnotas.getSelectedRow(), 0).toString();
                String notatraspaso=jtnotas.getValueAt(jtnotas.getSelectedRow(), 1).toString();
                String idprod=jtnotas.getValueAt(jtnotas.getSelectedRow(), 4).toString();
                conex con=new conex();                  
                String myQuery = "select * from to_traspasos where id_nota_traspaso='"+notatraspaso+"'";
                   //System.out.println(""+myQuery);
                ResultSet rs=null;
                   try {
                       Statement st = con.getConnection().createStatement();
                       Statement st2 = con.getConnection().createStatement();
                       rs=st.executeQuery(myQuery);     
                       while(rs.next()){
                           st2.executeUpdate("insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+rs.getString("idprod")+"','"+rs.getString("cantidad")+"',now(),'"+accesoSistema.nombreuser+"','SALIDA X TRASPASO')");                        
                           st2.executeUpdate("update tc_productos set existencia=existencia-"+rs.getString("cantidad")+" where idproducto='"+rs.getString("idprod")+"'");                        
                       }
                       
                       st2.executeUpdate("update to_traspasos_nota set estatus=1 where barcode='"+notatraspaso+"'");                        
                       rs.close();
                       st.close();
                       st2.close();
                       con.desconectar();
                       
                       JOptionPane.showMessageDialog(null, "Se realizo el traspaso correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
                   } catch (SQLException ex) {       

                       JOptionPane.showMessageDialog(null, "Error al realizar el traspaso: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                   }  
                cargartabla();
            }
        }
        
        
    }//GEN-LAST:event_jmcerrarnotaActionPerformed

    private void jmeliminarnotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmeliminarnotaActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();  
          int fila=-1;
          fila=jtnotas.getSelectedRow();
          if(fila!=-1){                 
            int response = JOptionPane.showConfirmDialog(null, "Desea eliminar la nota de transferencia?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {                        
                String id=jtnotas.getValueAt(jtnotas.getSelectedRow(), 0).toString();
                conex con=new conex();                  
                String myQuery = "update to_traspasos_nota set estatus=2 where IdNota='"+id+"'";
                   //System.out.println(""+myQuery);
                   try {
                       Statement st = con.getConnection().createStatement();
                       st.executeUpdate(myQuery);                    
                       st.close();
                       con.desconectar();
                       cargartabla();
                       JOptionPane.showMessageDialog(null, "Se elimino correctamente el traspaso", "OK", JOptionPane.INFORMATION_MESSAGE);
                   } catch (SQLException ex) {       

                       JOptionPane.showMessageDialog(null, "Error al eliminar el traspaso: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                   }  
            } 
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un traspaso de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
         }
                
    }//GEN-LAST:event_jmeliminarnotaActionPerformed

    private void jmverpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmverpdfActionPerformed
        // TODO add your handling code here:
      DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();  
      int fila=-1;
      fila=jtnotas.getSelectedRow();
      if(fila!=-1){   
        String id=jtnotas.getValueAt(jtnotas.getSelectedRow(), 0).toString(); 
        String notatraspaso=jtnotas.getValueAt(jtnotas.getSelectedRow(), 1).toString();                 
        String usuario=jtnotas.getValueAt(jtnotas.getSelectedRow(), 2).toString();                 
        String fecha=jtnotas.getValueAt(jtnotas.getSelectedRow(), 3).toString();                 
        String observacion=jtnotas.getValueAt(jtnotas.getSelectedRow(), 4).toString();                 
        String patharchivos=new File ("").getAbsolutePath ()+"\\traspasoproductos\\";
        boolean validaexisteqr=true;    
        String productos="";
        try {
            conex conn;
            ResultSet rs=null;
            conn = new conex();
            PreparedStatement pstm;
            pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from to_traspasos where id_nota_traspaso='"+notatraspaso+"'");
            rs=pstm.executeQuery();
            while(rs.next()){
                productos=productos+rs.getString("codbarprod")+"-"+rs.getString("cantidad")+"!";
            }
            rs.close();
            pstm.close();
            conn.desconectar();

        } catch (SQLException ex) {            
        }
        
        String datosqr=notatraspaso+"#"+usuario+"#"+fecha+"#"+observacion+"#"+productos;
        System.out.println("datosqr: "+datosqr);
        
        
        
        //obtenener datos partiendo de los delimitadores
        String delimiter = "#";
        String[] temp;
        temp = datosqr.split(delimiter);
        String nota=temp[0];
        System.out.println(nota);
        String user=temp[1];
        System.out.println(user);
        String fec=temp[2];
        System.out.println(fec);
        String obv=temp[3];
        System.out.println(obv);
        String prodcanttotales=temp[4];
        System.out.println(prodcanttotales);
        
        String delimiter2 = "!";
        String[] temp2;
        temp2 = prodcanttotales.split(delimiter2);
        System.out.println("longitud: "+temp2.length);
        for(int i=0;i<temp2.length;i++){
            String prodcant=temp2[i];            
            //System.out.println(""+prodcant);
            
            //cortar cantidad y codigo de barras
            String delimiter3 = "-";
            String[] temp3;
            temp3 = prodcant.split(delimiter3);
            String codbar=temp3[0]; 
            String cantidad=temp3[1];
            //System.out.println("codbar: "+codbar);
            //System.out.println("cantidad: "+cantidad);
            //fin cortar cadena de codigo de barras y cantidad            
        }  
        //fin de particionado
        
        
        
        
        //System.out.println(""+datosqr);
        generarQR qr=new generarQR();
        validaexisteqr=qr.Genera_CodigoQR(notatraspaso, datosqr, patharchivos);        //nombre archivo,   informacion de qr,   ruta del archivo de qr
        if(validaexisteqr){//se genero la imagen QR
            qr.imprimirpdftranspaso(notatraspaso, fecha, observacion);
            JOptionPane.showMessageDialog(null, "El PDF de traspaso se genero correctamente.","Alerta",JOptionPane.INFORMATION_MESSAGE);
        }                
      }else{//no selecciono un traspaso
        JOptionPane.showMessageDialog(null, "Seleccionar un traspaso de la tabla para generar el PDF.","Alerta",JOptionPane.ERROR_MESSAGE);
      } 
        
        
    }//GEN-LAST:event_jmverpdfActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlestatusnota;
    public static javax.swing.JLabel jlnota;
    public static javax.swing.JLabel jltotal;
    private javax.swing.JMenuItem jmcerrarnota;
    private javax.swing.JMenuItem jmeliminarnota;
    private javax.swing.JMenuItem jmverpdf;
    private javax.swing.JPopupMenu jptablenotas;
    public static javax.swing.JTable jtnotas;
    public static javax.swing.JTable jttraspasos;
    public static com.toedter.calendar.JDateChooser txtfechaini;
    public static javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables

 public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();         
            for (int i = 0; i < jtnotas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }   
public static void cargartabla(){    
        vaciartabla();
        
        Date fecha=txtfechaini.getDate();        
        SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");  
        String fechainic=fechaformateada.format(fecha);
        
        DefaultTableModel modelo=(DefaultTableModel) jtnotas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from to_traspasos_nota where (estatus=1 or estatus=0) and date(fechamov)='"+fechainic+"'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {  
                       String estatus=rsR.getString("estatus");
                       if(estatus.equals("0")){
                           estatus="ABIERTA";
                       }
                       if(estatus.equals("1")){
                           estatus="CERRADA";
                       }
                            modelo.addRow(new Object[]{rsR.getString("IdNota"),rsR.getString("barcode"),rsR.getString("usuario_registro"),rsR.getString("fechamov"),rsR.getString("nota"),estatus});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }    
    

    public static void cargar_producto(String producto_code){
        String numerovalidador=jlnota.getText().trim();
        if(numerovalidador.equals("")){
            txtproducto.setText("");
            txtproducto.requestFocus();
             JOptionPane.showMessageDialog(null, "Error seleccione un numero de orden de traspaso.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{        
            DefaultTableModel modelo=(DefaultTableModel) jttraspasos.getModel();          
            String codigo_barras=producto_code;
            conex con=new conex();          
            ResultSet rs = null;       
            String myQuery = "SELECT * FROM tc_productos WHERE (codigo_barras='"+codigo_barras+"') and estatus=1";
            System.out.println(""+myQuery);
            try {  
                Statement st = con.getConnection().createStatement();
                rs = st.executeQuery(myQuery);            
                boolean existe=false;
                if(rs.next()) {                        
                    for(int fila=0; fila<jttraspasos.getRowCount(); fila++){                   
                        String idprod=jttraspasos.getValueAt(fila, 0).toString().trim();     
                        if(rs.getString("idproducto").toString().equals(idprod)){     
                            existe=true;
                        }
                    }       
                    if(existe==false){
                    modelo.addRow(new Object[]{rs.getString("idproducto"),rs.getString("codigo_barras"),rs.getString("nombre_producto"),"1",rs.getString("idproducto")});
                    }
                }

                rs.close(); 
                st.close();
                con.desconectar();       
            } catch (SQLException ex) {
            }
            txtproducto.setText("");
            txtproducto.requestFocus();
            
            
            jltotal.setText("TOTAL: "+modelo.getRowCount());
        }
    }

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.VK_F10==e.getKeyCode())
        {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {        
    }


    public void registraproductos(){    
    String validador=jlnota.getText().trim();
        if(validador.equals("")){
                txtproducto.setText("");
                txtproducto.requestFocus();
                 JOptionPane.showMessageDialog(null, "Error seleccione un numero de orden de traspaso.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{            
            DefaultTableModel modelo=(DefaultTableModel) jttraspasos.getModel();                      
            conex con=new conex();          
            String myQuery = "";
            try {  
                Statement st = con.getConnection().createStatement();   
                        myQuery="delete from to_traspasos where id_nota_traspaso='"+validador+"'";
                        System.out.println(""+myQuery);
                        st.executeUpdate(myQuery);   
                    for(int fila=0; fila<jttraspasos.getRowCount(); fila++){                   
                        String idprod=jttraspasos.getValueAt(fila, 4).toString().trim();     
                        String codbar=jttraspasos.getValueAt(fila, 1).toString().trim(); 
                        String cantidad=jttraspasos.getValueAt(fila, 3).toString().trim(); 
                        myQuery="insert into to_traspasos (idprod,cantidad,id_nota_traspaso,codbarprod) values('"+idprod+"','"+cantidad+"','"+validador+"','"+codbar+"')";
                        System.out.println(""+myQuery);
                        st.executeUpdate(myQuery);    
                    }                                           
                st.close();
                con.desconectar();     
                cargartablaprod();
                JOptionPane.showMessageDialog(null, "Se registraron los productos correctamente.", "OK", JOptionPane.INFORMATION_MESSAGE);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar los productos para el traspaso. "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            txtproducto.setText("");
            txtproducto.requestFocus();
            
        }
    }

    
    public static void vaciartablaprod(){
            DefaultTableModel modelo=(DefaultTableModel) jttraspasos.getModel();         
            for (int i = 0; i < jttraspasos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }  

public static void cargartablaprod(){    
        vaciartablaprod();    
         String validador=jlnota.getText().trim();
        DefaultTableModel modelo=(DefaultTableModel) jttraspasos.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from to_traspasos where id_nota_traspaso='"+validador+"'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {  
                            String nombreproduc=obtennombreprod(rsR.getString("idprod"));
                            modelo.addRow(new Object[]{rsR.getString("Idtraspaso"),rsR.getString("codbarprod"),nombreproduc,rsR.getString("cantidad"),rsR.getString("idprod")});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              jltotal.setText("TOTAL: "+modelo.getRowCount());
    }    


public static String obtennombreprod(String idprod){
String nombre="";


        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select nombre_producto from tc_productos where idproducto='"+idprod+"'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {   
                       nombre=rsR.getString("nombre_producto");
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }    


return nombre;
}
    
}
