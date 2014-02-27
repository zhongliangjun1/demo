package com.dianping.start;

import javax.servlet.http.HttpServlet;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-27
 * Time: AM11:59
 * To change this template use File | Settings | File Templates.
 */
public class TestServlet extends HttpServlet {
    private static final long serialVersionUID = 9033219923025826619L;

    @Override
    public void init(){
        System.out.println("TestServlet init");
    }

}
