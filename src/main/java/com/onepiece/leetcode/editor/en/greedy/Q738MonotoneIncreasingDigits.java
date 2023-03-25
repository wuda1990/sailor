//An integer has monotone increasing digits if and only if each pair of adjacent
// digits x and y satisfy x <= y. 
//
// Given an integer n, return the largest number that is less than or equal to n
// with monotone increasing digits. 
//
// 
// Example 1: 
//
// 
//Input: n = 10
//Output: 9
// 
//
// Example 2: 
//
// 
//Input: n = 1234
//Output: 1234
// 
//
// Example 3: 
//
// 
//Input: n = 332
//Output: 299
// 
//
// 
// Constraints: 
//
// 
// 0 <= n <= 109 
// 
// Related Topics Math Greedy 
// 👍 1121 👎 92


package com.onepiece.leetcode.editor.en.greedy;

public class Q738MonotoneIncreasingDigits {
    public static void main(String[] args) {
        Solution solution = new Q738MonotoneIncreasingDigits().new Solution();
        solution.monotoneIncreasingDigits(10);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int monotoneIncreasingDigits(int n) {
            String s = String.valueOf(n);
            char[] chars = s.toCharArray();
            int flag = chars.length;
            for (int i = chars.length - 2; i >= 0; i--) {
                if (chars[i] > chars[i + 1]) {
                    chars[i]--;
                    flag = i + 1;
                }
            }
            for (int i = flag; i < chars.length; i++) {
                chars[i] = '9';
            }
            return Integer.parseInt(String.valueOf(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}