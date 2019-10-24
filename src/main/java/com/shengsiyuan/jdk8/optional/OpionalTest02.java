package com.shengsiyuan.jdk8.optional;

import javax.swing.text.Style;
import java.util.*;

//处理让不返回Null而是空List
public class OpionalTest02 {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("zhangsan");
        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> list = Arrays.asList(employee, employee2);
        company.setEmployees(list);

        //开始处理
        getList(company);

    }

    //assrt适用于卡null件时，阻止继续的情形。（assert不仅仅可卡null）
    //optional适用于卡null件时，流程继续（只能卡null）
    //从不为空的company里拿员工list（就算没员工也是空list而不是Null）
    private static List<Employee> getList(Company c) {
        List<Employee> list = c.getEmployees();  //无法保证c不为空
        //根据业务，以前需要用如下方式处理
//        if(list != null) {
//            return list;
//        } else {
//            return new ArrayList<>();
//        }
        //02 这里只能确保list做了对应操作，确保不了company不为空
        return Optional.ofNullable(list).orElse(new ArrayList<>());
    }

    //从不管为不为空的company里拿员工List
    //Optional容器先是放入的公司，之后又用员工List代替放入
    //map方法可见：如果一个对象里面不停的嵌套对象，是可以一直迭代放入的。直到放入null后，再map的调用就都是重新放入null
    private static List<Employee> getList2(Company c) {
        return Optional.ofNullable(c).map(company -> company.getEmployees()).orElse(Collections.emptyList());
        //源码如下
//        if (!isPresent())
//            return empty();   //之前以为在此位置，可推断  如果公司是空，就返回一个空List<Employee>了
        //其实不然，返回的只是带null的Optional
//        else {
                //否则就将动态方法调入（“从公司获取员工list”)，将员工list放入Optional中
//            return Optional.ofNullable(mapper.apply(value));
//        }
    }
}
