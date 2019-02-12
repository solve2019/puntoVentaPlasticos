/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuloVeterinaria;

import conexion.conex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo8
 */
public class NotificacionesDiarias extends javax.swing.JDialog {
String fechaini="", fechafin="";

    /**
     * Creates new form NotificacionesDiarias
     */
    public NotificacionesDiarias(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechahoy = new Date();
        String date1=sdf.format(fechahoy);
        fechaini=date1;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechahoy); // Configuramos la fecha que se recibe	
        Date fechasig=new Date();
        calendar.add(Calendar.DAY_OF_YEAR, 1);  // numero de días a añadir, o restar en caso de días<0
        fechasig=calendar.getTime();
        String date2=sdf.format(fechasig);
        fechafin=date2;
         
        cargartablaconsultas();
        cargartablaparasitos();
        cargartablavacunacion();
        
        cargartablaestetica();
        
        jtconsultas.getColumnModel().getColumn(0).setMaxWidth(0);
        jtconsultas.getColumnModel().getColumn(0).setMinWidth(0);
        jtconsultas.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtconsultas.getColumnModel().getColumn(0).setWidth(0);
        
        jtparasitos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtparasitos.getColumnModel().getColumn(0).setMinWidth(0);
        jtparasitos.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtparasitos.getColumnModel().getColumn(0).setWidth(0);
        
        jtvacunacion.getColumnModel().getColumn(0).setMaxWidth(0);
        jtvacunacion.getColumnModel().getColumn(0).setMinWidth(0);
        jtvacunacion.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtvacunacion.getColumnModel().getColumn(0).setWidth(0);
        
        jtestetica.getColumnModel().getColumn(0).setMaxWidth(0);
        jtestetica.getColumnModel().getColumn(0).setMinWidth(0);
        jtestetica.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtestetica.getColumnModel().getColumn(0).setWidth(0);
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtconsultas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtparasitos = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtvacunacion = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtestetica = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Notificaciones");

        jPanel1.setBackground(new java.awt.Color(248, 244, 244));

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(249, 246, 246));
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jtconsultas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Paciente", "Dueño", "Teléfono", "Fecha Ultima Consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jtconsultas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Consultas", jPanel2);

        jPanel3.setBackground(new java.awt.Color(248, 246, 246));

        jtparasitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Paciente", "Dueño", "Teléfono", "Ultima Desparacitación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtparasitos);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Desparacitación", jPanel3);

        jPanel4.setBackground(new java.awt.Color(251, 249, 249));

        jtvacunacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Paciente", "Dueño", "Teléfono", "Ultima vacunación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtvacunacion);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Vacunación", jPanel4);

        jPanel6.setBackground(new java.awt.Color(249, 246, 246));

        jtestetica.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Mascota", "Dueño", "Teléfono", "Ultima Visita", "Costo Ultima Visita"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jtestetica);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Estética", jPanel6);

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NOTIFICACIONES DEL SISTEMA");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(NotificacionesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotificacionesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotificacionesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotificacionesDiarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotificacionesDiarias dialog = new NotificacionesDiarias(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jtconsultas;
    private javax.swing.JTable jtestetica;
    private javax.swing.JTable jtparasitos;
    private javax.swing.JTable jtvacunacion;
    // End of variables declaration//GEN-END:variables


 public void vaciartablaconsultas(){
            DefaultTableModel modelo=(DefaultTableModel) jtconsultas.getModel();         
            for (int i = 0; i < jtconsultas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }
    
public void cargartablaconsultas(){    
        vaciartablaconsultas();
        DefaultTableModel modelo=(DefaultTableModel) jtconsultas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "SELECT Id, nombrepaciente, fecha_consulta, nombre_completo, telefono FROM veterinaria_consultas, tc_mascotas, tc_clientes WHERE tc_clientes.idcliente=tc_mascotas.idrcliente and tc_mascotas.Idmascota=veterinaria_consultas.idrpaciente and proxima_cita>='"+fechaini+"' and proxima_cita<='"+fechafin+"'";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("Id"),rsR.getString("nombrepaciente"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getString("fecha_consulta")});                        
                   }
                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                                     
               }     
               
              
    }    


 public void vaciartablaparasitos(){
            DefaultTableModel modelo=(DefaultTableModel) jtparasitos.getModel();         
            for (int i = 0; i < jtparasitos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }

public void cargartablaparasitos(){    
        vaciartablaparasitos();
        DefaultTableModel modelo=(DefaultTableModel) jtparasitos.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "SELECT IdParasito, nombrepaciente, cita, nombre_completo, telefono FROM veterinaria_parasitos, tc_mascotas, tc_clientes WHERE tc_clientes.idcliente=tc_mascotas.idrcliente and tc_mascotas.Idmascota=veterinaria_parasitos.idrpaciente and cita>='"+fechaini+"' and cita<='"+fechafin+"'";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("IdParasito"),rsR.getString("nombrepaciente"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getString("cita")});                        
                   }
                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                                     
               }                                  
    }    


public void vaciartablavacunacion(){
            DefaultTableModel modelo=(DefaultTableModel) jtvacunacion.getModel();         
            for (int i = 0; i < jtvacunacion.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }

public void cargartablavacunacion(){    
        vaciartablavacunacion();
        DefaultTableModel modelo=(DefaultTableModel) jtvacunacion.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "SELECT Idvacunas, nombrepaciente, revacunacion, nombre_completo, telefono FROM veterinaria_to_vacunas, tc_mascotas, tc_clientes WHERE tc_clientes.idcliente=tc_mascotas.idrcliente and tc_mascotas.Idmascota=veterinaria_to_vacunas.idrpaciente and revacunacion>='"+fechaini+"' and revacunacion<='"+fechafin+"'";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("Idvacunas"),rsR.getString("nombrepaciente"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getString("revacunacion")});                        
                   }
                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                                     
               }                                  
    }    


public void vaciartablaestetica(){
            DefaultTableModel modelo=(DefaultTableModel) jtestetica.getModel();         
            for (int i = 0; i < jtestetica.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }

public void cargartablaestetica(){    
        vaciartablaestetica();
        DefaultTableModel modelo=(DefaultTableModel) jtestetica.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "SELECT to_estetica.Id, nombrepaciente, fecha, nombre_completo, telefono, efectivo FROM to_estetica, tc_mascotas, tc_clientes WHERE tc_clientes.idcliente=tc_mascotas.idrcliente and tc_mascotas.Idmascota=to_estetica.idrpaciente and proxima_cita>='"+fechaini+"' and proxima_cita<='"+fechafin+"'";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("Id"),rsR.getString("nombrepaciente"),rsR.getString("nombre_completo"),rsR.getString("telefono"),rsR.getDate("fecha"),rsR.getString("efectivo")});                        
                   }
                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                            System.out.println("error estetica: "+ex);         
               }                                  
    }    


}