package com.dianping.classloader;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-17
 * Time: PM3:49
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentMapTest {

    private static ConcurrentMap<String,AtomicInteger> counter = new ConcurrentHashMap<String,AtomicInteger>();

    static Map m = new HashMap();

    public static void main(String[] args) {

        m.put("a", null);

        //counter.put("a", null);



    }

}
