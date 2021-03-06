/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinternalPanel.Proveedores;

import ClasesDAO.accesoSistema;
import Utilerias.funciones;
import conexion.conex;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import puntoventa.RemisionPDF;
/**
 *
 * @author desarrollo8
 */
public class ReporteCompras extends javax.swing.JInternalFrame {

    /**
     * Creates new form ReporteCompras
     */
    public ReporteCompras() {
        initComponents();
        Calendar c2 = new GregorianCalendar();
        txtfechaini.setCalendar(c2);
        txtfechafin.setCalendar(c2);
        
        Date fecha=txtfechaini.getDate();
        Date fecha2=txtfechafin.getDate();
        SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");  
        String fechaformateadas=fechaformateada.format(fecha);
        String fechafin=fechaformateada.format(fecha2);
        jlrango.setText("Del "+fechaformateadas+"  Al  "+fechafin);
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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jlrango = new javax.swing.JLabel();
        txtfechaini = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtfechafin = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfolioscompra = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtdetallecompra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jlfolioactual = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlmontototal = new javax.swing.JLabel();
        jlnumerocompras = new javax.swing.JLabel();

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jMenuItem1.setText("Imprimir Comprobante de Compra");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        if(!accesoSistema.privilegio.equals("ADMINISTRADOR")){
            jMenuItem2.setVisible(false);
        }
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/close.png"))); // NOI18N
        jMenuItem2.setText("Eliminar Compra");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setTitle("Reporte de Compras");

        jPanel1.setBackground(new java.awt.Color(248, 247, 247));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Detalle de la Compra Folio:");

        jlrango.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlrango.setForeground(new java.awt.Color(102, 102, 102));
        jlrango.setText("Del                Al");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 153));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Del");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 153));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Al");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jtfolioscompra.getTableHeader().setReorderingAllowed(false) ;
        jtfolioscompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfolioscompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Folio", "Fecha Registro", "Monto", "Usuario Registro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtfolioscompra.setComponentPopupMenu(jPopupMenu1);
        jtfolioscompra.setRowHeight(20);
        jtfolioscompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtfolioscompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfolioscompraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtfolioscompra);

        jtdetallecompra.getTableHeader().setReorderingAllowed(false) ;
        jtdetallecompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtdetallecompra.setModel(new javax.swing.table.DefaultTableModel(
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
        jtdetallecompra.setRowHeight(20);
        jtdetallecompra.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtdetallecompra);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Resumen de Compras");

        jlfolioactual.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlfolioactual.setForeground(new java.awt.Color(102, 102, 102));

        jPanel2.setBackground(new java.awt.Color(243, 240, 240));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Número de Compras");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Compras Totales");

        jlmontototal.setFont(new java.awt.Font("Arial", 0, 36)); // NOI18N
        jlmontototal.setForeground(new java.awt.Color(0, 51, 153));
        jlmontototal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlmontototal.setText("0.00");

        jlnumerocompras.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jlnumerocompras.setForeground(new java.awt.Color(0, 51, 153));
        jlnumerocompras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlnumerocompras.setText("0.00");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlmontototal, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jlnumerocompras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(64, 64, 64))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlmontototal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlnumerocompras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlrango, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(136, 136, 136))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlfolioactual, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(974, 974, 974))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlrango, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtfechaini, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtfechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlfolioactual, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtfolioscompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfolioscompraMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2) {
            int fila=-1;
            fila=jtfolioscompra.getSelectedRow();
            if(fila!=-1){
                String id=jtfolioscompra.getValueAt(jtfolioscompra.getSelectedRow(),0).toString();                
                String folio=jtfolioscompra.getValueAt(jtfolioscompra.getSelectedRow(),1).toString();
                jlfolioactual.setText(folio);
                cargarcompras(folio);
            }               
        }
    }//GEN-LAST:event_jtfolioscompraMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int fila=-1;
            fila=jtfolioscompra.getSelectedRow();
            if(fila!=-1){
                String folio=jtfolioscompra.getValueAt(jtfolioscompra.getSelectedRow(),1).toString();   
                
                String[] opcion={"ticket","tamaño carta"};
                String resp=(String) JOptionPane.showInputDialog(null,"Selecciona la forma de impresión","Opcion de impresion",JOptionPane.DEFAULT_OPTION,null,opcion,opcion[0]);
                  
                if(resp.equals("ticket")){
                    TicketProveedor imprime=new TicketProveedor();                    
                    imprime.ReImprimirPago(folio+"");
                }else{
                    RemisionPDF compraas=new RemisionPDF();
                    compraas.imprimirPDFCompra(folio+"");                  
                }
                  
                
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar un folio de compra.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
            int fila=-1;
            fila=jtfolioscompra.getSelectedRow();
            if(fila!=-1){
                String id=jtfolioscompra.getValueAt(jtfolioscompra.getSelectedRow(),0).toString();   
               int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?","Alerta",JOptionPane.INFORMATION_MESSAGE);
                if(opc==JOptionPane.OK_OPTION){                    
                    conex con=new conex();                                               
                    try {
                        String myQuery = "update proveedor_to_compra set estatuscompra=0, fecha_cancelacion=now(),usuarioCancelo='"+accesoSistema.nombreuser+"' where IdCompraFolio='"+id+"'";
                        Statement st = con.getConnection().createStatement();
                        st.executeUpdate(myQuery);
                        st.close();
                        con.desconectar();
                        cargartabla();
                        vaciartablacompras();
                        JOptionPane.showMessageDialog(null, "El folio de compra se elimino correctamente. ", "Cliente eliminado", JOptionPane.PLAIN_MESSAGE);
                    } catch (SQLException ex) {       

                        JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }   
                    
                }
            }else{
                JOptionPane.showMessageDialog(null, "Debe seleccionar un folio de compra.", "Alerta", JOptionPane.ERROR_MESSAGE);        
            }
    }//GEN-LAST:event_jMenuItem2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlfolioactual;
    private javax.swing.JLabel jlmontototal;
    private javax.swing.JLabel jlnumerocompras;
    private javax.swing.JLabel jlrango;
    private javax.swing.JTable jtdetallecompra;
    private javax.swing.JTable jtfolioscompra;
    private com.toedter.calendar.JDateChooser txtfechafin;
    private com.toedter.calendar.JDateChooser txtfechaini;
    // End of variables declaration//GEN-END:variables


