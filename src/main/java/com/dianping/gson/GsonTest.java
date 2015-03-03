package com.dianping.gson;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/3/3
 * Time: PM7:34
 * To change this template use File | Settings | File Templates.
 */
public class GsonTest {

    public static void main(String[] args) {
        Gson gson = new Gson();
        List<String> list = new ArrayList<String>();
        list.add("123");
        list.add("456");
        String result = gson.toJson(list);
        System.out.println(result);
    }

}
