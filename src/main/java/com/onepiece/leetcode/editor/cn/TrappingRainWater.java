//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 1 <= n <= 2 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2860 👎 0


package com.onepiece.leetcode.editor.cn;

import java.util.Stack;

public class TrappingRainWater{
    public static void main(String[]args) {
        Solution solution = new TrappingRainWater().new Solution();
        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int ans = 0;
        //单调递减栈
        Stack<Integer> stack = new Stack<>();
        //站存入的元素是数组下标
        for (int i = 0; i < height.length; i++) {
            //当栈顶元素小于当前元素的时候，就可以计算接雨水的面积了
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int cur = stack.peek();
                stack.pop();
                if (!stack.isEmpty()) {
                    int l = stack.peek();
                    int r = i;
                    int h = Math.min(height[l], height[r]) - height[cur];
                    ans += h * (r - l - 1);
                }

            }
            //这里将每个数组的索引入栈
            stack.push(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}