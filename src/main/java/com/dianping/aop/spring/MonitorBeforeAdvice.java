package com.dianping.aop.spring;

import com.dianping.aop.PerformanceMonitor;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-10
 * Time: AM12:43
 * To change this template use File | Settings | File Templates.
 */
public class MonitorBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        PerformanceMonitor.begin(method.getName());
    }

}
