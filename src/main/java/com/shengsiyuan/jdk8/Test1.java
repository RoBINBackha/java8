package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.List;

public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        //01
        for (int i = 0; i < list.size(); i++) {
        }
        //02
        for (Integer i : list) {
        }
        //java8
        list.forEach(integer -> {
        }); //参数是函数式接口：函数式接口的实例可通过lamda表达式形式创建
        //关于函数式接口：函数式接口是一个只有一个非爹方法的抽象方法的娃儿
        //1.如果某个接口上被声明了FunctionalInterface注解，那么编译器就会按照函数式接口的定义来要求该接口
        //2.如果某个接口只有一个抽象方法，但并没有被声明上FunctionalInterface注解，但编译器依旧视之为函数式接口
        //3.对函数式接口的理解直接影响到对lamda表达式的认知
    }
}

/**
 * 函数式接口的定义 与使用
 */
@FunctionalInterface
interface MyInterface02 {

    void itest();

    String toString();  //爹的方法
}

class Test02 {

    public static void main(String[] args) {
        Test02 test = new Test02();
        test.test02(() -> {  //空括号对应的不是娃儿，而是娃儿的法法的参数。
            System.out.println("asd");
        });

        MyInterface02 myInterface02 = () -> {System.out.println("aaa");};  //这种写法是合法的

        System.out.println(myInterface02.getClass());
        System.out.println(myInterface02.getClass().getSuperclass());
        System.out.println(myInterface02.getClass().getInterfaces()[0]);
    }

    private void test02(MyInterface02 m) {
        m.itest();
    }
}