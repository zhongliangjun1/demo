package com.dianping.jar;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-21
 * Time: PM9:02
 * To change this template use File | Settings | File Templates.
 */
public class JarLoadTest {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // http://mvn.dianpingoa.com/dianping-releases/com/dianping/dish-api/0.0.1/dish-api-0.0.1-sources.jar
//        URL url = null;
//        try {
//            url = new URL("http://mvn.dianpingoa.com/dianping-releases/com/dianping/dish-api/0.0.1/dish-api-0.0.1-sources.jar");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        URL[] urls = { url };
//        ClassLoader loader = new URLClassLoader(urls);
//        loader.getResources()

        String path = "/Users/mac/Documents/dish-api-0.0.1-SNAPSHOT.jar";

        JarFile jarFile = new JarFile(new File(path));
        URL url = new URL("file:" + path);
        ClassLoader loader = new URLClassLoader(new URL[]{url});//自己定义的classLoader类，把外部路径也加到load路径里，使系统去该路经load对象
        ClassLoader parentLoader = loader.getParent();
        Enumeration<JarEntry> es = jarFile.entries();

        while(es.hasMoreElements()){
            JarEntry jarEntry = (JarEntry) es.nextElement();
            String name = jarEntry.getName();

            if(name != null && name.endsWith(".class")){//只解析了.class文件，没有解析里面的jar包
                //默认去系统已经定义的路径查找对象，针对外部jar包不能用
                //Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(name.replace("/", ".").substring(0,name.length() - 6));

                Class<?> c = loader.loadClass(name.replace("/", ".").substring(0,name.length() - 6));//自己定义的loader路径可以找到
                System.out.println(c);
//                classes.add(c);
//                Annotation[] classAnnos = c.getDeclaredAnnotations();
//                classAnnotationMap.put(c, classAnnos);
//                Method[] classMethods = c.getDeclaredMethods();
//                Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();
//                for(int i = 0;i<classMethods.length;i++){
//                    Annotation[] a = classMethods[i].getDeclaredAnnotations();
//                    methodAnnoMap.put(classMethods[i], a);
//                }
//                classMethodAnnoMap.put(c, methodAnnoMap);
            }
        }


            System.out.println();


        //System.out.println();

    }


}
