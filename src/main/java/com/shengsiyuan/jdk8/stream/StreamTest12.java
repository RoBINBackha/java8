package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "hello", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        //输出Hi zhangsan
        //Hi lisi
        //Hi wangwu
        //Hi zhaoliu
        //hello zhangsan
        //hello lisi
        //hello wangwu
        //hello zhaoliu
        //你好 zhangsan
        //你好 lisi
        //你好 wangwu
        //你好 zhaoliu
        //的序列
        list1.stream().forEach(hi -> list2.stream().forEach(name -> System.out.println(hi + " "+name)));  //cjh的

        //老师的这种可以用来搜集，我的只能输出
        List<String> collect = list1.stream().flatMap(hi -> list2.stream().map(name -> hi + " " + name)).collect(Collectors.toList());

    }
}
