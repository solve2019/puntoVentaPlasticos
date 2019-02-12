/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Restaurant;
import ClasesDAO.*;
import conexion.conex;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import puntoventa.RemisionPDF;
/**
 *
 * @author desarrollo8
 */
public class cobrar_ventaFinalRes {
    
    
    
    
    public boolean cobrar(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String referenciamixto,String formadescuento,String idclientefac,double ieps,String mesa,String mesero){
        double resultdescuento=0;
        if(formadescuento.equals("PORCENTAJE")){
            resultdescuento = (descuento * monto)/100;            
        }
        if(formadescuento.equals("EFECTIVO")){
            resultdescuento = descuento;//SE DESCUENTA EN EFECTIVO            
        }
        
        monto=(float) (monto-resultdescuento);
        
       boolean valida=true;
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

           //STEP 6: INSERT a row into Employees table
           System.out.println("Inserta folio");
           int folio=0;
           String SQL = "select * from to_parametros where clave='FOLIO'";
           ResultSet rs=null;
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {    
            folio=rs.getInt("parametro");
           }
           folio++;//se incrementa el folio
           rs.close();
           double iva=obteniva();
           iva=monto*iva;
           double montototal=monto+iva;
           
           if(formaPago.equals("MIXTO")){
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,mesa,mesero) " +
                         "VALUES ('"+folio+"', "+monto+", "+pagoefectivo+", "+referenciabanco+", '"+referenciamixto+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','EFECTIVO','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+mesa+"','"+mesero+"')";
           //System.out.println(""+SQL);
           stmt.executeUpdate(SQL);      
           
           double efectivopagado=montototal-Double.parseDouble(referenciabanco);//se descuenta por si tiene cambio que entregar
           SQL="update to_cierre_caja set efectivo=(efectivo+"+efectivopagado+") where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL);            
           SQL="update to_cierre_caja set tarjeta=(tarjeta+"+referenciabanco+") where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           }
           
           if(formaPago.equals("EFECTIVO")){
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,mesa,mesero) " +
                         "VALUES ('"+folio+"', "+monto+", "+pagoefectivo+", 0, '"+referenciabanco+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','EFECTIVO','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+mesa+"','"+mesero+"')";
               //System.out.println(""+SQL);
           stmt.executeUpdate(SQL);           
           SQL="update to_cierre_caja set efectivo=(efectivo+"+montototal+") where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL);            
           }
           if(formaPago.equals("TARJETA")){
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,mesa,mesero) " +
                         "VALUES ('"+folio+"', "+monto+", 0,"+monto+", '"+referenciabanco+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','TARJETA','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+mesa+"','"+mesero+"')";
           stmt.executeUpdate(SQL);  
           SQL="update to_cierre_caja set tarjeta=(tarjeta+"+montototal+") where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           
           }
           
           
           
           
           
           SQL="update to_cierre_caja set no_ventas=(no_ventas+1) where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           
           SQL = "update to_parametros set parametro='"+folio+"' where clave='FOLIO'";
           stmt.executeUpdate(SQL);  

           //id    codigobarras   precioventa   cantidad   totalprod
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",iepsval="0";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    iepsval=numerosComoArray[6];
                    //System.out.println(numerosComoArray[i]);
                }
                SQL = "insert into to_ventas (idproducto,cantidad,precio,total,folio,fecha_mov,ieps) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"',now(),"+iepsval+")";
                stmt.executeUpdate(SQL);
                
                //SQL = "update tc_productos set existencia=(existencia-"+cantidad+") where idproducto='"+id+"'";                
                //stmt.executeUpdate(SQL);
                
                SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+id+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','SALIDA')";
                stmt.executeUpdate(SQL);  
                
                
                
                SQL = "select prodcompuesto from tc_productos where idproducto='"+id+"'";  
                Statement stmt2 = conn.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2=stmt.executeQuery(SQL);
                while(rs2.next()){
                    if(rs2.getString("prodcompuesto").equals("NO")){//NO ESPRODUCTO COMPUESTO
                        SQL = "update tc_productos set existencia=(existencia-"+cantidad+") where idproducto='"+id+"'";               
                        stmt2.executeUpdate(SQL);
                    }else{
                        validaProdCompuesto(id,cantidad);
                    }
                }
                rs2.close();
                stmt2.close();
           
           }
           

           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
           if(impresionticket.equals("MANDAIMPRIMIR")){//impresion de ticket
               java.util.Date date = new java.util.Date();
               DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               System.out.println("Fecha: "+dateFormat.format(date));
               
               int response = JOptionPane.showConfirmDialog(null, "Desea imprimir el ticket de pago?", "Confirmar",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (response == JOptionPane.YES_OPTION) {
                  TicketVenta ticketpdf=new TicketVenta();
                  String tipoimpresion=ticketpdf.tipoimpresion();
                  System.out.println("TIPOIMPRESION:"+tipoimpresion);
                  if(tipoimpresion.equals("PDF")){
                    ticketpdf.imprimirticket(folio+"","IMPREST");
                  }else{
                    Ticket imprime=new Ticket();
                    //imprime.ImprimirDocumento(folio+"",accesoSistema.nombreuser,monto,productos,dateFormat.format(date));
                    imprime.ReImprimirDocumento(folio+"");
                  }
               }
    
               
           }
           JOptionPane.showMessageDialog(null, "Se realizo la venta correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
           valida=false;
           // If there is an error then rollback the changes.
           System.out.println("Rolling back data here....");
               try{
                      if(conn!=null)
                 conn.rollback();
                 valida=false;
           }catch(SQLException se2){
              se2.printStackTrace();
           }//end try

        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    
    
    
        return valida;
    }
    


public boolean cobrarcreditocliente(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String idcliente,String idclientefac,double ieps){
        
        
        double resultdescuento = (descuento * monto)/100;            
        monto=(float) (monto-resultdescuento);
        
       boolean valida=true;
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

           //STEP 6: INSERT a row into Employees table
           System.out.println("Inserta folio");
           int folio=0;
           String SQL = "select * from to_parametros where clave='FOLIO'";
           ResultSet rs=null;
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {    
            folio=rs.getInt("parametro");
           }
           folio++;//se incrementa el folio
           rs.close();
           double iva=obteniva();
           iva=monto*iva;
           double montototal=monto+iva;
           //if(formaPago.equals("CREDITO")){
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps) " +
                         "VALUES ('"+folio+"', "+monto+", 0, 0, '"+referenciabanco+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','CREDITO','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+")";
               //System.out.println(""+SQL);
           stmt.executeUpdate(SQL);           
           //SQL="update to_cierre_caja set efectivo=(efectivo+"+montototal+") where id_cierre_caja ='1'";
           //stmt.executeUpdate(SQL);            
           //}
           
           
           SQL="insert into th_cliente_credito (idrcliente,idrfolio,fechamovimiento,usuariomovimiento) values ('"+idcliente+"','"+folio+"',now(),'"+accesoSistema.nombreuser+"')";
           stmt.executeUpdate(SQL);            
           
           SQL="update to_cierre_caja set no_ventas=(no_ventas+1) where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           
           SQL = "update to_parametros set parametro='"+folio+"' where clave='FOLIO'";
           stmt.executeUpdate(SQL);  

           //id    codigobarras   precioventa   cantidad   totalprod
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    //System.out.println(numerosComoArray[i]);
                }
                SQL = "insert into to_ventas (idproducto,cantidad,precio,total,folio,fecha_mov) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"',now())";
                stmt.executeUpdate(SQL);
                //SQL = "update tc_productos set existencia=(existencia-"+cantidad+") where idproducto='"+id+"'";                
                //stmt.executeUpdate(SQL);
                
                SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+id+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','SALIDA')";
                stmt.executeUpdate(SQL);  
                
                
                SQL = "select prodcompuesto from tc_productos where idproducto='"+id+"'";  
                Statement stmt2 = conn.createStatement(
                                ResultSet.TYPE_SCROLL_INSENSITIVE,
                                ResultSet.CONCUR_UPDATABLE);
                ResultSet rs2=stmt.executeQuery(SQL);
                while(rs2.next()){
                    if(rs2.getString("prodcompuesto").equals("NO")){//NO ESPRODUCTO COMPUESTO
                        SQL = "update tc_productos set existencia=(existencia-"+cantidad+") where idproducto='"+id+"'";               
                        stmt2.executeUpdate(SQL);
                    }else{
                        validaProdCompuesto(id,cantidad);
                    }
                }
                rs2.close();
                stmt2.close();
                
           
           }
           

           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
           if(impresionticket.equals("MANDAIMPRIMIR")){//impresion de ticket
               java.util.Date date = new java.util.Date();
               DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
               System.out.println("Fecha: "+dateFormat.format(date));
               TicketVenta ticketpdf=new TicketVenta();
              String tipoimpresion=ticketpdf.tipoimpresion();
              if(tipoimpresion.equals("PDF")){
                ticketpdf.imprimirticket(folio+"","IMPREST");
              }else{
               Ticket imprime=new Ticket();
               //imprime.ImprimirDocumento(folio+"",accesoSistema.nombreuser,monto,productos,dateFormat.format(date));
               imprime.ReImprimirDocumento(folio+"");
              }
           }
           JOptionPane.showMessageDialog(null, "Se realizo la venta correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
           valida=false;
           // If there is an error then rollback the changes.
           System.out.println("Rolling back data here....");
               try{
                      if(conn!=null)
                 conn.rollback();
                 valida=false;
           }catch(SQLException se2){
              se2.printStackTrace();
           }//end try

        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    
    
    
        return valida;
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




public boolean cotizacion(float monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento, String tipoventa,String cliente){
        
        
       double resultdescuento = (descuento * monto)/100;            
       monto=(float) (monto-resultdescuento);
        
       boolean valida=true;
       String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       //  Database credentials
       String USER = conex.login;
       String PASS = conex.password; 
       String IP = conex.ip;
       String DB_URL = "jdbc:mysql://"+IP+"/"+conex.bd;
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

           //STEP 6: INSERT a row into Employees table
           System.out.println("Inserta folio");
           int folio=0;
           String SQL = "select * from to_parametros where clave='FOLIO'";
           
           
           java.util.Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");     
            String codigoventa = formatter.format(today);
           SQL = "INSERT INTO to_cotizacion (fecha, monto_total, usuario_registro) " +
                         "VALUES (now(), "+monto+", '"+accesoSistema.nombreuser+"')";
           stmt.executeUpdate(SQL);  
           
           String idcoti="";
           SQL = "select id_cotizacion from to_cotizacion order by id_cotizacion desc limit 1";
           ResultSet rs=stmt.executeQuery(SQL);  
           while(rs.next()){
               idcoti=rs.getString("id_cotizacion");
           }

           //id    codigobarras   precioventa   cantidad   totalprod
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    //System.out.println(numerosComoArray[i]);
                }
                SQL = "insert into to_cotizacion_prod (idproducto,cantidad,precio,total,id_coti,fecha_mov) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+idcoti+"',now())";
                stmt.executeUpdate(SQL);
           
           }
           
           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
           RemisionPDF pdfremi=new RemisionPDF();
           pdfremi.imprimircotizacion(idcoti);
           JOptionPane.showMessageDialog(null, "Se realizo la cotizacion correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
           
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
           valida=false;
           // If there is an error then rollback the changes.
           System.out.println("Rolling back data here....");
               try{
                      if(conn!=null)
                 conn.rollback();
                 valida=false;
           }catch(SQLException se2){
              se2.printStackTrace();
           }//end try

        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    
    
    
        return valida;
    }




