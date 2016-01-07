package com.devtty.neb27k;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import twitter4j.Paging;
import twitter4j.Status;

/**
 *
 * @author Denis
 */
public class Application {
    
    Logger logger = LoggerFactory.getLogger(Application.class);
    
    
    public Application(){  
    
        if (logger.isDebugEnabled()) {
            try {
                Twitter twitter = TwitterFactory.getSingleton();

                logger.debug("Twitter Config");
                logger.debug("==============");
                logger.debug("ScreenName: " + twitter.getScreenName());
                
            } catch (TwitterException ex) {
                logger.error(ex.getErrorMessage());
            } catch (IllegalStateException ex) {
                logger.error(ex.getMessage());
            }
        }
        
    }
    
    public void initScheduler(){
        
        logger.debug("Init Scheduler");
        
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            JobDetail checkTwitter = newJob(CheckTwitter.class).build();
            
            JobDetail checkChanges = newJob(CheckChanges.class).build();
            
            JobDetail checkMessage = newJob(CheckTwitterMessages.class).build();

            CronTrigger twitterTrigger = newTrigger()
                    .withSchedule(cronSchedule("0/20 * * * * ?"))
                    .build();
            
            CronTrigger changesTrigger = newTrigger()
                    //P .withSchedule(cronSchedule("0 0/30 * * * ?"))
                    .withSchedule(cronSchedule("0/20 * * * * ?"))
                    .build();
            
            CronTrigger messageTrigger = newTrigger()
                    //P .withSchedule(cronSchedule("0 0/30 * * * ?"))
                    .withSchedule(cronSchedule("0/20 * * * * ?"))
                    .build();
            
            scheduler.scheduleJob(checkTwitter, twitterTrigger);
            scheduler.scheduleJob(checkChanges, changesTrigger);
            scheduler.scheduleJob(checkMessage, messageTrigger);
            
            try {
                Twitter twitter = TwitterFactory.getSingleton();
                Status lastTweet = twitter.getHomeTimeline(new Paging(1)).get(0);
                logger.debug("Last Tweet: " + lastTweet.getText());
                scheduler.getContext().put(Constants.LAST_TWEET, lastTweet.getId());
            } catch (TwitterException ex) {
                logger.error(ex.getErrorMessage());
            }
            
            scheduler.start();
            
        } catch (SchedulerException ex) {
            logger.error(ex.getMessage());
        }
    }

    public static void main(String[] args) {

        //System.setProperty("http.proxyHost", "192.168.193.1");
        //System.setProperty("http.proxyPort", "8000");
        
        Application a = new Application();
        a.initScheduler();
        
    }

}
