//Given the root of a binary tree, invert the tree, and return its root. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,7,1,3,6,9]
//Output: [4,7,2,9,6,3,1]
// 
//
// Example 2: 
//
// 
//Input: root = [2,1,3]
//Output: [2,3,1]
// 
//
// Example 3: 
//
// 
//Input: root = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 10673 👎 154


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

public class Q226InvertBinaryTree {
    //2023-01-07 11:22:02
    //Invert Binary Tree
    //编号：[226]
    public static void main(String[] args) {
        Solution solution = new Q226InvertBinaryTree().new Solution();
        TreeNode root = TreeNode.build(new String[]{"4", "2", "7", "1", "3", "6", "9"});
        solution.invertTree(root);
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
        public TreeNode invertTree(TreeNode root) {
            if (root == null) {
                return null;
            }
//            swap(root);
            invertTree(root.left);
            invertTree(root.right);
            swap(root);//后序遍历改为先序或中序也可以通过
            return root;
        }

        private void swap(TreeNode node) {
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
