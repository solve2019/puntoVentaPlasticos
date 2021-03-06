/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jinternalPanel;

import ClasesDAO.Ticket;
import Correo.Mensaje;
import Utilerias.funciones;
import conexion.conex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author desarrollo8
 */
public class PreCierre_caja extends javax.swing.JInternalFrame {

    /**
     * Creates new form Cierre_caja
     */
    public PreCierre_caja() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jldevolucion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jltarjeta = new javax.swing.JLabel();
        jltotal = new javax.swing.JLabel();
        jlentradas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jlsalidas = new javax.swing.JLabel();
        jltickets = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jlinicial = new javax.swing.JLabel();
        jlefectivo = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtentradas = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtsalidas = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlcredito = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jlcompras = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setTitle("Cierre de Caja");

        jPanel2.setBackground(new java.awt.Color(51, 153, 0));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PRE CIERRE DE CAJA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Por favor cuenta el dinero en caja para realizar el cuadre del dinero en efectivo.");

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));

        jldevolucion.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jldevolucion.setForeground(new java.awt.Color(153, 0, 0));
        jldevolucion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jldevolucion.setText("0.00");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Entradas:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Efectivo:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Numero de Ventas:");

        jltarjeta.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jltarjeta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jltarjeta.setText("0.00");

        jltotal.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jltotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jltotal.setText("0.00");

        jlentradas.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlentradas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlentradas.setText("0.00");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Efectivo Inicial:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tarjeta:");

        jlsalidas.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlsalidas.setForeground(new java.awt.Color(153, 0, 0));
        jlsalidas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlsalidas.setText("0.00");

        jltickets.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jltickets.setForeground(new java.awt.Color(51, 0, 255));
        jltickets.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jltickets.setText("0");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel16.setText("Total Ventas $");

        jlinicial.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlinicial.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlinicial.setText("0.00");

        jlefectivo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlefectivo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlefectivo.setText("0.00");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Devoluciones:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Salidas:");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Ver Pre Cierre Caja");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(250, 246, 246));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jtentradas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtentradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Monto", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtentradas.setRowHeight(22);
        jScrollPane1.setViewportView(jtentradas);

        jtsalidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtsalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Monto", "Observacion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtsalidas.setRowHeight(22);
        jScrollPane2.setViewportView(jtsalidas);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Entradas");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Salidas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(203, 203, 203)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 192, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("A credito:");
        jLabel12.setToolTipText("Este dato es informativo ya que se sumo a efectivo o tarjeta");

        jlcredito.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlcredito.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlcredito.setText("0.00");
        jlcredito.setToolTipText("Este dato es informativo ya que se sumo a efectivo o tarjeta");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Compras:");

        jlcompras.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jlcompras.setForeground(new java.awt.Color(153, 0, 0));
        jlcompras.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlcompras.setText("0.00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlsalidas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jldevolucion, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlentradas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlinicial, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jltarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jltickets, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlefectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlcompras, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlcredito, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jltickets))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jltotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jlefectivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jltarjeta)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jlinicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlentradas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jldevolucion)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlsalidas)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jlcompras))
                .addGap(39, 39, 39)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jlcredito))
                .addContainerGap(108, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargartablaentradas();
        cargartablasalidas();
        conex con=new conex();
        ResultSet rs = null;
        String myQuery = "SELECT * FROM to_cierre_caja WHERE id_cierre_caja ='1'";
        String cortecajaenviarcorreo="";
        try {
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            if(rs.next()) {
                jlefectivo.setText(rs.getString("efectivo"));
                jltarjeta.setText(rs.getString("tarjeta"));
                jlinicial.setText(rs.getString("monto_inicio_caja"));
                jldevolucion.setText(rs.getString("devoluciones"));
                jlentradas.setText(rs.getString("entrada"));
                jlsalidas.setText(rs.getString("salida"));
                jltickets.setText(rs.getString("no_ventas"));
                jlcredito.setText(rs.getString("credito"));
                jlcompras.setText(rs.getString("compras"));

                double total=rs.getFloat("monto_inicio_caja")+rs.getFloat("entrada")+rs.getFloat("tarjeta")+rs.getFloat("efectivo")-rs.getFloat("salida")-rs.getFloat("devoluciones")-rs.getFloat("compras");
                funciones redondeo=new funciones();
                total=redondeo.redondearDecimales(total, 2);
                //total=Math.rint((total*1000)/1000);//redondea los numeros
                jltotal.setText(total+"");
                int response = JOptionPane.showConfirmDialog(null, "Desea imprimir el pre-corte?", "Confirmar",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (response == JOptionPane.YES_OPTION) {
                    Ticket imprime=new Ticket();
                    cortecajaenviarcorreo=imprime.ImprimirCorteCaja(rs.getString("efectivo"),rs.getString("tarjeta"),rs.getString("monto_inicio_caja"),rs.getString("devoluciones"),rs.getString("entrada"),rs.getString("salida"),total+"",rs.getString("no_ventas"),rs.getString("credito"),rs.getString("compras"));
               }
            }
            rs.close();

            //myQuery = "update to_cierre_caja set no_ventas=0, efectivo=0, tarjeta=0, monto_inicio_caja=0, devoluciones=0, entrada=0, salida=0, activo='NO' WHERE id_cierre_caja ='1'";
            //st.executeUpdate(myQuery);
            st.close();
            con.desconectar();

            //Mensaje log = new Mensaje();
            //log.enviarMensaje(cortecajaenviarcorreo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlcompras;
    private javax.swing.JLabel jlcredito;
    private javax.swing.JLabel jldevolucion;
    private javax.swing.JLabel jlefectivo;
    private javax.swing.JLabel jlentradas;
    private javax.swing.JLabel jlinicial;
    private javax.swing.JLabel jlsalidas;
    private javax.swing.JLabel jltarjeta;
    private javax.swing.JLabel jltickets;
    private javax.swing.JLabel jltotal;
    private javax.swing.JTable jtentradas;
    private javax.swing.JTable jtsalidas;
    // End of variables declaration//GEN-END:variables


    public void vaciartabla(){
            DefaultTableModel modelo=(DefaultTableModel) jtentradas.getModel();         
            for (int i = 0; i < jtentradas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }

    public void cargartablaentradas(){    
        vaciartabla();
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String fech=format.format(fecha);
        DefaultTableModel modelo=(DefaultTableModel) jtentradas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select HOUR(fecha) as fecha, minute(fecha) as minu, monto,motivo from th_entradasefectivo where movimiento='ENTRADA' and fecha>='"+fech+" 00:00:00' and fecha<='"+fech+" 23:59:59'";
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("fecha")+":"+rsR.getString("minu"),""+rsR.getString("monto"),rsR.getString("motivo")});                        
                   }                             
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener la informacion: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
              
              
    }    

    
    
    
    public void vaciartablasalida(){
            DefaultTableModel modelo=(DefaultTableModel) jtsalidas.getModel();         
            for (int i = 0; i < jtsalidas.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
    }

    public void cargartablasalidas(){    
        vaciartablasalida();
        Date fecha = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
        String fech=format.format(fecha);
        DefaultTableModel modelo=(DefaultTableModel) jtsalidas.getModel();  
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select HOUR(fecha) as fecha, minute(fecha) as minu, monto,motivo from th_entradasefectivo where movimiento='SALIDA' and fecha>='"+fech+" 00:00:00' and fecha<='"+fech+" 23:59:59'";
               //System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                                
                            modelo.addRow(new Object[]{rsR.getString("fecha")+":"+rsR.getString("minu"),""+rsR.getString("monto"),rsR.getString("motivo")});                        
                   }                             
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener la informacion: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
              
              
    }    

}
