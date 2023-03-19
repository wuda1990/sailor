//Given two integer arrays inorder and postorder where inorder is the inorder tr
//aversal of a binary tree and postorder is the postorder traversal of the same tr
//ee, construct and return the binary tree. 
//
// 
// Example 1: 
//
// 
//Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//Output: [3,9,20,null,null,15,7]
// 
//
// Example 2: 
//
// 
//Input: inorder = [-1], postorder = [-1]
//Output: [-1]
// 
//
// 
// Constraints: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder and postorder consist of unique values. 
// Each value of postorder also appears in inorder. 
// inorder is guaranteed to be the inorder traversal of the tree. 
// postorder is guaranteed to be the postorder traversal of the tree. 
// 
// Related Topics Array Hash Table Divide and Conquer Tree Binary Tree 
// 👍 5646 👎 84


package com.onepiece.leetcode.editor.en.tree;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {
    //2023-01-14 15:28:25
    //Construct Binary Tree from Inorder and Postorder Traversal
    //编号：[106]
    public static void main(String[] args) {
        Solution solution = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
        solution.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
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
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                hm.put(inorder[i], i);
            }
            return createTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }


        private TreeNode createTree(int[] inorder, int ilow, int ihigh, int[] postorder,int plow, int phigh) {
            if (ilow > ihigh || plow > phigh) {
                return null;
            }
            int rootVal = postorder[phigh];
            int sliceIndex = hm.get(rootVal);
            TreeNode root = new TreeNode(rootVal);
            root.left = createTree(inorder, ilow, sliceIndex - 1, postorder, plow, plow + sliceIndex - ilow - 1);
            root.right = createTree(inorder, sliceIndex + 1, ihigh, postorder, plow + sliceIndex - ilow, phigh - 1);
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
