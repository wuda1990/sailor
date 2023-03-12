//Given the head of a linked list, remove the nᵗʰ node from the end of the list 
//and return its head. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5], n = 2
//Output: [1,2,3,5]
// 
//
// Example 2: 
//
// 
//Input: head = [1], n = 1
//Output: []
// 
//
// Example 3: 
//
// 
//Input: head = [1,2], n = 1
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is sz. 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
// Follow up: Could you do this in one pass? 
//
// Related Topics Linked List Two Pointers 👍 14998 👎 620


package com.onepiece.leetcode.editor.en.linkedlist;

import com.onepiece.leetcode.editor.ListNode;

public class Q19RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        Solution solution = new Q19RemoveNthNodeFromEndOfList().new Solution();
        solution.removeNthFromEnd(ListNode.initialList(new int[]{1, 2, 3, 4, 5}), 2);
    }

//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0, head);
            ListNode fast = dummy;
            int i = 0;
            while (fast != null && i < n) {
                fast = fast.next;
                i++;
            }
            ListNode slow = dummy;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //delete the node after slow
            slow.next = slow.next.next;
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}