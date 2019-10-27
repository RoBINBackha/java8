package com.shengsiyuan.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest13 {

    public static void main(String[] args) {

        //重名学生
        Student zhangsan = new Student("zhangsan", 100, 20);
        Student lisi = new Student("lisi", 90, 20);
        Student wangwu = new Student("wangwu", 90, 30);
        Student zhangsan2 = new Student("zhangsan", 80, 40);


        List<Student> students = Arrays.asList(zhangsan, lisi, wangwu, zhangsan2);

        //根据name分组，张三分组里面有2个对象，jdk8好强阿
        Map<String, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        Map<String, Long> map1 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.counting()));

        //求每个分组的平均值,太强了吧。。。。
        Map<String, Double> map2 = students.stream().collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));

        /**
         * 分区概念
         */
        //分区是分为true，false两组
        Map<Boolean, List<Student>> map3 = students.stream().collect(Collectors.partitioningBy(stu -> stu.getScore() >= 90));
    }
}
