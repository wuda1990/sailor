//Given two strings ransomNote and magazine, return true if ransomNote can be 
//constructed by using the letters from magazine and false otherwise. 
//
// Each letter in magazine can only be used once in ransomNote. 
//
// 
// Example 1: 
// Input: ransomNote = "a", magazine = "b"
//Output: false
// 
// Example 2: 
// Input: ransomNote = "aa", magazine = "ab"
//Output: false
// 
// Example 3: 
// Input: ransomNote = "aa", magazine = "aab"
//Output: true
// 
// 
// Constraints: 
//
// 
// 1 <= ransomNote.length, magazine.length <= 10⁵ 
// ransomNote and magazine consist of lowercase English letters. 
// 
//
// Related Topics Hash Table String Counting 👍 3737 👎 403


package com.onepiece.leetcode.editor.en;

public class Q383RansomNote {

    public static void main(String[] args) {
        Solution solution = new Q383RansomNote().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canConstruct(String ransomNote, String magazine) {
            int[] dict = new int[26];
            for (char c : ransomNote.toCharArray()) {
                dict[c - 'a']++;
            }
            for (char c : magazine.toCharArray()) {
                dict[c - 'a']--;
            }
            for (int i : dict) {
                if (i > 0) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}