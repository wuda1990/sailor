//<p><strong>n 皇后问题</strong> 研究的是如何将 <code>n</code> 个皇后放置在 <code>n×n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
//
//<p>给你一个整数 <code>n</code> ，返回所有不同的 <strong>n<em> </em>皇后问题</strong> 的解决方案。</p>
//
//<div class="original__bRMd">
//<div>
//<p>每一种解法包含一个不同的 <strong>n 皇后问题</strong> 的棋子放置方案，该方案中 <code>'Q'</code> 和 <code>'.'</code> 分别代表了皇后和空位。</p>
//
//<p> </p>
//
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
//<pre>
//<strong>输入：</strong>n = 4
//<strong>输出：</strong>[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>[["Q"]]
//</pre>
//
//<p> </p>
//
//<p><strong>提示：</strong></p>
//
//<ul>
//	<li><code>1 <= n <= 9</code></li>
//	<li>皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。</li>
//</ul>
//</div>
//</div>
//<div><div>Related Topics</div><div><li>数组</li><li>回溯</li></div></div><br><div><li>👍 1040</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueens{
  public static void main(String[] args) {
       Solution solution = new NQueens().new Solution();
      solution.solveNQueens(5);
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backTrack(0, n, ans, result);
        return result;
    }

      /**
       * 考虑二维数组优化
       * @param row
       * @param n
       * @param ans
       * @param result
       */
      private void backTrack(int row, int n, List<String> ans, List<List<String>> result) {
          if (row == n) {
              result.add(new ArrayList<>(ans));
              return;
          }

          for (int i = 0; i < n; i++) {
              if (overlap(i, ans)) {
                  continue;
              }
              ans.add(generate(i, n));
              backTrack(row + 1, n, ans, result);
              ans.remove(ans.size() - 1);
          }

      }

      private boolean overlap(int index, List<String> ans) {
          if (ans.size() == 0) {
              return false;
          }
          int lastRow = ans.size();
          for (int i = ans.size() - 1; i >= 0; i--) {
              String template = ans.get(i);
              int pos = template.indexOf('Q');
              if (index == pos) {
                  return true;
              }
              //判断是否在一条斜线上,斜率为1
              int colDiff = index - pos;
              int rowDiff = lastRow - i;
              if (colDiff == rowDiff || colDiff == -rowDiff) {
                  return true;
              }
          }
          return false;
      }

      private String generate(int j, int n) {
          char[] arr = new char[n];
          for (int i = 0; i < n; i++) {
              arr[i] = '.';
          }
          arr[j] = 'Q';
          return new String(arr);
      }
  }
//leetcode submit region end(Prohibit modification and deletion)

}