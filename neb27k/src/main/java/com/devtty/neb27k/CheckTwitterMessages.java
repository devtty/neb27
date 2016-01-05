package com.devtty.neb27k;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
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
public class CheckTwitterMessages implements Job{

    Logger logger = LoggerFactory.getLogger(CheckTwitterMessages.class);
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        try {
                        
            Twitter twitter = TwitterFactory.getSingleton();
            
            ResponseList<DirectMessage> dms = twitter.getDirectMessages(new Paging(jec.getScheduler().getContext().getLong(Constants.LAST_TWEET)));
            
            for(DirectMessage dm : dms){
                logger.debug("DM from " + dm.getSenderScreenName() + ": " + dm.getText());
                //TODO try to answer
            }
            
            ResponseList<Status> mentions = twitter.getMentionsTimeline(new Paging(jec.getScheduler().getContext().getLong(Constants.LAST_TWEET)));
            
            for(Status mention : mentions){
                if(!mention.isFavorited() && !mention.isRetweet()){
                    twitter.createFavorite(mention.getId());
                    //TODO try to answer
                }
                logger.debug("Mention from " + mention.getUser().getScreenName());
            }
            
        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        } catch (SchedulerException ex) {
            logger.error(ex.getMessage());
        }
    }
    
}
