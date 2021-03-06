/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PosVenta;

import jdialog.*;
import Utilerias.funciones;
import conexion.conex;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author desarrollo8
 */
public class Agranel_Pos extends javax.swing.JDialog {
Com com1=null;
String usarbascula="NO", puerto_com="COM8";
Timer timer = new Timer();  
    /**
     * Creates new form Agranel
     */
    public Agranel_Pos(java.awt.Frame parent, boolean modal,String prod,String precio) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        

        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM to_parametros WHERE clave='BASCULA' or clave='PUERTOBASCULA'";
        System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            while(rs.next()) { 
                if(rs.getString("clave").equals("BASCULA")){
                    usarbascula=rs.getString("parametro");
                }
                if(rs.getString("clave").equals("PUERTOBASCULA")){
                    puerto_com=rs.getString("parametro");
                }                
            }
            rs.close(); 
            con.desconectar(); 
        } catch (SQLException ex) {
        }                
        txtprecio.setText(precio);
        jlproducto.setText(prod);
        txtcantidad.requestFocus();               
        
        
        if(usarbascula.equals("SI")){
            //Definición de parametros        
            try {
                Parameters settings;
                settings = new Parameters();
                //definición del puerto que se va a utilizar
                //settings.setPort("COM8");
                settings.setPort(puerto_com);            
                settings.setBaudRate(Baud._9600);
                //asignamos los parametros al objeto com1
                com1 = new Com(settings);             
            } catch (Exception ex) {
                Logger.getLogger(Agranel_Pos.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
            timer.schedule(new OBTENPESO(), 0, 1500);

        }
        
        
        
        
        /*int contador = 0 ;
            do {              
                  com1.sendSingleData("P");               
                  Thread.sleep(60);                                                          
                  String pesoval="";
                  for(int i=0;i<12;i++){
                      //System.out.println("val: "+com1.receiveSingleChar());
                      char value=com1.receiveSingleChar();
                      if (Character.isDigit(value)){ //evalua si es numero
                          pesoval=pesoval+value;
                      }
                      String caract=value+"";
                      if(caract.equals(".")){  //evalua si es un punto
                          pesoval=pesoval+value;
                      }            
                      Thread.sleep(40);
                  }              
                  pesoval=pesoval.trim();        
                  txtcantidad.setText(pesoval);
                  txtcantidad.requestFocus();
                  System.out.println("pesoval: "+pesoval.trim());                      
                  Thread.sleep(500);
            } while (contador<10);*/
        
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
        jlproducto = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jlprecio = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txttotalpagar = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("¿Cantidad del producto?");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(248, 247, 247));
        jPanel1.setToolTipText("");

        jlproducto.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlproducto.setForeground(new java.awt.Color(0, 102, 204));
        jlproducto.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlproducto.setText("PRODUCTO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("Importe Actual:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kg del producto:");

        jlprecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlprecio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlprecio.setText("Precio Unitario:");

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtcantidad.setText("1");
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcantidadKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txttotalpagar.setEditable(false);
        txttotalpagar.setBackground(new java.awt.Color(204, 204, 204));
        txttotalpagar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txttotalpagar.setText("0");

        txtprecio.setBackground(new java.awt.Color(204, 204, 204));
        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtprecio.setEditable(false);
        txtprecio.setText("0");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/carrito.png"))); // NOI18N
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlproducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtcantidad)
                                    .addComponent(txttotalpagar, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(txtprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 51, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txttotalpagar)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
         if(txtcantidad.getText().trim().length()>=9){
            //JOptionPane.showMessageDialog(null, "Solo acepta 15 caracteres", "Alerta", JOptionPane.ERROR_MESSAGE);
            evt.consume(); // ignorar el evento de teclado
        }else{
            if (((evt.getKeyChar() < '0') || (evt.getKeyChar() > '9')) && (evt.getKeyChar() != '.')){
               evt.consume(); // ignorar el evento de teclado
            }
        }
         
        
        
    }//GEN-LAST:event_txtcantidadKeyTyped

    public void actualizacosto(){
        String canti=txtcantidad.getText().trim();
        if(canti.equals("")){
        }else{
            String precio=txtprecio.getText().trim();
            float total=0;
            try{
            total=Float.parseFloat(canti)*Float.parseFloat(precio);     
            funciones redondear=new funciones();
            double totl=redondear.redondearDecimales(total, 2);
            txttotalpagar.setText(totl+"");
            }catch(NumberFormatException ex){
                txtcantidad.setText("1");
                JOptionPane.showMessageDialog(null, "Error el formato de cantidad esta mal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }
    
    private void txtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyReleased
        
        actualizacosto();
        // TODO add your handling code here:        
        /*String canti=txtcantidad.getText().trim();
        if(canti.equals("")){
        }else{
            String precio=txtprecio.getText().trim();
            float total=0;
            try{
            total=Float.parseFloat(canti)*Float.parseFloat(precio);     
            funciones redondear=new funciones();
            double totl=redondear.redondearDecimales(total, 2);
            txttotalpagar.setText(totl+"");
            }catch(NumberFormatException ex){
                txtcantidad.setText("1");
                JOptionPane.showMessageDialog(null, "Error el formato de cantidad esta mal", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }*/
    }//GEN-LAST:event_txtcantidadKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         agregar();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){        
            agregar();
        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if(usarbascula.equals("SI")){
            /*try {
                // TODO add your handling code here:
                com1.close();               
            } catch (Exception ex) {
                Logger.getLogger(Agranel.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(usarbascula.equals("SI")){
            timer.purge();
            timer.cancel();                              
            try {
                // TODO add your handling code here:
                com1.close();               
            } catch (Exception ex) {
                Logger.getLogger(Agranel_Pos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Agranel_Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agranel_Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agranel_Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agranel_Pos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Agranel_Pos dialog = new Agranel_Pos(new javax.swing.JFrame(), true,"","");
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jlprecio;
    private javax.swing.JLabel jlproducto;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtprecio;
    private javax.swing.JTextField txttotalpagar;
    // End of variables declaration//GEN-END:variables

public void agregar(){
        String canti=txtcantidad.getText().trim();
        if(canti.equals("")){
            JOptionPane.showMessageDialog(null, "Error no ha colocado la cantidad", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            Pos_Ventas.cantidadagranel=txtcantidad.getText().trim();
            if(usarbascula.equals("SI")){
                try {
                    timer.purge();
                    timer.cancel();                  
                    com1.close();               
                } catch (Exception ex) {
                    Logger.getLogger(Agranel_Pos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            dispose();
        }
}


class OBTENPESO extends TimerTask {
	public void run() {
            try{
                  com1.sendSingleData("P");               
                  Thread.sleep(60);                                                          
                  String pesoval="";
                  for(int i=0;i<12;i++){
                      //System.out.println("val: "+com1.receiveSingleChar());
                      char value=com1.receiveSingleChar();
                      if (Character.isDigit(value)){ //evalua si es numero
                          pesoval=pesoval+value;
                      }
                      String caract=value+"";
                      if(caract.equals(".")){  //evalua si es un punto
                          pesoval=pesoval+value;
                      }            
                      Thread.sleep(40);
                  }              
                  pesoval=pesoval.trim();        
                  txtcantidad.setText(pesoval);
                  txtcantidad.requestFocus();
                  actualizacosto();
                  System.out.println("pesoval: "+pesoval.trim());                      
                  Thread.sleep(600);
            } catch (Exception ex) {
                Logger.getLogger(Agranel_Pos.class.getName()).log(Level.SEVERE, null, ex);
            }			
		}// end run()
    }// end SincronizacionAutomatica
 
}

 
