//Given the root of a binary tree, return the inorder traversal of its nodes' va
//lues. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,null,2,3]
//Output: [1,3,2]
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
// The number of nodes in the tree is in the range [0, 100]. 
// -100 <= Node.val <= 100 
// 
//
// 
//Follow up: Recursive solution is trivial, could you do it iteratively? Related
// Topics Stack Tree Depth-First Search Binary Tree 
// 👍 10484 👎 498


  package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q94BinaryTreeInorderTraversal {
 //2023-01-02 12:01:53
    //Binary Tree Inorder Traversal
    //编号：[94]
      public static void main(String[] args) {
           Solution solution = new Q94BinaryTreeInorderTraversal().new Solution();
          solution.inorderTraversal(TreeNode.build(new String[]{"1", "null", "2", "3"}));
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                //pop
                TreeNode pop = stack.pop();
                ans.add(pop.val);
                p = pop.right;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
