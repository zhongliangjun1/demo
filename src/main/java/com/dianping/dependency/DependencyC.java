package com.dianping.dependency;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-2
 * Time: PM5:04
 * To change this template use File | Settings | File Templates.
 */
public class DependencyC {


    private DependencyA dependencyA;
    private DependencyB dependencyB;

    public DependencyC() {
        System.out.println("DependencyC()");
    }

    public void initialize(){
        System.out.println("DependencyC initialized");
    }

    public DependencyA getDependencyA() {
        return dependencyA;
    }

    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }

    public DependencyB getDependencyB() {
        return dependencyB;
    }

    public void setDependencyB(DependencyB dependencyB) {
        this.dependencyB = dependencyB;
    }
}
