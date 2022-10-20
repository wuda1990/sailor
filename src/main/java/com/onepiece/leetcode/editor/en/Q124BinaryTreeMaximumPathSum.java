//A path in a binary tree is a sequence of nodes where each pair of adjacent 
//nodes in the sequence has an edge connecting them. A node can only appear in the 
//sequence at most once. Note that the path does not need to pass through the root. 
//
//
// The path sum of a path is the sum of the node's values in the path. 
//
// Given the root of a binary tree, return the maximum path sum of any non-
//empty path. 
//
// 
// Example 1: 
// 
// 
//Input: root = [1,2,3]
//Output: 6
//Explanation: The optimal path is 2 -> 1 -> 3 with a path sum of 2 + 1 + 3 = 6.
//
// 
//
// Example 2: 
// 
// 
//Input: root = [-10,9,20,null,null,15,7]
//Output: 42
//Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 
//= 42.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 3 * 10⁴]. 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 👍 117
//51 👎 591


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q124BinaryTreeMaximumPathSum{
 //2022-10-04 17:17:53
    //Binary Tree Maximum Path Sum
    //编号：[124]
      public static void main(String[] args) {
           Solution solution = new Q124BinaryTreeMaximumPathSum().new Solution();
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
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        goDown(root);
        return maxSum;
    }

    private int goDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 0 imply that do not select left or right
        int left = Math.max(0, goDown(node.left));
        int right = Math.max(0, goDown(node.right));
        /**
         * maxValue is the value which recording whether this current root is the final root,
         * so we use left + right + node.val. But to the upper layer(after return statement),
         * we cannot choose both left and right branches, so we need to select the larger one,
         * so we use max(left, right) + node.val to prune the lower branch.
         */
        maxSum = Math.max(maxSum, left + right + node.val); //dfs
        return Math.max(left, right) + node.val; // return value is used for upper level
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
