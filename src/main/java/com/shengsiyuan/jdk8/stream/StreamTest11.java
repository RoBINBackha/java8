package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest11 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world hello", "hello welcome");

        //cjh自己写的（有问题）
        list.stream().map(str -> str.split(" ")).collect(Collectors.toList()).stream().distinct().forEach(System.out::println);

        //flagMap的应用场景是很多的，flagMap这里将数组打散成多个stream流。而不是一个stream流里多个stream
        list.stream().map(str -> str.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);
    }
}
