//Given two integer arrays preorder and inorder where preorder is the preorder t
//raversal of a binary tree and inorder is the inorder traversal of the same tree,
// construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder and inorder consist of unique values. 
// Each value of inorder also appears in preorder. 
// preorder is guaranteed to be the preorder traversal of the tree. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 11883 👎 345


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    //2023-01-14 16:10:50
    //Construct Binary Tree from Preorder and Inorder Traversal
    //编号：[105]
    public static void main(String[] args) {
        Solution solution = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        Map<Integer, Integer> hm = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                hm.put(inorder[i], i);
            }
            return createTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }


        private TreeNode createTree(int[] preorder, int plow, int phigh, int[] inorder, int ilow, int ihigh) {
            if (ilow > ihigh || plow > phigh) {
                return null;
            }
            int rootVal = preorder[plow];
            int sliceIndex = hm.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left = createTree(preorder, plow + 1, plow + sliceIndex - ilow, inorder, ilow, sliceIndex - 1);
            root.right = createTree(preorder, plow + sliceIndex - ilow + 1, phigh, inorder, sliceIndex + 1, ihigh);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
