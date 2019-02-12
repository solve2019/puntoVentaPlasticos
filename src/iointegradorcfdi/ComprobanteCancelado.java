
package iointegradorcfdi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ComprobanteCancelado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ComprobanteCancelado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UUID" type="{http://microsoft.com/wsdl/types/}guid"/>
 *         &lt;element name="Cancelado" type="{http://tempuri.org/}EnumCancelado"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComprobanteCancelado", propOrder = {
    "uuid",
    "cancelado"
})
public class ComprobanteCancelado {

    @XmlElement(name = "UUID", required = true)
    protected String uuid;
    @XmlElement(name = "Cancelado", required = true)
    protected EnumCancelado cancelado;

    /**
     * Obtiene el valor de la propiedad uuid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUUID() {
        return uuid;
    }

    /**
     * Define el valor de la propiedad uuid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUUID(String value) {
        this.uuid = value;
    }

    /**
     * Obtiene el valor de la propiedad cancelado.
     * 
     * @return
     *     possible object is
     *     {@link EnumCancelado }
     *     
     */
    public EnumCancelado getCancelado() {
        return cancelado;
    }

    /**
     * Define el valor de la propiedad cancelado.
     * 
     * @param value
     *     allowed object is
     *     {@link EnumCancelado }
     *     
     */
    public void setCancelado(EnumCancelado value) {
        this.cancelado = value;
    }

}
