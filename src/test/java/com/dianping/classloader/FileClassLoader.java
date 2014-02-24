package com.dianping.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-2-24
 * Time: AM12:41
 * To change this template use File | Settings | File Templates.
 */
public class FileClassLoader extends ClassLoader {

    private String fileRootPath;
    private File root;

    public FileClassLoader(String filePath) throws FileNotFoundException {
        this.fileRootPath = filePath;
        this.root = new File(this.fileRootPath);
        if(!root.exists()) throw new FileNotFoundException();
    }


    /**
     * Finds the class with the specified binary name.
     * @param name : com.dianping.classloader.FileClassLoader
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        if(name==null || name.equals("")) throw new ClassNotFoundException();
        Class clazz = this.findLoadedClass(name);
        if(clazz==null){
            String className = enhanceClassName(name);
            byte[] classBytes = loadClassBytes(className);
            clazz = defineClass(name, classBytes, 0, classBytes.length);
        }
        return clazz;
    }

    private String enhanceClassName(String className){
        String suffix = ".class";
        //className = className.replace('.',File.separatorChar) + suffix;
        className = className.substring(className.lastIndexOf(".")+1) + suffix;
        return className;
    }

    private byte[] loadClassBytes(String className) throws ClassNotFoundException {
        try {
            return readFile(root, className);
        } catch (IOException e) {
            throw new ClassNotFoundException("class not found", e);
        }
    }

    private byte[] readFile(File file, String className) throws IOException {
        if(file.isDirectory()){
            File[] childFiles = file.listFiles();
            if(childFiles!=null){
                for(File f : childFiles){
                    try{
                        return readFile(f, className);
                    }catch (Exception e){};
                }
            }
        } else {
            if(file.getName().equals(className)){
                FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());
                try {
                    byte[] bytes = new byte[fileInputStream.available()];
                    fileInputStream.read(bytes);
                    return bytes;
                } finally {
                    fileInputStream.close();
                }
            }
        }
        throw new FileNotFoundException();
    }

    public static void main(String[] args) throws Exception {
        FileClassLoader loader = new FileClassLoader("/Users/mac/Documents/mywork/dish/dish-beans/dish-api/target/classes");
        //loader.findClass("com.dianping.App");
        loader.loadClass("com.dianping.dishremote.remote.MenuService");
    }


}
