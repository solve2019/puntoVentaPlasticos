package administracionFacturas;

import Utilerias.funciones;
import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import conexion.conex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;  
import java.io.PrintWriter;

import java.sql.PreparedStatement;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.text.DecimalFormat;  
import java.util.List;  
import javax.swing.JOptionPane;
import org.jdom.Document;  
import org.jdom.Element;  
import org.jdom.JDOMException;  
import org.jdom.Namespace;  
import org.jdom.input.SAXBuilder;  
import org.jdom.output.Format;  
import org.jdom.output.XMLOutputter;  
import org.jdom.xpath.XPath; 
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Admin
 */
public class GenerarCFDI {
    
     /*contendor*/
    public GenerarCFDI() {
        // TODO Auto-generated constructor stub
    }
 
    public static void main(String[] args) {
        //@parametro globales
    }
    
//### INICIA OBTENER ARCHIVO TEMPLATE XML PARA ENVIAR CFDI Y VALIDAR            OBTENER ARCHIVO TEMPLATE XML
    public String ConstruyeCFDI(String sello, String certificado, String noCertificado, String fechaGenera, String noFactura, String noEmpresa, String noCuenta, String metodoPago, String formaPago, int band, String patharchivos,String correo,String usocfdi){
        String parseado="", nom_comercial_="", calle_="", pais_="", rfc_="", TOTALFACTURA="",montoTotal="", montoIva="", importe="", valorUnitario="", listaServicios="", valorRepornado="",noFolio="",descuento="",ieps=""; //se agrego el campo folio,descuento nuevo para factura
        DecimalFormat df = new DecimalFormat("0.00");
        
        conex conn;
        conn = new conex();
        PreparedStatement pstm;
        PreparedStatement pstm1;
        try {
         pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from tc_clientes where idcliente='"+noEmpresa+"'");
         ResultSet rs = (ResultSet) pstm.executeQuery();
            while (rs.next()) {
                rfc_=rs.getString("rfc");
                nom_comercial_=rs.getString("razon_social");
                calle_=rs.getString("calle");
                pais_=rs.getString("pais");
                        }
                rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        double desc=0,subtot=0,iva=0,totales=0;
        double descuentototal=0;
        String desctotal="0";
        String tipoiva="0.160000";
        try {
         pstm = (PreparedStatement) conn.getConnection().prepareStatement("select subtotal,Monto,iva,factura,descuento,ieps from to_facturas where factura='"+noFactura+"'");
         ResultSet rs = (ResultSet) pstm.executeQuery();
            while (rs.next()) {                
                noFolio=rs.getString("factura");
                
                funciones utileria=new funciones();
                double paramiva=utileria.obteniva();
                if(paramiva==0){
                       tipoiva="0.000000";
                }
                
                double entiva=1+paramiva;
                ieps=rs.getString("ieps");
                //desc=rs.getFloat("descuento")/1.16;
                //desc=rs.getFloat("descuento")/entiva;
                desc=rs.getFloat("descuento");
                descuentototal=rs.getFloat("descuento");
                desctotal=rs.getString("descuento")+"";
                desctotal = desctotal.replace(",",".");
                
                desc=redondearDecimales(desc,2);
                
                //subtot=rs.getDouble("subtotal")-desc;//obtienen el subtotal                
                subtot=rs.getDouble("subtotal");//obtienen el subtotal                
                subtot=redondearDecimales(subtot,2);
                subtot=subtot-desc;
                subtot=redondearDecimales(subtot,2);
                montoTotal=rs.getDouble("subtotal")+"";
                
                //iva=subtot*0.16;
                iva=subtot*paramiva;
                iva=redondearDecimales(iva,2);
                montoIva=df.format(iva);
                montoIva = montoIva.replace(",",".");
                
                
                
                //DecimalFormat twoDForm = new DecimalFormat("#.##");
                //montoIva=""+Double.valueOf(twoDForm.format(iva));//agrega 2 decimales
                
                totales=iva+subtot;
                totales=redondearDecimales(totales,2);
                totales=totales+Float.parseFloat(ieps);
                totales=redondearDecimales(totales,2);
                TOTALFACTURA=totales+"";
                
                //formatea el monto de la factrua a decimales
                TOTALFACTURA = TOTALFACTURA.replace(".",",");
                  String de[]=TOTALFACTURA.split(",");
                  String unidad=de[0]+"";//obtengo las unidades
                  String decimales=de[1]+"";//obtengo decimales
                  System.out.println("total parseado a decimales"+decimales);
                  if(decimales.length()==1){
                      decimales=decimales+"0";
                  }
                  TOTALFACTURA=unidad+"."+decimales;
                
                
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        funciones utileria=new funciones();
        double paramiva=utileria.obteniva();
        
        descuento=desc+"";
         if(descuento.equals("")){
                    descuento="0.00";
         }
                    //formatea el descuento para que tenga 2 decimasles
                  descuento = descuento.replace(".",",");
                  String de[]=descuento.split(",");
                  String unidad=de[0]+"";//obtengo las unidades
                  String decimales=de[1]+"";//obtengo decimales
                  System.out.println("DESCUN"+decimales);
                  if(decimales.length()==1){
                      decimales=decimales+"0";
                  }
                  descuento=unidad+"."+decimales;
         
         
        
        if ( band==1 ){
            /*try {   
            pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from eb_tp_movimientos where no_factura_eb='"+noFactura+"' order by Id_movimiento_eb;");
            ResultSet rs = (ResultSet) pstm.executeQuery();
               while (rs.next()) {
                   listaServicios=listaServicios+"<cfdi:Concepto importe='"+rs.getString("costo_cliente")+"' valorUnitario='"+rs.getString("costo_cliente")+"' descripcion='PZA' unidad='CANT' cantidad='1'/>";
                           }
                   rs.close();
           } catch (SQLException ex) {
               System.out.println(ex);
           }*/
        }else if ( band==2 ){
            try { 
                System.out.println("select idproducto, to_ventas.cantidad, precio, to_ventas.precio*to_ventas.cantidad as total,to_ventas.descuento from to_ventas,to_folios,to_facturas where to_ventas.Tipoventa=to_folios.tipo_venta and to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+noFactura+"'");   
                
            pstm = (PreparedStatement) conn.getConnection().prepareStatement("select to_ventas.idproducto,codigo_barras,nombre_producto,idr_concep_sat, to_ventas.cantidad, precio, to_ventas.precio*to_ventas.cantidad as total, (((to_ventas.precio*to_ventas.cantidad)-to_ventas.descuento)) as ivaprod, to_ventas.descuento, ((to_ventas.precio*to_ventas.cantidad)-to_ventas.descuento) as totalcondesc,diferenciadescuento from to_ventas,to_folios,to_facturas,tc_productos where to_ventas.idproducto=tc_productos.idproducto and to_folios.no_folio=to_ventas.folio and to_facturas.folio=to_folios.no_folio and factura='"+noFactura+"'");
            ResultSet rs = (ResultSet) pstm.executeQuery();
            ResultSet rs2=null;
            int i=0;
            PreparedStatement pstm2 = (PreparedStatement) conn.getConnection().prepareStatement("");
                while (rs.next()) {
                    
                   String idr_concep_sat=rs.getString("idr_concep_sat"); 
                   String clave_prod="",clave_unidad="",Unidad="";
                   rs2 = (ResultSet) pstm2.executeQuery("select * from fact_concepto_productos where IdConceptos="+idr_concep_sat); 
                   
                   while (rs2.next()) {  
                          clave_prod=rs2.getString("clave_prod");
                          clave_unidad=rs2.getString("clave_unidad");
                          Unidad=rs2.getString("Unidad");
                   }   
                   //listaServicios=listaServicios+"<cfdi:Concepto importe='"+montoTotal+"' valorUnitario='"+montoTotal+"' descripcion='PZA' unidad='CANT' cantidad='1'/>";
                   //listaServicios=listaServicios+"<cfdi:Concepto ClaveProdServ='"+clave_prod+"' NoIdentificacion='"+rs.getString("codigo_barras")+"' Cantidad='"+rs.getString("cantidad")+"' ClaveUnidad='"+clave_unidad+"' Unidad='"+Unidad+"' Descripcion='"+rs.getString("nombre_producto")+"' ValorUnitario='"+rs.getString("precio")+"' Importe='"+rs.getString("total")+"' Descuento='"+rs.getString("descuento")+"'><cfdi:Impuestos><cfdi:Traslados><cfdi:Traslado Base='"+rs.getString("totalcondesc")+"' Impuesto='002' TipoFactor='Tasa' TasaOCuota='0.160000' Importe='"+rs.getString("ivaprod")+"'/></cfdi:Traslados></cfdi:Impuestos></cfdi:Concepto>";
                   double ivaproductos=paramiva*Float.parseFloat(rs.getString("ivaprod"));
                   DecimalFormat f1 = new DecimalFormat("##.0000");
                   String ivaprodsoloss=f1.format(ivaproductos);
                   String primera=ivaprodsoloss.substring(0, 1);
                   if(primera.equals(".")){//si son solo decilames se agrega un 0 al inicio  solo es para el iva del producto
                            ivaprodsoloss="0"+ivaprodsoloss;
                   }
                   
                   double difdesuento=rs.getDouble("diferenciadescuento");                   
                   double descuentos=rs.getDouble("descuento");
                   if(i==0){//se suma la diferencia del descuento al primer registro
                        descuentos=descuentos+difdesuento;
                   }
                   listaServicios=listaServicios+"<cfdi:Concepto ClaveProdServ='"+clave_prod+"' Cantidad='"+rs.getString("cantidad")+"' ClaveUnidad='"+clave_unidad+"' Unidad='"+Unidad+"' Descripcion='"+rs.getString("nombre_producto")+"' ValorUnitario='"+rs.getString("precio")+"' Importe='"+rs.getString("total")+"' Descuento='"+descuentos+"'><cfdi:Impuestos><cfdi:Traslados><cfdi:Traslado Base='"+rs.getString("totalcondesc")+"' Impuesto='002' TipoFactor='Tasa' TasaOCuota='"+tipoiva+"' Importe='"+ivaprodsoloss+"'/></cfdi:Traslados></cfdi:Impuestos></cfdi:Concepto>";
                   i++;
                }
                   rs.close();
           } catch (SQLException ex) {
               System.out.println(ex);
           }
        }
        
        
                  String rfcEmisor_="", razonsocialemisor="", paisemisor="",cpemisor="",lugarexpedicionemisor="",estadoemisor="",ciudademisor="",coloniaemisor="",calleemisor="";
                  String ivaemisor="",RegimenFiscalBD="";
                  try {                     
                     pstm = (PreparedStatement) conn.getConnection().prepareStatement("select * from to_datos_facturacion where id_datos=1");
                     ResultSet rs = (ResultSet) pstm.executeQuery();
                        while (rs.next()) {                                                                                
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
                            RegimenFiscalBD=rs.getString("RegimenFiscal").trim(); 
                        }
                        rs.close();
                    } catch (SQLException ex) {                        
                        System.out.println(ex);
                    }
        
                  System.out.println("llenaod el xml"+lugarexpedicionemisor);
        
      try {     
         // Creamos el builder basado en SAX  
         SAXBuilder builder = new SAXBuilder();  
         // Construimos el arbol DOM a partir del fichero xml  
         //Document doc = builder.build(new FileInputStream("C:\\factura\\WS_Temp.xml")); //ruta de archivos para produccion   
        Document doc = builder.build(new FileInputStream(patharchivos+"xml_parseado.xml")); //ruta de archivos para desarrollo  
         
         // Obtenemos la etiqueta raíz  
         Element raiz = doc.getRootElement();
        // NODO RAIZ
        //se agrego linea para folio en factura
        
        
        
        String LugarExpedicion = raiz.getAttributeValue("LugarExpedicion");
        if(LugarExpedicion!=null){
            raiz.setAttribute("LugarExpedicion",cpemisor);
        }
        
        
        
        String folio_ = raiz.getAttributeValue("Folio");
        if(folio_!=null){
            raiz.setAttribute("Folio",noFolio);
        }
       
        
        /*String NumCtaPago_ = raiz.getAttributeValue("NumCtaPago");  
        if(NumCtaPago_!=null){  
           raiz.setAttribute("NumCtaPago", noCuenta);
        }*/
        
        String formaDePago_ = raiz.getAttributeValue("FormaPago");  
        if(formaDePago_!=null){  
           raiz.setAttribute("FormaPago", metodoPago);
        }
         
        /*String metodoDePago_ = raiz.getAttributeValue("MetodoPago");  
        if(metodoDePago_!=null){  
           raiz.setAttribute("metodoDePago", metodoPago);
        }*/
        
        double a = Double.parseDouble(montoTotal);
        double b = Double.parseDouble(montoIva);
        double total=a+b;// se realiza la resta del descuento 
        String superTotal = df.format(total); 
        String subTotal_ = raiz.getAttributeValue("SubTotal");  
        
        
        double tasaieps=a-Float.parseFloat(ieps);
        double tas=tasaieps/a;
        tas=redondearDecimales(tas,2);
        tasaieps=1-tas;
        tasaieps=redondearDecimales(tasaieps,2);
        tasaieps=tasaieps*100;
          System.out.println("tasaieps: "+tasaieps);
        
        //formatea el subtotal de la factrua a decimales
                montoTotal = montoTotal.replace(".",",");
                  String subto[]=montoTotal.split(",");
                  String unidad2=subto[0]+"";//obtengo las unidades
                  String decimales2=subto[1]+"";//obtengo decimales
                  System.out.println("subtotal parseado a decimales"+decimales2);
                  if(decimales2.length()==1){
                      decimales2=decimales2+"0";
                  }
                  montoTotal=unidad2+"."+decimales2;
        
        
        if(subTotal_!=null){  
           raiz.setAttribute("SubTotal", montoTotal);
        }
       //se agrego campo de descuento
        String desc_ = raiz.getAttributeValue("Descuento");
        if(desc_!=null){
            raiz.setAttribute("Descuento",desctotal);
        }
        
        String total_ = raiz.getAttributeValue("Total");  
        if(total_!=null){  
           raiz.setAttribute("Total", ""+TOTALFACTURA);
        }
         
        String fecha_ = raiz.getAttributeValue("Fecha");  
        if(fecha_!=null){  
           raiz.setAttribute("Fecha", fechaGenera);
        }
        
        String certificado_ = raiz.getAttributeValue("Certificado");  
        if(certificado_!=null){  
           raiz.setAttribute("Certificado", certificado);
        }
        
        String sello_ = raiz.getAttributeValue("Sello");  
        if(sello_!=null){  
           raiz.setAttribute("Sello", sello);
        }
        
        String noCertificado_ = raiz.getAttributeValue("NoCertificado");  
        if(noCertificado_!=null){  
           raiz.setAttribute("NoCertificado", noCertificado);
        }
         
         // Recorremos los hijos de la etiqueta raíz  
         List<Element> hijosRaiz = raiz.getChildren();
         
        for(Element hijo: hijosRaiz){  
            String nombre = hijo.getName(); 
            
            List<Element> hijosRaiz02 = hijo.getChildren();
            for(Element hijo02: hijosRaiz02){  
                String nombre02 = hijo02.getName();
                
                
                List<Element> hijosRaiz03 = hijo02.getChildren();
                int val=0;
                /*
                for(Element hijo03: hijosRaiz03){  
                    if(val==0){
                        String nombre03 = hijo03.getName();
                        System.out.println("Nodos Tercer nivel: "+nombre03);
                        // NODO NIVEL TRES    
                        if(nombre03.equals("Traslado")){
                            String importe_ = hijo03.getAttributeValue("importe");  
                            if(importe_!=null){  

                                //formatea el subtotal de la factrua a decimales
                                montoIva = montoIva.replace(".",",");
                                String ivass[]=montoIva.split(",");
                                String unidad3=ivass[0]+"";//obtengo las unidades
                                String decimales3=ivass[1]+"";//obtengo decimales
                                System.out.println("subtotal parseado a decimales"+decimales3);
                                if(decimales3.length()==1){
                                    decimales3=decimales3+"0";
                                }
                                montoIva=unidad3+"."+decimales3;

                               hijo03.setAttribute("importe", montoIva);
                            } 

                            String impuesto = hijo03.getAttributeValue("impuesto");  
                            if(impuesto!=null){  
                               hijo03.setAttribute("impuesto", "IVA");
                            } 
                        }
                    }  
                    if(val==1){
                        String nombre03 = hijo03.getName();
                        System.out.println("Nodos Tercer nivel: "+nombre03);
                        // NODO NIVEL TRES    
                        if(nombre03.equals("Traslado")){
                            String importe_ = hijo03.getAttributeValue("importe");  
                            if(importe_!=null){  

                                //formatea el subtotal de la factrua a decimales
                                ieps = ieps.replace(".",",");
                                String ivass[]=ieps.split(",");
                                String unidad3=ivass[0]+"";//obtengo las unidades
                                String decimales3=ivass[1]+"";//obtengo decimales
                                System.out.println("subtotal parseado a decimales"+decimales3);
                                if(decimales3.length()==1){
                                    decimales3=decimales3+"0";
                                }
                                 montoIva=unidad3+"."+decimales3;

                               hijo03.setAttribute("importe", montoIva);
                            } 

                            
                            String tasa = hijo03.getAttributeValue("tasa");  
                            if(tasa!=null){ 
                               String tasasaieps=tasaieps+"";
                               tasasaieps= tasasaieps.replace(".",",");
                                String ivass[]=tasasaieps.split(",");
                                String unidad3=ivass[0]+"";//obtengo las unidades
                                String decimales3=ivass[1]+"";//obtengo decimales
                                System.out.println("subtotal parseado a decimales"+decimales3);
                                if(decimales3.length()==1){
                                    decimales3=decimales3+"0";
                                }
                                 tasasaieps=unidad3+"."+decimales3; 
                                
                                
                               hijo03.setAttribute("tasa", tasasaieps+"");
                            } 
                            
                            String impuesto = hijo03.getAttributeValue("impuesto");  
                            if(impuesto!=null){  
                               hijo03.setAttribute("impuesto", "IEPS");
                            } 
                        }
                    }
                    val++;
                 } */
                System.out.println("Nodo calle: "+nombre02);
                
                /*
                //modifica los datos del emisor
                if(nombre02.equals("DomicilioFiscal")){
                String cpemi = hijo02.getAttributeValue("codigoPostal");  
                System.out.println("cpemision:"+cpemi+"   "+cpemisor);
                if(cpemi!=null){  
                   hijo02.setAttribute("codigoPostal", cpemisor);
                   System.out.println("cpemision:"+cpemi+"   "+cpemisor);
                } 
                
                String paisemi = hijo02.getAttributeValue("pais");  
                if(paisemi!=null){  
                   hijo02.setAttribute("pais", paisemisor);
                } 
                String estaemi = hijo02.getAttributeValue("estado");  
                if(estaemi!=null){  
                   hijo02.setAttribute("estado", estadoemisor);
                } 
                String muniemi = hijo02.getAttributeValue("municipio");  
                if(muniemi!=null){  
                   hijo02.setAttribute("municipio", ciudademisor);
                }
                String calleemi = hijo02.getAttributeValue("calle");  
                System.out.println("calleemi:"+calleemi+"   "+calleemisor);
                if(calleemi!=null){  
                   hijo02.setAttribute("calle", calleemisor);
                }
                String coloniaemi = hijo02.getAttributeValue("colonia");  
                if(coloniaemi!=null){  
                   hijo02.setAttribute("colonia", coloniaemisor);
                }
            }//fin modifica los datos del emisor
                */
                
                // NODO NIVEL DOS
                /*
                if(nombre02.equals("Domicilio")){
                    String pais02 = hijo02.getAttributeValue("pais");  
                    if(pais02!=null){  
                       hijo02.setAttribute("pais", pais_);
                    } 

                    String calle02 = hijo02.getAttributeValue("calle");  
                    if(calle02!=null){  
                       hijo02.setAttribute("calle", calle_);
                    } 
                } */
                
             } 
            // ### INICIA: AGREGRA LA LISTA DE SERVICIOS DEFINIDOS PARA FACTURAR POR KONNEN
            if(hijo.getName().equals("Conceptos")){
                hijo.setText(listaServicios);
            }
            // ### TERMINA: AGREGAR LA LISTA DE SERVICIOS DEFINIDOS PARA FACTURACION POR KONNEN
            
            
            
            //formatea el iva total para que tenga 2 decimasles
                  /*montoIva = montoIva.replace(".",",");
                  String de22[]=montoIva.split(",");
                  String unidad22=de22[0]+"";//obtengo las unidades
                  String decimales22=de22[1]+"";//obtengo decimales
                  System.out.println("DESCUN"+decimales22);
                  if(decimales22.length()==1){
                      decimales22=decimales22+"0";
                  }
                  montoIva=unidad22+"."+decimales22;*/
            
            
            //para factura 3.3 se agregaron los impuestos
            String impuestos="<cfdi:Traslados><cfdi:Traslado Impuesto='002' TipoFactor='Tasa' TasaOCuota='"+tipoiva+"' Importe='"+montoIva+"'/></cfdi:Traslados>";
             if(hijo.getName().equals("Impuestos")){
                hijo.setText(impuestos);
            }
            if(nombre.equals("Impuestos")){
                String TotalImpuestosTrasladados = hijo.getAttributeValue("TotalImpuestosTrasladados");  
                if(TotalImpuestosTrasladados!=null){  
                   hijo.setAttribute("TotalImpuestosTrasladados", ""+montoIva);
                }                 
            } 
            //fin impuestos
             
            
            System.out.println("nombre del nodo:"+nombre);
            
            //#####INICIA MODIFICACION DE DATOS DEL EMISOR
            if(nombre.equals("Emisor")){
                String nombre_ = hijo.getAttributeValue("Nombre");  
                if(nombre_!=null){  
                   hijo.setAttribute("Nombre", razonsocialemisor);
                } 
                
                String rfc01 = hijo.getAttributeValue("Rfc");  
                if(rfc01!=null){  
                   hijo.setAttribute("Rfc", rfcEmisor_);
                }
                String RegimenFiscal = hijo.getAttributeValue("RegimenFiscal");  
                if(RegimenFiscal!=null){  
                   hijo.setAttribute("RegimenFiscal", RegimenFiscalBD);
                }
            }            
            //##############FIN MODIFICA LA INFORMACION DEL EMISOR
            
            
            // NODO NIVEL UNO
            if(nombre.equals("Receptor")){
                String nombre_ = hijo.getAttributeValue("Nombre");  
                if(nombre_!=null){  
                   hijo.setAttribute("Nombre", nom_comercial_);
                } 
                
                String rfc01 = hijo.getAttributeValue("Rfc");  
                if(rfc01!=null){  
                   hijo.setAttribute("Rfc", rfc_);
                } 
                
                String xmusocfdi = hijo.getAttributeValue("UsoCFDI");  
                if(xmusocfdi!=null){  
                   hijo.setAttribute("UsoCFDI", usocfdi);
                } 
            }
            
            
           
            
            
        }  
  
// #### INICIA AGREGAR NODO DE CONCEPTOS
   
// #### TERMINA AGREGAR NODO DE CONCEPTOS       
        
         // Partimos del "Formato bonito", aunque también existe el plano y el compacto  
         Format format = Format.getPrettyFormat();//getPrettyFormat();             EL FORMATO QUE YO NECESITO : .getRawFormat();
         // Creamos el serializador con el formato deseado  
         XMLOutputter xmloutputter = new XMLOutputter(format);  
         // Serializamos el document parseado  
         String docStr = xmloutputter.outputString(doc);  
         // Serializamos nuestro nuevo document  
         //String docNuevoStr = xmloutputter.outputString(docNuevo);   //OBTENEMOS ARCHIVO XML CREADO 
           
         System.out.println("XML parseado:\n"+docStr);  
         parseado = docStr;
         parseado = parseado.replace("\"","'");
         parseado = parseado.replace("&lt;","<");
         parseado = parseado.replace("&gt;",">");
         //System.out.println("XML parseado_:\n"+parseado); 
         
         System.out.println("Generacion de timbrado...123456");    
         
        //FACTURACION SMARTWEB
        // FacturaSmartWeb facturacion=new FacturaSmartWeb();
        // valorRepornado=facturacion.facturar(parseado, noFactura, patharchivos);//no se envia parseado
         
         //FACTURACION INVOICE ONE         
         valorRepornado = ConstruyeCFDI(parseado, noFactura,patharchivos,correo); 
          
      } catch (FileNotFoundException e) {  
         e.printStackTrace();  
      } catch (JDOMException e) {  
         e.printStackTrace();  
      } catch (IOException e) {  
         e.printStackTrace();  
      }  
        return valorRepornado;

    }
//### TERMINA OBTENER ARCHIVO TEMPLATE XML PARA ENVIAR CFDI Y VALIDAR           OBTENER ARCHIVO TEMPLATE XML

// ### INICIA MANDAR A LLAMAR METODO OBTNERCFDIPRUEBA() DE WEB SERVICES INVOICEONE
    public String ConstruyeCFDI(String xmlArchivo, String noFactura,String patharchivos,String correo){
    	 try
         {
         //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor        
         File archivo=new File(patharchivos+"facturas_xml\\parseador.xml"); //ruta para archivos de desarrollo
             
         //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
         FileWriter escribir=new FileWriter(archivo,true);

         //Escribimos en el archivo con el metodo write 
         escribir.write(xmlArchivo);

         //Cerramos la conexion
         escribir.close();
         }    	
         catch(Exception e)
         {
         System.out.println("Error al escribir");
         }
    	
         
         
        String entornodesarrollo="";
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
	    rs100.close();
            pstm100.close();
            cn.desconectar();
	} catch (SQLException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
         
         
    	
    	String xml="", valorRetornado="";
        try{
            System.out.println("Facturando Conecta con WSCDL Testing new >> Entra:...");
            //System.out.println(xmlArchivo);
           // configuracion para realizar pruebas de facturacion..
            org.tempuri.TimbreCFDI service = new org.tempuri.TimbreCFDI();    
            org.tempuri.TimbreCFDISoap port = service.getTimbreCFDISoap();    
            org.tempuri.IOAcuseTimbradoCfdi obj = new org.tempuri.IOAcuseTimbradoCfdi();
            
                       
            if(entornodesarrollo.equals("PRU")){//GENERA FACTURA DE PRUEBAS
                //obj = port.obtenerCFDIPrueba("VARJ8811", "3c43$I2i", xmlArchivo); //CARLOS VALENCIANOS PRUYEBAS
                obj = port.obtenerCFDIPrueba(userinvoice, contrainvoice, xmlArchivo); //CARLOS VALENCIANOS PRUYEBAS
                JOptionPane.showMessageDialog(null,"GENERACION DE FACTURAS DE PRUEBAS.","Alerta",JOptionPane.ERROR_MESSAGE);
            }
            if(entornodesarrollo.equals("PROD")){//GENERA FACTURA EN PRODUCCION
                //obj = port.obtenerCFDI("VARJ8811", "3c43$I2i", xmlArchivo);//CARLOS VALENCIANO PRODUCCION
                obj = port.obtenerCFDI(userinvoice, contrainvoice, xmlArchivo);//CARLOS VALENCIANO PRODUCCION
            }
            
            
                     
            
            xml = obj.getXml();
            System.out.println("Recibe XML: "+xml);
            
            
           

            
            
        }catch(Exception ex){
            System.out.println("Exception: "+ex.getMessage());
            System.out.println(ex);
            valorRetornado = ""+ex;
            
            File f;            
            System.out.println(patharchivos+"retornoxml.txt");
            f = new File(patharchivos+"retornoxml.txt");
            //Escritura            
            try{            
            FileWriter w = new FileWriter(f);            
            BufferedWriter bw = new BufferedWriter(w);            
            PrintWriter wr = new PrintWriter(bw);              
            wr.write(ex+"");//escribimos en el archivo            
            //wr.append(" - y aqui continua"); //concatenamos en el archivo sin borrar lo existente            
                    //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita            
                    //de no hacerlo no se escribirá nada en el archivo            
            wr.close();            
            bw.close();            
            }catch(IOException e){
            }            
            
        }
        
        // ### INICIA ALMACENAR ARCHIVO XML
        try
        {
        //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
       // File archivo=new File("C:\\factura\\CXCXML\\"+noFactura+".xml"); //ruta de archivos para produccion
        File archivo=new File(patharchivos+"facturas_xml\\"+noFactura+".xml"); //ruta para archivos de desarrollo
            
        //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
        FileWriter escribir=new FileWriter(archivo,true);

        //Escribimos en el archivo con el metodo write 
        escribir.write(xml);

        //Cerramos la conexion
        escribir.close();
        }

        //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
        System.out.println("Error al escribir");
        }
        // ### TERMINA ALMACENAR ARCHIVO XML
        return valorRetornado;
    }
    
    
 
    
// ### TERMINA MANDAR A LLAMAR METODO OBTNERCFDIPRUEBA() DE WEB SERVICES INVOICEONE  
    
    
    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
}