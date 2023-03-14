//Write a function that reverses a string. The input string is given as an 
//array of characters s. 
//
// You must do this by modifying the input array in-place with O(1) extra 
//memory. 
//
// 
// Example 1: 
// Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
// 
// Example 2: 
// Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] is a printable ascii character. 
// 
//
// Related Topics Two Pointers String 👍 7022 👎 1059


package com.onepiece.leetcode.editor.en.string;

public class Q344ReverseString {

    public static void main(String[] args) {
        Solution solution = new Q344ReverseString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;
            while (left < right) {
                swap(s, left++, right--);
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