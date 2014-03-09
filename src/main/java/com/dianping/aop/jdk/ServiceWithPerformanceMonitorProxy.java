package com.dianping.aop.jdk;

import com.dianping.aop.PerformanceMonitor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-9
 * Time: PM10:11
 * To change this template use File | Settings | File Templates.
 */
public class ServiceWithPerformanceMonitorProxy implements InvocationHandler {

    private Object target;

    public ServiceWithPerformanceMonitorProxy(Object target) {
        this.target = target;
    }

    public static Object newProxyInstance(Object target){
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new ServiceWithPerformanceMonitorProxy(target));
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(method.getName());

        Object result = method.invoke(target, args); // 通过反射执行被代理原本类的业务代码

        PerformanceMonitor.end(method.getName());

        return result;
    }
}
