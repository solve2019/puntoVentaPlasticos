package administracionFacturas;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.*;
import java.io.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.*;
import java.math.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.cert.X509Certificate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.axis.types.NonNegativeInteger;
import org.apache.axis.types.PositiveInteger;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.ssl.PKCS8Key;
import org.apache.xerces.parsers.DOMParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

//IMPORT CREAR SELLO CFDI
//IMPORTAMOS CLASES PARA CREAR ARCHIVO TXT

/**
 * Sample code to call the FedEx Ship Service
 * <p>
 * com.fedex.ship.stub is generated via WSDL2Java, like this:<br>
 * <pre>
 * java org.apache.axis.wsdl.WSDL2Java -w -p com.fedex.ship.stub http://www.fedex.com/...../ShipService?wsdl
 * </pre>
 *
 * This sample code has been tested with JDK 5 and Apache Axis 1.4
 */
//
//Sample code to call the FedEx Ship Service - Domestic Express


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Desarrollo
 */


public final class Facturacion{
 private static final long serialVersionUID = 1L;
  public static String contendor="";

  /*contendor*/
    public Facturacion() {
        // TODO Auto-generated constructor stub
    }


  
  
  
// ###  METODOS PARA CREAR EL SELLO A PARTIR DE DE LOS ARCHIVOS DE CLAVE PUBLICA
  /**
         * Obtiene el sello digital aplicando una codificacion MD5WithRSA a la cadena original.
         * @param cadena_original Cadena original.
         * @param clave_privada Clave privada.
         * @param cert_publico Ruta a la llave publica. (key file).
         * @return Cadena con el sello digital.
         */
        public String getSelloDigital(String cadena_original, String clave_privada, String cert_publico){
            System.out.println(""+cadena_original+" "+clave_privada+"  "+cert_publico);
                String sello_digital = "";
                        try {
                                if(cadena_original == null || cadena_original.isEmpty()){
                                        throw new Exception("Error: El valor de la cadena orginal no puede ser nulo.");
                                }else if(clave_privada == null || clave_privada.isEmpty()){
                                        throw new Exception("Error:  Por favor especifique la clave privada.");
                                }else if(cert_publico == null || cert_publico.isEmpty()){
                                        throw new Exception("Error: Por favor especifique la ruta del certificado publico.");
                                }
                                sello_digital = this.EncodeMD5RSA(cadena_original, clave_privada, cert_publico);
                                
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                return sello_digital;
        }
        
        /**
         * Realiza el proceso de codificar la cadena original con el algoritmo MD5WithRSA.
         * @param cadena_original Cadena original.
         * @param clave_privada Clave privada.
         * @param cert_publico Ruta donde se encuentra el certificado publico (key).
         * @return Regresa la cadena codificada en MD5 y RSA.
         */
        private String EncodeMD5RSAOKV32(String cadena_original, String clave_privada, String cert_publico){
                FileInputStream fin = null;             

                try
                {
                    System.out.println(""+cert_publico+" "+clave_privada);
                    fin = new FileInputStream (cert_publico);
                        
                    PKCS8Key pkcs8 = new PKCS8Key(fin, clave_privada.toCharArray());
                        //System.out.println(pkcs8);
                        //obtiene clave privada
                        java.security.PrivateKey pk = pkcs8.getPrivateKey();    //Correcto

                        //to md5 & rsa
                        Signature firma = Signature.getInstance("SHA1withRSA");//MD5withRSA 
                        firma.initSign(pk); 
                        
                        //pasamos firma original
                        firma.update(cadena_original.getBytes("UTF-8")); 
                        
                        //cadena encriptada
                        byte[] cadenaFirmada = firma.sign(); 

                        //sello digital
                        String selloDigital = new String(Base64.encodeBase64(cadenaFirmada)); 
        
                        return selloDigital;

                }catch (FileNotFoundException e)
                {
                        System.err.println ("Error: el archivo '" + cert_publico + "' no fue encontrado. ");
                        e.printStackTrace();
                }
                catch(Exception e){
                        System.err.println("Error: problema fue encontrado durante la codificacion.");
                        e.printStackTrace();
                }
                finally {
                        try {
                                fin.close();
                        }
                        catch(Exception ex) {
                        }
                }
                return null;
        }
        
        
        
        private String EncodeMD5RSA(String cadena_original, String clave_privada, String cert_publico){
            FileInputStream fin = null;             
                System.out.println("cadena SHA-RSA"+cadena_original);
                try
                {
                    System.out.println(""+cert_publico+" "+clave_privada);
                    fin = new FileInputStream (cert_publico);
                        
                    PKCS8Key pkcs8 = new PKCS8Key(fin, clave_privada.toCharArray());
                        //System.out.println(pkcs8);
                        //obtiene clave privada
                        java.security.PrivateKey pk = pkcs8.getPrivateKey();    //Correcto

                        //to md5 & rsa
                        Signature firma = Signature.getInstance("SHA256withRSA");//MD5withRSA 
                        firma.initSign(pk); 
                        
                        //pasamos firma original
                        firma.update(cadena_original.getBytes("UTF-8")); 
                        
                        //cadena encriptada
                        byte[] cadenaFirmada = firma.sign(); 

                        //sello digital
                        String selloDigital = new String(Base64.encodeBase64(cadenaFirmada)); 
        
                        return selloDigital;

                }catch (FileNotFoundException e)
                {
                        System.err.println ("Error: el archivo '" + cert_publico + "' no fue encontrado. ");
                        e.printStackTrace();
                }
                catch(Exception e){
                        System.err.println("Error: problema fue encontrado durante la codificacion.");
                        e.printStackTrace();
                }
                finally {
                        try {
                                fin.close();
                        }
                        catch(Exception ex) {
                        }
                }
                return null;
            
            
            
            
            /*String sello="";
            FileInputStream fin = null;     
                Signature signature;
                try {
                      fin = new FileInputStream (cert_publico);
                    PKCS8Key pkcs8 = new PKCS8Key(fin, clave_privada.toCharArray());
                    java.security.PrivateKey key = pkcs8.getPrivateKey();    //Correcto
                    signature = Signature.getInstance("SHA256withRSA");
                    signature.initSign(key);
                    byte[] bytescadena=cadena_original.getBytes("UTF-8");
                    signature.update(bytescadena);
                    byte[] bytesSigned = signature.sign();
                    byte[] bytesEncoded = Base64.encodeBase64(bytesSigned);
                    sello=new String(bytesEncoded);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                } catch (GeneralSecurityException ex) {
         Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
     } catch (IOException ex) {
         Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
     }
               
            return sello;*/
        }
        
        /** Regresa el certificado representado como una cadena de caracteres.
         * @param cer_file Ruta al archivo del certificado (cer file).
         * @return Regresa el certificado.
         */
        public String getCertificado(String cer_file){
                String certDigital = null;
                X509Certificate cert = null;

                FileInputStream fis = null;
                ByteArrayInputStream bais = null;
                try {
                        fis = new FileInputStream(cer_file);
                        byte value[] = new byte[fis.available()];
                        fis.read(value);
                        bais = new ByteArrayInputStream(value);
                        java.security.cert.CertificateFactory cf = java.security.cert.CertificateFactory.getInstance("X.509");
                        cert = (X509Certificate)cf.generateCertificate(bais);
                        certDigital = new String(Base64.encodeBase64(cert.getEncoded())); 
                        
                }catch (FileNotFoundException e)
                {
                        System.err.println ("Error: el archivo '" + cer_file + "' no fue encontrado. ");
                        e.printStackTrace();
                }
                catch(Exception e){
                        System.err.println("Error: problema al leer el certificado publico.");
                        e.printStackTrace();
                }
                finally {
                        try {
                                fis.close();
                                bais.close();
                        }
                        catch(Exception ex) {
                        }
                }
                return certDigital;
        }

    private void Genera_CodigoQR(String noFactura, String rfcEmisor, String rfcRecetor, String totalAmout) throws IOException, WriterException {
        
        //INICIA OBTENER DATOS DEL ARCHIVO XML GENERADO CON EL WEB SERVICE DE INVOICE ONE
        String total=totalAmout, UUID="", rfc_emosor=rfcEmisor, rfc_receptor=rfcRecetor;
        
                String sFichero = "C:/factura/CXCXML/"+noFactura+".xml";
                File fichero = new File(sFichero);
                if (fichero.exists()){
                                    // Creamos el parseador  
                                    DOMParser parser = new DOMParser();  
                                                 try {
                                                     // Procesamos el fichero XML  
                                                     //parser.parse(new InputSource(new FileInputStream("C:/factura/CXCXML/algo.xml")));
                                                     parser.parse(new InputSource(new FileInputStream("C:/factura/CXCXML/"+noFactura+".xml")));
                                                 } catch (SAXException ex) {
                                                     Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
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
                                              System.out.println(nodo.getAttributes().getNamedItem("UUID").getTextContent());
                                              /*
                                               try {
                                                    conexion conn;
                                                    conn = new conexion();
                                                    PreparedStatement pstm;
                                                    pstm = (PreparedStatement) conn.getConnection().prepareStatement("update cuentascobrar set uuid='"+UUID+"' where Id_cuenta="+noFactura);
                                                    pstm.executeUpdate();
                                                    pstm.close();
                                                    conn.desconectar();

                                                } catch (SQLException ex) {
                                                    Logger.getLogger(Facturacion.class.getName()).log(Level.SEVERE, null, ex);
                                                }*/
                       
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
        String filePath = "C:/factura/CXCXML/"+noFactura+".png";
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

