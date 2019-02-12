/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plasticos.bolsas;

import bean.catalogo;
import conexion.conex;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import plasticos.Inicial;
import javax.swing.ImageIcon;

import puntoventa.variableEstaticas;

/**
 *
 * @author desarrollo8
 */
public class BolsasP1 extends javax.swing.JFrame {
   
    /**
     * Creates new form BosasP1
     */
    //declaramos una varibale donde se 
    //guardar el nombre del catalogo para hacer consulta y mostar los  botones del subcatalogo
   

    public BolsasP1() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        System.out.println("entro "  + variableEstaticas.nombreCatalogo);
        int costado = 20, top = 20, ancho = 250, alto = 80;
        boolean ban = false;

        List<catalogo> lista = obtenerSubCatalogos();
        if (lista.size() > 0) {

            int contador = 0;
            int contador2 = 5;
            int valorTop = 6;
            JButton btn;

            for (int i = 0; i < lista.size(); i++) {
                catalogo bean = lista.get(i);
                //para ocultar botones

                if (bean.getNombre().equals("")) {

                } else {
                    if (bean.getNombre().equalsIgnoreCase("aaainicio")) {
                        btn = new JButton("INICIO");
                    } else {
                        btn = new JButton(bean.getNombre());
                    }

                    //es para darles espacio entre cada boton
                    btn.setBounds(costado, top, ancho, alto);//los primeros indican x al costado y el segundo la parte alta
                    //el tercero es el ancho y ultimo el alto

                    String img = "";
                    if (bean.getImagen().equalsIgnoreCase("")) {
                        img = new File(".").getAbsolutePath() + "/imagenesSubCatalogo/carro.PNG";
                    } else {
                        img = new File(".").getAbsolutePath() + bean.getImagen();
                    }

                    ImageIcon icono = new ImageIcon(img);

                    btn.setIcon(icono);

                    contador++;

                    if (contador == contador2) {
                      
                        costado = 20;
                        top = top + alto;
                        contador2 += 5;
                        // valorTop+=1;
                        ban = true;

                    } else {
                        costado = costado + ancho + 20;
                    }

                    //prueba presiona boton
                    btn.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            JButton obj = (JButton) e.getSource();
                            String nombre = obj.getText();

                            //aqui ********************
                            if (nombre.equals("")) {
                            } else if (nombre.equalsIgnoreCase("AGRANEL")) {
                                
                                P2Agranel p2a = new P2Agranel();
                                p2a.setVisible(true);
                               
                            } else if (nombre.equalsIgnoreCase("BASURA")) {
                                BolsasP1 b = new BolsasP1();
                                b.setVisible(true);
                                
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                
                            } else {
                            }
                            //fin *********

                        }

                    });

                    add(btn);
                    jPanel1.add(btn);

                }

            }
        } else {

        }
        //******************

    }

    public List<catalogo> obtenerSubCatalogos() {
        List<catalogo> lista = new ArrayList<catalogo>();
        conex con = new conex();
        catalogo bean = null;
        try {
            String sql = "select * from subCatalogo where nombreCatalogo=? order by nombre";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            System.out.println("nombre homis " + variableEstaticas.nombreCatalogo);
            ps.setString(1, variableEstaticas.nombreCatalogo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                bean = new catalogo();
                bean.setIdCatalogo(rs.getString("idSubCatalogo"));
                bean.setNombre(rs.getString("nombre"));
                bean.setImagen(rs.getString("imagen"));
                lista.add(bean);
            }
            ps.close();
            rs.close();
            con.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en BolsasP1 metodo obtenerCatalogoPrincipal " + e.getMessage());
        }

        return lista;
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

        jPanel1.setBackground(new java.awt.Color(251, 248, 248));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 918, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
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
            java.util.logging.Logger.getLogger(BolsasP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BolsasP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BolsasP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BolsasP1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new BolsasP1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
