package com.dianping.annotation;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-4
 * Time: PM5:51
 * To change this template use File | Settings | File Templates.
 */

@Repository
public class Adao implements Dao, BeanNameAware {

    @Override
    public void load() {
        System.out.println("Adao execute load()");
    }

    private String beanName;

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("Adao setBeanName :"+name);
    }

    public String getBeanName() {
        return beanName;
    }
    
}
