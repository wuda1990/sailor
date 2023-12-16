package com.onepiece.niuke;

import java.util.Scanner;

public class HexParser {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String input = in.nextLine();
            parse(input);
        }

    }

    private static void parse(String input) {
        int result = 0;
        int position = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c >= '1' && c <= '9') {
                result += position * (c - '1' + 1);
            }
            if (c >= 'A' && c <= 'F') {
                result += position * (c - 'A' + 10);
            }
            if (c >= 'a' && c <= 'f') {
                result += position * (c - 'a' + 10);
            }
            position = position * 16;
        }
        System.out.println(result);
    }


}