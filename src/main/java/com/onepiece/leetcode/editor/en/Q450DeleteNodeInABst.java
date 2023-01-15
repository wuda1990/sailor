//Given a root node reference of a BST and a key, delete the node with the given
// key in the BST. Return the root node reference (possibly updated) of the BST. 
//
// Basically, the deletion can be divided into two stages: 
//
// 
// Search for a node to remove. 
// If the node is found, delete the node. 
// 
//
// 
// Example 1: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 3
//Output: [5,4,6,2,null,null,7]
//Explanation: Given key to delete is 3. So we find the node with value 3 and de
//lete it.
//One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
//Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also
// accepted.
//
// 
//
// Example 2: 
//
// 
//Input: root = [5,3,6,2,4,null,7], key = 0
//Output: [5,3,6,2,4,null,7]
//Explanation: The tree does not contain a node with value = 0.
// 
//
// Example 3: 
//
// 
//Input: root = [], key = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// Each node has a unique value. 
// root is a valid binary search tree. 
// -105 <= key <= 105 
// 
//
// 
// Follow up: Could you solve it with time complexity O(height of tree)? 
// Related Topics Tree Binary Search Tree Binary Tree 
// 👍 6815 👎 173


  package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q450DeleteNodeInABst{
 //2023-01-15 16:51:58
    //Delete Node in a BST
    //编号：[450]
      public static void main(String[] args) {
           Solution solution = new Q450DeleteNodeInABst().new Solution();
          TreeNode treeNode = solution.deleteNode(TreeNode.build(new String[]{"50", "30", "70", "null", "40", "60", "80"}), 50);
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

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode p = root.right;
            while (p.left != null) {
                p = p.left;
            }
            // p is the minValue in right subTree
            //把根节点的值改成最小值，并删除掉右子树里的最小值
//            root.val = p.val;
//            root.right = deleteNode(root.right, p.val);
            //以右节点当作根节点，这样树的高度更大
            p.left = root.left;
            return root.right;

        }

        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
