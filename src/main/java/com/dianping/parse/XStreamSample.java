package com.dianping.parse;

import com.dianping.parse.entity.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-30
 * Time: PM3:34
 * To change this template use File | Settings | File Templates.
 */
public class XStreamSample {

    private static XStream xStream;

    static {
        xStream = new XStream(new DomDriver());
        xStream.processAnnotations(User.class); // 标注需要XStream解析的注解java对象
    }

    public static User getUser(){
        User user = new User();
        user.id = 1;
        user.name = "dajun";
        user.birthday = new Date();
        List<String> phoneNumbers = new ArrayList<String>();
        phoneNumbers.add("110");
        user.phoneNumbers = phoneNumbers;

        return user;
    }

    public static void objectToXml() throws FileNotFoundException {
        User user = getUser();
        FileOutputStream outputStream = new FileOutputStream("test1.xml");
        xStream.toXML(user, outputStream);
    }

    public static void main(String[] args) throws FileNotFoundException {
        objectToXml();
    }


}
