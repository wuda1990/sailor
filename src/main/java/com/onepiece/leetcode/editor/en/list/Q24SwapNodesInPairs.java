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
// Related Topics Linked List Recursion 👍 8211 👎 334


package com.onepiece.leetcode.editor.en.list;

import com.onepiece.leetcode.editor.ListNode;

public class Q24SwapNodesInPairs{
 //2022-10-03 11:58:44
    //Swap Nodes in Pairs
    //编号：[24]
      public static void main(String[] args) {
           Solution solution = new Q24SwapNodesInPairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode slow = head;
        ListNode fast;
        while (slow != null && slow.next != null) {
            fast = slow.next;
            //sets the next node address
            pre.next = fast;
            slow.next = fast.next;
            fast.next = slow;
            //update point, pre and slow value
            pre = slow;
            slow = slow.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
