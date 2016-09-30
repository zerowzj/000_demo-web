package com.noriental.jobweb.manage.web.controller;

import com.mchange.v1.util.ArrayUtils;
import com.noriental.jobweb.common.util.StringUtil;
import com.noriental.jobweb.manage.service.notify.NotifyService;
import com.noriental.jobweb.manage.web.form.NotifyForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通知控制器
 *
 * @author wangzhj
 */
@Controller
public class NotifyController {

    private static final Logger logger = LoggerFactory.getLogger(NotifyController.class);

    @Autowired
    private NotifyService notifyService;

    @RequestMapping("/notify")
    @ResponseBody
    public String handle(HttpServletRequest request, HttpServletResponse response, NotifyForm notifyForm) {
        String trackNo = notifyForm.getTrackNo();
        logger.info("<=========收到[{}]通知", trackNo);

        if (StringUtil.trimIsNull(trackNo)) {
            logger.error("==========>参数[trackNo]为空！");
            return "fail";
        }
        String msg = null;
        try {
            notifyService.handleNotify(notifyForm);
            msg = "success";
        } catch (Exception ex) {
            ex.printStackTrace();
            msg = "fail";
        }
        logger.info("===>[{}]通知结果为[{}]", trackNo, msg);
        return msg;
    }
}
