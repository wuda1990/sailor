//Implement a last-in-first-out (LIFO) stack using only two queues. The implemen
//ted stack should support all the functions of a normal stack (push, top, pop, an
//d empty). 
//
// Implement the MyStackUsingDoubleQueue class:
//
// 
// void push(int x) Pushes element x to the top of the stack. 
// int pop() Removes the element on the top of the stack and returns it. 
// int top() Returns the element on the top of the stack. 
// boolean empty() Returns true if the stack is empty, false otherwise. 
// 
//
// Notes: 
//
// 
// You must use only standard operations of a queue, which means that only push 
//to back, peek/pop from front, size and is empty operations are valid. 
// Depending on your language, the queue may not be supported natively. You may 
//simulate a queue using a list or deque (double-ended queue) as long as you use o
//nly a queue's standard operations. 
// 
//
// 
// Example 1: 
//
// 
//Input
//["MyStackUsingDoubleQueue", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 2, 2, false]
//
//Explanation
//MyStackUsingDoubleQueue myStack = new MyStackUsingDoubleQueue();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // return 2
//myStack.pop(); // return 2
//myStack.empty(); // return False
// 
//
// 
// Constraints: 
//
// 
// 1 <= x <= 9 
// At most 100 calls will be made to push, pop, top, and empty. 
// All the calls to pop and top are valid. 
// 
//
// 
// Follow-up: Can you implement the stack using only one queue? 
// Related Topics Stack Design Queue 
// 👍 4094 👎 973


package com.onepiece.leetcode.editor.en.stackQueue;

import java.util.LinkedList;
import java.util.Queue;

public class Q225ImplementStackUsingQueues {
    //2023-03-16 21:21:24
    //Implement Stack using Queues
    //编号：[225]
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
//    class MyStackUsingDoubleQueue {
//
//        Queue<Integer> queue1;
//        Queue<Integer> queue2;
//
//        public MyStackUsingDoubleQueue() {
//            queue1 = new LinkedList<>();
//            queue2 = new LinkedList<>();
//        }
//
//        public void push(int x) {
//            queue1.offer(x);
//        }
//
//        public int pop() {
//            int size = queue1.size();
//            for (int i = 0; i < size - 1; i++) {
//                queue2.offer(queue1.poll());
//            }
//            int result = queue1.poll();
//            Queue<Integer> tmp = queue1;
//            queue1 = queue2;
//            queue2 = tmp;
//            return result;
//        }
//
//        public int top() {
//            int size = queue1.size();
//            for (int i = 0; i < size - 1; i++) {
//                queue2.offer(queue1.poll());
//            }
//            int result = queue1.poll();
//            queue2.offer(result);
//            Queue<Integer> tmp = queue1;
//            queue1 = queue2;
//            queue2 = tmp;
//            return result;
//
//        }
//
//        public boolean empty() {
//            return queue1.isEmpty();
//        }
//    }

    class MyStack {

        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
        }

        public int pop() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
            int result = queue.poll();
            return result;
        }

        public int top() {
            int size = queue.size();
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
            int result = queue.poll();
            queue.offer(result);
            return result;

        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

/**
 * Your MyStackUsingDoubleQueue object will be instantiated and called as such:
 * MyStackUsingDoubleQueue obj = new MyStackUsingDoubleQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
