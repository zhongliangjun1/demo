package com.dianping.parse.entity;

import com.dianping.parse.DateConvert;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-30
 * Time: PM3:35
 * To change this template use File | Settings | File Templates.
 */
@XStreamAlias("user")
public class User {

    @XStreamAsAttribute
    public int id;

    public String name;

    @XStreamConverter(DateConvert.class)
    public Date birthday;

    public List<String> phoneNumbers;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
