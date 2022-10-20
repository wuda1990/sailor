//Given the head of a singly linked list, return true if it is a palindrome or 
//false otherwise. 
//
// 
// Example 1: 
// 
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 10⁵]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in 
//O(n) time and 
//O(1) space?
//
// Related Topics Linked List Two Pointers Stack Recursion 👍 11893 👎 663


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.ListNode;

public class Q234PalindromeLinkedList{
 //2022-10-03 21:31:28
    //Palindrome Linked List
    //编号：[234]
      public static void main(String[] args) {
           Solution solution = new Q234PalindromeLinkedList().new Solution();
          ListNode head = ListNode.initialList(new int[]{1, 2});
          System.out.println(solution.isPalindrome(head));
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
    public boolean isPalindrome(ListNode head) {
        //find the mid node slow
        ListNode slow=head,fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //reverse the right half node
        if (fast != null) {
            // when length is odd, forward
            slow = slow.next;
        }
        ListNode rHead = reverse(slow, null);
        ListNode p = head,q = rHead;
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }

    //this method makes the original linked list messed up
    private ListNode reverse(ListNode head, ListNode pre) {
        if (head == null) {
            return pre;
        }
        ListNode next = head.next;
        head.next = pre;
        return reverse(next, head);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
