//You are given a string s consisting of lowercase English letters. A duplicate 
//removal consists of choosing two adjacent and equal letters and removing them. 
//
// We repeatedly make duplicate removals on s until we no longer can. 
//
// Return the final string after all such duplicate removals have been made. It 
//can be proven that the answer is unique. 
//
// 
// Example 1: 
//
// 
//Input: s = "abbaca"
//Output: "ca"
//Explanation: 
//For example, in "abbaca" we could remove "bb" since the letters are adjacent a
//nd equal, and this is the only possible move.  The result of this move is that t
//he string is "aaca", of which only "aa" is possible, so the final string is "ca"
//.
// 
//
// Example 2: 
//
// 
//Input: s = "azxxzy"
//Output: "ay"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 105 
// s consists of lowercase English letters. 
// 
// Related Topics String Stack 
// 👍 5519 👎 217


package com.onepiece.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class Q1047RemoveAllAdjacentDuplicatesInString {
    //2023-03-16 21:53:48
    //Remove All Adjacent Duplicates In String
    //编号：[1047]
    public static void main(String[] args) {
        Solution solution = new Q1047RemoveAllAdjacentDuplicatesInString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String removeDuplicates(String s) {
            char[] arr = s.toCharArray();
            Deque<Character> deque = new LinkedList<>();
            for (char c : arr) {
                Character peek = deque.peek();
                if (peek != null && peek == c) {
                    deque.pop();
                }else {
                    deque.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!deque.isEmpty()) {
                sb.append(deque.pollLast());
            }
            return sb.toString();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
