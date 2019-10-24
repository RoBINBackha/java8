package com.shengsiyuan.jdk8.defaultMethod;

import com.shengsiyuan.jdk8.defaultMethod.impl.MyInterfaceImpl;

public class MyClass2 extends MyInterfaceImpl implements MyInterface2 {

    public static void main(String[] args) {
        MyClass2 myClass = new MyClass2();
        myClass.method();
    }
    //之所以不像上一个案例一样报错，是因为编译器认为实现类比接口的优先级更高
}
