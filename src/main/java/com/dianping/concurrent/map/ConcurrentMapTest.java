package com.dianping.concurrent.map;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/3/9
 * Time: PM4:47
 * To change this template use File | Settings | File Templates.
 */
public class ConcurrentMapTest {

    public static void concurrentMapOfGuavaTest() {

        Map<String, Object> data = Maps.newConcurrentMap();

        data.put("null", null);

    }

    public static void hashMapTest() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.keySet();
        map.entrySet();
    }

    public static void main(String[] args) {
        concurrentMapOfGuavaTest();
    }

}
