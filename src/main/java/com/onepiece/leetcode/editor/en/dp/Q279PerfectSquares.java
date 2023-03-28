//Given an integer n, return the least number of perfect square numbers that sum
// to n. 
//
// A perfect square is an integer that is the square of an integer; in other wor
//ds, it is the product of some integer with itself. For example, 1, 4, 9, and 16 
//are perfect squares while 3 and 11 are not. 
//
// 
// Example 1: 
//
// 
//Input: n = 12
//Output: 3
//Explanation: 12 = 4 + 4 + 4.
// 
//
// Example 2: 
//
// 
//Input: n = 13
//Output: 2
//Explanation: 13 = 4 + 9.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 104 
// 
// Related Topics Math Dynamic Programming Breadth-First Search 
// 👍 9008 👎 392


package com.onepiece.leetcode.editor.en.dp;

public class Q279PerfectSquares {
    //2023-02-02 00:37:03
    //Perfect Squares
    //编号：[279]
    public static void main(String[] args) {
        Solution solution = new Q279PerfectSquares().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSquares(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = Integer.MAX_VALUE;
            }
            for (int i = 1; i * i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j >= i * i) {
                        dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                    }
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
