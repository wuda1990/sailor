//Given a binary search tree (BST), find the lowest common ancestor (LCA) node o
//f two given nodes in the BST. 
//
// According to the definition of LCA on Wikipedia: “The lowest common ancestor 
//is defined between two nodes p and q as the lowest node in T that has both p and
// q as descendants (where we allow a node to be a descendant of itself).” 
//
// 
// Example 1: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//Output: 6
//Explanation: The LCA of nodes 2 and 8 is 6.
// 
//
// Example 2: 
//
// 
//Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//Output: 2
//Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant o
//f itself according to the LCA definition.
// 
//
// Example 3: 
//
// 
//Input: root = [2,1], p = 2, q = 1
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [2, 105]. 
// -109 <= Node.val <= 109 
// All Node.val are unique. 
// p != q 
// p and q will exist in the BST. 
// 
// Related Topics Tree Depth-First Search Binary Search Tree Binary Tree 
// 👍 8648 👎 244


  package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q235LowestCommonAncestorOfABinarySearchTree{
 //2023-01-15 12:38:19
    //Lowest Common Ancestor of a Binary Search Tree
    //编号：[235]
      public static void main(String[] args) {
           Solution solution = new Q235LowestCommonAncestorOfABinarySearchTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestorPostOrder(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        return dfs(root, min, max);
    }

    TreeNode dfs(TreeNode root, int min, int max) {
        if (max < root.val) {
            return dfs(root.left, min, max);
        } else if (min > root.val) {
            return dfs(root.right, min, max);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t = root;
        while (t != null) {
            if (t.val > p.val && t.val > q.val) {
                t = t.left;
            } else if (t.val < p.val && t.val < q.val) {
                t = t.right;
            }else {
                return t;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
