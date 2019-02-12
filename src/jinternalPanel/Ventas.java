/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jinternalPanel;

import ClasesDAO.Ticket;
import ClasesDAO.TicketVenta;
import ClasesDAO.accesoSistema;
import PosVenta.CargarPosVenta;
import Utilerias.funciones;
import com.mysql.jdbc.PreparedStatement;
import conexion.conex;
import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jdialog.Cobrar_venta;
import jdialog.ReporteDiarioVentasDevoluciones;
import jdialog.catalogo_productos;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import jdialog.Agranel;
import jdialog.ConsultarPrecio;
import jdialog.EditarCantidad;
import jdialog.EntradaEfectivo;
import jdialog.ProductoComun;
import jdialog.SalidasEfectivo;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import plasticos.Inicial;

/**
 *
 * @author desarrollo8
 */
public class Ventas extends javax.swing.JInternalFrame implements KeyListener {       
   public static String cantidadagranel="0";
   
    /**
     * Creates new form Ventasddd
     */
    public Ventas() {
        initComponents();
        
        jtproductos.getColumnModel().getColumn(0).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(0).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(0).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(0).setWidth(0);
        
        /*jtproductos.getColumnModel().getColumn(8).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(8).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(8).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(8).setWidth(0);
        */
        
        
        jtproductos.getColumnModel().getColumn(1).setMaxWidth(480);
        jtproductos.getColumnModel().getColumn(1).setMinWidth(480);
        jtproductos.getColumnModel().getColumn(1).setPreferredWidth(480);
        jtproductos.getColumnModel().getColumn(1).setWidth(480);
                       
 
        jtproductos.getColumnModel().getColumn(6).setMaxWidth(0);  //ID
        jtproductos.getColumnModel().getColumn(6).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(6).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(6).setWidth(0);
        
        jtproductos.getColumnModel().getColumn(5).setMaxWidth(0); //existencia
        jtproductos.getColumnModel().getColumn(5).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(5).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(5).setWidth(0);
        
        if(accesoSistema.campostablaventa.equals("1")){            
            jtproductos.getColumnModel().getColumn(7).setMaxWidth(0);  //descuento
            jtproductos.getColumnModel().getColumn(7).setMinWidth(0);
            jtproductos.getColumnModel().getColumn(7).setPreferredWidth(0);
            jtproductos.getColumnModel().getColumn(7).setWidth(0);

            jtproductos.getColumnModel().getColumn(8).setMaxWidth(0); //ieps
            jtproductos.getColumnModel().getColumn(8).setMinWidth(0);
            jtproductos.getColumnModel().getColumn(8).setPreferredWidth(0);
            jtproductos.getColumnModel().getColumn(8).setWidth(0);
        }   
            jtproductos.getColumnModel().getColumn(8).setMaxWidth(0); //ieps
            jtproductos.getColumnModel().getColumn(8).setMinWidth(0);
            jtproductos.getColumnModel().getColumn(8).setPreferredWidth(0);
            jtproductos.getColumnModel().getColumn(8).setWidth(0);
        
        if(accesoSistema.menufarmacia.equals("0")){            
            jtproductos.getColumnModel().getColumn(9).setMaxWidth(0);  //antibiotico
            jtproductos.getColumnModel().getColumn(9).setMinWidth(0);
            jtproductos.getColumnModel().getColumn(9).setPreferredWidth(0);
            jtproductos.getColumnModel().getColumn(9).setWidth(0);

            jtproductos.getColumnModel().getColumn(10).setMaxWidth(0); //lote
            jtproductos.getColumnModel().getColumn(10).setMinWidth(0);
            jtproductos.getColumnModel().getColumn(10).setPreferredWidth(0);
            jtproductos.getColumnModel().getColumn(10).setWidth(0);
        }  
        
        
        
        
        cargar_clientes();
        AutoCompleteDecorator.decorate(this.jccliente);
        if(accesoSistema.menufarmacia.equals("0")){
            jpfarmacia.setVisible(false);
        }
        
        txtproducto.requestFocus();
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
        jpfarmacia = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtnoreceta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmedico = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtproducto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jccliente = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jlfoto = new javax.swing.JLabel();
        txtcanti = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtproductos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                //return false; //Disallow the editing of any cell
                if(colIndex==3){ //Con esto se pueden editar todas las celdas menos la de la columna 0  colIndex==7 ||
                    return true;
                }
                else if(colIndex==2){ //Con esto se pueden editar todas las celdas menos la de la columna 0  colIndex==7 ||
                    return true;
                }
                else{
                    return false;
                }
                //return false;
            }
        };
        jltotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jlmonto = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jlgrantotal = new javax.swing.JLabel();
        lbieps = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();

        setBackground(new java.awt.Color(249, 249, 249));
        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("PUNTO DE VENTA");

        jPanel1.setBackground(new java.awt.Color(245, 244, 244));

        jpfarmacia.setBackground(new java.awt.Color(255, 153, 0));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("No. Receta:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Medico:");

        javax.swing.GroupLayout jpfarmaciaLayout = new javax.swing.GroupLayout(jpfarmacia);
        jpfarmacia.setLayout(jpfarmaciaLayout);
        jpfarmaciaLayout.setHorizontalGroup(
            jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpfarmaciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnoreceta)
                    .addComponent(txtmedico))
                .addContainerGap())
        );
        jpfarmaciaLayout.setVerticalGroup(
            jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpfarmaciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnoreceta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpfarmaciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtmedico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 204));
        jLabel1.setText("Cliente:");

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/palomita.png"))); // NOI18N
        jButton1.setText("Agregar Producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtproducto.addKeyListener(this);
        txtproducto.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        txtproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtproductoKeyPressed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/borrar.png"))); // NOI18N
        jButton2.setText("DEL Borrar Art.");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/buscar.png"))); // NOI18N
        jButton3.setText("F10 Buscar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setVisible(true);
        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salida.png"))); // NOI18N
        jButton4.setText("F9 Salidas");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setVisible(true);
        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/entrada.png"))); // NOI18N
        jButton5.setText("F8 Entradas");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setVisible(true);
        jButton10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/prod.png"))); // NOI18N
        jButton10.setText("F7 Prod. Común");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton11.setText("F6 TK Pendientes");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(231, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jccliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jccliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona.." }));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 204));
        jLabel2.setText("Código Producto:");

        txtcanti.requestFocus();
        txtcanti.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        txtcanti.setVisible(false);
        txtcanti.setText("1");
        txtcanti.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantiKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantiKeyTyped(evt);
            }
        });

        jLabel6.setVisible(false);
        jLabel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 204));
        jLabel6.setText("Cantidad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtcanti, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jccliente, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlfoto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpfarmacia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcanti, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jccliente, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jlfoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpfarmacia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        Color myColor = new Color(245,244,244);
        jScrollPane1.getViewport().setBackground(myColor);

        jtproductos.getTableHeader().setReorderingAllowed(false) ;
        jtproductos.setDefaultRenderer (Object.class, new MiRender());
        jtproductos.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jtproductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código de Barras", "Descripción del Producto", "Precio Unitario", "Cant.", "Importe", "Existencia", "Id", "% Descuento", "Ieps", "Antibiotico", "Lote"
            }
        ));
        jtproductos.setGridColor(new java.awt.Color(255, 255, 255));
        jtproductos.setRowHeight(34);
        jtproductos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jtproductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtproductosMouseClicked(evt);
            }
        });
        jtproductos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtproductosKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtproductos);

        jltotal.setFont(new java.awt.Font("Arial", 0, 22)); // NOI18N
        jltotal.setForeground(new java.awt.Color(0, 51, 153));
        jltotal.setText("0");

        jLabel3.setVisible(false);
        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Productos en la venta actual.");

        jButton6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jButton6.setForeground(new java.awt.Color(51, 102, 0));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pagar.png"))); // NOI18N
        jButton6.setText("F12 - Cobrar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jlmonto.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jlmonto.setForeground(new java.awt.Color(0, 51, 153));
        jlmonto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlmonto.setText("$0.00");

        if(accesoSistema.licencia.equals("DEMO")){
            jButton7.setVisible(false);
        }
        jButton7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/historico.png"))); // NOI18N
        jButton7.setText("Ventas del día y devoluciones");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        if(accesoSistema.licencia.equals("DEMO")){
            jButton8.setVisible(false);
        }
        jButton8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/impresora.png"))); // NOI18N
        jButton8.setText("Reimprimir Último Ticket");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jButton9.setText("F1 Cancelar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jlgrantotal.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jlgrantotal.setForeground(new java.awt.Color(0, 51, 153));
        jlgrantotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jlgrantotal.setText("$0.00");

        lbieps.setText("0.0");
        lbieps.setVisible(false);

        jButton12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/producto_bajo.png"))); // NOI18N
        jButton12.setText("Colocar Pendiente");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbieps, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jlmonto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlgrantotal, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbieps)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlmonto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jlgrantotal)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!txtproducto.getText().trim().equals("")){
            cargar_producto(txtproducto.getText().trim(),"CB");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtproductoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
            if(!txtproducto.getText().trim().equals("")){
                cargar_producto(txtproducto.getText().trim(),"CB");
            }
        }
    }//GEN-LAST:event_txtproductoKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        
         DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();  
          int fila=-1;
          fila=jtproductos.getSelectedRow();
          if(fila!=-1){
              //int opc=JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar?","Alerta",JOptionPane.INFORMATION_MESSAGE);
              //if(opc==JOptionPane.OK_OPTION){
                modelo.removeRow(fila);                
                //for(int i=fila; i<jtproductos.getRowCount(); i++){
                //    jtproductos.setValueAt(""+(i+1), i, 0);
                //}
              //}  
              
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
         }
         cargar_informacion();
         
         ponerfocoenventa();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        vaciartabla();
        cargar_informacion();
        ponerfocoenventa();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        catalogo_productos dialog = new catalogo_productos(f, true);
        dialog.show();
        //Inicial iniprod=new Inicial();
        //iniprod.setVisible(true);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        cargar_informacion();
        cargar_informacion();
        cobrar_venta();
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:        
        String folio="0";
        conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='FOLIO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	folio=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
            pstm100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        int folios=Integer.parseInt(folio);
        folios=folios-1;
        
        //Ticket imprime=new Ticket();
        //imprime.ReImprimirDocumento(folio);
        
        TicketVenta ticketpdf=new TicketVenta();
        ticketpdf.imprimirticket(folio+"","IMPPVT");
        ponerfocoenventa();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        ReporteDiarioVentasDevoluciones reportediario=new ReporteDiarioVentasDevoluciones(f,true);
        reportediario.show();
       
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jtproductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtproductosMouseClicked
        // TODO add your handling code here:
          if (evt.getClickCount() == 1) {
               String id=jtproductos.getValueAt(jtproductos.getSelectedRow(), 6).toString();
                funciones obtenimagen=new funciones();
                Image foto=obtenimagen.obtenImagenes("SELECT imagen FROM tc_productos where idproducto="+id);
                System.out.println("foto: "+foto);
                if(foto==null){
                    jlfoto.setText("");
                    jlfoto.setIcon(null);
                    jPanel1.updateUI();
                }else{
                    ImageIcon icon = new ImageIcon(foto.getScaledInstance(jlfoto.getWidth(), jlfoto.getHeight(), Image.SCALE_DEFAULT));
                    jlfoto.setText("");
                    jlfoto.setIcon(icon);
                    jPanel1.updateUI();
                }
          }
         if (evt.getClickCount() == 2) {
             String producto=jtproductos.getValueAt(jtproductos.getSelectedRow(), 1).toString();
             String precio=jtproductos.getValueAt(jtproductos.getSelectedRow(), 2).toString();
             String cantidad=jtproductos.getValueAt(jtproductos.getSelectedRow(), 3).toString();             
             String total=jtproductos.getValueAt(jtproductos.getSelectedRow(), 4).toString();  
             String existencia=jtproductos.getValueAt(jtproductos.getSelectedRow(), 5).toString();
             String idprod=jtproductos.getValueAt(jtproductos.getSelectedRow(), 6).toString();
             String descuento=jtproductos.getValueAt(jtproductos.getSelectedRow(), 7).toString();
             boolean val=validaragranel(idprod);
             if(val==false){
                int fila=jtproductos.getSelectedRow();
                Frame f = JOptionPane.getFrameForComponent(this);
                EditarCantidad dialog = new EditarCantidad(f,true,fila,producto,cantidad,precio,existencia,idprod,total,descuento);
                dialog.show();
             }
         }
        
    }//GEN-LAST:event_jtproductosMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        EntradaEfectivo dialog = new EntradaEfectivo(f, true);
        dialog.show();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        SalidasEfectivo dialog = new SalidasEfectivo(f, true);
        dialog.show();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        ProductoComun dialog = new ProductoComun(f, true);
        dialog.show();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        Frame f = JOptionPane.getFrameForComponent(this);
        CargarPosVenta POS = new CargarPosVenta(f, true);
        POS.show();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        poner_venta_pendiente();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jtproductosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtproductosKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
                String precio=jtproductos.getValueAt(jtproductos.getSelectedRow(), 2).toString();
                String cantidad=jtproductos.getValueAt(jtproductos.getSelectedRow(), 3).toString();
                String id=jtproductos.getValueAt(jtproductos.getSelectedRow(), 6).toString();
                Float costototal=Float.parseFloat(precio)*Float.parseFloat(cantidad);
                funciones redondear=new funciones();
                double imp=redondear.redondearDecimales(costototal, 2);
                System.out.println("enter: "+imp);
                jtproductos.setValueAt(imp+"", jtproductos.getSelectedRow(), 4);
                cargar_informacion();
                txtproducto.requestFocus();                                  
        }
    }//GEN-LAST:event_jtproductosKeyPressed

    private void txtcantiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantiKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            txtproducto.requestFocus(); 
         }  
    }//GEN-LAST:event_txtcantiKeyPressed

    private void txtcantiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantiKeyTyped
        // TODO add your handling code here:
        if(txtcanti.getText().trim().length()>=4){            
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9'))){
               evt.consume(); // ignorar el evento de teclado
            }            
        }        
    }//GEN-LAST:event_txtcantiKeyTyped

     public static void vaciartabla(){
        DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();         
            for (int i = 0; i < jtproductos.getRowCount(); i++) {
                modelo.removeRow(i);
                i-=1;
            }    
           
    }  
    public static void cargar_producto(String producto_code,String tipobusqueda){
        DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();          
        String codigo_barras=producto_code;
        conex con=new conex();          
        ResultSet rs = null;   
        String myQuery="";
        if(tipobusqueda.equals("CB")){
            myQuery = "SELECT * FROM tc_productos WHERE codigo_barras='"+codigo_barras+"' and estatus=1";
        }
        if(tipobusqueda.equals("ID")){
            myQuery = "SELECT * FROM tc_productos WHERE idproducto='"+codigo_barras+"' and estatus=1"; //el estatus es producto comun
        }        
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            float precio=0,preciomayoreo=0;
            float preciopromo=0;
            int cantidadpromo=0;
            int cantimayoreo=0;
            double ieps=0;
            String codigobarra="",producto="";
            int existencia=0;
            String id="";
            boolean existe=false;
            String agranel="";
            if(rs.next()) {                 
                precio=rs.getFloat("precio_venta");
                codigobarra=rs.getString("codigo_barras");
                producto=rs.getString("nombre_producto");
                existencia=rs.getInt("existencia");
                id=rs.getString("idproducto");
                preciomayoreo=rs.getFloat("precio_mayoreo");
                cantimayoreo=rs.getInt("cantidad_mayoreo");
                preciopromo=rs.getFloat("precio_promocion");
                cantidadpromo=rs.getInt("cantidad_promocion");
                agranel=rs.getString("agranel");
                ieps=rs.getDouble("ieps");
                existe=true;
                if(cantimayoreo==0){
                    cantimayoreo=10000;
                }
                
                funciones obtenimagen=new funciones();
                Image foto=obtenimagen.obtenImagenes("SELECT imagen FROM tc_productos where idproducto="+id);
                System.out.println("foto: "+foto);
                if(foto==null){
                    jlfoto.setText("");
                    jlfoto.setIcon(null);
                    jPanel1.updateUI();
                }else{
                    ImageIcon icon = new ImageIcon(foto.getScaledInstance(jlfoto.getWidth(), jlfoto.getHeight(), Image.SCALE_DEFAULT));
                    jlfoto.setText("");
                    jlfoto.setIcon(icon);
                    jPanel1.updateUI();
                }
                
                //modelo.addRow(new Object[]{rs.getString("codigo_barras"),rs.getString("nombre_producto"),rs.getString("precio_venta"),"1","10",rs.getString("existencia")});
            }
           
            rs.close(); 
            st.close();
            con.desconectar();   
            
            if(existencia<=0){
                //existe=false;
                //JOptionPane.showMessageDialog(null, "No cuenta con existencia de este producto.", "Sin existencia.", JOptionPane.ERROR_MESSAGE);
            }
            
            if(existe){
                //String cantidadini="1";
                String cantidadini=txtcanti.getText().trim();
                float importe=precio*Float.parseFloat(cantidadini);
                if(agranel.equals("SI")){                                
                        Frame f = JOptionPane.getFrameForComponent(null);
                        Agranel agran=new Agranel(f,true,producto,precio+"");
                        agran.show();
                        cantidadini=cantidadagranel; 
                        importe=precio*Float.parseFloat(cantidadini);                        
                        funciones redondear=new funciones();
                        double imp=redondear.redondearDecimales(importe, 2);
                        importe=(float) imp;
                }
                boolean existe_tabla_temp=false;
                for(int fila=0; fila<jtproductos.getRowCount(); fila++){
                    String barcode=jtproductos.getValueAt(fila, 0).toString().trim();                 
                    float precio_unitario=Float.parseFloat(jtproductos.getValueAt(fila, 2).toString().trim());
                    float cantidad=Float.parseFloat(jtproductos.getValueAt(fila, 3).toString().trim());                             
                    float existencia_total=Float.parseFloat(jtproductos.getValueAt(fila, 5).toString().trim());
                    String id_prod=jtproductos.getValueAt(fila, 6).toString().trim();                 
                    if(id_prod.equals(id)){         
                    //if(barcode.equals(codigobarra)){
                        if(agranel.equals("SI")){
                            //cantidad=Float.parseFloat(cantidadagranel);        //pone lacantidad que ingresa                                           
                            cantidad=cantidad+Float.parseFloat(cantidadagranel);   //suma loque ya se tiene                                                
                        }else{
                            //String txtcantiini="1";
                            String txtcantiini=txtcanti.getText().trim();
                            if(txtcanti.getText().trim().equals("")){
                                cantidad++;                             
                            }else{
                               cantidad=cantidad+Integer.parseInt(txtcanti.getText().trim());
                            }
                            
                        }
                        System.out.println(cantidad+">="+cantimayoreo);
                        if(cantidad>=cantimayoreo){
                            precio_unitario=preciomayoreo;
                            importe=precio_unitario*Float.parseFloat(cantidadini);
                        }
                        //PROMOCION
                        System.out.println(""+cantidadpromo+"!=0 && "+cantidad+">="+cantidadpromo);
                        if(cantidadpromo!=0 && cantidad>=cantidadpromo){
                            int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                 System.out.println("PRECIO PROMO");
                                 precio_unitario=preciopromo;
                            } 
                        }
                        //FIN PROMO
                        
                        funciones redondear2=new funciones();                  
                        ieps=precio_unitario*ieps;
                        ieps=redondear2.redondearDecimales(ieps, 2);     
                        ieps=ieps*cantidad;
                        ieps=redondear2.redondearDecimales(ieps, 2);     
                                
                        jtproductos.setValueAt(precio_unitario, fila, 2); 
                        
                        float total_final=precio_unitario*cantidad;  
                        funciones redondear=new funciones();
                        double totl=redondear.redondearDecimales(total_final, 2);
                        total_final=(float) totl;
                        if(agranel.equals("SI")){
                            existencia_total=existencia_total-Float.parseFloat(cantidadagranel);
                        }else{
                            existencia_total=existencia_total-1;
                        }
                        jtproductos.setValueAt(cantidad, fila, 3); 
                        jtproductos.setValueAt(total_final, fila, 4);   
                        jtproductos.setValueAt(existencia_total, fila, 5);  
                        jtproductos.setValueAt(ieps+"", fila, 8);  
                        System.out.println("MAS DE UN REGISTRO PERO YA ESTA EN TABLA");
                        existe_tabla_temp=true;
                        jtproductos.changeSelection(fila, 1, false, false);
                    }/*else{//es nuevo y se agrega    
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1});
                    }*/                 
                }

                if(existe_tabla_temp==false && jtproductos.getRowCount()>0){
                   
                    
                        System.out.println(""+cantidadpromo+"!=0 && "+1+">="+cantidadpromo);
                        if(cantidadpromo!=0 && 1>=cantidadpromo){
                            int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                 System.out.println("PRECIO PROMO");
                                 precio=preciopromo;
                                 importe=precio;
                            } 
                       }
                    
                        funciones redondear=new funciones();                  
                        ieps=precio*ieps;
                        ieps=redondear.redondearDecimales(ieps, 2);     
                        
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                     
                       
                       System.out.println("cantidadini1: "+cantidadini);
                        //if(txtcanti.getText().trim().equals("")){ //cantidad inicial del texbox                               
                        //}else{
                        //       cantidadini=txtcanti.getText().trim();
                        //}
                        
                        System.out.println(Float.parseFloat(cantidadini)+">="+cantimayoreo);
                        if(Float.parseFloat(cantidadini)>=cantimayoreo){
                                precio=preciomayoreo;                            
                                importe=preciomayoreo*Float.parseFloat(cantidadini);
                                System.out.println("preciomayoreo:"+preciomayoreo+" "+cantidadini);
                                
                        }
                       System.out.println("importe:"+importe);
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadini+"",importe+"",existencia-1,id,"0",ieps+""});
                       jtproductos.changeSelection(jtproductos.getRowCount() - 1, 1, false, false);
                }
                
                if(jtproductos.getRowCount()<=0){//es el primer registro
                    System.out.println(""+cantidadpromo+"!=0 && "+1+">="+cantidadpromo);
                    System.out.println("cantidadini1: "+cantidadini);
                    if(Float.parseFloat(cantidadini)>=cantimayoreo){
                            precio=preciomayoreo;
                    }
                    
                    if(cantidadpromo!=0 && 1>=cantidadpromo){
                        int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                             System.out.println("PRECIO PROMO");
                             precio=preciopromo;
                             importe=precio;
                        } 
                   }
                   funciones redondear=new funciones();                  
                   ieps=precio*ieps;
                   ieps=redondear.redondearDecimales(ieps, 2);                   
                   
                    System.out.println(Float.parseFloat(cantidadini)+">="+cantimayoreo);
                    if(Float.parseFloat(cantidadini)>=cantimayoreo){                            
                            importe=preciomayoreo*Float.parseFloat(cantidadini);
                    }
                   
                   System.out.println("PRIMER REGISTRO");
                   
                   System.out.println("cantidadini3: "+cantidadini);                   
                   //if(txtcanti.getText().trim().equals("")){ //cantidad inicial del texbox                               
                   //}else{
                   //       cantidadini=txtcanti.getText().trim();
                   //}
                    System.out.println("importe: "+importe);
                    System.out.println(""+cantidadini);
                   modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadini+"",importe+"",existencia-1,id,"0",ieps+""});
                   jtproductos.changeSelection(jtproductos.getRowCount() - 1, 1, false, false);
                }
            }else{
                
                conex conlocal=new conex();                   
                ResultSet rs2 = null;                
                int total=0;
                try {
                    Statement st2 = conlocal.getConnection().createStatement();
                    String consul="select count(idproducto) as total from tc_productos where estatus=1 and (nombre_producto like '%"+producto_code+"%' or codigo_barras like '%"+producto_code+"%')";
                    System.out.println(""+consul);
                    rs2 = st2.executeQuery(consul);                    
                    if(rs2.next()) {                     
                    total=rs2.getInt("total");
                    }
                    rs2.close();
                    st2.close();
                    conlocal.desconectar();
                } catch (SQLException ex) {
                    
                }
                if(total<=0){
                    Toolkit.getDefaultToolkit().beep();
                }else{
                    //Frame f= JOptionPane.getFrameForComponent(this);
                    catalogo_productos dialog = new catalogo_productos(null, true);
                    dialog.cargatabla2(producto_code);
                    dialog.show();
                }
                
                //System.out.println("no existe en el producto");
            }
             
        } catch (SQLException ex) {
        }
        
        jtproductos.getColumnModel().getColumn(6).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(6).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(6).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(6).setWidth(0);
        
        txtcanti.setText("1");
        txtproducto.setText("");
        cargar_informacion();
        txtproducto.requestFocus();
    }
    
    
    
    
    public static void cargar_productotouch(String producto_code,String tipobusqueda,String cantidadtouch,String preciotouch){
        DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();          
        String codigo_barras=producto_code;
        conex con=new conex();          
        ResultSet rs = null;   
        String myQuery="";
        if(tipobusqueda.equals("CB")){
            myQuery = "SELECT * FROM tc_productos WHERE codigo_barras='"+codigo_barras+"' and estatus=1";
        }
        if(tipobusqueda.equals("ID")){
            myQuery = "SELECT * FROM tc_productos WHERE idproducto='"+codigo_barras+"' and estatus=1"; //el estatus es producto comun
        }        
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            float precio=0,preciomayoreo=0;
            float preciopromo=0;
            int cantidadpromo=0;
            int cantimayoreo=0;
            double ieps=0;
            String codigobarra="",producto="";
            int existencia=0;
            String id="";
            boolean existe=false;
            String agranel="";
            if(rs.next()) {                 
                precio=Float.parseFloat(preciotouch);
                codigobarra=rs.getString("codigo_barras");
                producto=rs.getString("nombre_producto");
                existencia=rs.getInt("existencia");
                id=rs.getString("idproducto");
                preciomayoreo=Float.parseFloat(preciotouch);
                cantimayoreo=rs.getInt("cantidad_mayoreo");
                preciopromo=rs.getFloat("precio_promocion");
                cantidadpromo=rs.getInt("cantidad_promocion");
                agranel=rs.getString("agranel");
                ieps=rs.getDouble("ieps");
                existe=true;
                if(cantimayoreo==0){
                    cantimayoreo=10000;
                }
                
                funciones obtenimagen=new funciones();
                Image foto=obtenimagen.obtenImagenes("SELECT imagen FROM tc_productos where idproducto="+id);
                System.out.println("foto: "+foto);
                if(foto==null){
                    jlfoto.setText("");
                    jlfoto.setIcon(null);
                    jPanel1.updateUI();
                }else{
                    ImageIcon icon = new ImageIcon(foto.getScaledInstance(jlfoto.getWidth(), jlfoto.getHeight(), Image.SCALE_DEFAULT));
                    jlfoto.setText("");
                    jlfoto.setIcon(icon);
                    jPanel1.updateUI();
                }
                
                //modelo.addRow(new Object[]{rs.getString("codigo_barras"),rs.getString("nombre_producto"),rs.getString("precio_venta"),"1","10",rs.getString("existencia")});
            }
           
            rs.close(); 
            st.close();
            con.desconectar();   
            
            if(existencia<=0){
                //existe=false;
                //JOptionPane.showMessageDialog(null, "No cuenta con existencia de este producto.", "Sin existencia.", JOptionPane.ERROR_MESSAGE);
            }
            
            if(existe){
                String cantidadini=cantidadtouch;
                float importe=precio;
                if(agranel.equals("SI")){                                
                        Frame f = JOptionPane.getFrameForComponent(null);
                        Agranel agran=new Agranel(f,true,producto,precio+"");
                        agran.show();
                        cantidadini=cantidadagranel; 
                        importe=precio*Float.parseFloat(cantidadtouch);                        
                        funciones redondear=new funciones();
                        double imp=redondear.redondearDecimales(importe, 2);
                        importe=(float) imp;
                }
                boolean existe_tabla_temp=false;
                for(int fila=0; fila<jtproductos.getRowCount(); fila++){
                    String barcode=jtproductos.getValueAt(fila, 0).toString().trim();                 
                    float precio_unitario=Float.parseFloat(jtproductos.getValueAt(fila, 2).toString().trim());
                    float cantidad=Float.parseFloat(jtproductos.getValueAt(fila, 3).toString().trim());                             
                    float existencia_total=Float.parseFloat(jtproductos.getValueAt(fila, 5).toString().trim());
                    String id_prod=jtproductos.getValueAt(fila, 6).toString().trim();                 
                    if(id_prod.equals(id)){         
                    //if(barcode.equals(codigobarra)){
                        if(agranel.equals("SI")){
                            cantidad=Float.parseFloat(cantidadtouch);  
                        }else{
                            cantidad=Float.parseFloat(cantidadtouch);  
                        }
                        System.out.println(cantidad+">="+cantimayoreo);
                        if(cantidad>=cantimayoreo){
                            precio_unitario=preciomayoreo;
                        }
                        //PROMOCION
                        System.out.println(""+cantidadpromo+"!=0 && "+cantidad+">="+cantidadpromo);
                        if(cantidadpromo!=0 && cantidad>=cantidadpromo){
                            int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                 System.out.println("PRECIO PROMO");
                                 precio_unitario=preciopromo;
                            } 
                        }
                        //FIN PROMO
                        
                        funciones redondear2=new funciones();                  
                        ieps=precio_unitario*ieps;
                        ieps=redondear2.redondearDecimales(ieps, 2);     
                        ieps=ieps*cantidad;
                        ieps=redondear2.redondearDecimales(ieps, 2);     
                                
                        jtproductos.setValueAt(precio_unitario, fila, 2); 
                        
                        float total_final=precio_unitario*cantidad;  
                        funciones redondear=new funciones();
                        double totl=redondear.redondearDecimales(total_final, 2);
                        total_final=(float) totl;
                        if(agranel.equals("SI")){
                            existencia_total=existencia_total-Float.parseFloat(cantidadagranel);
                        }else{
                            existencia_total=existencia_total-1;
                        }
                        jtproductos.setValueAt(cantidadtouch, fila, 3); 
                        jtproductos.setValueAt(total_final, fila, 4);   
                        jtproductos.setValueAt(existencia_total, fila, 5);  
                        jtproductos.setValueAt(ieps+"", fila, 8);  
                        System.out.println("MAS DE UN REGISTRO PERO YA ESTA EN TABLA");
                        existe_tabla_temp=true;
                    }/*else{//es nuevo y se agrega    
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1});
                    }*/                 
                }

                if(existe_tabla_temp==false && jtproductos.getRowCount()>0){
                        System.out.println(""+cantidadpromo+"!=0 && "+1+">="+cantidadpromo);
                        if(cantidadpromo!=0 && 1>=cantidadpromo){
                            int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (response == JOptionPane.YES_OPTION) {
                                 System.out.println("PRECIO PROMO");
                                 precio=preciopromo;
                                 importe=precio;
                            } 
                       }
                    
                        funciones redondear=new funciones();                  
                        ieps=precio*ieps;
                        ieps=redondear.redondearDecimales(ieps, 2);     
                        
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       importe=precio*Float.parseFloat(cantidadtouch);
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadtouch+"",importe+"",existencia-1,id,"0",ieps+""});
                }
                
                if(jtproductos.getRowCount()<=0){//es el primer registro
                    System.out.println(""+cantidadpromo+"!=0 && "+1+">="+cantidadpromo);
                    
                    if(Float.parseFloat(cantidadini)>=cantimayoreo){
                            precio=preciomayoreo;
                    }
                    
                    if(cantidadpromo!=0 && 1>=cantidadpromo){
                        int response = JOptionPane.showConfirmDialog(null, "Este producto tiene promocion desea aplicar?", "Confirmar",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        if (response == JOptionPane.YES_OPTION) {
                             System.out.println("PRECIO PROMO");
                             precio=preciopromo;
                             importe=precio;
                        } 
                   }
                   funciones redondear=new funciones();                  
                   ieps=precio*ieps;
                   ieps=redondear.redondearDecimales(ieps, 2);                   
                   System.out.println("PRIMER REGISTRO");
                   importe=precio*Float.parseFloat(cantidadtouch);
                   modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadtouch+"",importe+"",existencia-1,id,"0",ieps+""});
                }
            }
             
        } catch (SQLException ex) {
        }
        
        jtproductos.getColumnModel().getColumn(6).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(6).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(6).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(6).setWidth(0);
        
        txtproducto.setText("");
        cargar_informacion();
        txtproducto.requestFocus();
    }
    
    
    public static void cargar_productobusqueda(String producto_code){
        DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();          
        String codigo_barras=producto_code;
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_productos WHERE idproducto='"+codigo_barras+"' and estatus=1"; //el estatus es producto comun
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            float precio=0;
            String codigobarra="",producto="";
            int existencia=0;
            String id="";
            boolean existe=false;
            if(rs.next()) {                 
                precio=rs.getFloat("precio_venta");
                codigobarra=rs.getString("codigo_barras");
                producto=rs.getString("nombre_producto");
                existencia=rs.getInt("existencia");
                id=rs.getString("idproducto");
                existe=true;
                //modelo.addRow(new Object[]{rs.getString("codigo_barras"),rs.getString("nombre_producto"),rs.getString("precio_venta"),"1","10",rs.getString("existencia")});
            }
            rs.close(); 
            st.close();
            con.desconectar();   
            
            
            if(existencia<=0){
                //existe=false;
                //JOptionPane.showMessageDialog(null, "No cuenta con existencia de este producto.", "Sin existencia.", JOptionPane.ERROR_MESSAGE);
            }
            
            
            if(existe){
                boolean existe_tabla_temp=false;
                for(int fila=0; fila<jtproductos.getRowCount(); fila++){
                    String barcode=jtproductos.getValueAt(fila, 0).toString().trim();                 
                    float precio_unitario=Float.parseFloat(jtproductos.getValueAt(fila, 2).toString().trim());
                    int cantidad=Integer.parseInt(jtproductos.getValueAt(fila, 3).toString().trim());                                  
                    int existencia_total=Integer.parseInt(jtproductos.getValueAt(fila, 5).toString().trim());
                    String id_prod=jtproductos.getValueAt(fila, 6).toString().trim();                 
                    if(id_prod.equals(id)){         
                    //if(barcode.equals(codigobarra)){
                        cantidad++;
                        float total_final=precio_unitario*cantidad;                     
                        existencia_total=existencia_total-1;
                        jtproductos.setValueAt(cantidad, fila, 3); 
                        jtproductos.setValueAt(total_final, fila, 4);   
                        jtproductos.setValueAt(existencia_total, fila, 5);  
                        System.out.println("MAS DE UN REGISTRO PERO YA ESTA EN TABLA");
                        existe_tabla_temp=true;
                    }/*else{//es nuevo y se agrega    
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1});
                    }*/                 
                }

                if(existe_tabla_temp==false && jtproductos.getRowCount()>0){
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1,id,"0"});
                }
                
                if(jtproductos.getRowCount()<=0){//es el primer registro
                   System.out.println("PRIMER REGISTRO");
                   modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1,id,"0"});
                }
            }
             
        } catch (SQLException ex) {
        }
        
        jtproductos.getColumnModel().getColumn(6).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(6).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(6).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(6).setWidth(0);
        
        txtproducto.setText("");
        cargar_informacion();
        txtproducto.requestFocus();
    }
    
    
    public static void cargar_productobusquedacomun(String producto_code,String cantidadnueva,String montototal){
        DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();          
        String codigo_barras=producto_code;
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_productos WHERE idproducto='"+codigo_barras+"' and estatus=3"; //el estatus es producto comun
        System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            float precio=0;
            String codigobarra="",producto="";
            int existencia=0;
            String id="";
            boolean existe=false;
            if(rs.next()) {                 
                precio=rs.getFloat("precio_venta");
                codigobarra=rs.getString("codigo_barras");
                producto=rs.getString("nombre_producto");
                existencia=rs.getInt("existencia");
                id=rs.getString("idproducto");
                existe=true;
                //modelo.addRow(new Object[]{rs.getString("codigo_barras"),rs.getString("nombre_producto"),rs.getString("precio_venta"),"1","10",rs.getString("existencia")});
            }
            rs.close(); 
            st.close();
            con.desconectar();   
            
            if(existe){
                boolean existe_tabla_temp=false;
                for(int fila=0; fila<jtproductos.getRowCount(); fila++){
                    String barcode=jtproductos.getValueAt(fila, 0).toString().trim();                 
                    float precio_unitario=Float.parseFloat(jtproductos.getValueAt(fila, 2).toString().trim());
                    float cantidad=Float.parseFloat(jtproductos.getValueAt(fila, 3).toString().trim());                                  
                    int existencia_total=Integer.parseInt(jtproductos.getValueAt(fila, 5).toString().trim());
                    String id_prod=jtproductos.getValueAt(fila, 6).toString().trim();                 
                    if(id_prod.equals(id)){         
                    //if(barcode.equals(codigobarra)){
                        cantidad++;
                        float total_final=precio_unitario*cantidad;                     
                        existencia_total=existencia_total-1;
                        jtproductos.setValueAt(cantidad, fila, 3); 
                        jtproductos.setValueAt(total_final, fila, 4);   
                        jtproductos.setValueAt(existencia_total, fila, 5);  
                        System.out.println("MAS DE UN REGISTRO PERO YA ESTA EN TABLA");
                        existe_tabla_temp=true;
                    }/*else{//es nuevo y se agrega    
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"","1",precio+"",existencia-1});
                    }*/                 
                }

                if(existe_tabla_temp==false && jtproductos.getRowCount()>0){
                       System.out.println("MAS DE UN REGISTRO, PERO NUEVO");
                       modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadnueva,montototal+"",existencia-1,id,"0","0"});
                }
                
                if(jtproductos.getRowCount()<=0){//es el primer registro
                   System.out.println("PRIMER REGISTRO comun");
                   modelo.addRow(new Object[]{codigobarra,producto,precio+"",cantidadnueva,montototal+"",existencia-1,id,"0","0"});
                }
            }
             
        } catch (SQLException ex) {
        }
        
        jtproductos.getColumnModel().getColumn(6).setMaxWidth(0);
        jtproductos.getColumnModel().getColumn(6).setMinWidth(0);
        jtproductos.getColumnModel().getColumn(6).setPreferredWidth(0);
        jtproductos.getColumnModel().getColumn(6).setWidth(0);
        
        txtproducto.setText("");
        cargar_informacion();
        txtproducto.requestFocus();
    }
    
    
    public static void cargar_informacion(){
       double total_valor=0,ieps=0;
       int total=0;
       float noitem=0;
       for(int fila=0; fila<jtproductos.getRowCount(); fila++){
                String precio=jtproductos.getValueAt(fila, 2).toString();
                String cantidad=jtproductos.getValueAt(fila, 3).toString();
                String id=jtproductos.getValueAt(fila, 6).toString();
                Float costototal=Float.parseFloat(precio)*Float.parseFloat(cantidad);
                funciones redondear=new funciones();
                double imp=redondear.redondearDecimales(costototal, 2);
                System.out.println("enter: "+imp);
                jtproductos.setValueAt(imp+"", fila, 4);
           
           
               noitem=noitem+Float.parseFloat(jtproductos.getValueAt(fila, 3).toString());
                total_valor=total_valor+Float.parseFloat(jtproductos.getValueAt(fila, 4).toString());
                ieps=ieps+Float.parseFloat(jtproductos.getValueAt(fila, 8).toString());
                //System.out.println(""+total_valor);
                total++;
       }
       //DecimalFormat df = new DecimalFormat("0.00"); 
       //jlmonto.setText("$ "+df.format(total_valor)+"");    
       funciones redondear=new funciones();
       ieps=redondear.redondearDecimales(ieps, 2);              
      
       lbieps.setText(""+ieps+"");       
       total_valor=redondear.redondearDecimales(total_valor, 2);
       jlmonto.setText("$ "+total_valor+"");       
       jltotal.setText("Total Productos: "+noitem+"   Filas: "+total);
       double montototal=total_valor+(total_valor*obteniva());
       montototal=redondear.redondearDecimales(montototal, 2);
       montototal=montototal+ieps;
       
       jlgrantotal.setText("$ "+montototal+"");  
       txtproducto.requestFocus();
       
   } 


