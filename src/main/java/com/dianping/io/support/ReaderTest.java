package com.dianping.io.support;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-12-4
 * Time: PM7:07
 * To change this template use File | Settings | File Templates.
 */
public class ReaderTest {

    public static void main(String[] args) throws IOException {
        treatFile1();
        for ( int i = 2; i<=7; i++ ) {
            treatOtherFile(i+"");
        }
    }

    private static void treatFile1() throws IOException {
        InputStream inputStream = new FileInputStream("/Users/mac/Documents/mywork/users/1");
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        File outFile = new File("/Users/mac/Documents/mywork/users/users");
        FileWriter writer = new FileWriter(outFile,true);
        outFile.createNewFile();
        while ( br.ready() ) {
            String oneLine = br.readLine();
            String openid = oneLine.split("\t")[0] + System.getProperty("line.separator");
            writer.write(openid);
            writer.flush();
        }
        writer.close();
        br.close();
        System.out.println("file 1 done");
    }

    private static void treatOtherFile(String name) throws IOException {
        InputStream inputStream = new FileInputStream("/Users/mac/Documents/mywork/users/"+name);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        File outFile = new File("/Users/mac/Documents/mywork/users/users");
        FileWriter writer = new FileWriter(outFile,true);
        while ( br.ready() ) {
            String oneLine = br.readLine();
            String openid = oneLine.split("\t")[1] + System.getProperty("line.separator");
            writer.write(openid);
            writer.flush();
        }
        writer.close();
        br.close();
        System.out.println("file "+name+" done");
    }

}
