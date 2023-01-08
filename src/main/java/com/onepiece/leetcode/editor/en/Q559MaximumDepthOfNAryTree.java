//Given a n-ary tree, find its maximum depth. 
//
// The maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node. 
//
// Nary-Tree input serialization is represented in their level order traversal, 
//each group of children is separated by the null value (See examples). 
//
// 
// Example 1: 
//
// 
//
// 
//Input: root = [1,null,3,2,4,null,5,6]
//Output: 3
// 
//
// Example 2: 
//
// 
//
// 
//Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null
//,12,null,13,null,null,14]
//Output: 5
// 
//
// 
// Constraints: 
//
// 
// The total number of nodes is in the range [0, 104]. 
// The depth of the n-ary tree is less than or equal to 1000. 
// 
// Related Topics Tree Depth-First Search Breadth-First Search 
// 👍 2350 👎 78


package com.onepiece.leetcode.editor.en;

import java.util.Collections;
import java.util.List;

public class Q559MaximumDepthOfNAryTree {
    //2023-01-08 13:50:07
    //Maximum Depth of N-ary Tree
    //编号：[559]
    public static void main(String[] args) {
        Solution solution = new Q559MaximumDepthOfNAryTree().new Solution();
    }
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public int maxDepth(Node root) {
            if (root == null) {
                return 0;
            }
            int max = 0;
            if (root.children != null && root.children.size() > 0) {
                for (int i = 0; i < root.children.size(); i++) {
                    Node child = root.children.get(i);
                    max = Math.max(max, maxDepth(child));
                }
            }
            return max + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
