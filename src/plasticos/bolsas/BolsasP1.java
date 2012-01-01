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
import plasticos.desechables.*;
import plasticos.bolsas.*;
import plasticos.cintas.*;
import plasticos.desechables.*;
import plasticos.higienicos.*;
import plasticos.logistica.*;
import plasticos.limpieza.*;
import plasticos.madera.*;
import plasticos.polietilenos.P2productoscharomesa;
import plasticos.polietilenos.P2productospolietileno;
import plasticos.polietilenos.*;

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
        System.out.println("entro " + variableEstaticas.nombreCatalogo);
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

                            //aqui **************************************************************************************
                            if (nombre.equals("")) {
                            } else if (nombre.equalsIgnoreCase("AGRANEL")) {
                                P2Agranel p2agrane = new P2Agranel();
                                p2agrane.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("BASURA")) {
                                P2basura p2basura = new P2basura();
                                p2basura.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ESPECIALES")) {
                                P2especiales p2espec = new P2especiales();
                                p2espec.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("HOJAS (LAMINILLAS)")) {
                                P2laminas p2lamin = new P2laminas();
                                p2lamin.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ASAS")) {
                                P2asas p2asa = new P2asas();
                                p2asa.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ROLLOS")) {
                                P2rollos p2rollos = new P2rollos();
                                p2rollos.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("LOGISTICA")) {
                                P2productoslogistica logistica = new P2productoslogistica();
                                logistica.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("GRADO ALIMENTICIO")) {
                                P2productosgradomesa gradoalimenticio = new P2productosgradomesa();
                                gradoalimenticio.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("RAFIA")) {
                                P2productosrafia rafia = new P2productosrafia();
                                rafia.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("CHAROLAS")) {
                                P2charolas p2charo = new P2charolas();
                                p2charo.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("VASO PLASTICO")) {
                                P2vasoplastico p2vasoplas = new P2vasoplastico();
                                p2vasoplas.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("VASO TERMICO")) {
                                P2vasoplastico p2vasoplas = new P2vasoplastico();
                                p2vasoplas.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("PLATOS")) {
                                P2platos p2platos = new P2platos();
                                p2platos.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("CONTENEDORES")) {
                                P2contenedores p2contene = new P2contenedores();
                                p2contene.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("CUBIERTOS")) {
                                P2cubierto p2cubierto = new P2cubierto();
                                p2cubierto.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("POPOTE")) {
                                P2popote p2popote = new P2popote();
                                p2popote.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ALUMINIO")) {
                                P2aluminio aluminio = new P2aluminio();
                                aluminio.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("POLIETILENOS")) {
                                P2productospolietileno polietileno = new P2productospolietileno();
                                polietileno.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("CHAROMESA")) {
                                P2productoscharomesa charo = new P2productoscharomesa();
                                charo.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ESCOBAS")) {
                                P2escoba escoba = new P2escoba();
                                escoba.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("MECHUDOS")) {
                                P2mechudo mechudo = new P2mechudo();
                                mechudo.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("FRANELA")) {
                                P2franela franela = new P2franela();
                                franela.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("QUIMICOS")) {
                                P2quimicos qumicos = new P2quimicos();
                                qumicos.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("JARCERIA")) {
                                P2jarceria jarceria = new P2jarceria();
                                jarceria.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("JERGA")) {
                                P2jerga jerga = new P2jerga();
                                jerga.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("DESPACHADORES")) {
                                P2despachadores toallas = new P2despachadores();
                                toallas.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("HIGIENICO LINEAS")) {
                                P2linea8 linea8 = new P2linea8();
                                linea8.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("TRADICIONALES")) {
                                P2tradicionales tradicionales = new P2tradicionales();
                                tradicionales.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("SERVILLETAS")) {
                                P2servilletas servi = new P2servilletas();
                                servi.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("TOALLAS")) {
                                P2toallas toallas = new P2toallas();
                                toallas.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ESTRAZA")) {
                                P2estraza estraza = new P2estraza();
                                estraza.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("MADERA")) {
                                P2made madera = new P2made();
                                madera.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("CANELA")) {
                                P2canda p2cinta = new P2canda();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("TRANSPARENTE")) {
                                P2cintas p2cinta = new P2cintas();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("COLORES")) {
                                P2colores p2cinta = new P2colores();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("IMPRESAS")) {
                                P2impresas p2impresa = new P2impresas();
                                p2impresa.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("MASKING")) {
                                P2masking p2cinta = new P2masking();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("DUCTO")) {
                                P2ducto p2cinta = new P2ducto();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("ELECTRICAS")) {
                                P2electricas p2cinta = new P2electricas();
                                p2cinta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("TAPAS VASO TERMICO")) {
                                P2tapavasotermico P2ta = new P2tapavasotermico();
                                P2ta.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("TAPAS VASO PLASTICO")) {
                                P2tapavasoplastico P2tapa = new P2tapavasoplastico();
                                P2tapa.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else if (nombre.equalsIgnoreCase("INICIO")) {
                                Inicial Inic = new Inicial();
                                Inic.setVisible(true);
                                dispose();
                            } else {
                            }
//fin *********************************************************************************************
                            }

                        }

                        );

                        add(btn);

                        jPanel1.add (btn);

                    }

                }
            }else {

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
