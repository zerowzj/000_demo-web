package com.noriental.jobweb.job.kernel.listener;

import org.quartz.SchedulerException;
import org.quartz.listeners.SchedulerListenerSupport;

/**
 * Scheduler监控
 *
 * @author wangzhj
 */
public class SchedulerMonitorListener extends SchedulerListenerSupport {

    @Override
    public void schedulerError(String msg, SchedulerException cause) {
        cause.printStackTrace();
    }
}
