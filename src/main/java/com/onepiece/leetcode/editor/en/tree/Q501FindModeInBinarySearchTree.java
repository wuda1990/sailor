//Given the root of a binary search tree (BST) with duplicates, return all the m
//ode(s) (i.e., the most frequently occurred element) in it. 
//
// If the tree has more than one mode, return them in any order. 
//
// Assume a BST is defined as follows: 
//
// 
// The left subtree of a node contains only nodes with keys less than or equal t
//o the node's key. 
// The right subtree of a node contains only nodes with keys greater than or equ
//al to the node's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,2]
//Output: [2]
// 
//
// Example 2: 
//
// 
//Input: root = [0]
//Output: [0]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -105 <= Node.val <= 105 
// 
//
// 
//Follow up: Could you do that without using any extra space? (Assume that the i
//mplicit stack space incurred due to recursion does not count). Related Topics Tr
//ee Depth-First Search Binary Search Tree Binary Tree 
// 👍 2717 👎 628


  package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Q501FindModeInBinarySearchTree {
 //2023-01-15 10:28:11
    //Find Mode in Binary Search Tree
    //编号：[501]
      public static void main(String[] args) {
           Solution solution = new Q501FindModeInBinarySearchTree().new Solution();
          solution.findMode(TreeNode.build(new String[]{"1", "null", "2", "2"}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    int maxCount = Integer.MIN_VALUE;
    int count = 0;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        LinkedList<Integer> list = new LinkedList();
        pre = root;
        inOrder(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left,list);
        if (pre.val == root.val) {
            count++;
        }else {
            count = 1;
        }
        if (count == maxCount) {
            list.add(root.val);
        }
        if (count > maxCount) {
            list.clear();
            list.add(root.val);
            maxCount = count;
        }
        pre = root;
        inOrder(root.right,list);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
