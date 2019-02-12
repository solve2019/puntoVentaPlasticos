
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
 *         &lt;element name="obtieneAcuseCancelacionResult" type="{http://tempuri.org/}IOAcuseTimbradoCfdi" minOccurs="0"/>
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
    "obtieneAcuseCancelacionResult"
})
@XmlRootElement(name = "obtieneAcuseCancelacionResponse")
public class ObtieneAcuseCancelacionResponse {

    protected IOAcuseTimbradoCfdi obtieneAcuseCancelacionResult;

    /**
     * Obtiene el valor de la propiedad obtieneAcuseCancelacionResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public IOAcuseTimbradoCfdi getObtieneAcuseCancelacionResult() {
        return obtieneAcuseCancelacionResult;
    }

    /**
     * Define el valor de la propiedad obtieneAcuseCancelacionResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public void setObtieneAcuseCancelacionResult(IOAcuseTimbradoCfdi value) {
        this.obtieneAcuseCancelacionResult = value;
    }

}
