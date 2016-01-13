package com.devtty.neb27k;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@ApplicationScoped
public class Var {
    
    Logger logger = LoggerFactory.getLogger(Var.class);
    
    private long lastTweet = 684360872010059776L;
    private List<String> changes;
    private String tweetas;
    
    public long getLastTweet() {
        return lastTweet;
    }

    public void setLastTweet(long lastTweet) {
        this.lastTweet = lastTweet;
    }

    public List<String> getChanges() {
        return changes;
    }

    public void setChanges(List<String> changes) {
        this.changes = changes;
    }

    public String getTweetas() {
        return tweetas;
    }

    public void setTweetas(String tweetas) {
        this.tweetas = tweetas;
    }
    
    
    @PostConstruct
    public void init(){
        logger.debug("Init application variables");
        changes = new ArrayList<>();
        try {
            Twitter twitter = TwitterFactory.getSingleton();
            tweetas = twitter.getScreenName();
            lastTweet = twitter.getHomeTimeline(new Paging(1)).get(0).getId();
        } catch (TwitterException ex) {
            logger.error(ex.getErrorMessage());
        }
    }
}
