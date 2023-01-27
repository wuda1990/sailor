//Given an integer array nums and an integer k, modify the array in the followin
//g way: 
//
// 
// choose an index i and replace nums[i] with -nums[i]. 
// 
//
// You should apply this process exactly k times. You may choose the same index 
//i multiple times. 
//
// Return the largest possible sum of the array after modifying it in this way. 
//
//
// 
// Example 1: 
//
// 
//Input: nums = [4,2,3], k = 1
//Output: 5
//Explanation: Choose index 1 and nums becomes [4,-2,3].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,-1,0,2], k = 3
//Output: 6
//Explanation: Choose indices (1, 2, 2) and nums becomes [3,1,0,2].
// 
//
// Example 3: 
//
// 
//Input: nums = [2,-3,-1,5,-4], k = 2
//Output: 13
//Explanation: Choose indices (1, 4) and nums becomes [2,3,-1,5,4].
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -100 <= nums[i] <= 100 
// 1 <= k <= 104 
// 
// Related Topics Array Greedy Sorting 
// 👍 1241 👎 95


package com.onepiece.leetcode.editor.en;

import java.util.stream.IntStream;

public class Q1005MaximizeSumOfArrayAfterKNegations {
    public static void main(String[] args) {
        Solution solution = new Q1005MaximizeSumOfArrayAfterKNegations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestSumAfterKNegations(int[] nums, int k) {
            int result = 0;
            int len = nums.length;
            nums = IntStream.of(nums).boxed().sorted((o1, o2) -> Math.abs(o2)-Math.abs(o1)).mapToInt(Integer::intValue).toArray();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < 0 && k > 0) {
                    nums[i] = nums[i] * -1;
                    k--;
                }
            }
            if (k > 0 && k % 2 == 1) {
                //modify the min abs number
                nums[len - 1] = nums[len - 1] * -1;
            }

            for (int i = 0; i < len; i++) {
                result = result + nums[i];
            }

            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}