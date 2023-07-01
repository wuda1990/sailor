//You are given an array of binary strings strs and two integers m and n. 
//
// Return the size of the largest subset of strs such that there are at most m 0
//'s and n 1's in the subset. 
//
// A set x is a subset of a set y if all elements of x are also elements of y. 
//
// 
// Example 1: 
//
// 
//Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
//Output: 4
//Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001",
// "1", "0"}, so the answer is 4.
//Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
//{"111001"} is an invalid subset because it contains 4 1's, greater than the 
//maximum of 3.
// 
//
// Example 2: 
//
// 
//Input: strs = ["10","0","1"], m = 1, n = 1
//Output: 2
//Explanation: The largest subset is {"0", "1"}, so the answer is 2.
// 
//
// 
// Constraints: 
//
// 
// 1 <= strs.length <= 600 
// 1 <= strs[i].length <= 100 
// strs[i] consists only of digits '0' and '1'. 
// 1 <= m, n <= 100 
// 
//
// Related Topics Array String Dynamic Programming 👍 4731 👎 420


package com.onepiece.leetcode.editor.en.dp;

public class Q474OnesAndZeroes {
    //2023-03-25 19:00:29
    //Ones and Zeroes
    //编号：[474]
    public static void main(String[] args) {
        Solution solution = new Q474OnesAndZeroes().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] dp = new int[m + 1][n + 1];
            for (String str : strs) {
                int zeroNum = 0;
                int oneNum = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == '0') {
                        zeroNum++;
                    } else {
                        oneNum++;
                    }
                }
                //倒序遍历容量
                for (int i = m; i >= zeroNum; i--) {
                    for (int j = n; j >= oneNum; j--) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                        System.out.println("i:" + i + ",j" + j + "=" + dp[i][j]);
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
