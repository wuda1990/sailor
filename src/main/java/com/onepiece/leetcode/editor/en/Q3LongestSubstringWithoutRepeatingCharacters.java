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

//Notice: 处理连续问题可以用滑动窗口,如子串,子数组
//Sliding window can be used when consecutive problem is encountered, such as subString, subarray
package com.onepiece.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q3LongestSubstringWithoutRepeatingCharacters {

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
            int i = 0;// i means start of the sub string
            int max = 0;
            int j = 0;
            while (i < n && j < n) {
                int tmp = charIndex[s.charAt(j)];
                /**
                 * why to get the max between tmp+1 and i ?
                 * consider str abcdefgga, when iterate to second g, first g's index is 6, change i to 7,
                 * but when iterate to second a, first a's index is 0, change i to 1, but i is already 7, so we need to get the max between tmp+1 and i
                 */
                if (tmp != -1) {
                    i = Math.max(tmp + 1, i);
                }
                charIndex[s.charAt(j)] = j;
                max = Math.max(j - i + 1, max);
                j++;
            }
            return max;
        }

        /**
         * it is never easy to loop, condition/branch/i,j need to be considered
         *
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
