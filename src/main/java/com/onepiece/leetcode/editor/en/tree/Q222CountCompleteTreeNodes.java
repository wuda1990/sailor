//Given the root of a complete binary tree, return the number of the nodes in th
//e tree. 
//
// According to Wikipedia, every level, except possibly the last, is completely 
//filled in a complete binary tree, and all nodes in the last level are as far lef
//t as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// 
//
// Design an algorithm that runs in less than O(n) time complexity. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,4,5,6]
//Output: 6
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: 0
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5 * 104]. 
// 0 <= Node.val <= 5 * 104 
// The tree is guaranteed to be complete. 
// 
// Related Topics Binary Search Tree Depth-First Search Binary Tree 
// 👍 6993 👎 394


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

public class Q222CountCompleteTreeNodes {
    //2023-01-10 21:33:07
    //Count Complete Tree Nodes
    //编号：[222]
    public static void main(String[] args) {
        Solution solution = new Q222CountCompleteTreeNodes().new Solution();
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
        public int countNodes(TreeNode root) {
            if (root == null) {
                return 0;
            }
//            return countNodes(root.left) + countNodes(root.right) + 1;
            TreeNode left = root.left;
            TreeNode right = root.right;
            int leftDepth = 0;
            int rightDepth = 0;
            while (left != null) {  // 求左子树深度
                left = left.left;
                leftDepth++;
            }
            while (right != null) { // 求右子树深度
                right = right.right;
                rightDepth++;
            }
            if (leftDepth == rightDepth) {
                return (2 << leftDepth) - 1; // 注意(2<<1) 相当于2^2，所以leftDepth初始为0
            }
            return countNodes(root.left) + countNodes(root.right) + 1;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
