package com.dianping.aop.cglib;

import com.dianping.aop.PerformanceMonitor;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-9
 * Time: AM12:27
 * To change this template use File | Settings | File Templates.
 */
public class CGlibProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    /**
     * 根据指定类，创建其代理类(动态生成被代理类的子类)
     * @param clazz 被代理的类
     * @return 代理类
     */
    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this); // 代理执行时会回调此this持有的intercept方法，以实现代码织入
        return enhancer.create();
    }


    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        PerformanceMonitor.begin(method.getName());

        Object result = methodProxy.invokeSuper(target, args);
        //Object result = method.invoke(target, args);

        PerformanceMonitor.end(method.getName());

        return result;
    }

}
