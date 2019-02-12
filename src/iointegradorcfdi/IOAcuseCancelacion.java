
package iointegradorcfdi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para IOAcuseCancelacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="IOAcuseCancelacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="XmlAcuse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ComprobantesCancelado" type="{http://tempuri.org/}ArrayOfComprobanteCancelado" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "IOAcuseCancelacion", propOrder = {
    "xmlAcuse",
    "comprobantesCancelado"
})
public class IOAcuseCancelacion {

    @XmlElement(name = "XmlAcuse")
    protected String xmlAcuse;
    @XmlElement(name = "ComprobantesCancelado")
    protected ArrayOfComprobanteCancelado comprobantesCancelado;

    /**
     * Obtiene el valor de la propiedad xmlAcuse.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXmlAcuse() {
        return xmlAcuse;
    }

    /**
     * Define el valor de la propiedad xmlAcuse.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXmlAcuse(String value) {
        this.xmlAcuse = value;
    }

    /**
     * Obtiene el valor de la propiedad comprobantesCancelado.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfComprobanteCancelado }
     *     
     */
    public ArrayOfComprobanteCancelado getComprobantesCancelado() {
        return comprobantesCancelado;
    }

    /**
     * Define el valor de la propiedad comprobantesCancelado.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfComprobanteCancelado }
     *     
     */
    public void setComprobantesCancelado(ArrayOfComprobanteCancelado value) {
        this.comprobantesCancelado = value;
    }

}