public void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtfolioscompra.getModel();         
            for (int i = 0; i < jtfolioscompra.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public void cargartabla(){
        vaciartabla();
        
        Date fecha=txtfechaini.getDate();
        Date fecha2=txtfechafin.getDate();
        SimpleDateFormat fechaformateada = new SimpleDateFormat("yyyy-MM-dd");  
        String fechaformateadas=fechaformateada.format(fecha);
        String fechafin=fechaformateada.format(fecha2);
        jlrango.setText("Del "+fechaformateadas+"  Al  "+fechafin);
        
        DefaultTableModel modelo=(DefaultTableModel) jtfolioscompra.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select * from proveedor_to_compra where estatuscompra=1 and fecha_registro>='"+fechaformateadas+" 00:00:00' and fecha_registro<='"+fechafin+" 23:59:59' order by IdCompraFolio desc";
        System.out.println(""+myQuery);
        double total=0;
        int numerocompras=0;
        try {
            Statement st = con.getConnection().createStatement();
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {             
                    total=total+rsR.getDouble("monto_compra");
                    numerocompras++;
                    modelo.addRow(new Object[]{rsR.getString("IdCompraFolio"),rsR.getString("FolioCompra"),rsR.getString("fecha_registro"),rsR.getString("monto_compra"),rsR.getString("usuario_registro")});                        
            }   
            
            funciones redondear=new funciones();
            total=redondear.redondearDecimales(total, 2);
            jlmontototal.setText("$"+total);
            jlnumerocompras.setText(""+numerocompras);
            rsR.close(); 
            st.close();
            con.desconectar();
        } catch (SQLException ex) {       

            JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }     
        jtfolioscompra.getColumnModel().getColumn(0).setMaxWidth(0);
        jtfolioscompra.getColumnModel().getColumn(0).setMinWidth(0);
        jtfolioscompra.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtfolioscompra.getColumnModel().getColumn(0).setWidth(0);   
        
        
        
}

public void vaciartablacompras(){
            DefaultTableModel modelo=(DefaultTableModel) jtdetallecompra.getModel();         
            for (int i = 0; i < jtdetallecompra.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public void cargarcompras(String folio){
        vaciartablacompras();
        DefaultTableModel modelo=(DefaultTableModel) jtdetallecompra.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select nombre_producto,cantidad,precio,total from proveedor_tc_compraprod,tc_productos where idproducto=idprod and IdFolioCompra='"+folio+"'";
        //System.out.println(""+myQuery);
        
        try {
            Statement st = con.getConnection().createStatement();
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {                               
                    modelo.addRow(new Object[]{rsR.getString("nombre_producto"),rsR.getString("cantidad"),rsR.getString("precio"),rsR.getString("total")});                        
            }               
            rsR.close(); 
            st.close();
            con.desconectar();
        } catch (SQLException ex) {       

            JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }     
        
}


}
