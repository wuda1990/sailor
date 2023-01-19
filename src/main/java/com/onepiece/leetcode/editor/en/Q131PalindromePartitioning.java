//Given a string s, partition s such that every substring of the partition is a 
//palindrome. Return all possible palindrome partitioning of s. 
//
// 
// Example 1: 
// Input: s = "aab"
//Output: [["a","a","b"],["aa","b"]]
// Example 2: 
// Input: s = "a"
//Output: [["a"]]
// 
// 
// Constraints: 
//
// 
// 1 <= s.length <= 16 
// s contains only lowercase English letters. 
// 
// Related Topics String Dynamic Programming Backtracking 
// 👍 9075 👎 294


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q131PalindromePartitioning {
    public static void main(String[] args) {
        Solution solution = new Q131PalindromePartitioning().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();
        public List<List<String>> partition(String s) {
            backTrack(s, s.length(), new LinkedList<>());
            return ans;
        }

        private void backTrack(String s, int leftCnt, LinkedList<String> list) {
            if (leftCnt == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
            for (int i = 1; i <= s.length(); i++) {
                String subStr = s.substring(0, i);
                if (!isPalindrome(subStr)) {
                    continue;
                }
                list.offerLast(subStr);
                backTrack(s.substring(i), leftCnt - subStr.length(), list);
                list.pollLast();
            }

        }

        private boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}