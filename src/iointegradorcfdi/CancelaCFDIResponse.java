
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
 *         &lt;element name="cancelaCFDIResult" type="{http://tempuri.org/}IOAcuseCancelacion" minOccurs="0"/>
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
    "cancelaCFDIResult"
})
@XmlRootElement(name = "cancelaCFDIResponse")
public class CancelaCFDIResponse {

    protected IOAcuseCancelacion cancelaCFDIResult;

    /**
     * Obtiene el valor de la propiedad cancelaCFDIResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public IOAcuseCancelacion getCancelaCFDIResult() {
        return cancelaCFDIResult;
    }

    /**
     * Define el valor de la propiedad cancelaCFDIResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public void setCancelaCFDIResult(IOAcuseCancelacion value) {
        this.cancelaCFDIResult = value;
    }

}
