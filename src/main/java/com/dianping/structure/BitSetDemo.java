package com.dianping.structure;

import java.util.BitSet;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 15/3/27
 * Time: AM11:49
 * To change this template use File | Settings | File Templates.
 */
public class BitSetDemo {

    public static void main(String[] args) {

        BitSet bitSet = new BitSet();

        bitSet.set(134, true);
        bitSet.set(235, false);
        bitSet.set(334, true);
        bitSet.set(435, false);
        bitSet.set(534, true);

        bitSet.flip(235);

        for (int i = bitSet.nextSetBit(0); i >= 0; i = bitSet.nextSetBit(i+1)) {
            print(i + " : " + bitSet.get(i));
        }


        print("get 888 : "+bitSet.get(888));

    }

    private static void print(Object o) {
        System.out.println(o);
    }

}
