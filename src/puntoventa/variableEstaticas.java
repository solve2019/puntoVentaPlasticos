/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventa;

import bean.producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author famsa
 */
public class variableEstaticas {
     public static String nombreCatalogo;
     public static List<producto>lista=new ArrayList<producto>();
     public static boolean controlVentas=false;
     public static JTable tabla = new JTable();
     public static DefaultTableModel modelTabla= new DefaultTableModel();
     public static String cliente="";
}
