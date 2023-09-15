package com.onepiece.leetcode.editor;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 传入数组，初始化链表
     *
     * @param arr
     */
    public static ListNode initialList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (int val : arr) {
            ListNode node = new ListNode(val);
            p.next = node;
            p = node;
        }
        p.next = null;
        return dummy.next;
    }

    //print the list
    public void print() {

    }
}
