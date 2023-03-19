//Given the root of a binary tree, return the postorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [3,2,1]
// 
//
// Example 2: 
//
// 
//Input: root = []
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1]
//Output: [1]
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics Stack Tree Depth-First Search Binary Tree 
// 👍 5397 👎 161


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q145BinaryTreePostorderTraversal {
    //2023-01-02 09:00:17
    //Binary Tree Postorder Traversal
    //编号：[145]
    public static void main(String[] args) {
        Solution solution = new Q145BinaryTreePostorderTraversal().new Solution();
        TreeNode root = TreeNode.build(new String[]{"1", "null", "2", "3"});
        List<Integer> ans = solution.postorderTraversal(root);
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

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            // 通过lastVisit标识右子节点是否已经弹出
            TreeNode lastVisit = root;
            while (p != null || !stack.isEmpty()) {
                while (p != null) {
                    stack.push(p);
                    p = p.left;
                }
                if (!stack.isEmpty()) {
                    //查看当前栈顶元素
                    TreeNode peek = stack.peek();
                    //如果其右子树不为且右子树未访问，则遍历右子树
                    if (peek.right!= null && peek.right != lastVisit) {
                        //否则继续遍历右子树
                        p = peek.right;
                    } else {
                        TreeNode pop = stack.pop();
                        result.add(pop.val);
                        // 标记当前这个节点已经弹出过
                        lastVisit = peek;
                    }
                }

            }
            return result;
        }

        /**
         * Brilliant code, I think it's faster than usual iterative solution. Every time it gets in while loop,
         * it can pop one out and push two in if possible.
         * The most smart trick is to add value from last, which saves a Hash Set to record visited nodes.
         */
        public List<Integer> postorderTraversal2(TreeNode root) {
            LinkedList<Integer> result = new LinkedList();
            Stack<TreeNode> stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                TreeNode p = stack.pop();
                result.addFirst(p.val); // reverse
                if (p.left != null) {
                    stack.push(p.left);
                }
                if (p.right != null) {
                    stack.push(p.right);
                }
            }
            return result;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