public void cobrar_venta(){
    String cliente=jccliente.getSelectedItem().toString();
    if(cliente.equals("Selecciona..")){
        cliente="0";
    }else{
        cliente=obtenidcliente(cliente);
    }
    
    
    int numprod=jtproductos.getRowCount();
    if(numprod>0){
        ArrayList productos=new ArrayList();
        for(int fila=0; fila<jtproductos.getRowCount(); fila++){
               //id    codigobarras      precioventa     cantidad     totalprod    descriprod     ieps     descuento      antibiotico        lote
               String antibiotico="NO",lote="0";
               if(jtproductos.getValueAt(fila, 9)==null){
               }else{
                   antibiotico=jtproductos.getValueAt(fila, 9).toString();
               }
               if(jtproductos.getValueAt(fila, 10)==null){
               }else{
                    lote=jtproductos.getValueAt(fila, 10).toString();
               }               
               if(lote.equals("")){
                   lote="0";
               }
               productos.add(jtproductos.getValueAt(fila, 6).toString()+"@"+jtproductos.getValueAt(fila, 0).toString()+"@"+jtproductos.getValueAt(fila, 2).toString()+"@"+jtproductos.getValueAt(fila, 3).toString()+"@"+jtproductos.getValueAt(fila, 4).toString()+"@"+jtproductos.getValueAt(fila, 1).toString()+"@"+jtproductos.getValueAt(fila, 8).toString()+"@"+jtproductos.getValueAt(fila, 7).toString()+"@"+antibiotico+"@"+lote);               
       }
        
        int cant=jlmonto.getText().trim().length();
        String monto=jlmonto.getText().trim().substring(1, cant); //se quita el caracter $        
        double monto_final=Float.parseFloat(monto);
        double ieps=Float.parseFloat(lbieps.getText().trim());
        Frame f = JOptionPane.getFrameForComponent(this);
        double iva=obteniva();
        double subtotal=monto_final;
        monto_final=monto_final+(monto_final*iva);
        funciones redondeo=new funciones();
        monto_final=redondeo.redondearDecimales(monto_final,2);
        monto_final=monto_final+ieps;
        //monto_final=Math.rint((monto_final*1000)/1000);//redondea los numeros
        
        String noreceta=txtnoreceta.getText().trim();
        String medico=txtmedico.getText().trim();
        
        Cobrar_venta venta=new Cobrar_venta(f,true,monto_final,productos,subtotal,cliente,ieps,noreceta,medico);
        venta.show();
    }else{
        JOptionPane.showMessageDialog(null, "No hay productos en la venta. ", "Error al registrar venta", JOptionPane.ERROR_MESSAGE);
        ponerfocoenventa();
    }

}    

