package com.dianping.start;
import javax.servlet.*;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-27
 * Time: AM11:22
 * To change this template use File | Settings | File Templates.
 */
public class TestFilter1 implements javax.servlet.Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init "+filterConfig.getFilterName()+" param :"+filterConfig.getInitParameter("filterparam1"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("TestFilter1 doFilter");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
