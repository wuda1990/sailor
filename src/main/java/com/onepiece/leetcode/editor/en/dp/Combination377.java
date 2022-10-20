package com.onepiece.leetcode.editor.en.dp;//Given an array of distinct integers nums and a target integer target, return
//the number of possible combinations that add up to target. 
//
// The test cases are generated so that the answer can fit in a 32-bit integer. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3], target = 4
//Output: 7
//Explanation:
//The possible combination ways are:
//(1, 1, 1, 1)
//(1, 1, 2)
//(1, 2, 1)
//(1, 3)
//(2, 1, 1)
//(2, 2)
//(3, 1)
//Note that different sequences are counted as different combinations.
// 
//
// Example 2: 
//
// 
//Input: nums = [9], target = 3
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 200 
// 1 <= nums[i] <= 1000 
// All the elements of nums are unique. 
// 1 <= target <= 1000 
// 
//
// 
// Follow up: What if negative numbers are allowed in the given array? How does 
//it change the problem? What limitation we need to add to the question to allow 
//negative numbers? 
//
// Related Topics Array Dynamic Programming 👍 5173 👎 535


public class Combination377 {
    public static void main(String[] args) {
        Solution solution = new Combination377().new Solution();
        System.out.println(solution.combinationSum4(new int[]{1, 2, 3}, 4));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * calculate the combination count using dp
         * Note that different sequences are counted as different combinations.
         * so iterate 1->target,then iterate array nums.
         * it is similar to coinChange
         * @param nums
         * @param target
         * @return
         */
        public int combinationSum4(int[] nums, int target) {
            //Todo can sort the nums, then break the loop
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int i = 1; i <= target; i++) {
                for (int n : nums) {
                    if (n > i) {
                        continue;
                    }
                    dp[i] = dp[i] + dp[i - n];
                }
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
