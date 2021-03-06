//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.04 at 02:33:07 PM CEST 
//


package com.devtty.neb27k.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.Duration;


/**
 * <p>Java class for GisRouteType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GisRouteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="seg" type="{hafas_rest}GisRouteSegment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="polyline" type="{hafas_rest}Polyline" minOccurs="0"/>
 *         &lt;element name="altPolyline" type="{hafas_rest}Polyline" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="dist" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="durS" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="durR" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="durST" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="durW2C" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="durW2D" type="{http://www.w3.org/2001/XMLSchema}duration" />
 *       &lt;attribute name="dirTxt" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dirGeo" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GisRouteType", propOrder = {
    "seg",
    "polyline",
    "altPolyline"
})
public class GisRouteType {

    protected List<GisRouteSegment> seg;
    protected Polyline polyline;
    protected List<Polyline> altPolyline;
    @XmlAttribute(name = "dist")
    protected Integer dist;
    @XmlAttribute(name = "durS")
    protected Duration durS;
    @XmlAttribute(name = "durR")
    protected Duration durR;
    @XmlAttribute(name = "durST")
    protected Duration durST;
    @XmlAttribute(name = "durW2C")
    protected Duration durW2C;
    @XmlAttribute(name = "durW2D")
    protected Duration durW2D;
    @XmlAttribute(name = "dirTxt")
    protected String dirTxt;
    @XmlAttribute(name = "dirGeo")
    protected Integer dirGeo;

    /**
     * Gets the value of the seg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GisRouteSegment }
     * 
     * 
     */
    public List<GisRouteSegment> getSeg() {
        if (seg == null) {
            seg = new ArrayList<GisRouteSegment>();
        }
        return this.seg;
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
     * Gets the value of the altPolyline property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the altPolyline property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAltPolyline().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Polyline }
     * 
     * 
     */
    public List<Polyline> getAltPolyline() {
        if (altPolyline == null) {
            altPolyline = new ArrayList<Polyline>();
        }
        return this.altPolyline;
    }

    /**
     * Gets the value of the dist property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDist() {
        return dist;
    }

    /**
     * Sets the value of the dist property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDist(Integer value) {
        this.dist = value;
    }

    /**
     * Gets the value of the durS property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDurS() {
        return durS;
    }

    /**
     * Sets the value of the durS property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDurS(Duration value) {
        this.durS = value;
    }

    /**
     * Gets the value of the durR property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDurR() {
        return durR;
    }

    /**
     * Sets the value of the durR property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDurR(Duration value) {
        this.durR = value;
    }

    /**
     * Gets the value of the durST property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDurST() {
        return durST;
    }

    /**
     * Sets the value of the durST property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDurST(Duration value) {
        this.durST = value;
    }

    /**
     * Gets the value of the durW2C property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDurW2C() {
        return durW2C;
    }

    /**
     * Sets the value of the durW2C property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDurW2C(Duration value) {
        this.durW2C = value;
    }

    /**
     * Gets the value of the durW2D property.
     * 
     * @return
     *     possible object is
     *     {@link Duration }
     *     
     */
    public Duration getDurW2D() {
        return durW2D;
    }

    /**
     * Sets the value of the durW2D property.
     * 
     * @param value
     *     allowed object is
     *     {@link Duration }
     *     
     */
    public void setDurW2D(Duration value) {
        this.durW2D = value;
    }

    /**
     * Gets the value of the dirTxt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDirTxt() {
        return dirTxt;
    }

    /**
     * Sets the value of the dirTxt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDirTxt(String value) {
        this.dirTxt = value;
    }

    /**
     * Gets the value of the dirGeo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDirGeo() {
        return dirGeo;
    }

    /**
     * Sets the value of the dirGeo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDirGeo(Integer value) {
        this.dirGeo = value;
    }

}
