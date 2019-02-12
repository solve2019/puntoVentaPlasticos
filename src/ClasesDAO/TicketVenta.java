package ClasesDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ClasesDAO.*;
import Utilerias.funciones;
import conexion.conex;
import conexion.conexremoto;
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
public class TicketVenta {
    
    
    public void imprimirticket(String folio, String tipoImpresora){
        System.out.println("imprimiendo: "+tipoImpresora);
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
		
 	int cantprod=0;	
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
                
                sql22="SELECT count(idventa) as total from to_ventas where folio='"+folio+"'";	
                pstm122 = (PreparedStatement) cn22.getConnection().prepareStatement(sql22);
		rs22 = (ResultSet) pstm122.executeQuery();
                if(rs22.next()) {	    	
	    	cantprod=rs22.getInt("total");	    		    			   
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
                    if(cantprod<=10){
                        master = "reportes//ticket80mm.jasper";                    
                    }
                    if(cantprod>10 && cantprod<=19){
                        master = "reportes//ticket80mm14.jasper";
                    }
                    if(cantprod>19){
                        master = "reportes//ticket80mm20.jasper";
                    }
                    
                }else{
                    master = "reportes//ticket80logo.jasper";
                }
            }else{//TAMAÑO DE 58MM
                if(ticketlogo.equals("SI")){
                    if(cantprod<=5){
                        master = "reportes//ticket_logo.jasper";                      
                    }
                    if(cantprod>5 && cantprod<=12){
                        master = "reportes//ticket_logo7.jasper";
                    }
                    if(cantprod>12){
                        master = "reportes//ticket_logo15.jasper";
                    }                    
                }else{                    
                    if(cantprod<=5){
                        master = "reportes//ticket.jasper";                      
                    }
                    if(cantprod>5 && cantprod<=12){
                        master = "reportes//ticket7.jasper";
                    }
                    if(cantprod>12 && cantprod<=18){
                        master = "reportes//ticket15.jasper";
                    }
                    if(cantprod>18 && cantprod<=24){
                        master = "reportes//ticket24.jasper";
                    }
                    if(cantprod>24){
                        master = "reportes//ticket30.jasper";
                    }
                }
            }
            
            
            System.out.println("archivo master: " + master);
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
	
