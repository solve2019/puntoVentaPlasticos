
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
 *         &lt;element name="cancelaCFDIPruebasResult" type="{http://tempuri.org/}IOAcuseCancelacion" minOccurs="0"/>
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
    "cancelaCFDIPruebasResult"
})
@XmlRootElement(name = "cancelaCFDIPruebasResponse")
public class CancelaCFDIPruebasResponse {

    protected IOAcuseCancelacion cancelaCFDIPruebasResult;

    /**
     * Obtiene el valor de la propiedad cancelaCFDIPruebasResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public IOAcuseCancelacion getCancelaCFDIPruebasResult() {
        return cancelaCFDIPruebasResult;
    }

    /**
     * Define el valor de la propiedad cancelaCFDIPruebasResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public void setCancelaCFDIPruebasResult(IOAcuseCancelacion value) {
        this.cancelaCFDIPruebasResult = value;
    }

}
