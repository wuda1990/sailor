//Given an integer n, return the number of structurally unique BST's (binary sea
//rch trees) which has exactly n nodes of unique values from 1 to n. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: 5
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 19 
// 
// Related Topics Math Dynamic Programming Tree Binary Search Tree Binary Tree 
// 👍 8698 👎 349


package com.onepiece.leetcode.editor.en;

public class Q96UniqueBinarySearchTrees {

    public static void main(String[] args) {
        Solution solution = new Q96UniqueBinarySearchTrees().new Solution();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numTrees(int n) {
            if (n <= 2) {
                return n;
            }
            int[] dp = new int[n + 1];
            dp[0] = 1; //base case
            //透过二叉树表面，找到状态转移方程,dp[i]表示i个节点下二叉搜索树的个数
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < i; j++) { // j表示左子树的节点数
                    dp[i] += dp[j] * dp[i - j - 1];
                }
            }
            return dp[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}