package com.zd.test;

public class A {
    private String name="xiaobai";
    private int num=50;

    public A() {
    }

    public A(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void show(){
        System.out.println(0);
    }

    public void show(String word){
        System.out.println(word);
    }
}
