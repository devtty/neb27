package com.devtty.neb27k;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Paging;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author Denis Renning <denis at devtty.de>
 */
@Named
@ApplicationScoped
public class TwitterContentProxy {
    
    Logger logger = LoggerFactory.getLogger(TwitterContentProxy.class);
    
    private long lastTweet = 684360872010059776L;
    private List<String> changes;
    private String tweetas;
    private String health;
    
    @Inject ServletContext servletContext;
    
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
            lastTweet = twitter.getHomeTimeline(new Paging(Constants.PAGING_OFFSET)).get(0).getId();
        } catch (TwitterException ex) {
            logger.error(ex.getErrorMessage());
        } catch (IllegalStateException isx){
            health = health();
        }   
    }
    
    private String health(){
        String s = "";
        
        String ht = System.getenv("hafasAccessToken");
        String lt = System.getenv("lametricAccessToken");
        
        if(ht!=null && !ht.isEmpty()){
            s = s + "hafas OK " + ht.substring(0,3);
        }
        
        if(lt!=null && !lt.isEmpty()){
            s = s + " lametric OK " + lt.substring(0,3);
        }
            
        if((new File(servletContext.getRealPath("/WEB-INF/classes/twitter4j.properties"))).exists()){
            s = s + " twitter Properties OK";
        }
        
        return s;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
    
    
}
