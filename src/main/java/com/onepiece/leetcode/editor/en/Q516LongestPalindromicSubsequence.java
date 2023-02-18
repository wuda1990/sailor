//Given a string s, find the longest palindromic subsequence's length in s. 
//
// A subsequence is a sequence that can be derived from another sequence by dele
//ting some or no elements without changing the order of the remaining elements. 
//
// 
// Example 1: 
//
// 
//Input: s = "bbbab"
//Output: 4
//Explanation: One possible longest palindromic subsequence is "bbbb".
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: 2
//Explanation: One possible longest palindromic subsequence is "bb".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists only of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 6836 👎 273


package com.onepiece.leetcode.editor.en;

public class Q516LongestPalindromicSubsequence {
    //2023-02-05 14:23:15
    //Longest Palindromic Subsequence
    //编号：[516]
    public static void main(String[] args) {
        Solution solution = new Q516LongestPalindromicSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindromeSubseq(String s) {
            int len = s.length();
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = 1;
            }
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i + 1; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    }else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][len - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
