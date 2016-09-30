package com.noriental.jobweb.dao.jobbase;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.noriental.jobweb.common.db.BaseDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("jobBaseDao")
public class JobBaseDaoImpl extends BaseDaoImpl<JobBaseEO> implements JobBaseDao {

//    @Override
//    public List<JobBaseEO> getJobLt() {
//        return getSqlSession().selectList(this.getSqlId("getJobLt"));
//    }

    @Override
    public PageList<JobBaseVO> getJobLtWithSchedule(String jbName, int pageNo, int pageSize) {
        Map<String, Object> params = new HashMap<>();
        params.put("jbName", jbName);
        PageBounds pageBounds = new PageBounds(pageNo, pageSize);
        return (PageList) getSqlSession().selectList(this.getSqlId("getJobLtWithSchedule"), params, pageBounds);
    }

    @Override
    public List<JobBaseEO> getJobLt(String jbName, String jbJobGroup, String jbJobName, String jbJobObject, String jbBeanMethod) {
        Map<String, Object> params = new HashMap<>();
        params.put("jbName", jbName);
        params.put("jbJobGroup", jbJobGroup);
        params.put("jbJobName", jbJobName);
        params.put("jbJobObject", jbJobObject);
        params.put("jbJobMethod", jbBeanMethod);
        return getSqlSession().selectList(this.getSqlId("getJobLt"), params);
    }
}
