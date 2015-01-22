package com.dianping.io.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/1/21
 * Time: PM3:20
 * To change this template use File | Settings | File Templates.
 */
public class FileChannelTest {

    public static void main(String[] args) throws Exception {


        RandomAccessFile aFile = new RandomAccessFile("/Users/mac/Documents/mywork/spring-demo/src/main/resources/file/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        RandomAccessFile oFile = new RandomAccessFile("/Users/mac/Documents/mywork/spring-demo/src/main/resources/file/output.txt", "rw");
        FileChannel outChannel = oFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48); //create buffer with capacity of 48 bytes
        //CharBuffer buf = CharBuffer.allocate(48);

        int bytesRead = inChannel.read(buf); //read into buffer.

        while (bytesRead != -1) {

            buf.flip();  //make buffer ready for read

            while(buf.hasRemaining()){
                System.out.print((char) buf.get()); // read 1 byte at a time
                //outChannel.write(buf);
            }

            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }

        aFile.close();
        oFile.close();

    }

}
