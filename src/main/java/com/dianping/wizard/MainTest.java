package com.dianping.wizard;

import groovy.lang.GroovyClassLoader;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-4-29
 * Time: PM8:51
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {

    private static String getScriptText(String groovyName) throws IOException {
        ClassPathResource loader = new ClassPathResource("/groovy/"+groovyName+".groovy", MainTest.class.getClassLoader());
        InputStream inputStream = loader.getInputStream();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int BUFFER_SIZE = 1024;
        byte[] data = new byte[BUFFER_SIZE];
        int count = -1;
        while((count = inputStream.read(data,0,BUFFER_SIZE)) != -1)
            outputStream.write(data, 0, count);

        String scriptText = new String(outputStream.toByteArray(),"UTF-8");
        inputStream.close();
        outputStream.close();
        return scriptText;
    }

    public static void phraseScriptText(String scriptText) throws IllegalAccessException, InstantiationException {
        GroovyClassLoader loader = new GroovyClassLoader();
        Class<WidgetBusiness> clazz = loader.parseClass(scriptText);
        WidgetBusiness widgetBusiness = clazz.newInstance();
        Map<String, Object> params = new ConcurrentHashMap<String, Object>();
        params.put("integer", 1);
        params.put("string", "hello");
        widgetBusiness.setParams(params);
        ResultType resultType = widgetBusiness.execute();
        if (resultType==ResultType.SUCCESS){
            System.out.println("ResultType.SUCCESS");
        }
    }

    public static void main(String[] args) throws Exception{
        String scriptText = getScriptText("BasicInfo");
        //System.out.println(scriptText);
        phraseScriptText(scriptText);
    }


}
