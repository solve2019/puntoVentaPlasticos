
package iointegradorcfdi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InfoIntegrador complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InfoIntegrador">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Produccion_FoliosTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Produccion_FoliosConsumidos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pruebas_FoliosTotal" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pruebas_FoliosConsumidos" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="FechaConsulta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InfoIntegrador", propOrder = {
    "produccionFoliosTotal",
    "produccionFoliosConsumidos",
    "pruebasFoliosTotal",
    "pruebasFoliosConsumidos",
    "fechaConsulta"
})
public class InfoIntegrador {

    @XmlElement(name = "Produccion_FoliosTotal")
    protected int produccionFoliosTotal;
    @XmlElement(name = "Produccion_FoliosConsumidos")
    protected int produccionFoliosConsumidos;
    @XmlElement(name = "Pruebas_FoliosTotal")
    protected int pruebasFoliosTotal;
    @XmlElement(name = "Pruebas_FoliosConsumidos")
    protected int pruebasFoliosConsumidos;
    @XmlElement(name = "FechaConsulta")
    protected String fechaConsulta;

    /**
     * Obtiene el valor de la propiedad produccionFoliosTotal.
     * 
     */
    public int getProduccionFoliosTotal() {
        return produccionFoliosTotal;
    }

    /**
     * Define el valor de la propiedad produccionFoliosTotal.
     * 
     */
    public void setProduccionFoliosTotal(int value) {
        this.produccionFoliosTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad produccionFoliosConsumidos.
     * 
     */
    public int getProduccionFoliosConsumidos() {
        return produccionFoliosConsumidos;
    }

    /**
     * Define el valor de la propiedad produccionFoliosConsumidos.
     * 
     */
    public void setProduccionFoliosConsumidos(int value) {
        this.produccionFoliosConsumidos = value;
    }

    /**
     * Obtiene el valor de la propiedad pruebasFoliosTotal.
     * 
     */
    public int getPruebasFoliosTotal() {
        return pruebasFoliosTotal;
    }

    /**
     * Define el valor de la propiedad pruebasFoliosTotal.
     * 
     */
    public void setPruebasFoliosTotal(int value) {
        this.pruebasFoliosTotal = value;
    }

    /**
     * Obtiene el valor de la propiedad pruebasFoliosConsumidos.
     * 
     */
    public int getPruebasFoliosConsumidos() {
        return pruebasFoliosConsumidos;
    }

    /**
     * Define el valor de la propiedad pruebasFoliosConsumidos.
     * 
     */
    public void setPruebasFoliosConsumidos(int value) {
        this.pruebasFoliosConsumidos = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaConsulta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * Define el valor de la propiedad fechaConsulta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaConsulta(String value) {
        this.fechaConsulta = value;
    }

}
