package com.dianping.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-26
 * Time: AM11:36
 * To change this template use File | Settings | File Templates.
 */
public class PropertiesParse {

    private Properties pts;

    public void parse(String propertiesPath) throws IOException {
        this.pts = new Properties();
        if(propertiesPath != null){
            final InputStream propIn = this.getClass().getClassLoader().getResourceAsStream(propertiesPath);
            this.pts.load(new InputStream() {
                boolean temp=false;
                public int read() throws IOException {
                    if(temp){
                        temp=false;
                        return ':';
                    }
                    int result=propIn.read();
                    if(result==(int)':'){
                        temp=true;
                        return '\\';
                    }
                    return result;
                }
            });
            propIn.close();
        }

    }

    public static void main(String[] args) throws IOException {
        PropertiesParse parse = new PropertiesParse();
        parse.parse("applicationContext.properties");
    }

}
