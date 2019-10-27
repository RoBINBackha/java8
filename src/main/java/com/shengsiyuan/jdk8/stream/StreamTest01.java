package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest01 {

    public static void main(String[] args) {
        //流最常见的3种创建方式
        Stream<String> hello = Stream.of("hello", "world", "hello world");

        String[] arr = new String[]{"hello", "world", "hello world"};
        //一般split之后可以用这个
        Stream<String> arr1 = Stream.of(arr);
        Stream<String> arr2 = Arrays.stream(arr);

        //这种最常见
        List<String> list = Arrays.asList(arr);
        Stream<String> stream = list.stream();
    }
}
