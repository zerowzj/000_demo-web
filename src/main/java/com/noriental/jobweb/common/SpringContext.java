package com.noriental.jobweb.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Spring上下文
 *
 * @author wangzhj
 */
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext context;

    /**
     * 获取Bean
     *
     * @param name
     * @return T
     */
    public static <T> T getBean(String name) {
        return (T) context.getBean(name);
    }

    /**
     * 获取Bean
     *
     * @param type
     * @return T
     */
    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

    /**
     * 是否包含Bean
     *
     * @param name
     * @return boolean
     */
    public static boolean containsBean(String name) {
        if (context.containsBean(name)) {
            return true;
        }
        return false;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
