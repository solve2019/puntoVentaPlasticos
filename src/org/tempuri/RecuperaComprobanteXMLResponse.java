
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
 *         &lt;element name="recuperaComprobanteXMLResult" type="{http://tempuri.org/}IOAcuseTimbradoCfdi" minOccurs="0"/>
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
    "recuperaComprobanteXMLResult"
})
@XmlRootElement(name = "recuperaComprobanteXMLResponse")
public class RecuperaComprobanteXMLResponse {

    protected IOAcuseTimbradoCfdi recuperaComprobanteXMLResult;

    /**
     * Obtiene el valor de la propiedad recuperaComprobanteXMLResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public IOAcuseTimbradoCfdi getRecuperaComprobanteXMLResult() {
        return recuperaComprobanteXMLResult;
    }

    /**
     * Define el valor de la propiedad recuperaComprobanteXMLResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public void setRecuperaComprobanteXMLResult(IOAcuseTimbradoCfdi value) {
        this.recuperaComprobanteXMLResult = value;
    }

}
