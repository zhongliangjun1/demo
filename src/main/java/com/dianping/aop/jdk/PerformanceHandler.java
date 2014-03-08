package com.dianping.aop.jdk;

import com.dianping.aop.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM11:49
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceHandler implements InvocationHandler {

    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        PerformanceMonitor.begin(method.getName());

        Object result = method.invoke(target, args); // 通过反射执行被代理原本类的业务代码

        PerformanceMonitor.end(method.getName());

        return result;
    }


}
