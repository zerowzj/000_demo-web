package com.company.project.web.pattern.action;

import com.company.project.common.SpringContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Action执行器
 *
 * @author wangzhj
 */
public class ActionExecutor {

    public static Map<String, Object> execute(HttpServletRequest request, HttpServletResponse response, String actionName, Object param){
        if(!SpringContext.containsBean(actionName)){
            throw new IllegalStateException("ssssssssssssssss");
        }
        Action action = SpringContext.getBean(actionName);
        return action.doExecute(request, response, param);
    }
}
