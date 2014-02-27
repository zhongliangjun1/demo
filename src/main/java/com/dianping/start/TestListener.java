package com.dianping.start;

import javax.servlet.ServletContextEvent;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-27
 * Time: AM11:55
 * To change this template use File | Settings | File Templates.
 */
public class TestListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("TestListener contextInitialized  get ServletContextEvent");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //To change body of implemented methods use File | Settings | File Templates.
    }



}
