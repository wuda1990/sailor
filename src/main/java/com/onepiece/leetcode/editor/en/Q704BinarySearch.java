//Given an array of integers nums which is sorted in ascending order, and an int
//eger target, write a function to search target in nums. If target exists, then r
//eturn its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -104 < nums[i], target < 104 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
// Related Topics Array Binary Search 
// 👍 6785 👎 148


  package com.onepiece.leetcode.editor.en;
  public class Q704BinarySearch{
 //2022-10-08 14:05:44
    //Binary Search
    //编号：[704]
      public static void main(String[] args) {
           Solution solution = new Q704BinarySearch().new Solution();
//          System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 19));
          System.out.println(solution.search(new int[]{5}, 5));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) {
                return mid;
            }else if (target > nums[mid]) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
