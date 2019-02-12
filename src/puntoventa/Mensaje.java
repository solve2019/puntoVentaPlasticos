/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntoventa;
import conexion.conex;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.BodyPart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
/**
 *
 * @author JOSE
 */
public class Mensaje {
        static String usuarioEmisorMensaje = "facturacion@solvemorelos.com.mx";
        //password real de la cuenta usuarioEmisorMensaje
        static String passwordEmisorMensaje = "Solve_1234";
        //static String usuarioEmisorMensaje = "ing_jose_antunez@hotmail.com";
        //password real de la cuenta usuarioEmisorMensaje
        //static String passwordEmisorMensaje = "lili2388";
        //Dirección del servidor para este protocolo (SMTP)
        static String smtpHost = "mail.solvemorelos.com.mx";
        //Puerto que se usará en el servidor.
        static String smtpPuerto = "26";  //25
        //Indicamos que vamos a auntenticarnos en el servidor
        static String smtpAuth = "true";
        static Properties props = new Properties();
   
    public void enviarMensaje(String factura, String correo,String cuerpocorreo){        
        System.out.println("correo: "+correo);
        
        String correos=correo;
	conex cn = new conex();
	String sql="SELECT parametro from to_parametros where clave='CORREOSCORTECAJA'";
	//System.out.println(sql);
	PreparedStatement pstm100;
	try {
		pstm100 = (PreparedStatement) cn.getConnection().prepareStatement(sql);
		ResultSet rs100 = (ResultSet) pstm100.executeQuery();
	    while (rs100.next()) {	    		    	
		}
	    rs100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}	
    
        
        if(correos.equals("")){
            System.out.println("NO HAY CORREOS ASIGNADOS");
        }else{
            //Asiganamos algunas propiedades
            props.put("mail.smtp.host", smtpHost);
            props.put("mail.smtp.port", smtpPuerto);
            props.put("mail.smtp.auth", smtpAuth);
            //props.put("mail.transport.protocol","smtp");
            props.put("mail.smtp.starttls.enable", "true");

            //Se obtiene una sesión con las propiedades anteriormente que hemos
            //guardado en -props-
            Session sesion = Session.getDefaultInstance(props, null);
            sesion.setDebug(true);
            try {
                //Empezamos a crear el e-mail
                Message mensaje = new MimeMessage(sesion);
                //Rellenamos los campos necesarios de un e-mail
                //El asunto
                mensaje.setSubject("Factura Punto de Venta");
                // Emisor del mensaje
                mensaje.setFrom(new InternetAddress(usuarioEmisorMensaje));
                String ruta=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".xml";
                String ruta2=new File ("").getAbsolutePath ()+"\\facturacion\\facturas_xml\\"+factura+".pdf";
                System.out.println (ruta);
                // Se compone el adjunto con la imagen
                BodyPart adjunto = new MimeBodyPart();
                adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(ruta)));                               
                adjunto.setFileName(factura+".xml");
                BodyPart adjunto2 = new MimeBodyPart();
                adjunto2.setDataHandler(
                    new DataHandler(new FileDataSource(ruta2)));
                adjunto2.setFileName(factura+".pdf");

                
                
                // Se compone la parte del texto
                BodyPart texto = new MimeBodyPart();
                texto.setText(cuerpocorreo);
                
                
                // Una MultiParte para agrupar texto e imagen.
                MimeMultipart multiParte = new MimeMultipart();
                multiParte.addBodyPart(texto);
                multiParte.addBodyPart(adjunto);
                multiParte.addBodyPart(adjunto2);

                String[] corre=correos.split(",");
                System.out.println("numero de correos: "+corre.length);

                Address [] receptores = new Address [corre.length];
                for(int i=0;i<receptores.length;i++){
                    receptores[i]=new InternetAddress(corre[i].trim());
                }
                /*
                //En este caso tenemos uno o varios receptores
                Address [] receptores = new Address []{
                    new InternetAddress ("jose_domo@hotmail.com"),
                    new InternetAddress ("joly2325@gmail.com")
                    //vemos que nuestros contactos pueden ser de distintos servicios
                    //Hotmail, Gmail, etc
                };*/


                String cuerpocorreos=cuerpocorreo;
                //Agregamos la lista de los receptores.
                mensaje.addRecipients(Message.RecipientType.TO, receptores);
                
                //Aquí va el contenido del mensaje
                mensaje.setText(cuerpocorreos);
                mensaje.setContent(multiParte);
                //Ahora vamos a enviar el mensaje
                Transport t = sesion.getTransport("smtp");
                //Pero antes tenemos que auntenticarnos con una cuenta real de
                //Hotmail
                System.out.println(" "+usuarioEmisorMensaje+" "+passwordEmisorMensaje);
                t.connect(usuarioEmisorMensaje, passwordEmisorMensaje);
                if(corre.length>0){
                    t.sendMessage(mensaje, mensaje.getRecipients(Message.RecipientType.TO));
                }
            }catch(MessagingException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    
    /*
     public static void main(String[] args) {
        Mensaje log = new Mensaje();
        log.enviarMensaje();

    }*/
}

