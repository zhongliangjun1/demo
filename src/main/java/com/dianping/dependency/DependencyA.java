package com.dianping.dependency;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-1
 * Time: PM10:11
 * To change this template use File | Settings | File Templates.
 */
public class DependencyA {

    private DependencyB dependencyB;

    public DependencyA() {
        System.out.println("DependencyA()");
    }

    public void setDependencyB(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }
}
