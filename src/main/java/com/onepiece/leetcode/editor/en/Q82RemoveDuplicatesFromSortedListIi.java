//Given the head of a sorted linked list, delete all nodes that have duplicate 
//numbers, leaving only distinct numbers from the original list. Return the linked 
//list sorted as well. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,3,3,4,4,5]
//Output: [1,2,5]
// 
//
// Example 2: 
// 
// 
//Input: head = [1,1,1,2,3]
//Output: [2,3]
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
// Related Topics Linked List Two Pointers 👍 6651 👎 185


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.ListNode;

public class Q82RemoveDuplicatesFromSortedListIi{
 //2022-10-03 18:20:57
    //Remove Duplicates from Sorted List II
    //编号：[82]
      public static void main(String[] args) {
           Solution solution = new Q82RemoveDuplicatesFromSortedListIi().new Solution();
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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        int n;
        //1,2,2,4,4,5,6
        while (p.next != null && p.next.next != null) {
            if (p.next.val == p.next.next.val) {
                n = p.next.val;
                while (p.next != null && p.next.val == n) {
                    p.next = p.next.next;
                }
            }else {
                p = p.next;
            }
        }
        return dummy.next;
        
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
