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


package com.onepiece.leetcode.editor.en.string;

public class Q28FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String[] args) {
        Solution solution = new Q28FindTheIndexOfTheFirstOccurrenceInAString().new Solution();
//        System.out.println(solution.strStr("aaa", "aaa"));
        System.out.println(solution.strStr("aabaabaafa", "aabaaf"));
//        System.out.println(solution.strStr("leetcode", "leeto"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int strStr(String haystack, String needle) {
            return strStrKMP(haystack, needle);
        }

        public int strStrBruce(String haystack, String needle) {
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

        public int strStrKMP(String haystack, String needle) {
            int[] next = getNext(needle);
            int j = 0;
            for (int i = 0; i < haystack.length(); i++) {
                while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                    j = next[j - 1];
                }
                if (haystack.charAt(i) == needle.charAt(j)) {
                    j++;
                }
                if (j == needle.length()) {
                    return i - needle.length() + 1;
                }
            }
            return -1;
        }

        /**
         * 求模式字符串的next数组
         * @param s
         * @return
         */
        private int[] getNext(String s) {
            int[] next = new int[s.length()];
            int j = 0;
            for (int i = 1; i < s.length(); i++) {
                while (j > 0 && s.charAt(i) != s.charAt(j)) {
                    j = next[j - 1];
                }
                if (s.charAt(i) == s.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}