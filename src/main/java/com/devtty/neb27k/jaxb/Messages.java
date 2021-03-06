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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Message" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;simpleContent>
 *               &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *                 &lt;attGroup ref="{hafas_rest}attlist.Message"/>
 *               &lt;/extension>
 *             &lt;/simpleContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
    "message"
})
@XmlRootElement(name = "Messages")
public class Messages {

    @XmlElement(name = "Message", required = true)
    protected List<Messages.Message> message;

    /**
     * Gets the value of the message property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the message property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Messages.Message }
     * 
     * 
     */
    public List<Messages.Message> getMessage() {
        if (message == null) {
            message = new ArrayList<Messages.Message>();
        }
        return this.message;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;simpleContent>
     *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
     *       &lt;attGroup ref="{hafas_rest}attlist.Message"/>
     *     &lt;/extension>
     *   &lt;/simpleContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class Message {

        @XmlValue
        protected String value;
        @XmlAttribute(name = "id", required = true)
        protected String id;
        @XmlAttribute(name = "type", required = true)
        protected MessageType type;
        @XmlAttribute(name = "act", required = true)
        protected boolean act;
        @XmlAttribute(name = "pub", required = true)
        protected String pub;
        @XmlAttribute(name = "head", required = true)
        protected String head;
        @XmlAttribute(name = "lead", required = true)
        protected String lead;
        @XmlAttribute(name = "text", required = true)
        protected String text;
        @XmlAttribute(name = "tckr", required = true)
        protected String tckr;
        @XmlAttribute(name = "priority", required = true)
        protected int priority;
        @XmlAttribute(name = "icon")
        protected String icon;
        @XmlAttribute(name = "routeIdxFrom")
        protected Integer routeIdxFrom;
        @XmlAttribute(name = "routeIdxTo")
        protected Integer routeIdxTo;

        /**
         * Gets the value of the value property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setValue(String value) {
            this.value = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link MessageType }
         *     
         */
        public MessageType getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link MessageType }
         *     
         */
        public void setType(MessageType value) {
            this.type = value;
        }

        /**
         * Gets the value of the act property.
         * 
         */
        public boolean isAct() {
            return act;
        }

        /**
         * Sets the value of the act property.
         * 
         */
        public void setAct(boolean value) {
            this.act = value;
        }

        /**
         * Gets the value of the pub property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPub() {
            return pub;
        }

        /**
         * Sets the value of the pub property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPub(String value) {
            this.pub = value;
        }

        /**
         * Gets the value of the head property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHead() {
            return head;
        }

        /**
         * Sets the value of the head property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHead(String value) {
            this.head = value;
        }

        /**
         * Gets the value of the lead property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getLead() {
            return lead;
        }

        /**
         * Sets the value of the lead property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setLead(String value) {
            this.lead = value;
        }

        /**
         * Gets the value of the text property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getText() {
            return text;
        }

        /**
         * Sets the value of the text property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setText(String value) {
            this.text = value;
        }

        /**
         * Gets the value of the tckr property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getTckr() {
            return tckr;
        }

        /**
         * Sets the value of the tckr property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setTckr(String value) {
            this.tckr = value;
        }

        /**
         * Gets the value of the priority property.
         * 
         */
        public int getPriority() {
            return priority;
        }

        /**
         * Sets the value of the priority property.
         * 
         */
        public void setPriority(int value) {
            this.priority = value;
        }

        /**
         * Gets the value of the icon property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getIcon() {
            return icon;
        }

        /**
         * Sets the value of the icon property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setIcon(String value) {
            this.icon = value;
        }

        /**
         * Gets the value of the routeIdxFrom property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getRouteIdxFrom() {
            return routeIdxFrom;
        }

        /**
         * Sets the value of the routeIdxFrom property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setRouteIdxFrom(Integer value) {
            this.routeIdxFrom = value;
        }

        /**
         * Gets the value of the routeIdxTo property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getRouteIdxTo() {
            return routeIdxTo;
        }

        /**
         * Sets the value of the routeIdxTo property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setRouteIdxTo(Integer value) {
            this.routeIdxTo = value;
        }

    }

}
