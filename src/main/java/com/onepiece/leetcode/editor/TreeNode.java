package com.onepiece.leetcode.editor;

import java.util.LinkedList;
import java.util.Queue;

//Definition for a binary tree node.
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode build(String s) {
        if ("null".equalsIgnoreCase(s)) {
            return null;
        }
        return new TreeNode(Integer.parseInt(s));
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode build(String[] str) {
        if (str.length == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = build(str[0]);
        queue.offer(root);
        int i = 0;
        while (!queue.isEmpty() && i < str.length) {
            TreeNode p = queue.poll();
            if (p == null) {
                continue;
            }
            if (++i < str.length) {
                p.left = build(str[i]);
                queue.offer(p.left);
            }
            if (++i < str.length) {
                p.right = build(str[i]);
                queue.offer(p.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new String[]{"3","9","20","null","null","4","5","2"});
        System.out.println("end");
    }
}

