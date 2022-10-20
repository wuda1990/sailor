//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 713 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[]args){
        Solution solution=new LowestCommonAncestorOfABinarySearchTree().new Solution();
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), node1), node2);
        solution.lowestCommonAncestor(root, node1, node2);
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min,max;
        if (p.val < q.val) {
            min = p.val;
            max = q.val;
        }else {
            min = q.val;
            max = p.val;
        }
        return dfs(root, min, max);
    }

    TreeNode dfs(TreeNode root, int min, int max) {
        if (min < root.val && max > root.val || root.val == min) {
            return root;
        } else if (max < root.val) {
            return dfs(root.left, min, max);
        } else if (min > root.val) {
            return dfs(root.right, min, max);
        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}