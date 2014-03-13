package com.dianping.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-14
 * Time: AM12:40
 * To change this template use File | Settings | File Templates.
 */
public class Base {

    static {
        System.out.println("execute static block of Base");
    }

    public static void executeBase(){
        System.out.println("executeBase()");
    }

}
