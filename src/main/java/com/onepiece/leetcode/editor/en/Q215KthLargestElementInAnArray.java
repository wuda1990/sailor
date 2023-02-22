//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// You must solve it in O(n) time complexity. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 12103 👎 616


  package com.onepiece.leetcode.editor.en;

import java.util.PriorityQueue;

public class Q215KthLargestElementInAnArray{
 //2022-10-09 09:32:08
    //Kth Largest Element in an Array
    //编号：[215]
      public static void main(String[] args) {
           Solution solution = new Q215KthLargestElementInAnArray().new Solution();
//          System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
          System.out.println(solution.findKthLargest(new int[]{ 2, 1}, 2));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int findKthLargest0(int[] nums, int k) {
            return findKthLargest(nums, 0, nums.length - 1, k);
        }

          /**
           * divide and conquer
           * @param nums
           * @param l
           * @param r
           * @param k
           * @return
           */
          private int findKthLargest(int[] nums, int l, int r, int k) {
              int index = partition(nums, l, r);

              //the numbers to the right of index
              int count = r - index + 1;
              if (count == k) {
                  return nums[index];
              } else if (count > k) {
                  return findKthLargest(nums, index + 1, r, k);
              }else {
                  //左半部分都是比nums[index]小的数，不包含右半部分的数，所以k要去掉count
                  return findKthLargest(nums, l, index - 1, k - count);
              }
          }

          /**
           * Two pointer,binary search
           * @param nums
           * @param k
           * @return
           */
          public int findKthLargest(int[] nums, int k) {
              int l = 0, r = nums.length - 1;
              int kth = nums.length - k;
              while (l < r) {
                  int pivotal = partition(nums, l, r);
                  if (pivotal == kth) {
                      return nums[pivotal];
                  } else if (pivotal < kth) {
                      l = pivotal + 1;
                  }else {
                      r = pivotal - 1;
                  }
              }
              return nums[l];
          }


        private int partition(int[] nums, int lo, int rh) {
            int l = lo;
            int r = rh;
            while (true) {
                while (nums[l] <= nums[lo] && l < rh) l++;
                while (nums[r] >= nums[lo] && r > lo) r--;
                if (l >= r) {
                    break;
                }
                swap(nums, l, r);
            }
            // r is the index which value is less than pivotal
            swap(nums, lo, r);
            return r;
        }

          private void swap(int[] nums, int i, int j) {
              int tmp = nums[i];
              nums[i] = nums[j];
              nums[j] = tmp;
          }

      }

      public int findKthLargestByHeap(int[] nums, int k) {
          PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
          for (int i = 0; i < nums.length; i++) {
              priorityQueue.add(nums[i]);
              if (priorityQueue.size() > k) {
                  priorityQueue.poll();
              }
          }
          return priorityQueue.peek();
      }

//leetcode submit region end(Prohibit modification and deletion)


  }
