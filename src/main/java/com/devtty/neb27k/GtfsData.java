package com.devtty.neb27k;

import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.onebusaway.gtfs.impl.GtfsDaoImpl;
import org.onebusaway.gtfs.serialization.GtfsReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * Preload GTFS data
 * 
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@ApplicationScoped
public class GtfsData {

    @Inject
    ServletContext servletContext;
    
    Logger logger = LoggerFactory.getLogger(GtfsData.class);
    
    private GtfsDaoImpl store;

    public GtfsDaoImpl getStore() {
        return store;
    }

    public void setStore(GtfsDaoImpl store) {
        this.store = store;
    }

    @PostConstruct
    public void init() {

        try {

            GtfsReader reader = new GtfsReader();
            
            String gtfsZip = servletContext.getRealPath("/WEB-INF/classes/vbb_gtfs.zip");
            File f = new File(gtfsZip);
            reader.setInputLocation(f);
                        
            store = new GtfsDaoImpl();
            reader.setEntityStore(store);

            reader.run();
            reader.close();

        } catch (IOException ex) {
            logger.error("Error reading GTFS data file");
        }

    }
}
