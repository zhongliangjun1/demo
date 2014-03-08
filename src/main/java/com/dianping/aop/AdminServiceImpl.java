package com.dianping.aop;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM10:27
 * To change this template use File | Settings | File Templates.
 */
public class AdminServiceImpl implements AdminService {

    @Override
    public boolean addTopic(int userId, String topic) {
        System.out.println("execute addTopic userId="+userId+" topic="+topic);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean removeTopic(int userId) {
        System.out.println("execute removeTopic userId="+userId);
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void innerMethod(){
        System.out.println("execute innerMethod ");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
