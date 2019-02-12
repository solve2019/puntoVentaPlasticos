package ClasesDAO;

import Utilerias.funciones;
import com.mysql.jdbc.PreparedStatement;
import conexion.conex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc; 
import javax.print.DocFlavor; 
import javax.print.DocPrintJob; 
import javax.print.PrintService; 
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc; 
import javax.swing.JOptionPane; 


import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;
import javax.print.PrintException;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.standard.PrinterName;
import puntoventa.Mensaje;


public class Ticket{
	
static ArrayList<String> CabezaLineas=new ArrayList<String>(); 
static ArrayList<String> subCabezaLineas=new ArrayList<String>(); 
static ArrayList<String> items=new ArrayList<String>(); 
static ArrayList<String> totales=new ArrayList<String>(); 
static ArrayList<String> LineasPie=new ArrayList<String>(); 
public static void AddCabecera(String line){CabezaLineas.add(line);} 
public static void AddSubCabecera(String line){subCabezaLineas.add(line);} 
public static void AddItem(String cantidad,String item,String price){  
} 
 
 
public void ImprimirDocumento(String folio,String user,float monto,ArrayList productos,String fecha){
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
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
	   a=a+"\n  ============================\n";
	   a=a+" Folio: "+folio+"\n";
           a=a+" Usuario: "+user+"\n";
           a=a+" Fecha:"+fecha+"\n\n";
	   //a=a+" Productos: \n";
           
           
           //id    codigobarras   precioventa   cantidad   totalprod  descripcion
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                //System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",produ="";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    produ=numerosComoArray[5];
                    //System.out.println(numerosComoArray[i]);
                }  
                if(cantidad.length()<3){ //3 posiciones de cantidad
                    for(int i=cantidad.length();i<=2;i++){
                        cantidad=cantidad+" ";
                    }
                }
                
                if(produ.length()>9){ //si es mayor a 15 lo corta
                    produ=produ.substring(0, 9);
                }
                if(produ.length()<=9){ //si es menor de 15 le agrega espacios vacios
                    for(int i=produ.length();i<=9;i++){
                        produ=produ+" ";
                    }
                }
                
                if(precio.length()<=6){ //si es menor de 6 le agrega espacios vacios
                    for(int i=precio.length();i<=6;i++){
                        precio=" "+precio;
                    }
                }
                
                if(total.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=total.length();i<=7;i++){
                        total=" "+total;
                    }
                }
                
                a=a+""+cantidad+" "+produ+" "+precio+" "+total+"\n";
           }
           
           String montostr=monto+"";
           if(montostr.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=montostr.length();i<=7;i++){
                        montostr=" "+montostr;
                    }
           }
           a=a+"                     Total: "+montostr+"\n\n";
	   		   
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n  ============================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel

System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
} 



public void ReImprimirDocumento(String folio){
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
        //id    codigobarras   precioventa   cantidad   totalprod  descripcion
        ArrayList productos=new ArrayList();
        sql="SELECT to_ventas.idproducto,precio,cantidad,total,nombre_producto from to_ventas,tc_productos where tc_productos.idproducto=to_ventas.idproducto and folio='"+folio+"'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
                productos.add(rs100.getString("idproducto")+"@"+" "+"@"+rs100.getString("precio")+"@"+rs100.getString("cantidad")+"@"+rs100.getString("total")+"@"+rs100.getString("nombre_producto"));               
	    	
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        
        
    try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));
char esc2=10;
String a=esc2+""+encabezado;	   
	   a=a+"\n ===============================\n";
	   a=a+" Folio: "+folio+"\n";
           a=a+" Usuario: "+user+"\n";
           a=a+" Fecha:"+fecha+"\n\n";
	   //a=a+" Productos: \n";
           
           
           //id    codigobarras   precioventa   cantidad   totalprod  descripcion
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                //System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",produ="";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    produ=numerosComoArray[5];
                    //System.out.println(numerosComoArray[i]);
                }  
                if(cantidad.length()<3){ //3 posiciones de cantidad
                    for(int i=cantidad.length();i<=2;i++){
                        cantidad=cantidad+" ";
                    }
                }
                
                if(produ.length()>9){ //si es mayor a 15 lo corta
                    produ=produ.substring(0, 9);
                }
                if(produ.length()<=9){ //si es menor de 15 le agrega espacios vacios
                    for(int i=produ.length();i<=9;i++){
                        produ=produ+" ";
                    }
                }
                
                if(precio.length()<=6){ //si es menor de 6 le agrega espacios vacios
                    for(int i=precio.length();i<=6;i++){
                        precio=" "+precio;
                    }
                }
                
                if(total.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=total.length();i<=7;i++){
                        total=" "+total;
                    }
                }
                
                a=a+""+cantidad+" "+produ+" "+precio+" "+total+"\n";
           }
           
           String montostr=monto+"";
           System.out.println("MONTO: "+montostr);
           /*if(montostr.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=montostr.length();i<=7;i++){
                        montostr=" "+montostr;
                    }
           }*/
           double mont=Double.parseDouble(montostr)+Double.parseDouble(descuento);
           a=a+"\n           Sub Total: $"+mont+"\n";
           a=a+"           Descuento: $"+descuento+"\n";
           
           //a=a+"                 Iva: "+iva+"\n";
           a=a+"               Total: $"+grantotal+"\n\n";
           a=a+"              Cambio: $"+cambio+"\n";
	   		   
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n ===============================\n"+footer+"\n";
//a=a+as+"V"+ew1+w;//corta el papel
//a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11