public void ponerfocoenventa(){
    txtproducto.requestFocus();
    
}

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private static javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JComboBox<String> jccliente;
    private static javax.swing.JLabel jlfoto;
    private static javax.swing.JLabel jlgrantotal;
    private static javax.swing.JLabel jlmonto;
    private static javax.swing.JLabel jltotal;
    private javax.swing.JPanel jpfarmacia;
    public static javax.swing.JTable jtproductos;
    private static javax.swing.JLabel lbieps;
    private static javax.swing.JTextField txtcanti;
    private javax.swing.JTextField txtmedico;
    private javax.swing.JTextField txtnoreceta;
    public static javax.swing.JTextField txtproducto;
    // End of variables declaration//GEN-END:variables

    
    
    
    public void keyPressed(KeyEvent e) {
    if (e.VK_F3==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        ConsultarPrecio consultaprecio=new ConsultarPrecio(f,true);
        consultaprecio.show();
    }  
       
        
        
    if (e.VK_F7==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        ProductoComun dialog = new ProductoComun(f, true);
        dialog.show();
    }
    if (e.VK_F8==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        EntradaEfectivo dialog = new EntradaEfectivo(f, true);
        dialog.show();
    }
    if (e.VK_F9==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        SalidasEfectivo dialog = new SalidasEfectivo(f, true);
        dialog.show();
    }
    if (e.VK_F6==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        CargarPosVenta POS = new CargarPosVenta(f, true);
        POS.show();
    }
    
    if (e.VK_F1==e.getKeyCode())
    {
        vaciartabla();
        cargar_informacion();
        ponerfocoenventa();
    }
     
    
    if (e.VK_F4==e.getKeyCode())//CAMBIAR COSTO AL PRODUCTO
    {
       DefaultTableModel modelo=(DefaultTableModel) jtproductos.getModel();  
          int fila=-1;
          fila=jtproductos.getSelectedRow();
          if(fila!=-1){
              System.out.println("filaactual: "+fila);
              //String precio=jtproductos.getValueAt(fila, 2).toString();            
              String id=jtproductos.getValueAt(fila, 6).toString();            
              JFrame frame = new JFrame("Nuevo Precio");
              // prompt the user to enter their name
              String newprecio = JOptionPane.showInputDialog(frame, "Ingrese el nuevo precio?");              
              if(newprecio==null){
              }
              else if(newprecio.equals("")){
              }else{
                  if(isValidDouble(newprecio)){
                      try{
                        float prec = Float.parseFloat(newprecio); // convirtiendo la cadena
                        //for(int filapr=0; fila<jtproductos.getRowCount(); fila++){
                        //    String id_prod=jtproductos.getValueAt(fila, 6).toString().trim();                 
                        //    if(id_prod.equals(id)){  
                                jtproductos.setValueAt(prec+"", fila, 2); 
                                jtproductos.setValueAt(prec+"", fila, 4); 
                                txtcanti.setText("1");
                                txtproducto.setText("");
                                cargar_informacion();
                                txtproducto.requestFocus();
                          //  }           
                        //}
                      }catch(NumberFormatException exfloat){                     
                      }
                      cargar_informacion();
                  }else{
                      JOptionPane.showMessageDialog(null, "El formato de la cantidad no es correcto.","Alerta",JOptionPane.ERROR_MESSAGE);
                  }                  
              }
          }else{
            JOptionPane.showMessageDialog(null, "Seleccionar un producto de la tabla.","Alerta",JOptionPane.ERROR_MESSAGE);
         }
    }

    if (e.VK_F10==e.getKeyCode())
    {
        Frame f = JOptionPane.getFrameForComponent(this);
        catalogo_productos dialog = new catalogo_productos(f, true);
        dialog.show();
        //Inicial iniprod=new Inicial();
        //iniprod.setVisible(true);
    }
    
    if (e.VK_F12==e.getKeyCode())
    {
        cobrar_venta();
    }
    
   }


    
    @Override
    public void keyTyped(KeyEvent e) {        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    if (e.getSource()==txtproducto)
    {
        if (e.VK_ESCAPE==e.getKeyCode())
        {
            
        }
    }        
    }
    
    public static double obteniva(){
    double iva=0.0;    
    conex cn = new conex();    
    String sql="SELECT parametro from to_parametros where clave='IVA'";
    System.out.println(sql);
    PreparedStatement pstm100;
    try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
        while (rs100.next()) {

            iva=rs100.getDouble("parametro");	    		    			   
            }
        rs100.close();
        pstm100.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }
    iva=iva/100;
    return iva;
    }

