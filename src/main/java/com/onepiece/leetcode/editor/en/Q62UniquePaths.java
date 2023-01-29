//There is a robot on an m x n grid. The robot is initially located at the top-l
//eft corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corne
//r (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at an
//y point in time. 
//
// Given the two integers m and n, return the number of possible unique paths th
//at the robot can take to reach the bottom-right corner. 
//
// The test cases are generated so that the answer will be less than or equal to
// 2 * 109. 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation: From the top-left corner, there are a total of 3 ways to reach th
//e bottom-right corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// 
// Related Topics Math Dynamic Programming Combinatorics 
// 👍 12850 👎 370


package com.onepiece.leetcode.editor.en;

public class Q62UniquePaths {
    public static void main(String[] args) {
        Solution solution = new Q62UniquePaths().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
            return dp[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}