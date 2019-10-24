package com.shengsiyuan.jdk8.defaultMethod;

public interface MyInterface2 {

    default void method() {
        System.out.println("method2");
    }
}
