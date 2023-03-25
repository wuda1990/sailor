//You are given a string s. We want to partition the string into as many parts 
//as possible so that each letter appears in at most one part. 
//
// Note that the partition is done so that after concatenating all the parts in 
//order, the resultant string should be s. 
//
// Return a list of integers representing the size of these parts. 
//
// 
// Example 1: 
//
// 
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it 
//splits s into less parts.
// 
//
// Example 2: 
//
// 
//Input: s = "eccbbbbdec"
//Output: [10]
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 500 
// s consists of lowercase English letters. 
// 
//
// Related Topics Hash Table Two Pointers String Greedy 👍 9296 👎 344


package com.onepiece.leetcode.editor.en.greedy;

import java.util.ArrayList;
import java.util.List;

public class Q763PartitionLabels {
    //2023-03-25 10:02:17
    //Partition Labels
    //编号：[763]
    public static void main(String[] args) {
        Solution solution = new Q763PartitionLabels().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 利用了hash表记录每个字符最远位置，确实巧妙
         *
         * @param s
         * @return
         */
        public List<Integer> partitionLabels(String s) {
            int[] hash = new int[26];
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                hash[c[i] - 'a'] = i;
            }
            List<Integer> ans = new ArrayList<>();
            int left = 0;
            int right = 0;
            for (int i = 0; i < c.length; i++) {
                right = Math.max(right, hash[c[i] - 'a']);
                if (i == right) {
                    ans.add(right - left + 1);
                    left = right + 1;
                }
            }
            return ans;
        }

        //Todo 统计字符串中所有字符的起始和结束位置，记录这些区间(实际上也就是435.无重叠区间 (opens new window)题目里的输入)，
        // 将区间按左边界从小到大排序，找到边界将区间划分成组，互不重叠。找到的边界就是答案。
    }
//leetcode submit region end(Prohibit modification and deletion)

}