        String user="",fecha="",monto="",cambio="",iva="",grantotal="",descuento="", mesa="", pagocon="";
        String membresia="",cliente="";
        String nombreclientesistema="";
        sql="SELECT usuario_registro,fecha_movimiento,monto_total, (efectivo+tarjeta+no_puntos) as pagocon, ((efectivo+tarjeta+no_puntos)-(monto_total+iva)) as cambio,iva,(monto_total+iva) as total, descuento,mesa,membresia,cliente from to_folios where no_folio='"+folio+"'";
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
                mesa=rs100.getString("mesa");
                pagocon=rs100.getString("pagocon");
                membresia=rs100.getString("membresia");
                cliente=rs100.getString("cliente");
            }
            if(mesa==null){
            mesa="";
            }
                        
            sql="select nombre_completo from tc_clientes where idcliente='"+cliente+"'";
            System.out.println(""+sql);
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	nombreclientesistema=rs100.getString("nombre_completo");
            } 
            
            
            sql="select * from rest_mesas where IdMesa='"+mesa+"'";
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	mesa=rs100.getString("Nombre");
            } 
            if(mesa==null){
            mesa="";
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
            String imagen=new File ("").getAbsolutePath ()+"\\imagenes_configurables\\";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");            
            
            parametro.put("folio",folio);               
            parametro.put("encabezado", encabezado);
            parametro.put("footer", footer);
            parametro.put("user", user);
            parametro.put("fecha", fecha);
            
            Double subt=Double.parseDouble(monto)+Double.parseDouble(descuento);
            parametro.put("subtotal", subt+"");
            parametro.put("descuento", descuento);
            funciones aa=new funciones();
            double suba=Double.parseDouble(grantotal)/1.16;
            suba=aa.redondearDecimales(suba, 2);
            double tot=Double.parseDouble(grantotal);
            
            
            double ivaas=tot-suba;
            ivaas=aa.redondearDecimales(ivaas, 2);
            //parametro.put("subtotal", suba+"");
            //NumberToLetterConverter letra=new NumberToLetterConverter();
            //String montoletra=letra.convertNumberToLetter(grantotal);
            //parametro.put("montoletra", montoletra+"");
            
            parametro.put("iva", ivaas+"");
            parametro.put("total", grantotal);
            parametro.put("cambio",cambio );
            parametro.put("pagocon",pagocon );
            parametro.put("ruta_imagen",imagen );
                          System.out.println("antes de membresia");  
            if(membresia==null){
            membresia="";
            }              
            if(membresia.equals("")){
            }else{
                String nombrecliente=obtennombrecliente(membresia);
                membresia=""+membresia+"  "+nombrecliente;
                System.out.println(""+membresia);
                parametro.put("mesa", membresia);
            }
                      
            if(mesa.equals("")){
            }else{
                mesa="Mesa: "+mesa;
                parametro.put("mesa",mesa );     
            }
            
            if(membresia.equals("") && mesa.equals("")){
                 mesa="";
                 if(nombreclientesistema.equals("")){
                     parametro.put("mesa",mesa );     
                 }else{
                     parametro.put("mesa",mesa+" Cliente: "+nombreclientesistema );     
                 }
                 
            }
            
            System.out.println("antes de jasperpritnt");  
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
            //System.out.println(""+impresoraconfig);
            if(impresoraconfig.equals("") || impresoraconfig.equals("Por Defecto")){ //sin impresora
                //Para mandar a imprimir
                JasperPrintManager.printReport(jasperPrint, false);
            }else{
                    PrinterJob job = PrinterJob.getPrinterJob();
                    PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
                    int selectedService = 0;
                    for(int i = 0; i < services.length;i++){
                        //if(services[i].getName().toUpperCase().contains("PDFCreator")){
                        //System.out.println(""+services[i].getName());
                        if(services[i].getName().contains(impresoraconfig)){
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
            //jviewer.setTitle("Ticket venta");
            //jviewer.setVisible(true);		
        }
        catch (Exception j)
        {
            JOptionPane.showMessageDialog(null, "Error al generar el pdf: "+j.getMessage(), "Alerta", JOptionPane.ERROR_MESSAGE);                
            //System.out.println("Mensaje de Error:"+j.getMessage());
        }
	}
	
    
    
    
    public void ImprimirDocumentoCliente(String monto,ArrayList productos){
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
	
    try {
        cn.desconectar();
    } catch (SQLException ex) {        
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
	   a=a+"\n  ============================\n";	   
           //a=a+" Usuario: "+user+"\n";
           a=a+" Fecha:"+dateFormat.format(date)+"\n\n";	   
           
           
           //id    codigobarras   precioventa   cantidad   totalprod  descripcion
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                //System.out.println(datos+" num:"+numerosComoArray.length);
                String precioventa="",cantidad="0",total="0",produ="";
                for (int i = 0; i < numerosComoArray.length; i++) {                    
                    precioventa=numerosComoArray[0];
                    cantidad=numerosComoArray[1];
                    total=numerosComoArray[2];
                    produ=numerosComoArray[3];
                    //System.out.println(numerosComoArray[i]);
                }
                
                if(produ.length()>12){ //si es mayor a 15 lo corta
                    produ=produ.substring(0, 12);
                }
                if(produ.length()<=12){ //si es menor de 15 le agrega espacios vacios
                    for(int i=produ.length();i<=12;i++){
                        produ=produ+" ";
                    }
                }
                cantidad=cantidad.substring(0,(cantidad.length()-3));
                if(cantidad.length()<3){ //3 posiciones de cantidad
                    for(int i=cantidad.length();i<=1;i++){
                        cantidad=cantidad+" ";
                    }
                }
                
                
                precioventa=precioventa.substring(0,(precioventa.length()-1));
                if(precioventa.length()<=5){ //si es menor de 6 le agrega espacios vacios
                    for(int i=precioventa.length();i<=5;i++){
                        precioventa=" "+precioventa;
                    }
                }
                total=total.substring(0,(total.length()-1));
                if(total.length()<=5){ //si es menor de 7 le agrega espacios vacios
                    for(int i=total.length();i<=5;i++){
                        total=" "+total;
                    }
                }
                
                a=a+""+cantidad+" "+produ+" "+precioventa+" "+total+"\n";
           }
           
           String montostr=monto+"";
           if(montostr.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=montostr.length();i<=7;i++){
                        montostr=" "+montostr;
                    }
           }
           a=a+"            Total: "+montostr+"\n\n";
	   		   

	   char esc=27;
	   char b=20;
	   char c=1;
	   char d=226;
	   char e1=0;
	   char f=70;
	   char g=56;
	   char h=29;
	   char i=1;
	   char j=120;
	   char k=0;
	   char l=4;
	   char m=28;

	   
	   
/*	   
char ss=15;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"k"+l+"2345345345"+k;
a=a+esc+m;
//fin codigo barras
*/
           
a=a+"\n  ============================\n"+footer+"\n\n\n";
a=a+as+"V"+ew1+w;//corta el papel

String impresora="";
conex con=new conex();  
try {
    ResultSet rsR = null; 
    Statement st = con.getConnection().createStatement();

    String myQuery = "select parametro from to_parametros where clave='IMPREST'";
    System.out.println(""+myQuery);               
    rsR = st.executeQuery(myQuery);
    while(rsR.next()) {                                                
         impresora=rsR.getString("parametro");
    }                
    rsR.close();
    st.close();
    con.desconectar();                  
} catch (SQLException ex) {       
    JOptionPane.showMessageDialog(null, "Error al obtener datos del parametros: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
}  
        System.out.println("impresora #####:"+impresora);
if(impresora.equals("") || impresora.equals("Por Defecto")){
        System.out.println(a);
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
        PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
        DocPrintJob pj = service.createPrintJob(); 
        byte[]bytes =a.getBytes(); 
        Doc doc = new SimpleDoc(bytes, flavor,null); 
        try{ 
        pj.print(doc,null); 
        }catch(Exception e){
        }

}else{
        AttributeSet aset = new HashAttributeSet();
        aset.add(new PrinterName(impresora, null));

        PrintService[] printService = PrintServiceLookup.lookupPrintServices(null, aset);
        System.out.println(printService.length);
        //PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
        if(printService.length>0){
            DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
            DocPrintJob docPrintJob = printService[0].createPrintJob();
            Doc doc=new SimpleDoc(a.getBytes(),flavor,null);                
            try {
            docPrintJob.print(doc, null);
            }
            catch (PrintException e) {
            System.out.println("Error al imprimir: "+e.getMessage());
             JOptionPane.showMessageDialog(null, "Error al imprimir. "+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }    
}


/*
System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
*/
    
    
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
    public String obtennombrecliente(String membresia){
    String nombre="";
    conexremoto con=new conexremoto();               
               String myQuery = "select nombre from tc_clientes where codigobarras='"+membresia+"'";
               System.out.println(""+myQuery);
               ResultSet rs=null;
               try {
                   Statement st = con.getConnection().createStatement();
                   rs=st.executeQuery(myQuery);                                                        
                   if(rs.next()){
                       nombre=rs.getString("nombre");
                   }
                   st.close();
                   rs.close();
                   con.desconectar();                                                        
               } catch (SQLException ex) {                         
                   //JOptionPane.showMessageDialog(null, "Error al conectar con el servidor para membresias, vuelva a intentar mas tarde "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
    return nombre;
    }
}
