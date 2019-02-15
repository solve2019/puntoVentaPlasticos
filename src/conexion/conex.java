/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conexion;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 *
 * @author desarrollo8
 */
public class conex {
static Properties PR;	

static String iparchivo="";
static String usuarioarchivo="";
static String passarchivo="";
static String bdarchivo="";
public static String caja="";
 //public static String login = "root1";
 //public static String password = "root";

 public static String login = "root";
 public static String password = "";
 public static String ip = "localhost";
 
 
 public static String bd = "bdplasticos";  
 public static String url = ""; 
   
   Connection conn = null;

   public conex(){
       ip=leerip();
       //System.out.println(""+ip);
       if(ip.equals("")){
           ip="localhost";
       }
       
       if(!bdarchivo.equals("")){
           bd=bdarchivo;
       }
       
       if(!usuarioarchivo.equals("")){
           login=usuarioarchivo;
       }
       if(!passarchivo.equals("")){
           password=passarchivo;
       }
       url = "jdbc:mysql://"+ip+":3306/"+bd; //tesnting
       try{
         Class.forName("com.mysql.jdbc.Driver");
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            //sSystem.out.println("Conexion a base de datos "+bd+" OK");
         }
      }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Error BD: "+ip+"  "+e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
         //System.out.println(e);
      }catch(ClassNotFoundException e){
         //System.out.println(e);
         JOptionPane.showMessageDialog(null, "Error BD: "+ip+"   "+e.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);
      }
   }
    
   public Connection getConnection(){
      return conn;
   }

   public void desconectar() throws SQLException{
       if(conn!=null){
               conn.close();
        }      
   }

   public String user(){
   
   return password;
  }
   
    

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }


public static String leerip(){
    String sFile ="Parametro_Configuracion.ini";
    String ips="";
            PR = new Properties();
            try {
                java.io.FileInputStream FIS = new java.io.FileInputStream(sFile);
                PR.load( FIS );
                FIS.close();
                ips = PR.getProperty("servidor");
                iparchivo= PR.getProperty("servidor");                
                usuarioarchivo= PR.getProperty("user");
                passarchivo= PR.getProperty("pass");                
                caja= PR.getProperty("caja");
                bdarchivo= PR.getProperty("bd");
                
                
                if(bdarchivo==null){
                    bdarchivo="";
                }
                if(usuarioarchivo==null){
                    usuarioarchivo="";
                }
                if(passarchivo==null){
                    passarchivo="";
                }
                if(caja==null){
                    caja="";
                }
                } catch (Exception e){
                System.out.println("Ha ocurrido una excepcion al abrir el fichero, no se encuentra o está protegido");
            }           
    return ips;				    
}    


}

