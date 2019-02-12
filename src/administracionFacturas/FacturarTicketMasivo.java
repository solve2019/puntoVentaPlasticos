/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;
import conexion.conex;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author JOSE
 */
public class FacturarTicketMasivo extends javax.swing.JFrame {
private static TableRowSorter<TableModel> sorter;
    /**
     * Creates new form FacturarTicket
     */
    public FacturarTicketMasivo() {
        initComponents();
        String rutaicon="/images/icono.png";        
        String ruta=rutaicon;      
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource(ruta));
        setIconImage(icon);
        this.setLocationRelativeTo(null);
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtfacturas = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jctipopago = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(246, 242, 242));

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Facturar Ticket Masivo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jtfacturas.getTableHeader().setReorderingAllowed(false);
        jtfacturas.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtfacturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Folio", "Cliente", "Monto", "BarCode", "Factura", "Marcar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtfacturas.setRowHeight(24);
        jtfacturas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jtfacturas);

        txtBusqueda.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("FACTURAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jctipopago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona..", "01 Efectivo", "02 Cheque Nominativo", "03 Transferencia electonica de fondos", "04 Tarjeta de credito", "05 Monedero electronico", "06 Dinero Electronico", "08 Vale despensa", "28 Tarjeta debito", "29 Tarjeta de Servicio", "99 Otros" }));

        jLabel9.setText("Tipo de Pago Factura");

        jLabel10.setText("Buscar (Folio o Cliente)");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seleccionarTodo.png"))); // NOI18N
        jButton2.setText("Marcar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deseleccionarTodo.png"))); // NOI18N
        jButton3.setText("Desmarcar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(405, 405, 405)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jctipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jctipopago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(5, 5, 5)
                        .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyPressed
        // TODO add your handling code here:
        txtBusqueda.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                filtrar();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                filtrar();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                filtrar();
            }
        });
    }//GEN-LAST:event_txtBusquedaKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tipoformapagofactura=jctipopago.getSelectedItem().toString();
        if(tipoformapagofactura.equals("Selecciona..")){
                        JOptionPane.showMessageDialog(null, "Falta ingresar el tipo de pago para la factura.", "Alerta", JOptionPane.ERROR_MESSAGE);
        }else{
            tipoformapagofactura=tipoformapagofactura.substring(0,2);
            int fila=-1;
            fila=jtfacturas.getSelectedRow();
            if(fila!=-1){
                ArrayList folios=new ArrayList();
                Double subtotal=0.0;
                boolean validaseleccion=false;
                for(int i=0;i<jtfacturas.getRowCount();i++){                    
                    if(jtfacturas.getValueAt(i,6)==null){
                    }else{  
                        String valida=jtfacturas.getValueAt(i,6).toString();//2018-01-12
                        if(valida.equals("true")){//valida si es true para facturar 2018-01-12
                            String codigobarras=jtfacturas.getValueAt(i,4).toString();
                            subtotal=subtotal+Double.parseDouble(jtfacturas.getValueAt(i,3).toString());
                            folios.add(codigobarras);
                            validaseleccion=true;
                        }
                    }
                    
                }
                if(validaseleccion==true){
                    boolean facturaok=false;
                    subtotal=redondearDecimales(subtotal,2);
                    for(int x=0;x<folios.size();x++) {
                        System.out.println(folios.get(x)+" "+subtotal);
                    }
                    GeneraFacturaElectronicaMasivo factura=new GeneraFacturaElectronicaMasivo();
                    facturaok=factura.facturarventamasiva(folios,tipoformapagofactura,subtotal);
                    System.out.println("facturaok: "+facturaok);
                    if(facturaok){
                        JOptionPane.showMessageDialog(null,"La factura se genero correctamente.","Factura Generada",JOptionPane.INFORMATION_MESSAGE);
                    }else{
                            JOptionPane.showMessageDialog(null,"La factura no es genero","Error",JOptionPane.ERROR_MESSAGE);
                    }                
                    cargartabla();
                }else{
                    JOptionPane.showMessageDialog(null,"Favor de marcar por lo menos un folio.","Alerta",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Favor de seleccionar un folio.","Alerta",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        seleccionartodo();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deseleccionartodo();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FacturarTicketMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FacturarTicketMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FacturarTicketMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FacturarTicketMasivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FacturarTicketMasivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jctipopago;
    private javax.swing.JTable jtfacturas;
    private javax.swing.JTextField txtBusqueda;
    // End of variables declaration//GEN-END:variables


    public void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtfacturas.getModel();         
            for (int i = 0; i < jtfacturas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
   public void cargartabla(){    
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtfacturas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select fecha_movimiento,no_folio,razon_social,monto_total from to_folios,tc_clientes where to_folios.Nofactura is null and cliente=idcliente and to_folios.estatus=1 order by fecha_movimiento desc;";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   ResultSet rsR2=null;
                   Statement st2 = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {  
                            String factura="";
                            boolean validafactura=false;
                            rsR2 = st2.executeQuery("select factura from to_facturas where factura>0 and folio='"+rsR.getString("no_folio")+"' and estatus is null");
                            if(rsR2.next()){
                                validafactura=true;
                                factura=rsR2.getString("factura");
                            }                     
                            if(validafactura==false){//yac eunta con factura
                                modelo.addRow(new Object[]{rsR.getString("fecha_movimiento"),rsR.getString("no_folio"),rsR.getString("razon_social"),""+rsR.getString("monto_total"),rsR.getString("no_folio"),factura});                        
                            }                            
                   }
                   sorter = new TableRowSorter<TableModel>(modelo);
                   jtfacturas.setRowSorter(sorter);
                   rsR2.close();
                   st2.close();
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               } catch (NullPointerException ex) {                         
                   JOptionPane.showMessageDialog(null, "No hay facturas. ", "Alerta", JOptionPane.ERROR_MESSAGE);
               }   
               
              
    } 
    private void filtrar() {
        
         RowFilter<TableModel, Object> rf = null;
        try {
            rf = RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),1,2);
        }catch (java.util.regex.PatternSyntaxException e) {
        }
        sorter.setRowFilter(rf);
    }  


   public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }  
    

void seleccionartodo(){
        for(int i=0; i<jtfacturas.getRowCount(); i++){
            jtfacturas.setValueAt(true, i, 6);
        }        
    } 
    
    void deseleccionartodo(){
        for(int i=0; i<jtfacturas.getRowCount(); i++){
            jtfacturas.setValueAt(false, i, 6);
        }        
    } 

}
