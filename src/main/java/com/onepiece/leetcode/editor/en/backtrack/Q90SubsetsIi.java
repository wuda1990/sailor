//Given an integer array nums that may contain duplicates, return all possible s
//ubsets (the power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
// Input: nums = [1,2,2]
//Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
// Example 2: 
// Input: nums = [0]
//Output: [[],[0]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 7383 👎 207


package com.onepiece.leetcode.editor.en.backtrack;

import java.util.*;

public class Q90SubsetsIi {
    public static void main(String[] args) {
        Solution solution = new Q90SubsetsIi().new Solution();
        solution.subsetsWithDup(new int[]{1, 2, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            backTrack(nums, 0, new LinkedList<>(), ans);
            return ans;
        }

        private void backTrack(int[] nums, int start, Deque<Integer> list, List<List<Integer>> ans) {
            ans.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                list.offerLast(nums[i]);
                backTrack(nums, i + 1, list, ans);
                list.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}