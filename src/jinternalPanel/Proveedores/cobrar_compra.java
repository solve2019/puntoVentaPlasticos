/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jinternalPanel.Proveedores;
import ClasesDAO.*;
import conexion.conex;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import puntoventa.RemisionPDF;
/**
 *
 * @author desarrollo8
 */
public class cobrar_compra {
    
    
    
    
    public boolean cobrarCompra(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String referenciamixto,String formadescuento,String proveedor){        
        
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
           String SQL = "select * from to_parametros where clave='FOLIOCOMRA'";
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
           
           
           
           if(formaPago.equals("EFECTIVO")){
           String provee=proveedor;
           if(provee.equals("Selecciona..")){//no tiene proveedor
               SQL = "INSERT INTO proveedor_to_compra (FolioCompra, monto_compra, fecha_registro, usuario_registro) " +
                         "VALUES ('"+folio+"', "+monto+", now(),'"+accesoSistema.nombreuser+"')";
           }else{//si tiene proveedor
               String[] arrayclave = provee.split("-");
               String prov = arrayclave[0];            
               SQL = "INSERT INTO proveedor_to_compra (FolioCompra, monto_compra, fecha_registro, usuario_registro,IdProveedor) " +
                         "VALUES ('"+folio+"', "+monto+", now(),'"+accesoSistema.nombreuser+"','"+prov+"')";
           }               
           //System.out.println(""+SQL);
           stmt.executeUpdate(SQL);           
           SQL="update to_cierre_caja set compras=(compras+"+monto+") where id_cierre_caja ='1'";
           System.out.println(""+SQL);
           stmt.executeUpdate(SQL);            
           }
           
           
           //SQL="update to_cierre_caja set no_ventas=(no_ventas+1) where id_cierre_caja ='1'";
           //stmt.executeUpdate(SQL); 
           
           SQL = "update to_parametros set parametro='"+folio+"' where clave='FOLIOCOMRA'";
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
                }
                SQL = "insert into proveedor_tc_compraprod (idprod,cantidad,precio,total,IdFolioCompra) values('"+id+"','"+cantidad+"','"+precio+"','"+total+"','"+folio+"')";
                System.out.println(""+SQL);
                stmt.executeUpdate(SQL);
                SQL = "update tc_productos set precio_compra='"+precio+"', existencia=(existencia+"+cantidad+") where idproducto='"+id+"'";                
                stmt.executeUpdate(SQL);                
                SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+id+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','INGRESO')";
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
               
               int response = JOptionPane.showConfirmDialog(null, "Desea imprimir el ticket de compra?", "Confirmar",
               JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
               if (response == JOptionPane.YES_OPTION) {                   
                  /*TicketCompra ticketpdf=new TicketCompra();
                  String tipoimpresion=ticketpdf.tipoimpresion();
                  if(tipoimpresion.equals("PDF")){
                    ticketpdf.imprimirticket(folio+"");
                  }else{
                    
                  }*/
                  
                  String[] opcion={"ticket","tamaño carta"};
                  String resp=(String) JOptionPane.showInputDialog(null,"Selecciona la forma de impresión","Opcion de impresion",JOptionPane.DEFAULT_OPTION,null,opcion,opcion[0]);
                  
                  
                  if(resp.equals("ticket")){
                    TicketProveedor imprime=new TicketProveedor();                    
                    imprime.ReImprimirPago(folio+"");
                    imprime.ReImprimirPago(folio+"");
                  }else{
                    RemisionPDF compraas=new RemisionPDF();
                    compraas.imprimirPDFCompra(folio+"");
                  }
                  
                  
               }
    
               
           }
           JOptionPane.showMessageDialog(null, "Se realizo el registro de compra correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
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
    


public boolean cobrarcreditocliente(double monto, float pagoefectivo, String referenciabanco,String formaPago,ArrayList productos,String impresionticket,double descuento,String idcliente){
        
        
        double resultdescuento = (descuento * monto)/100;            
        monto=(float) (monto-resultdescuento);
        
       boolean valida=true;
       String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
       //  Database credentials
       String USER = conex.login;
       String PASS = conex.password; 
       String DB_URL = "jdbc:mysql://localhost/"+conex.bd;
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
           SQL = "INSERT INTO to_folios (no_folio, monto_total, efectivo, tarjeta,referencia_tarjeta, monto_puntos, no_puntos, fecha_movimiento,usuario_registro,tipo_movimiento,forma_pago,id_usuario,descuento,iva) " +
                         "VALUES ('"+folio+"', "+monto+", 0, 0, '"+referenciabanco+"', 0, 0, now(),'"+accesoSistema.nombreuser+"','VENTA','CREDITO','"+accesoSistema.iduser+"','"+resultdescuento+"','"+iva+"')";
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
                SQL = "update tc_productos set existencia=(existencia-"+cantidad+") where idproducto='"+id+"'";
                //System.out.println(""+SQL);
                stmt.executeUpdate(SQL);
                
                SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+id+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','SALIDA')";
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
               Ticket imprime=new Ticket();
               //imprime.ImprimirDocumento(folio+"",accesoSistema.nombreuser,monto,productos,dateFormat.format(date));
               imprime.ReImprimirDocumento(folio+"");
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




    
}
