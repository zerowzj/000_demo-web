package com.noriental.jobweb.common.util;

import java.lang.reflect.Field;

/**
 * String Util
 *
 * @author wangzhj
 */
public abstract class StringUtil {

    /**
     * Trim
     *
     * @param str
     * @return String
     */
    public static String trimToNull(String str){
        if(str == null){
            return null;
        }
        str = str.trim();
        if("".equals(str)){
            return null;
        }
        return str;
    }

    /**
     * 判断是否为空
     *
     * @param str
     * @return boolean
     */
    public static boolean trimIsNull(String str){
        if(trimToNull(str) == null){
            return true;
        }
        return false;
    }

    /**
     * 对象的字符串表示
     *
     * @param obj
     * @return String
     */
    public static String toString(Object obj){
        if(obj == null){
            return "";
        }
        Class clazz = obj.getClass();
        StringBuffer sb = new StringBuffer();
        for(; clazz != Object.class; clazz = clazz.getSuperclass()){
            Field[] filedArr = clazz.getDeclaredFields();
            for(Field field : filedArr){
                String name = field.getName();
                field.setAccessible(true);
                Object value = null;
                try {
                    value = field.get(obj);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                sb.append(", ");
                sb.append(name);
                sb.append("=");
                sb.append(value);
            }
        }

        return sb.substring(2);
    }
}
