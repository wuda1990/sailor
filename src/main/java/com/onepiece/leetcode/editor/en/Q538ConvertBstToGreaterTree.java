//Given the root of a Binary Search Tree (BST), convert it to a Greater Tree suc
//h that every key of the original BST is changed to the original key plus the sum
// of all keys greater than the original key in BST. 
//
// As a reminder, a binary search tree is a tree that satisfies these constraint
//s: 
//
// 
// The left subtree of a node contains only nodes with keys less than the node's
// key. 
// The right subtree of a node contains only nodes with keys greater than the no
//de's key. 
// Both the left and right subtrees must also be binary search trees. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
//Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
// 
//
// Example 2: 
//
// 
//Input: root = [0,null,1]
//Output: [1,null,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -104 <= Node.val <= 104 
// All the values in the tree are unique. 
// root is guaranteed to be a valid binary search tree. 
// 
//
// 
// Note: This question is the same as 1038: https://leetcode.com/problems/binary
//-search-tree-to-greater-sum-tree/ 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 4660 👎 167


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q538ConvertBstToGreaterTree {
    //2023-01-15 16:29:16
    //Convert BST to Greater Tree
    //编号：[538]
    public static void main(String[] args) {
        Solution solution = new Q538ConvertBstToGreaterTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        TreeNode pre = null;
        public TreeNode convertBST(TreeNode root) {
            if (root == null) {
                return null;
            }
            convertBST(root.right);
            if (pre != null) {
                root.val += pre.val;
            }
            pre = root;
            convertBST(root.left);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
