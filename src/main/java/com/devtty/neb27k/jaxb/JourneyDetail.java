//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.04 at 02:33:07 PM CEST 
//


package com.devtty.neb27k.jaxb;

import com.devtty.neb27k.jaxb.GeometryRef;
import com.devtty.neb27k.jaxb.Directions;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element ref="{hafas_rest}Stops"/>
 *         &lt;element ref="{hafas_rest}GeometryRef" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}Names" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}Directions" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}Notes" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}Messages" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}JourneyStatus" minOccurs="0"/>
 *         &lt;element name="Polyline" type="{hafas_rest}Polyline" minOccurs="0"/>
 *         &lt;element ref="{hafas_rest}ServiceDays" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{hafas_rest}attlist.Common"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "stops",
    "geometryRef",
    "names",
    "directions",
    "notes",
    "messages",
    "journeyStatus",
    "polyline",
    "serviceDays"
})
@XmlRootElement(name = "JourneyDetail")
public class JourneyDetail {

    @XmlElement(name = "Stops")
    protected Stops stops;
    @XmlElement(name = "GeometryRef")
    protected GeometryRef geometryRef;
    @XmlElement(name = "Names")
    protected Names names;
    @XmlElement(name = "Directions")
    protected Directions directions;
    @XmlElement(name = "Notes")
    protected Notes notes;
    @XmlElement(name = "Messages")
    protected Messages messages;
    @XmlElement(name = "JourneyStatus")
    protected String journeyStatus;
    @XmlElement(name = "Polyline")
    protected Polyline polyline;
    @XmlElement(name = "ServiceDays")
    protected List<ServiceDays> serviceDays;
    @XmlAttribute(name = "serverVersion")
    protected String serverVersion;
    @XmlAttribute(name = "dialectVersion")
    protected String dialectVersion;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "errorCode")
    protected String errorCode;
    @XmlAttribute(name = "errorText")
    protected String errorText;

    /**
     * Gets the value of the stops property.
     * 
     * @return
     *     possible object is
     *     {@link Stops }
     *     
     */
    public Stops getStops() {
        return stops;
    }

    /**
     * Sets the value of the stops property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stops }
     *     
     */
    public void setStops(Stops value) {
        this.stops = value;
    }

    /**
     * Gets the value of the geometryRef property.
     * 
     * @return
     *     possible object is
     *     {@link GeometryRef }
     *     
     */
    public GeometryRef getGeometryRef() {
        return geometryRef;
    }

    /**
     * Sets the value of the geometryRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryRef }
     *     
     */
    public void setGeometryRef(GeometryRef value) {
        this.geometryRef = value;
    }

    /**
     * Gets the value of the names property.
     * 
     * @return
     *     possible object is
     *     {@link Names }
     *     
     */
    public Names getNames() {
        return names;
    }

    /**
     * Sets the value of the names property.
     * 
     * @param value
     *     allowed object is
     *     {@link Names }
     *     
     */
    public void setNames(Names value) {
        this.names = value;
    }

    /**
     * Gets the value of the directions property.
     * 
     * @return
     *     possible object is
     *     {@link Directions }
     *     
     */
    public Directions getDirections() {
        return directions;
    }

    /**
     * Sets the value of the directions property.
     * 
     * @param value
     *     allowed object is
     *     {@link Directions }
     *     
     */
    public void setDirections(Directions value) {
        this.directions = value;
    }

    /**
     * Contains notes to be displayed for this trip like attributes or footnotes.
     * 
     * @return
     *     possible object is
     *     {@link Notes }
     *     
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link Notes }
     *     
     */
    public void setNotes(Notes value) {
        this.notes = value;
    }

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
     * Gets the value of the journeyStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJourneyStatus() {
        return journeyStatus;
    }

    /**
     * Sets the value of the journeyStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJourneyStatus(String value) {
        this.journeyStatus = value;
    }

    /**
     * Gets the value of the polyline property.
     * 
     * @return
     *     possible object is
     *     {@link Polyline }
     *     
     */
    public Polyline getPolyline() {
        return polyline;
    }

    /**
     * Sets the value of the polyline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Polyline }
     *     
     */
    public void setPolyline(Polyline value) {
        this.polyline = value;
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
     * Gets the value of the serverVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServerVersion() {
        return serverVersion;
    }

    /**
     * Sets the value of the serverVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServerVersion(String value) {
        this.serverVersion = value;
    }

    /**
     * Gets the value of the dialectVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDialectVersion() {
        return dialectVersion;
    }

    /**
     * Sets the value of the dialectVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDialectVersion(String value) {
        this.dialectVersion = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorCode(String value) {
        this.errorCode = value;
    }

    /**
     * Gets the value of the errorText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorText() {
        return errorText;
    }

    /**
     * Sets the value of the errorText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorText(String value) {
        this.errorText = value;
    }

}
