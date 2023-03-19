//Given an array of distinct integers candidates and a target integer target, re
//turn a list of all unique combinations of candidates where the chosen numbers su
//m to target. You may return the combinations in any order. 
//
// The same number may be chosen from candidates an unlimited number of times. T
//wo combinations are unique if the frequency of at least one of the chosen number
//s is different. 
//
// The test cases are generated such that the number of unique combinations that
// sum up to target is less than 150 combinations for the given input. 
//
// 
// Example 1: 
//
// 
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple ti
//mes.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
// 
//
// Example 2: 
//
// 
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
// 
//
// Example 3: 
//
// 
//Input: candidates = [2], target = 1
//Output: []
// 
//
// 
// Constraints: 
//
// 
// 1 <= candidates.length <= 30 
// 2 <= candidates[i] <= 40 
// All elements of candidates are distinct. 
// 1 <= target <= 40 
// 
// Related Topics Array Backtracking 
// 👍 14746 👎 294


package com.onepiece.leetcode.editor.en.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q39CombinationSum {
    public static void main(String[] args) {
        Solution solution = new Q39CombinationSum().new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            backTrack(candidates, target, 0, new LinkedList<>());
            return ans;
        }

        private void backTrack(int[] candidates, int target, int index, LinkedList<Integer> list) {
            if (0 == target) {
                ans.add(new ArrayList<>(list));
                return;
            }
            if (target < 0) {
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                list.offer(candidates[i]);
                backTrack(candidates, target - candidates[i], i, list);
                list.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}