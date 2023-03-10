//Given an array of positive integers nums and a positive integer target, return
// the minimal length of a subarray whose sum is greater than or equal to target. 
//If there is no such subarray, return 0 instead. 
//
// 
// Example 1: 
//
// 
//Input: target = 7, nums = [2,3,1,2,4,3]
//Output: 2
//Explanation: The subarray [4,3] has the minimal length under the problem const
//raint.
// 
//
// Example 2: 
//
// 
//Input: target = 4, nums = [1,4,4]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: target = 11, nums = [1,1,1,1,1,1,1,1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 104 
// 
//
// 
//Follow up: If you have figured out the O(n) solution, try coding another solut
//ion of which the time complexity is O(n log(n)). Related Topics Array Binary Sea
//rch Sliding Window Prefix Sum 
// 👍 8840 👎 246


package com.onepiece.leetcode.editor.en.array;

public class Q209MinimumSizeSubarraySum {

    public static void main(String[] args) {
        Solution solution = new Q209MinimumSizeSubarraySum().new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minSubArrayLen(int target, int[] nums) {
            int minSize = Integer.MAX_VALUE;
            int sum = 0;
            int i = 0, j = 0;
            int len = nums.length;
            while (j < len) {
                sum += nums[j];
                while (i < len && sum >= target) {
                    sum = sum - nums[i];
                    minSize = Math.min(minSize, j - i + 1);
                    i++;
                }
                j++;
            }
            return minSize == Integer.MAX_VALUE ? 0 : minSize;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}