package com.shengsiyuan.jdk8.stream;

import java.util.IntSummaryStatistics;
import java.util.UUID;
import java.util.stream.Stream;

public class StreamTest06 {

    public static void main(String[] args) {
//        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
//        stream.findFirst().ifPresent(System.out::println);

//        Stream.iterate(1, item -> item +2).forEach(System.out::println);//无限流
        Stream.iterate(1, item -> item +2).limit(6).forEach(System.out::println);

        //找出Stream.iterate(1, item -> item + 2).limit(6)这个流中，
        //大于2的元素，然后将每个元素乘以2，然后忽略掉前两个元素，然后再取前两个元素，最后求出流中元素的总和
        //map本身也行，但mapToInt可以避免Function接收返回参数时的自动装拆箱
//        Integer reduce = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).sum();
//        Integer reduce = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).reduce(0, Integer::sum);
        //还可以通过IntSummaryStatistics这个操作一体化类去指定操作
        IntSummaryStatistics summaryStatistics = Stream.iterate(1, item -> item + 2).limit(6).filter(item -> item > 2).mapToInt(item -> item * 2).skip(2).limit(2).summaryStatistics();
        summaryStatistics.getSum();
    }
}
