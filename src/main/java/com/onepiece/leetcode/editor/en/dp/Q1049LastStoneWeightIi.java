//You are given an array of integers stones where stones[i] is the weight of the
// ith stone. 
//
// We are playing a game with the stones. On each turn, we choose any two stones
// and smash them together. Suppose the stones have weights x and y with x <= y. T
//he result of this smash is: 
//
// 
// If x == y, both stones are destroyed, and 
// If x != y, the stone of weight x is destroyed, and the stone of weight y has 
//new weight y - x. 
// 
//
// At the end of the game, there is at most one stone left. 
//
// Return the smallest possible weight of the left stone. If there are no stones
// left, return 0. 
//
// 
// Example 1: 
//
// 
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation:
//We can combine 2 and 4 to get 2, so the array converts to [2,7,1,8,1] then,
//we can combine 7 and 8 to get 1, so the array converts to [2,1,1,1] then,
//we can combine 2 and 1 to get 1, so the array converts to [1,1,1] then,
//we can combine 1 and 1 to get 0, so the array converts to [1], then that's the
// optimal value.
// 
//
// Example 2: 
//
// 
//Input: stones = [31,26,33,21,40]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// 1 <= stones.length <= 30 
// 1 <= stones[i] <= 100 
// 
// Related Topics Array Dynamic Programming 
// 👍 2584 👎 89


package com.onepiece.leetcode.editor.en.dp;

public class Q1049LastStoneWeightIi {

    public static void main(String[] args) {
        Solution solution = new Q1049LastStoneWeightIi().new Solution();
//        int result = solution.lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1});
        int result = solution.lastStoneWeightII(new int[]{1, 2});
        System.out.println(result);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int i = 0; i < stones.length; i++) {
                sum += stones[i];
            }
            int target = sum / 2;
            int[][] dp = new int[stones.length][target + 1];
            for (int j = stones[0]; j <= target; j++) {
                dp[0][j] = stones[0];
            }
            for (int i = 1; i < stones.length; i++) {
                for (int j = 1; j <= target; j++) {
                    if (j < stones[i]) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                    }
                }
            }
            int x = dp[stones.length - 1][target];
            return sum - 2 * x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}