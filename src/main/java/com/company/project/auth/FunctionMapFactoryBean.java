package com.company.project.auth;

import com.company.project.dao.popedomfunction.PopedomFunctionDao;
import com.company.project.dao.popedomfunction.PopedomFunctionEO;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * 功能映射工厂Bean
 *
 * @author wangzhj
 */
public class FunctionMapFactoryBean implements FactoryBean<LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>> {

    @Autowired
    private PopedomFunctionDao popedomFunctionDao = null;

    @Override
    public LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> getObject() throws Exception {
        //初始化
        LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> funMap = new LinkedHashMap<>();

        //获取受保护功能列表
        List<PopedomFunctionEO> pfEOLt = popedomFunctionDao.getFunctionLt(null);

        //生成映射
        AntPathRequestMatcher matcher = null;
        List<ConfigAttribute> configAttrLt = null;
        for (PopedomFunctionEO pfEO : pfEOLt) {
            //过滤掉1级
            Integer pfLevel = pfEO.getPfLevel();
            if (pfLevel == 1) {
                continue;
            }

            String pfPath = pfEO.getPfPath();
            if (pfPath == null || "".equals(pfPath)) {
                continue;
            }
            //匹配器
            matcher = new AntPathRequestMatcher(pfPath + "*");
            //配置属性
            configAttrLt = new ArrayList<>();
            configAttrLt.add(new SecurityConfig(pfPath));

            funMap.put(matcher, configAttrLt);
        }

        return funMap;
    }

    @Override
    public Class<?> getObjectType() {
        return LinkedHashMap.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
