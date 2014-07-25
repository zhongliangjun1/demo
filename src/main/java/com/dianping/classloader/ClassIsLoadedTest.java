package com.dianping.classloader;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-14
 * Time: AM12:39
 * To change this template use File | Settings | File Templates.
 */
public class ClassIsLoadedTest {

    //private native final Class findLoadedClass0(String name);

    public static void main(String[] args) {


        Class clazzBase = findLoadedClass("com.dianping.classloader.Base");
        Class clazzExtend = findLoadedClass("com.dianping.classloader.Extend");
        //Extend.executeBase();
        Extend.executeExtend();
        clazzBase = findLoadedClass("com.dianping.classloader.Base");
        clazzExtend = findLoadedClass("com.dianping.classloader.Extend");


        // 单纯地加载class是不会执行它的静态代码块的
        Class clazzOther = findLoadedClass("com.dianping.classloader.Other");
        try {
            clazzOther = ClassIsLoadedTest.class.getClassLoader().loadClass("com.dianping.classloader.Other");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();

    }


    private static Class findLoadedClass(String name) {
        try{
            // 子类是不可以直接反射父类的方法的，需要一层层的查找父类方法
            ClassLoader appClassLoader = ClassIsLoadedTest.class.getClassLoader();
            Method method = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
            method.setAccessible(true);
            return (Class) method.invoke(appClassLoader, name);
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
