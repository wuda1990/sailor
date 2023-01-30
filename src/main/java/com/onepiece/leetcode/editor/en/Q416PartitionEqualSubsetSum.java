//Given an integer array nums, return true if you can partition the array into t
//wo subsets such that the sum of the elements in both subsets is equal or false o
//therwise. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 9739 👎 164


package com.onepiece.leetcode.editor.en;

public class Q416PartitionEqualSubsetSum {
    public static void main(String[] args) {
        Solution solution = new Q416PartitionEqualSubsetSum().new Solution();
        solution.canPartition(new int[]{1, 2, 3, 5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
            }
            if (sum % 2 == 1) {
                return false;
            }
            int target = sum / 2;
            int[][] dp = new int[nums.length][target + 1];
            for (int j = nums[0]; j <= target; j++) {
                dp[0][j] = nums[0];
            }
            for (int i = 1; i < nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j < nums[i]) {
                        dp[i][j] = dp[i - 1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                    }
                }
            }
            return target == dp[nums.length - 1][target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}