package com.dianping.groovy;

import groovy.lang.GroovyClassLoader;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-28
 * Time: AM11:03
 * To change this template use File | Settings | File Templates.
 */
public class TestGroovyClassLoader {


    public static void  loadClassDuplicate() throws IllegalAccessException, InstantiationException {
        GroovyClassLoader loader = new GroovyClassLoader();
        String scriptText = "import com.dianping.groovy.GroovyTest; class Foo implements GroovyTest {\n"
                + " public void out() { println 'first' } \n"
                + "}";

        Class<GroovyTest> newClazz1 = loader.parseClass(scriptText);
        GroovyTest groovyTest1 = newClazz1.newInstance();
        groovyTest1.out();


        scriptText = "import com.dianping.groovy.GroovyTest; class Foo implements GroovyTest {\n"
                + " public void out() { println 'second' } \n"
                + "}";

        Class<GroovyTest> newClazz2 = loader.parseClass(scriptText);
        GroovyTest groovyTest2 = newClazz2.newInstance();
        groovyTest2.out();


        System.out.print("");
    }

    public static void executeClass() throws IllegalAccessException, InstantiationException {
        GroovyClassLoader loader = new GroovyClassLoader();
        String scriptText = "import com.dianping.groovy.GroovyTest; class Foo implements GroovyTest {\n"
                + " public void out() { println 'first' } \n"
                + "}";

        while (true) {
            //GroovyClassLoader loader = new GroovyClassLoader();
            Class<GroovyTest> newClazz1 = loader.parseClass(scriptText);
            GroovyTest groovyTest1 = newClazz1.newInstance();
            groovyTest1.out();
        }

    }


    public static void main(String[] args) throws Exception{
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //loadClassDuplicate();
        executeClass();
    }


}
