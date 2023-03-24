//Given an integer array nums, find the subarray with the largest sum, and retur
//n its sum. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//[1,-3,4]
//Output: 6
//Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
//Explanation: The subarray [1] has the largest sum 1.
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
//Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another solu
//tion using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 
// 👍 27707 👎 1229


package com.onepiece.leetcode.editor.en.greedy;

public class Q53MaximumSubarray {

    public static void main(String[] args) {
        Solution solution = new Q53MaximumSubarray().new Solution();
//        solution.maxSubArray(new int[]{-2, -3});
        solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxSubArray(int[] nums) {
            return maxSubArrayDP(nums);
        }

        public int maxSubArrayGreedy(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum < 0) {
                    sum = 0;
                }
                sum = sum + nums[i];
                max = Math.max(max, sum);
            }
            return max;
        }

        public int maxSubArrayDP(int[] nums) {
            //dp[i]表示包括i子数组的最大和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            }
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length; i++) {
                result = Math.max(result, dp[i]);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}