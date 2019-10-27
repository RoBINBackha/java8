package com.shengsiyuan.jdk8.stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

//静态导入Collectors，免得啰嗦
public class StreamTest01 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 90);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        List<Student> students1 = students.stream().collect(toList());

        Long aLong = students.stream().collect(counting());
        Long aLong2 = students.stream().count(); //结果一样的。因为jdk8给了很多方式，那什么方式最好？
        //jdk8提供了很一般也很具体的方式，我们建议使用具体的方式
    }
}
