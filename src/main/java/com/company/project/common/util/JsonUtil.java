package com.company.project.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author wangzhj
 */
public abstract class JsonUtil {

    public static String toJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String value = null;
        try {
            value = mapper.writeValueAsString(obj);
        } catch (Exception ex){

        }
        return value;
    }
}