System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}



public void ReimprimirDocumentoNotomar(String codebar, String placa, String marca, String modelo, String fecha,String folio, String usuario_general,String tipo,String costo){
	
	
	String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from parametros where clave='ENCABEZADO'";
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
	
	sql="SELECT parametro from parametros where clave='FOOTER'";
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
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;



String a=encabezado;
	   //a=a+"         ESTACIONAMIENTO CUERNAVACA\n";
	   //a=a+"     EXPEDIDO EN: CUERNAVACA MORELOS\n";
	   //a=a+"     AV. CIVAC NO. 18 COL. BUGMBILIAS\n";
	   //a=a+"      	  RFC: CSI-020226-MV4\n";
	   a=a+"\n  ============================\n";
	   a=a+"FOLIO: "+folio+"  PLACA: "+placa+" \n";
	   a=a+"MARCA: "+marca+"  MODELO: "+modelo+" \n";
	   a=a+"USUARIO: "+usuario_general+"\n";
	   if(tipo.equals("")){		  
	   }else{
		   a=a+"   Lavado de Auto: Si  Costo: $"+costo+"\n";
	   }
	   a=a+"  FECHA:"+fecha+"\n\n";
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

	   
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

	   
	   
	   
char ss=15;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras

a=a+"\n  ============================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel

System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}


public void imprimirComprobante(String ticket){
	
	
	String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from parametros where clave='ENCABEZADO'";
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
	
	sql="SELECT parametro from parametros where clave='FOOTER'";
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
	String monto="",folio="", placa="",marca="",modelo="";
	String fechaini="",fechafin="",tiempo_estancia="";
	sql="SELECT * from entradas where codigo_barras='"+ticket+"'";
	System.out.println(sql);
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
	    	
	    	monto=rs100.getString("monto");	  
	    	folio=rs100.getString("folio");	 
	    	placa=rs100.getString("placas");	 
	    	marca=rs100.getString("marca");	 
	    	modelo=rs100.getString("modelo");	
	    	fechaini=rs100.getString("fecha_entrada");	
	    	fechafin=rs100.getString("fecha_salida");
	    	tiempo_estancia=rs100.getString("tiempo_estancia");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	
    try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;


Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;
	   //a=a+"         ESTACIONAMIENTO CUERNAVACA\n";
	   //a=a+"     EXPEDIDO EN: CUERNAVACA MORELOS\n";
	   //a=a+"     AV. CIVAC NO. 18 COL. BUGMBILIAS\n";
	   //a=a+"      	  RFC: CSI-020226-MV4\n";
	   a=a+"\n  ============================\n";
	   a=a+"COMPROBANTE DE PAGO \n";
	   a=a+"MONTO: $"+monto+" \n";
	   a=a+"FOLIO: "+folio+"  PLACA: "+placa+" \n";
	   a=a+"MARCA: "+marca+"  MODELO: "+modelo+" \n";	 
	   a=a+"E: "+fechaini+"\n";
	   a=a+"S: "+fechafin+"\n\n";
	   a=a+"      "+tiempo_estancia+"\n";
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

	   
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
a=a+h+"k"+l+""+k;
a=a+esc+m;
//fin codigo barras
*/
a=a+"\n  ============================\n"+footer+"\n\n\n";
//a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11
System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}










public String ImprimirCorteCaja(String efectivo, String tarjeta, String efectivoinicial,String devoluciones, String entradas, String salidas, String total, String numerotickets,String credito,String compras){
Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));
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
        


