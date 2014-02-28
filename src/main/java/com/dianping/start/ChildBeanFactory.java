package com.dianping.start;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-28
 * Time: PM1:26
 * To change this template use File | Settings | File Templates.
 */
public class ChildBeanFactory {

    public static int getBankSavings(){
        System.out.println("ChildBeanFactory.getBankSavings : produce one banksvings : ");
        return 100000;
    }


}
