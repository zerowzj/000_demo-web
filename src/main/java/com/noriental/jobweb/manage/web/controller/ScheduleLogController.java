package com.noriental.jobweb.manage.web.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.util.StringUtil;
import com.noriental.jobweb.dao.jobschedulelog.JobScheduleLogVO;
import com.noriental.jobweb.manage.service.schedulelog.ScheduleLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 调度日志控制器
 *
 * @author wangzhj
 */
@Controller
@RequestMapping("/scheduleLog")
public class ScheduleLogController {

    @Autowired
    private ScheduleLogService scheduleLogService = null;

    @RequestMapping("/list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response){
        //
        Map<String, Object> model = new HashMap<>();
        //获取参数
        String jbName = StringUtil.trimToNull(request.getParameter("jbName"));
        model.put("jbName", jbName);
        String beginTime = StringUtil.trimToNull(request.getParameter("beginTime"));
        model.put("beginTime", beginTime);
        String endTime = StringUtil.trimToNull(request.getParameter("endTime"));
        model.put("endTime", endTime);
        String pageNo = request.getParameter("pageNo");
        if(StringUtil.trimIsNull(pageNo)){
            pageNo = "1";
        }
        //查询数据
        PageList<JobScheduleLogVO> jslVOLt = scheduleLogService.findScheduleLogLtWithJob(jbName, beginTime, endTime, Integer.valueOf(pageNo), 10);
        model.put("jslVOLt", jslVOLt);
        model.put("pageSize", jslVOLt.getPaginator().getLimit());
        model.put("pageNo", jslVOLt.getPaginator().getPage());
        model.put("totalCount", jslVOLt.getPaginator().getTotalCount());
        //返回视图
        return new ModelAndView("schedulelog/scheduleLogList", model);
    }

    @RequestMapping("/detail")
    public ModelAndView detail(HttpServletRequest request, HttpServletResponse response){
        //
        Map<String, Object> model = new HashMap<>();
        //获取参数
        String jslId = StringUtil.trimToNull(request.getParameter("jslId"));
        //查询数据
        JobScheduleLogVO jslVO = scheduleLogService.getScheduleLogWithJob(Long.valueOf(jslId));
        model.put("jslVO", jslVO);
        //返回视图
        return new ModelAndView("schedulelog/scheduleLogDetail", model);
    }
}
