/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administracionFacturas;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.*;
import java.io.IOException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author desarrollo8
 */
public class CancelarFactura {
    public static String pathprocess2="",pathprocess="";
    
    public boolean cancelafactura(String factura){
    boolean validacancelacion=true;
    
    
    
    String PfxBase64="MIIMYQIBAzCCDCcGCSqGSIb3DQEHAaCCDBgEggwUMIIMEDCCBscGCSqGSIb3DQEH\n" +
"BqCCBrgwgga0AgEAMIIGrQYJKoZIhvcNAQcBMBwGCiqGSIb3DQEMAQYwDgQIwNxi\n" +
"ytHiBTwCAggAgIIGgPrj4vjB1DcYzIApuvGbjsRJz+fZELVimSysbjalo0ICHCuQ\n" +
"2zLAmNiHuRMhzJQ/56SyvPu6nNU7qfr2zxsQNCorNzc/kT9s82gaTRJtO2xRbpgP\n" +
"fhZDR6VdhN+vsN30SoKfXLabeRrOPZbNiALAIljaJCEbTArvEYvwr5hSXTqsAn7V\n" +
"LfsiXxfzytjiy5YYu6QCJL74pQ8G7deLJd4xyW/n214wKVayYtKEAp6I+adJzcN+\n" +
"5zFYxjL4LAEqvtdLu16EvnbQ8CSkTpqHkacd5Fu5Sr0dwwBmH/cIj2tyNK98HvOt\n" +
"yATSDPcRC+cqg3HIdPaml7ZfplD158I5eYgoGjBkfWLyx36/xnufmkzkQKDp0FYl\n" +
"zjX4SD+qb3A4IuaiRUbiCSDATScWv6zUlrlXh1XuZT1rEo3IzSFdwaMws+lAPKRi\n" +
"kAM/9kguiy30MeYIBZCzpHWGBMi7P9dReGSC/6pVEoR4PSkm4+D5/PoTX9c/0/28\n" +
"YHRJodQmFQid7CoueuTNdLgoqFI11/ZYR7CnhiVKgOcME/JKwMXl8zYMgIH0OD+/\n" +
"sQAzekDx4/LICbkWCLeHWtpRGTiWRa5h5gf6iaR4H/MFQnHJRIEt1YEtz7QvqL6c\n" +
"GTY85b6ew8y1Cqs/QDQgRxNtvuLryrfmP4A61lXa4d5JhMK2DwZKhCBhSusWB9zC\n" +
"adK9c+4725kEEBRjV0/eLy++TckPYq4HQ4Y7MC168lkZlMA+p/KtyCt8NFeTPxKc\n" +
"KzpUCjX0Oqp84oOBe2290zxepncP/RZ9KAma1zjqEBXKSoBiX7p/olM0yQAsPgrE\n" +
"CcEsjffOOafWBFg34qMbdO06CrOLh2tnuKRAXyVgwsl09hYAu9GVC+gYM0i/UnCY\n" +
"/fsimcfz1S59G+3Qjc32gpgCk7c0WlXPoPQpSvawQvcvrllaxGJcgUGpUqUPpwIW\n" +
"sXwq4Hd8+RMAEXAZyOdkXdrjJp+Ym1NFqP0R+YRVlElB3HcSi9L1Xn3DKNBthI4a\n" +
"Zjl4oNxCuircx1XQDY6OxqxDwDTDejUMLEsty0RJ3LdwMFol7+pzJxDGWZni1VRx\n" +
"B8QEThH5Q8LYt6MSUl1Dbxj/nQixw9zAn6/grkEuHSO5oLd97eVYpQ+EGgoUf65U\n" +
"Gb8qgxOmeqQ2d2AmtI0doIUSZG69j+NEVpNDhbBgEBPo/hj2gIP38JOkrWVXc/58\n" +
"J88BS0M2QM7znROMLaukHktxoqe3EnR741BqmAWD9xJfk+2srcK9tvyBxcK7ncRf\n" +
"EnmCeyVMTNe9YT1qRxTO8jr/j9iDa2fiaCjqEvSVFypxOvi6+W2pALdF/Z8Xa2tY\n" +
"KwTcLGjzPdS/p8sxkDC8DtIvt4+d/xVrkxvbrkirzR1orL5wfAIHUXmn+W/b2/uF\n" +
"mv9jKQGF2pdfntzEzPWLY/6omP7ndVZ+9gfDuEJ4yMFfqzRVwdu8KP6+66k+o5Bc\n" +
"W+hjz6BiIYseF344chR/Y4JX0hT0fw+qY33HzpkanCYcTFyDDQIJj2QVCEKmlxHe\n" +
"l/u1d09TKIOljE6fLx4OxD2Kn92ADz290fjUzTsFnoxMh7pQNwPJWqBkciqocVML\n" +
"W5Ad/va2rSw0oxK+cPbbawMT03zOozS+Bos1GmcTj2CoUZup1bjpz+WkfvMlTmKE\n" +
"RoZqgGEEBtYvjMso/QqBqvJnQ4G/wKeYHkHMvlouTU+48egxT8uEL+8z4EsuTy8x\n" +
"/WMbdw+mLfQd8GAW/S0dO3wGF50wb9costTDzNPM8J9h63G3xpUpwZMVckEsJJ1c\n" +
"7VT8Ptoc1FsjIf8J8Ce5ZS2wWPqrUCIjuTUWzT4keht6JMp5ogHZjwlu4RirPL7t\n" +
"jXDNIg7XmdJolx4xGHOoH8QBjSMWr7AASA9fCNndohww75Nc65eX8+xzOI1vw1yq\n" +
"66yfJtyCEkbdwe39DYajf4qC/dFDCwjpRYnlNa6ePmXw7hessguZPwEP66jYECNu\n" +
"tsHgzgIeI0lNR8bmZp6avnbNyrHZCZgS+94hq/0giO1YmFUZD0YsmgWaWEy73NAc\n" +
"jUlsk9zmrWDavdtqWmBXcxhZeNFPlzq02ZP9Bbd9p2/8473ibzjpa0YN9jPKryeb\n" +
"xRBCuSW6shUkX6vOoFJnQpUzctbn2BsaXP9MQneVwTUaMmrCRzzoPWU6rkXKUNQm\n" +
"u/tvx8kOQpljz+aO8cEWoFIouNRhXUWPMheXSV1qVEPQK3/5R8BeLOyD1KSEMIIF\n" +
"QQYJKoZIhvcNAQcBoIIFMgSCBS4wggUqMIIFJgYLKoZIhvcNAQwKAQKgggTuMIIE\n" +
"6jAcBgoqhkiG9w0BDAEDMA4ECIXYmYtbZw60AgIIAASCBMhUEcLeqVpjR20KS8s9\n" +
"jZj+pDh8muHROeu4GyQ1f139qr2y5FYXLojsEWAZy4zBymG4r6g+pXyuRPrp6DLn\n" +
"V22rm6T+hmT6etumXZSd3j2GCJCg/oHEa/a1XUx9cvD8DH6KI5kFpoiib7wPtnyY\n" +
"6IoWLuZyfJzI1NKJ8Qqt2ijD1Dv2VSVjV8Gf2/Du72aLQ2xJHoswDlEveRxA/xE1\n" +
"wnFt2U7bB3DWv9R742GPjfLnXWhBWB4sKowFxA3dK9nuU+RJRrZUBAe2TL2DYnx9\n" +
"UtanKPPhi8xI1BIXMy7mW/nFxLGHQSnjLsuqFFWaV1qUUXqp8W6G5SGzSemjVnT2\n" +
"hGgVMnGNlr36EB+xssNahRxVFeDXbPHCr8Zc9/qHZXvMit9YaTfLDUn9oBvrkjt5\n" +
"VEejisjSEwajJL7D6b6X1zbUOaF8Qd/kj/4T4AGESNF1ujx7oolvc2MIuhYKzXzP\n" +
"d38Kiht7Kd0QOSD6xvFlwrGFFQOdKzASgIUDdb1Q5fsJ5am1TTFqbDyxqALa2zoM\n" +
"quYhuKvaQ96IJMdlZohYL9p2fJO99MWB/fRPK0463oKHV5nS7bXixmLhQ8hw2u7E\n" +
"vHAuh+aHDIZ4RiKUhg/2xR4djsrqjNszm4I7eFo8BObP/JtsbeJPKnt5P6duPGLP\n" +
"G1CmiA9POYMiKSuE7pFtdBt8QscChrfSBCPdOi4frGre2S12VhCcOXvvFfyyatz/\n" +
"aJtkzNQtrb2355s7YA7HDyrkxDy99Yd1n8/0rtYf351/Pkm6OQQgAHr8RTmahW1d\n" +
"b0V+s+qLhmlFYdHNs+5jk8aRJRlUpnuYWgRI6iHrjI0RRWaGeae37nKv9CZAwq+O\n" +
"jnG/h3lsrnqj3iBcGwCr1/Z/jLcGoPooPYlABJ1/oKnCgfYpZDcrwPGxjxou5RyU\n" +
"ccqtejFadQhF7l19oUSbOm1SfWO5TKyx9V4VBpJkMMq2MWMy8sM03Z5Qn3zRBvGj\n" +
"2Rr09FYmI/es4Ima59GfAfZUIA05XvrpCzFfVCUDB/ljw3PYeHb14QWyEGtxgH9D\n" +
"dYyMSrdvwOFR5DUrA7n2qPDD7bfVbvQmBgUEgM6hOdjWnRnkeDQNMZ9vVi9VMC6B\n" +
"3QTpYbaG5aJYJ8Oh2caBhrKjrjaRGBZEZ0nmBIlzdHIOyFeFJeT4gEtFWh5/UskK\n" +
"/NeeVJdZFDEQoLT8XRrwWF4AjVRHcahSxb+WRNtlZIRpvCZi7zeNF+4i4mV57lCv\n" +
"u4mBuhY6tzAUpKbvS9U6s7RYP3ExQKCoga0BUm7f0anIlRLqpFnZU5LnS3n4MKRN\n" +
"M/eg8QE5Fv0B+hpdS4F3wbwtr+16RgVyuVrDpacqElZ19X0kARC2Vgp+ppVfhVo7\n" +
"YdGVYfADj95KUYFkbGvMu+QAr1er6Q5p9XoMKWXljmJlTR9lRRB9zWnhQiMCWky+\n" +
"drE8ycO9sZtlx8Oiyr/7EN92CrhkMpTS6v87s2khfwy0F5uoPn035xg6w30T6r0/\n" +
"8WEnk/epN83i9Q0trkprjP0kJAahKX3T7AcEVA5oJoZD5b4t5bI5T4zHmyKA0Ydj\n" +
"Ny86vkZv3UyfAccgs4MmAbQWAupz2tHq7h+KsXGKvxgZEjhFQsiPSKvKtIlyoNvM\n" +
"ZFc6BM7xwdQm72UxJTAjBgkqhkiG9w0BCRUxFgQUhThdUWr5WDqITn/i38ocESpr\n" +
"eR4wMTAhMAkGBSsOAwIaBQAEFA4ksFQ8TkOYx4URWYzAN7PpOucJBAiaMyND6/o1\n" +
"7AICCAA=";
    String ContrasenaPfx="Mileni29";
    
        conex con=new conex();   
        ResultSet rsR = null;        
        String myQuery = "select uuid from to_facturas where factura="+factura;
        String uuid="";
        
        //System.out.println(""+myQuery);
        try {
            Statement st = con.getConnection().createStatement();                                      
            rsR = st.executeQuery(myQuery);
            while(rsR.next()) {                              
                uuid=rsR.getString("uuid");
                System.out.println(uuid);
               
            }                   
            rsR.close(); 
            st.close();
            con.desconectar();
        } catch (SQLException ex) {       
            validacancelacion=false;
            JOptionPane.showMessageDialog(null, "Error al obtener los datos: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }                     
        
      iointegradorcfdi.ArrayOfGuid obj = new iointegradorcfdi.ArrayOfGuid();  
      iointegradorcfdi.IoIntegradorCFDI service = new iointegradorcfdi.IoIntegradorCFDI();
      iointegradorcfdi.IoIntegradorCFDISoap port = service.getIoIntegradorCFDISoap();        
      iointegradorcfdi.IOAcuseCancelacion obj2 = new iointegradorcfdi.IOAcuseCancelacion(); 
      
      obj.getGuid().add(uuid);
       //Codigo WSDL Tempuri (Testing funcion para enviar la cancelacion del CFDI) COMENTARIO 2 
        //obj2=port.cancelaCFDIPruebas("0B7091FC-4970-4CDA-B443-FBE2AFA66854","SAB09083", "e283$P5p", "SARJ740708R22", obj, PfxBase64, ContrasenaPfx);
        
        String entornodesarrollo="",rfc="";
        String userinvoice="",contrainvoice="";
        conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='ENTORNODESARROLLO'";
	System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	entornodesarrollo=rs100.getString("parametro");	    		    			   
		}
                sql="SELECT parametro from to_parametros where clave='INVOICEUSER'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	userinvoice=rs100.getString("parametro");	    		    			   
		}
                sql="SELECT parametro from to_parametros where clave='INVOICECONTRA'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	contrainvoice=rs100.getString("parametro");	    		    			   
		}
                sql="SELECT rfc from to_datos_facturacion where id_datos='1'";
                pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
                rs100 = (ResultSet) pstm100.executeQuery();
                while (rs100.next()) {	    	
	    	rfc=rs100.getString("rfc");	    		    			   
		}
	    rs100.close();
            pstm100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
        
        
        if(entornodesarrollo.equals("PRU")){//CANCELA LA FACTURA DE PRUEBAS
            obj2=port.cancelaCFDIPruebas("95F74C54-7612-45B6-A998-156033AD9DF7",userinvoice, contrainvoice, rfc, obj, PfxBase64, ContrasenaPfx);
            JOptionPane.showMessageDialog(null,"CANCELACION DE PRUEBAS.","Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
        if(entornodesarrollo.equals("PROD")){//CANCELA LA FACTURA EN PRODUCCION
            obj2=port.cancelaCFDI("95F74C54-7612-45B6-A998-156033AD9DF7",userinvoice, contrainvoice, rfc, obj, PfxBase64, ContrasenaPfx);
        }
        
        


        // FIN COMENTARIO 2         
        // Codigo WSDL Integrador (Produccion funcion para enviar la cancelacion del CFDI) COMENTARIO 3 
        //obj2=port.cancelaCFDI("0B7091FC-4970-4CDA-B443-FBE2AFA66854", "SAB09083", "e283$P5p", "KSL140218398", obj, PfxBase64, ContrasenaPfx);
        // FIN COMENTARIO 3 
        
        String xml="";
         xml = obj2.getXmlAcuse();
        System.out.println("Response prueba: "+xml);
        
        
        String patharchivos=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\";
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
        File archivo=new File(patharchivos+factura+"_cancelada.xml");
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        FileWriter escribir=new FileWriter(archivo,true);
        //Escribimos en el archivo con el metodo write 
        escribir.write(xml);
        //Cerramos la conexion
        escribir.close();
        }        
        catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
        
          
        myQuery = "update to_facturas set estatus=5, fecha_cancelacion=now(),usuario_cancelacion='"+accesoSistema.nombreuser+"' where factura="+factura;        
        con=new conex();  
        //System.out.println(""+myQuery);
        try {
            Statement st = con.getConnection().createStatement();                                      
            st.executeUpdate(myQuery);            
            st.close();
            con.desconectar();
            validacancelacion=true;
        } catch (SQLException ex) {       
            JOptionPane.showMessageDialog(null, "Error al modificar el estatus de la factura: "+ex, "Error", JOptionPane.ERROR_MESSAGE);
        }     
        
       
    return validacancelacion;
    }

}
