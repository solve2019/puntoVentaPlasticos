/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClasesDAO;
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
public class TiketPDF {
    
    
    public void imprimiretiqueta(String producto, String barcodes, String preciomenudeo, String preciomayoreo){
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
            String master = "reportes//etiqueta.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo de la etiqueta maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir la etiqueta, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
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
            
            
            
            
            
            
    		
    		
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("codigo_barra", barcodes);
            parametro.put("folio",producto);   
            parametro.put("precioventa", "$"+preciomenudeo);
            parametro.put("preciomayoreo", "P"+preciomayoreo+"M");
            
            //parametro.put("vendedor", accesoSistema.nombreuser);
            parametro.put("vendedor", "");
            parametro.put("fecha", dateFormat.format(date));
            parametro.put("total", "");
            parametro.put("empresa", "Bali   Tel: 100-12-12");
            //parametro.put("empresa", "");
                     
            

            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //Para mandar a imprimir
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Etiqueta");
            jviewer.setVisible(true);		
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}
	
 
    public void imprimiretiquetadirecto(String producto, String barcodes, String preciomenudeo, String preciomayoreo){
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
            String master = "reportes//etiqueta.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo de la etiqueta maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir la etiqueta, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
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
            
            
            
            
            
            
    		
    		
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");	
            java.util.Date date = new java.util.Date();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("codigo_barra", barcodes);
            parametro.put("folio",producto);   
            parametro.put("precioventa", "$"+preciomenudeo);
            parametro.put("preciomayoreo", "P"+preciomayoreo+"M");
            
            //parametro.put("vendedor", accesoSistema.nombreuser);
            parametro.put("vendedor", "");
            parametro.put("fecha", dateFormat.format(date));
            parametro.put("total", "");
            parametro.put("empresa", "Bali   Tel: 100-12-12");
            //parametro.put("empresa", "");
                     
            

            
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //Para mandar a imprimir
            JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Etiqueta");
            //jviewer.setVisible(true);		
        }
        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}
    
    
    public void imprimirfactura(String factura,String fechaemision,String fechacertificacion,String importeletra,String subtotal,String descuento,String iva,String total, String foliofiscal, String seriecertificadosat, String sellodigitalemisor, String sellosat, String cadenacomplemento, String cliente, String metodopago, String rfcreceptor, String callereceptor, String cpreceptor, String ciudadreceptor, String coloniareceptor, String estadoreceptor, double confiva,String ieps,String usocfdi){
               System.out.println(sellodigitalemisor);
               System.out.println(sellosat);
               System.out.println(cadenacomplemento);
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
            String master = "reportes//factura_template.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
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
            
            
            
            
            String razonsocial="",rfc="",lugaremision="",seriecertificadoemisor="",regimenfiscal="";//datos emisor
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
                    regimenfiscal=rs.getString("RegimenFiscal");
                }
                rs.close();
                pstm.close();
                conn2.desconectar();

            } catch (SQLException ex) {
               
            }
            
            regimenfiscal=obtendescripcionregimenfiscal(regimenfiscal); 
            metodopago=obtendescripcionmetodopago(metodopago);
            parametro.put("regimenfiscal",regimenfiscal);   
            parametro.put("factura",factura);   
            
            //parametro.put("vendedor", accesoSistema.nombreuser);
            //parametro.put("fechacertificacion", dateFormat.format(fechacertificacion));
            
            parametro.put("razonsocial",razonsocial);
            parametro.put("rfc", rfc);
            parametro.put("lugaremision", lugaremision);
            
            parametro.put("fechaemision", fechaemision);
            parametro.put("fechacertificacion", fechacertificacion);
            
            
            parametro.put("cliente", cliente);
            parametro.put("callereceptor", callereceptor);
            parametro.put("metodopago", metodopago);
            parametro.put("cpreceptor", cpreceptor);
            parametro.put("ciudadreceptor", ciudadreceptor);
            parametro.put("coloniareceptor", coloniareceptor);
            parametro.put("rfcreceptor", rfcreceptor);
            parametro.put("estadoreceptor", estadoreceptor);
            
            parametro.put("importeletra", importeletra);
            parametro.put("subtotal", subtotal);
            parametro.put("descuento", descuento);
            parametro.put("iva", iva);
            parametro.put("ieps", ieps);
            
            
