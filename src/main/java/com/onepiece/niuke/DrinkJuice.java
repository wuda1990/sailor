package com.onepiece.niuke;

import java.util.Scanner;

public class DrinkJuice {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            if (a == 0) {
                return;
            }
            System.out.println(getDrinks(a));
        }
    }

    private static int getDrinks(int bottles) {
        int[] dp = new int[bottles + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= bottles; i++) {
            dp[i] = i / 3 + dp[i / 3 + i % 3];
        }
        return dp[bottles];
    }
}