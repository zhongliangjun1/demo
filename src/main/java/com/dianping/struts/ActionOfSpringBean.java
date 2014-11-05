package com.dianping.struts;

import com.dianping.aop.UserService;
import com.dianping.start.SingletonBeanUpdateTest;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-18
 * Time: AM1:12
 * To change this template use File | Settings | File Templates.
 */
public class ActionOfSpringBean implements ApplicationContextAware {

    private UserService userService;

    private ApplicationContext applicationContext;
    //private SingletonBeanUpdateTest singletonBeanUpdateTest;


    public String execute(){
        userService.addTopic(11, "ActionOfSpringBean");
        SingletonBeanUpdateTest singletonBeanUpdateTest = (SingletonBeanUpdateTest) applicationContext.getBean("singletonBeanUpdateTest");
        singletonBeanUpdateTest.test();
        return "success";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

//    public void setSingletonBeanUpdateTest(SingletonBeanUpdateTest singletonBeanUpdateTest) {
//        this.singletonBeanUpdateTest = singletonBeanUpdateTest;
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
