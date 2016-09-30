package com.noriental.jobweb.manage.service.notify;

import com.noriental.jobweb.manage.web.form.NotifyForm;

/**
 * 作业通知服务
 *
 * @author wangzhj
 */
public interface NotifyService {

    /**
     * 完成通知
     *
     * @param notifyForm
     */
    public void handleNotify(NotifyForm notifyForm);
}
