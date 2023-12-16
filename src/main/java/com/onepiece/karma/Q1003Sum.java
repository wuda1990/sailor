package com.onepiece.karma;

import java.util.Scanner;

public class Q1003Sum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // cope with every line, split by space
            int length = in.nextInt();
            if (length == 0) {
                continue;
            }
            int result = 0;
            //sum the numbers in the line
            for (int i = 0; i < length; i++) {
                result += in.nextInt();
            }
            System.out.println(result);
        }
    }

}
