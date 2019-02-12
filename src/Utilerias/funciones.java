/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import conexion.conex;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author desarrollo8
 */
public class funciones {
     public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
     
     
     public boolean guardarImagenprod(String ruta,String idprod){
	String insert = "update tc_productos set imagen=? where idproducto="+idprod;
         System.out.println(insert);
        //String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
	FileInputStream fis = null;
	PreparedStatement ps = null;
	try {
		conex con=new conex();
                ps = con.getConnection().prepareStatement(insert);                
		File file = new File(ruta);
		fis = new FileInputStream(file);		
		ps.setBinaryStream(1,fis,(int)file.length());
		//ps.setString(2, nombre);
		ps.executeUpdate();                
		con.desconectar();
                JOptionPane.showMessageDialog(null, "Foto guardada correctamente.", "Registro almacenado.", JOptionPane.INFORMATION_MESSAGE);
		return true;
	} catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Error al guardar la foto "+ex, "Error", JOptionPane.ERROR_MESSAGE);
	}finally{
		try {
			ps.close();
			fis.close();
		} catch (Exception ex) {
			
		}
	}        
	return false;
    }
     
     public boolean guardarImagen(String ruta,String idmascota){
	String insert = "update tc_mascotas set imagen=? where idmascota="+idmascota;
         System.out.println(insert);
        //String insert = "insert into Imagenes(imagen,nombre) values(?,?)";
	FileInputStream fis = null;
	PreparedStatement ps = null;
	try {
		conex con=new conex();
                ps = con.getConnection().prepareStatement(insert);                
		File file = new File(ruta);
		fis = new FileInputStream(file);		
		ps.setBinaryStream(1,fis,(int)file.length());
		//ps.setString(2, nombre);
		ps.executeUpdate();                
		con.desconectar();
                JOptionPane.showMessageDialog(null, "Foto guardada correctamente.", "Registro almacenado.", JOptionPane.INFORMATION_MESSAGE);
		return true;
	} catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Error al guardar la foto "+ex, "Error", JOptionPane.ERROR_MESSAGE);
	}finally{
		try {
			ps.close();
			fis.close();
		} catch (Exception ex) {
			
		}
	}        
	return false;
    }
     
     
    
    public Image obtenImagenes(String consulta) {
    //"SELECT imagen FROM tc_mascotas where Idmascota";
        Image imagen = null;
        BufferedImage img = null;
        try {
            conex con=new conex();
            Statement st = con.getConnection().createStatement();
            ResultSet rs=st.executeQuery(consulta);   
            while (rs.next())
            {        
                Blob blob = rs.getBlob("imagen");      
                if(blob==null){
                }else{
                    byte[] data = blob.getBytes(1, (int)blob.length());            
                    try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                    imagen=img;
                    } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "No se pudo convertir la imagen "+ex, "Error", JOptionPane.ERROR_MESSAGE);
                    }     
                }
            }
            rs.close();
            st.close();
            con.desconectar();       
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el la imagen de la base de datos "+ex, "Error sql", JOptionPane.ERROR_MESSAGE);
        }
    return imagen;
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
     


public void GenerarBackupMySQLSilencioso(){   
            String user=conex.login;
            String pass=conex.password;
            java.util.Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");     
            String fecha = formatter.format(today);
            String ruta=obtenruta();
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File("RESPALDOSBD/punto_venta_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                //Process child = runtime.exec("C:\\AppServ\\MySQL\\bin\\mysqldump --opt --password=root --user=root1 --databases punto_venta");
                //ruta=ruta+"\\mysqldump --opt --password=root --user=root1 --databases punto_venta";
                ruta=ruta+"\\mysqldump --opt --password="+pass+" --user="+user+" --databases punto_venta";
                System.out.println(""+ruta);
                Process child = runtime.exec(ruta);
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);
                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();
                //JOptionPane.showMessageDialog(null, "El respaldo se genero con exito","OK",JOptionPane. INFORMATION_MESSAGE);
            }catch(Exception e){
                System.out.println("error: "+e);
                //JOptionPane.showMessageDialog(null, "Error no se genero el respaldo por el siguiente motivo: "+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }            
        
    }


public void GenerarBackupMySQL(){   
            String user=conex.login;
            String pass=conex.password;
            java.util.Date today = Calendar.getInstance().getTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");     
            String fecha = formatter.format(today);
            String ruta=obtenruta();
            try{
                Runtime runtime = Runtime.getRuntime();
                File backupFile = new File("RESPALDOSBD/punto_venta_"+fecha+".sql");
                FileWriter fw = new FileWriter(backupFile);
                //Process child = runtime.exec("C:\\AppServ\\MySQL\\bin\\mysqldump --opt --password=root --user=root1 --databases punto_venta");
                ruta=ruta+"\\mysqldump --opt --password="+pass+" --user="+user+" --databases punto_venta";
                //System.out.println(""+ruta);
                Process child = runtime.exec(ruta);
                InputStreamReader irs = new InputStreamReader(child.getInputStream());
                BufferedReader br = new BufferedReader(irs);
                String line;
                while( (line=br.readLine()) != null ) {
                    fw.write(line + "\n");
                }
                fw.close();
                irs.close();
                br.close();
                JOptionPane.showMessageDialog(null, "El respaldo se genero con exito","OK",JOptionPane. INFORMATION_MESSAGE);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Error no se genero el respaldo por el siguiente motivo: "+e.getMessage(), "Verificar",JOptionPane.ERROR_MESSAGE);
            }            
        
    }


public String obtenruta(){
    String ruta="";
        conex con=new conex();          
        ResultSet rs = null;       
        String myQuery = "SELECT * FROM to_parametros WHERE clave='RUTARESPALDOBD'";
        //System.out.println(""+myQuery);
        try {  
            Statement st = con.getConnection().createStatement();
            rs = st.executeQuery(myQuery);
            while(rs.next()) {                
                    ruta=rs.getString("parametro");                              
            }
            rs.close(); 
            st.close();
            con.desconectar(); 
        } catch (SQLException ex) {
        }
return ruta;
}

}
