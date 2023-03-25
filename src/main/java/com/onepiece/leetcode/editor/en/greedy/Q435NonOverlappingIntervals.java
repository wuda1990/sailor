//Given an array of intervals intervals where intervals[i] = [starti, endi], ret
//urn the minimum number of intervals you need to remove to make the rest of the i
//ntervals non-overlapping. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//Output: 1
//Explanation: [1,3] can be removed and the rest of the intervals are non-overla
//pping.
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[1,2],[1,2]]
//Output: 2
//Explanation: You need to remove two [1,2] to make the rest of the intervals no
//n-overlapping.
// 
//
// Example 3: 
//
// 
//Input: intervals = [[1,2],[2,3]]
//Output: 0
//Explanation: You don't need to remove any of the intervals since they're alrea
//dy non-overlapping.
// 
//
// 
// Constraints: 
//
// 
// 1 <= intervals.length <= 105 
// intervals[i].length == 2 
// -5 * 104 <= starti < endi <= 5 * 104 
// 
// Related Topics Array Dynamic Programming Greedy Sorting 
// 👍 5432 👎 153


package com.onepiece.leetcode.editor.en.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Q435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new Q435NonOverlappingIntervals().new Solution();
        solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervalsSortByLeft(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int lapCount = 0;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    lapCount++;
                    end = Math.min(end, intervals[i][1]);
                }else {
                    end = intervals[i][1];
                }
            }
            return lapCount;
        }

        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
            int lapCount = 0;
            int end = intervals[0][1];
            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] < end) {
                    lapCount++;
                    //按右边界排序，不用每次更新end为最小值，因为end已经是最小值
                }else {
                    end = intervals[i][1];
                }
            }
            return lapCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}