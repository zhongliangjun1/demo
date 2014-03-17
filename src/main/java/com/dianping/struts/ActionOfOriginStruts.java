package com.dianping.struts;

import com.dianping.aop.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-18
 * Time: AM12:35
 * To change this template use File | Settings | File Templates.
 */
public class ActionOfOriginStruts extends ActionSupport {

    private static final long serialVersionUID = 232834287298017247L;

    private UserService userService;

    @Override
    public String execute() throws Exception {
        try{
            userService.addTopic(10, "ActionOfOriginStruts");
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
