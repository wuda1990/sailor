//Given the root of a binary tree, return its maximum depth. 
//
// A binary tree's maximum depth is the number of nodes along the longest path 
//from the root node down to the farthest leaf node. 
//
// 
// Example 1: 
// 
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 3
// 
//
// Example 2: 
//
// 
//Input: root = [1,null,2]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 10⁴]. 
// -100 <= Node.val <= 100 
// 
//
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 👍 86
//01 👎 138


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q104MaximumDepthOfBinaryTree{
 //2022-10-04 15:10:17
    //Maximum Depth of Binary Tree
    //编号：[104]
      public static void main(String[] args) {
           Solution solution = new Q104MaximumDepthOfBinaryTree().new Solution();
          TreeNode root = TreeNode.build("3,9,20,null,null,15,7".split(","));
          System.out.println(solution.maxDepth(root));
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
    private int max = 0;
    public int maxDepth(TreeNode root) {
//        dfs(root, 0);
//        return max;
        // 返回条件处理
        if (root == null) {
            return 0;
        }
        // divide：分左右子树分别计算
        // conquer：合并左右子树结果，即取二者中的最大值加一
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    // k is the node numbers from root to node parent
    private void dfs(TreeNode node,int k) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            max = Math.max(max, k + 1);
            return;
        }
        dfs(node.left, k + 1);
        dfs(node.right, k + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
