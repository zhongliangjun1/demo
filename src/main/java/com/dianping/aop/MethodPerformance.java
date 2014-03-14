package com.dianping.aop;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM11:11
 * To change this template use File | Settings | File Templates.
 */
public class MethodPerformance {

    private String method;
    private long begin;
    private long end;

    public MethodPerformance(String method) {
        this.method = method;
        begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;
        System.out.println(method+" cost "+elapse);
    }

    public String getMethod() {
        return method;
    }

    public long getBegin() {
        return begin;
    }

    public long getEnd() {
        return end;
    }
}
