package com.dianping.math;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-4
 * Time: PM9:23
 * To change this template use File | Settings | File Templates.
 */
public class DecimalTest {

    /**
     * The results of this constructor can be somewhat unpredictable. One might assume that
     new BigDecimal(.1) is exactly equal to .1, but it is actually equal
     to .1000000000000000055511151231257827021181583404541015625. This is so because .1
     cannot be represented exactly as a double (or, for that matter, as a binary fraction
     of any finite length). Thus, the long value that is being passed in to the constructor
     is not exactly equal to .1, appearances nonwithstanding.
     The (String) constructor, on the other hand, is perfectly predictable: new BigDecimal
     (".1") is exactly equal to .1, as one would expect. Therefore, it is generally
     recommended that the (String) constructor be used in preference to this one.
     *
     */

    public static void main(String[] args) {
        double a = 2.00;
        double b = 1.10;
        System.out.println("double a = "+a);
        System.out.println("double b = "+b);
        System.out.println("a-b = "+(a-b));

        System.out.println("-------------------------------");

        BigDecimal decimalA = new BigDecimal(a);
        BigDecimal decimalB = new BigDecimal(b);
        System.out.println("double a = "+decimalA.toString());
        System.out.println("double b = "+decimalB.toString());
        System.out.println("a-b = "+decimalA.subtract(decimalB));

        System.out.println("-------------------------------");

        BigDecimal decimalC = new BigDecimal("2.00");
        BigDecimal decimalD = new BigDecimal("1.10");
        System.out.println("double a = "+decimalC.toString());
        System.out.println("double b = "+decimalD.toString());
        System.out.println("a-b = "+decimalC.subtract(decimalD));


    }

}
