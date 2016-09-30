package com.noriental.jobweb.common.util;

import java.lang.reflect.Method;

/**
 * 反射 Util
 *
 * @author wangzhj
 */
public abstract class ReflectUtil {

    /**
     * 检查对象是否包含某个方法
     *
     * @param target
     * @param methodName
     * @return boolean
     */
    public static boolean checkExist(Object target, String methodName) {
        if (target == null || StringUtil.trimIsNull(methodName)) {
            return false;
        }
        return checkExist(target.getClass(), methodName);
    }

    /**
     * 检查类是否包含某个方法
     *
     * @param clazz
     * @param methodName
     * @return boolean
     */
    public static boolean checkExist(Class<?> clazz, String methodName){
        if (clazz == null || StringUtil.trimIsNull(methodName)) {
            return false;
        }
        boolean isExist = false;
        Method[] methodArray = clazz.getDeclaredMethods();
        for (Method method : methodArray) {
            if (method.getName().equals(methodName)) {
                isExist = true;
                //发现即完成
                break;
            }
        }
        return isExist;
    }
}
