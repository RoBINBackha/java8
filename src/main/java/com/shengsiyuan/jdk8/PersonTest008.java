package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PersonTest008 {

    public static void main(String[] args) {

        Person007 person1 = new Person007("zhangsan", 20);
        Person007 person2 = new Person007("lis", 30);
        Person007 person3 = new Person007("wangwu", 40);

        List<Person007> persons = Arrays.asList(person1, person2, person3);

        PersonTest008 test = new PersonTest008();
        List<Person007> listByName = test.getPersonByUserName("zhangsan", persons);
        listByName.forEach(person007 -> System.out.println(person007.getUserName()));

        List<Person007> listByAge = test.getPersonByAge(20, persons);
        listByAge.forEach(person007 -> System.out.println(person007.getAge()));

        List<Person007> listByAge2 = test.getPersonByAge2(20, persons, (ag, pList) -> pList.stream().filter(person -> person.getAge() > ag).collect(Collectors.toList()));
        listByAge2.forEach(person007 -> System.out.println(person007.getAge()));
    }

    //通过某一属性的对比，对集合元素做过滤
    //通常与之对应的是从数据库中where条件进行查询，当集合不能通过数据库方式时，可使用此方式
    //Predicate函数式接口返回boolean值
    //Function函数式接口返回R值
    //Consumer函数式接口不返回值
    public List<Person007> getPersonByUserName(String userName, List<Person007> persons) {
        Objects.requireNonNull(userName);
        //filter是对传入参数做是否符合规则的boolean判断
        //因为persons转换成流了，所有流里的每个对象都是Person007类型的
        //collect(Collectors.toList())是一个很重要的方法，且源码复杂
        return persons.stream().filter(person -> userName.equalsIgnoreCase(person.getUserName())).collect(Collectors.toList());
    }

    //可以使用另一种方式：通过定义BiFunction，来调用它的方法
    //我傻了，定义完BiFunction后，不知道怎么调用了。其实BiFunction现在就把它看成对象，调用它的方法就行了
    public List<Person007> getPersonByAge(Integer age, List<Person007> persons) {
        Objects.requireNonNull(age);
        BiFunction<Integer, List<Person007>, List<Person007>> biFunction = (ag, pList) -> pList.stream().filter(person -> person.getAge() > ag).collect(Collectors.toList());
        return biFunction.apply(age, persons);
    }

    //另一种方式（更好）,（不见得更好，如果调用得很多，每次调用都要写也是很麻烦的，util类最好是两种都提供）
    public List<Person007> getPersonByAge2(Integer age, List<Person007> persons, BiFunction<Integer, List<Person007>, List<Person007>> biFunction) {
        Objects.requireNonNull(age);
        return biFunction.apply(age, persons);
    }
}
