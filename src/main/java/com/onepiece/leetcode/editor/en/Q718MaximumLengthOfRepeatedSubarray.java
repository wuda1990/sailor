//Given two integer arrays nums1 and nums2, return the maximum length of a subar
//ray that appears in both arrays. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
//Explanation: The repeated subarray with maximum length is [3,2,1].
// 
//
// Example 2: 
//
// 
//Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//Output: 5
//Explanation: The repeated subarray with maximum length is [0,0,0,0,0].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 100 
// 
// Related Topics Array Binary Search Dynamic Programming Sliding Window Rolling
// Hash Hash Function 
// 👍 5970 👎 149


package com.onepiece.leetcode.editor.en;

public class Q718MaximumLengthOfRepeatedSubarray {
    //2023-02-05 10:10:18
    //Maximum Length of Repeated Subarray
    //编号：[718]
    public static void main(String[] args) {
        Solution solution = new Q718MaximumLengthOfRepeatedSubarray().new Solution();
        solution.findLength(new int[]{0, 1, 1, 1, 1}, new int[]{1,0,1,0,1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int result = 0;
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            for (int i = 1; i <= nums1.length; i++) {
                for (int j = 1; j <= nums2.length; j++) {
                    if (nums1[i - 1] == nums2[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        result = Math.max(dp[i][j], result);
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
