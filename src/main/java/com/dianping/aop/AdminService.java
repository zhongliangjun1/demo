package com.dianping.aop;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-8
 * Time: PM10:23
 * To change this template use File | Settings | File Templates.
 */
public interface AdminService {

    public boolean addTopic(int userId, String topic);

    public boolean removeTopic(int userId);

}
