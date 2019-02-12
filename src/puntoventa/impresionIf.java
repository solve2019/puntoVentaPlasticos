/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventa;

import conexion.conex;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import plasticos.bolsas.P2Agranel;

/**
 *
 * @author famsa
 */
public class impresionIf {

    public void eje() {
        conex con = new conex();
        String v = "if(nombre.equals('"+'"'   +'"'+"')){\n";
        try {
            String sql = "select * from subcatalogo ";
            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                /*bean = new catalogo();
                bean.setIdCatalogo(rs.getString("idCatalogo"));
                bean.setNombre(rs.getString("idCatalogo")+" - "+rs.getString("nombre"));
                bean.setImagen(rs.getString("imagen"));*/
                if (rs.getString("nombre").equalsIgnoreCase("")) {

                } else {
                    if (rs.getString("nombreClase").isEmpty()) {

                    } else {
                        String  name=rs.getString("nombre");
                        if (rs.getString("nombre").equalsIgnoreCase("aaainicio")) {
                           name =rs.getString("nombre").substring(3);
                        }
                        String arreDatos[] = rs.getString("nombreClase").split(" ");
                        v = v + "}else if(nombre.equalsIgnoreCase('" +'"'+ name + '"'+"')){\n"
                                + "" + rs.getString("nombreClase") + "\n"
                                + "" + arreDatos[1] + ".setVisible(true);\n"
                                + "dispose();\n"
                                + "";
                    }

                }

                //lista.add(bean);
            }
            v=v+"}else{\n"
                    + "}";
           v=v.replace("'", "");
            System.out.println("v " + v);
            ps.close();
            rs.close();
            con.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en imprimirif metodo eje " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        impresionIf n = new impresionIf();
        n.eje();
        String nombre="";
       
    }
    }
