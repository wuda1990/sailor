//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 656 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.ListNode;

public class RotateList{
    public static void main(String[]args){
        Solution solution=new RotateList().new Solution();
        ListNode test = ListNode.initialList(new int[]{1,2,3,4,5});
        solution.rotateRight(test, 2);
        System.out.println("end");
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
    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy.next;
        ListNode tail = head;
        int n = 0;
        while (p != null) {
            n++;
            tail = p;
            p = p.next;
        }
        k = k % n; //如果k>n，则取御书
        p = dummy.next;
        //从哑节点往后找到第n-k个节点
        for (int i = 0; i < n - k - 1; i++) {
            p = p.next;
        }
        tail.next = dummy.next;
        dummy.next = p.next;
        p.next = null;
        return dummy.next;
    }

    //快慢指针
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy.next;
        ListNode slow = head;
        ListNode fast = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        k = k % n; //如果k>n，则取余数
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}