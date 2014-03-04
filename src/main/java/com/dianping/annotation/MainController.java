package com.dianping.annotation;

import com.dianping.utils.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-4
 * Time: PM4:56
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class MainController {

    @Autowired
    private Service service; // @Autowired是根据类型，而不是name来匹配注入的; 在接口有多种实现时，可以通过@Qualifier来指定beanName


    static {
        ApplicationContextUtils.initialize();
    }

    public void doSomething(){
        service.test();
    }

    @PostConstruct
    public void init(){
        System.out.println("MainController init()");
    }


    public static void main(String[] args) {
        //MainController controller = new MainController(); // 这样创建的bean是不受spring管理的，自然不会被注入
        MainController controller = ApplicationContextUtils.getBean("mainController"); // 注解标注的bean，其name也是类名首字母小写
        controller.doSomething();
        System.out.println("end");
    }

//    @Autowired
//    public void setService(Service service) {
//        this.service = service;
//    }


}
