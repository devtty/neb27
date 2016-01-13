package com.devtty.neb27k;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
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
    Var var;
    
    @Schedule(minute="*/2", hour="*", persistent=false)
    public void execute(){
        try {
                        
            Twitter twitter = TwitterFactory.getSingleton();
            
            ResponseList<DirectMessage> dms = twitter.getDirectMessages(new Paging(var.getLastTweet()));
            
            for(DirectMessage dm : dms){
                logger.debug("DM from " + dm.getSenderScreenName() + ": " + dm.getText());
                //TODO try to answer
            }
            
            ResponseList<Status> mentions = twitter.getMentionsTimeline(new Paging(var.getLastTweet()));
            
            for(Status mention : mentions){
                if(!mention.isFavorited() && !mention.isRetweet()){
                    twitter.createFavorite(mention.getId());
                    //TODO try to answer
                }
                logger.debug("Mention from " + mention.getUser().getScreenName());
            }
            
        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        } 
    }
    
}
