package com.hzq.project.cronJob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import org.quartz.*;

/**
 * Created by hzq on 17/1/26.
 */
public class CarJob implements Job, InitializingBean {

    private static Scheduler scheduler;
    private static String cronExpression;
    private static CartUtil cartUtil;

    private static Logger logger = LoggerFactory.getLogger(CarJob.class);



    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            cartUtil.startGrab();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("error: {}", e);
        }


        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        JobUtil.startJob("CarJob", "CarJobCronTrigger", scheduler, cronExpression, this.getClass());
    }


    public static void setCartUtil(CartUtil cartUtil) {
        CarJob.cartUtil = cartUtil;
    }

    public static void setScheduler(Scheduler scheduler) {
        CarJob.scheduler = scheduler;
    }

    public static void setCronExpression(String cronExpression) {
        CarJob.cronExpression = cronExpression;
    }
}