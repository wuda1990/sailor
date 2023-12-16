package com.onepiece.niuke;

public class PalindromTest {

    //use dp to check if s is palindrom
    public boolean isPalindrom(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        //remove the non-alphanumeric characters and non-numeric characters
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //init dp
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        //dp
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j <= len - 1; j++) {
                final char c1 = s.charAt(i);
                final char c2 = s.charAt(j);
                if (c1 == c2) {
                    if (j - i == 1) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        PalindromTest palindromTest = new PalindromTest();
        String s = "abcbda";
        boolean ans = palindromTest.isPalindrom(s);
        System.out.println(ans);
    }
}
