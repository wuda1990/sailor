//Given a string s and a dictionary of strings wordDict, return true if s can be
// segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Hash Table String Dynamic Programming Trie Memoization 
// 👍 13329 👎 561


package com.onepiece.leetcode.editor.en;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q139WordBreak {
    public static void main(String[] args) {
        Solution solution = new Q139WordBreak().new Solution();
        solution.wordBreak("leetcode", Arrays.asList("leet", "code"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dictSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int j = 1; j <= s.length(); j++) {
                for (int i = 0; i < j && !dp[j]; i++) {
                    String substring = s.substring(i, j);
                    dp[j] = dp[i] && dictSet.contains(substring);
                }
            }
            return dp[s.length()];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}