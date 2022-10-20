//Given a string s, find the length of the longest substring without repeating 
//characters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s consists of English letters, digits, symbols and spaces. 
// 
//
// Related Topics Hash Table String Sliding Window 👍 28879 👎 1229


package com.onepiece.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3LongestSubstringWithoutRepeatingCharacters{
 //2022-09-30 09:27:01
    //Longest Substring Without Repeating Characters
    //编号：[3]
      public static void main(String[] args) {
           Solution solution = new Q3LongestSubstringWithoutRepeatingCharacters().new Solution();
//          System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
//          System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
          System.out.println(solution.lengthOfLongestSubstring("abba")); //To clear this scene
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] charIndex = new int[256];
        Arrays.fill(charIndex, -1);
        int n = s.length();
        int i = 0;
        int max = 0;
        int j = 0;
        while (i < n && j < n) {
            int tmp = charIndex[s.charAt(j)];
            i = Math.max(tmp + 1, i);// equals to below code segment
//            if (tmp != -1) {
//                i = Math.max(tmp + 1, i);
//            }
            charIndex[s.charAt(j)] = j;
            max = Math.max(j - i + 1, max);
            j++;
        }
        return max;
    }

          /**
           * it is never easy to loop, condition/branch/i,j need to be considered
           * @param s
           * @return
           */
          public int lengthOfLongestSubstring2(String s) {
              Map<Character, Integer> map = new HashMap<>();
              int n = s.length();
              int i = 0, j = 0;
              int max = 0;
              while (i < n && j < n) {
                  char tmp = s.charAt(j);
                  if (map.containsKey(tmp)) {
                      i = Math.max(map.get(tmp) + 1, i);
                  }
                  max = Math.max(max, j - i + 1);
                  map.put(tmp, j);
                  j++;
              }
              return max;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
