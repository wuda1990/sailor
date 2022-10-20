//<p><strong>n 皇后问题</strong> 研究的是如何将 <code>n</code> 个皇后放置在 <code>n×n</code> 的棋盘上，并且使皇后彼此之间不能相互攻击。</p>
//
//<p>给你一个整数 <code>n</code> ，返回 <strong>n 皇后问题</strong> 不同的解决方案的数量。</p>
//
//<p> </p>
//
//<div class="original__bRMd">
//<div>
//<p><strong>示例 1：</strong></p>
//<img alt="" src="https://assets.leetcode.com/uploads/2020/11/13/queens.jpg" style="width: 600px; height: 268px;" />
//<pre>
//<strong>输入：</strong>n = 4
//<strong>输出：</strong>2
//<strong>解释：</strong>如上图所示，4 皇后问题存在两个不同的解法。
//</pre>
//
//<p><strong>示例 2：</strong></p>
//
//<pre>
//<strong>输入：</strong>n = 1
//<strong>输出：</strong>1
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
//<div><div>Related Topics</div><div><li>回溯</li></div></div><br><div><li>👍 299</li><li>👎 0</li></div>
  
package com.onepiece.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NQueensIi{
  public static void main(String[] args) {
       Solution solution = new NQueensIi().new Solution();
      System.out.println(solution.totalNQueens(1));
  }
  //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int totalNQueens(int n) {
        Counter counter = new Solution().new Counter();
        List<String> ans = new ArrayList<>();
        backTrack(0,n,ans,counter);
        return counter.getCnt();
    }

    class Counter{
        private int cnt;

        public Counter(){
            cnt = 0;
        }

        public void inc() {
            cnt = cnt + 1;
        }

        public int getCnt(){
            return cnt;
        }

    }

      /**
       * 考虑二维数组优化
       * @param row
       * @param n
       * @param ans
       */
      private void backTrack(int row, int n,List<String> ans, Counter counter) {
          if (row == n) {
              counter.inc();
              return;
          }

          for (int i = 0; i < n; i++) {
              if (overlap(i, ans)) {
                  continue;
              }
              ans.add(generate(i, n));
              backTrack(row + 1, n, ans, counter);
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