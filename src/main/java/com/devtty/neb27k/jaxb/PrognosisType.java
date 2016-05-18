//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.04 at 02:33:07 PM CEST 
//


package com.devtty.neb27k.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PrognosisType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PrognosisType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PROGNOSED"/>
 *     &lt;enumeration value="MANUAL"/>
 *     &lt;enumeration value="REPORTED"/>
 *     &lt;enumeration value="CORRECTED"/>
 *     &lt;enumeration value="CALCULATED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrognosisType")
@XmlEnum
public enum PrognosisType {


    /**
     * Prognosis was reported from an external provider as a prognosis for the future.
     * 
     */
    PROGNOSED,

    /**
     * Prognosis was reported from an external provider from a manual entry.
     * 
     */
    MANUAL,

    /**
     * Prognosis was reported from an external provider as a delay for previously passed stations.
     * 
     */
    REPORTED,

    /**
     * Prognosis was corrected by the system to adjust the prognoses over the train's journey to ensure proper continuation.
     * 
     */
    CORRECTED,

    /**
     * Prognosis was calculated by the system for upcoming stations or to fill gaps for previously passed stations where no delay was reported.
     * 
     */
    CALCULATED;

    public String value() {
        return name();
    }

    public static PrognosisType fromValue(String v) {
        return valueOf(v);
    }

}