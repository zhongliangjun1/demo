package com.dianping.groovy;

import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.io.IOException;

/**
 * @author sajia
 *
 */
public class TestGroovyShell   {

    private static int count = 0;

    // see if the number of loaded class keeps growing when using GroovyShell.parse
    public static void test() {
        GroovyShell shell = new GroovyShell();
        String scriptText = "def mul(x, y) { x * y }\n println mul(5, 7)";
        //Script script = shell.parse(scriptText);
        while (true) {
            Script script = shell.parse(scriptText);
            Object result = script.run();
            System.out.println(count++);
        }
    }



    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        test();
    }
}