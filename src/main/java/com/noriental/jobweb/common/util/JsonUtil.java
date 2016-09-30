package com.noriental.jobweb.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json Util
 *
 * @author wangzhj
 */
public abstract class JsonUtil {

    public static final String toJson(Object obj){
        ObjectMapper mapper = new ObjectMapper();
        String str = null;
        try {
            str = mapper.writeValueAsString(obj);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return str;
    }
}
