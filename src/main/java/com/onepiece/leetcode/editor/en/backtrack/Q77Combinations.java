//Given two integers n and k, return all possible combinations of k numbers chos
//en from the range [1, n]. 
//
// You may return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to 
//be the same combination.
// 
//
// Example 2: 
//
// 
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics Backtracking 
// 👍 5554 👎 176


package com.onepiece.leetcode.editor.en.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q77Combinations {

    //2023-01-15 21:45:21
    //Combinations
    //编号：[77]
    public static void main(String[] args) {
        Solution solution = new Q77Combinations().new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> combine(int n, int k) {
            LinkedList<Integer> list = new LinkedList<>();
            List<List<Integer>> result = new ArrayList<>();
            backTrack(n, k, 1, list, result);
            return result;
        }

        /**
         * 已经选择的元素个数：path.size();
         * <p>
         * 所需需要的元素个数为: k - path.size();
         * <p>
         * 列表中剩余元素n-i >= 所需需要的元素个数（k - path.size()）
         * <p>
         * 在集合n中至多要从该起始位置 : i <= n - (k - path.size()) + 1，开始遍历
         *
         * @param n
         * @param k
         * @param start
         * @param list
         * @param result
         */
        private void backTrack(int n, int k, int start, LinkedList<Integer> list, List<List<Integer>> result) {
            if (list.size() == k) {
                List tmp = new ArrayList(list);
                result.add(tmp);
                return;
            }
            for (int i = start; i <= n - (k - list.size()) + 1; i++) {
                list.offer(i);
                backTrack(n, k, i + 1, list, result);
                list.pollLast();
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}
