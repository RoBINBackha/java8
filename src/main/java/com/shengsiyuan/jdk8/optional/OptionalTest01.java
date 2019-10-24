package com.shengsiyuan.jdk8.optional;

import java.util.Optional;

public class OptionalTest01 {

    public static void main(String[] args) {
        Optional<String> hello = Optional.of("hello");

        //01  不推荐
//        if (hello.isPresent()) {
//            System.out.println(hello.get());
//        }
        //02  推荐
        hello.ifPresent(item -> System.out.println(item));

        //cjh平时的代码，感觉比optional在接收参数的处理上更合理（可以自己定义异常输出信息）
        //但如果卡件null，业务逻辑是不报异常的时候，assert就用不了，就用optional代替if(some != null)
        //但实际上很少有这种卡件到不为null时，继续做业务处理，为null也不管的情形。
        //一般只有2种业务情况：   1、卡到null件，直接抛异常，否则继续
        //                      2、集合卡到null件，用空集合取而代之，继续执行
        String a = "hello";
        assert a != null : "对象不能为空";
        System.out.println(a);

        //01  不推荐
//        System.out.println(hello.orElseGet(() -> "world"));
        //02  推荐
        System.out.println(hello.orElse("world"));

        //optional不要做成员变量和方法参数，因为无法序列化
    }
}
