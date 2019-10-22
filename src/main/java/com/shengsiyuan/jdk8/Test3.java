package com.shengsiyuan.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test3 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello","world","boy");

        List<String> list2  = new ArrayList<>();

        //not j8
        list.forEach(s -> list2.add(s.toUpperCase()));
        list2.forEach(System.out::println);

        //Function<T, R>  T表示输入的类型，R表示输出的类型， 所以apply.toLowerCase()的位置一定是一个有返回值的方法才不会编译报错
        //parallelStream        lamda表达式
        list.stream().map(apply -> apply.toLowerCase()).forEach(accept -> System.out.println(accept));
        //方法引用的方式
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //4种方法引用中的其中一种
        Function<String, String> function = String::toUpperCase;
        System.out.println(function.getClass().getInterfaces()[0]);

        //构造方法的引用 ArrayList::new

    }
}
