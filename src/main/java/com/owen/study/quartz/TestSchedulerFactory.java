package com.owen.study.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.*;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.*;


/**
 * Created by owen on 2016/9/15.
 */
public class TestSchedulerFactory {
    public static void main(String[] args){
        SchedulerFactory sdf = new StdSchedulerFactory();
        try {
            Scheduler scheduler = sdf.getScheduler();
            scheduler.start();

            JobDetail jobDetail = newJob(MyJob.class)
                                  .withIdentity("myJob1","group1")
                                  .build();

            Trigger trigger = newTrigger()
                              .withIdentity("myTrigger1","group1")
                              .withSchedule(simpleSchedule()
                                            .withIntervalInSeconds(30)
                                            .repeatForever())
                              .startNow()
                              .build();

            scheduler.scheduleJob(jobDetail,trigger);

            Thread.sleep(60000);

            scheduler.shutdown();

        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
