
package org.tempuri;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * <p>Clase Java para SoapHeaderAplicativoGratuito complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="SoapHeaderAplicativoGratuito">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id_TicketAplicativoGratuito" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Id_Token" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="FechaCreacion" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="FechaExpira" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="InfoCfdi" type="{http://tempuri.org/}AppInfoCfdi" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SoapHeaderAplicativoGratuito", propOrder = {
    "idTicketAplicativoGratuito",
    "idToken",
    "fechaCreacion",
    "fechaExpira",
    "infoCfdi"
})
public class SoapHeaderAplicativoGratuito {

    @XmlElement(name = "Id_TicketAplicativoGratuito", required = true)
    protected String idTicketAplicativoGratuito;
    @XmlElement(name = "Id_Token", required = true)
    protected String idToken;
    @XmlElement(name = "FechaCreacion")
    protected long fechaCreacion;
    @XmlElement(name = "FechaExpira")
    protected long fechaExpira;
    @XmlElement(name = "InfoCfdi")
    protected AppInfoCfdi infoCfdi;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Obtiene el valor de la propiedad idTicketAplicativoGratuito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTicketAplicativoGratuito() {
        return idTicketAplicativoGratuito;
    }

    /**
     * Define el valor de la propiedad idTicketAplicativoGratuito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTicketAplicativoGratuito(String value) {
        this.idTicketAplicativoGratuito = value;
    }

    /**
     * Obtiene el valor de la propiedad idToken.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdToken() {
        return idToken;
    }

    /**
     * Define el valor de la propiedad idToken.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdToken(String value) {
        this.idToken = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaCreacion.
     * 
     */
    public long getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Define el valor de la propiedad fechaCreacion.
     * 
     */
    public void setFechaCreacion(long value) {
        this.fechaCreacion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaExpira.
     * 
     */
    public long getFechaExpira() {
        return fechaExpira;
    }

    /**
     * Define el valor de la propiedad fechaExpira.
     * 
     */
    public void setFechaExpira(long value) {
        this.fechaExpira = value;
    }

    /**
     * Obtiene el valor de la propiedad infoCfdi.
     * 
     * @return
     *     possible object is
     *     {@link AppInfoCfdi }
     *     
     */
    public AppInfoCfdi getInfoCfdi() {
        return infoCfdi;
    }

    /**
     * Define el valor de la propiedad infoCfdi.
     * 
     * @param value
     *     allowed object is
     *     {@link AppInfoCfdi }
     *     
     */
    public void setInfoCfdi(AppInfoCfdi value) {
        this.infoCfdi = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

}
