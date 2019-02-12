
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
 *         &lt;element name="ObtenerCFDIPruebaResult" type="{http://tempuri.org/}IOAcuseTimbradoCfdi" minOccurs="0"/>
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
    "obtenerCFDIPruebaResult"
})
@XmlRootElement(name = "ObtenerCFDIPruebaResponse")
public class ObtenerCFDIPruebaResponse {

    @XmlElement(name = "ObtenerCFDIPruebaResult")
    protected IOAcuseTimbradoCfdi obtenerCFDIPruebaResult;

    /**
     * Obtiene el valor de la propiedad obtenerCFDIPruebaResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public IOAcuseTimbradoCfdi getObtenerCFDIPruebaResult() {
        return obtenerCFDIPruebaResult;
    }

    /**
     * Define el valor de la propiedad obtenerCFDIPruebaResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseTimbradoCfdi }
     *     
     */
    public void setObtenerCFDIPruebaResult(IOAcuseTimbradoCfdi value) {
        this.obtenerCFDIPruebaResult = value;
    }

}
