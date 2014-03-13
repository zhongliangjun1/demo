package com.dianping.aop;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-13
 * Time: PM10:36
 * To change this template use File | Settings | File Templates.
 */
public class UserServiceImpl implements UserService {

    @Override
    public boolean addTopic(int userId, String topic) {
        System.out.println("User execute addTopic userId="+userId+" topic="+topic);
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
