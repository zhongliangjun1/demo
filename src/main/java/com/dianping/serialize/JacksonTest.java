package com.dianping.serialize;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-5
 * Time: PM4:02
 * To change this template use File | Settings | File Templates.
 */
public class JacksonTest {


    public static void main(String[] args) throws IOException {
        String json = "{ \"name\":\"product\", \"price\":12.3401 }";
        ObjectMapper mapper = new ObjectMapper();
        MyValue myValue = mapper.readValue(json, MyValue.class);
        System.out.println(myValue.getPrice().toString());
    }


}
