//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=105 
// 0 <= heights[i] <= 104 
// 
// Related Topics 栈 数组 单调栈 
// 👍 1627 👎 0


package com.onepiece.leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LargestRectangleInHistogram{
    public static void main(String[]args){
        Solution solution=new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea2(new int[]{2,1,2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                //计算最大矩形的面积
                //搞半天原来是边界的细节问题，但是按每个柱子去找左右两边比他小的边界，这个核心思路没搞懂是不行的
                int cur = stack.pop();
                int left = stack.isEmpty() ? - 1 : stack.peek();
                int r = i;
                int area = heights[cur] * (r - left - 1);
                ans = Math.max(ans, area);
            }
            stack.push(i);
        }
        //当栈里面所有元素都是递增的，再进行计算
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            int left = stack.isEmpty() ? -1 : stack.peek();
            int r = heights.length;
            int area = heights[cur] * (r - left - 1);
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public int largestRectangleArea2(int[] heights) {
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
                int peek = stack.isEmpty() ? -1 : stack.peek();
                res = Math.max(res, (i - 1 - peek) * new_heights[cur]);
            }
            //入栈的都是数组的索引
            stack.push(i);
        }
        return res;
    }
    /**
     * use dp solution to calculate lessFromLeft and lessFromRight
     */

    public  int largestRectangleArea3(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
        int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
        lessFromRight[height.length - 1] = height.length;
        lessFromLeft[0] = -1;

        for (int i = 1; i < height.length; i++) {
            int p = i - 1;

            while (p >= 0 && height[p] >= height[i]) {
                p = lessFromLeft[p];
            }
            lessFromLeft[i] = p;
        }

        for (int i = height.length - 2; i >= 0; i--) {
            int p = i + 1;

            while (p < height.length && height[p] >= height[i]) {
                p = lessFromRight[p];
            }
            lessFromRight[i] = p;
        }

        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
        }

        return maxArea;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}