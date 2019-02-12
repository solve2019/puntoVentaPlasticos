/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClasesDAO;
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
public class cobrar_ventafinal {
    
    
    
    
    public boolean cobrar(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String referenciamixto,String formadescuento,String idclientefac,double ieps,String membresia,String noreceta,String medico,String usuarioventa){
        double resultdescuento=0;
        System.out.println("formadescuento: "+formadescuento);
        if(formadescuento.equals("PORCENTAJE")){
            resultdescuento = (descuento * monto)/100;            
        }
        if(formadescuento.equals("EFECTIVO")){
            resultdescuento = descuento;//SE DESCUENTA EN EFECTIVO            
        }
        System.out.println("resultdescuento: "+resultdescuento);
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
           String userventa="",iduser="0";
            
           if(usuarioventa.equals("Selecciona..")){
                userventa=accesoSistema.nombreuser;
                iduser=accesoSistema.iduser;
           }else{
               System.out.println("usuarioventa: "+usuarioventa);
               String[] parts = usuarioventa.split("-");
               iduser = parts[0]; // 004
               userventa = parts[1]; // 034556                
           }
           if(formaPago.equals("MIXTO")){
                SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,membresia,numero_receta,medico) " +
                              "VALUES ('"+folio+"', "+monto+", "+pagoefectivo+", "+referenciabanco+", '"+referenciamixto+"', 0, 0, now(),'"+userventa+"','VENTA','MIXTO','"+iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+membresia+"','"+noreceta+"','"+medico+"')";
                    System.out.println(""+SQL);
                stmt.executeUpdate(SQL);      

                double efectivopagado=montototal-Double.parseDouble(referenciabanco);//se descuenta por si tiene cambio que entregar
                SQL="update to_cierre_caja set efectivo=(efectivo+"+efectivopagado+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL);
                if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set efectivo=(efectivo+"+efectivopagado+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
                }	           
                SQL="update to_cierre_caja set tarjeta=(tarjeta+"+referenciabanco+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL); 
                if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set tarjeta=(tarjeta+"+referenciabanco+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
                }                      
           }
           
           if(formaPago.equals("EFECTIVO")){
                SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,membresia,numero_receta,medico) " +
                              "VALUES ('"+folio+"', "+monto+", "+pagoefectivo+", 0, '"+referenciabanco+"', 0, 0, now(),'"+userventa+"','VENTA','EFECTIVO','"+iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+membresia+"','"+noreceta+"','"+medico+"')";
                    System.out.println(""+SQL);
                stmt.executeUpdate(SQL);           
                SQL="update to_cierre_caja set efectivo=(efectivo+"+montototal+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL);  
                if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set efectivo=(efectivo+"+montototal+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
                } 
           }
           if(formaPago.equals("TARJETA")){
                SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,membresia,numero_receta,medico) " +
                              "VALUES ('"+folio+"', "+monto+", 0,"+monto+", '"+referenciabanco+"', 0, 0, now(),'"+userventa+"','VENTA','TARJETA','"+iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+membresia+"','"+noreceta+"','"+medico+"')";
                stmt.executeUpdate(SQL);  
                SQL="update to_cierre_caja set tarjeta=(tarjeta+"+montototal+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL); 
                if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set tarjeta=(tarjeta+"+montototal+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
                } 
           }
           
           
           
           
           
           SQL="update to_cierre_caja set no_ventas=(no_ventas+1) where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set no_ventas=(no_ventas+1) WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
           }
           
           SQL = "update to_parametros set parametro='"+folio+"' where clave='FOLIO'";
           stmt.executeUpdate(SQL);  

           //id    codigobarras   precioventa   cantidad   totalprod
           
           double descuentototal=0;
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",iepsval="0",descuentoprod="0";
                double descuentosss=0;
                double utilidad=0;
                String antibiotico="";
                String lote="";
                for (int i = 0; i < numerosComoArray.length; i++) {
                    id=numerosComoArray[0];                    
                    double preciocompra=obtenpreciocompra(id);                    
                    preciocompra=preciocompra*Double.parseDouble(cantidad);                   
                    
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    //total=numerosComoArray[4];
                    double totales=Double.parseDouble(precio)*Double.parseDouble(cantidad);
                    totales=redondearDecimales(totales,2);                    
                    total=totales+"";
                    
                    utilidad=totales-preciocompra;
                    
                    iepsval=numerosComoArray[6];
                    descuentoprod=numerosComoArray[7];
                    if(descuento>0){//viene descuento de todo el producto se hace descuento a cada producto
                        descuentoprod=descuento+"";
                    }
                    
                    descuentosss=(totales*Double.parseDouble(descuentoprod)/100);
                    descuentoprod=descuentosss+"";    
                    
                    if(numerosComoArray[8]==null){
                    }else{
                        antibiotico=numerosComoArray[8];
                        //System.out.println("antibiotico: "+antibiotico);
                    }
                    
                    if(numerosComoArray[9]==null){
                    }else{
                        lote=numerosComoArray[9];
                        System.out.println("LOTE: "+lote);
                    }
                    
                    if(!lote.equals("0")){
                        String[] parts = lote.split("-");
                        lote = parts[0]; // 123                        
                    }
                    
                    if(antibiotico.equals("NO")){
                        antibiotico="0";
                    }
                    if(antibiotico.equals("SI")){
                        antibiotico="1";
                    }
                    
                    //System.out.println(numerosComoArray[i]);
                }
                descuentototal=descuentototal+descuentosss;
                SQL = "insert into to_ventas (idproducto,cantidad,precio,total,folio,fecha_mov,ieps,descuento,utilidad,idr_lote,antibiotico) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"',now(),"+iepsval+","+descuentoprod+",'"+utilidad+"','"+lote+"','"+antibiotico+"')";
                stmt.executeUpdate(SQL);
                
                if(!lote.equals("0")){//proviene de un lote se descuenta del lote
                    SQL = "update farmacia_to_lotes set cantidad=cantidad-"+cantidad+" where Id_lotes='"+lote+"'";
                    stmt.executeUpdate(SQL);
                }
                
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
                
                //funcion para inventario fisico
                SQL="select parametro from to_parametros where clave='INVENTARIOFISICO'";
                String invfis="NO";
                rs2=stmt.executeQuery(SQL);
                while(rs2.next()){
                   invfis=rs2.getString("parametro");
                }    
                if(invfis.equals("SI")){
                    valida_inventario_fisico(id,cantidad);
                }
                rs2.close();
                stmt2.close();
                
           
           }//termina array de lecturas de productos
           if(descuentototal>0){
                SQL = "update to_folios set descuento='"+descuentototal+"' where no_folio='"+folio+"'";
                stmt.executeUpdate(SQL);
                SQL = "select sum(descuento) as descu from to_ventas where folio='"+folio+"'";
                ResultSet rs21=stmt.executeQuery(SQL);
                double totaldesdif=0;
                if(rs21.next()){
                    totaldesdif=rs21.getDouble("descu");                    
                }
                double descuentodif=descuentototal-totaldesdif;
                if(descuentodif>0){//suma la diferencias
                    SQL = "update to_folios set diferenciadescuento='"+descuentodif+"' where no_folio='"+folio+"'";
                    stmt.executeUpdate(SQL);
                }
                rs21.close();
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
                    ticketpdf.imprimirticket(folio+"","IMPPVT");
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
    


public boolean cobrarcreditocliente(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String idcliente,String idclientefac,double ieps,String membresia,String noreceta,String medico){
        
        
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
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva,cliente,ieps,membresia,numero_receta,medico) " +
                         "VALUES ('"+folio+"', "+monto+", 0, 0, '"+referenciabanco+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','CREDITO','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"','"+idclientefac+"',"+ieps+",'"+membresia+"','"+noreceta+"','"+medico+"')";
               //System.out.println(""+SQL);
           stmt.executeUpdate(SQL);           
           //SQL="update to_cierre_caja set efectivo=(efectivo+"+montototal+") where id_cierre_caja ='1'";
           //stmt.executeUpdate(SQL);            
           //}
           
           
           SQL="insert into th_cliente_credito (idrcliente,idrfolio,fechamovimiento,usuariomovimiento) values ('"+idcliente+"','"+folio+"',now(),'"+accesoSistema.nombreuser+"')";
           stmt.executeUpdate(SQL);            
           
           SQL="update to_cierre_caja set no_ventas=(no_ventas+1) where id_cierre_caja ='1'";
           stmt.executeUpdate(SQL); 
           if(!accesoSistema.nombrecaja.equals("")){
                     SQL = "update to_cierre_caja set no_ventas=(no_ventas+1) WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                     stmt.executeUpdate(SQL);  
           } 
           
           
           SQL = "update to_parametros set parametro='"+folio+"' where clave='FOLIO'";
           stmt.executeUpdate(SQL);  
           double descuentototal=0;
           //id    codigobarras   precioventa   cantidad   totalprod
           for(int x=0;x<productos.size();x++) {
                //System.out.println(productos.get(x));
                String datos=productos.get(x)+"";            
                String[] numerosComoArray = datos.split("@");
                System.out.println(datos+" num:"+numerosComoArray.length);
                String id="",cantidad="0",precio="0",total="0",descuentoprod="0",iepsval="0";
                double descuentosss=0;
                for (int i = 0; i < numerosComoArray.length; i++) {
                    /*id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    total=numerosComoArray[4];*/
                    
                    
                    id=numerosComoArray[0];
                    precio=numerosComoArray[2];
                    cantidad=numerosComoArray[3];
                    //total=numerosComoArray[4];
                    double totales=Double.parseDouble(precio)*Double.parseDouble(cantidad);
                    totales=redondearDecimales(totales,2);                    
                    total=totales+"";
                    iepsval=numerosComoArray[6];
                    descuentoprod=numerosComoArray[7];                    
                    if(descuento>0){//viene descuento de todo el producto se hace descuento a cada producto
                        descuentoprod=descuento+"";
                    }
                    
                    descuentosss=(totales*Double.parseDouble(descuentoprod)/100);
                    descuentoprod=descuentosss+"";     
                    
                    
                    //System.out.println(numerosComoArray[i]);
                    
                    //System.out.println(numerosComoArray[i]);
                }
                //SQL = "insert into to_ventas (idproducto,cantidad,precio,total,folio,fecha_mov) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"',now())";
                //stmt.executeUpdate(SQL);
                descuentototal=descuentototal+descuentosss;
                SQL = "insert into to_ventas (idproducto,cantidad,precio,total,folio,fecha_mov,ieps,descuento) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"',now(),"+iepsval+","+descuentoprod+")";
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
           
            if(descuentototal>0){
                SQL = "update to_folios set descuento='"+descuentototal+"' where no_folio='"+folio+"'";
                stmt.executeUpdate(SQL);
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
                ticketpdf.imprimirticket(folio+"","IMPPVT");
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

public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }


public void valida_inventario_fisico(String idprod,String cantidad){
    //VALIDAR SI YA ESTA REGISTRADO EN EL INVENTARIO 
    conex cn = new conex();    
    String sql="SELECT idr_prod_inv from to_inventariofisico where idr_prod_inv='"+idprod+"'";
    System.out.println(sql);
    PreparedStatement pstm100;
    try {
        pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
        ResultSet rs100 = (ResultSet) pstm100.executeQuery();
        Statement stmt = cn.getConnection().createStatement();
        if (rs100.next()) {
    		    	String SQL2 = "insert into to_inventariofisico (idr_prod_inv,cantidad,fecha_inventario,usuario_inventario) values ('"+idprod+"','-"+cantidad+"',now(),'"+accesoSistema.nombreuser+"')";               
                        System.out.println(SQL2);
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


public float obtenpreciocompra(String id){
 float precio=0;
     conex cn = new conex();    
    String sql="SELECT precio_compra from tc_productos where idproducto='"+id+"'";    
    PreparedStatement pstm100;
    try {
        pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
        ResultSet rs100 = (ResultSet) pstm100.executeQuery();
        Statement stmt = cn.getConnection().createStatement();
        if (rs100.next()) {
            precio=rs100.getFloat(1);
        }
        rs100.close();
        pstm100.close();
        stmt.close();
        cn.desconectar();
    } catch (SQLException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
    }
 
 return precio;
}
}
