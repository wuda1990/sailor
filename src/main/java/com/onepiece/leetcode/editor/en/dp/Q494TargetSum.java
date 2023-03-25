//You are given an integer array nums and an integer target. 
//
// You want to build an expression out of nums by adding one of the symbols '+' 
//and '-' before each integer in nums and then concatenate all the integers. 
//
// 
// For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 
//and concatenate them to build the expression "+2-1". 
// 
//
// Return the number of different expressions that you can build, which evaluate
//s to target. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,1,1,1], target = 3
//Output: 5
//Explanation: There are 5 ways to assign symbols to make the sum of nums be tar
//get 3.
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// Example 2: 
//
// 
//Input: nums = [1], target = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics Array Dynamic Programming Backtracking 
// 👍 8733 👎 311


package com.onepiece.leetcode.editor.en.dp;

public class Q494TargetSum {
    public static void main(String[] args) {
        Solution solution = new Q494TargetSum().new Solution();
//        solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        solution.findTargetSumWays(new int[]{100}, -200);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * x 是取正数的和,有
     * x - (sum-x) = target
     * x == (sum+target)/2
     * 转化成0，1背包问题,在n个物品里,是否选择+1，凑满容量为x的组合个数
     */
    class Solution {
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            //排除无解情况
            if (Math.abs(target) > sum || (sum + target) % 2 == 1) {
                return 0;
            }
            int x = Math.abs((sum + target) / 2);
            //dp[i][j]表示从(0,i)个物品里，能够凑满容量为j里有多少种组合个数
            int[][] dp = new int[nums.length][x + 1];
            dp[0][0] = 1;
            for (int j = x; j >= nums[0]; j--) {
                dp[0][j] += dp[0][j - nums[0]];
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 0; j <= x; j++) {
                    if (j >= nums[i]) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
            return dp[nums.length - 1][x];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}