/*
I01-Construcciones
I02-Mobilario y equipo de oficina por inversiones
I03-Equipo de transporte
I05-Dados, troqueles, moldes, matrices y herramental
I06-Comunicaciones telefónicas
I07-Comunicaciones satelitales
I08-Otra maquinaria y equipo
D03-Gastos funerales.
D04-Donativos.
D05-Intereses reales efectivamente pagados por creditos hipotecarios (casa habitacion).
D06-Aportaciones voluntarias al SAR.
D07-Primas por seguros de gastos médicos.
D08-Gastos de transportación escolar obligatoria.
D09-Depositos en cuentas para el ahorro, primas que tengan como base planes de pensiones.
D10-Pagos por servicios educativos (colegiaturas)*/

        
            if(usocfdi.equals("G01")){
                usocfdi = usocfdi + "-Adquisición de mercancias";
            }
            if (usocfdi.equals("G02")) {
                usocfdi = usocfdi + "-Devoluciones, descuentos o bonificaciones";
            }
            if (usocfdi.equals("G03")) {
                usocfdi = usocfdi + "-Gastos en general";
            }
            if (usocfdi.equals("G03")) {
                usocfdi = usocfdi + "-Gastos en general";
            }
            if (usocfdi.equals("I04")) {
                usocfdi = usocfdi + "-Equipo de computo y accesorios";
            }
            if (usocfdi.equals("P01")) {
                usocfdi = usocfdi + "-Por definir";
            }
            if (usocfdi.equals("D01")) {
                usocfdi = usocfdi + "-Honorarios médicos, dentales y gastos hospitalarios";
            }
            if (usocfdi.equals("D02")) {
                usocfdi = usocfdi + "-Gastos médicos por incapacidad o discapacidad";
            }
            
            parametro.put("usocfdi", "Uso CFDI: "+usocfdi);
            parametro.put("total", total);
            
            
            String rutaimagen=new File ("").getAbsolutePath ()+"\\imagenes_configurables\\";
            String rutacodbar=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".png";
            parametro.put("seriecertificadoemisor", seriecertificadoemisor); 
            parametro.put("foliofiscal", foliofiscal);
            parametro.put("seriecertificadosat", seriecertificadosat);  
            parametro.put("sellodigitalemisor", sellodigitalemisor);
            parametro.put("sellosat", sellosat); 
            parametro.put("cadenacomplemento", cadenacomplemento);             
            parametro.put("rutaimagen", rutaimagen); 
            parametro.put("rutacodbar", rutacodbar); 
            System.out.println("#####IVA PARAM:   "+confiva+"####");
            parametro.put("paramiva", confiva+"");
            

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            //JasperPrintManager.printReport(jasperPrint, false);
            
            JRExporter exporter = new JRPdfExporter();  // para exportar el archivo a pdf 
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            String rutafactura=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".pdf";//obtiene el path del folder                     
             System.out.println("rutafactura: "+rutafactura);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(rutafactura));  //poner la direccion donde se guardara el archivo
            exporter.exportReport();

            
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Ticket");
            //jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
	
        
        
        
        
        
        
        public void imprimirfacturaPublicoGral(String factura,String fechaemision,String fechacertificacion,String importeletra,String subtotal,String descuento,String iva,String total, String foliofiscal, String seriecertificadosat, String sellodigitalemisor, String sellosat, String cadenacomplemento, String cliente, String metodopago, String rfcreceptor, String callereceptor, String cpreceptor, String ciudadreceptor, String coloniareceptor, String estadoreceptor){
               System.out.println(sellodigitalemisor);
               System.out.println(sellosat);
               System.out.println(cadenacomplemento);
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
            String master = "reportes//factura_templateMasivo.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
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
            
            
            
            
            String razonsocial="",rfc="",lugaremision="",seriecertificadoemisor="",regimenfiscal="";//datos emisor
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
                    regimenfiscal=rs.getString("RegimenFiscal");
                    
                }
                rs.close();
                pstm.close();
                conn2.desconectar();

            } catch (SQLException ex) {
               
            }
            
            String foliosagregados="Folios: ";
            try {
               conex conn2;
                conn2 = new conex();
                PreparedStatement pstm;
                pstm = (PreparedStatement) conn2.getConnection().prepareStatement("SELECT no_folio from to_folios where Nofactura='"+factura+"'");
                ResultSet rs=pstm.executeQuery();
                while(rs.next()){                    
                    foliosagregados=foliosagregados+","+rs.getString("no_folio");                    
                }
                rs.close();
                pstm.close();
                conn2.desconectar();

            } catch (SQLException ex) {
               
            }
            
            System.out.println("####FACTURA: "+factura);
            regimenfiscal=obtendescripcionregimenfiscal(regimenfiscal); 
            metodopago=obtendescripcionmetodopago(metodopago);
            parametro.put("regimenfiscal",regimenfiscal); 
            parametro.put("factura",factura);   
            
            //parametro.put("vendedor", accesoSistema.nombreuser);
            //parametro.put("fechacertificacion", dateFormat.format(fechacertificacion));
            
            parametro.put("razonsocial",razonsocial);
            parametro.put("rfc", rfc);
            parametro.put("lugaremision", lugaremision);
            
            parametro.put("fechaemision", fechaemision);
            parametro.put("fechacertificacion", fechacertificacion);
            
            
            parametro.put("cliente", cliente);
            parametro.put("callereceptor", callereceptor);
            parametro.put("metodopago", metodopago);
            parametro.put("cpreceptor", cpreceptor);
            parametro.put("ciudadreceptor", ciudadreceptor);
            parametro.put("coloniareceptor", coloniareceptor);
            parametro.put("rfcreceptor", rfcreceptor);
            parametro.put("estadoreceptor", estadoreceptor);
            
            parametro.put("importeletra", importeletra);
            parametro.put("subtotal", subtotal);
            parametro.put("descuento", descuento);
            parametro.put("iva", iva);
            parametro.put("total", total);
            
            String rutaimagen=new File ("").getAbsolutePath ()+"\\imagenes_configurables\\";
            String rutacodbar=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".png";
            parametro.put("seriecertificadoemisor", seriecertificadoemisor); 
            parametro.put("foliofiscal", foliofiscal);
            parametro.put("seriecertificadosat", seriecertificadosat);  
            parametro.put("sellodigitalemisor", sellodigitalemisor);
            parametro.put("sellosat", sellosat); 
            parametro.put("cadenacomplemento", cadenacomplemento); 
            //C:\\Users\\JOSE\\Documents\\Netbeans 8.1\\PuntoVentaGlobos\\imagenes_configurables\\         
            parametro.put("rutaimagen", rutaimagen); 
            parametro.put("rutacodbar", rutacodbar); 
            parametro.put("foliosagregados", foliosagregados); 
            

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            //JasperPrintManager.printReport(jasperPrint, false);
            
            JRExporter exporter = new JRPdfExporter();  // para exportar el archivo a pdf 
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            String rutafactura=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".pdf";//obtiene el path del folder                     
             System.out.println("rutafactura: "+rutafactura);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(rutafactura));  //poner la direccion donde se guardara el archivo
            exporter.exportReport();       
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            //JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            //jviewer.setTitle("Ticket");
            //jviewer.setVisible(true);		
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
	
}
        
    
public String obtendescripcionregimenfiscal(String clave){
String descripcion="";
try {
        conex conn2;
        conn2 = new conex();
        PreparedStatement pstm;
        pstm = (PreparedStatement) conn2.getConnection().prepareStatement("SELECT descripcion from tc_regimenfiscal where clave='"+clave+"'");
        ResultSet rs=pstm.executeQuery();
        while(rs.next()){   
            descripcion=rs.getString("descripcion");
        }
        rs.close();
        pstm.close();
        conn2.desconectar();

} catch (SQLException ex) {
               
}

return descripcion;
}    

public String obtendescripcionmetodopago(String clave){
String desc="";
if(clave.equals("01")){
    desc=clave+"-Efectivo";
}
if(clave.equals("02")){
    desc=clave+"-Cheque Nominativo";
}
if(clave.equals("03")){
    desc=clave+"-Transferencia electonica de fondos";
}
if(clave.equals("04")){
    desc=clave+"-Tarjeta de credito";
}
if(clave.equals("05")){
    desc=clave+"-Monedero electronico";
}
if(clave.equals("06")){
    desc=clave+"-Dinero Electronico";
}
if(clave.equals("08")){
    desc=clave+"-Vale despensa";
}
if(clave.equals("28")){
    desc=clave+"-Tarjeta debito";
}
if(clave.equals("29")){
    desc=clave+"-Tarjeta de Servicio";
}
if(clave.equals("99")){
    desc=clave+"-Otros";
}
return desc;
}

}
