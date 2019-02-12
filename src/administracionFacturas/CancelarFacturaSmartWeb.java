/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;

import Exceptions.AuthException;
import Exceptions.GeneralException;
import Services.Cancelation.SWCancelationService;
import Utils.Responses.CancelationResponse;
import conexion.conex;
import java.io.File;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;
import ClasesDAO.accesoSistema;
/**
 *
 * @author desarrollo8
 */
public class CancelarFacturaSmartWeb {
    public boolean cancelafactura(String factura){
   String uuid="",  password_csd="",  rfc="",  b64Cer="", b64Key="";
   String patharchivos=new File ("").getAbsolutePath ()+"\\facturacion\\";   
   String rutacer=""+patharchivos+"CSD_Empresa\\certificado.cer";
   String rutakey=""+patharchivos+"CSD_Empresa\\llave.key";
   b64Cer=obtenbase64(rutacer);
   b64Key=obtenbase64(rutakey);
    conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select uuid from to_facturas where factura="+factura;                       
        try {
            Statement st = con.getConnection().createStatement();                                      
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {                              
                uuid=rsR.getString("uuid");                               
            }
            myQuery="select * from to_datos_facturacion where id_datos=1";
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {                              
                password_csd=rsR.getString("clave_privada");                               
                rfc=rsR.getString("rfc"); 
            }
            
            rsR.close(); 
            st.close();
            con.desconectar();
        } catch (SQLException ex) {                               
        }  
       
        String entornodesarrollo="";
        String userinvoice="",contrainvoice="";
        conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENTORNODESARROLLO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	entornodesarrollo=rs100.getString("parametro");	    		    			   
		}
                sql="SELECT parametro from to_parametros where clave='SMARTWEBUSER'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	userinvoice=rs100.getString("parametro");	    		    			   
		}
                sql="SELECT parametro from to_parametros where clave='SMARTWEBCONTRA'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	contrainvoice=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
            pstm100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	} 
        
            
    boolean validacancelacion=false;        
        try {     
        SWCancelationService app=null;
        if(entornodesarrollo.equals("PRU")){//GENERA FACTURA DE PRUEBAS
            app = new SWCancelationService("facturacion@solvemorelos.com.mx","sw.jose","http://services.test.sw.com.mx");   
            JOptionPane.showMessageDialog(null,"CANCELACION DE FACTURAS DE PRUEBAS.","Alerta",JOptionPane.INFORMATION_MESSAGE);
        } 
        if(entornodesarrollo.equals("PROD")){//GENERA FACTURA EN PRODUCCION
            app = new SWCancelationService(userinvoice,contrainvoice,"http://services.sw.com.mx");   
        }
        CancelationResponse response = null;
        response = (CancelationResponse)app.Cancelation(uuid, password_csd, rfc, b64Cer, b64Key);
        String status=response.Status;        
        System.out.println(response.Status);
        if(status.equals("error")){
            JOptionPane.showMessageDialog(null,"Error al cancelar: "+response.message,"Alerta",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(response.HttpStatusCode);
        System.out.println(response.acuse);
        System.out.println(response.uuid);
        System.out.println(response.uuidStatusCode);
        //En caso de obtener un error, este puede obtenerse de los campos
        System.out.println(response.message);
        System.out.println(response.messageDetail);
        if(status.equals("success")){
            String xml=response.acuse;
            validacancelacion=true;            
                String patharchivos1=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\";
                try
                {
                    //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
                    File archivo=new File(patharchivos1+factura+"_cancelada.xml");
                    //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
                    FileWriter escribir=new FileWriter(archivo,true);
                    //Escribimos en el archivo con el metodo write 
                    escribir.write(xml);
                    //Cerramos la conexion
                    escribir.close();
                }catch(Exception e){
                    System.out.println("Error al escribir");
                }
                myQuery = "update to_facturas set estatus=5, fecha_cancelacion=now(),usuario_cancelacion='"+accesoSistema.nombreuser+"' where factura="+factura;        
                con=new conex();                  
                try {
                    Statement st = con.getConnection().createStatement();                                      
                    st.executeUpdate(myQuery);            
                    st.close();
                    con.desconectar();                    
                } catch (SQLException ex) {       
                    JOptionPane.showMessageDialog(null, "Error al modificar el estatus de la factura: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                }     
            
        }        
        } catch (AuthException ex) {
            Logger.getLogger(CancelarFacturaSmartWeb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GeneralException ex) {
            Logger.getLogger(CancelarFacturaSmartWeb.class.getName()).log(Level.SEVERE, null, ex);
        }
    return validacancelacion;
    }
    
    public String obtenbase64(String ruta){
        Base64 base64 = new Base64();
        File file = new File(ruta);
	byte[] fileArray = new byte[(int) file.length()];
        InputStream inputStream;
        String encodedFile = "";
        try {
                inputStream = new FileInputStream(file);
                inputStream.read(fileArray);
                encodedFile = base64.encodeToString(fileArray);
        } catch (Exception e) {
                // Manejar Error
        }        
        //System.out.println(encodedFile);
        return encodedFile;
    }
}
