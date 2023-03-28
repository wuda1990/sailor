//Given an array of distinct integers nums and a target integer target, return t
//he number of possible combinations that add up to target. 
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
//it change the problem? What limitation we need to add to the question to allow n
//egative numbers? 
// Related Topics Array Dynamic Programming 
// 👍 5456 👎 560


package com.onepiece.leetcode.editor.en.dp;

public class Q377CombinationSumIv {

    public static void main(String[] args) {
        Solution solution = new Q377CombinationSumIv().new Solution();
        solution.combinationSum4(new int[]{1, 2, 3}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int combinationSum4(int[] nums, int target) {
            int[] dp = new int[target + 1];
            dp[0] = 1;
            for (int j = 0; j <= target; j++) {
                for (int i = 0; i < nums.length; i++) {
                    if (j >= nums[i]) {
                        dp[j] = dp[j] + dp[j - nums[i]];
                    }
                    System.out.print(dp[j] + ",");
                }
                System.out.println();
            }
            return dp[target];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}