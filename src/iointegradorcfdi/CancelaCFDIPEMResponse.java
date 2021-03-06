
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
 *         &lt;element name="cancelaCFDI_PEMResult" type="{http://tempuri.org/}IOAcuseCancelacion" minOccurs="0"/>
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
    "cancelaCFDIPEMResult"
})
@XmlRootElement(name = "cancelaCFDI_PEMResponse")
public class CancelaCFDIPEMResponse {

    @XmlElement(name = "cancelaCFDI_PEMResult")
    protected IOAcuseCancelacion cancelaCFDIPEMResult;

    /**
     * Obtiene el valor de la propiedad cancelaCFDIPEMResult.
     * 
     * @return
     *     possible object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public IOAcuseCancelacion getCancelaCFDIPEMResult() {
        return cancelaCFDIPEMResult;
    }

    /**
     * Define el valor de la propiedad cancelaCFDIPEMResult.
     * 
     * @param value
     *     allowed object is
     *     {@link IOAcuseCancelacion }
     *     
     */
    public void setCancelaCFDIPEMResult(IOAcuseCancelacion value) {
        this.cancelaCFDIPEMResult = value;
    }

}
