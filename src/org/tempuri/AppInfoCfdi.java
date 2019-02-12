
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para AppInfoCfdi complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="AppInfoCfdi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_Num_Emisor" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Id_Num_Receptor" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Id_Usuario" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Id_Oficina" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="ImporteLetra" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id_TipoFormaPago" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_Folio" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Id_TipoCFDI" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Id_Moneda" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Bit_Pagada" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FormaPagoTexto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComentarioConcepto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id_tickets_Lista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Id_tickets_HASH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroOrden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreAgenteVentas" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreComprador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NombreComercial" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Observaciones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AppInfoCfdi", propOrder = {
    "idNumEmisor",
    "idNumReceptor",
    "idUsuario",
    "idOficina",
    "importeLetra",
    "idTipoFormaPago",
    "idFolio",
    "idTipoCFDI",
    "idMoneda",
    "bitPagada",
    "folio",
    "formaPagoTexto",
    "comentarioConcepto",
    "idTicketsLista",
    "idTicketsHASH",
    "numeroCliente",
    "numeroOrden",
    "numeroProveedor",
    "nombreAgenteVentas",
    "nombreComprador",
    "nombreComercial",
    "observaciones"
})
public class AppInfoCfdi {

    @XmlElement(name = "Id_Num_Emisor", required = true)
    protected String idNumEmisor;
    @XmlElement(name = "Id_Num_Receptor", required = true, nillable = true)
    protected String idNumReceptor;
    @XmlElement(name = "Id_Usuario", required = true, nillable = true)
    protected String idUsuario;
    @XmlElement(name = "Id_Oficina", required = true, nillable = true)
    protected String idOficina;
    @XmlElement(name = "ImporteLetra")
    protected String importeLetra;
    @XmlElement(name = "Id_TipoFormaPago")
    protected int idTipoFormaPago;
    @XmlElement(name = "Id_Folio", required = true, nillable = true)
    protected String idFolio;
    @XmlElement(name = "Id_TipoCFDI")
    protected int idTipoCFDI;
    @XmlElement(name = "Id_Moneda")
    protected int idMoneda;
    @XmlElement(name = "Bit_Pagada")
    protected boolean bitPagada;
    @XmlElement(name = "Folio", required = true, type = Integer.class, nillable = true)
    protected Integer folio;
    @XmlElement(name = "FormaPagoTexto")
    protected String formaPagoTexto;
    @XmlElement(name = "ComentarioConcepto")
    protected String comentarioConcepto;
    @XmlElement(name = "Id_tickets_Lista")
    protected String idTicketsLista;
    @XmlElement(name = "Id_tickets_HASH")
    protected String idTicketsHASH;
    @XmlElement(name = "NumeroCliente")
    protected String numeroCliente;
    @XmlElement(name = "NumeroOrden")
    protected String numeroOrden;
    @XmlElement(name = "NumeroProveedor")
    protected String numeroProveedor;
    @XmlElement(name = "NombreAgenteVentas")
    protected String nombreAgenteVentas;
    @XmlElement(name = "NombreComprador")
    protected String nombreComprador;
    @XmlElement(name = "NombreComercial")
    protected String nombreComercial;
    @XmlElement(name = "Observaciones")
    protected String observaciones;

    /**
     * Obtiene el valor de la propiedad idNumEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNumEmisor() {
        return idNumEmisor;
    }

    /**
     * Define el valor de la propiedad idNumEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNumEmisor(String value) {
        this.idNumEmisor = value;
    }

    /**
     * Obtiene el valor de la propiedad idNumReceptor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNumReceptor() {
        return idNumReceptor;
    }

    /**
     * Define el valor de la propiedad idNumReceptor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNumReceptor(String value) {
        this.idNumReceptor = value;
    }

    /**
     * Obtiene el valor de la propiedad idUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdUsuario() {
        return idUsuario;
    }

    /**
     * Define el valor de la propiedad idUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdUsuario(String value) {
        this.idUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad idOficina.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdOficina() {
        return idOficina;
    }

    /**
     * Define el valor de la propiedad idOficina.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdOficina(String value) {
        this.idOficina = value;
    }

    /**
     * Obtiene el valor de la propiedad importeLetra.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteLetra() {
        return importeLetra;
    }

    /**
     * Define el valor de la propiedad importeLetra.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteLetra(String value) {
        this.importeLetra = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoFormaPago.
     * 
     */
    public int getIdTipoFormaPago() {
        return idTipoFormaPago;
    }

