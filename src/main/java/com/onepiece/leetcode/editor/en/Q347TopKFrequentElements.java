//Given an integer array nums and an integer k, return the k most frequent 
//elements. You may return the answer in any order. 
//
// 
// Example 1: 
// Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
// 
// Example 2: 
// Input: nums = [1], k = 1
//Output: [1]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// k is in the range [1, the number of unique elements in the array]. 
// It is guaranteed that the answer is unique. 
// 
//
// 
// Follow up: Your algorithm's time complexity must be better than O(n log n), 
//where n is the array's size. 
//
// Related Topics Array Hash Table Divide and Conquer Sorting Heap (Priority 
//Queue) Bucket Sort Counting Quickselect 👍 12951 👎 475


package com.onepiece.leetcode.editor.en;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q347TopKFrequentElements {

    public static void main(String[] args) {
        Solution solution = new Q347TopKFrequentElements().new Solution();
//        solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        solution.topKFrequent(new int[]{-1, -1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] topKFrequent(int[] nums, int k) {
            int[] count = new int[20001];
            for (int i : nums) {
                count[i + 10000]++;
            }
            PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(nums.length,
                Comparator.comparingInt(Pair::getRight).reversed());

            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    priorityQueue.offer(new Pair(i - 10000, count[i]));
                }
            }
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = priorityQueue.poll().getLeft();
            }
            return result;
        }

        class Pair {

            int left;
            int right;

            public Pair(final int left, final int right) {
                this.left = left;
                this.right = right;
            }

            public int getLeft() {
                return left;
            }

            public void setLeft(final int left) {
                this.left = left;
            }

            public int getRight() {
                return right;
            }

            public void setRight(final int right) {
                this.right = right;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}