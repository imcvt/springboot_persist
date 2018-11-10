package com.imc.task;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoly
 * @date 2018/11/10 17:45
 * @description
 */

@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail simpleTaskDetail() {
        return JobBuilder.newJob(SimpleTask.class)
                .withIdentity("simpleTask")
                .storeDurably()
                .build();
    }
    @Bean
    public Trigger simpleTaskTrigger() {
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        return TriggerBuilder.newTrigger().forJob(simpleTaskDetail())
                .withIdentity("simpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
