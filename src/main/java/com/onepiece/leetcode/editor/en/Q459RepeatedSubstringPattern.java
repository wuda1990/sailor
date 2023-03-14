//Given a string s, check if it can be constructed by taking a substring of it 
//and appending multiple copies of the substring together. 
//
// 
// Example 1: 
//
// 
//Input: s = "abab"
//Output: true
//Explanation: It is the substring "ab" twice.
// abababab
//
// Example 2: 
//
// 
//Input: s = "aba"
//Output: false
// 
//
// Example 3: 
//
// 
//Input: s = "abcabcabcabc"
//Output: true
//Explanation: It is the substring "abc" four times or the substring "abcabc" 
//twice.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of lowercase English letters. 
// 
//
// Related Topics String String Matching 👍 4233 👎 379


package com.onepiece.leetcode.editor.en;

public class Q459RepeatedSubstringPattern {

    public static void main(String[] args) {
        Solution solution = new Q459RepeatedSubstringPattern().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean repeatedSubstringPattern(String s) {
            StringBuilder sb = new StringBuilder();
            sb.append(s).append(s);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString().contains(s);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}