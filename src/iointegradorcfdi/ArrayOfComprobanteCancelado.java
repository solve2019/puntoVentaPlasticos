
package iointegradorcfdi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfComprobanteCancelado complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfComprobanteCancelado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ComprobanteCancelado" type="{http://tempuri.org/}ComprobanteCancelado" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfComprobanteCancelado", propOrder = {
    "comprobanteCancelado"
})
public class ArrayOfComprobanteCancelado {

    @XmlElement(name = "ComprobanteCancelado", nillable = true)
    protected List<ComprobanteCancelado> comprobanteCancelado;

    /**
     * Gets the value of the comprobanteCancelado property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comprobanteCancelado property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComprobanteCancelado().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ComprobanteCancelado }
     * 
     * 
     */
    public List<ComprobanteCancelado> getComprobanteCancelado() {
        if (comprobanteCancelado == null) {
            comprobanteCancelado = new ArrayList<ComprobanteCancelado>();
        }
        return this.comprobanteCancelado;
    }

}