String a=encabezado+"\n";	   
	   a=a+"\n ===================================\n";	   
           a=a+"           CORTE DE CAJA \n";
           a=a+" Usuario: "+accesoSistema.nombreuser+"\n";
           a=a+" Fecha: "+dateFormat.format(date)+"\n";
	   a=a+" Numero de Ventas: "+numerotickets+"\n\n";
           a=a+" Efectivo:             $"+efectivo+" \n";
           a=a+" Tarjeta:              $"+tarjeta+" \n";           
           a=a+" Devoluciones:         $"+devoluciones+" \n";
           a=a+" Entradas:             $"+entradas+" \n";
           a=a+" Compras:              $"+compras+" \n";
           a=a+" Salidas:              $"+salidas+" \n\n";
           a=a+" Total:                $"+total+" \n\n";
           a=a+" Efectivo Inicial:     $"+efectivoinicial+" \n\n\n";
           
           Date fecha = new Date();
           SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd");
           String fech=format.format(fecha);
           
           a=a+" ========ENTRADAS A CREDITO========== \n";
           a=a+" Cobro por credito        $"+credito+"\n";
           
           a=a+"\n =======ENTRADAS DE EFECTIVO========= \n";
           
                  
           String myQuery = "select HOUR(fecha) as fecha, minute(fecha) as minu, monto,motivo from th_entradasefectivo where movimiento='ENTRADA' and fecha>='"+fech+" 00:00:00' and fecha<='"+fech+" 23:59:59'";
           //System.out.println(""+myQuery);
           try {
               conex con=new conex();   
               ResultSet rsR = null; 
               Statement st = con.getConnection().createStatement();
               rsR = st.executeQuery(myQuery);
               while(rsR.next()) {
                   a=a+" "+rsR.getString("motivo")+"\n";
                   a=a+" Hrs: "+rsR.getString("fecha")+":"+rsR.getString("minu")+"             $"+rsR.getString("monto")+"\n";
                   
               }                             
               rsR.close(); 
               st.close();
               con.desconectar();
           } catch (SQLException ex) {                      
           }   
           
           
           
           a=a+"\n =======SALIDAS DE EFECTIVO========== \n";

           
               
           myQuery = "select HOUR(fecha) as fecha, minute(fecha) as minu, monto,motivo from th_entradasefectivo where movimiento='SALIDA' and fecha>='"+fech+" 00:00:00' and fecha<='"+fech+" 23:59:59'";
           //System.out.println(""+myQuery);
           try {
               conex con=new conex();   
               ResultSet rsR = null; 
               Statement st = con.getConnection().createStatement();
               rsR = st.executeQuery(myQuery);
               while(rsR.next()) {
                   a=a+" "+rsR.getString("motivo")+"\n";
                   a=a+" Hrs: "+rsR.getString("fecha")+":"+rsR.getString("minu")+"             $"+rsR.getString("monto")+"\n";
                   
               }                             
               rsR.close(); 
               st.close();
               con.desconectar();
           } catch (SQLException ex) {                      
           }   
           
           
           
           
           
           a=a+"\n ===================================\n\n";

           a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11
           
System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 



return a;


}




public void Imprimirresumenventa(String total, String numventas, String promedio, String fechaini, String fechafin,String efectivo, String tarjetas,String entradas,String salidas,String creditos){
Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a="";	   
	   a=a+"\n ===============================\n";	   
           a=a+"        REPORTE DE VENTAS \n";
           a=a+" Del: "+fechaini+" \n";
           a=a+" Al: "+fechafin+" \n";
           a=a+" Usuario: "+accesoSistema.nombreuser+"\n\n";           	   
           a=a+" No. Ventas: "+numventas+" \n";
           a=a+"   Promedio: "+promedio+" \n\n";           
           a=a+"   Efectivo:   + "+efectivo+" \n";           
           a=a+"   Tarjetas:   + "+tarjetas+" \n";           
           a=a+"   Entradas:   + "+entradas+" \n";                                
           a=a+"   Creditos:   + "+creditos+" \n";                      
           a=a+"    Salidas:   - "+salidas+" \n\n"; 
           a=a+"      Total:     "+total+" \n";
           
           
           
           
           
a=a+"\n ===============================\n\n\n\n";


System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}








public void imprimirabono(String idabono){
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
	
        String user="",fecha="",monto="", cliente="",idcliente="0",formapago="";
        sql="SELECT UsuarioMovimiento,Fecha,Monto,nombre_completo,IdrCliente,th_abonos_cliente.FormaPago from th_abonos_cliente,tc_clientes where idcliente=IdrCliente and IdAbono="+idabono;
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	user=rs100.getString("UsuarioMovimiento");
                fecha=rs100.getString("Fecha");
                monto=rs100.getString("Monto"); 
                cliente=rs100.getString("nombre_completo"); 
                idcliente=rs100.getString("IdrCliente"); 
                formapago=rs100.getString("FormaPago"); 
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}                        
    try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	double montodeuda=0,montopagado=0,diferencia=0;                   
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select (monto_total+iva) as monto_total from to_folios, th_cliente_credito where estatus=1 and tipo_movimiento='VENTA' and idrfolio=no_folio and idrcliente="+idcliente;
               System.out.println(""+myQuery);
               try {
                   Statement st = con.getConnection().createStatement();
                   //rsR = st.executeQuery(myQuery);
                   //while(rsR.next()) {                                                
                   //         double montototal=Math.rint((rsR.getDouble("monto_total")*1000)/1000);//redondea los numeros    
                   //}            
                   myQuery="select sum(monto_total+iva) as deuda from to_folios, th_cliente_credito where estatus=1 and tipo_movimiento='VENTA' and idrfolio=no_folio and idrcliente="+idcliente;
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {                                 
                           montodeuda=rsR.getDouble("deuda");
                   }
                   myQuery="select sum(Monto) as pagado from th_abonos_cliente where idrCliente="+idcliente;
                   rsR = st.executeQuery(myQuery);
                   while(rsR.next()) {          
                       montopagado=rsR.getDouble("pagado");
                   }
                   diferencia=montodeuda-montopagado;
                   diferencia=Math.rint((diferencia*1000)/1000);//redondea los numeros                   
                   rsR.close(); 
                   st.close();
                   con.desconectar();
               } catch (SQLException ex) {       
                  
                   JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
               }     
    
    
    
    
	
