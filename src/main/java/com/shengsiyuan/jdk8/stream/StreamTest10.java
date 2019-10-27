package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;

//流的运行过程初步了解
public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list =  Arrays.asList("hello", "world", "hello world");

        //注意结果：hello，5，world，5，hello world
        //而不是hello，world，hello world,5,5
        //说明流的所以操作是被放入一个箱子。当一个数据来的时候，处理所有箱子。第二个数据来的时候一样处理
        //而不是流每一个数据全部先处理完第一个操作，然后再一起去处理第二个操作
//        list.stream().mapToInt(item -> {
//            int len = item.length();
//            System.out.println(item);
//            return len;
//        }).filter(len -> len == 5).forEach(System.out::println);


        list.stream().mapToInt(item -> {
            int len = item.length();
            System.out.println(item);
            return len;
        }).filter(len -> len == 5).findFirst().ifPresent(System.out::println);

        //当把hello改成hello1，上面语句会是什么结果
    }
}
