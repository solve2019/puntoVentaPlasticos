/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Admin
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class AgregarServiciosFactura {
    private static final long serialVersionUID = 1L;   
    DecimalFormat df = new DecimalFormat("#.##");

 
    public AgregarServiciosFactura() {
        // TODO Auto-generated constructor stub
    }
    
        
        public boolean generarfactura(int idcliente,String patharchivos,int numeroFactSig,String correo,String cliente,String tipopagocliente,String no_folio){
            boolean valor=true;
            int idclientes=idcliente; 
            String valorRetornado="";           
            
            
            
                GenerarFactura Obj = new GenerarFactura();
                try {
                        valorRetornado = Obj.GenerarFacturaCliente(idclientes, numeroFactSig,0,2,patharchivos,correo, cliente,tipopagocliente,no_folio);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                
                if(valorRetornado.equals("Factura generada correctamente")){
                   valor=true;
                }else{
                  valor=false;
                } 
                
            return valor;
       }
        
            
      
    
}



