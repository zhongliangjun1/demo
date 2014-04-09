package com.dianping.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-8
 * Time: PM3:55
 * To change this template use File | Settings | File Templates.
 */

@Controller
//@RequestMapping("/spring-mvc")
public class AppController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name", required = false, defaultValue = "soso") String name,  ModelMap model){

        model.put("isOk", true);
        model.put("message", "hello "+name);

        return "hello";
    }

    @RequestMapping(value = "/ajax/shop/load", method = RequestMethod.GET)
    public @ResponseBody Shop loadShop(){

        Shop shop = new Shop();
        shop.setShopId(11);
        shop.setShopName("云中小雅");
        shop.setAddTime(new Date());

        return shop;
    }


}
