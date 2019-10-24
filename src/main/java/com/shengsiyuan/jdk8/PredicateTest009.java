package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//流操作会得到大量的应用
public class PredicateTest009 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //一般用这个，因为需要的是过滤了的list
        List<Integer> odd = list.stream().filter(value -> value % 2 == 1).collect(Collectors.toList());
        odd.forEach(i -> System.out.println(i));

        PredicateTest009 test = new PredicateTest009();
        test.find(list, value -> value % 2 == 1);
        test.find(list, value -> value % 2 == 0);
        test.find(list, value -> value > 5);
        test.find(list, value -> value < 3);
        test.find(list, value -> true); //打印集合中所有元素

        System.out.println("--------------");
        test.and(list, value -> value % 2 == 0, value -> value > 5);
        System.out.println("--------------");
        test.or(list, value -> value % 2 == 0, value -> value > 5);
        System.out.println("--------------");
        test.and_negate(list, value -> value % 2 == 0, value -> value > 5);

        System.out.println(test.isEqual("test").test("test2"));
        //讲道理应该是false才对阿
//        System.out.println(test.isEqual2(new Date()).test(new Date()));
    }

    private void find(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(integer -> {
            if (predicate.test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private void and(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate1.and(predicate2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private void or(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate1.or(predicate2).test(integer)) {
                System.out.println(integer);
            }
        });
    }

    //差集
    //static <T> Predicate<T> isEqual(Object targetRef) {}
    //的意思是返回一个带有lamda表达式的且表达式的返回值是函数式接口的宝宝的返回值类型的函数式接口，在这里是boolean。
    //我想了半天，怎么返回一个函数式接口，原来它的意思是返回它的宝宝
    private void and_negate(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2) {
        list.forEach(integer -> {
            if (predicate1.and(predicate2).negate().test(integer)) {
                System.out.println(integer);
            }
        });
    }

    private Predicate<String> isEqual(Object o) {
        return Predicate.isEqual(o);
    }

    private Predicate<Date> isEqual2(Object o) {
        return Predicate.isEqual(o);
    }
}
