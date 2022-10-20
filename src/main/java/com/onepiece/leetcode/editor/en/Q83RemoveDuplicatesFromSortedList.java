//Given the head of a sorted linked list, delete all duplicates such that each 
//element appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
//
// Related Topics Linked List 👍 5927 👎 210


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.ListNode;

public class Q83RemoveDuplicatesFromSortedList{
 //2022-10-03 17:22:27
    //Remove Duplicates from Sorted List
    //编号：[83]
      public static void main(String[] args) {
           Solution solution = new Q83RemoveDuplicatesFromSortedList().new Solution();
          ListNode head = ListNode.initialList(new int[]{1, 1, 2});
          solution.deleteDuplicates(head);
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            while (q != null && p.val == q.val) {
                q = q.next;
            }
            p.next = q;
            p = q;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
