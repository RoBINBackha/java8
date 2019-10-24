package com.shengsiyuan.jdk8;

import java.util.function.Supplier;

//不接收参数，返回一个结果。多数工厂模式都是这样
public class SupplierTest010 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "hello";
        System.out.println(supplier.get());
    }
}
