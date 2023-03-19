//You are given the root of a binary search tree (BST) and an integer val. 
//
// Find the node in the BST that the node's value equals val and return the subt
//ree rooted with that node. If such a node does not exist, return null. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3], val = 2
//Output: [2,1,3]
// 
//
// Example 2: 
//
// 
//Input: root = [4,2,7,1,3], val = 5
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 5000]. 
// 1 <= Node.val <= 107 
// root is a binary search tree. 
// 1 <= val <= 107 
// 
// Related Topics Tree Binary Search Tree Binary Tree 
// 👍 4458 👎 163


  package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

public class Q700SearchInABinarySearchTree {
 //2023-01-14 18:42:37
    //Search in a Binary Search Tree
    //编号：[700]
      public static void main(String[] args) {
           Solution solution = new Q700SearchInABinarySearchTree().new Solution();
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
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
//        TreeNode leftTree = searchBST(root.left, val);
//        if (leftTree != null) {
//            return leftTree;
//        }
//        TreeNode rightTree = searchBST(root.right, val);
//        if (rightTree != null) {
//            return rightTree;
//        }
//        return null;
        if (root.val > val) {
            return searchBST(root.left, val);
        }else {
            return searchBST(root.right, val);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
