//Given two strings needle and haystack, return the index of the first 
//occurrence of needle in haystack, or -1 if needle is not part of haystack. 
//
// 
// Example 1: 
//
// 
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
// 
//
// Example 2: 
//
// 
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= haystack.length, needle.length <= 10⁴ 
// haystack and needle consist of only lowercase English characters. 
// 
//
// Related Topics Two Pointers String String Matching 👍 2928 👎 141


package com.onepiece.leetcode.editor.en;

public class Q28FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        Solution solution = new Q28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
        System.out.println(solution.strStr("aaa", "aaa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strStr(String haystack, String needle) {
            for (int i = 0; i < (haystack.length() - needle.length() + 1); i++) {
                int k = i;
                int j = 0;
                while (k < haystack.length() && j < needle.length()
                    && haystack.charAt(k) == needle.charAt(j)) {
                    k++;
                    j++;
                }
                if (j == needle.length()) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}