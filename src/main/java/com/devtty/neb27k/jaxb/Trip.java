//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.04 at 02:33:07 PM CEST 
//


package com.devtty.neb27k.jaxb;

import com.devtty.neb27k.jaxb.EcoType;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence minOccurs="0">
 *         &lt;element ref="{hafas_rest}Messages" minOccurs="0"/>
 *         &lt;element name="Eco" type="{hafas_rest}EcoType" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}ServiceDays" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}LegList"/>
 *         &lt;element ref="{hafas_rest}TariffResult" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{hafas_rest}attlist.Trip"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messages",
    "eco",
    "serviceDays",
    "legList",
    "tariffResult"
})
@XmlRootElement(name = "Trip")
public class Trip {

    @XmlElement(name = "Messages")
    protected Messages messages;
    @XmlElement(name = "Eco")
    protected EcoType eco;
    @XmlElement(name = "ServiceDays")
    protected List<ServiceDays> serviceDays;
    @XmlElement(name = "LegList")
    protected LegList legList;
    @XmlElement(name = "TariffResult")
    protected TariffResult tariffResult;
    @XmlAttribute(name = "alternative")
    protected Boolean alternative;
    @XmlAttribute(name = "valid")
    protected Boolean valid;
    @XmlAttribute(name = "idx")
    protected Integer idx;
    @XmlAttribute(name = "tripId")
    protected String tripId;
    @XmlAttribute(name = "ctxRecon")
    protected String ctxRecon;
    @XmlAttribute(name = "duration")
    protected Duration duration;
    @XmlAttribute(name = "return")
    protected Boolean _return;

    /**
     * Gets the value of the messages property.
     * 
     * @return
     *     possible object is
     *     {@link Messages }
     *     
     */
    public Messages getMessages() {
        return messages;
    }

    /**
     * Sets the value of the messages property.
     * 
     * @param value
     *     allowed object is
     *     {@link Messages }
     *     
     */
    public void setMessages(Messages value) {
        this.messages = value;
    }

    /**
     * Gets the value of the eco property.
     * 
     * @return
     *     possible object is
     *     {@link EcoType }
     *     
     */
    public EcoType getEco() {
        return eco;
    }

    /**
     * Sets the value of the eco property.
     * 
     * @param value
     *     allowed object is
     *     {@link EcoType }
     *     
     */
    public void setEco(EcoType value) {
        this.eco = value;
    }

    /**
     * Gets the value of the serviceDays property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceDays property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceDays().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ServiceDays }
     * 
     * 
     */
    public List<ServiceDays> getServiceDays() {
        if (serviceDays == null) {
            serviceDays = new ArrayList<ServiceDays>();
        }
        return this.serviceDays;
    }

    /**
     * The element LegList contains all legs of the computed trip.
     * 
     * @return
     *     possible object is
     *     {@link LegList }
     *     
     */
    public LegList getLegList() {
        return legList;
    }

    /**
     * Sets the value of the legList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LegList }
     *     
     */
    public void setLegList(LegList value) {
        this.legList = value;
    }

    /**
     * Gets the value of the tariffResult property.
     * 
     * @return
     *     possible object is
     *     {@link TariffResult }
     *     
     */
    public TariffResult getTariffResult() {
        return tariffResult;
    }

    /**
     * Sets the value of the tariffResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link TariffResult }
     *     
     */
    public void setTariffResult(TariffResult value) {
        this.tariffResult = value;
    }

    /**
     * Gets the value of the alternative property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAlternative() {
        if (alternative == null) {
            return false;
        } else {
            return alternative;
        }
    }

    /**
     * Sets the value of the alternative property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlternative(Boolean value) {
        this.alternative = value;
    }

    /**
     * Gets the value of the valid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isValid() {
        if (valid == null) {
            return true;
        } else {
            return valid;
        }
    }

    /**
     * Sets the value of the valid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setValid(Boolean value) {
        this.valid = value;
    }

    /**
     * Gets the value of the idx property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdx() {
        return idx;
    }

    /**
     * Sets the value of the idx property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdx(Integer value) {
        this.idx = value;
    }

    /**
     * Gets the value of the tripId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * Sets the value of the tripId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTripId(String value) {
        this.tripId = value;
    }

    /**
     * Gets the value of the ctxRecon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCtxRecon() {
        return ctxRecon;
    }

    /**
     * Sets the value of the ctxRecon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCtxRecon(String value) {
        this.ctxRecon = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDuration(Duration value) {
        this.duration = value;
    }

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isReturn() {
        if (_return == null) {
            return false;
        } else {
            return _return;
        }
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturn(Boolean value) {
        this._return = value;
    }

}
