//Given the root of a binary tree, return the leftmost value in the last row of 
//the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [2,1,3]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [1,2,3,4,null,5,6,null,null,7]
//Output: 7
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 104]. 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 2697 👎 237


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q513FindBottomLeftTreeValue {
    //2023-01-11 23:07:14
    //Find Bottom Left Tree Value
    //编号：[513]
    public static void main(String[] args) {
        Solution solution = new Q513FindBottomLeftTreeValue().new Solution();
        solution.findBottomLeftValue(TreeNode.build("2,1,3".split(",")));
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
        int maxDepth = Integer.MIN_VALUE;
        int result;

        public int findBottomLeftValueByPreOrderTraverse(TreeNode root) {
            dfs(root, 1);
            return result;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (depth > maxDepth) {
                    maxDepth = depth;
                    result = root.val;
                }
            }
            dfs(root.left, depth + 1);
            dfs(root.right, depth + 1);
        }

        //层序遍历
        public int findBottomLeftValue(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.push(root);
            int result = root.val;
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode t = deque.poll();
                    if (i == 0) {
                        result = t.val;
                    }
                    if (t.left != null) {
                        deque.offer(t.left);
                    }
                    if (t.right != null) {
                        deque.offer(t.right);
                    }
                }
            }
            return result;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
