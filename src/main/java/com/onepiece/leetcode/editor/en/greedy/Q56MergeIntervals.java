//Given an array of intervals where intervals[i] = [starti, endi], merge all ove
//rlapping intervals, and return an array of the non-overlapping intervals that co
//ver all the intervals in the input. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics Array Sorting 
// 👍 17806 👎 614


package com.onepiece.leetcode.editor.en.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Q56MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Q56MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            LinkedList<int[]> list = new LinkedList<>();
            list.add(intervals[0]);
            for (int i = 1; i < intervals.length; i++) {
                int[] last = list.peekLast();
                if (last[1] >= intervals[i][0]) {
                    list.pollLast();
                    list.offerLast(new int[]{last[0], Math.max(last[1], intervals[i][1])});
                } else {
                    list.offerLast(intervals[i]);
                }
            }

            return list.toArray(new int[list.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}