package com.noriental.jobweb.dao.jobschedule;

import com.noriental.jobweb.common.db.BaseDaoImpl;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("jobScheduleDao")
public class JobScheduleDaoImpl extends BaseDaoImpl<JobScheduleEO> implements JobScheduleDao {

    @Override
    public List<JobScheduleEO> getScheduleLt() {
        return getSqlSession().selectList(this.getSqlId("getScheduleLt"));
    }

    @Override
    public PageList<JobScheduleVO> getScheduleLtWithJob(String jbName, String jsStatus, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("jbName", jbName);
        params.put("jsStatus", jsStatus);
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        return (PageList) getSqlSession().selectList(this.getSqlId("getScheduleLtWithJob"), params, pageBounds);
    }
}
