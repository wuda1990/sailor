//Given two strings s and t, return true if s is a subsequence of t, or false ot
//herwise. 
//
// A subsequence of a string is a new string that is formed from the original st
//ring by deleting some (can be none) of the characters without disturbing the rel
//ative positions of the remaining characters. (i.e., "ace" is a subsequence of "a
//bcde" while "aec" is not). 
//
// 
// Example 1: 
// Input: s = "abc", t = "ahbgdc"
//Output: true
// Example 2: 
// Input: s = "axc", t = "ahbgdc"
//Output: false
// 
// 
// Constraints: 
//
// 
// 0 <= s.length <= 100 
// 0 <= t.length <= 104 
// s and t consist only of lowercase English letters. 
// 
//
// 
//Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >
//= 109, and you want to check one by one to see if t has its subsequence. In this
// scenario, how would you change your code? Related Topics Two Pointers String Dy
//namic Programming 
// 👍 6755 👎 386


package com.onepiece.leetcode.editor.en;

public class Q392IsSubsequence {
    //2023-02-05 08:30:17
    //Is Subsequence
    //编号：[392]
    public static void main(String[] args) {
        Solution solution = new Q392IsSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int result = 0;
            //求s,t最大公共子串长度
            int[][] dp = new int[s.length() + 1][t.length() + 1];
            //dp数组默认都初始化为0，包括dp[0][0],dp[i][0]
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= t.length(); j++) {
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            if (dp[s.length()][t.length()] == s.length()) {
                return true;
            }
            return false;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
