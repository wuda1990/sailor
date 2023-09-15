package com.onepiece.leetcode.editor.en;

public class ReplaceWhiteSpace {

    public static void main(String[] args) {
        Solution solution = new ReplaceWhiteSpace().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //replace white space with %20, in place
        public String replaceSpace(String s) {
            char[] chars = s.toCharArray();
            int spaceCount = 0;
            for (char c : chars) {
                if (c == ' ') {
                    spaceCount++;
                }
            }
            int newLength = chars.length + spaceCount * 2;
            char[] newChars = new char[newLength];
            int j = newLength - 1;
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] == ' ') {
                    newChars[j--] = '0';
                    newChars[j--] = '2';
                    newChars[j--] = '%';
                } else {
                    newChars[j--] = chars[i];
                }
            }
            return new String(newChars);
        }

    }

}
