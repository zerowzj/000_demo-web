package com.company.project.dao.popedomfunction;

import com.company.project.dao.BaseDaoTest;
import com.company.util.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangzhj on 2016/9/27.
 */
public class PopedomFunctionDaoTest extends BaseDaoTest {

    @Autowired
    private PopedomFunctionDao popedomFunctionDao;

    @Test
    public void testNestDown(){
        Long pfId = 1000L;
        System.out.println(JsonUtil.toJson(getChildren(pfId)));
    }

    private List<Map<String, Object>> getChildren(Long pfId) {
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionChildLt(pfId);
        List<Map<String, Object>> mapLt = new ArrayList<>();
        Map<String, Object> map = null;
        for(PopedomFunctionEO pfEO : pfEOLt){
            map = new HashMap<>();

            map.put("pf_id", pfEO.getPfId());
            map.put("pf_name", pfEO.getPfName());
            map.put("pf_parent_id", pfEO.getPfParentId());
            map.put("children", getChildren(pfEO.getPfId()));

            mapLt.add(map);
        }

        return mapLt;
    }
}
