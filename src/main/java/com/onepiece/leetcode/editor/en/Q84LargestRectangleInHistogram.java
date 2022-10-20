//Given an array of integers heights representing the histogram's bar height whe
//re the width of each bar is 1, return the area of the largest rectangle in the h
//istogram. 
//
// 
// Example 1: 
//
// 
//Input: heights = [2,1,5,6,2,3]
//Output: 10
//Explanation: The above is a histogram where width of each bar is 1.
//The largest rectangle is shown in the red area, which has an area = 10 units.
// 
//
// Example 2: 
//
// 
//Input: heights = [2,4]
//Output: 4
// 
//
// 
// Constraints: 
//
// 
// 1 <= heights.length <= 105 
// 0 <= heights[i] <= 104 
// 
// Related Topics Array Stack Monotonic Stack 
// 👍 12245 👎 169


  package com.onepiece.leetcode.editor.en;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q84LargestRectangleInHistogram{
 //2022-10-08 11:44:33
    //Largest Rectangle in Histogram
    //编号：[84]
      public static void main(String[] args) {
           Solution solution = new Q84LargestRectangleInHistogram().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        //在原来数组的基础上头尾加上0，类似与连表的dummyNode,不用处理特殊情况
        //栈底部始终有一个0
        for (int i = 1; i < heights.length + 1; i++)
            new_heights[i] = heights[i - 1];
        for (int i = 0; i < new_heights.length; i++) {
            //单调递增栈
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                //关键是这个宽度的边界为要入栈的元素-1，到出栈后栈顶元素占据的宽度，高度为当前出栈的元素高度
                //这里宽度的起始边界是stack.peek(),考虑cur!=stack.peek()+1这种情况,如 2，1，2这种情况，
                // 最后栈元素是0,1,遇到0，1需要出栈，4-1-2 or 4-1-0,明显后者覆盖了更多面积
                if (!stack.isEmpty()) {
                    res = Math.max(res, (i - 1 - stack.peek()) * new_heights[cur]);
                }
            }
            //入栈的都是数组的索引
            stack.push(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
