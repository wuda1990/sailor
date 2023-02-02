//You are a professional robber planning to rob houses along a street. Each hous
//e has a certain amount of money stashed. All houses at this place are arranged i
//n a circle. That means the first house is the neighbor of the last one. Meanwhil
//e, adjacent houses have a security system connected, and it will automatically c
//ontact the police if two adjacent houses were broken into on the same night. 
//
// Given an integer array nums representing the amount of money of each house, r
//eturn the maximum amount of money you can rob tonight without alerting the polic
//e. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,2]
//Output: 3
//Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 
//2), because they are adjacent houses.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,1]
//Output: 4
//Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//Total amount you can rob = 1 + 3 = 4.
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3]
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics Array Dynamic Programming 
// 👍 7676 👎 113


package com.onepiece.leetcode.editor.en;

public class Q213HouseRobberIi {
    public static void main(String[] args) {
        Solution solution = new Q213HouseRobberIi().new Solution();
        solution.rob(new int[]{1,2, 3, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return 0;
            } else if (len == 1) {
                return nums[0];
            }
            return Math.max(robAction(nums, 0, len - 2), robAction(nums, 1, len - 1));
        }

        private int robAction(int[] nums, int start, int end) {
            int x = 0, y = 0, z = 0;
            for (int i = start; i <= end; i++) {
                z = Math.max(y, x + nums[i]);
                x = y;
                y = z;
            }
            return z;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}