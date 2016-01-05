package com.devtty.neb27k;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * This job checks for tweets and retweets all matches
 *
 * @author Denis
 */
public class CheckTwitter implements Job {

    Logger logger = LoggerFactory.getLogger(CheckTwitter.class);

    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        
        try {
            SchedulerContext sc = jec.getScheduler().getContext();
            
            Twitter twitter = TwitterFactory.getSingleton();

            Query query = new Query("#neb27 OR #Regionalbahndamenklub OR #heidekrautbahn");
            query.setResultType(Query.ResultType.recent);
            
            if(sc.containsKey(Constants.LAST_TWEET)){
                query.setSinceId(sc.getLong(Constants.LAST_TWEET));
            }
                
            QueryResult result = twitter.search(query);

            for (Status status : result.getTweets()) {
                logger.debug("Tweet: " + status.getUser().getScreenName() + ": " + status.getText());
                if (!status.isRetweetedByMe()) {
                    logger.debug("Retweet status " + status.getId());
                    
                    Status rt = twitter.retweetStatus(status.getId());
                    long id = rt.getId();
                    jec.getScheduler().getContext().put(Constants.LAST_TWEET, id);
                     
                }
            }

        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        } catch (SchedulerException ex) {
            logger.error(ex.getMessage());
        }
    }

}
