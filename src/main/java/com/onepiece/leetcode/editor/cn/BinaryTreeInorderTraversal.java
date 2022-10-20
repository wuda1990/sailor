//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1184 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[]args){
        Solution solution=new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(3), null));
        List<Integer> ans = solution.inorderTraversal(root);
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

    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return ans;
        }
        inorderTraversal1(root.left);
        ans.add(root.val);
        inorderTraversal1(root.right);
        return ans;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            if (!stack.isEmpty()) {
                TreeNode t = stack.pop();
                ans.add(t.val);
                p = t.right;
            }
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}