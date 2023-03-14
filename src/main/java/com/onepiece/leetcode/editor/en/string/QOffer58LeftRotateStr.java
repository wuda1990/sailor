package com.onepiece.leetcode.editor.en.string;

public class QOffer58LeftRotateStr {

    public static void main(String[] args) {
        QOffer58LeftRotateStr.Solution solution = new QOffer58LeftRotateStr().new Solution();
        System.out.println(solution.reverseLeftWords("abcdefg", 2));
    }

    class Solution {

        public String reverseLeftWords(String s, int n) {
            return reverseLeftWordsUsingRotate(s, n);
        }

        public String reverseLeftWordsUsingReverse(String s, int n) {
            int len = s.length();
            StringBuilder sb = new StringBuilder(s);
            reverseString(sb, 0, n - 1);
            reverseString(sb, n, len - 1);
            return sb.reverse().toString();
        }

        public void reverseString(StringBuilder sb, int start, int end) {
            while (start < end) {
                char temp = sb.charAt(start);
                sb.setCharAt(start, sb.charAt(end));
                sb.setCharAt(end, temp);
                start++;
                end--;
            }
        }

        public String reverseLeftWordsUsingRotate(String s, int n) {
            char[] chars = s.toCharArray();
            char[] tmp = new char[n];
            for (int i = 0; i < n; i++) {
                tmp[i] = chars[i];
            }
            int k = 0;
            for (; k < chars.length - n; k++) {
                chars[k] = chars[k + n];
            }
            for (int i = 0; k < chars.length && i < tmp.length; k++, i++) {
                chars[k] = tmp[i];
            }
            return new String(chars);
        }

    }
}
