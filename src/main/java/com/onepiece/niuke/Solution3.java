package com.onepiece.niuke;

import java.util.PriorityQueue;

public class Solution3 {

    //return the third max number in nums
    public int maxThird(int[] nums) {
        //use min priority queue
        int len = nums.length;
        int k = 3;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < len; i++) {
            if (minHeap.size() < k && !minHeap.contains(nums[i])) {
                minHeap.add(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int[] nums = {3, 2, 2, 1};
        int ans = solution3.maxThird(nums);
        System.out.println(ans);
    }
}
