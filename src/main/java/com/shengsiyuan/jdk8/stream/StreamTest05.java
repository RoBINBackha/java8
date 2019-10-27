package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//map做映射，reduce做归一
public class StreamTest05 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "test");

        //实际开发中会collect的
        list.stream().map(item -> item.toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);//转大写并打印
        list.stream().map(item -> item.toUpperCase()).forEach(System.out::println);//转大写并打印
//        list.stream().map(String::toUpperCase).forEach(System.out::println);//转大写并打印

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6));
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
    }
}
