//Given two strings s and t, return the number of distinct subsequences of s whi
//ch equals t. 
//
// The test cases are generated so that the answer fits on a 32-bit signed integ
//er. 
//
// 
// Example 1: 
//
// 
//Input: s = "rabbbit", t = "rabbit"
//Output: 3
//Explanation:
//As shown below, there are 3 ways you can generate "rabbit" from s.
//rabbbit
//rabbbit
//rabbbit
// 
//
// Example 2: 
//
// 
//Input: s = "babgbag", t = "bag"
//Output: 5
//Explanation:
//As shown below, there are 5 ways you can generate "bag" from s.
//babgbag
//babgbag
//babgbag
//babgbag
//babgbag 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 1000 
// s and t consist of English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 4944 👎 193


package com.onepiece.leetcode.editor.en;

public class Q115DistinctSubsequences {
    //2023-02-05 11:37:55
    //Distinct Subsequences
    //编号：[115]
    public static void main(String[] args) {
        Solution solution = new Q115DistinctSubsequences().new Solution();
        solution.numDistinct("babgbag", "bag");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numDistinct(String s, String t) {
            int[][] dp = new int[t.length() + 1][s.length() + 1];
            for (int j = 0; j <= s.length(); j++) {
                dp[0][j] = 1;
            }
            for (int i = 1; i <= t.length(); i++) {
                for (int j = 1; j <= s.length(); j++) {
                    if (t.charAt(i - 1) == s.charAt(j - 1)) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    }else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
            return dp[t.length()][s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
