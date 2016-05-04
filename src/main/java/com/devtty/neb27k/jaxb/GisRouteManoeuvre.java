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
 * <p>Java class for GisRouteManoeuvre.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GisRouteManoeuvre">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NO"/>
 *     &lt;enumeration value="FR"/>
 *     &lt;enumeration value="TO"/>
 *     &lt;enumeration value="ON"/>
 *     &lt;enumeration value="LE"/>
 *     &lt;enumeration value="RI"/>
 *     &lt;enumeration value="KL"/>
 *     &lt;enumeration value="KR"/>
 *     &lt;enumeration value="HL"/>
 *     &lt;enumeration value="HR"/>
 *     &lt;enumeration value="KHL"/>
 *     &lt;enumeration value="KHR"/>
 *     &lt;enumeration value="SL"/>
 *     &lt;enumeration value="SR"/>
 *     &lt;enumeration value="KSL"/>
 *     &lt;enumeration value="KSR"/>
 *     &lt;enumeration value="ST"/>
 *     &lt;enumeration value="UT"/>
 *     &lt;enumeration value="EN"/>
 *     &lt;enumeration value="LV"/>
 *     &lt;enumeration value="ER"/>
 *     &lt;enumeration value="SIR"/>
 *     &lt;enumeration value="LR"/>
 *     &lt;enumeration value="EF"/>
 *     &lt;enumeration value="LF"/>
 *     &lt;enumeration value="CH"/>
 *     &lt;enumeration value="CIF"/>
 *     &lt;enumeration value="COF"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GisRouteManoeuvre")
@XmlEnum
public enum GisRouteManoeuvre {


    /**
     * Not set
     * 
     */
    NO,

    /**
     * From
     * 
     */
    FR,

    /**
     * To
     * 
     */
    TO,

    /**
     * On
     * 
     */
    ON,

    /**
     * Left
     * 
     */
    LE,

    /**
     * Right
     * 
     */
    RI,

    /**
     * Keep left
     * 
     */
    KL,

    /**
     * Keep right
     * 
     */
    KR,

    /**
     * Half left
     * 
     */
    HL,

    /**
     * Half right
     * 
     */
    HR,

    /**
     * Keep half left
     * 
     */
    KHL,

    /**
     * Keep half right
     * 
     */
    KHR,

    /**
     * Sharp left
     * 
     */
    SL,

    /**
     * Sharp right
     * 
     */
    SR,

    /**
     * Keep sharp left
     * 
     */
    KSL,

    /**
     * Keep sharp right
     * 
     */
    KSR,

    /**
     * Straight
     * 
     */
    ST,

    /**
     * U-Turn
     * 
     */
    UT,

    /**
     * Enter
     * 
     */
    EN,

    /**
     * Leave
     * 
     */
    LV,

    /**
     * Enter roundabout
     * 
     */
    ER,

    /**
     * Stay in roundabout
     * 
     */
    SIR,

    /**
     * Leave roundabout
     * 
     */
    LR,

    /**
     * Enter ferry
     * 
     */
    EF,

    /**
     * Leave ferry
     * 
     */
    LF,

    /**
     * Change highway
     * 
     */
    CH,

    /**
     * Check-in ferry
     * 
     */
    CIF,

    /**
     * Check-out ferry
     * 
     */
    COF;

    public String value() {
        return name();
    }

    public static GisRouteManoeuvre fromValue(String v) {
        return valueOf(v);
    }

}
