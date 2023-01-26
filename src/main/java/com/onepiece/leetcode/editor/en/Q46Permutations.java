//Given an array nums of distinct integers, return all the possible permutations
//. You can return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2: 
// Input: nums = [0,1]
//Output: [[0,1],[1,0]]
// Example 3: 
// Input: nums = [1]
//Output: [[1]]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// All the integers of nums are unique. 
// 
// Related Topics Array Backtracking 
// 👍 14437 👎 243


package com.onepiece.leetcode.editor.en;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q46Permutations {
    public static void main(String[] args) {
        Solution solution = new Q46Permutations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permute(int[] nums) {
            used = new boolean[nums.length];
            backTrack(nums, new LinkedList<>());
            return ans;
        }

        private void backTrack(int[] nums, Deque<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
            }
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.offerLast(nums[i]);
                used[i] = true;
                backTrack(nums, path);
                used[i] = false;
                path.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}