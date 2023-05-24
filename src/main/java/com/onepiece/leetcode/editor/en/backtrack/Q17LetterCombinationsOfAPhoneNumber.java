//Given a string containing digits from 2-9 inclusive, return all possible lette
//r combinations that the number could represent. Return the answer in any order. 
//
//
// A mapping of digits to letters (just like on the telephone buttons) is given 
//below. Note that 1 does not map to any letters. 
//
// 
// Example 1: 
//
// 
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// Example 2: 
//
// 
//Input: digits = ""
//Output: []
// 
//
// Example 3: 
//
// 
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
// 
// Constraints: 
//
// 
// 0 <= digits.length <= 4 
// digits[i] is a digit in the range ['2', '9']. 
// 
// Related Topics Hash Table String Backtracking
// 👍 13804 👎 802


package com.onepiece.leetcode.editor.en.backtrack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17LetterCombinationsOfAPhoneNumber {

    //2023-01-18 23:46:24
    //Letter Combinations of a Phone Number
    //编号：[17]
    public static void main(String[] args) {
        Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> letterCombinationsBackTrack(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits.length() == 0)
                return ans;
            backTrack(ans, digits, "", 0);
            return ans;
        }

        public final Map<Character, String> telMap = new HashMap<>();

        //init
        {
            telMap.put('2', "abc");
            telMap.put('3', "def");
            telMap.put('4', "ghi");
            telMap.put('5', "jkl");
            telMap.put('6', "mno");
            telMap.put('7', "pqrs");
            telMap.put('8', "tuv");
            telMap.put('9', "wxyz");
        }


        private void backTrack(List<String> ans, String digits, String str, int index) {
            if (index == digits.length()) {
                ans.add(str);
            } else {
                String telStr = telMap.get(digits.charAt(index));
                for (int j = 0; j < telStr.length(); j++) {
                    backTrack(ans, digits, str + telStr.charAt(j), index + 1);
                }

            }
        }

        //traverse by bfs
        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if (digits.length() == 0) {
                return ans;
            }
            Deque<String> deque = new ArrayDeque<>();
            deque.push("");
            int i = 0;
            while (!deque.isEmpty() && i < digits.length()) {
                int size = deque.size();
                for (int l = 0; l < size; l++) {
                    String s = deque.poll();
                    String telStr = telMap.get(digits.charAt(i));
                    for (int j = 0; j < telStr.length(); j++) {
                        if (i + 1 == digits.length()) {
                            ans.add(s + telStr.charAt(j));
                        } else {
                            deque.offer(s + telStr.charAt(j));
                        }
                    }
                }
                i++;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
