//Given the heads of two singly linked-lists headA and headB, return the node at
// which the two lists intersect. If the two linked lists have no intersection at 
//all, return null. 
//
// For example, the following two linked lists begin to intersect at node c1: 
//
// The test cases are generated such that there are no cycles anywhere in the en
//tire linked structure. 
//
// Note that the linked lists must retain their original structure after the fun
//ction returns. 
//
// Custom Judge: 
//
// The inputs to the judge are given as follows (your program is not given these
// inputs): 
//
// 
// intersectVal - The value of the node where the intersection occurs. This is 0
// if there is no intersected node. 
// listA - The first linked list. 
// listB - The second linked list. 
// skipA - The number of nodes to skip ahead in listA (starting from the head) t
//o get to the intersected node. 
// skipB - The number of nodes to skip ahead in listB (starting from the head) t
//o get to the intersected node. 
// 
//
// The judge will then create the linked structure based on these inputs and pas
//s the two heads, headA and headB to your program. If you correctly return the in
//tersected node, then your solution will be accepted. 
//
// 
// Example 1: 
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Intersected at '8'
//Explanation: The intersected node's value is 8 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [
//5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 no
//des before the intersected node in B.
//- Note that the intersected node's value is not 1 because the nodes with value
// 1 in A and B (2nd node in A and 3rd node in B) are different node references. I
//n other words, they point to two different locations in memory, while the nodes 
//with value 8 in A and B (3rd node in A and 4th node in B) point to the same loca
//tion in memory.
// 
//
// Example 2: 
//
// 
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Intersected at '2'
//Explanation: The intersected node's value is 2 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [
//3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node bef
//ore the intersected node in B.
// 
//
// Example 3: 
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: No intersection
//Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it r
//eads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, whi
//le skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes of listA is in the m. 
// The number of nodes of listB is in the n. 
// 1 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA < m 
// 0 <= skipB < n 
// intersectVal is 0 if listA and listB do not intersect. 
// intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect. 
// 
//
// 
//Follow up: Could you write a solution that runs in O(m + n) time and use only 
//O(1) memory? Related Topics Hash Table Linked List Two Pointers 
// 👍 12478 👎 1134


  package com.onepiece.leetcode.editor.en.linkedlist;

import com.onepiece.leetcode.editor.ListNode;

public class Q160IntersectionOfTwoLinkedLists {
 //2023-03-09 20:53:28
    //Intersection of Two Linked Lists
    //编号：[160]
      public static void main(String[] args) {
           Solution solution = new Q160IntersectionOfTwoLinkedLists().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        //if two lists are not intersected, p1=null, or else return the intersection
        return p1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
