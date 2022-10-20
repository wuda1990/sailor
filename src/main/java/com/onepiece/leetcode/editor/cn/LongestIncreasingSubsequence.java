//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。 
//
// 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子
//序列。 
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,9,2,5,3,7,101,18]
//输出：4
//解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,3,2,3]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,7,7,7,7,7,7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2500 
// -104 <= nums[i] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你能将算法的时间复杂度降低到 O(n log(n)) 吗? 
// 
// Related Topics 数组 二分查找 动态规划 
// 👍 2359 👎 0


package com.onepiece.leetcode.editor.cn;

public class LongestIncreasingSubsequence{
    public static void main(String[]args){
        Solution solution=new LongestIncreasingSubsequence().new Solution();
//        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = new int[]{3,5,6,2,5,4,19,5,6,7,12};
        System.out.println(solution.lengthOfLIS(nums));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS0(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxLen = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //新建一个数组保存最长子序列每个位置最小的元素
    public int lengthOfLIS(int[] nums) {
        int[] tail = new int[nums.length];
        tail[0] = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > tail[index]) {
                index++;
                tail[index] = nums[i];
            } else {
                int l = 0;
                int h = index;
                while (l + 1 < h) {
                    int mid = (l + h) / 2;
                    if (tail[mid] < nums[i]) {
                        l = mid;
                    } else{
                        h = mid;
                    }
                }
                // l = h-1
                if (nums[i] <= tail[l]) {
                    tail[l] = nums[i];
                } else {
                    tail[h] = nums[i];
                }

            }
        }
        return index + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}