package com.dianping.parse;

import com.dianping.parse.entity.User;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;

import java.io.*;
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

    /**
     * 流式处理
     */
    public static void objectToXmlWithStream() throws IOException {
        User user = getUser();
        PrintWriter printWriter = new PrintWriter("test2.xml");
        PrettyPrintWriter writer = new PrettyPrintWriter(printWriter);
        ObjectOutputStream outputStream = xStream.createObjectOutputStream(writer);
        outputStream.writeObject(user);
        outputStream.close();
    }

    public static void xmlToObjectWithStream() throws IOException, ClassNotFoundException {
        FileReader reader = new FileReader("test2.xml");
        BufferedReader bufferedReader = new BufferedReader(reader);

        ObjectInputStream inputStream = xStream.createObjectInputStream(bufferedReader);
        User user = (User) inputStream.readObject();
        System.out.println(user.toString());
    }

    public static void main(String[] args) throws Exception {
        //objectToXml();
        //objectToXmlWithStream();
        xmlToObjectWithStream();
    }


}
