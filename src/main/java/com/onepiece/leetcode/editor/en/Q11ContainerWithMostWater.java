//You are given an integer array height of length n. There are n vertical lines 
//drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// 
//
// Find two lines that together with the x-axis form a container, such that the 
//container contains the most water. 
//
// Return the maximum amount of water a container can store. 
//
// Notice that you may not slant the container. 
//
// 
// Example 1: 
//
// 
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,
//3,7]. In this case, the max area of water (blue section) the container can conta
//in is 49.
// 
//
// Example 2: 
//
// 
//Input: height = [1,1]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// n == height.length 
// 2 <= n <= 105 
// 0 <= height[i] <= 104 
// 
// Related Topics Array Two Pointers Greedy 
// 👍 22784 👎 1215


  package com.onepiece.leetcode.editor.en;

import java.util.Collections;

public class Q11ContainerWithMostWater{
 //2023-02-18 20:58:33
    //Container With Most Water
    //编号：[11]
      public static void main(String[] args) {
           Solution solution = new Q11ContainerWithMostWater().new Solution();
          int maxArea = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
          System.out.println(maxArea);
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            int distance = right - left;
            if (height[left] < height[right]) {
                result = Math.max(result, height[left] * distance);
                left++;
            }else {
                result = Math.max(result, height[right] * distance);
                right--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
