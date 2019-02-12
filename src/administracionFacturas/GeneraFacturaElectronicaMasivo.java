/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;
import Utilerias.funciones;
import conexion.conex;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author JOSE
 */
public class GeneraFacturaElectronicaMasivo {

public boolean facturarventamasiva(ArrayList folios,String tipopagofactura,Double SubtotalIni){
    boolean exito=true;
    
    
    
    String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       //  Database credentials
       String USER = conex.login;
       String PASS = conex.password; 
       String ip = conex.ip; 
       String DB_URL = "jdbc:mysql://"+ip+"/"+conex.bd;
        Connection conn = null;
        Statement stmt = null;
        try{
           //STEP 2: Register JDBC driver
           Class.forName("com.mysql.jdbc.Driver");

           //STEP 3: Open a connection
           System.out.println("Connecting to database...");
           conn = DriverManager.getConnection(DB_URL,USER,PASS);

           //STEP 4: Set auto commit as false.
           conn.setAutoCommit(false);

           //STEP 5: Execute a query to create statment with
           // required arguments for RS example.
           System.out.println("Creating statement...");
           stmt = conn.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);

           String SQL="";           
           //STEP 6: INSERT a row into Employees table           
           ResultSet rs=null;   
           String patharchivos=new File ("").getAbsolutePath ()+"\\facturacion\\";					
           String idcliente="0",subtotal="0",iva="0",total="0",nocuenta="",formapago="",MetodoPago="",no_folio="";					
           String cliente="";
           String email="";
           funciones utileria=new funciones();            
           double paramiva=utileria.obteniva();
           //double ivaini=SubtotalIni*0.16;
           double ivaini=SubtotalIni*paramiva;
           ivaini=redondearDecimales(ivaini,2);
           double totalini=SubtotalIni+ivaini;
           totalini=redondearDecimales(totalini,2);
           
           subtotal=SubtotalIni+"";
           iva=ivaini+"";
           total=totalini+"";
           //original
           //SQL="select no_folio,idcliente,monto_total, (monto_total*0.16) as iva, (monto_total+(monto_total*0.16)) as total,noCuenta,FormaPago,MetodoPago,email,razon_social  from to_folios, tc_clientes where (to_folios.tipo_venta='Factura' or to_folios.tipo_venta='Ticket') and cliente=idcliente and codigo_venta='"+codigobarras+"'";
           //RFC: PUBLICO GENERAL XAXX010101000
           SQL="select idcliente,noCuenta,FormaPago,MetodoPago,email,razon_social  from tc_clientes where nombre_completo='PUBLICO general'";
            System.out.println(""+SQL);
           rs=stmt.executeQuery(SQL); 
           while(rs.next()){
               //no_folio=rs.getString("no_folio");
               idcliente=rs.getString("idcliente");
               //subtotal=rs.getString("monto_total");
               //iva=rs.getString("iva");
               //total=rs.getString("total");
               nocuenta=rs.getString("noCuenta");
               formapago=rs.getString("FormaPago");
               MetodoPago=rs.getString("MetodoPago");
               email=rs.getString("email");
               cliente=rs.getString("razon_social");
           }
           
           int factura_nueva=0;					
           SQL="SELECT * from to_parametros where clave='FACTURA'";
           rs=stmt.executeQuery(SQL); 
           while(rs.next()){
               factura_nueva=rs.getInt("parametro"); 
           }
           factura_nueva=factura_nueva+1;
           
           String cantidad="1";
           String concepto="Ventas";
           //original
           //SQL="insert into to_facturas (idr_cliente,noCuenta,MetodoPago,FormaPagos,cantidad,unidad,concepto,subtotal,iva, Monto, factura, FechaGeneracion,folio) values ('"+idcliente+"','"+nocuenta+"','"+MetodoPago+"','"+formapago+"','"+cantidad+"','PZA','"+concepto+"','"+subtotal+"','"+iva+"','"+total+"','"+factura_nueva+"',now(),'"+no_folio+"')";
           SQL="insert into to_facturas (idr_cliente,noCuenta,MetodoPago,FormaPagos,cantidad,unidad,concepto,subtotal,iva, Monto, factura, FechaGeneracion) values ('"+idcliente+"','"+nocuenta+"','"+MetodoPago+"','"+formapago+"','"+cantidad+"','NA','"+concepto+"','"+subtotal+"','"+iva+"','"+total+"','"+factura_nueva+"',now())";
           System.out.println(""+SQL);
           stmt.executeUpdate(SQL);           
           System.out.println(""+patharchivos);                      
           SQL="update to_parametros set parametro='"+factura_nueva+"' where clave='FACTURA'";
           stmt.executeUpdate(SQL); 
           
           rs.close();
           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();                      
           
           AgregarServiciosFacturaMasivo factura=new AgregarServiciosFacturaMasivo();           
           boolean valida=factura.generarfacturaMasivo(Integer.parseInt(idcliente),patharchivos,factura_nueva,email,cliente,tipopagofactura,folios);
           if(valida==false){
               exito=false;
           }
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
           exito=false;
           // If there is an error then rollback the changes.
           System.out.println("Rolling back data here....");
               try{
                      if(conn!=null)
                 conn.rollback();
                 exito=false;
           }catch(SQLException se2){
              se2.printStackTrace();
           }//end try

        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
           exito=false;
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
               exito=false;
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
               exito=false;
              se.printStackTrace();
           }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    
    
    return exito;
}
    

public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }  
}
