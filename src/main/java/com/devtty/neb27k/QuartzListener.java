package com.devtty.neb27k;

import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * Web application lifecycle listener.
 *
 * @author Denis
 */
@WebListener
public class QuartzListener extends QuartzInitializerListener {

    Logger logger = LoggerFactory.getLogger(QuartzListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            super.contextInitialized(sce);
            
            ServletContext ctx = sce.getServletContext();
            StdSchedulerFactory factory = (StdSchedulerFactory) ctx.getAttribute(QUARTZ_FACTORY_KEY);

            Scheduler scheduler = factory.getScheduler();

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
                scheduler.getContext().put(Constants.CHANGES, new ArrayList<>());
            } catch (TwitterException ex) {
                logger.error(ex.getErrorMessage());
            }

            scheduler.start();
            
        } catch (SchedulerException ex) {
            logger.error(ex.getMessage());
        }
    }
}
