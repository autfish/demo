package com.autfish.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("demoJob")
public class DemoJob {

    @Scheduled(cron = "0/1 * * * * ?")
    public void doNothing() {
        System.out.println(System.currentTimeMillis());
    }
}
