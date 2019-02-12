/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;

import Services.Stamp.SWStampService;
import Utils.Responses.SuccessV4Response;
import conexion.conex;
import java.io.File;
import java.io.FileWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author desarrollo8
 */
public class FacturaSmartWeb {
    public String facturar(String xmlfacturar,String noFactura, String patharchivos){
        
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
        
        String valor="";
        try{
                    //Es preferible inicializar el objeto con el usuario y password de nuestra cuenta, en caso contrario se puede incluir solamente el token de acceso
                    //Se especifica el base path, esto para consumir el api de pruebas o productivo
                    SWStampService sdk =null;
                    if(entornodesarrollo.equals("PRU")){//GENERA FACTURA DE PRUEBAS
                        sdk = new SWStampService("facturacion@solvemorelos.com.mx","sw.jose","http://services.test.sw.com.mx");
                        JOptionPane.showMessageDialog(null,"GENERACION DE FACTURAS DE PRUEBAS.","Alerta",JOptionPane.INFORMATION_MESSAGE);
                    }if(entornodesarrollo.equals("PROD")){//GENERA FACTURA EN PRODUCCION
                        //sdk = new SWStampService(userinvoice,contrainvoice,"http://services.sw.com.mx");
                        sdk = new SWStampService(userinvoice,contrainvoice,"http://services.sw.com.mx");
                    }
                    //Se inicializa un objeto response, que obtendra la respuesta del api
                    SuccessV4Response response = null;
                    //Se asigna el resultado de la respuesta a dicho objeto
                    //Se ejecuta el metodo "Stamp", que timbrara nuestro comprobante posteriormente sellado, asi como la versión del servicio de timbrado,
                    //puede ver mas de estas versiones en el apartado "Versiones de timbrado"
                    response =(SuccessV4Response) sdk.Stamp(xmlfacturar,"v4");
                    //El objeto response tendra así los atributos:
                    // Status: estado de la petición procesada, puede ser : "success", "fail", "error"
                    // HttpStatusCode: Codigo de respuesta HTTP del servidor: eg. 200, 400, 500
                    // Data: Cuerpo de la respuesta que arroja el servidor
                   String status=response.Status;  
                   System.out.println(response.Status);
                   /*System.out.println(response.message);                                                        
                   System.out.println(response.cfdi);
                   System.out.println(response.qrCode);
                   System.out.println(response.cadenaOriginalSAT);
                   System.out.println(response.selloCFDI);
                   System.out.println(response.selloSAT);
                   System.out.println(response.noCertificadoCFDI);
                   System.out.println(response.noCertificadoSAT);
                   System.out.println(response.fechaTimbrado);
                   System.out.println(response.uuid);
                   System.out.println(response.cfdi);*/
                   String xmlretorno=response.cfdi;                   
                   if(status.equals("success")){
                        guardararchivo(xmlretorno, noFactura, patharchivos);
                   }else{
                        valor=response.message;
                   }                   
        }catch(Exception e){
                        valor="Error Web Services: "+e.getMessage();
                        System.out.println(e.getMessage());
        }
        return valor;
    }
    
    public void guardararchivo(String xml, String noFactura, String patharchivos){
        System.out.println("patharchivos: "+patharchivos);
    try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
       // File archivo=new File("C:\\factura\\CXCXML\\"+noFactura+".xml"); //ruta de archivos para produccion
        File archivo=new File(patharchivos+"facturas_xml\\"+noFactura+".xml"); //ruta para archivos de desarrollo            
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        FileWriter escribir=new FileWriter(archivo,true);
        //Escribimos en el archivo con el metodo write 
        escribir.write(xml);
        //Cerramos la conexion
        escribir.close();
        }
        //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
            System.out.println("Error al escribir: "+e);
        }    
    }
}
