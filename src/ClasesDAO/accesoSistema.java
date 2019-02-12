/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClasesDAO;

import conexion.conex;
import java.security.MessageDigest;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import puntoventa.ValidadorLicencia;

/**
 *
 * @author desarrollo8
 */
public class accesoSistema {
    public static String nombreuser="";
    public static String iduser;  
    public static String privilegio="";  
    public static double monto_caja_inicial=0.00;
    public static String licencia="DEMO";  
    
    public static String ventas="0";   
    public static String catcliente="0";   
    public static String catprod="0";   
    public static String catusuario="0";   
    public static String catcateg="0";   
    public static String proveedores="0";   
    public static String inventarios="0";   
    public static String reportes="0";   
    public static String respaldo="0";   
    public static String cotizaciones="0";   
    public static String agenda="0";   
    public static String traspasos="0";   
    public static String cierrecaja="0"; 
    public static String menufacturacion="0";
    public static String menuveterinaria="0";
    public static String menurestaurant="0";
    public static String menunotacredito="0";
    public static String menuserviciotecnico="0";
    public static String menufarmacia="0";
    public static String menufidelizaciones="0";
    public static String campostablaventa="0";//quita el descuento y el ieps
    public static String nombrecaja="";
    
    public accesoSistema() {
    }
    
   public boolean validaAcceso(String user,String password){
        ValidadorLicencia lic=new ValidadorLicencia();       
        //valida software
        if(lic.validasoftware()){
        licencia="ACTIVADO";
            //JOptionPane.showMessageDialog(null, "El software esta activo.","Test licencia",JOptionPane.INFORMATION_MESSAGE);  
        }else{
            JOptionPane.showMessageDialog(null, "El software esta en modo demostración o ya se vencio la licencia favor de contactar a su proveedor o ingresar a la opción de ('Acerca de..) www.solvemorelos.com.mx'","Licencia Demo o Vencida",JOptionPane.INFORMATION_MESSAGE);  
        }  
       
       
        conex con=new conex();   
        String pass=GeneraClaveMD5(password);
        boolean validauser=false;
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM tc_usuarios WHERE usuario ='"+user+"' and password='"+pass+"' and (estatus=1 or estatus=10)";
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            if(rs.next()) { 
                iduser=rs.getString("idusuario");
                nombreuser=rs.getString("nombre");
                privilegio=rs.getString("perfil");
                validauser=true;
            }
            
            if(validauser==true){
                nombrecaja=conex.caja;
                //JOptionPane.showMessageDialog(null, "Error en base de datos: "+nombrecaja, "Alerta BD", JOptionPane.ERROR_MESSAGE);
                myQuery = "SELECT * FROM privilegios WHERE usuario ='"+privilegio+"'";
                st = con.getConnection().createStatement();
                rs = st.executeQuery(myQuery);
                if(rs.next()) { 
                    ventas=rs.getString("ventas");
                    catcliente=rs.getString("catcliente");
                    catprod=rs.getString("catprod");
                    catusuario=rs.getString("catusuario");
                    catcateg=rs.getString("catcateg");
                    proveedores=rs.getString("proveedores");
                    inventarios=rs.getString("inventarios");
                    reportes=rs.getString("reportes");
                    respaldo=rs.getString("respaldo");
                    cotizaciones=rs.getString("cotizaciones");
                    agenda=rs.getString("agenda");
                    traspasos=rs.getString("traspasos");
                    cierrecaja=rs.getString("cierrecaja");
                    menufacturacion=rs.getString("facturacion");
                    menuveterinaria=rs.getString("veterinaria");
                    menurestaurant=rs.getString("restaurant");
                    menunotacredito=rs.getString("notacredito");
                    menuserviciotecnico=rs.getString("serviciotecnico");
                    menufarmacia=rs.getString("farmacia");
                    menufidelizaciones=rs.getString("fidelizaciones");
                }
            }
            
            rs.close(); 
            st.close();
            con.desconectar(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(accesoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    return validauser;
   } 
    
   public String caja_abierta(){
       String abierto="SI";
        conex con=new conex();                   
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM to_cierre_caja WHERE id_cierre_caja ='1'";        
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            if(rs.next()) { 
                abierto=rs.getString("activo");
            
            }
            rs.close(); 
            con.desconectar(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(accesoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    return abierto;
   } 
   
   
   public void iniciacaja(Double monto){
       
        conex con=new conex();                           
        String myQuery = "update to_cierre_caja set activo='SI', monto_inicio_caja=monto_inicio_caja+'"+monto+"' WHERE id_cierre_caja ='1'";        
        try {  
            Statement st = con.getConnection().createStatement();       
            st.executeUpdate(myQuery);            
            System.out.println("antes de actualizar cajas independientes");
            if(!accesoSistema.nombrecaja.equals("")){
                myQuery = "update to_cierre_caja set activo='SI', monto_inicio_caja='"+monto+"' WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                st.executeUpdate(myQuery);  
            }
            
            st.close();
            con.desconectar(); 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(accesoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       

   } 
   
    public String GeneraClaveMD5(String passs){
        //Transformanos el password a MD
        String contra = null;
        StringBuffer sb = new StringBuffer();
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(passs.getBytes());
            byte[] digest = md.digest();
            String hex;
            for (int i=0;i<digest.length;i++){
                hex =  Integer.toHexString(0xFF & digest[i]);
                if(hex.length() == 1){hex = "0" + hex;}
                sb.append(hex);            
            }
        } catch(Exception ee) {

        }
        contra = sb.toString();

        return contra;
    }
   
   
   
}

