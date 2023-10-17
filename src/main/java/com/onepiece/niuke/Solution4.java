package com.onepiece.niuke;

public class Solution4 {

    //return if array nums can be cut into three parts with equal sum
    public boolean canCutIntoThreeParts(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //if sum can not be divided by 3, return false
        if (sum % 3 != 0) {
            return false;
        }
        int oneSum = sum / 3;
        int twoSum = sum / 3;
        //sum the first part
        for (int i = 0; i < nums.length; i++) {
            oneSum -= nums[i];
            if (oneSum == 0) {
                //sum the second part
                int j = i + 1;
                while (j < nums.length - 1) {
                    twoSum -= nums[j];
                    if (twoSum == 0) {
                        return true;
                    }
                    j++;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int[] nums = {0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
        boolean ans = solution4.canCutIntoThreeParts(nums);
        System.out.println(ans);
    }
}
