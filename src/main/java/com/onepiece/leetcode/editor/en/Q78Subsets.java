//Given an integer array nums of unique elements, return all possible subsets (t
//he power set). 
//
// The solution set must not contain duplicate subsets. Return the solution in a
//ny order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,3]
//Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// Example 2: 
//
// 
//Input: nums = [0]
//Output: [[],[0]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// All the numbers of nums are unique. 
// 
// Related Topics Array Backtracking Bit Manipulation 
// 👍 13317 👎 188


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q78Subsets {
    public static void main(String[] args) {
        Solution solution = new Q78Subsets().new Solution();
        solution.subsets(new int[]{1, 2, 3});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            backTrack(nums, 0, new LinkedList<>(), ans);
            return ans;
        }

        private void backTrack(int[] nums, int start, Deque<Integer> list,List<List<Integer>> ans) {
            ans.add(new ArrayList<>(list));
            for (int i = start; i < nums.length; i++) {
                list.offerLast(nums[i]);
                backTrack(nums, i + 1, list, ans);
                list.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}