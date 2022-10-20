//<p>You are given two <strong>non-empty</strong> linked lists representing two non-negative integers. The digits are stored in <strong>reverse order</strong>, and each of their nodes contains a single digit. Add the two numbers and return the sum&nbsp;as a linked list.</p>
//
//<p>You may assume the two numbers do not contain any leading zero, except the number 0 itself.</p>
//
//<p>&nbsp;</p>
//<p><strong>Example 1:</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/10/02/addtwonumber1.jpg" style="width: 483px; height: 342px;" />
//<pre>
//<strong>Input:</strong> l1 = [2,4,3], l2 = [5,6,4]
//<strong>Output:</strong> [7,0,8]
//<strong>Explanation:</strong> 342 + 465 = 807.
//</pre>
//
//<p><strong>Example 2:</strong></p>
//
//<pre>
//<strong>Input:</strong> l1 = [0], l2 = [0]
//<strong>Output:</strong> [0]
//</pre>
//
//<p><strong>Example 3:</strong></p>
//
//<pre>
//<strong>Input:</strong> l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//<strong>Output:</strong> [8,9,9,9,0,0,0,1]
//</pre>
//
//<p>&nbsp;</p>
//<p><strong>Constraints:</strong></p>
//
//<ul>
//	<li>The number of nodes in each linked list is in the range <code>[1, 100]</code>.</li>
//	<li><code>0 &lt;= Node.val &lt;= 9</code></li>
//	<li>It is guaranteed that the list represents a number that does not have leading zeros.</li>
//</ul>
//<div><div>Related Topics</div><div><li>递归</li><li>链表</li><li>数学</li></div></div><br><div><li>👍 6740</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.ListNode;

public class AddTwoNumbers{
  public static void main(String[] args) {
       Solution solution = new AddTwoNumbers().new Solution();
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        int jinwei = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + jinwei;
            jinwei = sum / 10;
            ListNode p = new ListNode(sum % 10);
            pre.next = p;
            pre = p;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int sum = l1.val + jinwei;
            jinwei = sum / 10;
            ListNode p = new ListNode(sum % 10);
            pre.next = p;
            pre = p;
            l1 = l1.next;
        }
        while (l2 != null) {
            int sum = l2.val + jinwei;
            jinwei = sum / 10;
            ListNode p = new ListNode(sum % 10);
            pre.next = p;
            pre = p;
            l2 = l2.next;
        }
        if (jinwei != 0) {
            ListNode p = new ListNode(jinwei);
            pre.next = p;
            pre = p;
        }
        return head.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}