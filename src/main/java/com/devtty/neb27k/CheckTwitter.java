package com.devtty.neb27k;

import java.util.ArrayList;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
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
@Singleton
public class CheckTwitter {

    Logger logger = LoggerFactory.getLogger(CheckTwitter.class);

    @Inject
    Var var;

    @Schedule(minute = "*/2", hour = "*", persistent = false)
    public void execute() {
        
        ArrayList<Long> retweetIds = new ArrayList<>();
        
        try {
            Twitter twitter = TwitterFactory.getSingleton();

            Query query = new Query("#neb27 OR #Regionalbahndamenklub OR #heidekrautbahn");
            query.setResultType(Query.ResultType.recent);

            query.setSinceId(var.getLastTweet());

            QueryResult result = twitter.search(query);

            for (Status status : result.getTweets()) {
                logger.debug("Tweeet: " + status.getUser().getScreenName() + ": " + status.getText());
                if (!status.getUser().getScreenName().equals(var.getTweetas()) && !status.isRetweeted()) {
                    logger.debug("Retweet status " + status.getId());
                    retweetIds.add(status.getId());
                }
            }
            
            long last = 0;
            
            for(Long retweet: retweetIds){
                Status rt = twitter.retweetStatus(retweet);
                last = rt.getId();
            }
            
            if(last>0)
                var.setLastTweet(last);
            
        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        }
    }

}
