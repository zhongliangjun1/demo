package com.dianping.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-14
 * Time: AM12:40
 * To change this template use File | Settings | File Templates.
 */
public class Base {

    public static int i = getValue();

    static {
        System.out.println("execute static block of Base");
    }

    private static int getValue(){
        System.out.println("Base.getValue()");
        return 1;
    }

    public static void executeBase(){
        System.out.println("executeBase()");
    }

}
