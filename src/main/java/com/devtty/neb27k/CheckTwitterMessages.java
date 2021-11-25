package com.devtty.neb27k;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.apache.commons.lang.StringUtils;
import org.onebusaway.gtfs.model.Stop;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.DirectMessage;
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 *  This job checks for (direct) messages from twitter
 *  and tries to answer.
 * 
 * @author Denis
 */
@Singleton
public class CheckTwitterMessages{

    Logger logger = LoggerFactory.getLogger(CheckTwitterMessages.class);
    
    @Inject
    TwitterContentProxy twitterContentProxy;
    
    @Inject
    GtfsData gtfs;
    
    @Schedule(minute="*/2", hour="*", persistent=false)
    public void execute(){
        logger.debug("CHECKED MSGs");
                
        try {
                        
            Twitter twitter = TwitterFactory.getSingleton();
            
            //only DMs recieved after the last response
            ResponseList<DirectMessage> dms = twitter.getDirectMessages(new Paging(twitter.getSentDirectMessages(new Paging(Constants.PAGING_OFFSET)).get(0).getId()));
            
            for(DirectMessage dm : dms){
                logger.debug("DM from " + dm.getSenderScreenName() + ": " + dm.getText());
                
                List<Stop> stops = getStopsFromMessage(dm.getText());

                String str = respond(stops);

                if (!str.isEmpty()) {
                    DirectMessage m = twitter.sendDirectMessage(dm.getSenderId(), str);
                    logger.debug("MSG _SEND_ " + str);
                }

                
            }
            
            ResponseList<Status> mentions = twitter.getMentionsTimeline(new Paging(twitterContentProxy.getLastTweet()));
            
            // give a star when somebody retweets me
            for(Status mention : mentions){
                if(!mention.isFavorited() && !mention.isRetweet()){
                    twitter.createFavorite(mention.getId());
                }
                logger.debug("Mention from " + mention.getUser().getScreenName());
            }
            
        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        } 
    }

    private List<Stop> getStopsFromMessage(String msg) {

        logger.debug("STOP MSG: " + msg);
        
        List<Stop> stops = new ArrayList<>();

        String[] str = msg.split("\\u0020");

        for (int x = 0; x < str.length; x++) {
            for (Stop stop : gtfs.getStore().getAllStops()) {
               
                if (compare(stop.getName(), str[x])) {
                    logger.debug("CHK TOKEN: " + stop.getName());
                    stops.add(stop);
                }
            }
        }

        return stops;
    }

    private String respond(List<Stop> stops) {
        String r = "";
        logger.debug("STOP SIZE: " + stops.size());
        if(stops.size()==1){
            // next departure on this station
            Vbb vbb = new Vbb();
            
            r = vbb.queryNextServiceAndReturnMessage(stops.get(0).getName());
            
        } else if(stops.size()==2){
            // next departure in this direction
        }
        
        return r;
    }

    private boolean compare(String stopname, String in) {
        String diff = StringUtils.difference(in.toLowerCase(), stopname.toLowerCase().replaceAll("^(s\\+u\\s)|(u\\s)|(s\\s)", ""));
        return diff.equals(", bahnhof")
                || diff.equals(" (bar, bahnhof)")
                || diff.equals(" bhf (berlin)");
    }

}
