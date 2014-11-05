package com.dianping.start;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-11-5
 * Time: PM2:49
 * To change this template use File | Settings | File Templates.
 */
public class SingletonBeanUpdateTestImpl implements SingletonBeanUpdateTest {

    private int count = 0;

    @Override
    public void test() {
        count = count + 1;
        System.out.println("now count is "+count);
    }
}
