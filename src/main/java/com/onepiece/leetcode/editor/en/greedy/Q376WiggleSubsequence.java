//A wiggle sequence is a sequence where the differences between successive 
//numbers strictly alternate between positive and negative. The first difference (if 
//one exists) may be either positive or negative. A sequence with one element and a 
//sequence with two non-equal elements are trivially wiggle sequences. 
//
// 
// For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences 
//(6, -3, 5, -7, 3) alternate between positive and negative. 
// In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences. 
//The first is not because its first two differences are positive, and the second 
//is not because its last difference is zero. 
// 
//
// A subsequence is obtained by deleting some elements (possibly zero) from the 
//original sequence, leaving the remaining elements in their original order. 
//
// Given an integer array nums, return the length of the longest wiggle 
//subsequence of nums. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,7,4,9,2,5]
//Output: 6
//Explanation: The entire sequence is a wiggle sequence with differences (6, -3,
// 5, -7, 3).
// 
//
// Example 2: 
//
// 
//Input: nums = [1,17,5,10,13,15,10,5,16,8]
//Output: 7
//Explanation: There are several subsequences that achieve this length.
//One is [1, 17, 10, 13, 10, 16, 8] with differences (16, -7, 3, -3, 6, -8).
// 
//
// Example 3: 
//
// 
//Input: nums = [1,2,3,4,5,6,7,8,9]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// 
//
// 
// Follow up: Could you solve this in O(n) time? 
//
// Related Topics Array Dynamic Programming Greedy 👍 4615 👎 150


package com.onepiece.leetcode.editor.en.greedy;

public class Q376WiggleSubsequence {

    public static void main(String[] args) {
        Solution solution = new Q376WiggleSubsequence().new Solution();
//        solution.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5});
        solution.wiggleMaxLength(new int[]{0, 0});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int wiggleMaxLength(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }
            int sumit = 1;
            int preDiff = 0;
            int curDiff = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                curDiff = nums[i + 1] - nums[i];
                if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff < 0)) {
                    sumit++;
                    preDiff = curDiff;
                }
            }

            return sumit;
        }

        // DP
        public int wiggleMaxLengthWithDP(int[] nums) {
            // 0 i 作为波峰的最大长度
            // 1 i 作为波谷的最大长度
            int dp[][] = new int[nums.length][2];

            dp[0][0] = dp[0][1] = 1;
            for (int i = 1; i < nums.length; i++) {
                //i 自己可以成为波峰或者波谷
                dp[i][0] = dp[i][1] = 1;

                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        // i 是波谷
                        dp[i][1] = Math.max(dp[i][1], dp[j][0] + 1);
                    }
                    if (nums[j] < nums[i]) {
                        // i 是波峰
                        dp[i][0] = Math.max(dp[i][0], dp[j][1] + 1);
                    }
                }
            }

            return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}