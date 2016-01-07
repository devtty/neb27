package com.devtty.neb27k;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *  This job checks the NEB main page for traffic changes.
 *  In case that one or more changes will be detected the job 
 *  tweets the contents of every change. *  
 * 
 *  @author Denis
 */
public class CheckChanges implements Job{

    Logger logger = LoggerFactory.getLogger(CheckChanges.class);
    
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        
        try {
            Document doc = Jsoup.connect("http://www.neb.de/service/baustellenfahrplanaenderungen/").get();
            Elements line = doc.select(".news");

            List<String> changes = (List<String>) jec.getScheduler().getContext().get(Constants.CHANGES);

            for(Element e : line){
                if(e.text().equals(Constants.NO_CHANGES)){
                    logger.debug("No traffic changes");
                    return;
                }else{                    
                    logger.debug("handle change--- IMPLEMENT!");
                    //tweet if not already sent in the last 24h
                }
            }
            
            
            /*
            try {
            Twitter twitter = TwitterFactory.getSingleton();
            
            Query query = new Query("#neb27 OR #Regionalbahndamenklub OR #heidekrautbahn since:2016-01-03");
            QueryResult result = twitter.search(query);
            
            for(Status status : result.getTweets()){
            logger.info("test" + status.getUser().getScreenName() + ": " + status.getText());
            if(!status.isRetweetedByMe()){
            logger.debug("Retweet status " + status.getId());
            //TODO productive !!!! twitter.retweetStatus(status.getId());
            }
            }
            
            
            } catch (TwitterException ex) {
            logger.error(ex.getMessage());
            }*/
        } catch (IOException | SchedulerException ex) {
            logger.error(ex.getMessage());
        }
    }
    
}
