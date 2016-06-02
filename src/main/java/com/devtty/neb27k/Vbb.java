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
 *
 * @author Denis Renning
 */
public class Vbb {

    private static final String VBB_PROXY = "http://demo.hafas.de/openapi/vbb-proxy";
    
    Logger logger = LoggerFactory.getLogger(Vbb.class);

    @Inject
    ServletContext ctx;
    
    private String accessId;

    public String nextService(String id) {

        accessId = System.getenv("hafasAccessToken");
        
        JsonObject message = Json.createObjectBuilder()
                .add("departureBoard", Json.createObjectBuilder()
                        .add("accessId", accessId)
                        .add("id", id)
                        .add("maxJourneys", 5)
                )
                .build();

        Client client = new ResteasyClientBuilder().build();

        WebTarget location = client.target(VBB_PROXY).path("/location.name")
                .queryParam("accessId", accessId)
                .queryParam("format", "json")
                .queryParam("input", id);

        Response rl = location.request().accept(MediaType.APPLICATION_JSON).get();
        String r = "jippi";

        String extId = null;

        if (rl.getStatus() == 200) {

            LocationList locations = rl.readEntity(LocationList.class);

            for (StopLocation stop : locations.getStopLocation()) {
                r = stop.getName();
                extId = stop.getId();
            }

        } else {
            return "Error, couldnt recognize Stop";
        }
        rl.close();

        if (extId != null) {
            
            WebTarget target = client.target(VBB_PROXY).path("/departureBoard")
                    .queryParam("accessId", accessId)
                    .queryParam("id", extId)
                    .queryParam("maxJourneys", 3)
                    .queryParam("format", "json");

            Response response = target.request().accept(MediaType.APPLICATION_JSON).get();

            DepartureBoard board = response.readEntity(DepartureBoard.class);

            for (Departure dep : board.getDeparture()) {
                String late = calculateLate(dep.getDate(), dep.getTime(), dep.getRtDate(), dep.getRtTime());
                r = r + dep.getTime().substring(0,5) + " nach " + dep.getDirection() + late +  " - ";
                
            }

            response.close();

        }
        return r;
    }

    private String calculateLate(String date, String time, String rtDate, String rtTime) {
        
        String late = "";
        
        if(!rtDate.equals("null") && !rtTime.equals("null")){
            try {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
                Date date1 = df.parse(date+time);
                Date date2 = df.parse(rtDate+rtTime);
                
                long difference = (date2.getTime() - date1.getTime()) / 60000;
                
                if(difference >= 1)
                    late = " mit " + (difference / 60000) + " min Verspätung";
                
            } catch (ParseException ex) {
            }
        }
        
        return late;
    }

   
    
}