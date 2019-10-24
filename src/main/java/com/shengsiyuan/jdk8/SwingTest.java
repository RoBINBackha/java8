package com.shengsiyuan.jdk8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingTest {

    public static void main(String[] args) {
        System.out.println("12321");
        JFrame jFrame = new JFrame("Cjh JFrame");
        JButton jButton = new JButton("Cjh Button");

//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("pressed");
//            }
//        });   //1.8之前要写匿名内部类

//        jButton.addActionListener((ActionEvent e) -> System.out.println("pressed"));//通过java的一种叫“类型推断”机制的可以去掉ActionEvent
        jButton.addActionListener(e -> System.out.println("pressed"));
//        Lambda表达式的基本结构：(param1, param2, param3) -> {
//
//        }
        jFrame.add(jButton);
        jFrame.pack();
        jFrame.setVisible(true);
        //按住ctrl+shift+空格  弹出提示枚举
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
