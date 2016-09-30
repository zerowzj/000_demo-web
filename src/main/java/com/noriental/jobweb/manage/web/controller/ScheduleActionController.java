package com.noriental.jobweb.manage.web.controller;

import com.noriental.jobweb.manage.service.scheduleaction.ScheduleActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 调度操作控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/scheduleAction")
public class ScheduleActionController {

    @Autowired
    private ScheduleActionService scheduleActionService = null;

    @RequestMapping("/start")
    public String start(HttpServletRequest request, HttpServletResponse response){
        String jsId = request.getParameter("jsId");
        try {
            scheduleActionService.startTrigger(Long.valueOf(jsId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/schedule/list";
    }

    @RequestMapping("/pause")
    public String pause(HttpServletRequest request, HttpServletResponse response){
        String jsId = request.getParameter("jsId");
        try {
            scheduleActionService.pauseTrigger(Long.valueOf(jsId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/schedule/list";
    }

    @RequestMapping("/resume")
    public String resume(HttpServletRequest request, HttpServletResponse response){
        String jsId = request.getParameter("jsId");
        try {
            scheduleActionService.resumeTrigger(Long.valueOf(jsId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/schedule/list";
    }

    @RequestMapping("/remove")
    public String remove(HttpServletRequest request, HttpServletResponse response){
        String jsId = request.getParameter("jsId");
        try {
            scheduleActionService.removeTrigger(Long.valueOf(jsId));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/schedule/list";
    }
}