public boolean validaragranel(String idprod){
    boolean valida=false;
    conex cn = new conex();    
    String sql="SELECT agranel from tc_productos where agranel='SI' and idproducto='"+idprod+"'";
    System.out.println(sql);
    PreparedStatement pstm100;
    try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
            if(rs100.next()) {
                valida=true;  		    			   
            }
        rs100.close();
        pstm100.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }
    return valida;
}


public static void cargar_clientes(){
       
        jccliente.removeAllItems();
        jccliente.addItem("Selecciona..");
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_clientes where estatus=1 order by nombre_completo asc";        
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);            
            while(rs.next()) {     
                jccliente.addItem(rs.getString("nombre_completo")+"-"+rs.getString("idcliente"));
            }
            String publico="";
            myQuery = "SELECT * FROM tc_clientes where nombre_completo like '%publico%' order by nombre_completo asc";   
            rs = st.executeQuery(myQuery);               
            while(rs.next()) {     
                publico=rs.getString("nombre_completo")+"-"+rs.getString("idcliente");
            }
            if(!publico.equals("")){
                jccliente.setSelectedItem(publico);
            }
            rs.close(); 
            st.close();
            con.desconectar();                
        } catch (SQLException ex) {
        }
       
   } 


public static String obtenidcliente(String id){
        String ids=id;
        String[] temp=ids.split("-");
        for(int i=1;i<2;i++){
            ids=temp[i];
        }
    return ids;
    }




