//Given an unsorted array of integers nums, return the length of the longest con
//tinuous increasing subsequence (i.e. subarray). The subsequence must be strictly
// increasing. 
//
// A continuous increasing subsequence is defined by two indices l and r (l < r)
// such that it is [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] and for each 
//l <= i < r, nums[i] < nums[i + 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,5,4,7]
//Output: 3
//Explanation: The longest continuous increasing subsequence is [1,3,5] with len
//gth 3.
//Even though [1,3,5,7] is an increasing subsequence, it is not continuous as el
//ements 5 and 7 are separated by element
//4.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,2,2,2,2]
//Output: 1
//Explanation: The longest continuous increasing subsequence is [2] with length 
//1. Note that it must be strictly
//increasing.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics Array 
// 👍 2011 👎 168


package com.onepiece.leetcode.editor.en;

public class Q674LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        Solution solution = new Q674LongestContinuousIncreasingSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int result = 1;
            int[] dp = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                }
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}