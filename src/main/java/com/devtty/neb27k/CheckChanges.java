package com.devtty.neb27k;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import twitter4j.Paging;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

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
            List<String> changes = (List<String>) jec.getScheduler().getContext().get(Constants.CHANGES);
            logger.debug("Changes Amount: {}", changes.size());
            if(changes.size()>0){
                notifyClients(jec);
            }
        } catch (SchedulerException | TwitterException ex) {
            logger.error(ex.getMessage());
        }
    }

    private boolean checkMainPage(JobExecutionContext jec) throws SchedulerException, IOException {
        boolean change = false;
        
        Document doc = Jsoup.connect(Constants.URL_MAIN).get();
        Elements line = doc.select(Constants.CSS_SEARCH_WARNING);
        List<String> changes = (List<String>) jec.getScheduler().getContext().get(Constants.CHANGES);
        for(Element e : line) {
            logger.debug("MainPageLine: {}", e.text());
            if(e.text().contains(Constants.RB27)){
                changes.add(e.text());
                change = true;
            }
        }
        return change;
    }
    
    private boolean checkChangesPage(JobExecutionContext jec) throws SchedulerException, IOException {
        boolean change = false;
        Document doc = Jsoup.connect(Constants.URL_CHANGES).get();
        Elements line = doc.select(Constants.CSS_SEARCH_NEWS);
        List<String> changes = (List<String>) jec.getScheduler().getContext().get(Constants.CHANGES);
        for (Element e : line) {
            if (e.text().equals(Constants.NO_CHANGES)) {
                logger.debug("No traffic changes");
                change =  true;
            } else {
                logger.debug("handle change--- IMPLEMENT!");
                //tweet if not already sent in the last 24h
            }
        }
        return change;
    }

    private void notifyClients(JobExecutionContext jec) throws SchedulerException, TwitterException {
        
        List tweetsToday = getTweetsToday();
        
        List<String> changes = (List<String>) jec.getScheduler().getContext().get(Constants.CHANGES);
        
        for(String c : changes){
            if(c.length()>130){
                c = c.substring(6, 145);
            }
            
            if(!tweetsToday.contains(c)){
                Twitter twitter = TwitterFactory.getSingleton();
                
                Status update = twitter.updateStatus(c);
                jec.getScheduler().getContext().put(Constants.LAST_TWEET, update.getId());
                jec.getScheduler().getContext().put(Constants.CHANGES, new ArrayList<>());
                
                logger.debug("Tweet: {}", c);
            }   
        }
    }

    private List<String> getTweetsToday() throws TwitterException {
        List<String> tweetsToday = new ArrayList<>();

        Twitter twitter = TwitterFactory.getSingleton();

        Calendar midnight = new GregorianCalendar();
        midnight.set(Calendar.HOUR_OF_DAY, 0);
        midnight.set(Calendar.MINUTE, 0);
        midnight.set(Calendar.SECOND, 0);
        midnight.set(Calendar.MILLISECOND, 0);

        ResponseList<Status> lastTweets = twitter.getHomeTimeline(new Paging(20));
        lastTweets.stream().filter((s) -> (!s.isRetweet() && s.getCreatedAt().after(midnight.getTime()))).forEach((s) -> {
            tweetsToday.add(s.getText());
        });

        return tweetsToday;
    }
    
}
