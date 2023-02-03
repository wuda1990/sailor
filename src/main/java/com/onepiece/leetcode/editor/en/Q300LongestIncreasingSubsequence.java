//Given an integer array nums, return the length of the longest strictly increas
//ing subsequence. 
//
// 
// Example 1: 
//
// 
//Input: nums = [10,9,2,5,3,7,101,18]
//Output: 4
//Explanation: The longest increasing subsequence is [2,3,7,101], therefore the 
//length is 4.
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,0,3,2,3]
//Output: 4
// 
//
// Example 3: 
//
// 
//Input: nums = [7,7,7,7,7,7,7]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(n log(n)) time co
//mplexity? 
// Related Topics Array Binary Search Dynamic Programming 
// 👍 16326 👎 300


package com.onepiece.leetcode.editor.en;

public class Q300LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q300LongestIncreasingSubsequence().new Solution();
        System.out.println(solution.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int result = 1;
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < nums.length; i++) {
//                System.out.println("i=" + i);
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
//                        System.out.println("i=" + i + ",j=" + j + ",dp[i]=" + dp[i]);
                    }
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}