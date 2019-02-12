package jinternalPanel.Proveedores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClasesDAO.*;
import ClasesDAO.*;
import conexion.conex;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.export.JRPdfExporter;
/**
 *
 * @author desarrollo8
 */
public class TicketCompra {
    
    
    public void imprimirticket(String folio){
        System.out.println("imprimiendo");
		java.sql.Connection conn = null;		
 		String bd = conex.bd;   
 		String login = conex.login;   
 		String password = conex.password;  
 		String ip=conex.ip;
 		
 		
 		String url = "jdbc:mysql://"+ip+"/" + bd; 

 		try 
         {
 			
    		 Class.forName("com.mysql.jdbc.Driver");
 			conn = DriverManager.getConnection(url, login, password);
 			
          
         } 
         catch (ClassNotFoundException ex) 
         {
             ex.printStackTrace();
         } 
         catch (SQLException ex) 
         {
             ex.printStackTrace();
         }
		
 		
 		
 		
 		
		try
        {       
            String master = "reportes//ticket.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo de la etiqueta maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte maestro: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
        String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	encabezado=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
	sql="SELECT parametro from to_parametros where clave='FOOTER'";
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	footer=rs100.getString("parametro");	    		    			   
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
        String user="",fecha="",monto="",cambio="",iva="",grantotal="",descuento="";
        sql="SELECT usuario_registro,fecha_movimiento,monto_total, ((efectivo+tarjeta+no_puntos)-(monto_total+iva)) as cambio,iva,(monto_total+iva) as total, descuento from to_folios where no_folio='"+folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	user=rs100.getString("usuario_registro");
                fecha=rs100.getString("fecha_movimiento");
                monto=rs100.getString("monto_total");
                cambio=rs100.getString("cambio");
                iva=rs100.getString("iva");
                grantotal=rs100.getString("total");
                descuento=rs100.getString("descuento");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        try {
            cn.desconectar();
        } catch (SQLException ex) {

        }
            
            
            
    		
    		
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");            
            
            parametro.put("folio",folio);               
            parametro.put("encabezado", encabezado);
            parametro.put("footer", footer);
            parametro.put("user", user);
            parametro.put("fecha", fecha);
            
            parametro.put("subtotal", monto);
            parametro.put("descuento", descuento);
            parametro.put("total", grantotal);
            parametro.put("cambio",cambio );
                     
            

            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //Para mandar a imprimir
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicacion al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Ticket venta");
            jviewer.setVisible(true);		
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}
	
    
    public String tipoimpresion(){
        String tipo="";
        conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='TIPOIMPRESION'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	tipo=rs100.getString("parametro");	    		    			   
            }
	    rs100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}		        
        return tipo;
    }
    
}
