//Given the head of a singly linked list, reverse the list, and return the 
//reversed list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,4,5]
//Output: [5,4,3,2,1]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: [2,1]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is the range [0, 5000]. 
// -5000 <= Node.val <= 5000 
// 
//
// 
// Follow up: A linked list can be reversed either iteratively or recursively. 
//Could you implement both? 
//
// Related Topics Linked List Recursion 👍 14843 👎 250


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.ListNode;

public class Q206ReverseLinkedList {

    //2022-10-03 18:53:25
    //Reverse Linked List
    //编号：[206]
    public static void main(String[] args) {
        Solution solution = new Q206ReverseLinkedList().new Solution();
        final ListNode listNode = ListNode.initialList(new int[]{1, 2, 3});
        final ListNode result = solution.reverseListRecursively(listNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {

        public ListNode reverseListRecursively(ListNode head) {
            return reverse(head, null);
        }

        private ListNode reverse(final ListNode p, final ListNode pre) {
            if (p == null) {
                return pre;
            }
            ListNode next = p.next;
            p.next = pre;
            return reverse(next, p);
        }

        //iterator
        public ListNode reverse(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = null;
            ListNode p = dummy;
            while (p.next != null) {
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