    /**
     * Define el valor de la propiedad idTipoFormaPago.
     * 
     */
    public void setIdTipoFormaPago(int value) {
        this.idTipoFormaPago = value;
    }

    /**
     * Obtiene el valor de la propiedad idFolio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdFolio() {
        return idFolio;
    }

    /**
     * Define el valor de la propiedad idFolio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdFolio(String value) {
        this.idFolio = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoCFDI.
     * 
     */
    public int getIdTipoCFDI() {
        return idTipoCFDI;
    }

    /**
     * Define el valor de la propiedad idTipoCFDI.
     * 
     */
    public void setIdTipoCFDI(int value) {
        this.idTipoCFDI = value;
    }

    /**
     * Obtiene el valor de la propiedad idMoneda.
     * 
     */
    public int getIdMoneda() {
        return idMoneda;
    }

    /**
     * Define el valor de la propiedad idMoneda.
     * 
     */
    public void setIdMoneda(int value) {
        this.idMoneda = value;
    }

    /**
     * Obtiene el valor de la propiedad bitPagada.
     * 
     */
    public boolean isBitPagada() {
        return bitPagada;
    }

    /**
     * Define el valor de la propiedad bitPagada.
     * 
     */
    public void setBitPagada(boolean value) {
        this.bitPagada = value;
    }

    /**
     * Obtiene el valor de la propiedad folio.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getFolio() {
        return folio;
    }

    /**
     * Define el valor de la propiedad folio.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setFolio(Integer value) {
        this.folio = value;
    }

    /**
     * Obtiene el valor de la propiedad formaPagoTexto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPagoTexto() {
        return formaPagoTexto;
    }

    /**
     * Define el valor de la propiedad formaPagoTexto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPagoTexto(String value) {
        this.formaPagoTexto = value;
    }

    /**
     * Obtiene el valor de la propiedad comentarioConcepto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComentarioConcepto() {
        return comentarioConcepto;
    }

    /**
     * Define el valor de la propiedad comentarioConcepto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComentarioConcepto(String value) {
        this.comentarioConcepto = value;
    }

    /**
     * Obtiene el valor de la propiedad idTicketsLista.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTicketsLista() {
        return idTicketsLista;
    }

    /**
     * Define el valor de la propiedad idTicketsLista.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTicketsLista(String value) {
        this.idTicketsLista = value;
    }

    /**
     * Obtiene el valor de la propiedad idTicketsHASH.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTicketsHASH() {
        return idTicketsHASH;
    }

    /**
     * Define el valor de la propiedad idTicketsHASH.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTicketsHASH(String value) {
        this.idTicketsHASH = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroCliente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Define el valor de la propiedad numeroCliente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCliente(String value) {
        this.numeroCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroOrden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroOrden() {
        return numeroOrden;
    }

    /**
     * Define el valor de la propiedad numeroOrden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroOrden(String value) {
        this.numeroOrden = value;
    }

    /**
     * Obtiene el valor de la propiedad numeroProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroProveedor() {
        return numeroProveedor;
    }

    /**
     * Define el valor de la propiedad numeroProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroProveedor(String value) {
        this.numeroProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreAgenteVentas.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreAgenteVentas() {
        return nombreAgenteVentas;
    }

    /**
     * Define el valor de la propiedad nombreAgenteVentas.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreAgenteVentas(String value) {
        this.nombreAgenteVentas = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreComprador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreComprador() {
        return nombreComprador;
    }

    /**
     * Define el valor de la propiedad nombreComprador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreComprador(String value) {
        this.nombreComprador = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreComercial.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     * Define el valor de la propiedad nombreComercial.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreComercial(String value) {
        this.nombreComercial = value;
    }

    /**
     * Obtiene el valor de la propiedad observaciones.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * Define el valor de la propiedad observaciones.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObservaciones(String value) {
        this.observaciones = value;
    }

}
