package com.dianping.aop.cglib;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-5-8
 * Time: AM2:37
 * To change this template use File | Settings | File Templates.
 */
public class StudentInfoServiceImpl {


    public void findInfo(String name){
        System.out.println("你目前输入的名字是:"+name);
        //StudentInfoServiceImpl类内部调用！
        findInfo2();
        System.out.println("complete method findInfo");
    }

    //private void findInfo2(){
    public void findInfo2(){
        System.out.println("i'm in findinfo2!!!");
    }

}
