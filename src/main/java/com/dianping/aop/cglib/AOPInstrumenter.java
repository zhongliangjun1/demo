package com.dianping.aop.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-5-8
 * Time: AM2:39
 * To change this template use File | Settings | File Templates.
 */
public class AOPInstrumenter implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getInstrumentedClass(Class clz) {
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] args,
                            MethodProxy proxy) throws Throwable {
        System.out.println("进入代理 方法:" + method.getName());
        System.out.println("开始执行原始方法:" + method.getName());
        Object result = proxy.invokeSuper(o, args);
        System.out.println("退出代理 方法:" + method.getName());
        return result;
    }

    public static void main(String[] args) {
        AOPInstrumenter instrumenter = new AOPInstrumenter();
        StudentInfoServiceImpl studentInfo = (StudentInfoServiceImpl)instrumenter.getInstrumentedClass(StudentInfoServiceImpl.class);
        studentInfo.findInfo("阿飞");
    }

}
