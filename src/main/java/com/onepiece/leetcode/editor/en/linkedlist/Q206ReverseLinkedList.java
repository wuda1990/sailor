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


package com.onepiece.leetcode.editor.en.linkedlist;

import com.onepiece.leetcode.editor.ListNode;

public class Q206ReverseLinkedList {

    //2022-10-03 18:53:25
    //Reverse Linked List
    //编号：[206]
    public static void main(String[] args) {
        Solution solution = new Q206ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode() {} ListNode(int
     * val) { this.val = val; } ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
     */
    class Solution {

        public ListNode reverseList2(ListNode head) {
            return reverseListInt(head, null);
        }

        private ListNode reverseListInt(ListNode p, ListNode pre) {
            if (p == null) {
                return pre;
            }
            ListNode next = p.next;
            //set current p's next to the pre value
            p.next = pre;
            return reverseListInt(next, p);
        }

        public ListNode reverseList(ListNode head) {
            ListNode pre = null, next = null;
            ListNode p = head;
            while (p != null) {
                next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
