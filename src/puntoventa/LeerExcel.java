/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package puntoventa;

import ClasesDAO.accesoSistema;
import conexion.conex;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
public class LeerExcel {
    
    public String lectura_excel(String archivo) throws IOException{
    
        FileInputStream file = new FileInputStream(new File(archivo));
	// Crear el objeto que tendra el libro de Excel
	HSSFWorkbook workbook = new HSSFWorkbook(file);
        /*
	 * Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
	 * Una vez obtenida la hoja excel con las filas que se quieren leer obtenemos el iterator
	 * que nos permite recorrer cada una de las filas que contiene.
	 */
	HSSFSheet sheet = workbook.getSheetAt(0);
	Iterator<Row> rowIterator = sheet.iterator();
	Row row;
	// Recorremos todas las filas para mostrar el contenido de cada celda
        int cantidad_prod=0;
        
        int errores=0;
        String error="";
	while (rowIterator.hasNext()){
            
                        row = rowIterator.next();
                        // Obtenemos el iterator que permite recorres todas las celdas de una fila
                        Iterator<Cell> cellIterator = row.cellIterator();
                        Cell celda;
                        int numerocolumna=0;
                        String codigobarra="",producto="",descripcion="",precio="",precioventa="",existencia="",cantidadminima="",preciomayoreo="",campo1="",campo2="",cantidadmayoreo="";
                        while (cellIterator.hasNext()){
                            
                            celda = cellIterator.next();
                            
                            String valor="";
                            celda.setCellType(Cell.CELL_TYPE_STRING);
                            // Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                            switch(celda.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                if( HSSFDateUtil.isCellDateFormatted(celda) ){
                                   valor=celda.getDateCellValue()+"";
                                   //System.out.println(celda.getDateCellValue());
                                }else{
                                   valor=celda.getNumericCellValue()+"";
                                   //System.out.println(celda.getNumericCellValue());
                                }                                 
                                valor=celda.getNumericCellValue()+"";
                                //System.out.println(celda.getNumericCellValue());
                                break;
                            case Cell.CELL_TYPE_STRING:
                                valor=celda.getStringCellValue()+"";
                                //System.out.println(celda.getStringCellValue());
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                valor=celda.getBooleanCellValue()+"";
                                //System.out.println(celda.getBooleanCellValue());
                                break;
                            }

                            if(numerocolumna==0){
                                codigobarra=valor;
                                
                            }
                            if(numerocolumna==1){
                                producto=valor;
                            }
                            if(numerocolumna==2){
                                descripcion=valor;
                            }
                            if(numerocolumna==3){
                                precio=valor;
                            }
                            if(numerocolumna==4){
                                precioventa=valor;
                            }
                            if(numerocolumna==5){
                                existencia=valor;
                            }
                            if(numerocolumna==6){
                                cantidadminima=valor;
                            }  
                            if(numerocolumna==7){
                                preciomayoreo=valor;
                            }  
                            if(numerocolumna==8){
                                cantidadmayoreo=valor;
                            } 
                            if(numerocolumna==9){
                                campo1=valor;
                            }  
                            if(numerocolumna==10){
                                campo2=valor;
                            }  
                            numerocolumna++;
                        }
                        
                        
                        conex con=new conex();   
                        ResultSet rs = null;       
                        String myQuery = "insert into tc_productos (codigo_barras,nombre_producto,descripcion,precio_compra,precio_venta,existencia,cantidad_minima,estatus,fecha_registro,usuario_registro,precio_mayoreo,campo1,campo2,cantidad_mayoreo)"
                                + " values ('"+codigobarra+"','"+producto+"','"+descripcion+"','"+precio+"','"+precioventa+"','"+existencia+"','"+cantidadminima+"','1',now(),'"+accesoSistema.nombreuser+"','"+preciomayoreo+"','"+campo1+"','"+campo2+"','"+cantidadmayoreo+"')";
                        System.out.println(""+myQuery);
                        try {  
                            Statement st = con.getConnection().createStatement();
                            st.executeUpdate(myQuery);
                            st.close();
                            con.desconectar(); 
                            cantidad_prod++;
                        } catch (SQLException ex) {
                            //JOptionPane.showMessageDialog(null, "Error en base de datos: "+ex, "Alerta BD", JOptionPane.ERROR_MESSAGE);
                            errores++;
                            error=error+producto+"|";
                        }
                        //System.out.print(""+codigobarra+"|"+producto+"|"+descripcion+"|"+precio+"|"+precioventa+"|"+existencia+"|"+cantidadminima);
                        //System.out.println("");
                        
            
	}
	// cerramos el libro excel
	workbook.close();
        JOptionPane.showMessageDialog(null, "Cargados correctamente:"+cantidad_prod+" Errores:"+errores, "Carga de información", JOptionPane.ERROR_MESSAGE);
        
    return error;
    }
    
    public static void main(String args[]) throws IOException{
        LeerExcel excel=new LeerExcel();
	excel.lectura_excel("C:\\sabiocom\\productos.xls");
    }
}

