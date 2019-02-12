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
import javax.swing.JOptionPane;
/**
 *
 * @author desarrollo8
 */
public class Devoluciones {
    public boolean devolucion(String idventa, float cantidad){
     double iva=obteniva();
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
           String idprod="";
           float preciorestar=0;
           double ivaprod=0;
           String SQL = "select idproducto,folio,precio from to_ventas where idventa='"+idventa+"'";
           ResultSet rs=null;
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {  
            idprod=rs.getString("idproducto");
            folio=rs.getInt("folio");
            preciorestar=rs.getFloat("precio");
           }
           String formapago="";
           SQL = "select forma_pago from to_folios where no_folio='"+folio+"'";
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {  
               formapago=rs.getString("forma_pago");
           }          
           rs.close();
           preciorestar=preciorestar*cantidad;//se resta al monto total del ticket
           ivaprod=preciorestar*iva;
           SQL = "update tc_productos set existencia=(existencia+"+cantidad+") where idproducto='"+idprod+"'";  
           stmt.executeUpdate(SQL);  
           
           SQL = "update to_ventas set cantidad=(cantidad-"+cantidad+") where idventa='"+idventa+"'";  
           stmt.executeUpdate(SQL);  
           
           SQL = "update to_folios set iva=iva-"+ivaprod+", monto_total=(monto_total-"+preciorestar+") where no_folio='"+folio+"'";  
           stmt.executeUpdate(SQL);  
           if(!formapago.equals("CREDITO")){ 
                SQL="update to_cierre_caja set devoluciones=(devoluciones+"+(preciorestar+ivaprod)+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL); 
                if(!accesoSistema.nombrecaja.equals("")){
                    SQL = "update to_cierre_caja set devoluciones=(devoluciones+"+(preciorestar+ivaprod)+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                    stmt.executeUpdate(SQL);  
                }
           }
           SQL = "insert into to_folios (monto_total,fecha_movimiento,usuario_registro,tipo_movimiento,id_devolucion_venta,iva) values ('"+preciorestar+"',now(),'"+accesoSistema.nombreuser+"','DEVOLUCION','"+idventa+"','"+ivaprod+"')";  
           stmt.executeUpdate(SQL);
           
           SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+idprod+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','DEVOLUCION')";
           stmt.executeUpdate(SQL);  

           
           

           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
          
           JOptionPane.showMessageDialog(null, "Se realizo la devolución correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
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
        System.out.println("Goodbye!");
    
    
    
        return valida;
    }




public boolean devolucionfolio(String idventa, float cantidad){
    double iva=obteniva();
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
           String idprod="";
           double preciorestar=0;
           double ivaprod=0;
           double descuento=0;
           String idr_lote="0";
           String SQL = "select idproducto,folio,precio,descuento,idr_lote from to_ventas where idventa='"+idventa+"'";
           ResultSet rs=null;
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {  
            idprod=rs.getString("idproducto");
            folio=rs.getInt("folio");
            preciorestar=rs.getFloat("precio");            
            descuento=rs.getFloat("descuento");
            idr_lote=rs.getString("idr_lote");
            ivaprod=preciorestar*iva;
           }    
           String formapago="";
           SQL = "select forma_pago from to_folios where no_folio='"+folio+"'";
           rs=stmt.executeQuery(SQL);  
           while(rs.next()) {  
               formapago=rs.getString("forma_pago");
           }
           rs.close();
           preciorestar=(preciorestar*cantidad)-descuento;//se resta al monto total del ticket
           ivaprod=ivaprod*cantidad;//se resta al monto total del ticket
           SQL = "update tc_productos set existencia=(existencia+"+cantidad+") where idproducto='"+idprod+"'";  
           stmt.executeUpdate(SQL);  
           
           if(!idr_lote.equals("0")){
                SQL = "update farmacia_to_lotes set cantidad=(cantidad+"+cantidad+") where Id_lotes='"+idr_lote+"'";  
                stmt.executeUpdate(SQL);  
           }
           
           SQL = "update to_ventas set cantidad=(cantidad-"+cantidad+") where idventa='"+idventa+"'";  
           stmt.executeUpdate(SQL);  
                     
           if(!formapago.equals("CREDITO")){
                SQL="update to_cierre_caja set devoluciones=(devoluciones+"+(preciorestar+ivaprod)+") where id_cierre_caja ='1'";
                stmt.executeUpdate(SQL); 
                if(!accesoSistema.nombrecaja.equals("")){
                    SQL = "update to_cierre_caja set devoluciones=(devoluciones+"+(preciorestar+ivaprod)+") WHERE caja ='"+accesoSistema.nombrecaja+"'";        
                    stmt.executeUpdate(SQL);  
                }
                
           }
           SQL = "insert into to_folios (monto_total,fecha_movimiento,usuario_registro,tipo_movimiento,id_devolucion_venta,iva) values ('"+preciorestar+"',now(),'"+accesoSistema.nombreuser+"','DEVOLUCION','"+idventa+"','"+ivaprod+"')";  
           stmt.executeUpdate(SQL);
           
           SQL = "insert into th_inventarios_registrados (id_producto,cantidad_agregada,fecha,usuario_ajusto,tipo_mov) values ('"+idprod+"','"+cantidad+"',now(),'"+accesoSistema.nombreuser+"','DEVOLUCION')";
           stmt.executeUpdate(SQL);  

           
           

           //STEP 8: Commit data here.
           System.out.println("Commiting data here....");
           conn.commit();

               

           //STEP 10: Clean-up environment           
           stmt.close();
           conn.close();
           valida=true;
          
           //JOptionPane.showMessageDialog(null, "Se realizo la devolución correctamente.", "Alerta", JOptionPane.INFORMATION_MESSAGE);                
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
        System.out.println("Goodbye!");
    
    
    
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
