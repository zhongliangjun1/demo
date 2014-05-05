package com.dianping.reflect;

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

    public static void main(String[] args) {
        Class<?>[] interfaces = MyImplements.class.getInterfaces();
        for(Class clazz : interfaces){
            System.out.println(clazz.getName());
        }
    }

}
