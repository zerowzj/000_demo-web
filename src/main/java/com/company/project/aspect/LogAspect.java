package com.company.project.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * Created by wangzhj on 2016/9/27.
 */
@Aspect
public class LogAspect {

    @Around("@annotation(com.noriental.resourcesvr.common.ResourceCrop)")
    public Object intercept(ProceedingJoinPoint joinPoint) {
        return null;
    }
}
