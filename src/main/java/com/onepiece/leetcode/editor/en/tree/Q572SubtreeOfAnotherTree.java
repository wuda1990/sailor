//Given the roots of two binary trees root and subRoot, return true if there is 
//a subtree of root with the same structure and node values of subRoot and false o
//therwise. 
//
// A subtree of a binary tree tree is a tree that consists of a node in tree and
// all of this node's descendants. The tree tree could also be considered as a sub
//tree of itself. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,4,5,1,2], subRoot = [4,1,2]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the root tree is in the range [1, 2000]. 
// The number of nodes in the subRoot tree is in the range [1, 1000]. 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// Related Topics Tree Depth-First Search String Matching Binary Tree Hash Funct
//ion 
// 👍 6954 👎 394


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

public class Q572SubtreeOfAnotherTree {
    //2023-03-18 13:56:04
    //Subtree of Another Tree
    //编号：[572]
    public static void main(String[] args) {
        Solution solution = new Q572SubtreeOfAnotherTree().new Solution();
        TreeNode treeNode = TreeNode.build("1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2".split(","));
        TreeNode subTree = TreeNode.build("1,null,1,null,1,null,1,null,1,null,1,2".split(","));
        boolean result = solution.isSubtree(treeNode, subTree);
        System.out.println(result);
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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null) {
                return false;
            }
            return compare(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean compare(TreeNode node1, TreeNode node2) {
            if (node1 == null && node2 == null) {
                return true;
            }
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            return compare(node1.left, node2.left) && compare(node1.right, node2.right);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
