package com.noriental.jobweb.dao.jobschedulelog;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.db.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;


@Repository("jobScheduleLogDao")
public class JobScheduleLogDaoImpl extends BaseDaoImpl<JobScheduleLogEO> implements JobScheduleLogDao {

    @Override
    public PageList<JobScheduleLogVO> getScheduleLogLtWithJob(String jbName, String beginTime, String endTime, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("jbName", jbName);
        params.put("beginTime", beginTime);
        params.put("endTime", endTime);
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        return (PageList) getSqlSession().selectList(this.getSqlId("getScheduleLogLtWithJob"), params, pageBounds);
    }

    @Override
    public JobScheduleLogVO getScheduleLogWithJob(Long jslId) {
        return getSqlSession().selectOne(this.getSqlId("getScheduleLogWithJob"), jslId);
    }
}
