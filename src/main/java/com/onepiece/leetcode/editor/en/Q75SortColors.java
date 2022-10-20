//Given an array nums with n objects colored red, white, or blue, sort them in-
//place so that objects of the same color are adjacent, with the colors in the 
//order red, white, and blue. 
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and 
//blue, respectively. 
//
// You must solve this problem without using the library's sort function. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
// 
//
// Example 2: 
//
// 
//Input: nums = [2,0,1]
//Output: [0,1,2]
// 
//
// 
// Constraints: 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] is either 0, 1, or 2. 
// 
//
// 
// Follow up: Could you come up with a one-pass algorithm using only constant 
//extra space? 
//
// Related Topics Array Two Pointers Sorting 👍 12414 👎 464


package com.onepiece.leetcode.editor.en;
  public class Q75SortColors{
 //2022-10-04 22:14:33
    //Sort Colors
    //编号：[75]
      public static void main(String[] args) {
           Solution solution = new Q75SortColors().new Solution();
           solution.swap(new int[]{1,2,3},0,2);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
          // only 0,1,2 exists in array, so set 1 as pivotal number, then all 0 on the left , all 2 on the right
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (int k = l; k <= r; ) {
            if (nums[k] == 0) {
                swap(nums, k++, l++);
            } else if (nums[k] == 2) {
                swap(nums,k,r--);
            }else {
                k++;
            }
        }
    }

          private void swap(int[] nums, int i, int j) {
//              int tmp = nums[i];
//              nums[i] = nums[j];
//              nums[j] = tmp;
              nums[i] = nums[i] ^ nums[j];
              nums[j] = nums[i] ^ nums[j];
              nums[i] = nums[i] ^ nums[j];
          }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
