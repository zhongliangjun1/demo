package com.dianping.concurrent.linearization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/2/26
 * Time: AM10:38
 * To change this template use File | Settings | File Templates.
 */
public class LinearizerDemo {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        Linearizer linearizer = new Linearizer();
        final ConcurrentPoint concurrentPoint1 = linearizer.createConcurrentPoint();
        final ConcurrentPoint concurrentPoint2 = linearizer.createConcurrentPoint();
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                concurrentPoint1.start();

                try {
                    System.err.println("point1");
                } finally {
                    concurrentPoint1.complete();
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                concurrentPoint2.start();

                try {
                    System.err.println("point2");
                } finally {
                    concurrentPoint2.complete();
                }
            }
        };


        final LinearizationPoint linearizationPoint =
                linearizer.createLinearizationPoint();
        Runnable task3 = new Runnable() {
            @Override
            public void run() {
                linearizationPoint.start();

                try {
                    System.err.println("point3");
                } finally {
                    linearizationPoint.complete();
                }
            }
        };


        final ConcurrentPoint concurrentPoint4 = linearizer.createConcurrentPoint();
        Runnable task4 = new Runnable() {
            @Override
            public void run() {
                concurrentPoint4.start();

                try {
                    System.err.println("point4");
                } finally {
                    concurrentPoint4.complete();
                }
            }
        };


        final LinearizationPoint linearizationPoint5 =
                linearizer.createLinearizationPoint();
        Runnable task5 = new Runnable() {
            @Override
            public void run() {
                linearizationPoint5.start();

                try {
                    System.err.println("point5");
                } finally {
                    linearizationPoint5.complete();
                }
            }
        };



        executor.execute(task5);
        executor.execute(task4);
        executor.execute(task3);
        executor.execute(task1);
        executor.execute(task2);

        executor.shutdown();
    }


}
