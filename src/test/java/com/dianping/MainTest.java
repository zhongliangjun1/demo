package com.dianping;

import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import java.io.IOException;
import java.security.Security;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-6-18
 * Time: PM4:33
 * To change this template use File | Settings | File Templates.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        System.setProperty("javax.net.ssl.trustStore", "/Library/Java/Home/lib/security/cacerts");
        System.setProperty("java.protocol.handler.pkgs","com.sun.net.ssl.internal.www.protocol");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        Response response = Request.Get("https://graph.qq.com/v3/qqclient/dianping_reddot?appid=200002&openid=86C72E87D7DD5A979FDE5AB2CA904907&access_token=BACBB4CB8BF92D5B51A2C05A4626E894&pf=qzone").execute();
        Content content = response.returnContent();
        System.out.println(content);
    }

}
