//路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不
//一定经过根节点。 
//
// 路径和 是路径中各节点值的总和。 
//
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6 
//
// 示例 2： 
//
// 
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围是 [1, 3 * 104] 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 1323 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

public class BinaryTreeMaximumPathSum{
    public static void main(String[]args){
        Solution solution=new BinaryTreeMaximumPathSum().new Solution();
        TreeNode treeNode = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        solution.maxPathSum(treeNode);
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
    public int maxPathSum(TreeNode root) {
        return maxSum(root)[1];
    }

    // 返回的数组意义：int[0]表示单边最大值，int[1]表示所有情况的最大值（单边或者两个单边+根的值）
    private int[] maxSum(TreeNode p) {
        // check
        if (p == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        // Divide
        int[] left = maxSum(p.left);
        int[] right = maxSum(p.right);
        int singleSum, bothSum;
        // Conquer
        // 求单边最大值
        if (left[0] > right[0]) {
            singleSum = Math.max(left[0] + p.val, 0);
        } else {
            singleSum = Math.max(right[0] + p.val, 0);
        }
        // 求所有情况（两个子树的所有情况、两个单边最大值与根之和）的最大值
        bothSum = Math.max(left[1], right[1]);
        bothSum = Math.max(bothSum, left[0] + right[0] + p.val);
        return new int[]{singleSum, bothSum};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}