char as=29;  //gs
char ew1=66;
char w=80;

String a=encabezado;	   
	   a=a+"\n ==================================\n";	   
           a=a+"          ABONO DE CREDITO   \n";
           a=a+" Usuario Recibio: "+user+"\n";
           a=a+" Fecha: "+fecha+"\n";
           a=a+" Cliente: "+cliente+"\n";	   
           String montostr=monto+"";                      
           
           a=a+"\n    Forma de Pago: "+formapago+"";                      
           a=a+"\n             Pago: $"+montostr+"";                      
           a=a+"\n            Resta: $"+diferencia+"\n";                      
	   		   
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n =================================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11


System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 
}




public String ImprimirEntradaEfectivo(String identrada,String tipomov){
    String motivo="",efectivo="",fecha="",usuario="";
           String myQuery = "select  fecha, monto,motivo,usuario from th_entradasefectivo where Id='"+identrada+"'";           
           System.out.println(""+myQuery);
           try {
               conex con=new conex();   
               ResultSet rsR = null; 
               Statement st = con.getConnection().createStatement();
               rsR = st.executeQuery(myQuery);
               while(rsR.next()) {
                   motivo=rsR.getString("motivo");
                   efectivo=rsR.getString("monto");
                   usuario=rsR.getString("usuario");
                   fecha=""+rsR.getString("fecha");                   
               }                             
               rsR.close(); 
               st.close();
               con.desconectar();
           } catch (SQLException ex) {                      
           }
    
    
           String a="";	   
	   a=a+"\n ===================================\n";	   
           a=a+"    "+tipomov+" \n\n";
           a=a+" Usuario: "+usuario+"\n";
           a=a+" Fecha: "+fecha+"\n";	   
           a=a+" Efectivo: $"+efectivo+" \n";           
           a=a+" Motivo: "+motivo+" \n\n";          
                      
           
                  
              
           
           
           
           a=a+"===================================\n\n";
           a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11
           
System.out.println(a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 



return a;


}



public void ImprimirVentaFactura(String codigobarras,String tipoventa,float costotarjeta,String factura,String correo,String cliente,String idcliente,String tipopagos,String enviarcorreo,String no_folio){
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
	
        String user="",fecha="",monto="",folio="",forma_pago="", ieps="";
        String tipoventa10="";
        sql="SELECT * from to_folios where no_folio='"+no_folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    
                folio=rs100.getString("no_folio");
	    	user=rs100.getString("usuario_venta");
                fecha=rs100.getString("fecha_registro_venta");
                monto=rs100.getString("monto_total");
                forma_pago=rs100.getString("forma_pago");    
                ieps=rs100.getString("ieps");  
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String uuid="", FechaTimbrado="", selloCFD="", noCertificadoSAT="", selloSAT="",fechaGeneracion="", uso_cfdi="";
        sql="SELECT uuid, FechaTimbrado, selloCFD, noCertificadoSAT, selloSAT, FechaGeneracion,uso_cfdi from to_facturas where factura='"+factura+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    
                uuid=rs100.getString("uuid");
	    	FechaTimbrado=rs100.getString("FechaTimbrado");
                selloCFD=rs100.getString("selloCFD");
                noCertificadoSAT=rs100.getString("noCertificadoSAT");
                selloSAT=rs100.getString("selloSAT");
                fechaGeneracion=rs100.getString("FechaGeneracion");
                uso_cfdi=rs100.getString("uso_cfdi");
	    }
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        //id    codigobarras   precioventa   cantidad   totalprod  descripcion
        ArrayList productos=new ArrayList();
        sql="SELECT to_ventas.idproducto,precio,cantidad,total,nombre_producto from to_ventas,tc_productos where tc_productos.idproducto=to_ventas.idproducto and folio='"+folio+"'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
                productos.add(rs100.getString("idproducto")+"@"+" "+"@"+rs100.getString("precio")+"@"+rs100.getString("cantidad")+"@"+rs100.getString("total")+"@"+rs100.getString("nombre_producto"));               
	    	
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String callereceptor="", cpreceptor="", ciudadreceptor="", coloniareceptor="", estadoreceptor="";
        String direccioncliente="",rfccliente="";
        sql="SELECT * from tc_clientes where idcliente='"+idcliente+"'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) { 
                    callereceptor=rs100.getString("calle") + " #" + rs100.getString("noext");
                    cpreceptor=rs100.getString("cp");
                    ciudadreceptor=rs100.getString("municipio");
                    coloniareceptor=rs100.getString("colonia");
                    estadoreceptor=rs100.getString("estado");
                    direccioncliente="CALLE "+rs100.getString("calle")+" #"+rs100.getString("noext")+" Col. "+rs100.getString("colonia")+" CP "+rs100.getString("cp")+", "+rs100.getString("municipio")+" "+rs100.getString("estado")+", "+rs100.getString("pais");
                    rfccliente=rs100.getString("rfc");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String lugarexpedicion="",nocertificado="";
        sql="SELECT * from to_datos_facturacion where id_datos='1'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {                                    
                    lugarexpedicion=rs100.getString("ciudad")+", "+rs100.getString("estado");
                    nocertificado=rs100.getString("nocertificado");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        
        
    try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
                
	   a=a+"\n  REGIMEN DE LAS PERSONAS FISICAS CON ACTIVIDAD EMPRESARIAL Y PROFESIONAL \n";
           a=a+"\n ==========================================\n";
	   a=a+"           FACTURA DE VENTA \n";
           a=a+"  Lugar de expedición: "+lugarexpedicion+"\n";
           a=a+"  Factura: "+factura+"\n";
           a=a+"  Cliente: "+cliente+"\n";
           a=a+"  RFC: "+rfccliente+"\n";
           a=a+"  Direccion: "+direccioncliente+"\n\n";
           
           a=a+"  Serie del certificado Emisor:       \n";
           a=a+"  "+nocertificado+"\n";
           a=a+"  Folio Fiscal:       \n";
           a=a+"  "+uuid+"\n";
           a=a+"  No. Serie  del Certificado Del SAT: \n"+noCertificadoSAT+" \n";
           a=a+"  Fecha y hora de certificacion:\n";
           a=a+"  "+FechaTimbrado+"\n\n";
           //a=a+" Usuario: "+user+"\n";
           //a=a+" Fecha:   "+fecha+"\n\n";
	   //a=a+" Productos: \n";
           
           a=a+"  Forma de Pago: PAGO EN UNA SOLA EXIBICION\n";
           a=a+"  Método de Pago: "+tipopagos+"\n";
           a=a+"  Cuenta de Pago: NO IDENTIFICADA\n";
           a=a+"  Condiciones de pago: CONTADO\n";
           a=a+"  Moneda: MX  \n";
           a=a+"  Tipo Comprobante: INGRESO \n";
           a=a+"  Nombre Agente: NO IDENTIFICADO \n\n";           
           
           
           //id    codigobarras   precioventa   cantidad   totalprod  descripcion
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                //System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",produ="";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    produ=numerosComoArray[5];
                    //System.out.println(numerosComoArray[i]);
                }  
                if(cantidad.length()<3){ //3 posiciones de cantidad
                    for(int i=cantidad.length();i<=2;i++){
                        cantidad=cantidad+" ";
                    }
                }
                
                /*if(produ.length()>9){ //si es mayor a 15 lo corta
                    produ=produ.substring(0, 9);
                }
                if(produ.length()<=9){ //si es menor de 15 le agrega espacios vacios
                    for(int i=produ.length();i<=9;i++){
                        produ=produ+" ";
                    }
                }*/
                
                if(precio.length()<=6){ //si es menor de 6 le agrega espacios vacios
                    for(int i=precio.length();i<=6;i++){
                        precio=" "+precio;
                    }
                }
                
                if(total.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=total.length();i<=7;i++){
                        total=" "+total;
                    }
                }
                
                a=a+""+cantidad+"  PZA   "+produ+" "+precio+" "+total+"\n";
           }
           
           
           
           String montostr=monto+"";
           System.out.println("MONTO: "+montostr);
           funciones utileria=new funciones();            
           double paramiva=utileria.obteniva();
           //double iva=0.16;
           double iva=paramiva;
           double subtotal=Double.parseDouble(montostr);
           double ivatotal=iva*subtotal;
           double total=ivatotal+subtotal;
           subtotal=Math.rint(subtotal*100)/100;
           ivatotal=Math.rint(ivatotal*100)/100;
           total=Math.rint(total*100)/100;
           total=total+Float.parseFloat(ieps);
           total=Math.rint(total*100)/100;
           //if(montostr.length()<=7){ //si es menor de 7 le agrega espacios vacios
            //        for(int i=montostr.length();i<=7;i++){
            //            montostr=" "+montostr;
            //        }
           //}
           
           if(tipoventa.equals("TARJETA")){
           a=a+"\n          Comision 3%:     "+costotarjeta+"\n";
           }
           
           
           String enteros="", decimales="";
            StringTokenizer tokens=new StringTokenizer(total+"",".");
            while(tokens.hasMoreTokens()){
                    enteros=tokens.nextToken();
                    decimales=tokens.nextToken();
            }
           NumberToLetterConverter cantidadletra=new NumberToLetterConverter();
           String costoletra=cantidadletra.convertNumberToLetter(enteros);
           costoletra=costoletra+" "+decimales+"/100 MXN";
           
           
           
           a=a+"\n              Sub total: $"+montostr+"\n";
           a=a+"\n                    Iva: $"+ivatotal+"\n";
           a=a+"\n                   Ieps: $"+ieps+"\n";
           a=a+"\n                  Total: $"+total+"\n\n";
           
           a=a+" Importe con letra\n";
           a=a+"  "+costoletra+"\n\n";
           
           String cadenacomplemento="||1.0|"+uuid+"|"+FechaTimbrado+"|"+selloCFD+"|"+noCertificadoSAT+"||"; 
           //System.out.println(cadenacomplemento);
           //####################genera el PDF DE LA FACTURA##################
           TiketPDF pdffactura=new TiketPDF();   
           pdffactura.imprimirfactura(factura,fechaGeneracion,FechaTimbrado,costoletra,montostr+"","0",ivatotal+"",total+"", uuid, noCertificadoSAT, selloCFD, selloSAT, cadenacomplemento,cliente,tipopagos,rfccliente,callereceptor,cpreceptor,ciudadreceptor,coloniareceptor,estadoreceptor,paramiva,ieps,uso_cfdi);
        //################ FIN GENERA FACTURA #############################
           
           a=a+"CADENA ORIGINAL DE COMPLEMENTO DE \n";
           a=a+"  CERTIFICACION DIGITAL DEL SAT \n";
           a=a+"||1.0|"+uuid+"|"+FechaTimbrado+"|"+selloCFD+"|"+noCertificadoSAT+"||"+"\n\n";
           a=a+"-------------SELLO DIGITAL DEL EMISOR----------\n";
           a=a+selloCFD+"\n\n";
           a=a+"-------------SELLO DIGITAL DEL SAT--------------\n\n";
           a=a+selloSAT+"\n";          
	   a=a+"------------------------------------------------ \n\n";		   
           
           a=a+" Este documento es una representacion \n";
           a=a+"        impresa de un CFDI \n";
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n ====================================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11

