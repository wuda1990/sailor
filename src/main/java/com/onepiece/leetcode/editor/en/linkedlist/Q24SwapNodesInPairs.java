//Given a linked list, swap every two adjacent nodes and return its head. You 
//must solve the problem without modifying the values in the list's nodes (i.e., 
//only nodes themselves may be changed.) 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4]
//Output: [2,1,4,3]
// 
//
// Example 2: 
//
// 
//Input: head = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 100]. 
// 0 <= Node.val <= 100 
// 
//
// Related Topics Linked List Recursion 👍 9254 👎 357


package com.onepiece.leetcode.editor.en.linkedlist;

import com.onepiece.leetcode.editor.ListNode;

public class Q24SwapNodesInPairs {

    public static void main(String[] args) {
        Solution solution = new Q24SwapNodesInPairs().new Solution();
        solution.swapPairs(ListNode.initialList(new int[]{1, 2, 3, 4}));
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {

        public ListNode swapPairs(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode slow = dummy.next;
            while (slow != null && slow.next != null) {
                ListNode fast = slow.next;
                ListNode next = fast.next;
                fast.next = slow;
                slow.next = next;
                pre.next = fast;
                pre = slow;
                slow = next;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}