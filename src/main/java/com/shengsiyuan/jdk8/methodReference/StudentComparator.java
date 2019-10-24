package com.shengsiyuan.jdk8.methodReference;

import java.util.Optional;

public class StudentComparator {

    //对第2种方法引用的举例
    public int compareStudentBySocre(Student s1, Student s2) {
//        return s1.getScore() - s2.getScore();
        //防止空学生和空成绩
        return Optional.ofNullable(s1).map(s -> s.getScore()).orElse(0) - Optional.ofNullable(s2).map(s -> s.getScore()).orElse(0);
    }
    public int compareStudentByName(Student s1, Student s2) {
//        return s1.getName().compareToIgnoreCase(s2.getName());
        //防止空学生和空名字
        return Optional.ofNullable(s1).map(s -> s.getName()).orElse("").compareToIgnoreCase(Optional.ofNullable(s2).map(s -> s.getName()).orElse(""));
    }
}
