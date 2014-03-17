package com.dianping.struts;

import com.dianping.aop.UserService;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-18
 * Time: AM1:12
 * To change this template use File | Settings | File Templates.
 */
public class ActionOfSpringBean {

    private UserService userService;


    public String execute(){
        userService.addTopic(11, "ActionOfSpringBean");
        return "success";
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
