package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamTest03 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().map(x -> x * 2).reduce(0,Integer::sum));

//        System.out.println(IntStream.range(3,8).map(x -> x*2).sum());
    }
}
