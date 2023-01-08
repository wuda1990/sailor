//Given the root of a binary tree, check whether it is a mirror of itself (i.e.,
// symmetric around its center). 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,2,3,4,4,3]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,2,null,3,null,3]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Could you solve it both recursively and iteratively? Related Topics
// Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 11884 👎 270


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q101SymmetricTree {
    //2023-01-08 09:30:36
    //Symmetric Tree
    //编号：[101]
    public static void main(String[] args) {
        Solution solution = new Q101SymmetricTree().new Solution();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(null);
        Integer poll = queue.poll();
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
//        public boolean isSymmetric2(TreeNode root) {
//            if (root == null) {
//                return true;
//            }
//            return compare(root.left, root.right);
//        }
//
//        //depth first
//        private boolean compare(TreeNode left, TreeNode right) {
//            if (left == null && right == null) {
//                return true;
//            }
//            if (left == null || right == null) {
//                return false;
//            }
//            if (left.val != right.val) {
//                return false;
//            }
//            return compare(left.right, right.left) && compare(left.left, right.right);
//        }

        //breadth-first
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root.left);
            queue.offer(root.right);
            while (!queue.isEmpty()) {
                TreeNode left = queue.poll();
                TreeNode right = queue.poll();
                if (left == null && right == null) {
                    continue;
                }
                if (left == null || right == null || left.val != right.val) {
                    return false;
                }
                queue.offer(left.right);
                queue.offer(right.left);
                queue.offer(left.left);
                queue.offer(right.right);

            }
            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
