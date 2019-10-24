package com.shengsiyuan.jdk8.methodReference;

import java.util.Optional;

public class Student {

    private String name;

    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    //对第一种方法引用的举例
    public static int compareStudentBySocre(Student s1, Student s2) {
//        return s1.getScore() - s2.getScore();
        //防止空学生和空成绩
        return Optional.ofNullable(s1).map(s -> s.getScore()).orElse(0) - Optional.ofNullable(s2).map(s -> s.getScore()).orElse(0);
    }
    public static int compareStudentByName(Student s1, Student s2) {
//        return s1.getName().compareToIgnoreCase(s2.getName());
        //防止空学生和空名字
        return Optional.ofNullable(s1).map(s -> s.getName()).orElse("").compareToIgnoreCase(Optional.ofNullable(s2).map(s -> s.getName()).orElse(""));
    }

    public int compareByScore(Student s) {
        return this.getScore() - s.getScore();
    }

    public int compareByName(Student s) {
        return this.getName().compareToIgnoreCase(s.getName());
    }
}
