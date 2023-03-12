//Given a positive integer n, generate an n x n matrix filled with elements from
// 1 to n2 in spiral order. 
//
// 
// Example 1: 
//
// 
//Input: n = 3
//Output: [[1,2,3],[8,9,4],[7,6,5]]
// 
//
// Example 2: 
//
// 
//Input: n = 1
//Output: [[1]]
// 
//
// 
// Constraints: 
//
// 
// 1 <= n <= 20 
// 
// Related Topics Array Matrix Simulation 
// 👍 4678 👎 204


package com.onepiece.leetcode.editor.en.array;

public class Q59SpiralMatrixIi {

    public static void main(String[] args) {
        Solution solution = new Q59SpiralMatrixIi().new Solution();
        solution.generateMatrix(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int k = 1;
            int i = 0, j = 0;
            int di = 0;
            int dj = 1;
            while (k <= n * n) {
                res[i][j] = k++;
                if (i + di < 0 || j + dj < 0 || res[(i + di) % n][(j + dj) % n] != 0) {
                    int tmp = di;
                    di = dj;
                    dj = -tmp;
                }
                i = i + di;
                j = j + dj;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}