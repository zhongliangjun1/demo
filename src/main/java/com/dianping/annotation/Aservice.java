package com.dianping.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-4
 * Time: PM4:53
 * To change this template use File | Settings | File Templates.
 */

@org.springframework.stereotype.Service
public class Aservice implements Service {

    @Autowired
    private Dao bdao; // @Autowired 在类型唯一的情况下，根据类型注入，在类型不唯一的情况下，根据beanName注入
    @Autowired
    private Dao adao;

    @Autowired
    private List<Dao> daos;


    @Override
    public void test() {
        System.out.println("Aservice execute test() begin");
        System.out.println("begin execute adao.load()");
        adao.load();
        System.out.println("begin execute bdao.load()");
        bdao.load();
        System.out.println("List<Dao> daos size:"+daos.size());
        System.out.println("Aservice execute test() end");
    }

}
