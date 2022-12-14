package com.onepiece.algorithm;

public class ConstantPoolTest {

    public static void main(String[] args) {
        intern();
        intern2();
    }
    public static void intern() {
        String s1 = new String("he") + new String("llo");
        String s2 = s1.intern();
        String s3 = "hello";
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s2);//true
    }

    public static void intern2() {
        String s3 = "hello";
        String s1 = new String("he") + new String("llo");
        String s2 = s1.intern();
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s2);//false
    }

}
