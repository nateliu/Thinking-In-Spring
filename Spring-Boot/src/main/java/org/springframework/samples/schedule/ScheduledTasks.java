package org.springframework.samples.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jinlliu on 9/17/2016.
 * The cron expression api can be found
 * http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html
 */
@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static List<String> drrList = new ArrayList<String>();

    //    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron ="*/5 * * * * *" )
    @Scheduled(cron = "${cron.expression}")
    public void reportCurrentTime() {
        Date time = new Date();
        if (time.getSeconds() == 10) {
            drrList = new ArrayList<String>();
            drrList.add("1101");
            drrList.add("1102");
            drrList.add("1102");
        }
        log.info("The time is now {} and the drrList has {} lines", dateFormat.format(time), drrList.size());
//        log.info("The time is now {}", dateFormat.format(new Date()));
    }

}
