package com.dianping.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-14
 * Time: AM12:40
 * To change this template use File | Settings | File Templates.
 */
public class Extend extends Base {

    public static int i = getValue();

    static {
        System.out.println("execute static block of Extend");
    }

    private static int getValue(){
        System.out.println("Extend.getValue()");
        return 1;
    }

    public static void executeExtend(){
        System.out.println("executeExtend()");
    }


}
