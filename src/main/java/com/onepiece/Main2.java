package com.onepiece;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        int i=0;
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt() && i<n) { // 注意 while 处理多个 case
            int b = in.nextInt();
            nums[i++] = b;
        }
        sort(nums);
        for (int j = 0; j < n; j++) {
            if (j > 0 && nums[j] == nums[j - 1]) {
                continue;
            }
            System.out.println(nums[j]);
        }
    }

    private static void sort(int[] nums) {
        for (int i = nums.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] nums, int j, int i) {
        nums[j] = nums[j] ^ nums[i];
        nums[i] = nums[j] ^ nums[i];
        nums[j] = nums[j] ^ nums[i];
    }
}