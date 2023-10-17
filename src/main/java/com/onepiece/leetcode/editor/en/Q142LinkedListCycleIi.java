//Given the head of a linked list, return the node where the cycle begins. If 
//there is no cycle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to (0
//-indexed). It is -1 if there is no cycle. Note that pos is not passed as a 
//parameter. 
//
// Do not modify the linked list. 
//
// 
// Example 1: 
// 
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the 
//second node.
// 
//
// Example 2: 
// 
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the 
//first node.
// 
//
// Example 3: 
// 
// 
//Input: head = [1], pos = -1
//Output: no cycle
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
//
// Related Topics Hash Table Linked List Two Pointers 👍 9071 👎 629


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.ListNode;

public class Q142LinkedListCycleIi {

    //2022-10-03 22:45:49
    //Linked List Cycle II
    //编号：[142]
    public static void main(String[] args) {
        Solution solution = new Q142LinkedListCycleIi().new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list. class ListNode { int val; ListNode next; ListNode(int x) { val = x; next =
     * null; } }
     */
    public class Solution {

        /**
         * how is the solution working? m denotes the distance from head to the start of cycle n denotes the distance
         * from the start of cycle to the meeting point l denotes the length of the cycle 2(m + n) = m + n + kl => m +
         * n= kl => m = kl - n => m = (k - 1)l + (l - n) so when slow and fast meet, if we set another pointer start
         * from head, and move it with slow pointer together, they will meet at the start of cycle
         *
         * @param head
         * @return
         */
        public ListNode detectCycle(ListNode head) {
            ListNode start, slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    start = head;
                    while (start != slow) {
                        start = start.next;
                        slow = slow.next;
                    }
                    return start;
                }
            }
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
