package com.devtty.neb27k;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Pushes messages to LaMetric App
 * 
 * @author Denis Renning
 */
public class LaMetric {

    private static final String LAMETRIC_DEV_CON = "https://developer.lametric.com";
    private static final String LAMETRIC_WIDGET_URI = "api/V1/dev/widget/update/com.lametric.20d9fabf0b232dc145b0b82d9deb8ea9/1 ";
    
    Logger logger = LoggerFactory.getLogger(LaMetric.class);
    
    @Inject ServletContext ctx;
        
    private String accessToken;
    
    private String appId = "";
        
    public LaMetric(){
        
    }

    public void push(String messageText) {
        accessToken = System.getenv("lametricAccessToken");
        
        JsonObject message = Json.createObjectBuilder()
                .add("frames", Json.createObjectBuilder()
                        .add("index", 0)
                        .add("text", messageText)
                        .add("icon", "i1347")
                )
                .build();
      
        Client restClient = new ResteasyClientBuilder().build();      
        
        WebTarget target = restClient.target(LAMETRIC_DEV_CON).path(LAMETRIC_WIDGET_URI);
        
        CacheControl cacheControl = new CacheControl();
        cacheControl.setNoCache(true);

        Response response = target.request().accept(MediaType.APPLICATION_JSON).cacheControl(cacheControl).header("X-Access-Token", accessToken).post(Entity.json(message));
        
        logger.debug("RESPLAMETRIC: " + response.getStatus() + response.getStatusInfo().getReasonPhrase() );
    }
    

}
