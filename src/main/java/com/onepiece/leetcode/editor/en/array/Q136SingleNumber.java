//Given a non-empty array of integers nums, every element appears twice except f
//or one. Find that single one. 
//
// You must implement a solution with a linear runtime complexity and use only c
//onstant extra space. 
//
// 
// Example 1: 
// Input: nums = [2,2,1]
//Output: 1
// Example 2: 
// Input: nums = [4,1,2,1,2]
//Output: 4
// Example 3: 
// Input: nums = [1]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 104 
// -3 * 104 <= nums[i] <= 3 * 104 
// Each element in the array appears twice except for one element which appears 
//only once. 
// 
// Related Topics Array Bit Manipulation 
// 👍 11670 👎 444


package com.onepiece.leetcode.editor.en.array;

public class Q136SingleNumber {

    //2022-10-09 12:51:20
    //Single Number
    //编号：[136]
    public static void main(String[] args) {
        Solution solution = new Q136SingleNumber().new Solution();
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i : nums) {
                result = result ^ i;
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
