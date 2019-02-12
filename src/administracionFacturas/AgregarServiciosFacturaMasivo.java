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

public class AgregarServiciosFacturaMasivo {
    private static final long serialVersionUID = 1L;   
    DecimalFormat df = new DecimalFormat("#.##");

 
    public AgregarServiciosFacturaMasivo() {
        // TODO Auto-generated constructor stub
    }
    
        
        public boolean generarfacturaMasivo(int idcliente,String patharchivos,int numeroFactSig,String correo,String cliente,String tipopagocliente,ArrayList folios){
            boolean valor=true;
            int idclientes=idcliente; 
            String valorRetornado="";           
            
            
            
                GenerarFacturaMasivo Obj = new GenerarFacturaMasivo();
                try {
                        valorRetornado = Obj.GenerarFacturaClienteMasivo(idclientes, numeroFactSig,0,2,patharchivos,correo, cliente,tipopagocliente,folios);
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



