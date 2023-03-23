//Given a collection of numbers, nums, that might contain duplicates, return all
// possible unique permutations in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics Array Backtracking 
// 👍 7008 👎 126


package com.onepiece.leetcode.editor.en.backtrack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q47PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new Q47PermutationsIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used;

        public List<List<Integer>> permuteUnique(int[] nums) {
            used = new boolean[nums.length];
            backTrack(nums, new LinkedList<>());
            return ans;
        }

        private void backTrack(int[] nums, Deque<Integer> path) {
            if (path.size() == nums.length) {
                ans.add(new ArrayList<>(path));
            }
            //breadthwise used array
            boolean[] brUsed = new boolean[21];
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || brUsed[nums[i] + 10]) {
                    continue;
                }
                path.offerLast(nums[i]);
                used[i] = true;
                brUsed[nums[i] + 10] = true;
                backTrack(nums, path);
                used[i] = false;
                path.pollLast();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}