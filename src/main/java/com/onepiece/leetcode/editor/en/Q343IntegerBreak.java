//Given an integer n, break it into the sum of k positive integers, where k >= 2
//, and maximize the product of those integers. 
//
// Return the maximum product you can get. 
//
// 
// Example 1: 
//
// 
//Input: n = 2
//Output: 1
//Explanation: 2 = 1 + 1, 1 × 1 = 1.
// 
//
// Example 2: 
//
// 
//Input: n = 10
//Output: 36
//Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
// 
//
// 
// Constraints: 
//
// 
// 2 <= n <= 58 
// 
// Related Topics Math Dynamic Programming 
// 👍 3454 👎 357


package com.onepiece.leetcode.editor.en;

public class Q343IntegerBreak {
    //2023-01-29 22:17:39
    //Integer Break
    //编号：[343]
    public static void main(String[] args) {
        Solution solution = new Q343IntegerBreak().new Solution();
//        solution.integerBreak(2);
        System.out.println(solution.integerBreak(10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int integerBreak(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 0;
            for (int i = 2; i <= n; i++) {
                for (int j = i; j > 0; j--) {
                    dp[i] = Math.max(dp[i], j * Math.max(i - j, dp[i - j]));
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
