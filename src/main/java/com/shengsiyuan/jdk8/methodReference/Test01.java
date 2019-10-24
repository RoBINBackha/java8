package com.shengsiyuan.jdk8.methodReference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test01 {

    public static void main(String[] args) {

        Test01 test01 = new Test01();

        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 60);
        Student student4 = new Student("zhaoliu", 30);

        List<Student> list = Arrays.asList(student1, student2, student3, student4);

        //1.8集合本身就增加了排序
        //第①种方法引用类型
//        list.sort((s1, s2) -> Student.compareStudentByName(s1, s2));
        list.sort(Student::compareStudentBySocre);//为什么不需要s1,s2呢


        StudentComparator studentComparator = new StudentComparator();

        //第②种方法引用类型
//        list.sort((s1, s2) -> studentComparator.compareStudentByName(s1, s2));
        list.sort(studentComparator::compareStudentBySocre);

        //第③种方法引用类型
        list.sort(Student::compareByName);
        //Comparator的lamda表达式本身接收2个参数，为什么这里能成功
        //这里与前两种不同的地方在于，前两者冒号的第一部分都是调用者
        //而这里类是不能调用实例方法的
        //联系(x, y) -> x.compareByName(y)，这里其实第一个参数是待排序的2个student对象的第一个，而第二个对象则
        //作为compareByName的参数
        //除了第一个参数，后续的所有参数都是作为compareByName方法的参数

        List<String> citys = Arrays.asList("qingdao", "chongqin", "beijing", "wuhan");
//        Collections.sort(citys, (c1, c2) -> c1.compareToIgnoreCase(c2));
//        Collections.sort(citys, String::compareToIgnoreCase);
        //从上面两个能得出，只要c1，c2满足属于同一个类就能用方法引用

        //第④种方法引用类型
        System.out.println(test01.getString(() -> ""));
        System.out.println(test01.getString(String::new));

        System.out.println(test01.getString2("hello", String::new));
    }

    public String getString(Supplier<String> supplier) {
        return supplier.get() + "test";
    }

    public String getString2(String s, Function<String, String> function) {
        return function.apply(s);
    }
}
