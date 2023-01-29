//You are given the root of a binary tree. We install cameras on the tree nodes 
//where each camera at a node can monitor its parent, itself, and its immediate ch
//ildren. 
//
// Return the minimum number of cameras needed to monitor all nodes of the tree.
// 
//
// 
// Example 1: 
//
// 
//Input: root = [0,0,null,0,0]
//Output: 1
//Explanation: One camera is enough to monitor all nodes if placed as shown.
// 
//
// Example 2: 
//
// 
//Input: root = [0,0,null,0,null,0,null,null,0]
//Output: 2
//Explanation: At least two cameras are needed to monitor all nodes of the tree.
// The above image shows one of the valid configurations of camera placement.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 1000]. 
// Node.val == 0 
// 
// Related Topics Dynamic Programming Tree Depth-First Search Binary Tree 
// 👍 4660 👎 62


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

public class Q968BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new Q968BinaryTreeCameras().new Solution();
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
        /**
         * camera status
         * 0: the node has not been covered
         * 1: the node has a camera
         * 2: the node has been covered
         **/

        int result = 0;
        public int minCameraCover(TreeNode root) {
            return dfs(root) > 0 ? result : result + 1;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 2;
            }
            int L = dfs(root.left);
            int R = dfs(root.right);
            if (L == 2 && R == 2) {
                return 0;
            }
            if (L == 0 || R == 0) {
                result++;
                return 1;
            }
            return 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}