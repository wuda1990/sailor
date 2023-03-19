//Given the root of a binary tree, return the preorder traversal of its nodes' 
//values. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,null,2,3]
//Output: [1,2,3]
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
// Follow up: Recursive solution is trivial, could you do it iteratively? 
//
// Related Topics Stack Tree Depth-First Search Binary Tree 👍 5032 👎 140


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Q144BinaryTreePreorderTraversal{
 //2022-09-25 19:34:06
    //Binary Tree Preorder Traversal
    //编号：[144]
      public static void main(String[] args) {
           Solution solution = new Q144BinaryTreePreorderTraversal().new Solution();
          TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
          List<Integer> ans = solution.preorderTraversal(root);
          ans.forEach(System.out::print);
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            ans.add(p.val);
            // right first
            if (p.right != null) {
                stack.push(p.right);
            }
            if (p.left != null) {
                stack.push(p.left);
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
