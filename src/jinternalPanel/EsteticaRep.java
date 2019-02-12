/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jinternalPanel;

import ClasesDAO.Ticket;
import ClasesDAO.accesoSistema;
import conexion.conex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo8
 */
public class EsteticaRep extends javax.swing.JInternalFrame {

    /**
     * Creates new form Estetica
     */
    public EsteticaRep() {
        initComponents();
        cargartabla();
        jtpacientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setMinWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtpacientes.getColumnModel().getColumn(0).setWidth(0);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpacientes = new javax.swing.JTable();
        jcestatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setTitle("Estetica Canina");

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));

        jtpacientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtpacientes.getTableHeader().setReorderingAllowed(false) ;
        jtpacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Fecha", "Mascota", "Raza", "Tipo Corte", "Tratamiento", "Comentario", "A cuenta", "Monto Total", "Resta", "Dueño", "Teléfono"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtpacientes.setRowHeight(28);
        jScrollPane1.setViewportView(jtpacientes);

        jcestatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ABIERTA", "CERRADA", "TODAS" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Estatus:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/seg.png"))); // NOI18N
        jButton2.setText("Entregar mascota");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcestatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargartabla();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int fila=-1;
            fila=jtpacientes.getSelectedRow();
            if(fila!=-1){
                String id=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),0).toString(); 
                String efectivorestante=jtpacientes.getValueAt(jtpacientes.getSelectedRow(),9).toString(); 
                int dialogButton = JOptionPane.YES_NO_OPTION;
                dialogButton=JOptionPane.showConfirmDialog (null, " Desea entregar a la mascota?","Entrega de Mascota",dialogButton);
                if(dialogButton == JOptionPane.YES_OPTION){ //The ISSUE is here
                    System.out.println("Se ha hecho doble click");
                    conex con=new conex();                      
                    String myQuery = "update to_estetica set fecha_entrega=now(),usuarioentrego='"+accesoSistema.nombreuser+"',estatus='CERRADA' where Id="+id;
                    System.out.println(""+myQuery);
                    try {
                       Statement st = con.getConnection().createStatement();
                       st.executeUpdate(myQuery);                   
                       st.close();
                       con.desconectar();
                       cargartabla();
                       //registraentradadinero(efectivorestante);
                       
                       
                    } catch (SQLException ex) {       
                       JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }                  
            }else{
                JOptionPane.showMessageDialog(null,"Seleccione un paciente de la Tabla","Alerta",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JComboBox<String> jcestatus;
    private static javax.swing.JTable jtpacientes;
    // End of variables declaration//GEN-END:variables



public static void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();         
            for (int i = 0; i < jtpacientes.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
public static void cargartabla(){    
        String estatus=jcestatus.getSelectedItem().toString();
        String sqlaux="";
        if(!estatus.equals("TODAS")){
            sqlaux=" and to_estetica.estatus='"+estatus+"'";
        }
        vaciartabla();
        DefaultTableModel modelo=(DefaultTableModel) jtpacientes.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select id,fecha,nombrepaciente,raza,tipocorte,tratamiento,comentario,acuenta,efectivo,nombre_completo,tc_clientes.telefono, (efectivo-acuenta) as resta from to_estetica,tc_mascotas,tc_clientes where tc_clientes.idcliente=tc_mascotas.idrcliente and to_estetica.idrpaciente=tc_mascotas.Idmascota"+sqlaux+" order by id desc";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("id"),rsR.getString("fecha"),rsR.getString("nombrepaciente"),rsR.getString("raza"),rsR.getString("tipocorte"),rsR.getString("tratamiento"),rsR.getString("comentario"),rsR.getString("acuenta"),rsR.getString("efectivo"),rsR.getString("resta"),rsR.getString("nombre_completo"),rsR.getString("telefono")});                        
                   }                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
               
              
    }        



public void registraentradadinero(String montook){
conex con=new conex();  
                try {
                    Statement st = con.getConnection().createStatement();
                    String sql="update to_cierre_caja set entrada=(entrada+"+montook+") where id_cierre_caja=1";                
                    st.executeUpdate(sql);                
                    sql="insert into th_entradasefectivo (fecha,monto,motivo,movimiento,usuario) values(now(),'"+montook+"','ESTETICA CANINA EFECTIVO RESTANTE','ENTRADA','"+accesoSistema.nombreuser+"')";                                                   
                    st.executeUpdate(sql);
                    sql="select Id from th_entradasefectivo order by Id desc limit 1";                                                   
                    ResultSet rs=st.executeQuery(sql);
                    String id="0";
                    if(rs.next()){
                        id=rs.getString("Id");
                    }
                    rs.close();
                    st.close();
                    con.desconectar();     
                    
                    Ticket tickets=new Ticket();
                    tickets.ImprimirEntradaEfectivo(id,"ENTRADA DE EFECTIVO");                                                                                
                } catch (SQLException ex) {       
                    //JOptionPane.showMessageDialog(null, "Error al ingresar el efectivo: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                }  

}
}