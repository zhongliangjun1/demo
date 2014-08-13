package com.dianping.reflect.method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-8-11
 * Time: PM6:50
 * To change this template use File | Settings | File Templates.
 */
import java.lang.reflect.Method;

public class TestClassLoad {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.dianping.reflect.method.A");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 26; i++) {
            m.invoke(o, Integer.toString(i));
        }
    }
}