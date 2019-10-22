package com.shengsiyuan.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringCComparator {

    public static void main(String[] args) {

        List<String> name = Arrays.asList("zhangsan","lisi","wangwu", "zhaoliu");

        Collections.sort(name, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(name, (o1, o2) ->  o2.compareTo(o1));
        //这个是最终的
        Collections.sort(name, Comparator.reverseOrder());
    }
}
