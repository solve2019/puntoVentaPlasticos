/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciotecnico;
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

/**
 *
 * @author desarrollo8
 */
public class ticketentrega {
    
    

public void ImprimirServicio(String folio){
	String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	/*try {
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
	}*/
	
        String fecharecepcion="",nombre="",correo="",telefono="",imei="",marca="",modelo="",estado="",observaciones="";
        sql="SELECT * from to_recepcion where Id='"+folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	fecharecepcion=rs100.getString("fecha");
                nombre=rs100.getString("nombre");
                correo=rs100.getString("correo");
                telefono=rs100.getString("telefono");                
                imei=rs100.getString("imei");
                marca=rs100.getString("marca");
                modelo=rs100.getString("modelo");
                estado=rs100.getString("estado");
                observaciones=rs100.getString("observaciones");
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
char esc2=10;
String a=esc2+""+encabezado;	   
	   a=a+"\n ===============================\n";
	   a=a+" Folio: "+folio+"\n";
           a=a+" Fecha: "+fecharecepcion+"\n\n";
           a=a+" Cliente: "+nombre+"\n";
           a=a+" Telefono: "+telefono+"\n";
	   a=a+" Correo: "+correo+"\n\n";
           a=a+" IMEI: "+imei+"\n";
           a=a+" Marca: "+marca+"\n";
           a=a+" Modelo: "+modelo+"\n";
           a=a+" Estado: "+estado+"\n";
           a=a+" Observaciones: "+observaciones+"\n";
           
           
     
	   		   
	   
	   
	   
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



public void ImprimirServicioEntrega(String folio){
	String encabezado="",footer="";
	conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENCABEZADO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	/*try {
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
	}*/
	
        String fecharecepcion="",nombre="",correo="",telefono="",imei="",marca="",modelo="",estado="",observaciones="";
        String fechaentrega="",correccion="",monto="";
        sql="SELECT * from to_recepcion where Id='"+folio+"'";
        System.out.println(""+sql);
	try {
            pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
            ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    	
	    	fecharecepcion=rs100.getString("fecha");
                nombre=rs100.getString("nombre");
                correo=rs100.getString("correo");
                telefono=rs100.getString("telefono");                
                imei=rs100.getString("imei");
                marca=rs100.getString("marca");
                modelo=rs100.getString("modelo");
                estado=rs100.getString("estado");
                observaciones=rs100.getString("observaciones");
                fechaentrega=rs100.getString("fechaentrega");
                correccion=rs100.getString("correccion");
                monto=rs100.getString("monto");
                
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
char esc2=10;
String a=esc2+""+encabezado;	   
	   a=a+"\n ===============================\n";
	   a=a+" Folio: "+folio+"\n";
           a=a+" Fecha: "+fecharecepcion+"\n\n";
           a=a+" Cliente: "+nombre+"\n";
           a=a+" Telefono: "+telefono+"\n";
	   a=a+" Correo: "+correo+"\n\n";
           a=a+" IMEI: "+imei+"\n";
           a=a+" Marca: "+marca+"\n";
           a=a+" Modelo: "+modelo+"\n";
           a=a+" Estado: "+estado+"\n";
           a=a+" Observaciones: "+observaciones+"\n\n";
           a=a+" Fecha entrega: "+fechaentrega+"\n";
           a=a+" Correcciones: "+correccion+"\n";
           a=a+" Monto: $"+monto+"\n";
           
           
     
	   		   
	   
	   
	   
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



}
