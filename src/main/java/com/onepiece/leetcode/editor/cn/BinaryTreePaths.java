//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
// Related Topics 树 深度优先搜索 字符串 二叉树 
// 👍 610 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths{
    public static void main(String[]args){
        Solution solution=new BinaryTreePaths().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3, null, null));
        solution.binaryTreePaths(root);
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root,"",result);
        return result;
    }

    void dfs(TreeNode root, String str, List<String> result) {
        if (root == null) {
            return;
        }
        String cur = str + root.val;
        if (root.left == null && root.right == null) {
            result.add(cur);
        } else {
            //Todo 这里java方法参数是值copy,所以参数是copy cur的值，不会影响在当前方法里cur的值
            dfs(root.left, cur + "->", result);
            dfs(root.right, cur + "->", result);
        }


    }


}
//leetcode submit region end(Prohibit modification and deletion)

}