
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
 *         &lt;element name="obtenerCFDIconReferenciaResult" type="{http://tempuri.org/}IOAcuseTimbradoCfdi" minOccurs="0"/>
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
    "obtenerCFDIconReferenciaResult"
})
@XmlRootElement(name = "obtenerCFDIconReferenciaResponse")
public class ObtenerCFDIconReferenciaResponse {

    protected IOAcuseTimbradoCfdi obtenerCFDIconReferenciaResult;

    /**
     * Obtiene el valor de la propiedad obtenerCFDIconReferenciaResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public IOAcuseTimbradoCfdi getObtenerCFDIconReferenciaResult() {
        return obtenerCFDIconReferenciaResult;
    }

    /**
     * Define el valor de la propiedad obtenerCFDIconReferenciaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public void setObtenerCFDIconReferenciaResult(IOAcuseTimbradoCfdi value) {
        this.obtenerCFDIconReferenciaResult = value;
    }

}
