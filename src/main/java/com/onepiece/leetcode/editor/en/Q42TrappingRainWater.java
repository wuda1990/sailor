//Given n non-negative integers representing an elevation map where the width of
// each bar is 1, compute how much water it can trap after raining. 
//
// 
// Example 1: 
//
// 
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [
//0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are
// being trapped.
// 
//
// Example 2: 
//
// 
//Input: height = [4,2,0,3,2,5]
//Output: 9
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics Array Two Pointers Dynamic Programming Stack Monotonic Stack 
// 👍 23203 👎 320


  package com.onepiece.leetcode.editor.en;
  public class Q42TrappingRainWater {
      //2022-10-08 13:07:00
      //Trapping Rain Water
      //编号：[42]
      public static void main(String[] args) {
          Solution solution = new Q42TrappingRainWater().new Solution();
      }

      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          /**]
           * The idea is: I calculated the stored water at each index a and b in my code.
           * At the start of every loop, I update the current maximum height from left side (that is from A[0,1...a])
           * and the maximum height from right side(from A[b,b+1...n-1]). if(leftmax<rightmax) then,
           * at least (leftmax-A[a]) water can definitely be stored no matter what happens between [a,b]
           * since we know there is a barrier at the rightside(rightmax>leftmax). On the other side,
           * we cannot store more water than (leftmax-A[a]) at index a since the barrier at left is of height leftmax.
           * So, we know the water that can be stored at index a is exactly (leftmax-A[a]). The same logic applies
           * to the case when (leftmax>rightmax). At each loop we can make a and b one step closer. Thus we can finish
           * it in linear time.
           * @param height
           * @return
           */
          public int trap(int[] height) {
              if (height == null || height.length == 0) {
                  return 0;
              }

              int result = 0;
              // leftMax represents the highest bar from left
              int leftMax = Integer.MIN_VALUE;
              // rightMax represents the highest bar from right
              int rightMax = Integer.MIN_VALUE;

              // use two pointers to scan the entire array until they meet with each other
              // Key points: any bars in the middle of leftMax bar and rightMax bar will not influence
              // how much water can current position trap
              for (int left = 0, right = height.length - 1; left <= right; ) {
                  leftMax = Math.max(leftMax, height[left]);
                  rightMax = Math.max(rightMax, height[right]);

                  //how much can current position trap depends on the shorter bar (木桶原理)
                  if (leftMax < rightMax) {
                      //DO NOT FORGET to subtract bar height of current position
                      result += leftMax - height[left];
                      left++;
                  } else {
                      result += rightMax - height[right];
                      right--;
                  }
              }
              return result;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)
  }
