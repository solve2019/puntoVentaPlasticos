/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraspasoProductos;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import conexion.conex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


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
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
/**
 *
 * @author desarrollo8
 */
public class generarQR {
     public boolean Genera_CodigoQR(String identificador, String datosqr, String rutaarchivo){
        boolean valida=true;                
        String datoiniqr=datosqr;
        String rutaimagen=rutaarchivo+identificador+".png";   
        //System.out.println("ruta: "+rutaimagen);
                /*try {
                   conex conn;
                    conn = new conex();
                    PreparedStatement pstm;
                    pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_facturas set uuida=");
                    pstm.executeUpdate();
                    pstm.close();
                    conn.desconectar();

                } catch (SQLException ex) {

                }  */               
        
        String qrCodeData = datoiniqr;       
        String filePath = rutaimagen; 
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
         try {
             valida=createQRCode(qrCodeData, filePath, charset, hintMap, 130, 130);
         } catch (IOException ex) {
             valida=false;
             JOptionPane.showMessageDialog(null, "Error al generar el la imagen QR: "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
             Logger.getLogger(generarQR.class.getName()).log(Level.SEVERE, null, ex);
         } catch (WriterException ex) {
             valida=false;
             JOptionPane.showMessageDialog(null, "Error al generar el la imagen QR: "+ex,"Alerta",JOptionPane.ERROR_MESSAGE);
             Logger.getLogger(generarQR.class.getName()).log(Level.SEVERE, null, ex);
         }
        return valida;
    }
    
    public boolean createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth) throws IOException, WriterException{
        boolean valida=true;
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
        //System.out.println("Si entro a la generacion de el QR...");
        return valida;
    }

    
    
    
    
     public void imprimirpdftranspaso(String notraspaso,String fechaemision,String observacion ){
              System.out.println("notraspaso: "+notraspaso);
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
            String master = "reportes//machote_traspasos.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo generar el pdf, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte maestro: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo generar el pdf de la factura."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
            
            
            String razonsocial="",rfc="",lugaremision="",seriecertificadoemisor="";//datos emisor
            //String cliente="",callereceptor="",metodopago="",cpreceptor="",ciudadreceptor="",coloniareceptor="",rfcreceptor="",estadoreceptor="";//datos clientes
            //String importeletra="",subtotal="",descuento="",iva="",total="";//datos factura
    	    //String foliofiscal="",seriecertificadosat="",sellodigitalemisor="",sellosat="",cadenacomplemento="";//datos factura
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            
            
            try {
               conex conn2;
                conn2 = new conex();
                PreparedStatement pstm;
                pstm = (PreparedStatement) conn2.getConnection().prepareStatement("SELECT * from to_datos_facturacion where id_datos='1'");
                ResultSet rs=pstm.executeQuery();
                while(rs.next()){
                    //lugaremision="CALLE "+rs.getString("calle")+" #"+rs.getString("noext")+" Col. "+rs.getString("colonia")+" CP "+rs.getString("cp")+", "+rs.getString("municipio")+" "+rs.getString("estado");
                    lugaremision=rs.getString("calle")+" "+rs.getString("colonia")+" "+rs.getString("ciudad")+" "+rs.getString("estado")+" "+rs.getString("cp")+" "+rs.getString("pais");
                    razonsocial=rs.getString("razonsocial");
                    rfc=rs.getString("rfc");
                    seriecertificadoemisor=rs.getString("nocertificado");
                }
                rs.close();
                pstm.close();
                conn2.desconectar();

            } catch (SQLException ex) {
               
            }
            
            
            
            parametro.put("factura",notraspaso);               
            parametro.put("razonsocial",razonsocial);                       
            parametro.put("fechaemision", fechaemision);           
            parametro.put("observacion", observacion);     
            
            String rutaimagen=new File ("").getAbsolutePath ()+"\\imagenes_configurables\\";
            String rutacodbar=new File ("").getAbsolutePath ()+"\\traspasoproductos\\"+notraspaso+".png";
            
            parametro.put("rutaimagen", rutaimagen); 
            parametro.put("rutacodbar", rutacodbar); 
            

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            //JasperPrintManager.printReport(jasperPrint, false);
            
            /*JRExporter exporter = new JRPdfExporter();  // para exportar el archivo a pdf 
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            String rutafactura=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".pdf";//obtiene el path del folder                     
             System.out.println("rutafactura: "+rutafactura);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(rutafactura));  //poner la direccion donde se guardara el archivo
            exporter.exportReport();*/

            
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Traspasos");
            jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            JOptionPane.showMessageDialog(null,"No se pudo generar el pdf, error: "+j,"Mensaje",JOptionPane.PLAIN_MESSAGE);  
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
	
    
    
}
