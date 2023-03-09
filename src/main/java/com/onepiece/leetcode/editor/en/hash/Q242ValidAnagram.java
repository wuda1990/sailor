//Given two strings s and t, return true if t is an anagram of s, and false othe
//rwise. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a differe
//nt word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
// Input: s = "anagram", t = "nagaram"
//Output: true
// Example 2: 
// Input: s = "rat", t = "car"
//Output: false
// 
// 
// Constraints: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s and t consist of lowercase English letters. 
// 
//
// 
// Follow up: What if the inputs contain Unicode characters? How would you adapt
// your solution to such a case? 
// Related Topics Hash Table String Sorting 
// 👍 8443 👎 276


  package com.onepiece.leetcode.editor.en.hash;
  public class Q242ValidAnagram {
 //2023-03-09 21:20:03
    //Valid Anagram
    //编号：[242]
      public static void main(String[] args) {
           Solution solution = new Q242ValidAnagram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] dict = new int[26];
        for (char c : s.toCharArray()) {
            dict[c-'a']++;
        }
        for (char c : t.toCharArray()) {
            dict[c-'a']--;
        }
        for (int i : dict) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
