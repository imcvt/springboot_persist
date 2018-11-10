package com.imc.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @author luoly
 * @date 2018/11/10 17:42
 * @description
 */

@DisallowConcurrentExecution
public class SimpleTask extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("QuartzJobBean定时任务启动：" + new Date().getTime());
    }
}
