//You are given a 0-indexed array of integers nums of length n. You are 
//initially positioned at nums[0]. 
//
// Each element nums[i] represents the maximum length of a forward jump from 
//index i. In other words, if you are at nums[i], you can jump to any nums[i + j] 
//where: 
//
// 
// 1 <= j <= nums[i] and 
// i + j < n 
// 
//
// Return the minimum number of jumps to reach nums[n - 1]. The test cases are 
//generated such that you can reach nums[n - 1]. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,1,1,4]
//Output: 2
//Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 
//step from index 0 to 1, then 3 steps to the last index.
// 
//
// Example 2: 
//
// 
//Input: nums = [2,3,0,1,4]
//Output: 2
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 
//
// Related Topics Array Dynamic Programming Greedy 👍 9714 👎 345


package com.onepiece.leetcode.editor.en;
  public class Q45JumpGameIi{
 //2022-10-03 15:47:54
    //Jump Game II
    //编号：[45]
      public static void main(String[] args) {
           Solution solution = new Q45JumpGameIi().new Solution();
          System.out.println(solution.jump2(new int[]{2, 3, 1, 1, 4}));
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int steps = 0;
        int start = 0;
        int end = 1;// Todo why end initial with 1
        //
        while (end < nums.length) {
            // 确定最远的跳跃范围
            int maxPosition = 0;
            for (int i = start; i < end; i++) {
                maxPosition = Math.max(maxPosition, i + nums[i]);
            }
            start = end;
            end = maxPosition + 1;
            // 步数增加
            steps++;
        }
        return steps;
    }

          //The main idea is based on greedy.
          // Let's say the range of the current jump is [curBegin, curEnd],
          // curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
          // Once the current point reaches curEnd, then trigger another jump,
          // and set the new curEnd with curFarthest, then keep the above steps, as the following:

          /**
           * This is an implicit bfs solution.
           * i == curEnd means you visited all the items on the current level.
           * Incrementing jumps++ is like incrementing the level you are on.
           * And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
           * @param A
           * @return
           */
          public int jump2(int[] A) {
              int jumps = 0, curEnd = 0, curFarthest = 0;
              for (int i = 0; i < A.length - 1; i++) {
                  curFarthest = Math.max(curFarthest, i + A[i]);
                  if (i == curEnd) {
                      jumps++;
                      curEnd = curFarthest;
                  }
              }
              return jumps;
          }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
