package com.dianping.reflect;

import groovy.lang.GroovyClassLoader;

import java.lang.reflect.Constructor;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-5-4
 * Time: PM11:46
 * To change this template use File | Settings | File Templates.
 */
public class MyImplements implements InterfaceC {
    @Override
    public void smile() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void look() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void listen() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void eat() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args) throws Exception {
        Class<?>[] interfaces = MyImplements.class.getInterfaces();
        for(Class clazz : interfaces){
            System.out.println(clazz.getName());
        }

        String s = null;
        try {
            s.charAt(0);
        } catch (Exception e) {
            Constructor constructor = TemplateException.class.getConstructor(Throwable.class);
            RuntimeException runtimeException = (RuntimeException) constructor.newInstance(e);
            //runtimeException.printStackTrace();
            System.out.println(runtimeException);
        }

        GroovyClassLoader loader = new GroovyClassLoader();
        Class cla = loader.parseClass(templateException.replaceAll("#widgetName#", "Test"));
        System.out.println(cla);

    }

    private static final String templateException = "" +
            "public class #widgetName#Exception extends RuntimeException {\n" +
            "    public #widgetName#Exception(Throwable cause) {\n" +
            "        super(cause);\n" +
            "    }\n" +
            "}";

}
