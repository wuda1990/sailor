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
        public int[] sortedSquares1(int[] nums) {
            int len = nums.length;
            //calculate the mid is pivotal, it is the position which the value is greater than 0
            int mid = nums[0] >= 0 ? 0 : len - 1;
            // if mid>0, then loop to find the index which value is greater than 0
            for (int i = 1; i < len; i++) {
                if (nums[i] >= 0) {
                    mid = i;
                    break;
                }
            }
            int l, r;
            if (nums[mid] > 0) {
                l = mid - 1;
                r = mid;
            } else {
                l = mid;
                r = mid + 1;
            }
            int i = 0;
            int[] result = new int[len];
            while (l >= 0 && r < len) {
                if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                    result[i++] = sqrt(nums[r++]);
                } else {
                    result[i++] = sqrt(nums[l--]);
                }
            }
            while (l >= 0) {
                result[i++] = sqrt(nums[l--]);
            }
            while (r < len) {
                result[i++] = sqrt(nums[r++]);
            }
            return result;
        }

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