System.out.println("cobrar caja: "+a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 

if(enviarcorreo.equals("SI")){
    Mensaje log = new Mensaje();
    log.enviarMensaje(factura,correo,a);
}

}



public void ImprimirVentaFacturaMasivo(String codigobarras,String tipoventa,float costotarjeta,String factura,String correo,String cliente,String idcliente,String tipopagos,String enviarcorreo){
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
	
        String user="",fecha="",monto="",folio="",forma_pago="";
        String tipoventa10="";
        sql="SELECT * from to_folios where no_folio='"+codigobarras+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    
                folio=rs100.getString("no_folio");
	    	user=rs100.getString("usuario_venta");
                fecha=rs100.getString("fecha_registro_venta");
                monto=rs100.getString("monto_total");
                forma_pago=rs100.getString("forma_pago");
                tipoventa10=rs100.getString("tipo_venta");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String uuid="", FechaTimbrado="", selloCFD="", noCertificadoSAT="", selloSAT="",fechaGeneracion="";
        sql="SELECT uuid, FechaTimbrado, selloCFD, noCertificadoSAT, selloSAT, FechaGeneracion,subtotal from to_facturas where factura='"+factura+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    
                uuid=rs100.getString("uuid");
	    	FechaTimbrado=rs100.getString("FechaTimbrado");
                selloCFD=rs100.getString("selloCFD");
                noCertificadoSAT=rs100.getString("noCertificadoSAT");
                selloSAT=rs100.getString("selloSAT");
                fechaGeneracion=rs100.getString("FechaGeneracion");
                monto=rs100.getString("subtotal");
	    }
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        //id    codigobarras   precioventa   cantidad   totalprod  descripcion
        ArrayList productos=new ArrayList();
        sql="SELECT to_ventas.idproducto,precio,cantidad,total,nombre_producto from to_ventas,tc_productos where tc_productos.idproducto=to_ventas.idproducto and folio='"+folio+"'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {
                productos.add(rs100.getString("idproducto")+"@"+" "+"@"+rs100.getString("precio")+"@"+rs100.getString("cantidad")+"@"+rs100.getString("total")+"@"+rs100.getString("nombre_producto"));               
	    	
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String callereceptor="", cpreceptor="", ciudadreceptor="", coloniareceptor="", estadoreceptor="";
        String direccioncliente="",rfccliente="";
        sql="SELECT * from tc_clientes where idcliente='"+idcliente+"'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) { 
                    callereceptor=rs100.getString("calle") + " #" + rs100.getString("noext");
                    cpreceptor=rs100.getString("cp");
                    ciudadreceptor=rs100.getString("municipio");
                    coloniareceptor=rs100.getString("colonia");
                    estadoreceptor=rs100.getString("estado");
                    direccioncliente="CALLE "+rs100.getString("calle")+" #"+rs100.getString("noext")+" Col. "+rs100.getString("colonia")+" CP "+rs100.getString("cp")+", "+rs100.getString("municipio")+" "+rs100.getString("estado")+", "+rs100.getString("pais");
                    rfccliente=rs100.getString("rfc");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        String lugarexpedicion="",nocertificado="";
        sql="SELECT * from to_datos_facturacion where id_datos='1'";
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {                                    
                    lugarexpedicion=rs100.getString("ciudad")+", "+rs100.getString("estado");
                    nocertificado=rs100.getString("nocertificado");
		}
	    rs100.close();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        
        
    try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;

Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a=encabezado;	   
                
	   a=a+"\n  REGIMEN DE LAS PERSONAS FISICAS CON ACTIVIDAD EMPRESARIAL Y PROFESIONAL \n";
           a=a+"\n ==========================================\n";
	   a=a+"           FACTURA DE VENTA \n";
           a=a+"  Lugar de expedición: "+lugarexpedicion+"\n";
           a=a+"  Factura: "+factura+"\n";
           a=a+"  Cliente: "+cliente+"\n";
           a=a+"  RFC: "+rfccliente+"\n";
           a=a+"  Direccion: "+direccioncliente+"\n\n";
           
           a=a+"  Serie del certificado Emisor:       \n";
           a=a+"  "+nocertificado+"\n";
           a=a+"  Folio Fiscal:       \n";
           a=a+"  "+uuid+"\n";
           a=a+"  No. Serie  del Certificado Del SAT: \n"+noCertificadoSAT+" \n";
           a=a+"  Fecha y hora de certificacion:\n";
           a=a+"  "+FechaTimbrado+"\n\n";
           //a=a+" Usuario: "+user+"\n";
           //a=a+" Fecha:   "+fecha+"\n\n";
	   //a=a+" Productos: \n";
           
           a=a+"  Forma de Pago: PAGO EN UNA SOLA EXIBICION\n";
           a=a+"  Método de Pago: "+tipopagos+"\n";
           a=a+"  Cuenta de Pago: NO IDENTIFICADA\n";
           a=a+"  Condiciones de pago: CONTADO\n";
           a=a+"  Moneda: MX  \n";
           a=a+"  Tipo Comprobante: INGRESO \n";
           a=a+"  Nombre Agente: NO IDENTIFICADO \n\n";           
           
           
           //id    codigobarras   precioventa   cantidad   totalprod  descripcion
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                //System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",produ="";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    produ=numerosComoArray[5];
                    //System.out.println(numerosComoArray[i]);
                }  
                if(cantidad.length()<3){ //3 posiciones de cantidad
                    for(int i=cantidad.length();i<=2;i++){
                        cantidad=cantidad+" ";
                    }
                }
                
                /*if(produ.length()>9){ //si es mayor a 15 lo corta
                    produ=produ.substring(0, 9);
                }
                if(produ.length()<=9){ //si es menor de 15 le agrega espacios vacios
                    for(int i=produ.length();i<=9;i++){
                        produ=produ+" ";
                    }
                }*/
                
                if(precio.length()<=6){ //si es menor de 6 le agrega espacios vacios
                    for(int i=precio.length();i<=6;i++){
                        precio=" "+precio;
                    }
                }
                
                if(total.length()<=7){ //si es menor de 7 le agrega espacios vacios
                    for(int i=total.length();i<=7;i++){
                        total=" "+total;
                    }
                }
                
                //a=a+""+cantidad+"  PZA   "+produ+" "+precio+" "+total+"\n";
           }
           
           
           
           String montostr=monto+"";
           System.out.println("MONTO: "+montostr);
           funciones utileria=new funciones();            
           double paramiva=utileria.obteniva();
           //double iva=0.16;
           double iva=paramiva;
           double subtotal=Double.parseDouble(montostr);
           double ivatotal=iva*subtotal;
           double total=ivatotal+subtotal;
           subtotal=Math.rint(subtotal*100)/100;
           ivatotal=Math.rint(ivatotal*100)/100;
           total=Math.rint(total*100)/100;
           
           a=a+"1  OPERACION CON EL PUBLICO EN GENERAL "+total+"  "+total+"\n";
           
           //if(montostr.length()<=7){ //si es menor de 7 le agrega espacios vacios
            //        for(int i=montostr.length();i<=7;i++){
            //            montostr=" "+montostr;
            //        }
           //}
           
           if(tipoventa.equals("TARJETA")){
           a=a+"\n          Comision 3%:     "+costotarjeta+"\n";
           }
           
           
           String enteros="", decimales="";
            StringTokenizer tokens=new StringTokenizer(total+"",".");
            while(tokens.hasMoreTokens()){
                    enteros=tokens.nextToken();
                    decimales=tokens.nextToken();
            }
           NumberToLetterConverter cantidadletra=new NumberToLetterConverter();
           String costoletra=cantidadletra.convertNumberToLetter(enteros);
           costoletra=costoletra+" "+decimales+"/100 MXN";
           
           
           
           a=a+"\n              Sub total: $"+montostr+"\n";
           a=a+"\n                    Iva: $"+ivatotal+"\n";
           a=a+"\n                  Total: $"+total+"\n\n";
           
           a=a+" Importe con letra\n";
           a=a+"  "+costoletra+"\n\n";
           
           String cadenacomplemento="||1.0|"+uuid+"|"+FechaTimbrado+"|"+selloCFD+"|"+noCertificadoSAT+"||"; 
           //System.out.println(cadenacomplemento);
           //####################genera el PDF DE LA FACTURA##################
           TiketPDF pdffactura=new TiketPDF();   
           pdffactura.imprimirfacturaPublicoGral(factura,fechaGeneracion,FechaTimbrado,costoletra,montostr+"","0",ivatotal+"",total+"", uuid, noCertificadoSAT, selloCFD, selloSAT, cadenacomplemento,cliente,tipopagos,rfccliente,callereceptor,cpreceptor,ciudadreceptor,coloniareceptor,estadoreceptor);
        //################ FIN GENERA FACTURA #############################
           
           a=a+"CADENA ORIGINAL DE COMPLEMENTO DE \n";
           a=a+"  CERTIFICACION DIGITAL DEL SAT \n";
           a=a+"||1.0|"+uuid+"|"+FechaTimbrado+"|"+selloCFD+"|"+noCertificadoSAT+"||"+"\n\n";
           a=a+"-------------SELLO DIGITAL DEL EMISOR----------\n";
           a=a+selloCFD+"\n\n";
           a=a+"-------------SELLO DIGITAL DEL SAT--------------\n\n";
           a=a+selloSAT+"\n";          
	   a=a+"------------------------------------------------ \n\n";		   
           
           a=a+" Este documento es una representacion \n";
           a=a+"        impresa de un CFDI \n";
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n ====================================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel
a=a+(char)27+(char)112+(char)0+(char)25+(char)250;  //abre cajon dinero por rj11

