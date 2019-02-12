
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
 *         &lt;element name="obtenerInfoIntegradorResult" type="{http://tempuri.org/}InfoIntegrador" minOccurs="0"/>
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
    "obtenerInfoIntegradorResult"
})
@XmlRootElement(name = "obtenerInfoIntegradorResponse")
public class ObtenerInfoIntegradorResponse {

    protected InfoIntegrador obtenerInfoIntegradorResult;

    /**
     * Obtiene el valor de la propiedad obtenerInfoIntegradorResult.
     * 
     * @return
     *     possible object is
     *     {@link InfoIntegrador }
     *     
     */
    public InfoIntegrador getObtenerInfoIntegradorResult() {
        return obtenerInfoIntegradorResult;
    }

    /**
     * Define el valor de la propiedad obtenerInfoIntegradorResult.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoIntegrador }
     *     
     */
    public void setObtenerInfoIntegradorResult(InfoIntegrador value) {
        this.obtenerInfoIntegradorResult = value;
    }

}
