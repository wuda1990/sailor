//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
//输出：[1,2]
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
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 684 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal{
    public static void main(String[]args){
        Solution solution=new BinaryTreePreorderTraversal().new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> ans1 = solution.preorderTraversal(root);
        List<Integer> ans2 = solution.preorderTraversal1(root);
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

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root != null) {
            ans.add(root.val);
            preorderTraversal1(root.left);
            preorderTraversal1(root.right);
        }
        return ans;
    }


    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //将遍历的节点入栈
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            if (t == null) {
                break;
            }
            ans.add(t.val);
            while (t.left != null) {
                ans.add(t.left.val);
                if (t.right != null) {
                    stack.push(t.right);
                }
                t= t.left;
            }
            if (t.right != null) {
                stack.push(t.right);
            }
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}