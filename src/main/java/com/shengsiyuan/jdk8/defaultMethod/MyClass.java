package com.shengsiyuan.jdk8.defaultMethod;

public class MyClass implements MyInterface, MyInterface2{

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.method();
    }

    @Override
    public void method() {
        MyInterface2.super.method();  //接口居然有super来调用方法
    }

    //MyClass再继承MyInterface2会报错，方法同名。除非override
}
