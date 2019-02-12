
package iointegradorcfdi;

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
 *         &lt;element name="cancelaSATPruebasResult" type="{http://tempuri.org/}IOAcuseCancelacion" minOccurs="0"/>
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
    "cancelaSATPruebasResult"
})
@XmlRootElement(name = "cancelaSATPruebasResponse")
public class CancelaSATPruebasResponse {

    protected IOAcuseCancelacion cancelaSATPruebasResult;

    /**
     * Obtiene el valor de la propiedad cancelaSATPruebasResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public IOAcuseCancelacion getCancelaSATPruebasResult() {
        return cancelaSATPruebasResult;
    }

    /**
     * Define el valor de la propiedad cancelaSATPruebasResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public void setCancelaSATPruebasResult(IOAcuseCancelacion value) {
        this.cancelaSATPruebasResult = value;
    }

}
