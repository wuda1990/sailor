//You are given an array of integers nums, there is a sliding window of size k w
//hich is moving from the very left of the array to the very right. You can only s
//ee the k numbers in the window. Each time the sliding window moves right by one 
//position. 
//
// Return the max sliding window. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
//Output: [3,3,5,5,6,7]
//Explanation: 
//Window position                Max
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 
//
// Example 2: 
//
// 
//Input: nums = [1], k = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 105 
// -104 <= nums[i] <= 104 
// 1 <= k <= nums.length 
// 
// Related Topics Array Queue Sliding Window Heap (Priority Queue) Monotonic Que
//ue 
// 👍 13161 👎 426


package com.onepiece.leetcode.editor.en;

import java.util.Deque;
import java.util.LinkedList;

public class Q239SlidingWindowMaximum {
    //2022-12-29 22:02:32
    //Sliding Window Maximum
    //编号：[239]
    public static void main(String[] args) {
        Solution solution = new Q239SlidingWindowMaximum().new Solution();
        solution.maxSlidingWindow(new int[]{1, -1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        class MyQueue {
            Deque<Integer> deque = new LinkedList<>();

            //弹出元素时，比较当前要弹出的数值是否等于队列出口的数值，如果相等则弹出
            //同时判断队列当前是否为空
            void poll(int val) {
                if (!deque.isEmpty() && val == deque.peek()) {
                    deque.poll();
                }
            }

            //添加元素时，如果要添加的元素大于入口处的元素，就将入口元素弹出
            //保证队列元素单调递减
            //比如此时队列元素3,1，2将要入队，比1大，所以1弹出，此时队列：3,2
            void add(int val) {
                while (!deque.isEmpty() && val > deque.getLast()) {
                    deque.removeLast();
                }
                deque.add(val);
            }

            //队列队顶元素始终为最大值
            int peek() {
                return deque.peek();
            }
        }

        public int[] maxSlidingWindow0(int[] nums, int k) {
            if (nums.length == 1) {
                return nums;
            }
            int len = nums.length - k + 1;
            //存放结果元素的数组
            int[] res = new int[len];
            int num = 0;
            //自定义队列
            MyQueue myQueue = new MyQueue();
            //先将前k的元素放入队列
            for (int i = 0; i < k; i++) {
                myQueue.add(nums[i]);
            }
            res[num++] = myQueue.peek();
            for (int i = k; i < nums.length; i++) {
                //滑动窗口移除最前面的元素，移除是判断该元素是否放入队列
                myQueue.poll(nums[i - k]);
                //滑动窗口加入最后面的元素
                myQueue.add(nums[i]);
                //记录对应的最大值
                res[num++] = myQueue.peek();
            }
            return res;
        }

        public int[] maxSlidingWindow(int[] nums, int k) {
            Deque<Integer> queue = new LinkedList<>();
            int[] result = new int[nums.length - k + 1];
            int num = 0;
            for (int i = 0; i < k; i++) {
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
            }
            result[num++] = queue.peekFirst();
            for (int i = k; i < nums.length; i++) {
                if (!queue.isEmpty() && queue.peekFirst() == nums[i - k]) {
                    queue.pollFirst();
                }
                while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
                result[num++] = queue.peekFirst();
            }
            return result;

        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
