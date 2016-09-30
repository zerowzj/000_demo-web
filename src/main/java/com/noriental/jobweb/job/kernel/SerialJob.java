package com.noriental.jobweb.job.kernel;

import org.quartz.DisallowConcurrentExecution;

/**
 * 串行Job
 *
 * @author wangzhj
 */
@DisallowConcurrentExecution
public class SerialJob extends BaseJob {
}
