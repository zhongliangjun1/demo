package com.dianping.aop;

import com.dianping.aop.jdk.PerformanceHandler;

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
        AdminService proxy = (AdminService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), performanceHandler);

        int userId = 10;
        String topic = "jdkProxyEnhanceTest";
        proxy.addTopic(userId, topic);
        proxy.removeTopic(userId);
    }


    public static void main(String[] args) {
        TestMain testMain = new TestMain();
        testMain.jdkProxyEnhanceTest();
    }




}
