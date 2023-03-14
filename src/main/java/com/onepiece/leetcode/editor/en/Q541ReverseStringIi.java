//Given a string s and an integer k, reverse the first k characters for every 2
//k characters counting from the start of the string. 
//
// If there are fewer than k characters left, reverse all of them. If there are 
//less than 2k but greater than or equal to k characters, then reverse the first 
//k characters and leave the other as original. 
//
// 
// Example 1: 
// Input: s = "abcdefg", k = 2
//Output: "bacdfeg"
// 
// Example 2: 
// Input: s = "abcd", k = 2
//Output: "bacd"
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s consists of only lowercase English letters. 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics Two Pointers String 👍 1528 👎 3080


package com.onepiece.leetcode.editor.en;

public class Q541ReverseStringIi {

    public static void main(String[] args) {
        Solution solution = new Q541ReverseStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //0,k,2k,3k,4k
        public String reverseStr(String s, int k) {
            int len = s.length();
            char[] arr = s.toCharArray();
            int begin = 0;
            int end = Math.min(k, len);
            while (begin < len) {
                reverse(arr, begin, end);
                begin = begin + 2 * k;
                end = Math.min(begin + k, len);
            }
            return new String(arr);
        }

        private void reverse(char[] arr, int begin, int end) {
            int left = begin;
            int right = end - 1;
            while (left < right) {
                swap(arr, left++, right--);
            }
        }

        private void swap(char[] s, int i, int j) {
            s[i] = (char) (s[i] ^ s[j]);
            s[j] = (char) (s[i] ^ s[j]);
            s[i] = (char) (s[i] ^ s[j]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}