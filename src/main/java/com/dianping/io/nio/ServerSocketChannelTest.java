package com.dianping.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
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
        int channels = 0;

        // 建立channel，并绑到9000端口
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(), 3000);
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 3000);
        serverSocketChannel.socket().bind(address);
        serverSocketChannel.configureBlocking(false);

        // 向selector注册channel和感兴趣的事件
        SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        printKeyInfo(selectionKey);

        while (true) {

            debug("start selecting-----");

            int keysNum = selector.select();
            if ( keysNum>0 ) {

                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeySet.iterator();
                while ( iterator.hasNext() ) {
                    SelectionKey key = iterator.next();
                    printKeyInfo(key);
                    iterator.remove();
                    if ( key.isAcceptable() ) {

                    } else {
                        debug("not acceptable");
                    }

                    if(key.isAcceptable()) {
                        // a connection was accepted by a ServerSocketChannel.
                        ServerSocketChannel channel = (ServerSocketChannel) key.channel();
                        Socket socket = channel.accept().socket();
                        SocketChannel socketChannel = socket.getChannel();
                        debug((++channels)+"");
                    } else if (key.isConnectable()) {
                        // a connection was established with a remote server.
                    } else if (key.isReadable()) {
                        // a channel is ready for reading
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
                    socketChannel.configureBlocking(false);
                    socketChannel.connect(new InetSocketAddress("127.0.0.1", 3000));

                    while(! socketChannel.finishConnect() ){
                        System.out.println("----");
                    }

                    Thread.sleep(6000);
                    socketChannel.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.execute(serverTask);
        Thread.sleep(2000);
        pool.execute(clientTask);
        Thread.sleep(20000);
        pool.execute(clientTask);



    }



}
