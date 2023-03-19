//Given the root of a Binary Search Tree (BST), return the minimum absolute diff
//erence between the values of any two different nodes in the tree. 
//
// 
// Example 1: 
//
// 
//Input: root = [4,2,6,1,3]
//Output: 1
// 
//
// Example 2: 
//
// 
//Input: root = [1,0,48,null,null,12,49]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 104]. 
// 0 <= Node.val <= 105 
// 
//
// 
// Note: This question is the same as 783: https://leetcode.com/problems/minimum
//-distance-between-bst-nodes/ 
// Related Topics Tree Depth-First Search Breadth-First Search Binary Search Tre
//e Binary Tree 
// 👍 2583 👎 138


  package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.LinkedList;

public class Q530MinimumAbsoluteDifferenceInBst {
 //2023-01-15 09:53:24
    //Minimum Absolute Difference in BST
    //编号：[530]
      public static void main(String[] args) {
           Solution solution = new Q530MinimumAbsoluteDifferenceInBst().new Solution();
          solution.getMinimumDifference(TreeNode.build(new String[]{"4", "2", "6", "1", "3"}));
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
    public int getMinimumDifference(TreeNode root) {
        //inorder traverse
        int result = Integer.MAX_VALUE;
        TreeNode pre = null, p = root;
        LinkedList<TreeNode> stack = new LinkedList();
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            }else {
                TreeNode cur = stack.pop();
                if (pre != null) {
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                p = cur.right;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
