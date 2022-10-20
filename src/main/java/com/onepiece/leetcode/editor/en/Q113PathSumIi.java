//Given the root of a binary tree and an integer targetSum, return all root-to-
//leaf paths where the sum of the node values in the path equals targetSum. Each 
//path should be returned as a list of the node values, not node references. 
//
// A root-to-leaf path is a path starting from the root and ending at any leaf 
//node. A leaf is a node with no children. 
//
// 
// Example 1: 
// 
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: [[5,4,11,2],[5,8,4,5]]
//Explanation: There are two paths whose sum equals targetSum:
//5 + 4 + 11 + 2 = 22
//5 + 8 + 4 + 5 = 22
// 
//
// Example 2: 
// 
// 
//Input: root = [1,2,3], targetSum = 5
//Output: []
// 
//
// Example 3: 
//
// 
//Input: root = [1,2], targetSum = 0
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 5000]. 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics Backtracking Tree Depth-First Search Binary Tree 👍 6251 👎 13
//2


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q113PathSumIi{
 //2022-09-28 21:13:46
    //Path Sum II
    //编号：[113]
      public static void main(String[] args) {
           Solution solution = new Q113PathSumIi().new Solution();
          TreeNode treeNode = new TreeNode(1, new TreeNode(2), null);
          solution.pathSum(treeNode, 1);
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(root, 0, targetSum, new Stack<>(), ans);
        return ans;
    }

    private void backTrack(TreeNode root, int sum, int targetSum, Stack<Integer> stack, List<List<Integer>> ans) {
        if (root==null) {
            return;
        }
        int currentSum = root.val + sum;
        stack.push(root.val);
        //only leaf node
        if (currentSum == targetSum && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(stack));
            stack.pop();
            return;
        }

        backTrack(root.left, currentSum, targetSum, stack, ans);
        backTrack(root.right, currentSum, targetSum, stack, ans);
        stack.pop();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

  }
