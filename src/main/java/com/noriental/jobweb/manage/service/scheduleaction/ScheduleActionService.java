package com.noriental.jobweb.manage.service.scheduleaction;

/**
 * 作业调度服务
 *
 * @author wangzhj
 */
public interface ScheduleActionService {

    /**
     * 开始触发器
     *
     * @param jsId 调度编号
     */
    public void startTrigger(Long jsId);

    /**
     * 暂停触发器
     *
     * @param jsId 调度编号
     */
    public void pauseTrigger(Long jsId);

    /**
     * 恢复触发器
     *
     * @param jsId 调度编号
     */
    public void resumeTrigger(Long jsId);

    /**
     * 删除触发器
     *
     * @param jsId 调度编号
     */
    public void removeTrigger(Long jsId);
}