public class MiRender extends DefaultTableCellRenderer
{
   public Component getTableCellRendererComponent(JTable table,
      Object value,
      boolean isSelected,
      boolean hasFocus,
      int row,
      int column)
   {
      Component comp = super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      boolean oddRow = (row % 2 == 0);
      Color azul = new Color(220, 248, 239);
      Color blanco = new Color(255,255,255);
      Color seleccion = new Color(75, 131, 141);    
      
      
      if ( oddRow ){
                 
         //if(column==2){
             this.setBackground(azul);
            this.setForeground(Color.BLACK);         
         /*}else{
             this.setBackground(blanco);
             this.setForeground(Color.BLACK); 
         }*/
      } else {
          
          /*if(column==2){
             this.setBackground(azul);
            this.setForeground(Color.white);         
         }else{*/
             this.setBackground(blanco);
             this.setForeground(Color.BLACK); 
         //}
          //this.setBackground(d);
          //this.setForeground(Color.BLACK);  
         // Restaurar los valores por defecto
      }    
      
       if(isSelected){
            this.setBackground(seleccion);
            this.setForeground(Color.white);   
      }
      
        
      return this;
   }
}   
   
public void poner_venta_pendiente(){
    int numprod=jtproductos.getRowCount();
    if(numprod>0){
       java.util.Date date = new java.util.Date();
       DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmss");
       String codigobarras="T"+dateFormat.format(date);
       ArrayList productos=new ArrayList();
       double monto=0;  
        
        conex conlocal=new conex();                   
        ResultSet rs = null;            
        try {
            Statement st = conlocal.getConnection().createStatement();
            for(int fila=0; fila<jtproductos.getRowCount(); fila++){
               //codigobarras   descriprod  preciounitario  cantidad  importe    existencia    idprod   descuento   ieps          
               productos.add(jtproductos.getValueAt(fila, 0).toString()+"@"+jtproductos.getValueAt(fila, 1).toString()+"@"+jtproductos.getValueAt(fila, 2).toString()+"@"+jtproductos.getValueAt(fila, 3).toString()+"@"+jtproductos.getValueAt(fila, 4).toString()+"@"+jtproductos.getValueAt(fila, 5).toString()+"@"+jtproductos.getValueAt(fila, 6).toString()+"@"+jtproductos.getValueAt(fila, 7).toString()+"@"+jtproductos.getValueAt(fila, 8).toString());               
               monto=monto+Float.parseFloat(jtproductos.getValueAt(fila, 4).toString());
               String consul="insert into to_pos_venta (folio,codbar,descprod,preciounitario,cantidad,importe,existencia,idprod,descuento,ieps,fecha,persona_atendio,tipo_venta)"
               + " values('"+codigobarras+"','"+jtproductos.getValueAt(fila, 0).toString()+"','"+jtproductos.getValueAt(fila, 1).toString()+"','"+jtproductos.getValueAt(fila, 2).toString()+"','"+jtproductos.getValueAt(fila, 3).toString()+"','"+jtproductos.getValueAt(fila, 4).toString()+"','"+jtproductos.getValueAt(fila, 5).toString()+"','"+jtproductos.getValueAt(fila, 6).toString()+"','"+jtproductos.getValueAt(fila, 7).toString()+"','"+jtproductos.getValueAt(fila, 8).toString()+"',now(),'"+accesoSistema.nombreuser+"','VENTATEMPORAL')";
               System.out.println(""+consul);
               st.executeUpdate(consul);            
            }            
            conlocal.desconectar();
        } catch (SQLException ex) {
            
        }
      JOptionPane.showMessageDialog(null, "Se guardo la venta temporalmente. ", "Ok", JOptionPane.INFORMATION_MESSAGE);
       vaciartabla();
       cargar_informacion();
       ponerfocoenventa();       
    }else{
        JOptionPane.showMessageDialog(null, "No hay productos para guardar. ", "Error al generar ticket de cobro", JOptionPane.ERROR_MESSAGE);
        ponerfocoenventa();
    }
}


public boolean isValidDouble(String s) {
    boolean isValid = true;

    try {
        Double.parseDouble(s);
    } catch(NumberFormatException nfe) {
        isValid = false;
    }

    return isValid;
}


}
