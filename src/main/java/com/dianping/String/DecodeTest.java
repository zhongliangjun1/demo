package com.dianping.String;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-12-17
 * Time: PM6:28
 * To change this template use File | Settings | File Templates.
 */
public class DecodeTest {

    public static void main(String[] args) {

        System.out.println(URLEncoder.encode("http://alpha.shopping.admin.dp/admin/"));

        System.out.println(URLEncoder.encode("http://alpha.shopping.admin.dp/shopping/admin/searchpromo?type=1&pageNo=1&pageSize=10"));

        String href = "dianping://recommendshop?url=http%3A%2F%2Fm.dianping.com%2Fforum%2Fnote%2F7761277%3Fsource%3Dapp%26_utm%3D__2i57%26_p%3Dmain_app_shopping_richbutton%26dp_res%3Dmain_app_shopping_richbutton%26title%3D%25E5%259C%25A3%25E8%25AF%259E%25E8%258A%2582%25E4%25B9%25B0%25E4%25B9%25B0%25E4%25B9%25B0&amp;utm=w_opplatform_app";
        String url = URLDecoder.decode(href.split("url=")[1]);
        String result = url.split("\\?")[0];
        System.out.println(result);
    }

}
