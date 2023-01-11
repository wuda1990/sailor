//Given the root of a binary tree, return the sum of all left leaves. 
//
// A leaf is a node with no children. A left leaf is a leaf that is the left chi
//ld of another node. 
//
// 
// Example 1: 
//
// 
//Input: root = [3,9,20,null,null,15,7]
//Output: 24
//Explanation: There are two left leaves in the binary tree, with values 9 and 1
//5 respectively.
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// -1000 <= Node.val <= 1000 
// 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Tree 
// 👍 4176 👎 267


  package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q404SumOfLeftLeaves{
 //2023-01-11 22:14:59
    //Sum of Left Leaves
    //编号：[404]
      public static void main(String[] args) {
           Solution solution = new Q404SumOfLeftLeaves().new Solution();
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && isLeaf(root.left)) {
            sum += root.left.val;
        }else {
            sum += sumOfLeftLeaves(root.left);
        }
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
