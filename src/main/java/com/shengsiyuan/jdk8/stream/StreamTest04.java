package com.shengsiyuan.jdk8.stream;

import sun.security.util.Length;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest04 {

    public static void main(String[] args) {

        //数组   -> 流
        Stream<String> stream = Stream.of("hello", "world");
        //流转   -> 数组
//        String[] array = stream.toArray(len -> new String[len]);// 没懂
//        String[] array = stream.toArray(String::new);
//        String[] array = stream.toArray(String[]::new);
        //数组   -> array
        List<String> list = Arrays.asList("a", "b", "c");
        //array  -> 数组
        String[] strings  = (String[])list.toArray();

        //三种写法都可以，但都不太好理解
//        List<String> collect = stream.collect(Collectors.toList());
//        List<String> collect2 = stream.collect(()->new ArrayList(), (theList, item) -> theList.add(item), (theList1, theList2) -> theList1.addAll(theList2));//刚开始不懂它怎么知道参数的类型的，其实R在第一个返回的结果的时候就确定了
//        List<String> collect3 = stream.collect(LinkedList::new, LinkedList::add, LinkedList::addAll);

        //toList和toCollection的区别一目了然，第二种不限定于List
//        List<String> collect4 = stream.collect(Collectors.toCollection(ArrayList::new));
//        Set<String> set1 = stream.collect(Collectors.toCollection(TreeSet::new));

        //Collectors的功能十分强大，这里举例拼接字符串
        String s = stream.collect(Collectors.joining());
    }
}
