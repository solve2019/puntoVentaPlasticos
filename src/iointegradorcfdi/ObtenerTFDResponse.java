
package iointegradorcfdi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="ObtenerTFDResult" type="{http://tempuri.org/}IOAcuseTimbradoCfdi" minOccurs="0"/>
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
    "obtenerTFDResult"
})
@XmlRootElement(name = "ObtenerTFDResponse")
public class ObtenerTFDResponse {

    @XmlElement(name = "ObtenerTFDResult")
    protected IOAcuseTimbradoCfdi obtenerTFDResult;

    /**
     * Obtiene el valor de la propiedad obtenerTFDResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public IOAcuseTimbradoCfdi getObtenerTFDResult() {
        return obtenerTFDResult;
    }

    /**
     * Define el valor de la propiedad obtenerTFDResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public void setObtenerTFDResult(IOAcuseTimbradoCfdi value) {
        this.obtenerTFDResult = value;
    }

}
