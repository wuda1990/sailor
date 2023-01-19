//Given a collection of candidate numbers (candidates) and a target number (targ
//et), find all unique combinations in candidates where the candidate numbers sum 
//to target. 
//
// Each number in candidates may only be used once in the combination. 
//
// Note: The solution set must not contain duplicate combinations. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics Array Backtracking 
// 👍 7716 👎 191


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q40CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new Q40CombinationSumIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            backTrack(candidates, target, 0, new LinkedList<>());
            return ans;
        }

        private void backTrack(int[] candidates, int target, int startIndex, LinkedList<Integer> list) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(list));
            }
            for (int i = startIndex; i < candidates.length; i++) {
                //
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.offerLast(candidates[i]);
                backTrack(candidates, target - candidates[i], i + 1, list);
                list.pollLast();
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}