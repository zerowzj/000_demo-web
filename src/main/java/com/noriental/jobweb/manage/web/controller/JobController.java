package com.noriental.jobweb.manage.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.SpringContext;
import com.noriental.jobweb.common.util.StringUtil;
import com.noriental.jobweb.dao.jobbase.JobBaseEO;
import com.noriental.jobweb.dao.jobbase.JobBaseVO;
import com.noriental.jobweb.manage.service.job.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作业信息控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private JobService jobService = null;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) {
        //设置数据
        Map<String, Object> model = new HashMap<>();
        //获取参数
        String pageNo = request.getParameter("pageNo");
        if (StringUtil.trimIsNull(pageNo)) {
            pageNo = "1";
        }
        String jbName = request.getParameter("jbName");
        model.put("jbName", jbName);
        //查询数据
        PageList<JobBaseVO> jbVOLt = jobService.findJobLtWithSchedule(StringUtil.trimToNull(jbName), Integer.valueOf(pageNo), 10);
        model.put("jbVOLt", jbVOLt);
        model.put("pageSize", jbVOLt.getPaginator().getLimit());
        model.put("pageNo", jbVOLt.getPaginator().getPage());
        model.put("totalCount", jbVOLt.getPaginator().getTotalCount());
        //返回
        return new ModelAndView("job/jobList", model);
    }

    @RequestMapping("/toAdd")
    public ModelAndView toAdd(HttpServletRequest request, HttpServletResponse response) {
        //初始模型数据
        Map<String, Object> model = new HashMap<>();

        //返回
        return new ModelAndView("job/jobAdd", model);
    }

    @RequestMapping("/add")
    public String add(HttpServletRequest request, HttpServletResponse response, JobBaseEO jbEO) {

        jobService.addJob(jbEO);
        //返回视图
        return "redirect:/job/list";
    }

    @RequestMapping("/check/bean")
    @ResponseBody
    public Map<String, Object> checkBean(HttpServletRequest request, HttpServletResponse response) {
        //初始模型数据
        Map<String, Object> model = new HashMap<>();
        //Bean是否存在
        String beanId = request.getParameter("param");
        if (SpringContext.containsBean(beanId)) {
            model.put("status", "y");
            model.put("info", "");
        } else {
            model.put("status", "n");
            model.put("info", "作业对象[" + beanId + "]不存在！");
        }
        //返回
        return model;
    }

    @RequestMapping("/check/jobName")
    @ResponseBody
    public Map<String, Object> checkJobName(HttpServletRequest request, HttpServletResponse response) {
        //初始模型数据
        Map<String, Object> model = new HashMap<>();
        //Bean是否存在
        String jobName = request.getParameter("param");
        boolean isExist = jobService.checkJobNameIsExist(jobName);
        if (isExist) {
            model.put("status", "n");
            model.put("info", "作业名称[" + jobName + "]已存在！");
        } else {
            model.put("status", "y");
            model.put("info", "");
        }
        //返回
        return model;
    }
}
