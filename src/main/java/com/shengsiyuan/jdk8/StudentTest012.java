package com.shengsiyuan.jdk8;

import java.util.function.Supplier;

public class StudentTest012 {

    public static void main(String[] args) {

        //其实我个人觉得阿，这玩意儿没什么用。原来大不了是Student011 student011 = new Student011();
        //有什么更好用么
        Supplier<Student011> supplier = () -> new Student011();
        System.out.println(supplier.get().getName());

        Supplier<Student011> supplier2 = Student011::new;
        System.out.println(supplier2.get().getName());
    }
}
