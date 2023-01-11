//Given the root of a binary tree, return all root-to-leaf paths in any order. 
//
// A leaf is a node with no children. 
//
// 
// Example 1: 
//
// 
//Input: root = [1,2,3,null,5]
//Output: ["1->2->5","1->3"]
// 
//
// Example 2: 
//
// 
//Input: root = [1]
//Output: ["1"]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [1, 100]. 
// -100 <= Node.val <= 100 
// 
// Related Topics String Backtracking Tree Depth-First Search Binary Tree 
// 👍 5319 👎 226


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q257BinaryTreePaths {
    //2023-01-11 21:17:02
    //Binary Tree Paths
    //编号：[257]
    public static void main(String[] args) {
        Solution solution = new Q257BinaryTreePaths().new Solution();
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
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            dfs(root, "", result);
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

