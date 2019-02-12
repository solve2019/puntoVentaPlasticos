/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaserial;
import giovynet.nativelink.SerialPort;
import giovynet.serial.Baud;
import giovynet.serial.Com;
import giovynet.serial.Parameters;
import java.util.List;

/**
 *
 * @author SOLVEMORELOS
 */
public class Puertoserial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        /*
        //Definición de parametros
        Parameters settings = new Parameters();
        //definición del puerto que se va a utilizar
        settings.setPort("COM8");
        settings.setBaudRate(Baud._9600);
        //asignamos los parametros al objeto com1
        Com com1 = new Com(settings);        
        com1.sendSingleData("P");               
        Thread.sleep(30);                                                          
        String pesoval="";
        for(int i=0;i<12;i++){
            //System.out.println("val: "+com1.receiveSingleChar());
            char value=com1.receiveSingleChar();
            if (Character.isDigit(value)){ //evalua si es numero
                pesoval=pesoval+value;
            }
            String caract=value+"";
            if(caract.equals(".")){  //evalua si es un punto
                pesoval=pesoval+value;
            }            
            Thread.sleep(30);
        }              
        pesoval=pesoval.trim();        
        System.out.println("pesoval: "+pesoval.trim());        
        com1.close();    */           
        
        
        //Definición de parametros
        Parameters settings = new Parameters();
        //definición del puerto que se va a utilizar
        settings.setPort("COM8");
        settings.setBaudRate(Baud._9600);
        //asignamos los parametros al objeto com1
        Com com1 = new Com(settings);        
        int contador = 0 ;
        do {              
              com1.sendSingleData("P");               
              Thread.sleep(60);                                                          
              String pesoval="";
              for(int i=0;i<12;i++){
                  //System.out.println("val: "+com1.receiveSingleChar());
                  char value=com1.receiveSingleChar();
                  if (Character.isDigit(value)){ //evalua si es numero
                      pesoval=pesoval+value;
                  }
                  String caract=value+"";
                  if(caract.equals(".")){  //evalua si es un punto
                      pesoval=pesoval+value;
                  }            
                  Thread.sleep(40);
              }              
              pesoval=pesoval.trim();        
              System.out.println("pesoval: "+pesoval.trim());                      
              Thread.sleep(500);
        } while (contador<10);
        com1.close();               
        System.out.println("salir");
        
        
        
    }
    
}
