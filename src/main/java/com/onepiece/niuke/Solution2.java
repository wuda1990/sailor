package com.onepiece.niuke;

public class Solution2 {

    // check if the rest of the array is ascending strictly if we remove one element
    public boolean isBeIncreasing(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            final int num1 = nums[i];
            final int num2 = nums[i + 1];
            if (num1 >= num2) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (i > 0 && num2 <= nums[i - 1]) {
                    nums[i + 1] = num1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] nums = {3, 4, 2, 3};
        boolean ans = solution2.isBeIncreasing(nums);
        System.out.println(ans);
        nums = new int[]{1, 2, 10, 5};
        System.out.println(solution2.isBeIncreasing(nums));
    }

}
