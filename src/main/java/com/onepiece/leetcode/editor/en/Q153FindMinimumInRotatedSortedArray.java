//Suppose an array of length n sorted in ascending order is rotated between 1 an
//d n times. For example, the array nums = [0,1,2,4,5,6,7] might become: 
//
// 
// [4,5,6,7,0,1,2] if it was rotated 4 times. 
// [0,1,2,4,5,6,7] if it was rotated 7 times. 
// 
//
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results 
//in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]]. 
//
// Given the sorted rotated array nums of unique elements, return the minimum el
//ement of this array. 
//
// You must write an algorithm that runs in O(log n) time. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,4,5,1,2]
//Output: 1
//Explanation: The original array was [1,2,3,4,5] rotated 3 times.
// 
//
// Example 2: 
//
// 
//Input: nums = [4,5,6,7,0,1,2]
//Output: 0
//Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times
//.
// 
//
// Example 3: 
//
// 
//Input: nums = [11,13,15,17]
//Output: 11
//Explanation: The original array was [11,13,15,17] and it was rotated 4 times. 
//
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 5000 
// -5000 <= nums[i] <= 5000 
// All the integers of nums are unique. 
// nums is sorted and rotated between 1 and n times. 
// 
// Related Topics Array Binary Search 
// 👍 8643 👎 434


  package com.onepiece.leetcode.editor.en;
  public class Q153FindMinimumInRotatedSortedArray{
 //2022-10-08 16:45:27
    //Find Minimum in Rotated Sorted Array
    //编号：[153]
      public static void main(String[] args) {
           Solution solution = new Q153FindMinimumInRotatedSortedArray().new Solution();
          System.out.println(solution.findMin(new int[]{3, 4, 5, 1, 2}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        while (r - l > 1) {
            // The right shift operation should be enclosed in parentheses
            int m = l + ((r - l) >> 1);
            if (nums[m] > nums[r]) {
                l = m;
            }else {
                r = m;
            }
        }
        return Math.min(nums[l], nums[r]);
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
