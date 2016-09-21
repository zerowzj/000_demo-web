package com.company.project.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    /**
     * 获取Bean
     *
     * @param name
     * @return T
     */
    public static <T> T getBean(String name) {
        T obj = (T) context.getBean(name);
        return obj;
    }

    /**
     * 获取Bean
     *
     * @param clazz
     * @return T
     */
    public static <T> T getBean(Class<T> clazz) {
        T obj = (T) context.getBean(clazz);
        return obj;
    }

    /**
     * 是否存在Bean
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return context.containsBean(name);
    }
}
