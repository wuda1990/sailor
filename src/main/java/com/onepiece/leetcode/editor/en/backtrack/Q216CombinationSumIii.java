//Find all valid combinations of k numbers that sum up to n such that the follow
//ing conditions are true: 
//
// 
// Only numbers 1 through 9 are used. 
// Each number is used at most once. 
// 
//
// Return a list of all possible valid combinations. The list must not contain t
//he same combination twice, and the combinations may be returned in any order. 
//
// 
// Example 1: 
//
// 
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations. 
//
// Example 2: 
//
// 
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
// 
//
// Example 3: 
//
// 
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1
//+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
// 
// Constraints: 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 60 
// 
// Related Topics Array Backtracking 
// 👍 4615 👎 93


  package com.onepiece.leetcode.editor.en.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q216CombinationSumIii {
 //2023-01-18 23:34:24
    //Combination Sum III
    //编号：[216]
      public static void main(String[] args) {
           Solution solution = new Q216CombinationSumIii().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<List<Integer>> combinationSum3(int k, int n) {
              List<List<Integer>> ans = new ArrayList<>();
              LinkedList<Integer> list = new LinkedList<>();
              backTrack(1, n, k, list, ans);
              return ans;
          }

          private void backTrack(int pos, int target, int k, LinkedList<Integer> list, List<List<Integer>> ans) {
              if (target == 0 && list.size() == k) {
                  ans.add(new ArrayList<>(list));
              }
              for (int i = pos; i <= 9 - (k - list.size()) + 1; i++) {
                  if (i > target) {
                      break;
                  }
                  list.offer(i);
                  backTrack(i + 1, target - i, k, list, ans);
                  list.pollLast();
              }
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }
