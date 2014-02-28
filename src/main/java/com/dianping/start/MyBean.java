package com.dianping.start;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-27
 * Time: PM8:49
 * To change this template use File | Settings | File Templates.
 */
public class MyBean implements BeanNameAware, BeanFactoryAware {

    private String myName;
    private int age;
    private String password;
    private String sex;


    public MyBean() {
        System.out.println("MyBean constructor");
    }

    public MyBean(String myName) {
        this.myName = myName;
        System.out.println("MyBean constructor(String name)");
    }

    /**
     * The name of the custom initialization method to invoke after setting
     bean properties. The method must have no arguments, but may throw any
     exception.
     */
    public void initMyself(){
        this.age = 18;
        System.out.println("initMyself with age=18 ");
        System.out.println("");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory!");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName : "+s);
    }

    public void setMyName(String myName) {
        this.myName = myName;
        System.out.println("setMyName : "+myName);
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("setAge : "+age);
    }

    public void setPassword(String password) {
        this.password = password;
        System.out.println("setPassword : "+password);
    }

    public void setSex(String sex) {
        this.sex = sex;
        System.out.println("setSex : "+sex);
    }
}
