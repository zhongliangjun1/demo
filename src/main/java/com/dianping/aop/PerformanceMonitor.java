package com.dianping.aop;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM11:09
 * To change this template use File | Settings | File Templates.
 */
public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> threadLocal = new ThreadLocal<MethodPerformance>();

    public static void begin(String method){
        System.out.println("begin monitor "+method);
        MethodPerformance methodPerformance = new MethodPerformance(method);
        threadLocal.set(methodPerformance);
    }

    public static void end(String method){
        MethodPerformance methodPerformance = threadLocal.get();
        methodPerformance.printPerformance();
        System.out.println("finish monitor "+method);
    }


}
