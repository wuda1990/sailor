//Given an integer array nums and an integer val, remove all occurrences of val 
//in nums in-place. The relative order of the elements may be changed. 
//
// Since it is impossible to change the length of the array in some languages, y
//ou must instead have the result be placed in the first part of the array nums. M
//ore formally, if there are k elements after removing the duplicates, then the fi
//rst k elements of nums should hold the final result. It does not matter what you
// leave beyond the first k elements. 
//
// Return k after placing the final result in the first k slots of nums. 
//
// Do not allocate extra space for another array. You must do this by modifying 
//the input array in-place with O(1) extra memory. 
//
// Custom Judge: 
//
// The judge will test your solution with the following code: 
//
// 
//int[] nums = [...]; // Input array
//int val = ...; // Value to remove
//int[] expectedNums = [...]; // The expected answer with correct length.
//                            // It is sorted with no values equaling val.
//
//int k = removeElement(nums, val); // Calls your implementation
//
//assert k == expectedNums.length;
//sort(nums, 0, k); // Sort the first k elements of nums
//for (int i = 0; i < actualLength; i++) {
//    assert nums[i] == expectedNums[i];
//}
// 
//
// If all assertions pass, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of
// nums being 2.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// Example 2: 
//
// 
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements o
//f nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are unders
//cores).
// 
//
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 100 
// 0 <= nums[i] <= 50 
// 0 <= val <= 100 
// 
// Related Topics Array Two Pointers 
// 👍 4629 👎 6353


package com.onepiece.leetcode.editor.en.array;

public class Q27RemoveElement {

    //2022-10-29 23:30:04
    //Remove Element
    //编号：[27]
    public static void main(String[] args) {
        Solution solution = new Q27RemoveElement().new Solution();
//          System.out.println(solution.removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(solution.removeElement(new int[]{2}, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int removeElement1(int[] nums, int val) {
            int l = 0;
            int r = nums.length - 1;
            while (true) {
                while (l < nums.length && nums[l] != val) {
                    l++;
                }
                while (r >= 0 && nums[r] == val) {
                    r--;
                }
                if (l >= r) {
                    break;
                }
                swap(nums, l, r);
            }
            return l;
        }

        private void swap(int[] nums, int i, int j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }

        // solution 2 :use slow and fast pointer
        public int removeElement(int[] nums, int val) {
            int slow = 0;
            int fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != val) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
