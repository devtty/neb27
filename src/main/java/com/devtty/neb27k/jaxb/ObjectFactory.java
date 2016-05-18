//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.05.04 at 02:33:07 PM CEST 
//


package com.devtty.neb27k.jaxb;

import com.devtty.neb27k.jaxb.StopLocation;
import com.devtty.neb27k.jaxb.Departure;
import com.devtty.neb27k.jaxb.CoordLocation;
import com.devtty.neb27k.jaxb.FareSetItem;
import com.devtty.neb27k.jaxb.ArrivalBoard;
import com.devtty.neb27k.jaxb.GisRouteType;
import com.devtty.neb27k.jaxb.FareItem;
import com.devtty.neb27k.jaxb.GisRef;
import com.devtty.neb27k.jaxb.GeometryRef;
import com.devtty.neb27k.jaxb.EcoType;
import com.devtty.neb27k.jaxb.DepartureBoard;
import com.devtty.neb27k.jaxb.GisRouteSegment;
import com.devtty.neb27k.jaxb.Geometry;
import com.devtty.neb27k.jaxb.Directions;
import com.devtty.neb27k.jaxb.Arrival;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cfg package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _JourneyStatus_QNAME = new QName("hafas_rest", "JourneyStatus");
    private final static QName _Origin_QNAME = new QName("hafas_rest", "Origin");
    private final static QName _Destination_QNAME = new QName("hafas_rest", "Destination");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cfg
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Notes }
     * 
     */
    public Notes createNotes() {
        return new Notes();
    }

    /**
     * Create an instance of {@link Stops }
     * 
     */
    public Stops createStops() {
        return new Stops();
    }

    /**
     * Create an instance of {@link Names }
     * 
     */
    public Names createNames() {
        return new Names();
    }

    /**
     * Create an instance of {@link Directions }
     * 
     */
    public Directions createDirections() {
        return new Directions();
    }

    /**
     * Create an instance of {@link Messages }
     * 
     */
    public Messages createMessages() {
        return new Messages();
    }

    /**
     * Create an instance of {@link Geometry }
     * 
     */
    public Geometry createGeometry() {
        return new Geometry();
    }

    /**
     * Create an instance of {@link Geometry.Points }
     * 
     */
    public Geometry.Points createGeometryPoints() {
        return new Geometry.Points();
    }

    /**
     * Create an instance of {@link ArrivalBoard }
     * 
     */
    public ArrivalBoard createArrivalBoard() {
        return new ArrivalBoard();
    }

    /**
     * Create an instance of {@link Arrival }
     * 
     */
    public Arrival createArrival() {
        return new Arrival();
    }

    /**
     * Create an instance of {@link JourneyDetailRef }
     * 
     */
    public JourneyDetailRef createJourneyDetailRef() {
        return new JourneyDetailRef();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link Notes.Note }
     * 
     */
    public Notes.Note createNotesNote() {
        return new Notes.Note();
    }

    /**
     * Create an instance of {@link Departure }
     * 
     */
    public Departure createDeparture() {
        return new Departure();
    }

    /**
     * Create an instance of {@link JourneyDetail }
     * 
     */
    public JourneyDetail createJourneyDetail() {
        return new JourneyDetail();
    }

    /**
     * Create an instance of {@link Stops.Stop }
     * 
     */
    public Stops.Stop createStopsStop() {
        return new Stops.Stop();
    }

    /**
     * Create an instance of {@link GeometryRef }
     * 
     */
    public GeometryRef createGeometryRef() {
        return new GeometryRef();
    }

    /**
     * Create an instance of {@link Names.Name }
     * 
     */
    public Names.Name createNamesName() {
        return new Names.Name();
    }

    /**
     * Create an instance of {@link Directions.Direction }
     * 
     */
    public Directions.Direction createDirectionsDirection() {
        return new Directions.Direction();
    }

    /**
     * Create an instance of {@link Messages.Message }
     * 
     */
    public Messages.Message createMessagesMessage() {
        return new Messages.Message();
    }

    /**
     * Create an instance of {@link Polyline }
     * 
     */
    public Polyline createPolyline() {
        return new Polyline();
    }

    /**
     * Create an instance of {@link ServiceDays }
     * 
     */
    public ServiceDays createServiceDays() {
        return new ServiceDays();
    }

    /**
     * Create an instance of {@link OriginDestType }
     * 
     */
    public OriginDestType createOriginDestType() {
        return new OriginDestType();
    }

    /**
     * Create an instance of {@link LocationNote }
     * 
     */
    public LocationNote createLocationNote() {
        return new LocationNote();
    }

    /**
     * Create an instance of {@link TariffResult }
     * 
     */
    public TariffResult createTariffResult() {
        return new TariffResult();
    }

    /**
     * Create an instance of {@link FareSetItem }
     * 
     */
    public FareSetItem createFareSetItem() {
        return new FareSetItem();
    }

    /**
     * Create an instance of {@link KVType }
     * 
     */
    public KVType createKVType() {
        return new KVType();
    }

    /**
     * Create an instance of {@link FareItem }
     * 
     */
    public FareItem createFareItem() {
        return new FareItem();
    }

    /**
     * Create an instance of {@link Ticket }
     * 
     */
    public Ticket createTicket() {
        return new Ticket();
    }

    /**
     * Create an instance of {@link LocationNotes }
     * 
     */
    public LocationNotes createLocationNotes() {
        return new LocationNotes();
    }

    /**
     * Create an instance of {@link Trip }
     * 
     */
    public Trip createTrip() {
        return new Trip();
    }

    /**
     * Create an instance of {@link EcoType }
     * 
     */
    public EcoType createEcoType() {
        return new EcoType();
    }

    /**
     * Create an instance of {@link LegList }
     * 
     */
    public LegList createLegList() {
        return new LegList();
    }

    /**
     * Create an instance of {@link Leg }
     * 
     */
    public Leg createLeg() {
        return new Leg();
    }

    /**
     * Create an instance of {@link GisRef }
     * 
     */
    public GisRef createGisRef() {
        return new GisRef();
    }

    /**
     * Create an instance of {@link GisRouteType }
     * 
     */
    public GisRouteType createGisRouteType() {
        return new GisRouteType();
    }

    /**
     * Create an instance of {@link LocationList }
     * 
     */
    public LocationList createLocationList() {
        return new LocationList();
    }

    /**
     * Create an instance of {@link StopLocation }
     * 
     */
    public StopLocation createStopLocation() {
        return new StopLocation();
    }

    /**
     * Create an instance of {@link CoordLocation }
     * 
     */
    public CoordLocation createCoordLocation() {
        return new CoordLocation();
    }

    /**
     * Create an instance of {@link DepartureBoard }
     * 
     */
    public DepartureBoard createDepartureBoard() {
        return new DepartureBoard();
    }

    /**
     * Create an instance of {@link Error }
     * 
     */
    public Error createError() {
        return new Error();
    }

    /**
     * Create an instance of {@link TripList }
     * 
     */
    public TripList createTripList() {
        return new TripList();
    }

    /**
     * Create an instance of {@link PricingType }
     * 
     */
    public PricingType createPricingType() {
        return new PricingType();
    }

    /**
     * Create an instance of {@link GisRouteSegment }
     * 
     */
    public GisRouteSegment createGisRouteSegment() {
        return new GisRouteSegment();
    }

    /**
     * Create an instance of {@link Geometry.Points.Point }
     * 
     */
    public Geometry.Points.Point createGeometryPointsPoint() {
        return new Geometry.Points.Point();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "hafas_rest", name = "JourneyStatus")
    public JAXBElement<String> createJourneyStatus(String value) {
        return new JAXBElement<String>(_JourneyStatus_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginDestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "hafas_rest", name = "Origin")
    public JAXBElement<OriginDestType> createOrigin(OriginDestType value) {
        return new JAXBElement<OriginDestType>(_Origin_QNAME, OriginDestType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OriginDestType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "hafas_rest", name = "Destination")
    public JAXBElement<OriginDestType> createDestination(OriginDestType value) {
        return new JAXBElement<OriginDestType>(_Destination_QNAME, OriginDestType.class, null, value);
    }

}
