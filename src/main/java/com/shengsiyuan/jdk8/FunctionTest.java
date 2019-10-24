package com.shengsiyuan.jdk8;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest t = new FunctionTest();
        System.out.println(t.test(1, i -> i + 2));
    }

    //在自己写的类中定义一个函数式接口的方法
    private int test(int a, Function<Integer,Integer> function) {
        return function.apply(a);
    }

    //高阶函数：如果一个函数接收一个函数作为参数，或者返回一个函数作为返回值，那么该函数就叫做高阶函数
}
