
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombreUsuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contrasena" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rfcEmisor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaUuid" type="{http://tempuri.org/}ArrayOfGuid" minOccurs="0"/>
 *         &lt;element name="pfxBase64" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contrasenaPfx" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nombreUsuario",
    "contrasena",
    "rfcEmisor",
    "listaUuid",
    "pfxBase64",
    "contrasenaPfx"
})
@XmlRootElement(name = "cancelaCFDIPruebas")
public class CancelaCFDIPruebas {

    protected String nombreUsuario;
    protected String contrasena;
    protected String rfcEmisor;
    protected ArrayOfGuid listaUuid;
    protected String pfxBase64;
    protected String contrasenaPfx;

    /**
     * Obtiene el valor de la propiedad nombreUsuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Define el valor de la propiedad nombreUsuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreUsuario(String value) {
        this.nombreUsuario = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Define el valor de la propiedad contrasena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasena(String value) {
        this.contrasena = value;
    }

    /**
     * Obtiene el valor de la propiedad rfcEmisor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRfcEmisor() {
        return rfcEmisor;
    }

    /**
     * Define el valor de la propiedad rfcEmisor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRfcEmisor(String value) {
        this.rfcEmisor = value;
    }

    /**
     * Obtiene el valor de la propiedad listaUuid.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGuid }
     *     
     */
    public ArrayOfGuid getListaUuid() {
        return listaUuid;
    }

    /**
     * Define el valor de la propiedad listaUuid.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGuid }
     *     
     */
    public void setListaUuid(ArrayOfGuid value) {
        this.listaUuid = value;
    }

    /**
     * Obtiene el valor de la propiedad pfxBase64.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPfxBase64() {
        return pfxBase64;
    }

    /**
     * Define el valor de la propiedad pfxBase64.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPfxBase64(String value) {
        this.pfxBase64 = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasenaPfx.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasenaPfx() {
        return contrasenaPfx;
    }

    /**
     * Define el valor de la propiedad contrasenaPfx.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasenaPfx(String value) {
        this.contrasenaPfx = value;
    }

}
