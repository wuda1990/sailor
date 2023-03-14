//Given an input string s, reverse the order of the words. 
//
// A word is defined as a sequence of non-space characters. The words in s will 
//be separated by at least one space. 
//
// Return a string of the words in reverse order concatenated by a single space.
// 
//
// Note that s may contain leading or trailing spaces or multiple spaces 
//between two words. The returned string should only have a single space separating the 
//words. Do not include any extra spaces. 
//
// 
// Example 1: 
//
// 
//Input: s = "the sky is blue"
//Output: "blue is sky the"
// 
//
// Example 2: 
//
// 
//Input: s = "  hello world  "
//Output: "world hello"
//Explanation: Your reversed string should not contain leading or trailing 
//spaces.
// 
//
// Example 3: 
//
// 
//Input: s = "a good   example"
//Output: "example good a"
//Explanation: You need to reduce multiple spaces between two words to a single 
//space in the reversed string.
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 10⁴ 
// s contains English letters (upper-case and lower-case), digits, and spaces ' 
//'. 
// There is at least one word in s. 
// 
//
// 
// Follow-up: If the string data type is mutable in your language, can you 
//solve it in-place with O(1) extra space? 
//
// Related Topics Two Pointers String 👍 5565 👎 4513


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q151ReverseWordsInAString {

    public static void main(String[] args) {
        Solution solution = new Q151ReverseWordsInAString().new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
//        System.out.println(solution.reverseWords("  hello world  "));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String reverseWords(String s) {
            return reverseWordsByO1Space(s);
        }

        public String reverseWordsByONSpace(String s) {
            List<String> list = new ArrayList<>();
            char[] chars = s.toCharArray();
            int i = 0;
            while (i < chars.length) {
                while (i < chars.length && chars[i] == ' ') {
                    i++;
                }
                int begin = i;
                while (i < chars.length && chars[i] != ' ') {
                    i++;
                }
                if (begin != i) {
                    list.add(s.substring(begin, i));
                }
            }
            Collections.reverse(list);
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        public String reverseWordsByO1Space(String s) {
            char[] chars = s.toCharArray();
            //remove extra spaces
//            int newLen = removeExtraSpaces(chars, ' ');
            int newLen = removeExtraSpaces2(chars, ' ');
            //reverse entire string
            reverse(chars, 0, newLen);
            //reverse each word
            reverseEachWord(chars, 0, newLen);
            return new String(chars, 0, newLen);
        }

        private void reverseEachWord(final char[] chars, int offset, int len) {
            int i = offset;
            int begin = offset;
            while (i < len) {
                if (chars[i] == ' ') {
                    begin = ++i;
                }
                while (i < len && chars[i] != ' ') {
                    i++;
                }
                reverse(chars, begin, i);
            }
        }

        /**
         * this version is hard to understand, use version2
         *
         * @param chars
         * @param val
         * @return
         */
        private int removeExtraSpaces(final char[] chars, final char val) {
            int slow = 0;
            int fast = 0;
            while (fast < chars.length && chars[fast] == val) {
                fast++;
            }
            int right = chars.length - 1;
            while (right > fast && chars[right] == val) {
                right--;
            }
            for (; fast <= right; fast++) {
                if (chars[fast] == val && chars[fast] != chars[fast - 1]) {
                    chars[slow++] = val;
                    continue;
                }
                if (chars[fast] != val) {
                    chars[slow++] = chars[fast];
                }
            }
            //return new array's length
            return slow;
        }

        private int removeExtraSpaces2(final char[] chars, final char val) {
            int slow = 0;
            for (int fast = 0; fast < chars.length; fast++) {
                if (chars[fast] != val) {
                    if (slow > 0) {
                        chars[slow++] = val;
                    }
                    while (fast < chars.length && chars[fast] != val) {
                        chars[slow++] = chars[fast++];
                    }
                }
            }
            return slow;
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