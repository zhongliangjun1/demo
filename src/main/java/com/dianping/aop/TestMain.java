package com.dianping.aop;

import com.dianping.aop.cglib.CGlibProxy;
import com.dianping.aop.jdk.PerformanceHandler;
import com.dianping.aop.jdk.ServiceWithPerformanceMonitorProxy;

import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM11:52
 * To change this template use File | Settings | File Templates.
 */
public class TestMain {

    private void jdkProxyEnhanceTest(){

        AdminService target = new AdminServiceImpl();
        PerformanceHandler performanceHandler = new PerformanceHandler(target);
        Class clazz = target.getClass();

        // interfaces - the list of interfaces for the proxy class to implement
        AdminService proxy = (AdminService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), performanceHandler);

        int userId = 10;
        String topic = "jdkProxyEnhanceTest";
        proxy.addTopic(userId, topic);
        proxy.removeTopic(userId);
    }

    private void jdkProxyTest(){
        AdminService target = new AdminServiceImpl();
        AdminService proxy = (AdminService) ServiceWithPerformanceMonitorProxy.newProxyInstance(target);

        int userId = 10;
        String topic = "jdkProxyEnhanceTest";
        proxy.addTopic(userId, topic);
        proxy.removeTopic(userId);
    }


    private void cglibProxyEnhanceTest(){

        CGlibProxy proxy = new CGlibProxy();
        AdminServiceImpl adminService = (AdminServiceImpl) proxy.getProxy(AdminServiceImpl.class);

        int userId = 10;
        String topic = "cglibProxyEnhanceTest";
        adminService.addTopic(userId, topic);
        adminService.removeTopic(userId);
        adminService.innerMethod(); // 证实了cglib优于jdk proxy的地方在于，它是面向类的方法级别的拦截代理，而jdk proxy是面向接口级别的
    }


    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        //testMain.jdkProxyEnhanceTest();
        testMain.jdkProxyTest();
        //testMain.cglibProxyEnhanceTest();
    }




}
