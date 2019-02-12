
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
 *         &lt;element name="cancelaSATResult" type="{http://tempuri.org/}IOAcuseCancelacion" minOccurs="0"/>
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
    "cancelaSATResult"
})
@XmlRootElement(name = "cancelaSATResponse")
public class CancelaSATResponse {

    protected IOAcuseCancelacion cancelaSATResult;

    /**
     * Obtiene el valor de la propiedad cancelaSATResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public IOAcuseCancelacion getCancelaSATResult() {
        return cancelaSATResult;
    }

    /**
     * Define el valor de la propiedad cancelaSATResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public void setCancelaSATResult(IOAcuseCancelacion value) {
        this.cancelaSATResult = value;
    }

}
