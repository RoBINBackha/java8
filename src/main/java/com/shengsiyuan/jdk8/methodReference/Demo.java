package com.shengsiyuan.jdk8.methodReference;

import java.util.Arrays;
import java.util.List;

public class Demo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello word");
        list.forEach(item -> System.out.println(item));
        list.forEach(System.out::println);
    }
}
