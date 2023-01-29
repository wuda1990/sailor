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


package com.onepiece.leetcode.editor.en;

import java.util.Arrays;
import java.util.Comparator;

public class Q435NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new Q435NonOverlappingIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int arrows = 1;
            for (int i = 0; i < intervals.length - 1; i++) {
                if (intervals[i][1] <= intervals[i + 1][0]) {
                    arrows++;
                }else {
                    intervals[i + 1][1] = Math.min(intervals[i + 1][1], intervals[i][1]);
                }
            }
            return intervals.length - arrows;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}