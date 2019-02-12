
package iointegradorcfdi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para EnumCancelado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="EnumCancelado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NoValido"/>
 *     &lt;enumeration value="Cancelado"/>
 *     &lt;enumeration value="PreviamenteCancelado"/>
 *     &lt;enumeration value="NoCorrespondeAlEmisor"/>
 *     &lt;enumeration value="NoAplicableParaCancelacion"/>
 *     &lt;enumeration value="UUIDNoExiste"/>
 *     &lt;enumeration value="NoIdentificado206"/>
 *     &lt;enumeration value="NoIdentificado207"/>
 *     &lt;enumeration value="NoIdentificado208"/>
 *     &lt;enumeration value="NoIdentificado209"/>
 *     &lt;enumeration value="NoIdentificado210"/>
 *     &lt;enumeration value="NoVerificado"/>
 *     &lt;enumeration value="UsuarioNoExiste"/>
 *     &lt;enumeration value="NoCumpleConEstandarXSD"/>
 *     &lt;enumeration value="SelloDelEmisorInvalido"/>
 *     &lt;enumeration value="CSDEmisorNoCorrespondeRFC"/>
 *     &lt;enumeration value="CSDEmisorRevocado"/>
 *     &lt;enumeration value="FechaEmisionFueraDeVigencia"/>
 *     &lt;enumeration value="CSDesFIEL"/>
 *     &lt;enumeration value="TimbrePrevio"/>
 *     &lt;enumeration value="CSDNoValidoPorSAT"/>
 *     &lt;enumeration value="FechaMayor72Horas"/>
 *     &lt;enumeration value="RFCSinValidesDeObligacion"/>
 *     &lt;enumeration value="FechaInferiorAEnero"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EnumCancelado")
@XmlEnum
public enum EnumCancelado {

    @XmlEnumValue("NoValido")
    NO_VALIDO("NoValido"),
    @XmlEnumValue("Cancelado")
    CANCELADO("Cancelado"),
    @XmlEnumValue("PreviamenteCancelado")
    PREVIAMENTE_CANCELADO("PreviamenteCancelado"),
    @XmlEnumValue("NoCorrespondeAlEmisor")
    NO_CORRESPONDE_AL_EMISOR("NoCorrespondeAlEmisor"),
    @XmlEnumValue("NoAplicableParaCancelacion")
    NO_APLICABLE_PARA_CANCELACION("NoAplicableParaCancelacion"),
    @XmlEnumValue("UUIDNoExiste")
    UUID_NO_EXISTE("UUIDNoExiste"),
    @XmlEnumValue("NoIdentificado206")
    NO_IDENTIFICADO_206("NoIdentificado206"),
    @XmlEnumValue("NoIdentificado207")
    NO_IDENTIFICADO_207("NoIdentificado207"),
    @XmlEnumValue("NoIdentificado208")
    NO_IDENTIFICADO_208("NoIdentificado208"),
    @XmlEnumValue("NoIdentificado209")
    NO_IDENTIFICADO_209("NoIdentificado209"),
    @XmlEnumValue("NoIdentificado210")
    NO_IDENTIFICADO_210("NoIdentificado210"),
    @XmlEnumValue("NoVerificado")
    NO_VERIFICADO("NoVerificado"),
    @XmlEnumValue("UsuarioNoExiste")
    USUARIO_NO_EXISTE("UsuarioNoExiste"),
    @XmlEnumValue("NoCumpleConEstandarXSD")
    NO_CUMPLE_CON_ESTANDAR_XSD("NoCumpleConEstandarXSD"),
    @XmlEnumValue("SelloDelEmisorInvalido")
    SELLO_DEL_EMISOR_INVALIDO("SelloDelEmisorInvalido"),
    @XmlEnumValue("CSDEmisorNoCorrespondeRFC")
    CSD_EMISOR_NO_CORRESPONDE_RFC("CSDEmisorNoCorrespondeRFC"),
    @XmlEnumValue("CSDEmisorRevocado")
    CSD_EMISOR_REVOCADO("CSDEmisorRevocado"),
    @XmlEnumValue("FechaEmisionFueraDeVigencia")
    FECHA_EMISION_FUERA_DE_VIGENCIA("FechaEmisionFueraDeVigencia"),
    @XmlEnumValue("CSDesFIEL")
    CS_DES_FIEL("CSDesFIEL"),
    @XmlEnumValue("TimbrePrevio")
    TIMBRE_PREVIO("TimbrePrevio"),
    @XmlEnumValue("CSDNoValidoPorSAT")
    CSD_NO_VALIDO_POR_SAT("CSDNoValidoPorSAT"),
    @XmlEnumValue("FechaMayor72Horas")
    FECHA_MAYOR_72_HORAS("FechaMayor72Horas"),
    @XmlEnumValue("RFCSinValidesDeObligacion")
    RFC_SIN_VALIDES_DE_OBLIGACION("RFCSinValidesDeObligacion"),
    @XmlEnumValue("FechaInferiorAEnero")
    FECHA_INFERIOR_A_ENERO("FechaInferiorAEnero");
    private final String value;

    EnumCancelado(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EnumCancelado fromValue(String v) {
        for (EnumCancelado c: EnumCancelado.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
