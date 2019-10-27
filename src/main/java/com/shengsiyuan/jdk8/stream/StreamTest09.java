package com.shengsiyuan.jdk8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class StreamTest09 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(5000000);

        //randomUUID居然不是Long类型，是UUID类型
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        System.out.println("开始执行");
        long startTime = System.nanoTime();
//        Stream.of(list).sorted().forEach(System.out::println);//注意这里Stream.of(list)返回的是Stream<List<String>>
        list.stream().sorted().forEach(System.out::println); //而这里返回的是Stream<String>，所以一般开发的时候，千万不要用第一个，出了BUG找都找不到地方
        list.parallelStream().sorted().forEach(System.out::println);//并发的效率大概是开平方
        long endTime = System.nanoTime();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));


    }
}
