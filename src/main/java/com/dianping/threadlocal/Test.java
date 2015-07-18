/**
 * liangjun.zhong
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.dianping.threadlocal;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author zhongliangjun1@gmail.com
 * @version $Id: Test.java, v 0.1 7/6/15 11:36 AM liangjun.zhong Exp $$
 */
public class Test {

    private static Runnable getTask(final int no, final String name) {
        return new Runnable() {
            public void run() {
                System.out.println("thread"+no+" : before set name="+ContextHolder.getContext().getName());
                ContextHolder.getContext().setName(name);
                System.out.println("thread"+no+" : after set name="+ContextHolder.getContext().getName());
                ContextHolder.clear();
                System.out.println("thread"+no+" : after clear name="+ContextHolder.getContext().getName());
            }
        };
    }

    public static void main(String[] args) {
        Runnable task1 = getTask(1, "jack");
        Runnable task2 = getTask(2, "tom");
        Runnable task3 = getTask(3, "mou");

        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);
    }

}
