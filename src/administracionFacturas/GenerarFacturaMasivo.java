/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package administracionFacturas;



import ClasesDAO.Ticket;
import Utilerias.funciones;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import conexion.conex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;




/**
 *
 * @author JOSE ANTUNEZ ROGEL
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class GenerarFacturaMasivo {
    
    private static final long serialVersionUID = 1L;
 
    public GenerarFacturaMasivo() {
        // TODO Auto-generated constructor stub
        
    }
    
   
    
            public String GenerarFacturaClienteMasivo(int numeroEmp,int numeroFac, int serieFac, int band,String patharchivos,String correo,String cliente,String tipopagocliente,ArrayList Folios) throws IOException{
            String noEmpresa="", rfcEmisor_="", rfcReceptor_="", totalAmout="";
            String valorRetornado="";
            noEmpresa=""+numeroEmp;
            String cadena_lineal="", sello="", certificado="", noCertificado="", fechaGenera="", noFactura="", noCuenta="", metodoPago="", 
            formaPago="", folio="";
            String codigobarras="";
            String clave_privada="";
            float costotarjeta=0;
            // ### INICIA GENERACION DE CADENA LINEAL CON DATOS DE FACTURACION              GENERACION DE CADENA LINEAL 
            String desgloseServ="", fechaGeneracion="", rfcReceptor="", calle="", pais="", descEmpresa="";
            double montoTotal=0, SubTotal=0,descuento=0;
            DecimalFormat df = new DecimalFormat("0.00"); 
            cadena_lineal="";
            

            //INICIA AQUI SE REALIZA DE REASIGNACION DE MONTO A LA NUEVA FACTURA QUE SERA GENERADA DESDE LA REMISION
            conex conn;
            conn = new conex();
            PreparedStatement pstm;
            PreparedStatement pstm1;

            //TERMINA AQUI SE REALIZA DE REASIGNACION DE MONTO A LA NUEVA FACTURA QUE SERA GENERADA DESDE LA REMISION

          // ### TERMINA GENERACIÓN DE CADENA LINEAL CON DATOS DE FACTURACION             GENERACION DE CADENA LINEAL
            try
              {
                  File archivo=new File(patharchivos+"cadenalineal.txt");
                  FileWriter escribir=new FileWriter(archivo,true);


                  try {
                   pstm = (PreparedStatement) conn.getConnection().prepareStatement("select FechaGeneracion, Monto,factura,noCuenta,MetodoPago,FormaPagos,subtotal,iva from to_facturas where factura="+numeroFac);
                   ResultSet rs = (ResultSet) pstm.executeQuery();
                      while (rs.next()) {
                          fechaGeneracion=rs.getString("FechaGeneracion");
                          montoTotal=rs.getFloat("Monto");
                          descuento=0;
                          folio=rs.getString("factura");
                          noCuenta=rs.getString("noCuenta");
                          metodoPago=rs.getString("MetodoPago");
                          formaPago=rs.getString("FormaPagos");
                          SubTotal=rs.getFloat("subtotal");                          
                          }
                          rs.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  metodoPago=tipopagocliente;
                  noFactura=folio;
                  if(noCuenta.equals("")){
                      noCuenta="0000";
                  }

                  try {  
                        pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from tc_clientes where idcliente='"+noEmpresa+"'");
                        ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {
                            rfcReceptor=rs.getString("rfc");
                            calle=rs.getString("calle");
                            pais=rs.getString("pais");
                            descEmpresa=rs.getString("razon_social");
                        }
                        rs.close();
                  } catch (SQLException ex) {
                      Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  StringTokenizer tokens = new StringTokenizer(fechaGeneracion," ");
                  String ano="", mes="";
                  while(tokens.hasMoreTokens()){
                    ano=tokens.nextToken();
                    mes=tokens.nextToken();
                  }
                  
                  StringTokenizer tokens2 = new StringTokenizer(mes,".");
                  String hora="", basura="";
                  while(tokens2.hasMoreTokens()){
                    hora=tokens2.nextToken();
                    basura=tokens2.nextToken();
                  }
                  funciones utileria=new funciones();            
                  double paramiva=utileria.obteniva();
                  String id=null;                 
                  String subtotalparseado=df.format(SubTotal);
                  subtotalparseado = subtotalparseado.replace(",",".");
                  //String totalparseado=df.format((SubTotal+(SubTotal*.16)));
                  String totalparseado=df.format((SubTotal+(SubTotal*paramiva)));
                  totalparseado = totalparseado.replace(",",".");
                  //String ivaparseado=(df.format(SubTotal*.16));
                  String ivaparseado=(df.format(SubTotal*paramiva));
                  ivaparseado = ivaparseado.replace(",",".");
		  if ( band==2 ){
                    System.out.println("Consultar VENTA DE ARTICULOS");
                    String preciounitario=df.format(SubTotal);   
                    //desgloseServ=desgloseServ+"1"+"|NA|OPERACION CON EL PUBLICO EN GENERAL|"+subtotalparseado+"|"+subtotalparseado+"|";
                    
                    //IVA DEL PRODUCTO  NUEVO VERSION CFDI3.3 2017-11-15
                    desgloseServ=desgloseServ+"01010101|";  //ClaveProdServ
                    desgloseServ=desgloseServ+"001|";  //NoIdentificacion
                    desgloseServ=desgloseServ+"1|";  //Cantidad
                    desgloseServ=desgloseServ+"ACT|";  //ClaveUnidad
                    desgloseServ=desgloseServ+"Pieza|";  //Unidad
                    desgloseServ=desgloseServ+"Venta|";  //Descripcion
                    desgloseServ=desgloseServ+preciounitario+"|";  //ValorUnitario
                    desgloseServ=desgloseServ+subtotalparseado+"|";  //Importe
                    desgloseServ=desgloseServ+"0.00|";  //Descuento
                    
                    //IVA DEL PRODUCTO  NUEVO VERSION CFDI3.3 2017-11-15
                    double ivaprod=Float.parseFloat(subtotalparseado)*0.16;
                    desgloseServ=desgloseServ+subtotalparseado+"|";  //Base
                    desgloseServ=desgloseServ+"002|";  //Impuesto
                    desgloseServ=desgloseServ+"Tasa|";  //TipoFactor
                    desgloseServ=desgloseServ+"0.160000|";  //TasaOCuota
                    desgloseServ=desgloseServ+ivaparseado+"|";  //Importe    
                    
                    
                    /*System.out.println("select idproducto, to_ventas.cantidad, precio, total, codigo_venta,tarjeta from to_ventas,to_folios,to_facturas where to_ventas.Tipoventa=to_folios.tipo_venta and to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+numeroFac+"' and to_ventas.Tipoventa='Factura'");
                    try {                     
                     pstm = (PreparedStatement) conn.getConnection().prepareStatement("select idproducto, to_ventas.cantidad, precio, total, codigo_venta,tarjeta from to_ventas,to_folios,to_facturas where to_ventas.Tipoventa=to_folios.tipo_venta and to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+numeroFac+"'");
                     ResultSet rs = (ResultSet) pstm.executeQuery();                    
                        while (rs.next()) {                          
                          String costocliente=df.format(rs.getDouble("total"));
                                                                    
                          preciounitario=preciounitario.replace(",", ".");                          
                          //desgloseServ=desgloseServ+rs.getString("cantidad")+"|CANT|PZA|"+preciounitario+"|"+costocliente+"|";                          
                                                    
                          codigobarras=rs.getString("codigo_venta");
                          costotarjeta=rs.getFloat("tarjeta");
                        }
                            rs.close();
                    } catch (SQLException ex) {                        
                        System.out.println(ex);
                    }*/
                    
                          //desgloseServ=desgloseServ+"1|CANT|PZA|"+subtotalparseado+"|"+subtotalparseado+"|";
                          //SubTotal=SubTotal; 
                       
                  }
                  SubTotal=SubTotal-descuento;
                  totalAmout=""+(SubTotal); //se agrego la resta del descuento para el calculo del iva
                  
                  
                  String razonsocialemisor="", paisemisor="",cpemisor="",lugarexpedicionemisor="",estadoemisor="",ciudademisor="",coloniaemisor="",calleemisor="";
                  String ivaemisor="",RegimenFiscal="";
                  try {                     
                     pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from to_datos_facturacion where id_datos=1");
                     ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {                                                    
                            clave_privada = rs.getString("clave_privada").trim();        
                            rfcEmisor_=rs.getString("rfc").trim();
                            noCertificado=rs.getString("nocertificado").trim();
                            razonsocialemisor=rs.getString("razonsocial").trim();
                            paisemisor=rs.getString("pais").trim();
                            cpemisor=rs.getString("cp").trim();
                            lugarexpedicionemisor=rs.getString("lugarexpedicion").trim();
                            estadoemisor=rs.getString("estado").trim();
                            ciudademisor=rs.getString("ciudad").trim();
                            coloniaemisor=rs.getString("colonia").trim();
                            calleemisor=rs.getString("calle").trim();                                                        
                            ivaemisor=rs.getString("iva").trim();  
                            RegimenFiscal=rs.getString("RegimenFiscal").trim();                                                        
                        }
                        rs.close();
                    } catch (SQLException ex) {                        
                        System.out.println(ex);
                    }
                  
                  System.out.println("ciudademisor:   "+ciudademisor);
                  
                  //rfcEmisor_="KSL140218398";
                  //rfcEmisor_="SARJ740708R22";
                  rfcReceptor_=rfcReceptor;
                  //desgloseServ=desgloseServ+"IVA|"+ivaemisor+"|"+ivaparseado+"||";
                  
                  
                  
                  /*cadena_lineal=cadena_lineal+ano+"T"+hora+"|ingreso|"+formaPago.trim()+"|"+(subtotalparseado)+"|0.00|"+(totalparseado)
                          +"|"+metodoPago.trim()+"|"+lugarexpedicionemisor+"|"+noCuenta+"|"+rfcEmisor_+"|"+razonsocialemisor+"|"+calleemisor+"|"+coloniaemisor+"|"+ciudademisor+"|"+estadoemisor+""+
                          "|"+paisemisor+"|"+cpemisor+"|PERSONA MORAL|"+rfcReceptor.trim()+"|"+descEmpresa.trim()+"|"+calle.trim()+"|"+pais.trim()+"|";
                  cadena_lineal=cadena_lineal+desgloseServ;*/
                  
                  cadena_lineal="||3.3|";   //VERSION
                  //cadena_lineal=cadena_lineal+ ""+codigobarras+"|";  //FOLIO
                  cadena_lineal=cadena_lineal+ano+"T"+hora+"|";  //FECHA
                  cadena_lineal=cadena_lineal+metodoPago.trim()+"|";  //FormaPago
                  cadena_lineal=cadena_lineal+noCertificado+"|";  //NoCertificado
                  //cadena_lineal=cadena_lineal+"00001000000404523692|";  //NoCertificado
                  cadena_lineal=cadena_lineal+"CONTADO|";  //CondicionesDePago
                  cadena_lineal=cadena_lineal+subtotalparseado+"|";  //SubTotal
                  cadena_lineal=cadena_lineal+"0.00|";  //Descuento
                  cadena_lineal=cadena_lineal+"MXN|";  //Moneda
                  cadena_lineal=cadena_lineal+totalparseado+"|";  //Total
                  cadena_lineal=cadena_lineal+"I|";  //TipoDeComprobante
                  cadena_lineal=cadena_lineal+"PUE|";  //MetodoPago
                  cadena_lineal=cadena_lineal+cpemisor+"|";  //LugarExpedicion                  
                  
                  cadena_lineal=cadena_lineal+rfcEmisor_+"|";  //RFC EMISOR
                  cadena_lineal=cadena_lineal+razonsocialemisor+"|";  //NOMBRE EMISOR
                  cadena_lineal=cadena_lineal+RegimenFiscal+"|";  //RegimenFiscal EMISOR
                  
                  cadena_lineal=cadena_lineal+rfcReceptor+"|";  //RFC RECEPTOR
                  cadena_lineal=cadena_lineal+descEmpresa+"|";  //NOMBRE RECEPTOR
                  cadena_lineal=cadena_lineal+"P01|";  //UsoCFDI RECEPTOR
                  
                  //se agregan todos los productos a la cadena lineal
                  cadena_lineal=cadena_lineal+desgloseServ;
                  
                  //se agregareltotal de impuestos de todos los productos 2017-11-15  cfdi 3.3                  
                  String totalImpuestos="002|";  //Impuesto
                  totalImpuestos=totalImpuestos+"Tasa|"; //TipoFactor
                  totalImpuestos=totalImpuestos+"0.160000|"; //TasaOCuota
                  totalImpuestos=totalImpuestos+ivaparseado+"|"; //Importe
                  totalImpuestos=totalImpuestos+ivaparseado+"||"; //TotalImpuestosTrasladados
                  
                  cadena_lineal=cadena_lineal+totalImpuestos;
                  
                  
                  
                  
                  
                  
                  fechaGenera=ano+"T"+hora;
                  //Escribimos en el archivo con el metodo write 
                  escribir.write(cadena_lineal);
                  //Cerramos la conexion
                  escribir.close();
                  System.out.println("cadena_lineal: "+cadena_lineal);
              }catch(Exception e)
              {
                  //Si existe un problema al escribir cae aqui
                  System.out.println("Exception: "+e);
              }
          // ### TERMINA GENERACIÓN DE CADENA LINEAL CON DATOS DE FACTURACION             GENERACION DE CADENA LINEAL

                System.out.println("inicia facturacion");
          // ### INICIA GENERACION DE SELLO DIGITAL Y CERTIFICADO APARTIR DE ARCHIVOS     SELLO DIGITAL Y CERTIFICADO
                  Facturacion obj = new Facturacion();
                  String cadena_original="", cert_publico="", origen_cer="";

                  //  cadena_original Cadena original.
                  //  clave_privada Clave privada.
                  //  cert_publico Ruta a la llave publica. (key file).
                  cadena_original = cadena_lineal;
                  //clave_privada = "Sell0k0Nn3n2014";                  
                  //clave_privada = "Mileni29";              //salazar7407    
                  //cert_publico = patharchivos+"CSD_Empresa\\CSD_SUCURSAL_KSL140218398_20140705_102913.key"; //ruta de archivos para desarrollo                  
                  cert_publico = patharchivos+"CSD_Empresa\\llave.key"; //ruta de archivos para desarrollo                  
                  //noCertificado = "00001000000304609708"; //CERTIFICADO DE KONNEN
                  //noCertificado = "00001000000202545310"; //CERTYIFICADO DE JOSE ANTUNEZ

                  sello = obj.getSelloDigital(cadena_original, clave_privada, cert_publico); 
                  //origen_cer = patharchivos+"CSD_Empresa\\00001000000304609708.cer"; //ruta para archivos de desarrollo                                    
                  origen_cer = patharchivos+"CSD_Empresa\\certificado.cer"; //ruta para archivos de desarrollo                                    
                  certificado = obj.getCertificado(origen_cer);
                  
                  System.out.println("Cadena original: "+cadena_original);
                  System.out.println("Sello: "+sello);
                  System.out.println("Certificado: "+certificado);
                  
          // ### TERMINA GENERACIÓN DE SELLO DIGITAL Y CERTIFICADO APARTIR DE ARCHIVOS    SELLO DIGITAL Y CERTIFICADO

          // ### INICIA GENERAR CFDI TIMBRADO                                             GENERAR CFDI TIMBRADO
                  GenerarCFDIMasivo obj_ = new GenerarCFDIMasivo();
                  System.out.println("Inicia generar CFDI Timbrado...");
                  
                  if ( band==1 ){
                     
                  }else if ( band==2 ){
                      valorRetornado = obj_.ConstruyeCFDIMasivo(sello, certificado, noCertificado, fechaGenera, noFactura, noEmpresa, noCuenta, metodoPago, formaPago, 2,patharchivos,correo);
                  }
                  
                 
          // ### TERMINA GENERAR CFDI TIMBRADO                                            GENERAR CFDI TIMBRADO
                  
                
                  if(valorRetornado.equals("")){
                      valorRetornado = "Factura generada correctamente";
                      for(int x=0;x<Folios.size();x++) {
                        System.out.println(Folios.get(x));
                            try {                      
                            pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_folios set Nofactura="+noFactura+" where no_folio='"+Folios.get(x)+"';");
                            pstm.executeUpdate();     
                           } catch (SQLException ex) {
                               Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                           }
                      }
                      try {
                          Genera_CodigoQR(noFactura, rfcEmisor_, rfcReceptor_, totalAmout,patharchivos);
                      } catch (WriterException ex) {
                          //Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
                      
                      String enviarcorreo="SI";
                      Ticket imprime=new Ticket();               
                      imprime.ImprimirVentaFacturaMasivo(codigobarras+"",formaPago,costotarjeta, noFactura,correo,cliente,numeroEmp+"",tipopagocliente,enviarcorreo);           
                      enviarcorreo="NO";
                      imprime.ImprimirVentaFacturaMasivo(codigobarras+"",formaPago,costotarjeta, noFactura,correo,cliente,numeroEmp+"",tipopagocliente,enviarcorreo);           
                  }else{
                      System.out.println("Exception la factura no pudo ser generada");
                      try {                      
                      pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_facturas set estatus=2, factura=0 where factura='"+numeroFac+"';");
                      pstm.executeUpdate();    
                      pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_parametros set parametro=parametro-1 where clave='FACTURA';");
                      pstm.executeUpdate();     
                     } catch (SQLException ex) {
                         Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                     }
                      JOptionPane.showMessageDialog(null, "La factura no se genero, Error: "+valorRetornado, "Error", JOptionPane.ERROR_MESSAGE);
                  }
                  
                  
              
                 return valorRetornado;    
        }
            
        private void Genera_CodigoQR(String noFactura, String rfcEmisor, String rfcRecetor, String totalAmout,String patharchivos) throws IOException, WriterException {
        
        //INICIA OBTENER DATOS DEL ARCHIVO XML GENERADO CON EL WEB SERVICE DE INVOICE ONE
        String total=totalAmout,  rfc_emosor=rfcEmisor, rfc_receptor=rfcRecetor;
        String FechaTimbrado="", UUID="", selloCFD="", noCertificadoSAT="", selloSAT="";
                String rutaimagen=patharchivos+"facturas_xml\\"+noFactura+".png";
                String sFichero = patharchivos+"facturas_xml\\"+noFactura+".xml"; //ruata de archivos para produccion
                System.out.println("ruta xml: "+sFichero);
                File fichero = new File(sFichero);
                if (fichero.exists()){
                                    // Creamos el parseador  
                                    DOMParser parser = new DOMParser();  
                                                 try {
                                                     // Procesamos el fichero XML                                                      
                                                     parser.parse(new InputSource(new FileInputStream(sFichero)));
                                                 } catch (SAXException ex) {
                                                     Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                                                 }
                                    // Obtenemos el objeto Document  
                                    Document doc = parser.getDocument(); 
                                    // Obtenemos la etiqueta raiz  
                                 
                                        /*NodeList listaNodosNS = doc.getElementsByTagNameNS("http://www.sat.gob.mx/cfd/3","Comprobante");  
                                        for(int i=0;i<listaNodosNS.getLength();i++){  
                                           Node nodo = listaNodosNS.item(i); 
                                           //System.out.println(listaNodosNS.item(i));
                                           if (nodo instanceof Element){  
                                              //System.out.println(nodo.getAttributes().getNamedItem("descripcion").getTextContent());  

                                              total=nodo.getAttributes().getNamedItem("total").getTextContent()+"";
                                              System.out.println(nodo.getAttributes().getNamedItem("total").getTextContent());
                                                                                                      
                                           }                         
                                        }*/  


                                        NodeList listaNodosNS = doc.getElementsByTagNameNS("http://www.sat.gob.mx/TimbreFiscalDigital","TimbreFiscalDigital");  
                                        for(int i=0;i<listaNodosNS.getLength();i++){  
                                           Node nodo = listaNodosNS.item(i); 
                                           //System.out.println(listaNodosNS.item(i));
                                           if (nodo instanceof Element){  

                                              UUID= nodo.getAttributes().getNamedItem("UUID").getTextContent()+"";
                                              FechaTimbrado=nodo.getAttributes().getNamedItem("FechaTimbrado").getTextContent();                                              
                                              selloCFD=nodo.getAttributes().getNamedItem("SelloCFD").getTextContent();
                                              noCertificadoSAT=nodo.getAttributes().getNamedItem("NoCertificadoSAT").getTextContent();
                                              selloSAT=nodo.getAttributes().getNamedItem("SelloSAT").getTextContent();
                                              
                                              
                                               try {
                                            	   conex conn;
                                                    conn = new conex();
                                                    PreparedStatement pstm;
                                                    pstm = (PreparedStatement) conn.getConnection().prepareStatement("update to_facturas set uuid='"+UUID+"', FechaTimbrado='"+FechaTimbrado+"', selloCFD='"+selloCFD+"', noCertificadoSAT='"+noCertificadoSAT+"', selloSAT='"+selloSAT+"' where factura="+noFactura);
                                                    pstm.executeUpdate();
                                                    pstm.close();
                                                    conn.desconectar();

                                                } catch (SQLException ex) {
                                                    Logger.getLogger(GenerarFacturaMasivo.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                       
                                           }                         
                                        }                        
                                        
                                 }//FIN DE VALIDACION DE FICHERO
        //TERMINA OBTENR DATOS DEL ARCHIVO XML GENERADO CON EL WEB SERVICE DE INVOICE ONE
                
        
        //INICIA AGREAGAR ESTRUCTURA DE MONTO TOTAL PARA CFDI A MOSTRAR EN EL CODIGO QR
        int error=0;
        String montoTotal="", enteros="", decimal="", enterosAdd="", decimalAdd=""; 

        montoTotal=total;
        StringTokenizer tokens=new StringTokenizer(montoTotal,".");
        while(tokens.hasMoreTokens()){
                enteros=tokens.nextToken();
                decimal=tokens.nextToken();
        }

        if(enteros.length()<10){
                for(int i=enteros.length();i<10;i++){
                        enterosAdd=enterosAdd+"0";
                }
                enterosAdd = enterosAdd+enteros;
        }else if(enteros.length()>10){
                error=1;
        }

        if(decimal.length()<6){
                for(int i=decimal.length();i<6;i++){
                        decimalAdd=decimalAdd+"0";
                }
                decimalAdd=decimal+decimalAdd;
        }else if(decimal.length()>6){
                for (int i=0;i<decimal.length();i++){
                        if(i<6){
                                decimalAdd=decimalAdd+decimal.charAt(i);
                        }
                }	   
        }

        if(error==1){
                System.out.println("Error en la generación de QR Code");
        }else{
                System.out.println("Resul: "+enterosAdd+" . "+decimalAdd);
        }
        //TERMINA AGREGAR ESTRUCTURA DE MONTO TOTAL PARA CFDI A MOSTRAR EN EL CODIGO QR       
        
        String qrCodeData = "?re="+rfc_emosor+"&rr="+rfc_receptor+"&tt="+enterosAdd+"."+decimalAdd+"&id="+UUID;
       // String filePath = "C:/factura/CXCXML/"+noFactura+".png"; //ruta de archivos para produccion
        String filePath = rutaimagen; //"C:/factura_desarrollo/CXCXML/"+noFactura+".png"; //ruta de archivos desarrollo 
        String charset = "UTF-8"; // or "ISO-8859-1"
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
        hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        createQRCode(qrCodeData, filePath, charset, hintMap, 100, 100);
    }
    
    public static void createQRCode(String qrCodeData, String filePath, String charset, Map hintMap, int qrCodeheight, int qrCodewidth) throws IOException, WriterException{
        BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
        MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
        System.out.println("Si entro...");
    }
}


