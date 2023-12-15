//Given an integer array nums sorted in non-decreasing order, return an array of
// the squares of each number sorted in non-decreasing order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-4,-1,0,3,10]
//Output: [0,1,9,16,100]
//Explanation: After squaring, the array becomes [16,1,0,9,100].
//After sorting, it becomes [0,1,9,16,100].
// 
//
// Example 2: 
//
// 
//Input: nums = [-7,-3,2,3,11]
//Output: [4,9,9,49,121]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// nums is sorted in non-decreasing order. 
// 
//
// 
//Follow up: Squaring each element and sorting the new array is very trivial, co
//uld you find an O(n) solution using a different approach? Related Topics Array T
//wo Pointers Sorting 
// 👍 6700 👎 169


package com.onepiece.leetcode.editor.en;

public class Q977SquaresOfASortedArray {
    //2022-10-30 21:02:10
    //Squares of a Sorted Array
    //编号：[977]
    public static void main(String[] args) {
        Solution solution = new Q977SquaresOfASortedArray().new Solution();
        System.out.println(solution.sortedSquares(new int[]{-5, -3, -2, -1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int sqrt(int a) {
            return a * a;
        }

        // l, r pointers iterate from left and right to middle
        // new arrays k pointer iterate from right to left
        public int[] sortedSquares(int[] nums) {
            int len = nums.length;
            int l = 0, r = len - 1;
            int[] res = new int[len];
            int k = len-1;
            while (l <= r) {
                if (Math.abs(nums[l]) < Math.abs(nums[r])) {
                    res[k--] = sqrt(nums[r--]);
                }else {
                    res[k--] = sqrt(nums[l++]);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
