package com.onepiece.karma;

import java.util.Scanner;

public class Q1Sum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            // cope with every line, split by space
            String[] line = in.nextLine().split(" ");
            System.out.println(sum(line));
        }
    }

    private static int sum(String[] line) {
        int sum = 0;
        for (String s : line) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
