//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,4,4,5,6,7] might become: 
//
// 
// [4,5,6,7,0,1,4] if it was rotated 4 times. 
// [0,1,4,4,5,6,7] if it was rotated 7 times. 
// 
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 
//
// Given the sorted rotated array nums that may contain duplicates, return the m
//inimum element of this array. 
//
// You must decrease the overall operation steps as much as possible. 
//
// 
// Example 1: 
// Input: nums = [1,3,5]
//Output: 1
// Example 2: 
// Input: nums = [2,2,2,0,1]
//Output: 0
// 
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// nums is sorted and rotated between 1 and n times. 
// 
//
// 
// Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, b
//ut nums may contain duplicates. Would this affect the runtime complexity? How an
//d why? 
//
// 
// Related Topics Array Binary Search 
// 👍 3451 👎 397


  package com.onepiece.leetcode.editor.en;
  public class Q154FindMinimumInRotatedSortedArrayIi{
 //2022-10-08 17:35:22
    //Find Minimum in Rotated Sorted Array II
    //编号：[154]
      public static void main(String[] args) {
           Solution solution = new Q154FindMinimumInRotatedSortedArrayIi().new Solution();
          System.out.println(solution.findMin(new int[]{3, 3, 1, 3}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[right]) {
                left = mid;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }else {
                if (nums[right - 1] > nums[right]) {// this imply right is the min index
                    return nums[right];
                }
                right--;
            }
        }
        return Math.min(nums[left], nums[right]);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