public boolean notacredito(float monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento, String tipoventa,String cliente,String ieps){
        
        
       double resultdescuento = (descuento * monto)/100;            
       monto=(float) (monto-resultdescuento);
        
       boolean valida=true;
       String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       //  Database credentials
       String USER = conex.login;
       String PASS = conex.password; 
       String IP = conex.ip;
       String DB_URL = "jdbc:mysql://"+IP+"/"+conex.bd;
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

           //STEP 6: INSERT a row into Employees table
           System.out.println("Inserta folio");
           int folio=0;
           String SQL = "select * from to_parametros where clave='FOLIO'";
           
           
           java.util.Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddhhmmss");     
            String codigoventa = formatter.format(today);
           SQL = "INSERT INTO to_nota_credito (fechanonta, monto_total_nota, usuario_registro,idr_cliente,ieps) " +
                         "VALUES (now(), "+monto+", '"+accesoSistema.nombreuser+"','"+cliente+"',"+ieps+")";
           stmt.executeUpdate(SQL);  
           
           String idnota="";
           SQL = "select id_nota from to_nota_credito order by id_nota desc limit 1";
           ResultSet rs=stmt.executeQuery(SQL);  
           while(rs.next()){
               idnota=rs.getString("id_nota");
           }

           //id    codigobarras   precioventa   cantidad   totalprod
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",iepsunit="0";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];
                    iepsunit=numerosComoArray[6];
                    //System.out.println(numerosComoArray[i]);
                }
                SQL = "insert into to_nota_credito_prod (idrproducto,cant,precio,total,idr_nota,fecha_mov,ieps) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+idnota+"',now(),"+ieps+")";
                stmt.executeUpdate(SQL);
           
           }
           
           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
           RemisionPDF pdfremi=new RemisionPDF();
           pdfremi.imprimirnota(idnota);
           JOptionPane.showMessageDialog(null, "Se realizo la nota de credito correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
           
        }catch(SQLException se){
           //Handle errors for JDBC
           se.printStackTrace();
           valida=false;
           // If there is an error then rollback the changes.
           System.out.println("Rolling back data here....");
               try{
                      if(conn!=null)
                 conn.rollback();
                 valida=false;
           }catch(SQLException se2){
              se2.printStackTrace();
           }//end try

        }catch(Exception e){
           //Handle errors for Class.forName
           e.printStackTrace();
        }finally{
           //finally block used to close resources
           try{
              if(stmt!=null)
                 stmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn!=null)
                 conn.close();
           }catch(SQLException se){
              se.printStackTrace();
           }//end finally try
        }//end try
        //System.out.println("Goodbye!");
    
    
    
        return valida;
    }


public void validaProdCompuesto(String idprod,String cantidad){//descuenta cantidades del los productos que componen el producto
    conex cn = new conex();    
    String sql="SELECT * from tc_prod_compuesto where Idr_productoPrimario='"+idprod+"'";
    System.out.println(sql);
    PreparedStatement pstm100;
    try {
        pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
        ResultSet rs100 = (ResultSet) pstm100.executeQuery();
        Statement stmt = cn.getConnection().createStatement();
        while (rs100.next()) {
    		    	String SQL2 = "update tc_productos set existencia=(existencia-("+rs100.getString("cant_utiliza")+"*"+cantidad+")) where idproducto='"+rs100.getString("Id_prod_secundario")+"'";               
                        stmt.executeUpdate(SQL2);	   
            }
        rs100.close();
        pstm100.close();
        stmt.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }
}

}
