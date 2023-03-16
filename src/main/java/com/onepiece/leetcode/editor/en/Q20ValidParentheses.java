//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']
//', determine if the input string is valid. 
//
// An input string is valid if: 
//
// 
// Open brackets must be closed by the same type of brackets. 
// Open brackets must be closed in the correct order. 
// Every close bracket has a corresponding open bracket of the same type. 
// 
//
// 
// Example 1: 
//
// 
//Input: s = "()"
//Output: true
// 
//
// Example 2: 
//
// 
//Input: s = "()[]{}"
//Output: true
// 
//
// Example 3: 
//
// 
//Input: s = "(]"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 104 
// s consists of parentheses only '()[]{}'. 
// 
// Related Topics String Stack 
// 👍 18495 👎 1056


  package com.onepiece.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q20ValidParentheses{
 //2023-03-16 21:38:07
    //Valid Parentheses
    //编号：[20]
      public static void main(String[] args) {
           Solution solution = new Q20ValidParentheses().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c == '(') {
                deque.push(')');
            } else if (c == '[') {
                deque.push(']');
            } else if (c == '{') {
                deque.push('}');
            } else if (deque.isEmpty() || c != deque.pop()) {
                return false;
            }
        }
        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
