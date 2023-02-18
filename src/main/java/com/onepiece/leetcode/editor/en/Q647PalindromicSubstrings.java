//Given a string s, return the number of palindromic substrings in it. 
//
// A string is a palindrome when it reads the same backward as forward. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "abc"
//Output: 3
//Explanation: Three palindromic strings: "a", "b", "c".
// 
//
// Example 2: 
//
// 
//Input: s = "aaa"
//Output: 6
//Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consists of lowercase English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 8592 👎 188


package com.onepiece.leetcode.editor.en;

public class Q647PalindromicSubstrings {
    //2023-02-05 14:02:47
    //Palindromic Substrings
    //编号：[647]
    public static void main(String[] args) {
        Solution solution = new Q647PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 求字符串s的回文子串个数
         * @param s
         * @return
         */
        public int countSubstrings(String s) {
            int result = 0;
            int len = s.length();
            boolean[][] dp = new boolean[len][len];
            for (int i = len - 1; i >= 0; i--) {
                for (int j = i; j < len; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i <= 1 || dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                            result++;
                        }
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
