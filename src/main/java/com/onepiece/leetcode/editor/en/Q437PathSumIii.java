//Given the root of a binary tree and an integer targetSum, return the number 
//of paths where the sum of the values along the path equals targetSum. 
//
// The path does not need to start or end at the root or a leaf, but it must go 
//downwards (i.e., traveling only from parent nodes to child nodes). 
//
// 
// Example 1: 
// 
// 
//Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//Output: 3
//Explanation: The paths that sum to 8 are shown.
// 
//
// Example 2: 
//
// 
//Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//Output: 3
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the tree is in the range [0, 1000]. 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics Tree Depth-First Search Binary Tree 👍 8647 👎 413


package com.onepiece.leetcode.editor.en;

import com.onepiece.leetcode.editor.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q437PathSumIii{
 //2022-09-29 07:49:30
    //Path Sum III
    //编号：[437]
      public static void main(String[] args) {
           Solution solution = new Q437PathSumIii().new Solution();
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
    public int pathSum(TreeNode root, int targetSum) {
        int count = 0;
        List<Integer> sumList = backTrack(root, targetSum);
        for (Integer sum : sumList) {
            if (sum == targetSum) {
                count++;
            }
        }
        return count;
    }
    private List<Integer> backTrack(TreeNode root, int targetSum) {
        if (root==null) {
            return null;
        }
        List<Integer> sumList = new ArrayList<>();
        sumList.add(root.val);
        List<Integer> leftSumList = backTrack(root.left, targetSum);
        List<Integer> rightSumList = backTrack(root.right, targetSum);
        if (leftSumList != null) {
            for (Integer leftSum : leftSumList) {
                sumList.add(root.val + leftSum);
            }
        }
        if (rightSumList != null) {
            for (Integer rightSum : rightSumList) {
                sumList.add(root.val + rightSum);
            }
        }
        return sumList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
