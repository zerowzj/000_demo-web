package com.noriental.jobweb.manage.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.util.StringUtil;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleEO;
import com.noriental.jobweb.dao.jobschedule.JobScheduleVO;
import com.noriental.jobweb.manage.service.job.JobService;
import com.noriental.jobweb.manage.service.schedule.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 调度信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private JobService jobService = null;
    @Autowired
    private ScheduleService scheduleService = null;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        //初始模型数据
        Map<String, Object> model = new HashMap<>();
        //获取参数
        String pageNo = request.getParameter("pageNo");
        if(StringUtil.trimIsNull(pageNo)){
            pageNo = "1";
        }
        String jbName = request.getParameter("jbName");
        model.put("jbName", jbName);
        String jsStatus = request.getParameter("jsStatus");
        model.put("jsStatus", jsStatus);
        //查询数据
        PageList<JobScheduleVO> jsVOLt = scheduleService.findScheduleLtWithJob(StringUtil.trimToNull(jbName), StringUtil.trimToNull(jsStatus), Integer.valueOf(pageNo), 10);
        model.put("jsVOLt", jsVOLt);
        model.put("pageSize", jsVOLt.getPaginator().getLimit());
        model.put("pageNo", jsVOLt.getPaginator().getPage());
        model.put("totalCount", jsVOLt.getPaginator().getTotalCount());
        //返回
        return new ModelAndView("schedule/scheduleList", model);
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response){
        //初始模型数据
        Map<String, Object> model = new HashMap<>();
        //获取参数
        String jobId = request.getParameter("jobId");
        //查询数据
        JobBaseEO jbEO = jobService.getJob(Long.valueOf(jobId));
        model.put("jbEO", jbEO);
        //返回
        return new ModelAndView("schedule/scheduleAdd", model);
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, JobScheduleEO jsEO){
        //新增
        scheduleService.addSchedule(jsEO);
        //返回视图
        return "redirect:/schedule/list";
    }

    @RequestMapping("/toModify")
    public ModelAndView toModify(HttpServletRequest request, HttpServletResponse response){
        //获取参数
        String jsId = request.getParameter("jsId");
        //查询数据
        JobScheduleEO jsEO = scheduleService.getSchedule(Long.valueOf(jsId));
        JobBaseEO jbEO = jobService.getJob(jsEO.getJsJbId());
        //设置数据
        Map<String, Object> model = new HashMap<>();
        model.put("jsEO", jsEO);
        model.put("jbEO", jbEO);
        //返回视图
        return new ModelAndView("schedule/scheduleModify", model);
    }

    @RequestMapping("/modify")
    public String modify(HttpServletRequest request, HttpServletResponse response, JobScheduleEO jsEO){
        //修改
        scheduleService.modifySchedule(jsEO);
        //返回视图
        return "redirect:/schedule/list";
    }
}
