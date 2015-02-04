package com.dianping.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/1/22
 * Time: AM12:20
 * To change this template use File | Settings | File Templates.
 */
public class ServerSocketChannelTest {

    public void startServer() throws IOException {

        Selector selector = Selector.open();

        // 建立channel，并绑到9000端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 3000);
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 3000);
        serverSocketChannel.socket().bind(address);
        serverSocketChannel.configureBlocking(false);

        // 向selector注册channel和感兴趣的事件
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        printKeyInfo(selectionKey);

        int channels = 0;
        int selectTimes = 0;

        while (true) {

            int keysNum = selector.select();
            selectTimes++;
            debug(String.format("selector selects %d times, now keysNum is %d", selectTimes, keysNum));

            if ( keysNum>0 ) {

                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();

                while ( iterator.hasNext() ) {

                    SelectionKey key = iterator.next();
                    iterator.remove();
                    //printKeyInfo(key);

                    if( key.isAcceptable() ) {

                        // a connection was accepted by a ServerSocketChannel.
                        ServerSocketChannel serverChannel = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = serverChannel.accept();
                        channels++;
                        debug(String.format("now channels count = %d", channels));

                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {

                        // a channel is ready for reading
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        int count = socketChannel.read(buffer);
                        if (count > 0) {
                            buffer.flip();
                            CharsetDecoder charsetDecoder = Charset.forName("UTF-8").newDecoder();
                            CharBuffer charBuffer = charsetDecoder.decode(buffer);
                            debug( "get the msg from client : " + charBuffer.toString() );
                        }
                        buffer.clear();

                        socketChannel.finishConnect();
                        socketChannel.close();


                    } else if (key.isWritable()) {
                        // a channel is ready for writing
                    }

                }

            } else {

                debug("without any keys this time-----");

            }

        }


    }

    private static void printKeyInfo(SelectionKey sk) {

        String s;
        s = "Att: " + (sk.attachment() == null ? "no" : "yes");
        s += ", Read: " + sk.isReadable();
        s += ", Acpt: " + sk.isAcceptable();
        s += ", Cnct: " + sk.isConnectable();
        s += ", Wrt: " + sk.isWritable();
        s += ", Valid: " + sk.isValid();
        s += ", Ops: " + sk.interestOps();

        debug(s);
    }

    public static void debug(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable serverTask = new Runnable() {
            @Override
            public void run() {
                try {
                    new ServerSocketChannelTest().startServer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable clientTask = new Runnable() {
            @Override
            public void run() {

                try {
                    SocketChannel socketChannel = SocketChannel.open();
                    //socketChannel.configureBlocking(false);
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 3000));

                    CharsetEncoder encoder = Charset.forName("UTF-8").newEncoder();
                    socketChannel.write(encoder.encode(CharBuffer.wrap("hello")));

                    socketChannel.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        pool.execute(serverTask);
        Thread.sleep(2000);

        pool.execute(clientTask);
        Thread.sleep(500);
        pool.execute(clientTask);
        pool.execute(clientTask);
        Thread.sleep(20000);
        pool.execute(clientTask);



    }



}
