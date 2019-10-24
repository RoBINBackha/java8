package com.shengsiyuan.jdk8;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorTest013 {

    public static void main(String[] args) {

        BinaryOperatorTest013 test = new BinaryOperatorTest013();
        System.out.println(test.find(1, 2, (a, b) -> a + b));

        System.out.println(test.getShort("aaaaa", "bbbb", (a, b) -> a.length() - b.length()));
        System.out.println(test.getShort("aaaaa", "bbbb", (a, b) -> a.charAt(0) - b.charAt(0)));
    }

    private int find(int a, int b, BinaryOperator<Integer> binaryOperator) {
        return binaryOperator.apply(a, b);
    }

    //这里容易写错成Comparable接口
    //Comparator与Comparable的区别：
    private String getShort(String a, String b, Comparator<String> comparator) {
        return BinaryOperator.minBy(comparator).apply(a, b);
    }
}
