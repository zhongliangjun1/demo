package com.dianping.aop.spring;

import com.dianping.aop.PerformanceMonitor;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-10
 * Time: AM12:45
 * To change this template use File | Settings | File Templates.
 */
public class MonitorAfterReturningAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o2) throws Throwable {
        PerformanceMonitor.end(method.getName());
    }

}
