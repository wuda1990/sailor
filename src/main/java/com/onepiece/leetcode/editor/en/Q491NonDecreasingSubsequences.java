//Given an integer array nums, return all the different possible non-decreasing 
//subsequences of the given array with at least two elements. You may return the a
//nswer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [4,6,7,7]
//Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
// 
//
// Example 2: 
//
// 
//Input: nums = [4,4,3,2,1]
//Output: [[4,4]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 15 
// -100 <= nums[i] <= 100 
// 
// Related Topics Array Hash Table Backtracking Bit Manipulation 
// 👍 2454 👎 180


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q491NonDecreasingSubsequences {
    public static void main(String[] args) {
        Solution solution = new Q491NonDecreasingSubsequences().new Solution();
        solution.findSubsequences(new int[]{4, 6, 7, 7});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> findSubsequences(int[] nums) {
            backTrack(nums, 0, new LinkedList<>());
            return ans;
        }

        private void backTrack(int[] nums, int startIndex, Deque<Integer> list) {
            if (list.size() > 1) {
                ans.add(new ArrayList<>(list));
            }
            boolean[] used = new boolean[201];
            for (int i = startIndex; i < nums.length; i++) {
                if (!list.isEmpty() && nums[i] < list.peekLast()) {
                    continue;
                }
                if (used[nums[i] + 100]) {
                    continue;
                }
                used[nums[i]+100] = true;
                list.offerLast(nums[i]);
                backTrack(nums, i + 1, list);
                list.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}