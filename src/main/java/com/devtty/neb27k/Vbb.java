package com.devtty.neb27k;

import com.devtty.neb27k.jaxb.Departure;
import com.devtty.neb27k.jaxb.DepartureBoard;
import com.devtty.neb27k.jaxb.LocationList;
import com.devtty.neb27k.jaxb.StopLocation;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class queries Hafas (DB-Bahnauskunft) - Liveservice
 * and calculates late minutes for detected train services
 * 
 * @author Denis Renning
 */
public class Vbb {

    private static final int HAFAS_QUERY_LOCATION_MAX_JOURNEYS = 5;
    private static final int HAFAS_QUERY_DEPARTURE_MAX_JOURNEYS = 3;
    private static final int TIME_STRING_OFFSET_LENGTH = 5;
    private static final int MINUTE_IN_MILLISECONDS = 60000;
    
    private static final String VBB_PROXY = "http://demo.hafas.de/openapi/vbb-proxy";
    
    Logger logger = LoggerFactory.getLogger(Vbb.class);

    @Inject
    ServletContext ctx;
    
    private String accessId;

    public String queryNextServiceAndReturnMessage(String stationName) {

        accessId = System.getenv("hafasAccessToken");
        
        JsonObject message = Json.createObjectBuilder()
                .add("departureBoard", Json.createObjectBuilder()
                        .add("accessId", accessId)
                        .add("id", stationName)
                        .add("maxJourneys", HAFAS_QUERY_LOCATION_MAX_JOURNEYS)
                )
                .build();

        Client restClient = new ResteasyClientBuilder().build();

        WebTarget location = restClient.target(VBB_PROXY).path("/location.name")
                .queryParam("accessId", accessId)
                .queryParam("format", "json")
                .queryParam("input", stationName);

        Response locationResponse = location.request().accept(MediaType.APPLICATION_JSON).get();
        String returnMessage = "jippi";

        String alternativeStopId = null;

        if (locationResponse.getStatus() == Response.Status.OK.getStatusCode()) {

            LocationList locations = locationResponse.readEntity(LocationList.class);

            for (StopLocation stop : locations.getStopLocation()) {
                returnMessage = stop.getName();
                alternativeStopId = stop.getId();
            }

        } else {
            return "Error, couldnt recognize Stop";
        }
        locationResponse.close();

        if (alternativeStopId != null) {
            
            WebTarget target = restClient.target(VBB_PROXY).path("/departureBoard")
                    .queryParam("accessId", accessId)
                    .queryParam("id", alternativeStopId)
                    .queryParam("maxJourneys", HAFAS_QUERY_DEPARTURE_MAX_JOURNEYS)
                    .queryParam("format", "json");

            Response response = target.request().accept(MediaType.APPLICATION_JSON).get();

            DepartureBoard board = response.readEntity(DepartureBoard.class);

            for (Departure dep : board.getDeparture()) {
                String late = calculateLate(dep.getDate(), dep.getTime(), dep.getRtDate(), dep.getRtTime());
                returnMessage = returnMessage + dep.getTime().substring(0,TIME_STRING_OFFSET_LENGTH) + " nach " + dep.getDirection() + late +  " - ";
                
            }

            response.close();

        }
        return returnMessage;
    }

    private String calculateLate(String departureDate, String departureTime, String rtDate, String rtTime) {
        
        String lateMessage = "";
        
        if(!rtDate.equals("null") && !rtTime.equals("null")){
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
                Date departure = dateFormat.parse(departureDate+departureTime);
                Date realtime = dateFormat.parse(rtDate+rtTime);
                
                long difference = (realtime.getTime() - departure.getTime()) / MINUTE_IN_MILLISECONDS;
                
                if(difference >= 1)
                    lateMessage = " mit " + (difference / MINUTE_IN_MILLISECONDS) + " min Verspätung";
                
            } catch (ParseException ex) {
                logger.error(ex.getMessage());
            }
        }
        
        return lateMessage;
    }
    
   
    
}