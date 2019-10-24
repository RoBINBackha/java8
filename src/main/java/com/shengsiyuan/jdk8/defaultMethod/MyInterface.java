package com.shengsiyuan.jdk8.defaultMethod;

public interface MyInterface {

    default void method() {
        System.out.println("method");
    }
}
