package com.shengsiyuan.jdk8;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();

        System.out.println(test.compute(2, value -> value * 3, value -> value * value)); //12
        System.out.println(test.compute2(2, value -> value * 3, value -> value * value)); //36

        System.out.println(test.compute3(1, 2, (a, b) -> a + b));

        System.out.println(test.compute4(1, 2, (a, b) -> a + b, value -> value * value));
    }

    //我们在需要做计算时，可以自己定义高阶函数，然后传入lamda表达式来调用动态操作
    //apply(a)是指把a丢进到操作里
    public int compute(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.compose(f2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> f1, Function<Integer, Integer> f2) {
        return f1.andThen(f2).apply(a);
    }

    //注意test.compute3(1, 2, (a, b) -> a + b); 里，BiFunction不是让你想办法搞出一个BiFunction来，而是联想到它的宝宝（apply）的参数
    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    //为什么BiFunction没有提供compose方法：因为before是先执行的，before返回的是一个结果，而这只有一个结果，而apply需要2个参数
    //同理为什么andThen的参数是Function而不是BiFunction。是因为接收参数的个数
    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> f) {
        return biFunction.andThen(f).apply(a, b);
    }
}
