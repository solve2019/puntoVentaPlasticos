package puntoventa;
import conexion.conex;
import java.io.File;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class RemisionPDF {

	
	public void imprimirpdf(String barcodes){
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
            String master = "reportes//remision.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
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
            
            
            
            
            
            
    		
    	
            String folio="", subtotal="",total="",iva="";
            conex con=new conex();  
            try {
                String myQuery = "select no_folio, monto_total, (monto_total*.16) as iva, monto_total+(monto_total*.16) as total from to_folios where codigo_venta='"+barcodes+"'";
                System.out.println(""+myQuery);
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                
                    folio=rsR.getString("no_folio");
                    subtotal=rsR.getString("monto_total");
                    total=rsR.getString("total");
                    iva=rsR.getString("iva");
                }
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {                   
            }  
            
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");								            			           			           		            		           
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", folio);		            
            parametro.put("subtotal", subtotal);		            
            parametro.put("iva", iva);		            
            parametro.put("total", total);		            
            //parametro.put("folio",folio);            
            System.out.println(folio+" "+subtotal+" "+iva+" "+total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Remision");
            jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

        
        
	public void imprimircotizacion(String idcoti){
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
            String master = "reportes//cotizacion.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo imprimir la cotizacion."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
            
            
            
            
    	    double ivas=obteniva();
    	
            String folio="", subtotal="",total="",iva="";
            conex con=new conex();  
            try {
                
                String myQuery = "select monto_total, (monto_total*"+ivas+") as iva, monto_total+(monto_total*"+ivas+") as total from to_cotizacion where id_cotizacion='"+idcoti+"'";
                System.out.println(""+myQuery);
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                                    
                    subtotal=rsR.getString("monto_total");
                    total=rsR.getString("total");
                    iva=rsR.getString("iva");
                }
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {                   
            }  
            
            String datosempresa=datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");								            			           			           		            		           
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);	
            
            parametro.put("datosempresa", datosempresa);		            
            parametro.put("subtotal", subtotal);		            
            parametro.put("iva", iva);		            
            parametro.put("total", total);		            
            //parametro.put("folio",folio);            
            System.out.println(folio+" "+subtotal+" "+iva+" "+total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Cotizacion");
            jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
        
        
        
        
        
        
        
        public void imprimirPDFCompra(String idcoti){
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
            String master = "reportes//compras.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo imprimir el ticket, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo imprimir la cotizacion."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
            
            
            
            
    	    double ivas=obteniva();
    	
            String folio="", subtotal="",total="",iva="",fecha="",proveedor="",domicilio="",idprov="";
            conex con=new conex();  
            try {
                
                String myQuery = "select monto_compra, (monto_compra*"+ivas+") as iva, monto_compra+(monto_compra*"+ivas+") as total, fecha_registro, IdProveedor from proveedor_to_compra where FolioCompra='"+idcoti+"'";
                System.out.println(""+myQuery);
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                                    
                    subtotal=rsR.getString("monto_compra");
                    total=rsR.getString("total");
                    iva=rsR.getString("iva");
                    fecha=rsR.getString("fecha_registro");
                    idprov=rsR.getString("IdProveedor");
                }
                                
                myQuery="SELECT * from proveedor_tc where IdProveedor='"+idprov+"'";
                System.out.println(""+myQuery);
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                                    
                    proveedor=rsR.getString("nombreProveedor");
                    domicilio=rsR.getString("direccion")+" "+rsR.getString("colonia")+" C.P. "+rsR.getString("cp")+" "+rsR.getString("estado");                  
                }
                
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {                   
            }  
            String imagen=new File (".").getAbsolutePath ()+"\\imagenes_configurables\\logo_sistema.jpg";
            String datosempresa=datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");								            			           			           		            		           
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);	
            
            parametro.put("datosempresa", datosempresa);		            
            parametro.put("subtotal", subtotal);		            
            parametro.put("iva", iva);		            
            parametro.put("total", total);		            
            parametro.put("fecha",fecha);            
            parametro.put("fecha",fecha);            
            parametro.put("proveedor",proveedor);            
            parametro.put("domicilio",domicilio);            
            parametro.put("imagen",imagen);            
            System.out.println(folio+" "+subtotal+" "+iva+" "+total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Compras");
            jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
public void imprimirpdfpension(String barcodes,String pension){
		
		
		
		
		
	    
	    
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
                System.out.println("No encuentro el archivo del reporte maestro.");
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
            
            
            
            String footer="",encabezado="";
        	
            
            
            String tiempo_mu="0", hora_fin=null,diahoramin="";	
			 String tipo_auto="";
			 float lavado=0;
			 int tiempo=0;
            
            
            conex cn = new conex();		            
    		String sql="SELECT sum(TIMESTAMPDIFF(second,fecha_entrada,fecha_salida)) as tiempo, codigo_barras,folio,fecha_entrada,placas,marca,modelo,id_usuario,fecha_salida,monto,costo_lavado from entradas where codigo_barras='"+barcodes+"' GROUP BY fecha_entrada";			    		
    		ResultSet rs100 = null;
    		PreparedStatement pstm100;	
    		String codigobar="",ficha="",hora_entrada="",conductor="",placa_tracto="",noeconomico="",placa_remolque="";
    		String empresa="",tipo="",categoria="",usuario="",hora_salida="",monto="",dias="",costo_lavado="";		            
    		try {
    			pstm100 = cn.getConnection().prepareStatement(sql);
    			rs100 = (ResultSet) pstm100.executeQuery();
    		    while (rs100.next()) {	 
    		    	tiempo_mu=rs100.getString(1);
    		    	codigobar=rs100.getString("codigo_barras");	
    		    	ficha=rs100.getString("folio");	
    		    	hora_entrada=rs100.getString("fecha_entrada");	    		    
    		    	placa_tracto=rs100.getString("placas");	
    		    	noeconomico=rs100.getString("marca");	
    		    	placa_remolque=rs100.getString("modelo");	
    		    	costo_lavado=rs100.getString("costo_lavado");	
		    		usuario=rs100.getString("id_usuario");	
		    		hora_salida=rs100.getString("fecha_salida");	
		    		monto=rs100.getString("monto");		
    			}	
    		    sql="SELECT parametro from parametros where clave='FOOTER'";
    		    pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
        		rs100 = (ResultSet) pstm100.executeQuery();
        	    while (rs100.next()) {
        	    	
        	    	footer=rs100.getString("parametro");	    		    			   
        		}
        	    sql="SELECT parametro from parametros where clave='ENCABEZADO'";
    		    pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
        		rs100 = (ResultSet) pstm100.executeQuery();
        	    while (rs100.next()) {
        	    	
        	    	encabezado=rs100.getString("parametro");	    		    			   
        		}
    		    
    		    
    		} catch (SQLException e2) {
    			// TODO Auto-generated catch block
    			e2.printStackTrace();
    		}
    		rs100.close();
    		cn.desconectar();
    		
            
    		
    		
    		 
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");								            			           			           		            		           
            String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            
            parametro.put("codigo_barra", codigobar);		            
            parametro.put("footer",footer);
            parametro.put("encabezado",encabezado);
            parametro.put("costolavado",costo_lavado);
            
            parametro.put("ficha", ficha);		            
            parametro.put("hora_entrada", hora_entrada);
            parametro.put("conductor", conductor);
            parametro.put("placa_tracto", placa_tracto);
            parametro.put("noeconomico", noeconomico);
            parametro.put("placa_remolque", placa_remolque);
            parametro.put("empresa", empresa);		            
            parametro.put("tipo", tipo);
            parametro.put("categoria", categoria);
            parametro.put("usuario", usuario);
            parametro.put("hora_salida", hora_salida);
            parametro.put("monto", monto);
            parametro.put("dias", diahoramin);
            parametro.put("pension", pension);
            

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            JasperPrintManager.printReport(jasperPrint, false);
            
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
	
	
	
	
	
	
public double obteniva(){
    double iva=0.0;    
    conex cn = new conex();    
    String sql="SELECT parametro from to_parametros where clave='IVA'";
    System.out.println(sql);
    PreparedStatement pstm100;
    try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
        while (rs100.next()) {

            iva=rs100.getDouble("parametro");	    		    			   
            }
        rs100.close();
        pstm100.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }
    iva=iva/100;
    return iva;
    }	

public String datosdeempresa(){
    String encabezado="";    
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
        pstm100.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }    
    return encabezado;
    }	


public void imprimirnota(String idcoti){
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
            String master = "reportes//notacredito.jasper";  //poner la direccion donde se encuentra el archivo .jasper
            
          //  System.out.println("master" + master);
            if (master == null) 
            {                
                System.out.println("No encuentro el archivo del reporte maestro.");
                JOptionPane.showMessageDialog(null,"No se pudo generar la nota, no esta el archivo jasper.","Mensaje",JOptionPane.PLAIN_MESSAGE);  
            } 

            JasperReport masterReport = null;
            try 
            {
                masterReport = (JasperReport) JRLoader.loadObject(master);
            } 
            catch (JRException e1) 
            {
                System.out.println("Error cargando el reporte de cotizacion: " + e1.getMessage());
                JOptionPane.showMessageDialog(null,"No se pudo imprimir la nota."+e1.getMessage(),"Mensaje",JOptionPane.PLAIN_MESSAGE);  
                
            }              
            
            //este es el par�metro, se pueden agregar m�s par�metros
            //basta con poner mas parametro.put
 
            //JOptionPane.showMessageDialog(null,"Se esta generando el reporte.","Mensaje",JOptionPane.PLAIN_MESSAGE);    
            Map<String, String> parametro = new HashMap<String, String>();
            //parametro.put("area",centro); 
            //System.out.println (new File ("").getAbsolutePath ()+"\\reportes\\logo.jpg");
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo.jpg";
            
            
            
            
            
            
    	    double ivas=obteniva();
    	
            String folio="", subtotal="",total="",iva="",ieps="";
            conex con=new conex();  
            try {
                
                String myQuery = "select monto_total_nota, (monto_total_nota*"+ivas+") as iva, monto_total_nota+ieps+(monto_total_nota*"+ivas+") as total,ieps from to_nota_credito where id_nota='"+idcoti+"'";
                System.out.println(""+myQuery);
                ResultSet rsR = null; 
                Statement st = con.getConnection().createStatement();
                rsR = st.executeQuery(myQuery);
                while(rsR.next()) {                                                                    
                    subtotal=rsR.getString("monto_total_nota");
                    total=rsR.getString("total");
                    iva=rsR.getString("iva");
                    ieps=rsR.getString("ieps");
                    
                }
                rsR.close();
                st.close();
                con.desconectar();                  
            } catch (SQLException ex) {                   
            }  
            
            String datosempresa=datosdeempresa();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");								            			           			           		            		           
            //String imagen=new File (".").getAbsolutePath ()+"\\reportes\\logo_reporte.jpg";
            //parametro.put("logo", imagen);		            
            System.out.println("impresion PDF");
            parametro.put("folio", idcoti);	
            
            parametro.put("datosempresa", datosempresa);		            
            parametro.put("subtotal", subtotal);		            
            parametro.put("iva", iva);		            
            parametro.put("ieps", ieps);	
            parametro.put("total", total);		            
            //parametro.put("folio",folio);            
            System.out.println(folio+" "+subtotal+" "+iva+" "+total);

            //Reporte dise�ado y compilado con iReport
            JasperPrint jasperPrint = JasperFillManager.fillReport(masterReport,parametro,conn);
            //jasperPrint.setPageHeight(100);
            //jasperPrint.setPageWidth(80);
            
            //JasperPrintManager.printReport(jasperPrint, false);
            
            //Se lanza el Viewer de Jasper, no termina aplicaci�n al salir
            JasperViewer jviewer = new JasperViewer(jasperPrint,false);
            jviewer.setTitle("Nota de credito");
            jviewer.setVisible(true);
            
			
			
        }

        catch (Exception j)
        {
            System.out.println("Mensaje de Error:"+j.getMessage());
        }
		
		
		
		
		
		
		
		
		
	}
	
}
