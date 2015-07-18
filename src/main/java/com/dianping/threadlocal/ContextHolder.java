/**
 * liangjun.zhong
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package com.dianping.threadlocal;

/**
 * @author zhongliangjun1@gmail.com
 * @version $Id: ContextHolder.java, v 0.1 7/6/15 10:54 AM liangjun.zhong Exp $$
 */
public class ContextHolder {

    private static ThreadLocal<Context> holder = new ThreadLocal<Context>();

    public static Context getContext() {
        if (holder.get() == null) {
            holder.set(new Context());
            System.out.println(holder.hashCode()+" init context -----");
        }
        return holder.get();
    }

    public static void clear() {
        holder.remove();
    }

    public static void main(String[] args) {
        Context context = getContext();
        context.setName("jack");
        clear();

        context = getContext();
        System.out.println(context.getName());
    }

}
