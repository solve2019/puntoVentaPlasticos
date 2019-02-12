package PosVenta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClasesDAO.*;
import ClasesDAO.*;
import conexion.conex;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import javax.print.Doc; 
import javax.print.DocFlavor; 
import javax.print.DocPrintJob; 
import javax.print.PrintException;
import javax.print.PrintService; 
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc; 
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaPrintableArea;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.PrinterName;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author desarrollo8
 */
public class TicketPosVenta {
    
    
    public void imprimirPosVenta(String folio, String tipoImpresora, String codigobarras,String monto){
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
		
 		
 	String tamaimpresion="58",ticketlogo="NO";
        conex cn22 = new conex();
	String sql22="SELECT parametro from to_parametros where clave='TICKETLOGO'";	
	PreparedStatement pstm122;
	try {
		pstm122 = (PreparedStatement) cn22.getConnection().prepareStatement(sql22);
		ResultSet rs22 = (ResultSet) pstm122.executeQuery();
                if(rs22.next()) {	    	
	    	ticketlogo=rs22.getString("parametro");	    		    			   
		}
                sql22="SELECT parametro from to_parametros where clave='TAMANOTICKET'";	
                pstm122 = (PreparedStatement) cn22.getConnection().prepareStatement(sql22);
		rs22 = (ResultSet) pstm122.executeQuery();
                if(rs22.next()) {	    	
	    	tamaimpresion=rs22.getString("parametro");	    		    			   
		}
	    rs22.close();
            pstm122.close();
            cn22.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}        
                
                
 		
 		
	try
        {       
            String master = "reportes//ticket.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
            if(tamaimpresion.equals("80")){//TAMAÑO DE 80MM
                if(ticketlogo.equals("NO")){
                    master = "reportes//posticket.jasper";
                }else{
                }
            }else{//TAMAÑO DE 58MM
                if(ticketlogo.equals("SI")){
                    master = "reportes//posticket.jasper";
                }else{
                    master = "reportes//posticket.jasper";                    
                }
            }
            
            
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
	
        String user="",fecha="",cambio="",iva="",grantotal="",descuento="", mesa="", pagocon="";
        sql="SELECT usuario_registro,fecha_movimiento,monto_total, (efectivo+tarjeta+no_puntos) as pagocon, ((efectivo+tarjeta+no_puntos)-(monto_total+iva)) as cambio,iva,(monto_total+iva) as total, descuento,mesa from to_folios where no_folio='"+folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	user=rs100.getString("usuario_registro");
                fecha=rs100.getString("fecha_movimiento");
                
                cambio=rs100.getString("cambio");
                iva=rs100.getString("iva");
                grantotal=rs100.getString("total");
                descuento=rs100.getString("descuento");
                mesa=rs100.getString("mesa");
                pagocon=rs100.getString("pagocon");
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
            String fechass=dateFormat.format(date);
            String imagen=new File ("").getAbsolutePath ()+"\\imagenes_configurables\\";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");            
            
            parametro.put("codigo_barra",codigobarras);                           
            parametro.put("vendedor", accesoSistema.nombreuser);
            parametro.put("fecha", fechass);                        
            parametro.put("total", monto);
            
                              
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            
            
            String impresoraconfig="";
            conex con=new conex();  
            try {
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                
                String myQuery = "select parametro from to_parametros where clave='"+tipoImpresora+"'";
                System.out.println(""+myQuery);               
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                
                     impresoraconfig=rsR.getString("parametro");
                }                
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {       
                JOptionPane.showMessageDialog(null, "Error al obtener datos del parametros: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
            }  
            
            if(impresoraconfig.equals("") || impresoraconfig.equals("Por Defecto")){ //sin impresora
                //Para mandar a imprimir
                JasperPrintManager.printReport(jasperPrint, false);
            }else{
                    PrinterJob job = PrinterJob.getPrinterJob();
                    PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
                    int selectedService = 0;
                    for(int i = 0; i < services.length;i++){
                        if(services[i].getName().toUpperCase().contains("PDFCreator")){
                        selectedService = i;
                        } 
                    }
                    job.setPrintService(services[selectedService]);
                    PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
                    MediaSizeName mediaSizeName = MediaSize.findMedia(4,4,MediaPrintableArea.INCH);
                    printRequestAttributeSet.add(mediaSizeName);
                    printRequestAttributeSet.add(new Copies(1));

                    JRPrintServiceExporter exporter;
                    exporter = new JRPrintServiceExporter();

                    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
                    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
                    exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
                    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
                    exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
                    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                    exporter.exportReport();
            }                          
            
            //para ver el pdf    
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Ticket Pos venta");
            //jviewer.setVisible(true);		
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}    
}
