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
    TwitterContentProxy twitterContentProxy;

    @Schedule(minute = "*/2", hour = "*", persistent = false)
    public void execute() {
        
        ArrayList<Long> retweetIds = new ArrayList<>();
        
        try {
            Twitter twitter = TwitterFactory.getSingleton();

            Query query = new Query("#neb27 OR #Regionalbahndamenklub OR #heidekrautbahn");
            query.setResultType(Query.ResultType.recent);

            query.setSinceId(twitterContentProxy.getLastTweet());

            QueryResult result = twitter.search(query);

            for (Status status : result.getTweets()) {
                logger.debug("Tweeet: " + status.getUser().getScreenName() + ": " + status.getText());
                if (!status.getUser().getScreenName().equals(twitterContentProxy.getTweetas()) && !status.isRetweeted()) {
                    logger.debug("Retweet status " + status.getId());
                    retweetIds.add(status.getId());
                }
            }
            
            long lastTweetId = 0;
            
            for(Long retweetId: retweetIds){
                Status retweetStatus = twitter.retweetStatus(retweetId);
                lastTweetId = retweetStatus.getId();
            }
            
            if(lastTweetId>0)
                twitterContentProxy.setLastTweet(lastTweetId);
            
        } catch (TwitterException ex) {
            logger.error(ex.getMessage());
        }
    }

}
