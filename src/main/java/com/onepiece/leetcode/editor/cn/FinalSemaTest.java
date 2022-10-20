package com.onepiece.leetcode.editor.cn;

public class FinalSemaTest {

    public static void main(String[] args) {
        final MyClass myClass = new MyClass();
        System.out.println(++myClass.i);
    }

}

class MyClass{
    public int i = 0;
}