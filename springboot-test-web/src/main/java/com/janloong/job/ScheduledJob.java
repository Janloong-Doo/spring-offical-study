package com.janloong.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Janloong
 * @create 2017-09-20 14:45
 **/
@Component
public class ScheduledJob {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledJob.class);

    @Scheduled(fixedRate=20000)
    public void testJob() {
        //System.out.println("---------计划任务---------");
        logger.info("计划任务");
    }
}

