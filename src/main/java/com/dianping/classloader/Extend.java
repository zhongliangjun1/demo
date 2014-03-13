package com.dianping.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-14
 * Time: AM12:40
 * To change this template use File | Settings | File Templates.
 */
public class Extend extends Base {

    static {
        System.out.println("execute static block of Extend");
    }

    public static void executeExtend(){
        System.out.println("executeExtend()");
    }


}
