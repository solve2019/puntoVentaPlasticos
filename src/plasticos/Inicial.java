/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plasticos;

import bean.catalogo;
import conexion.conex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import plasticos.bolsas.BolsasP1;

import plasticos.cintas.CintasP1;
import plasticos.desechables.DesechablesP1;
import plasticos.higienicos.HigienicosP1;
import plasticos.limpieza.LimpiezaP1;
import plasticos.logistica.LogisticaP1;
import plasticos.madera.MaderaP1;
import plasticos.polietilenos.PolietilenoP1;
import puntoventa.variableEstaticas;

/**
 *
 * @author desarrollo8
 */
public class Inicial extends javax.swing.JFrame {

    /**
     * Creates new form Inicial
     */
    public Inicial() {
        setExtendedState(MAXIMIZED_BOTH);  
        initComponents();
 
        List<catalogo> lista = obtenerCatalogoPrincipal();
        if (lista.size() > 0) {
           
            int contador=0;
             int contador2=5;
             int valorTop=6;
            JButton btn;
            int costado = 20, top = 20, ancho = 250, alto = 80;
            boolean ban=false;
            for (int i = 0; i < lista.size(); i++) {
                catalogo bean=lista.get(i);
                //para ocultar botones
                
                if (bean.getNombre().equals("")) {
                  
                }else{
                    
                     btn = new JButton(bean.getNombre());
                 btn.setBounds(costado, top, ancho, alto);//los primeros indican x al costado y el segundo la parte alta
                //el tercero es el ancho y ultimo el alto
                 String img="";
                if (bean.getImagen().equalsIgnoreCase(" ")) {
                    System.out.println("aquiiiiiiiiiiiii");
                       //img = new File(".").getAbsolutePath() + "/imagenesCatalogo/carro.PNG";
                }else{
                       img = new File(".").getAbsolutePath() + bean.getImagen();
                }
              
                ImageIcon icono = new ImageIcon(img);

             
                btn.setIcon(icono);

               
                contador++;
              
                if (contador ==contador2) {
                    
                      costado = 20;
                      top = top +alto;
                     contador2+=5;
                    // valorTop+=1;
                     ban=true;
                    
                     
                } else {
                    //es para darles espacio entre cada boton
                    costado = costado + ancho + 20;
                }
               
               
                //prueba presiona boton
                btn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton obj = (JButton) e.getSource();
                        String nombre = obj.getText();
                       
                        variableEstaticas.nombreCatalogo=nombre;
                        BolsasP1 b= new BolsasP1();
                        b.setVisible(true);
                        
                        
                        dispose();
                       
                    }

                });
                    
                     add(btn);
                jPanel1.add(btn);
                }
               
                
            }
        } else {

        }

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 248, 248));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 834, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 494, Short.MAX_VALUE)
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
    public List<catalogo> obtenerCatalogoPrincipal() {
        List<catalogo> lista = new ArrayList<catalogo>();
        conex con = new conex();
        catalogo bean = null;
        try {
            String sql = "select * from catalogo order by nombre";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bean = new catalogo();
                bean.setIdCatalogo(rs.getString("idCatalogo"));
                bean.setNombre(rs.getString("nombre"));
                bean.setImagen(rs.getString("imagen"));
                lista.add(bean);
            }
            ps.close();
            rs.close();
            con.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en inicial metodo obtenerCatalogoPrincipal " + e.getMessage());
        }

        return lista;
    }

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
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
