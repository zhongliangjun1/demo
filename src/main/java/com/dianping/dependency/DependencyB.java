package com.dianping.dependency;

/**
 * Created with IntelliJ IDEA.
 * Author: liangjun.zhong
 * Date: 14-3-1
 * Time: PM10:11
 * To change this template use File | Settings | File Templates.
 */
public class DependencyB {

    private DependencyA dependencyA;

    public DependencyB() {
        System.out.println("DependencyB()");
    }

    public void initialize(){
        System.out.println("DependencyB initialized");
    }

    public void setDependencyA(DependencyA dependencyA) {
        this.dependencyA = dependencyA;
    }
}
