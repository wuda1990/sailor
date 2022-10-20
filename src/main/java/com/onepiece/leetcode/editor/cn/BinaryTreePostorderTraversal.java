//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 715 👎 0


package com.onepiece.leetcode.editor.cn;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal{
    public static void main(String[]args){
        Solution solution=new BinaryTreePostorderTraversal().new Solution();
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        solution.postorderTraversal(root);
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

    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode lastVisitNode = null;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            TreeNode t = stack.peek();
            //这里必须等节点的右子节点为空或者已经访问，才能访问当前节点，把它加入答案中
            if (t.right == null || t.right == lastVisitNode) {
                TreeNode node = stack.pop();
                ans.add(node.val);
                lastVisitNode = node;
            }else {//继续遍历右子树
                p = t.right;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}