//There are some spherical balloons taped onto a flat wall that represents the X
//Y-plane. The balloons are represented as a 2D integer array points where points[
//i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches betwee
//n xstart and xend. You do not know the exact y-coordinates of the balloons. 
//
// Arrows can be shot up directly vertically (in the positive y-direction) from 
//different points along the x-axis. A balloon with xstart and xend is burst by an
// arrow shot at x if xstart <= x <= xend. There is no limit to the number of arro
//ws that can be shot. A shot arrow keeps traveling up infinitely, bursting any ba
//lloons in its path. 
//
// Given the array points, return the minimum number of arrows that must be shot
// to burst all balloons. 
//
// 
// Example 1: 
//
// 
//Input: points = [[10,16],[2,8],[1,6],[7,12]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
//- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
// 
//
// Example 2: 
//
// 
//Input: points = [[1,2],[3,4],[5,6],[7,8]]
//Output: 4
//Explanation: One arrow needs to be shot for each balloon for a total of 4 arro
//ws.
// 
//
// Example 3: 
//
// 
//Input: points = [[1,2],[2,3],[3,4],[4,5]]
//Output: 2
//Explanation: The balloons can be burst by 2 arrows:
//- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
//- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
// 
//
// 
// Constraints: 
//
// 
// 1 <= points.length <= 105 
// points[i].length == 2 
// -231 <= xstart < xend <= 231 - 1 
// 
// Related Topics Array Greedy Sorting 
// 👍 5818 👎 160


package com.onepiece.leetcode.editor.en.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Q452MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        Solution solution = new Q452MinimumNumberOfArrowsToBurstBalloons().new Solution();
//        solution.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}});
//        solution.findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}});
        solution.findMinArrowShots(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}});
//        solution.findMinArrowShots(new int[][]{{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinArrowShots(int[][] points) {
            if (points.length == 0) {
                return 0;
            }
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int arrows = 1;
            int end = points[0][1];
            for (int i = 1; i < points.length; i++) {
                if (end < points[i][0]) {
                    arrows++;
                    end = points[i][1];
                }else {//更新右边界
                    end = Math.min(points[i][1], end);
                }
            }
            return arrows;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}