System.out.println("cobrar caja: "+a);
DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE; 
PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
DocPrintJob pj = service.createPrintJob(); 
byte[]bytes =a.getBytes(); 
Doc doc = new SimpleDoc(bytes, flavor,null); 
try{ 
pj.print(doc,null); 
}catch(Exception e){ } 


if(enviarcorreo.equals("SI")){
    Mensaje log = new Mensaje();
    log.enviarMensaje(factura,correo,a);
}

}





public void ImprimirComanda(String mesa){
    System.out.println("IMPRIMIENDO COMANDA");
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
	
   
	
	
	
	
char as=29;  //gs
char ew1=66;
char w=80;


String prod="",nombremesa="";
            sql="SELECT Idtemp,cantidad,descripcion,Nombre,observacion from rest_temp_venta,rest_mesas where IdMesa=idrmesa and impreso=1 and idrmesa='"+mesa+"' order by Idtemp asc";
            System.out.println(sql);            
            try {
                    pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
                    Statement st = cn.getConnection().createStatement();
                    
                    ResultSet rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {
                    nombremesa=rs100.getString("Nombre");
                    String cantidad=rs100.getString("cantidad");
                    if(cantidad.equals("0.00")){
                    cantidad="---";
                    }else{
                        cantidad=cantidad.substring(0,(cantidad.length()-3));
                    }
                     prod=prod+""+cantidad+" "+rs100.getString("descripcion")+"  "+rs100.getString("observacion")+"\n";           
                     System.out.println("update rest_temp_venta set impreso=0 where Idtemp="+rs100.getString("Idtemp"));
                     st.executeUpdate("update rest_temp_venta set impreso=0 where Idtemp="+rs100.getString("Idtemp"));
                    }
                rs100.close();
            } catch (SQLException e2) {
                    // TODO Auto-generated catch block
                    e2.printStackTrace();
            }

 try {
        cn.desconectar();
    } catch (SQLException ex) {
        Logger.getLogger(Ticket.class.getName()).log(Level.SEVERE, null, ex);
    }            
            
Date date = new Date();
DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
System.out.println("Fecha: "+dateFormat.format(date));

String a="";	   
	   a=a+"\n  ============================\n";
	   a=a+" Mesa: "+nombremesa+"\n";
           //a=a+" Usuario: "+user+"\n";
           a=a+" Fecha:"+dateFormat.format(date)+"\n\n";	    
           a=a+prod+"                     \n\n";
	   		   
	   
	   
	   
/*
char esc=27;
char b=20;
char c=1;
char d=226;
char e1=0;
char f=70;
char g=56;
char h=29;
char i=2;
char j=40;
char k=0;
char l=4;
char m=28;

char ss=15;
a=a+esc+"W"+b+c+d+e1+f+e1+g+c;
a=a+esc+"T"+c;
a=a+h+"H"+i;
a=a+h+"f"+c;
a=a+h+"h"+j;
a=a+h+"w"+i;
a=a+h+"$"+j+k;
a=a+h+"k"+l+codebar+k;
a=a+esc+m;
//fin codigo barras
*/

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
           
a=a+"\n  ============================\n"+footer+"\n";
a=a+as+"V"+ew1+w;//corta el papel




        
    String impresora="";
    conex con=new conex();  
    try {
        ResultSet rsR = null; 
        Statement st = con.getConnection().createStatement();

        String myQuery = "select parametro from to_parametros where clave='IMPCOMANDA'";
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
    System.out.println(a);
    if(impresora.equals("") || impresora.equals("Por Defecto")){            
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
    
    


 


} 
} 

