package com.zd.test;

public class A1 extends A {

    A1(){
        super();
    }

    private String name="xiaohong";

    @Override
    public String getName() {
        return name;
    }

    public String getSuperName(){
        return super.getName();
    }
}
