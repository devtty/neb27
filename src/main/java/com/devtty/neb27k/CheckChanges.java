package com.devtty.neb27k;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.inject.Inject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * This job checks the NEB main page for traffic changes. In case that one or
 * more changes will be detected the job tweets the contents of every change. *
 *
 * @author Denis
 */
@Singleton
public class CheckChanges {

    public final static int WARNING_MSG_START_POSITION = 6;
    public final static int WARNING_MSG_END_POSITION = 145;
    
    @Inject
    TwitterContentProxy twitterContentProxy;

    Logger logger = LoggerFactory.getLogger(CheckChanges.class);

    @Schedule(minute = "*/5", hour = "*", persistent = false)
    public void execute() {

        try {
            checkMainPage();
            List<String> changes = twitterContentProxy.getChanges();
            if (changes != null) {
                logger.debug("Changes Amount: {}", changes.size());
                if (changes.size() > 0) {
                    notifyClients();
                }else{
                    LaMetric lm = new LaMetric();
                    lm.push("ok");
                }
                
            }
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }

    }

    /*
    * check neb mainpage for change message on train line RB27
    */
    private void checkMainPage() throws IOException {
        Document mainPage = Jsoup.connect(Constants.URL_MAIN).get();
        Elements messageList = mainPage.select(Constants.CSS_SEARCH_WARNING);
        List<String> changes = new ArrayList<>();

        for (Element message : messageList) {
            logger.debug("MainPageLine: {}", message.text());
            if (message.text().contains(Constants.RB27)) {
                changes.add(message.text());
                twitterContentProxy.setChanges(changes);
            }
        }
    }

    private void notifyClients(){
        logger.debug("notifying clients");
        List tweetsToday = getTweetsToday();

        List<String> changes = twitterContentProxy.getChanges();

        int count = 0;
        
        for (String change : changes) {
            logger.debug("Change is: " + change);
            if (change.length() > 130) {
                change = change.substring(WARNING_MSG_START_POSITION, WARNING_MSG_END_POSITION);
            }

            if (!tweetsToday.contains(change)) {
                logger.debug("Tweet: {}", change);
                Twitter twitter = TwitterFactory.getSingleton();

                Status update;
                try {
                    update = twitter.updateStatus(change);
                    twitterContentProxy.setLastTweet(update.getId());
                    count++;
                } catch (TwitterException ex) {
                    logger.error(ex.getMessage());
                }
            }
        }
        
        LaMetric lm = new LaMetric();
        
        if(count>0){
            lm.push("Kapoot" + count);
        }
            
    }

    private List<String> getTweetsToday() {
        List<String> tweetsToday = new ArrayList<>();

        Twitter twitter = TwitterFactory.getSingleton();

        ResponseList<Status> lastTweets;
        try {
            lastTweets = twitter.getUserTimeline();

            lastTweets.stream().filter((s) -> (isFromTodayAndNoRetweet(s))).forEach((s) -> {
                tweetsToday.add(s.getText());
            });
 
            } catch (TwitterException ex) {
                logger.error(ex.getMessage());
            }
        return tweetsToday;
    }

    private boolean isFromTodayAndNoRetweet(Status s) {
        return !s.isRetweet() && s.getCreatedAt().after(getStartTimeOfToday());
    }
    
    private Date getStartTimeOfToday(){
        LocalDateTime midnight = LocalDate.now().atStartOfDay();
        Date convertedDate = Date.from(midnight.atZone(ZoneId.of("Europe/Berlin")).toInstant());
        return convertedDate;
    }

}
