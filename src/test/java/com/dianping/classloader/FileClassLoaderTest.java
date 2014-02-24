package com.dianping.classloader;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-24
 * Time: PM9:53
 * To change this template use File | Settings | File Templates.
 */
public class FileClassLoaderTest {

    public static void main(String[] args) throws Exception {
        FileClassLoader loader = new FileClassLoader("/Users/mac/Documents/mywork/dish/dish-beans/dish-api/target/classes");
        //loader.findClass("com.dianping.App");
        loader.loadClass("com.dianping.dishremote.remote.MenuService");
    }

}
